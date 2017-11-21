package com.wordstalk.translate.common.vo;

public class JsonContent {
	public JsonContent(){
	}
	public JsonContent(Integer type, String msg, Object data){
		this.msg = msg;
		this.data = data;
		this.status = type;
	}
	public static JsonContent errorJson(String msg, Object data){
		return new JsonContent(-1, msg, data);
	}
	public static JsonContent okJson(String msg, Object data){
		return new JsonContent(1, msg, data);
	}
	private Integer status;
	private String msg;
	private Object data;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
