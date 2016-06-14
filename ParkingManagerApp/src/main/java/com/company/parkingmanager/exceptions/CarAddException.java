/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.exceptions;

public class CarAddException extends RuntimeException {

	private static final long serialVersionUID = -9204822423538093128L;
	private String errorDetails;

	public CarAddException(String reason, String errorDetails) {
		super(reason);
		this.errorDetails = errorDetails;
	}

	public String getErrorDetails() {
		return errorDetails;
	}
}
