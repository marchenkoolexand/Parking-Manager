/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputDataValidator {

	private static final Logger logger = LoggerFactory.getLogger(InputDataValidator.class);

	public static boolean validate(Object... arg) {

		for (Object a : arg) {

			if (a.getClass().equals(Integer.class)) {

				boolean intStatus = validateInt((int) a);

				if (intStatus == false) {

					logger.debug("Integer argument: " + a + " is invalid");

					return false;
				}

			} else if (a.getClass().equals(String.class)) {

				boolean stringStatus = validateString((String) a);

				if (stringStatus == false) {

					logger.debug("String argument: " + a + " is invalid");

					return false;
				}

			} else {

				return false;
			}

		}

		logger.info("All arguments was correct, continue job");

		return true;
	}

	private static boolean validateInt(int arg) {

		if (arg < 0) {

			return false;

		} else if (arg > 10000) {

			return false;
		}
		return true;

	}

	private static boolean validateString(String arg) {

		String validationString = "abcdefghijklmnopqrstuvwxyz0123456789_ABCDEFGHIJKLMNOPQRSTUVWXVZ -.,'";

		char[] symbols = arg.toCharArray();

		if (symbols.length < 1 || symbols.length > 40) {

			return false;
		}

		for (char c : symbols) {

			if (validationString.indexOf(c) == -1) {

				return false;
			}
		}

		return true;

	}

}
