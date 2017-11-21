package com.wordstalk.translate.common.vo;

import java.util.List;

import jxl.write.WritableWorkbook;

public class ExcelSheetVO {
	private String[] titles;
	private String[] columns;
	private List<?> results;
	private WritableWorkbook wwb;
	public String[] getTitles() {
		return titles;
	}
	public void setTitles(String[] titles) {
		this.titles = titles;
	}
	public String[] getColumns() {
		return columns;
	}
	public void setColumns(String[] columns) {
		this.columns = columns;
	}
	public List<?> getResults() {
		return results;
	}
	public void setResults(List<?> results) {
		this.results = results;
	}
	public WritableWorkbook getWwb() {
		return wwb;
	}
	public void setWwb(WritableWorkbook wwb) {
		this.wwb = wwb;
	}
}
