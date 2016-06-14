/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.exceptions;

public class GarageUpdateException  extends RuntimeException {
	

	private static final long serialVersionUID = -7624594116912725459L;
	private String errorDetails;

	public GarageUpdateException(String reason, String errorDetails) {
		super(reason);
		this.errorDetails = errorDetails;
	}

	public String getErrorDetails() {
		return errorDetails;
	}
}
