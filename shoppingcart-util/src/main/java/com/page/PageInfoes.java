package com.page;

/**
 */
public class PageInfoes {
    private int pageNo = 1;
    private long recordCount;
    private int pageSize = 5;

    public PageInfoes() {
    }

    public PageInfoes(int pageNo, long recordCount) {
        this.pageNo = pageNo;
        this.recordCount = recordCount;
    }

    public PageInfoes(int pageNo, long recordCount, int pageSize) {
        this.pageNo = pageNo;
        this.recordCount = recordCount;
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public long getRecordCount() {
        return recordCount;
    }


    public int getPageSize() {
        return pageSize;
    }


    /**
     * 	得到下一页
     * @return
     */
    public int getNext() {
        return Math.min(pageNo+1, getPageCount());
    }


    /**
     * 	得到最后一页
     * @return
     */
    public int getLast() {
        return  getPageCount();
    }
    /**
     * 	得到总页数
     * @return
     */
    public int getPageCount(){
        return (int)Math.ceil(this.recordCount * 1.0 / this.pageSize);
    }
    /**
     * 	得到上一页
     * @return
     */
    public int getPrev() {
        return Math.max(pageNo-1, 1);
    }

    /**
     * 	得到第一页
     * @return
     */
    public int getFirst() {
        return 1;
    }

    /**
     * 	得到上一页最后一条记录
     * @return
     */
    public int getOffset(){
        return (this.pageNo-1) * this.pageSize;
    }
    /**
     * 	得到当前页第一条记录
     * @return
     */
    public int getStart() {
    	return (this.pageNo-1)* this.pageSize  + 1;
    }
    /**
     * 	得到当前页最后一条记录
     * @return
     */
    public int getEnd() {
    	return this.pageNo* this.pageSize ;
    }

}
