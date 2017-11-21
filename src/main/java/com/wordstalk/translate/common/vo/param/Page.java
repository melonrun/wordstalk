package com.wordstalk.translate.common.vo.param;

public class Page {
	private Integer curPage;
	private Integer dataSum;
	private Integer pages;
	private Integer rows;
	private Object results;
	public static Page createPage(Integer curPage, Integer pages, 
			Integer rows, Object results){
		return new Page(curPage, pages, rows, results);
	}
	
	public Page(Integer curPage, Integer dataSum, Integer rows, Object results) {
		super();
		this.curPage = curPage;
		this.dataSum = dataSum;
		this.rows = rows;
		this.results = results;
	}
	public Page(){}
	public Integer getDataSum() {
		return dataSum;
	}

	public void setDataSum(Integer dataSum) {
		this.dataSum = dataSum;
	}

	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPages() {
		pages = rows==0?((dataSum-1)/15 + 1):((dataSum-1)/rows + 1);
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Object getResults() {
		return results;
	}
	public void setResults(Object results) {
		this.results = results;
	}
}
