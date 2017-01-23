/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.parkingmanager.testdata.DataGenerator;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response) {

		return "home";
	}

	@RequestMapping(value = "/addData", method = RequestMethod.GET)
	public String addData(HttpServletRequest request, HttpServletResponse response) {

		DataGenerator.addData();

		return "home";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleCustomException(Exception ex) {

		return  "home";

	}

}
