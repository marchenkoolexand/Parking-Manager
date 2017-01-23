package com.company.parkingmanager.testdata;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.company.parkingmanager.dao.HibernateUtils;
import com.company.parkingmanager.entyty.Car;
import com.company.parkingmanager.entyty.Garage;
import com.company.parkingmanager.entyty.Owner;

public class DataGenerator {

	public static void addData() {
		Garage garage = new Garage("Lviv", "Naukova", 66);
		Garage garage2 = new Garage("Kharkiv", "Ivana Pidkovu", 11);
		Garage garage3 = new Garage("Kiev", "Zelena", 5);
		Garage garage4 = new Garage("Odesa", "Veluka", 9);
		Garage garage5 = new Garage("Ternopil", "Rankova", 987);

		Owner owner = new Owner("Ivan", "Kosach");
		Owner owner2 = new Owner("Victoria", "Bubon");
		Owner owner3 = new Owner("Ivan", "Zaharko");
		Owner owner4 = new Owner("Vasul", "Peretyatko");
		Owner owner5 = new Owner("Maria", "Hamhil");
		Owner owner6 = new Owner("Iruna", "Repenko");
		Owner owner7 = new Owner("Vadum", "Malunuk");
		Owner owner8 = new Owner("Svitlana", "Svatko");
		Owner owner9 = new Owner("Oleksandr", "Malashenko");
		Owner owner10 = new Owner("Mukhailo", "Golubka");

		Car car = new Car("BMW", "516", 2003, "DB5678KJ", "BLUE,", owner);
		Car car2 = new Car("KIA", "CERATO", 2010, "FG5672hj", "WHITE", owner2);
		Car car3 = new Car("TOYOTA", "LAND CRUSER 200", 2016, "CRUSER", "BLACK", owner3);
		Car car4 = new Car("DAEWOO", "LANOS", 1998, "UY8934UI", "BROWN", owner4);
		Car car5 = new Car("HONDA", "ACORD", 2015, "678GH", "WHITE", owner5);
		Car car6 = new Car("NISSAN", "LEAF", 2016, "LEAF666", "RED", owner6);
		Car car7 = new Car("FIAT", "LINEA", 2014, "REF89JN", "PURPLE", owner7);
		Car car8 = new Car("CHERY", "QQ", 2010, "OIHE67", "BLACK", owner8);
		Car car9 = new Car("FERRARI", "ITALIA 458", 2015, "ITALIA", "RED", owner9);
		Car car10 = new Car("CITROEN", "C4", 2016, "UI345MA", "GREEN", owner10);

		garage.getCars().add(car);
		garage.getCars().add(car2);
		garage2.getCars().add(car3);
		garage2.getCars().add(car4);
		garage3.getCars().add(car5);
		garage3.getCars().add(car6);
		garage4.getCars().add(car7);
		garage4.getCars().add(car8);
		garage5.getCars().add(car9);
		garage5.getCars().add(car10);

		Session session = HibernateUtils.getSessionFactory().openSession();

		Transaction transaction = session.getTransaction();

		try {
			transaction.begin();
			
			session.save(garage);
			session.save(garage2);
			session.save(garage3);
			session.save(garage4);
			session.save(garage5);
			
		} catch (HibernateException e) {
			
			transaction.rollback();
			
		} finally {
			
			transaction.commit();
		}
	}
}
