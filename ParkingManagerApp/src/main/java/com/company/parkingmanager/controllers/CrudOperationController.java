/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.parkingmanager.dao.InputDataValidator;
import com.company.parkingmanager.dao.PersistanceManager;
import com.company.parkingmanager.dao.PersistenceManagerImpl;
import com.company.parkingmanager.entyty.Car;
import com.company.parkingmanager.entyty.Garage;
import com.company.parkingmanager.entyty.Owner;

@Controller
public class CrudOperationController {

	private static final Logger logger = LoggerFactory.getLogger(CrudOperationController.class);

	PersistanceManager manager = new PersistenceManagerImpl();

	@RequestMapping(value = "/addNewCar", method = RequestMethod.GET)
	public boolean addNewCar(HttpServletRequest request) {

		String garageId = "null";
		garageId = request.getParameter("garageId");
		int garageIdConvertedFromString = Integer.parseInt(garageId);
		String brand = "null";
		brand = request.getParameter("brand");
		String model = "null";
		model = request.getParameter("model");
		String year = "0";
		year = request.getParameter("year");
		int yearConvertedFromString = Integer.parseInt(year);
		String color = "null";
		color = request.getParameter("color");
		String plateNumber = "null";
		plateNumber = request.getParameter("plateNumber");
		String ownerId = request.getParameter("ownerId");
		int ownerIdConvertedFromString = Integer.parseInt(ownerId);

		boolean result = false;

		if (InputDataValidator.validate(garageIdConvertedFromString, brand, model, yearConvertedFromString, color,
				plateNumber, ownerIdConvertedFromString)) {

			result = manager.addNewCarToGarage(garageIdConvertedFromString, brand, model, yearConvertedFromString,
					color, plateNumber, ownerIdConvertedFromString);

			if (result) {
				logger.info("New Car was add to DB with next param: Brand- " + brand + ",Model - " + model + " ,Year- "
						+ year + " ,Color- " + color + " ,Plate Number- " + plateNumber + " ,Owner ID-" + ownerId
						+ ".");
			} else {
				logger.error("Error ocure while adding car to DB with next param: Brand- " + brand + ",Model - " + model
						+ " ,Year- " + year + " ,Color- " + color + " ,Plate Number- " + plateNumber + " ,Owner ID-"
						+ ownerId + ".");
			}
		}

		return result;
	}

	@RequestMapping(value = "/addNewOwner", method = RequestMethod.GET)
	public boolean addNewOwner(HttpServletRequest request) {

		String name = "null";
		name = request.getParameter("name");
		String surname = "null";
		surname = request.getParameter("surname");
		boolean result = false;

		if (InputDataValidator.validate(name, surname)) {
			result = manager.addNewOwner(name, surname);
			if (result) {
				logger.info("New Owner was add to DB with next param: Name- " + name + ",Surname - " + surname);
			} else {
				logger.error("Error ocure while adding new Owner to DB with next param: Name- " + name + ",Surname - "
						+ surname);
			}
		}
		return result;
	}

	@RequestMapping(value = "/addNewGarage", method = RequestMethod.GET)
	public boolean addNewGarage(HttpServletRequest request) {

		String city = "null";
		city = request.getParameter("city");
		String street = "null";
		street = request.getParameter("street");
		String buildingNumber = "0";
		buildingNumber = request.getParameter("buildingNumber");
		int convertedFromString = Integer.parseInt(buildingNumber);

		boolean result = false;

		if (InputDataValidator.validate(city, street)) {

			result = manager.addNewGarage(city, street, convertedFromString);

			if (result) {
				logger.info("New Garage was add to DB with next param: City- " + city + ",Street - " + street
						+ " ,Building number - " + buildingNumber);
			} else {
				logger.error("Error ocure while adding new Garage to DB with next param: City- " + city + ",Street - "
						+ street + " ,Building number - " + buildingNumber);
			}
		}
		return result;
	}

	@RequestMapping(value = "/updateCar", method = RequestMethod.GET)
	public boolean updateCar(HttpServletRequest request) {

		String field = "null";
		field = request.getParameter("field");
		String newData = "null";
		newData = request.getParameter("newData");
		String carID = "0";
		carID = request.getParameter("carID");
		int convertedFromString = Integer.parseInt(carID);

		boolean result = false;
		if (InputDataValidator.validate(field, newData, convertedFromString)) {

			result = manager.updateCar(field, newData, convertedFromString);
			if (result) {
				logger.info("Car was update sucsesfuly with next param: Field- " + field + ",New Data - " + newData
						+ " ,Garage ID- " + carID);
			} else {
				logger.error("Error ocure while updating car with next param: Field- " + field + ",New Data - "
						+ newData + " ,Garage ID- " + carID);
			}
		}
		return result;
	}

