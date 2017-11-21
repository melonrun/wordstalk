package com.wordstalk.translate.common.vo;

import org.apache.commons.lang3.StringUtils;

public class ProjectVO {
	private Integer id;
	private String projectId;
	private String projectName;
	private String customerName;
	private String startDate;
	private String endDate;
	private String languageFrom;
	private String languageTo;
	private Integer wordsCount;
	private Integer reviewWordsCount;
	private Integer wordsNoSpace;
	private Integer projectType;
	private String remarks;
	private String temp;

	public Integer getProjectType() {
		return projectType;
	}

	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public Integer getReviewWordsCount() {
		return reviewWordsCount;
	}

	public void setReviewWordsCount(Integer reviewWordsCount) {
		this.reviewWordsCount = reviewWordsCount;
	}

	private String cutDateString(String date){
		if(StringUtils.isNotBlank(date) && date.length() > 2){
			date = date.substring(2);
			date = date.replace("-", "");
		}
		return date;
	}
	public String getProjectId() {
		projectId = cutDateString(startDate) + "-"
				+ cutDateString(endDate);
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		if("".equals(startDate))
			this.startDate = null;
		else
			this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		if("".equals(endDate))
			this.endDate = null;
		else
			this.endDate = endDate;
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
	public Integer getWordsCount() {
		return wordsCount;
	}
	public void setWordsCount(Integer wordsCount) {
		this.wordsCount = wordsCount;
	}
	public Integer getWordsNoSpace() {
		return wordsNoSpace;
	}
	public void setWordsNoSpace(Integer wordsNoSpace) {
		this.wordsNoSpace = wordsNoSpace;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectVO other = (ProjectVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "项目名称:" + projectName
				+ "; 客户名称:" + customerName + "; 项目开始时间:" + startDate
				+ "; 项目结束时间:" + endDate + "; 源语言:" + languageFrom
				+ "; 目标语言:" + languageTo + "; 区块合计字数:" + wordsCount
				+ "; 不计空格字数:" + wordsNoSpace + "; 备注:" + remarks ;
	}
	
}
