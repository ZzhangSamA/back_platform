package com.back.tools;

/**
 * 分页tool
 */
public class SplitPage {

    //当前页
    private int currentPage;
    //总行数
    private int totalLine;
    //总页数
    private int totalPage;
    // 每页显示数量
    private int pageSize;
    //每页开始值
    private  int Start;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalLine() {
        return totalLine;
    }

    public void setTotalLine(int totalLine) {
        setTotalPage(totalLine/pageSize==0?totalLine/pageSize:totalLine/pageSize+1);
        this.totalLine = totalLine;
    }

    public int getTotalPage() {
        if (totalLine==0){
            return 0;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return (currentPage-1)*pageSize;
    }

    public void setStart(int start) {
        Start = start;
    }
}
