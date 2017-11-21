package com.wordstalk.translate.common.vo;

public class ProjectPartVO {
	private Integer id;
	private Integer projectId;
	private String partName;
	private Integer wordsNum;
	private String translatorId;
	private String translatorName;
	private Double salaryStd;
	private Double salaryReal;
	private String startDate;
	private String endDate;
	private String comment;
	private Integer status;
	private String statusStr;
	private String settleDate;
	private Integer partType;
	private Integer score1;
	private Integer score2;
	private Integer score3;
	private Integer score4;
	private Integer score5;
	private Double scoreAvg;

	private String projectName;
	private String projectIdStr;

	private String pmCheckout;

	public Integer getScore1() {
		return score1;
	}

	public void setScore1(Integer score1) {
		this.score1 = score1;
	}

	public Integer getScore2() {
		return score2;
	}

	public void setScore2(Integer score2) {
		this.score2 = score2;
	}

	public Integer getScore3() {
		return score3;
	}

	public void setScore3(Integer score3) {
		this.score3 = score3;
	}

	public Integer getScore4() {
		return score4;
	}

	public void setScore4(Integer score4) {
		this.score4 = score4;
	}

	public Integer getScore5() {
		return score5;
	}

	public void setScore5(Integer score5) {
		this.score5 = score5;
	}

	public Double getScoreAvg() {
		return scoreAvg;
	}

	public void setScoreAvg(Double scoreAvg) {
		this.scoreAvg = scoreAvg;
	}

	public String getPmCheckout() {
		return pmCheckout;
	}

	public void setPmCheckout(String pmCheckout) {
		this.pmCheckout = pmCheckout;
	}

	public Integer getPartType() {
		return partType;
	}

	public void setPartType(Integer partType) {
		this.partType = partType;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectIdStr() {
		return projectIdStr;
	}
	public void setProjectIdStr(String projectIdStr) {
		this.projectIdStr = projectIdStr;
	}
	public String getStatusStr() {
		statusStr = status==1?"是":"否";
		return statusStr;
	}
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	public String getTranslatorName() {
		return translatorName;
	}
	public void setTranslatorName(String translatorName) {
		this.translatorName = translatorName;
	}
	public Double getSalaryReal() {
		return salaryReal;
	}
	public void setSalaryReal(Double salaryReal) {
		this.salaryReal = salaryReal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public Integer getWordsNum() {
		return wordsNum;
	}
	public void setWordsNum(Integer wordsNum) {
		this.wordsNum = wordsNum;
	}
	public String getTranslatorId() {
		return translatorId;
	}
	public void setTranslatorId(String translatorId) {
		this.translatorId = translatorId;
	}
	public Double getSalaryStd() {
		return salaryStd;
	}
	public void setSalaryStd(Double salaryStd) {
		this.salaryStd = salaryStd;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		statusStr = status==-1?"否":"是";
		this.status = status;
	}
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String settleDate) {
		if("".equals(settleDate))
			this.settleDate = null;
		else
			this.settleDate = settleDate;
	}
}
