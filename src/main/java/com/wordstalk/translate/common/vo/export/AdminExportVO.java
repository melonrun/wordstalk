package com.wordstalk.translate.common.vo.export;

/**
 * Created by y on 16/10/2.
 */
public class AdminExportVO {
    /* 项目基本信息*/
    private String projectId;
    private String projectName;
    private String projectStartDate;
    private String projectEndDate;
    private String customerName;
    private String languageFrom;
    private String languageTo;
    private Integer wordsCount;
    private Integer reviewWordsCount;
    private Integer wordsNoSpace;
    private String projectRemarks;
    private String projectType;

    /* 项目区块信息*/
    private String partType;
    private String partName;
    private String translatorName;
    private Integer wordsNum;
    private String partStartDate;
    private String partEndDate;
    private String comment;
    private String status;
    private String settleDate;
    private Double partSalaryStd;
    private Double partSalaryReal;

    /* 项目管理员部分信息*/
    private Integer adminWordsCount;
    private Integer adminReviewWordsCount;
    private Double chargeStd;
    private Double projectIncome;
    private Double tranCost;
    private Double reviewCost;
    private Double manageCost;
    private Double saleComm;
    private String saleRecord;
    private Double taxCost;
    private Double projectProfit;
    private Double profitRatio;
    private String accountStatus;
    private String adminEndDate;

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }



    public Double getPartSalaryStd() {
        return partSalaryStd;
    }

    public void setPartSalaryStd(Double partSalaryStd) {
        this.partSalaryStd = partSalaryStd;
    }

    public Double getPartSalaryReal() {
        return partSalaryReal;
    }

    public void setPartSalaryReal(Double partSalaryReal) {
        this.partSalaryReal = partSalaryReal;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(String projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public String getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(String projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public Integer getReviewWordsCount() {
        return reviewWordsCount;
    }

    public void setReviewWordsCount(Integer reviewWordsCount) {
        this.reviewWordsCount = reviewWordsCount;
    }

    public Integer getWordsNoSpace() {
        return wordsNoSpace;
    }

    public void setWordsNoSpace(Integer wordsNoSpace) {
        this.wordsNoSpace = wordsNoSpace;
    }

    public String getProjectRemarks() {
        return projectRemarks;
    }

    public void setProjectRemarks(String projectRemarks) {
        this.projectRemarks = projectRemarks;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getTranslatorName() {
        return translatorName;
    }

    public void setTranslatorName(String translatorName) {
        this.translatorName = translatorName;
    }

    public Integer getWordsNum() {
        return wordsNum;
    }

    public void setWordsNum(Integer wordsNum) {
        this.wordsNum = wordsNum;
    }

    public String getPartStartDate() {
        return partStartDate;
    }

    public void setPartStartDate(String partStartDate) {
        this.partStartDate = partStartDate;
    }

    public String getPartEndDate() {
        return partEndDate;
    }

    public void setPartEndDate(String partEndDate) {
        this.partEndDate = partEndDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public Integer getAdminWordsCount() {
        return adminWordsCount;
    }

    public void setAdminWordsCount(Integer adminWordsCount) {
        this.adminWordsCount = adminWordsCount;
    }

    public Integer getAdminReviewWordsCount() {
        return adminReviewWordsCount;
    }

    public void setAdminReviewWordsCount(Integer adminReviewWordsCount) {
        this.adminReviewWordsCount = adminReviewWordsCount;
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

    public Double getReviewCost() {
        return reviewCost;
    }

    public void setReviewCost(Double reviewCost) {
        this.reviewCost = reviewCost;
    }

    public Double getManageCost() {
        return manageCost;
    }

    public void setManageCost(Double manageCost) {
        this.manageCost = manageCost;
    }

    public Double getSaleComm() {
        return saleComm;
    }

    public void setSaleComm(Double saleComm) {
        this.saleComm = saleComm;
    }

    public String getSaleRecord() {
        return saleRecord;
    }

    public void setSaleRecord(String saleRecord) {
        this.saleRecord = saleRecord;
    }

    public Double getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(Double taxCost) {
        this.taxCost = taxCost;
    }

    public Double getProjectProfit() {
        return projectProfit;
    }

    public void setProjectProfit(Double projectProfit) {
        this.projectProfit = projectProfit;
    }

    public Double getProfitRatio() {
        return profitRatio;
    }

    public void setProfitRatio(Double profitRatio) {
        this.profitRatio = profitRatio;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAdminEndDate() {
        return adminEndDate;
    }

    public void setAdminEndDate(String adminEndDate) {
        this.adminEndDate = adminEndDate;
    }
}
