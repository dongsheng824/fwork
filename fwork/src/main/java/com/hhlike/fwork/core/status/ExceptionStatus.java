package com.hhlike.fwork.core.status;

public enum ExceptionStatus {

	PIC_FORMAT_ERROR(2000, "图片格式错误！");

	private int status;
	private String description;

	private ExceptionStatus(int status, String description) {
		this.status = status;
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
