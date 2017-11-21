package com.wordstalk.translate.common.vo;

public class ProjectAdminVO {
	private Integer id;
	private Integer projectId;
	private String projectName;
	private Double chargeStd;
	private Double projectIncome;
	private Double tranCost;
	private Double manageCost;
	private Double saleCommission;
	private String saleRecord;
	private Double projectProfit;
	private Double profitRatio;
	private Integer accountStatus;
	private String endDate;
	private String pmCheckoutDate;
	private String accountStatusStr;
	private Double taxCost;
	private Double reviewCost;
    private Integer wordsCount;
    private Integer reviewWordsCount;
	private Integer pmCheckout;

	public String getPmCheckoutDate() {
		return pmCheckoutDate;
	}

	public void setPmCheckoutDate(String pmCheckoutDate) {
		if("".equals(pmCheckoutDate))
			this.pmCheckoutDate = null;
		else
			this.pmCheckoutDate = pmCheckoutDate;
	}

	public Integer getPmCheckout() {
		return pmCheckout;
	}

	public void setPmCheckout(Integer pmCheckout) {
		this.pmCheckout = pmCheckout;
	}

	public Integer getReviewWordsCount() {
        return reviewWordsCount;
    }

    public void setReviewWordsCount(Integer reviewWordsCount) {
        this.reviewWordsCount = reviewWordsCount;
    }

    public Integer getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(Integer wordsCount) {
        this.wordsCount = wordsCount;
    }

	public Double getTaxCost() {
		return taxCost;
	}

	public void setTaxCost(Double taxCost) {
		this.taxCost = taxCost;
	}

	public Double getReviewCost() {
		return reviewCost;
	}

	public void setReviewCost(Double reviewCost) {
		this.reviewCost = reviewCost;
	}

	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getAccountStatusStr() {
		return accountStatus==-1?"否":"是";
	}
	public void setAccountStatusStr(String accountStatusStr) {
		this.accountStatusStr = accountStatusStr;
	}
	public Double getProfitRatio() {
		return profitRatio;
	}
	public void setProfitRatio(Double profitRatio) {
		this.profitRatio = profitRatio;
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
	public Double getChargeStd() {
		return chargeStd;
	}
	public void setChargeStd(Double chargeStd) {
		this.chargeStd = chargeStd;
	}
	public Double getProjectIncome() {
		return projectIncome;
	}
	public void setProjectIncome(Double projectIncome) {
		this.projectIncome = projectIncome;
	}
	public Double getTranCost() {
		return tranCost;
	}
	public void setTranCost(Double tranCost) {
		this.tranCost = tranCost;
	}
	public Double getManageCost() {
		return manageCost;
	}
	public void setManageCost(Double manageCost) {
		this.manageCost = manageCost;
	}
	public Double getSaleCommission() {
		return saleCommission;
	}
	public void setSaleCommission(Double saleCommission) {
		this.saleCommission = saleCommission;
	}
	public String getSaleRecord() {
		return saleRecord;
	}
	public void setSaleRecord(String saleRecord) {
		this.saleRecord = saleRecord;
	}
	public Double getProjectProfit() {
		return projectProfit;
	}
	public void setProjectProfit(Double projectProfit) {
		this.projectProfit = projectProfit;
	}
	public Integer getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(Integer accountStatus) {
		accountStatusStr = accountStatus==-1?"否":"是";
		this.accountStatus = accountStatus;
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
	@Override
	public String toString() {
		return " 收费标准: " + chargeStd + "; 项目收入:"
				+ projectIncome + "; 译员稿费:" + tranCost + "; 管理费:"
				+ manageCost + "; 销售提成:" + saleCommission
				+ "; 提成记录:" + saleRecord + "; 项目利润:"
				+ projectProfit + "; 利润率:" + profitRatio
				+ ", accountStatus=" + accountStatus + "; 到账时间:" + endDate ;
	}
}
