package com.hhlike.fwork.core.exceptions;

import com.hhlike.fwork.core.status.ExceptionStatus;

public class BusiException extends RuntimeException {
	private static final long serialVersionUID = -2666275013686512308L;

	ExceptionStatus exceptionStatus;
	public BusiException(String errMessage){
		super(errMessage);
	}

	public BusiException(ExceptionStatus exceptionStatus) {
		super(exceptionStatus.getDescription());
		this.exceptionStatus = exceptionStatus;
	}
	
}
