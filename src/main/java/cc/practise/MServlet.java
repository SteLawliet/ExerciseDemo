package cc.practise;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.sky.Domain.FileBean;
import cc.sky.dao.DaoFile;

/**
 * Created by Stelawliet on 17/12/16.
 */
public class MServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");

        String methodName = request.getParameter("method");


        try {

            if (methodName == null) {
                throw new NoSuchMethodException();
            }

            Method method = MServlet.class.getMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);
            String re = (String) method.invoke(this, request, response);

            if (re == null) {
                return;
            }
            String[] res = re.split(":");

            if (res[0].equals("f")) {
                request.getRequestDispatcher(res[1]).forward(request, response);
            }

        } catch (NoSuchMethodException e) {

            throw new RuntimeException("the method is null");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public String Upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String temp = getServletContext().getRealPath("/temp");
        File file1 = new File(temp);
        if (!file1.exists()) {
            file1.mkdirs();
        }

        String upload = getServletContext().getRealPath("/upload");
        File file0 = new File(upload);
        if (!file0.exists()) {
            file0.mkdirs();
        }
        System.out.println(temp);
        System.out.println(upload);

        DiskFileItemFactory factory =
                new DiskFileItemFactory(1024 * 10, new File(temp));
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

        fileUpload.setHeaderEncoding("UTF-8");

        List<FileItem> fileItems = null;
        List<FileBean> filelist = new ArrayList<FileBean>();
        try {
            fileItems = fileUpload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        if (fileItems != null) {
            for (FileItem fileItem : fileItems) {

                if (fileItem.isFormField()) {
                    System.out.println(fileItem.getFieldName());
                    System.out.println(fileItem.getString("UTF-8"));
                    continue;
                }

                InputStream in = fileItem.getInputStream();

                File file = new File(upload + "/" + fileItem.getName());

                if (!file.exists()) {
                    file.createNewFile();
                }


                MyUtils.InToOut(in, new FileOutputStream(file));

                String size = String.valueOf(fileItem.getSize());

                FileBean fileBean = MyUtils.FileItemToBean(fileItem);

                fileBean.setPath(file.getAbsolutePath());

                filelist.add(fileBean);

                fileItem.delete();

            }
        }
        DaoFile daoFile = new DaoFile();
        daoFile.addFile(filelist);

        request.setAttribute("filelist", daoFile.FindAll());

        return "f:/jsp/upload.jsp";


    }

    public String Download(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String upload = getServletContext().getRealPath("/upload");
        File file0 = new File(upload);
        if (!file0.exists()) {
            file0.mkdirs();
        }

        String downFile = request.getParameter("filename");

        File file = new File(upload + "/" + downFile);

        if (!file.exists()) {
            file.createNewFile();
        }
//        downFile = new String(downFile.getBytes(ISO8859-1));
//        String filename = new String("中文文件名.xls".getBytes(), "ISO8859-1");
        response.setContentType("application/octet-stream");
        response.setHeader("content-disposition",
                "attachment;filename=" +
                        new String(downFile.getBytes("utf-8"),
                                "ISO-8859-1"));

        DaoFile daoFile = new DaoFile();
        FileBean fileBean = daoFile.FindFileByName(downFile);

        InputStream in = FileUtils.openInputStream(new File(fileBean.getPath()));
        MyUtils.InToOut(in, response.getOutputStream());

        return null;
    }


    /**
     * @param request  TESIID
     * @param response D D
     * @return DDD
     * @throws IOException DDD
     */

    public String Upload0(HttpServletRequest request, HttpServletResponse response) {

        DaoFile daoFile = new DaoFile();
        request.setAttribute("filelist", daoFile.FindAll());
        return "f:/jsp/upload.jsp";

    }


}
