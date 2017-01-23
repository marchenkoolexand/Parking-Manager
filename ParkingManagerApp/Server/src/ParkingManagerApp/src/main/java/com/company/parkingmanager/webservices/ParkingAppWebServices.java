/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.parkingmanager.dao.PersistanceManager;
import com.company.parkingmanager.dao.PersistenceManagerImpl;
import com.company.parkingmanager.entyty.Car;
import com.company.parkingmanager.entyty.Garage;
import com.company.parkingmanager.entyty.Owner;
import com.company.parkingmanager.testdata.DataGenerator;

@WebService(name = "ParkingAppManager", serviceName = "ParkingService", targetNamespace = "http://parkingmanager.com")
@SOAPBinding(style = Style.DOCUMENT)
public class ParkingAppWebServices implements PersistanceManager {

	private static final Logger logger = LoggerFactory.getLogger(ParkingAppWebServices.class);

	PersistanceManager manager = new PersistenceManagerImpl();

	@Override
	@WebMethod(action = "add_new_car_to_garage", operationName = "addNewCar")
	@WebResult(partName = "addNewCarOutput")
	public boolean addNewCarToGarage(@WebParam(name = "garageId") int garageID, @WebParam(name = "brand") String brand,
			@WebParam(name = "model") String model, @WebParam(name = "year") int year,
			@WebParam(name = "color") String color, @WebParam(name = "plateNumber") String plateNumber,
			@WebParam(name = "ownerId") int ownerId) {

		boolean result = manager.addNewCarToGarage(garageID, brand, model, year, color, plateNumber, ownerId);

		if (result) {
			logger.info("New Car was add to DB with next param: Brand- " + brand + ",Model - " + model + " ,Year- "
					+ year + " ,Color- " + color + " ,Plate Number- " + plateNumber + " ,Owner ID-" + ownerId + ".");
		} else {
			logger.error("Error ocure while adding car to DB with next param: Brand- " + brand + ",Model - " + model
					+ " ,Year- " + year + " ,Color- " + color + " ,Plate Number- " + plateNumber + " ,Owner ID-"
					+ ownerId + ".");
		}

		return result;
	}

	@Override
	@WebMethod(action = "add_new_garage", operationName = "addNewGarage")
	@WebResult(name = "addNewGarageOutput")
	public boolean addNewGarage(@WebParam(name = "city") String city, @WebParam(name = "street") String street,
			@WebParam(name = "buildingNumber") int buildingNumber) {

		boolean result = manager.addNewGarage(city, street, buildingNumber);

		if (result) {
			logger.info("New Garage was add to DB with next param: City- " + city + ",Street - " + street
					+ " ,Building number - " + buildingNumber);
		} else {
			logger.error("Error ocure while adding new Garage to DB with next param: City- " + city + ",Street - "
					+ street + " ,Building number - " + buildingNumber);
		}

		return result;
	}

	@WebMethod(action = "add_new_owner", operationName = "addNewOwner")
	@Override
	@WebResult(partName = "addNewOwnerOutput")
	public boolean addNewOwner(@WebParam(name = "name") String name, @WebParam(name = "surname") String surname) {

		boolean result = manager.addNewOwner(name, surname);

		if (result) {
			logger.info("New Owner was add to DB with next param: Name- " + name + ",Surname - " + surname);
		} else {
			logger.error("Error ocure while adding new Owner to DB with next param: Name- " + name + ",Surname - "
					+ surname);
		}
		return result;
	}

	@Override
	@WebMethod(action = "update_garage", operationName = "updateGarage")
	@WebResult(partName = "updateGarageOutput")
	public boolean updateGarage(@WebParam(name = "field") String field, @WebParam(name = "newData") String newData,
			@WebParam(name = "garageId") int garageID) {

		boolean result = manager.updateGarage(field, newData, garageID);

		if (result) {
			logger.info("Garage was update sucsesfuly with next param: Field- " + field + ",New Data - " + newData
					+ " ,Garage ID- " + garageID);
		} else {
			logger.error("Error ocure while updating garage with next param: Field- " + field + ",New Data - " + newData
					+ " ,Garage ID- " + garageID);
		}

		return result;

	}

