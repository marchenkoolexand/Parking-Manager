/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.exceptions;

public class CarLoadException extends RuntimeException {


	private static final long serialVersionUID = -5647717119236793956L;
	private String errorDetails;

	public CarLoadException(String reason, String errorDetails) {
		super(reason);
		this.errorDetails = errorDetails;
	}

	public String getErrorDetails() {
		return errorDetails;
	}
	
}
