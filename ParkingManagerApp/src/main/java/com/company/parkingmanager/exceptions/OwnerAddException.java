/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.exceptions;

public class OwnerAddException extends RuntimeException {

	private static final long serialVersionUID = 8325198538727942328L;
	private String errorDetails;

	public OwnerAddException(String reason, String errorDetails) {
		super(reason);
		this.errorDetails = errorDetails;
	}

	public String getErrorDetails() {
		return errorDetails;
	}
}
