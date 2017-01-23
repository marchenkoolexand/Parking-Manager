/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.entyty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@XmlRootElement
@Entity
@Table(name = "garage_table")
public class Garage {
	@Id
	@GenericGenerator(name = "idgen", strategy = "increment")
	@GeneratedValue(generator = "idgen")
	@Column(name = "garage_id", unique = true)
	private int id;

	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "building_number")
	private int buidingNumber;

	@OneToMany
	@JoinColumn(name = "garage_id")
	@Cascade(CascadeType.ALL)
	private List<Car> cars;

	public Garage() {
	}

	public Garage(String city, String street, int buidingNumber) {
		super();
		this.city = city;
		this.street = street;
		this.buidingNumber = buidingNumber;
		this.cars = new ArrayList<Car>();
	}

	@XmlElement(name = "id", required=true)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "city", required=true)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@XmlElement(name = "street", required=true)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@XmlElement(name = "building_number", required=true)
	public int getBuidingNumber() {
		return buidingNumber;
	}

	public void setBuidingNumber(int buidingNumber) {
		this.buidingNumber = buidingNumber;
	}

	@XmlElement(name = "cars", required=true)
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + buidingNumber;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + id;
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Garage other = (Garage) obj;
		if (buidingNumber != other.buidingNumber)
			return false;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id != other.id)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Garage Id = " + id + ", City = " + city + ", Street = " + street + ", Buiding Number = " + buidingNumber
				+ ", Cars = " + cars;
	}

}
