package com.wordstalk.translate.common.vo.param;

public class VerifyVO {
	private boolean status;
	private String errorMsg;
	
	public VerifyVO() {
		super();
	}
	public VerifyVO(boolean status, String errorMsg) {
		super();
		this.status = status;
		this.errorMsg = errorMsg;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
