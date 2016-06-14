/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.parkingmanager.constants.CarFields;
import com.company.parkingmanager.constants.GarageFields;
import com.company.parkingmanager.constants.OwnerFields;
import com.company.parkingmanager.entyty.Car;
import com.company.parkingmanager.entyty.Garage;
import com.company.parkingmanager.entyty.Owner;
import com.company.parkingmanager.exceptions.CarAddException;
import com.company.parkingmanager.exceptions.CarDeleteException;
import com.company.parkingmanager.exceptions.CarLoadException;
import com.company.parkingmanager.exceptions.CarUpdateException;
import com.company.parkingmanager.exceptions.GarageAddException;
import com.company.parkingmanager.exceptions.GarageDeleteException;
import com.company.parkingmanager.exceptions.GarageLoadException;
import com.company.parkingmanager.exceptions.GarageUpdateException;
import com.company.parkingmanager.exceptions.OwnerAddException;
import com.company.parkingmanager.exceptions.OwnerDeleteException;
import com.company.parkingmanager.exceptions.OwnerLoadException;
import com.company.parkingmanager.exceptions.OwnerUpdateException;

public class PersistenceManagerImpl implements PersistanceManager {

	private static final Logger logger = LoggerFactory.getLogger(PersistenceManagerImpl.class);

	public boolean addNewCarToGarage(int garageID, String brand, String model, int year, String color,
			String plateNumber, int ownerId) {

		boolean status = false;

		if (InputDataValidator.validate(garageID, brand, model, year, color, plateNumber, ownerId)) {

			Session session = HibernateUtils.getSessionFactory().openSession();

			Transaction transaction = session.getTransaction();

			Car car = null;

			Garage garage = null;

			try {

				transaction.begin();

				garage = session.load(Garage.class, garageID);

				Owner owner = session.load(Owner.class, ownerId);

				car = new Car(brand, model, year, plateNumber, color, owner);

				garage.getCars().add(car);

				session.save(garage);

				status = true;

			} catch (HibernateException e) {

				if (transaction != null) {

					transaction.rollback();

					logger.error("Exception occurs while transaction in addNewCarToGarage method, transaction rollback."
							+ e);

				}
				status = false;

			} finally {

				transaction.commit();

			}

			if (status) {

				logger.info("Car" + car.toString() + "was successfully add to Garage " + garage.getId());
			}

		} else {

			CarAddException addException = new CarAddException("Invalid input for create new Car", "");

			logger.error(addException.toString());

			throw addException;

		}
		return status;

	}

	public boolean addNewOwner(String name, String surname) {
		boolean status = false;

		if (InputDataValidator.validate(name, surname)) {

			Session session = HibernateUtils.getSessionFactory().openSession();

			Transaction transaction = session.getTransaction();

			try {

				transaction.begin();

				Owner owner = new Owner(name, surname);

				session.save(owner);

				status = true;

			} catch (HibernateException e) {
				if (transaction != null) {

					transaction.rollback();

					logger.error("Exception occurs while transaction in addNewOwner method, transaction rollback." + e);
				}
				status = false;

			} finally {
				transaction.commit();
			}

		} else {

			OwnerAddException addException = new OwnerAddException("Invalid input for add new Owner", "");

			logger.error(addException.toString());

			throw addException;
		}

		return status;
	}

	public boolean addNewGarage(String city, String street, int buildingNumber) {
		boolean status = false;

		if (InputDataValidator.validate(city, street, buildingNumber)) {

			Session session = HibernateUtils.getSessionFactory().openSession();

			Transaction transaction = session.getTransaction();

			try {
				transaction.begin();

				Garage garage = new Garage(city, street, buildingNumber);

				session.save(garage);

				status = true;

			} catch (HibernateException e) {

				if (transaction != null) {
					transaction.rollback();

					logger.error(
							"Exception occurs while transaction in addNewGarage method, transaction rollback." + e);
				}
				status = false;
			} finally {

				transaction.commit();
			}
		} else {

			GarageAddException addException = new GarageAddException("Invalid input for add new Garage", "");

			logger.error(addException.toString());

			throw addException;
		}
		return status;
	}

