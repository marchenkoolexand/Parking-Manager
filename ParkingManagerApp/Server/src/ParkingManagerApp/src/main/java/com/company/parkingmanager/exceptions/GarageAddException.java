/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.exceptions;

public class GarageAddException extends RuntimeException {


	private static final long serialVersionUID = -8713760105439438141L;
	private String errorDetails;

	public GarageAddException(String reason, String errorDetails) {
		super(reason);
		this.errorDetails = errorDetails;
	}

	public String getErrorDetails() {
		return errorDetails;
	}
}