	@RequestMapping(value = "/updateOwner", method = RequestMethod.GET)
	public boolean updateOwner(HttpServletRequest request) {

		String field = "null";
		field = request.getParameter("field");
		String newData = "null";
		newData = request.getParameter("newData");
		String ownerID = "0";
		ownerID = request.getParameter("ownerID");
		int convertedFromString = Integer.parseInt(ownerID);

		boolean result = false;

		if (InputDataValidator.validate(field, newData, convertedFromString)) {

			result = manager.updateOwner(field, newData, convertedFromString);
			if (result) {
				logger.info("Owner was update sucsesfuly with next param: Field- " + field + ",New Data - " + newData
						+ " ,Garage ID- " + ownerID);
				logger.error("Error ocure while updating owner with next param: Field- " + field + ",New Data - "
						+ newData + " ,Garage ID- " + ownerID);
			}
		}
		return result;
	}

	@RequestMapping(value = "/updateGarage", method = RequestMethod.GET)
	public boolean updateGarage(HttpServletRequest request) {

		String field = "null";
		field = request.getParameter("field");
		String newData = "null";
		newData = request.getParameter("newData");
		String garageID = "0";
		garageID = request.getParameter("garageID");
		int convertedFromString = Integer.parseInt(garageID);

		boolean result = false;

		if (InputDataValidator.validate(field, newData, convertedFromString)) {

			result = manager.updateGarage(field, newData, convertedFromString);
			if (result) {
				logger.info("Garage was update sucsesfuly with next param: Field- " + field + ",New Data - " + newData
						+ " ,Garage ID- " + garageID);
			} else {
				logger.error("Error ocure while updating garage with next param: Field- " + field + ",New Data - "
						+ newData + " ,Garage ID- " + garageID);
			}
		}
		return result;
	}

	@RequestMapping(value = "/loadAllData", method = RequestMethod.GET)

	public List<Garage> loadAllData(HttpServletRequest request) {

		List<Garage> list = manager.loadSummaryData();

		if (!list.isEmpty()) {

			logger.info("Data load sucsesfuly");

		} else {

			logger.error("Error ocure while load data from DB");
		}

		return list;
	}

	@RequestMapping(value = "/loadCar", method = RequestMethod.GET)

	public Car loadCar(HttpServletRequest request) {

		String carID = "0";
		carID = request.getParameter("carID");
		int convertedFromString = Integer.parseInt(carID);
		Car result = null;

		if (InputDataValidator.validate(convertedFromString)) {

			result = manager.fetchCar(convertedFromString);

			if (!(result == null)) {

				logger.info("Car load sucsesfuly, Car: " + result);

			} else {

				logger.error("Error ocure while load car");
			}
		}
		return result;
	}

	@RequestMapping(value = "/loadOwner", method = RequestMethod.GET)

	public Owner loadOwner(HttpServletRequest request) {
		String ownerID = "0";
		ownerID = request.getParameter("ownerID");
		int convertedFromString = Integer.parseInt(ownerID);
		Owner result = null;

		if (InputDataValidator.validate(convertedFromString)) {

			result = manager.fetchOwner(convertedFromString);

			if (!(result == null)) {

				logger.info("Owner load sucsesfuly, Owner: " + result);
			} else {
				logger.error("Error ocure while load owner");
			}

		}
		return result;
	}

	@RequestMapping(value = "/loadGarage", method = RequestMethod.GET)

	public Garage loadGarage(HttpServletRequest request) {

		String garageId = "0";
		garageId = request.getParameter("garageId");
		int convertedFromString = Integer.parseInt(garageId);
		Garage result = null;

		if (InputDataValidator.validate(convertedFromString)) {

			result = manager.fetchGarage(convertedFromString);

			if (!(result == null)) {

				logger.info("Garage load sucsesfuly, Car: " + result);
			} else {
				logger.error("Error ocure while load garage");
			}
		}
		return result;
	}

	@RequestMapping(value = "/deleteGarage", method = RequestMethod.GET)
	public String deleteGarage(HttpServletRequest request) {

		String garageId = "0";
		garageId = request.getParameter("garageId");
		int convertedFromString = Integer.parseInt(garageId);

		if (InputDataValidator.validate(convertedFromString)) {

			manager.deleteGarage(convertedFromString);

		}
		return "home";
	}

	@RequestMapping(value = "/deleteCar", method = RequestMethod.GET)
	public String deleteCar(HttpServletRequest request) {

		String carId = "0";
		carId = request.getParameter("carId");
		int convertedFromString = Integer.parseInt(carId);

		if (InputDataValidator.validate(convertedFromString)) {

			manager.deleteCar(convertedFromString);

		}
		return "home";
	}

	@RequestMapping(value = "/deleteOwner", method = RequestMethod.GET)
	public String deleteOwner(HttpServletRequest request) {

		String ownerId = "0";
		ownerId = request.getParameter("ownerId");
		int convertedFromString = Integer.parseInt(ownerId);

		if (InputDataValidator.validate(convertedFromString)) {

			manager.deleteOwner(convertedFromString);

		}
		return "home";
	}
}
