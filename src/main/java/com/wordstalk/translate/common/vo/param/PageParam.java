package com.wordstalk.translate.common.vo.param;

import java.io.Serializable;

public class PageParam implements Serializable {

	private static final long serialVersionUID = 4413547131157945790L;
	
	/**
	 * 第几页
	 */
	private int page;
	/**
	 * 每页几行
	 */
	private int rows = 15;
	/**
	 * desc or asc 
	 */
	private String sortRule;
	/**
	 * 字段名称
	 */
	private String sortOrderBy;
	/**
	 * 共多少条数据
	 */
	private int offset;
	/**
	 * 搜索关键字
	 */
	private String searchKey;
	
	private Integer projectId;
	
	private Integer status;
	private String remarks;
	private String customerName;
	private String levelStr;
	private String name;
	private String languageFrom;
	private String languageTo;
	private String contractEndDate;
	private String other;

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getLevelStr() {
		return levelStr;
	}

	public void setLevelStr(String levelStr) {
		this.levelStr = levelStr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguageFrom() {
		return languageFrom;
	}

	public void setLanguageFrom(String languageFrom) {
		this.languageFrom = languageFrom;
	}

	public String getLanguageTo() {
		return languageTo;
	}

	public void setLanguageTo(String languageTo) {
		this.languageTo = languageTo;
	}

	public String getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public void setOffset(Integer offset) {
		this.offset = offset=(page==0?page:(page-1))*rows;
	}
	public Integer getOffset() {
		return offset;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;//默认 15
	}
	public String getSortRule() {
		return sortRule;
	}
	public void setSortRule(String sortRule) {
		this.sortRule = sortRule;
	}
	public String getSortOrderBy() {
		return sortOrderBy;
	}
	public void setSortOrderBy(String sortOrderBy) {
		this.sortOrderBy = sortOrderBy;
	}
}