	public boolean updateGarage(String field, String newData, int garageID) {
		boolean status = false;

		if (InputDataValidator.validate(field, newData, garageID)) {

			Session session = HibernateUtils.getSessionFactory().openSession();

			Transaction transaction = session.getTransaction();

			Garage garage = null;

			if (!newData.equals(null) | !field.equals(null)) {

				try {

					transaction.begin();

					switch (field.toLowerCase()) {

					case GarageFields.CITY:

						garage = session.load(Garage.class, garageID);

						garage.setCity(newData);

						session.update(garage);

						break;

					case GarageFields.STREET:

						garage = session.load(Garage.class, garageID);

						garage.setStreet(newData);

						session.update(garage);

						break;
					case GarageFields.BUILDING:

						garage = session.load(Garage.class, garageID);

						garage.setBuidingNumber(Integer.parseInt(newData));

						session.update(garage);

						break;
					}

					status = true;

				} catch (HibernateException e) {
					if (transaction != null) {

						transaction.rollback();
						logger.error(
								"Exception occurs while transaction in updateGarage method, transaction rollback." + e);
					}

					status = false;
				} finally {
					transaction.commit();
				}
			}
		} else {

			GarageUpdateException updateException = new GarageUpdateException("Invalid input for update Garage", "");

			logger.error(updateException.toString());

			throw updateException;
		}
		return status;
	}

	public boolean updateOwner(String field, String newData, int ownerID) {
		boolean status = false;

		if (InputDataValidator.validate(field, newData, ownerID)) {

			Session session = HibernateUtils.getSessionFactory().openSession();

			Transaction transaction = session.getTransaction();

			Owner loadedOwner = null;

			if (!newData.equals(null) | !field.equals(null)) {

				try {

					transaction.begin();

					switch (field.toLowerCase()) {

					case OwnerFields.NAME:

						loadedOwner = session.load(Owner.class, ownerID);

						loadedOwner.setName(newData);

						session.update(loadedOwner);

						break;

					case OwnerFields.SURNAME:

						loadedOwner = session.load(Owner.class, ownerID);

						loadedOwner.setSurname(newData);

						session.update(loadedOwner);

						break;
					}
					status = true;

				} catch (HibernateException e) {
					if (transaction != null) {
						transaction.rollback();

						logger.error(
								"Exception occurs while transaction in updateOwner method, transaction rollback." + e);
					}
					status = false;

				} finally {

					transaction.commit();
				}
			}
		} else {

			OwnerUpdateException updateException = new OwnerUpdateException("Invalid input for update Owner", "");

			logger.error(updateException.toString());

			throw updateException;
		}
		return status;
	}

	public boolean updateCar(String field, String newData, int carID) {
		boolean status = false;

		if (InputDataValidator.validate(field, newData, carID)) {

			Session session = HibernateUtils.getSessionFactory().openSession();

			Transaction transaction = session.getTransaction();

			Car loadedCar = null;

			if (!newData.equals(null) | !field.equals(null)) {

				try {

					transaction.begin();

					switch (field.toLowerCase()) {

					case CarFields.COLOR:

						loadedCar = session.load(Car.class, carID);

						loadedCar.setColor(newData);

						session.update(loadedCar);

						break;

					case CarFields.MODEL:

						loadedCar = session.load(Car.class, carID);

						loadedCar.setModel(newData);

						session.update(loadedCar);

						break;

					case CarFields.OWNER:

						loadedCar = session.load(Car.class, carID);

						Owner owner = session.load(Owner.class, Integer.parseInt(newData));

						loadedCar.setOwner(owner);

						session.update(loadedCar);

						break;

					case CarFields.PLATE_NUMBER:

						loadedCar = session.load(Car.class, carID);

						loadedCar.setPlateNumber(newData);

						session.update(loadedCar);

						break;

					case CarFields.BRAND:

						loadedCar = session.load(Car.class, carID);

						loadedCar.setBrand(newData);

						session.update(loadedCar);

						break;

					case CarFields.YEAR:

						loadedCar = session.load(Car.class, carID);

						loadedCar.setYear(Integer.parseInt(newData));

						session.update(loadedCar);

						break;
					}
					status = true;

				} catch (HibernateException e) {
					if (transaction != null) {
						transaction.rollback();

						logger.error(
								"Exception occurs while transaction in updateCar method, transaction rollback." + e);
					}
					status = false;
				} finally {
					transaction.commit();
				}
			}
		} else {

			CarUpdateException updateException = new CarUpdateException("Invalid input for update Car", "");

			logger.error(updateException.toString());

			throw updateException;
		}
		return status;
	}

	@SuppressWarnings("unchecked")
	public List<Garage> loadSummaryData() {

		Session session = HibernateUtils.getSessionFactory().openSession();

		Transaction transaction = session.getTransaction();

		List<Garage> list = null;

		try {
			transaction.begin();

			list = session.createQuery("from Garage").list();

		} catch (HibernateException e) {
			if (transaction != null) {

				transaction.rollback();

				logger.error("Exception occurs while transaction in loadSummaryData method, transaction rollback." + e);
			}
		} finally {
			transaction.commit();
		}
		return list;
	}

