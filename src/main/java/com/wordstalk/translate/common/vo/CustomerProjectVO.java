package com.wordstalk.translate.common.vo;

/**
 * Created by y on 2017/8/22.
 */
public class CustomerProjectVO {

    private String startDate;
    private String endDate;
    private String projectName;
    private String chargeStd;
    private String projectIncome;
    private String saleCommission;
    private String accountStatus;
    private String accountDate;

    public String getStartDate() {
        if(startDate == null)
            return "";
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        if(endDate == null)
            return "";
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getProjectName() {
        if(projectName == null)
            return "";
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getChargeStd() {

        if(chargeStd == null)
            return "";
        return chargeStd;
    }

    public void setChargeStd(String chargeStd) {
        this.chargeStd = chargeStd;
    }

    public String getProjectIncome() {
        if(projectIncome == null)
            return "";
        return projectIncome;
    }

    public void setProjectIncome(String projectIncome) {
        this.projectIncome = projectIncome;
    }

    public String getSaleCommission() {
        if(saleCommission == null)
            return "";
        return saleCommission;
    }

    public void setSaleCommission(String saleCommission) {
        this.saleCommission = saleCommission;
    }

    public String getAccountStatus() {

        if(accountStatus == null)
            return "";
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountDate() {

        if(accountDate == null)
            return "";
        return accountDate;
    }

    public void setAccountDate(String accountDate) {
        this.accountDate = accountDate;
    }
}
