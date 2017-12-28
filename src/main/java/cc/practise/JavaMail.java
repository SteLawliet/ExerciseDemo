package cc.practise;

import com.github.flyinghe.tools.Email;
import com.github.flyinghe.tools.MailUtils;
import com.sun.mail.util.MailSSLSocketFactory;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import static MyMailUtil.MyMail.SendMail;
import static MyMailUtil.MyMail.getEmailSession;


/**
 * Created by Stelawliet on 17/12/24.
 * 572237582 vfhvedmeixzsbbbd
 */
public class JavaMail {
    @Test
    @Ignore
    public void fun1() throws Exception {
        Session s = MailUtils.getSession("smtp.qq.com", "l.loneove", "ZzqZzq52");
        Email mail = new Email("572237582@qq.com", "test", "233333", "text/html;charset=utf-8");
        MailUtils.sendEmail(s, mail);
    }

    @Test
    @Ignore
    public void mail() {

        final String username = "572237582@qq.com";
        final String password = "vfhvedmeixzsbbbd";

        Session session = getEmailSession(username, password);


        String sendTo = "1909282497@qq.com";
        String sendFrom = "572237582@qq.com";
        String subject = "test java mail";
        String content = "<h1>233333<h1><br>" +
                "<h2>2333saasa2</h2>";

        String file = "/Volumes/Data/DATA/软件安装包 dmg/三大框架.rar";


        SendMail(session, sendFrom, sendTo, subject, content, file);
    }


}