	@Override
	public Car fetchCar(int carID) {
		Car loadedCar = null;

		if (InputDataValidator.validate(carID)) {

			Session session = HibernateUtils.getSessionFactory().openSession();

			Transaction transaction = session.getTransaction();

			try {
				transaction.begin();

				loadedCar = session.load(Car.class, carID);

			} catch (HibernateException e) {
				if (transaction != null) {

					transaction.rollback();

					logger.error("Exception occurs while transaction in fetchCar method, transaction rollback." + e);
				}
			} finally {
				transaction.commit();
			}
		} else {

			CarLoadException carLoadException = new CarLoadException("Invalid input for load new Car", "");

			logger.error(carLoadException.toString());

			throw carLoadException;
		}
		return loadedCar;
	}

	@Override
	public Owner fetchOwner(int ownerID) {

		Owner loadedOwner = null;

		if (InputDataValidator.validate(ownerID)) {

			Session session = HibernateUtils.getSessionFactory().openSession();

			Transaction transaction = session.getTransaction();

			try {
				transaction.begin();

				loadedOwner = session.load(Owner.class, ownerID);
			} catch (HibernateException e) {

				if (transaction != null) {

					transaction.rollback();

					logger.error("Exception occurs while transaction in fetchOwner method, transaction rollback." + e);
				}
			} finally {
				transaction.commit();
			}
		} else {

			OwnerLoadException ownerLoadException = new OwnerLoadException("Invalid input for load new Owner", "");

			logger.error(ownerLoadException.toString());

			throw ownerLoadException;
		}
		return loadedOwner;
	}

	@Override
	public Garage fetchGarage(int garageID) {

		Garage loadedGarage = null;

		if (InputDataValidator.validate(garageID)) {

			Session session = HibernateUtils.getSessionFactory().openSession();

			Transaction transaction = session.getTransaction();

			try {
				transaction.begin();
				loadedGarage = session.load(Garage.class, garageID);
			} catch (HibernateException e) {
				if (transaction != null) {
					transaction.rollback();

					logger.error("Exception occurs while transaction in fetchGarage method, transaction rollback." + e);
				}
			} finally {
				transaction.commit();
			}
		} else {

			GarageLoadException garageLoadException = new GarageLoadException("Invalid input for load Garage", "");
			logger.error(garageLoadException.toString());

			throw garageLoadException;
		}
		return loadedGarage;
	}

	@Override
	public void deleteCar(int carId) {

		if (InputDataValidator.validate(carId)) {

			Session session = HibernateUtils.getSessionFactory().openSession();

			Transaction transaction = session.getTransaction();

			try {
				transaction.begin();

				Query query = session.createQuery("delete Car where car_id = :carId");

				query.setParameter("carId", carId);

				query.executeUpdate();

			} catch (HibernateException e) {
				if (transaction != null) {
					transaction.rollback();

					logger.error("Exception occurs while transaction in deleteCar method, transaction rollback." + e);
				}
			} finally {
				transaction.commit();
			}
		} else {

			CarDeleteException carDeleteException = new CarDeleteException("Invalid input for delete Car", "");

			logger.error(carDeleteException.toString());

			throw carDeleteException;
		}

	}

	@Override
	public void deleteGarage(int garageId) {

		if (InputDataValidator.validate(garageId)) {

			Session session = HibernateUtils.getSessionFactory().openSession();

			Transaction transaction = session.getTransaction();

			try {
				transaction.begin();
				
				Query query = session.createQuery("delete Garage where garage_id = :garageId");

				query.setParameter("garageId", garageId);

				query.executeUpdate();

			} catch (HibernateException e) {
				if (transaction != null) {
					transaction.rollback();

					logger.error(
							"Exception occurs while transaction in deleteGarage method, transaction rollback." + e);
				}
			} finally {
				transaction.commit();
			}
		} else {

			GarageDeleteException garageDeleteException = new GarageDeleteException("Invalid input for delete Car", "");

			logger.error(garageDeleteException.toString());

			throw garageDeleteException;
		}

	}

	@Override
	public void deleteOwner(int ownerId) {

		if (InputDataValidator.validate(ownerId)) {

			Session session = HibernateUtils.getSessionFactory().openSession();

			Transaction transaction = session.getTransaction();

			try {
				transaction.begin();

				Query query = session.createQuery("delete Owner where owner_id = :ownerId");

				query.setParameter("ownerId", ownerId);

				query.executeUpdate();

			} catch (HibernateException e) {
				if (transaction != null) {
					transaction.rollback();

					logger.error("Exception occurs while transaction in deleteOwner method, transaction rollback." + e);
				}
			} finally {
				transaction.commit();
			}
		} else {

			OwnerDeleteException ownerDeleteException = new OwnerDeleteException("Invalid input for delete Car", "");

			logger.error(ownerDeleteException.toString());

			throw ownerDeleteException;
		}

	}
}