	@Override
	@WebMethod(action = "update_owner", operationName = "updateOwner")
	@WebResult(partName = "updateOwnerOutput")
	public boolean updateOwner(@WebParam(name = "field") String field, @WebParam(name = "newData") String newData,
			@WebParam(name = "ownerID") int ownerID) {

		boolean result = manager.updateOwner(field, newData, ownerID);

		if (result) {
			logger.info("Owner was update sucsesfuly with next param: Field- " + field + ",New Data - " + newData
					+ " ,Garage ID- " + ownerID);
			logger.error("Error ocure while updating owner with next param: Field- " + field + ",New Data - " + newData
					+ " ,Garage ID- " + ownerID);
		}

		return result;

	}

	@Override
	@WebMethod(action = "update_car", operationName = "updateCar")
	@WebResult(partName = "updateCarOutput")
	public boolean updateCar(@WebParam(name = "field") String field, @WebParam(name = "newData") String newData,
			@WebParam(name = "carID") int carID) {

		boolean result = manager.updateCar(field, newData, carID);

		if (result) {
			logger.info("Car was update sucsesfuly with next param: Field- " + field + ",New Data - " + newData
					+ " ,Garage ID- " + carID);
		} else {
			logger.error("Error ocure while updating car with next param: Field- " + field + ",New Data - " + newData
					+ " ,Garage ID- " + carID);
		}

		return result;
	}

	@Override
	@WebMethod(action = "load_all_data", operationName = "loadAllData")
	@WebResult(partName = "loadAllDataOutput")
	public List<Garage> loadSummaryData() {

		List<Garage> result = manager.loadSummaryData();

		if (!result.isEmpty()) {
			logger.info("Data load sucsesfuly");
		} else {
			logger.error("Error ocure while load data from DB");
		}

		return result;
	}

	@Override
	@WebMethod(action = "load_car", operationName = "loadCar")
	@WebResult(partName = "fetchCarOutput", name = "Car")
	public Car fetchCar(@WebParam(name = "carId") int carID) {

		Car result = manager.fetchCar(carID);

		if (!(result == null)) {
			logger.info("Car load sucsesfuly, Car: " + result);
		} else {
			logger.error("Error ocure while load car");
		}

		return result;
	}

	@Override
	@WebMethod(action = "load_owner", operationName = "loadOwner")
	@WebResult(name = "Owner", partName = "fetchOwnerOutput")
	public Owner fetchOwner(@WebParam(name = "ownerId") int ownerID) {

		Owner result = manager.fetchOwner(ownerID);

		if (!(result == null)) {
			logger.info("Owner load sucsesfuly, Owner: " + result);
		} else {
			logger.error("Error ocure while load owner");
		}

		return result;
	}

	@Override
	@WebMethod(action = "load_garage", operationName = "loadGarage")
	@WebResult(name = "Garage", partName = "fetchGarageOutput")
	public Garage fetchGarage(@WebParam(name = "garageId") int garageID) {

		Garage result = manager.fetchGarage(garageID);

		if (!(result == null)) {
			logger.info("Garage load sucsesfuly, Car: " + result);
		} else {
			logger.error("Error ocure while load garage");
		}

		return result;
	}

	@WebMethod(action = "add_sample_data", operationName = "addData")
	public void addSampleData() {

		DataGenerator.addData();

	}

	@WebMethod(action = "delete_car", operationName = "deleteCar")
	@Override
	public void deleteCar(@WebParam(name = "carId") int carId) {

		manager.deleteCar(carId);
	}

	@WebMethod(action = "deleteGarage", operationName = "deleteGarage")
	@Override
	public void deleteGarage(@WebParam(name = "garageId") int garageId) {
		manager.deleteGarage(garageId);

	}

	@WebMethod(action = "deleteOwner", operationName = "deleteOwner")
	@Override
	public void deleteOwner(@WebParam(name = "ownerId") int ownerId) {
		manager.deleteOwner(ownerId);
	}

}