/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.dao;

import java.util.List;

import com.company.parkingmanager.entyty.Car;
import com.company.parkingmanager.entyty.Garage;
import com.company.parkingmanager.entyty.Owner;

public interface PersistanceManager {

	boolean addNewCarToGarage(int garageID, String brand, String model, int year, String color, String plateNumber,
			int ownerId);

	boolean addNewGarage(String city, String street, int buildingNumber);

	boolean addNewOwner(String name, String surname);

	boolean updateGarage(String field, String newData, int garageID);

	boolean updateOwner(String field, String newData, int ownerID);

	boolean updateCar(String brand, String newData, int carID);

	Car fetchCar(int carID);

	Owner fetchOwner(int ownerID);

	Garage fetchGarage(int garageID);

	List<Garage> loadSummaryData();

	void deleteCar(int carId);

	void deleteGarage(int garageId);

	void deleteOwner(int ownerId);
}