package com.back.rsx.tools;

/**
 * Created by DELL on 2019/3/29.
 */
public class SplitePageBean {
    int pageCount;//一共多少页
    int currentPage = 1;//当前第几页
    int pageSize = 10;//一页多少行 默认10行
    int start;//从第几行开始
    int dataCount;//总共有多少行数据

    public int getStart() {
        this.start = (currentPage-1)*pageSize;
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }


    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.pageCount= dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
        this.dataCount = dataCount;
    }

    @Override
    public String toString() {
        return "SplitePageBean{" +
                "pageCount=" + pageCount +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", start=" + start +
                ", dataCount=" + dataCount +
                '}';
    }
}
