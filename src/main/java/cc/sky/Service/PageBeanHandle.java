package cc.sky.Service;

import cc.sky.Domain.PageBean;

/**
 * Created by Stelawliet on 17/11/16.
 */
public class PageBeanHandle {
    private PageBean pageBean;

    public PageBeanHandle(int currentPage, int size, int count) {
        this.pageBean.setPageSize(size);
        this.pageBean.setTotalCount(count);
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }


}
