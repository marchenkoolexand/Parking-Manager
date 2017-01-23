/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.exceptions;

public class OwnerLoadException extends RuntimeException {

	private static final long serialVersionUID = -5714383478289653091L;
	private String errorDetails;

	public OwnerLoadException(String reason, String errorDetails) {
		super(reason);
		this.errorDetails = errorDetails;
	}

	public String getErrorDetails() {
		return errorDetails;
	}
	
}
