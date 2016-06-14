/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.exceptions;

public class OwnerUpdateException extends RuntimeException {
	

	private static final long serialVersionUID = -4196432298337805288L;
	private String errorDetails;

	public OwnerUpdateException(String reason, String errorDetails) {
		super(reason);
		this.errorDetails = errorDetails;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

}
