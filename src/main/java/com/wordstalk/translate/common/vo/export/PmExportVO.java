package com.wordstalk.translate.common.vo.export;

/**
 * Created by y on 16/10/2.
 */
public class PmExportVO {
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

    public String getLanguageTo() {
        return languageTo;
    }

    public void setLanguageTo(String languageTo) {
        this.languageTo = languageTo;
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
}
