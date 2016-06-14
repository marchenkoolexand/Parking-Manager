/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.exceptions;

public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = -3978553917369331937L;
	private String errorDetails;

	public InvalidInputException(String reason, String errorDetails) {
		super(reason);
		this.errorDetails = errorDetails;
	}

	public String getErrorDetails() {
		return errorDetails;
	}
}
