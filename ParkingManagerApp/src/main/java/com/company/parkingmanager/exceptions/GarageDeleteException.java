package com.company.parkingmanager.exceptions;

public class GarageDeleteException extends RuntimeException {

	private static final long serialVersionUID = -9204822423538093128L;
	private String errorDetails;

	public GarageDeleteException(String reason, String errorDetails) {
		super(reason);
		this.errorDetails = errorDetails;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

}