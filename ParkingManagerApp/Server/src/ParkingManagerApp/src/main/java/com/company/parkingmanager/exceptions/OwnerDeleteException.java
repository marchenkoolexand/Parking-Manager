package com.company.parkingmanager.exceptions;

public class OwnerDeleteException extends RuntimeException {

	private static final long serialVersionUID = -9204822423538093128L;
	private String errorDetails;

	public OwnerDeleteException(String reason, String errorDetails) {
		super(reason);
		this.errorDetails = errorDetails;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

}