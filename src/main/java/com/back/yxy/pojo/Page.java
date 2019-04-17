package com.back.yxy.pojo;

public class Page {
    int pageCount;//一共多少页
    int currentPage;//当前第几页
    int pageSize;//一页多少行
    int startPage;//从第几行开始
    int totalCount;//总共有多少行数据

    public int getPageCount() {
        this.pageCount = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
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

    public int getStartPage() {
        this.startPage = (currentPage-1)*pageSize;
        return startPage;
    }

    public void setStartPage(int start) {
        this.startPage = start;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageCount=" + pageCount +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", startPage=" + startPage +
                ", totalCount=" + totalCount +
                '}';
    }
}
