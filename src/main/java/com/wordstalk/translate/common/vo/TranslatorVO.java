package com.wordstalk.translate.common.vo;

public class TranslatorVO {
	private Integer id;
	private String name;/* 姓名 */
	private String workExperience;/* 工作背景 */
	private Integer level;/* 级别 */
	private String skillfulField;
	private String contractStartDate;
	private String contractEndDate;
	private Double salary;
	private String telephone;
	private String email;
	private String remarks;/* 说明 */
	private String languageList;
	private String levelStr;
	private String spareDayStr;
	private Integer partNum;
	private Integer status;
	private String statusStr;
	private Double scoreAvg;

	public Double getScoreAvg() {
		return scoreAvg;
	}

	public void setScoreAvg(Double scoreAvg) {
		this.scoreAvg = scoreAvg;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {

		this.statusStr = status == 1?"在职":"离职";
		this.status = status;
	}

	public Integer getPartNum() {
		return partNum;
	}

	public void setPartNum(Integer partNum) {
		this.partNum = partNum;
	}

	public String getSpareDayStr() {
		return spareDayStr;
	}

	public void setSpareDayStr(String spareDayStr) {
		this.spareDayStr = spareDayStr;
	}

	public String getLevelStr() {
		return levelStr;
	}

	public void setLevelStr(String levelStr) {
		this.levelStr = levelStr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLanguageList() {
		return languageList;
	}

	public void setLanguageList(String languageList) {
		this.languageList = languageList;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getSkillfulField() {
		return skillfulField;
	}

	public void setSkillfulField(String skillfulField) {
		this.skillfulField = skillfulField;
	}

	public String getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(String contractStartDate) {
		if ("".equals(contractStartDate))
			this.contractStartDate = null;
		else
			this.contractStartDate = contractStartDate;
	}

	public String getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(String contractEndDate) {
		if ("".equals(contractEndDate))
			this.contractEndDate = null;
		else
			this.contractEndDate = contractEndDate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "译员姓名：" + name + "; 背景:" + workExperience + "; 擅长领域"
				+ skillfulField + "; 合同开始时间:" + contractStartDate + "; 合同结束时间:"
				+ contractEndDate + "; 稿费标准" + salary + "; 电话:" + telephone
				+ "; 邮箱:" + email + "; 备注:" + remarks + "; 语言:" + languageList
				+ "; 级别:" + ConstantsField.levelMap.get(level) + "; 空余时间:"
				+ spareDayStr + "]";
	}

}
