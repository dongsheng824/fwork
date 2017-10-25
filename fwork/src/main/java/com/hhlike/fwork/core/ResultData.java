package com.hhlike.fwork.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.hhlike.fwork.core.status.ResultStatus;

public class ResultData implements Serializable{

	private static final long serialVersionUID = 1L;
	private int status;
	private String message;
	private Map<String, Object> data;

	public ResultData() {
		super();
	}

	public ResultData(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ResultData(ResultStatus resultStatus) {
		this.status = resultStatus.getStatus();
		this.message = resultStatus.getDescription();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public void addData(String key, Object value) {
		if (this.data == null) {
			data = new HashMap<String, Object>();
		}
		data.put(key, value);
	}

	public Object getData(String key) {
		if (this.data == null) {
			return null;
		}
		return this.data.get(key);
	}
}
