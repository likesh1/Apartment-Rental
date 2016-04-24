package org.apartments.uncc.viewBeans;

import java.util.Date;


public class ApartmentDetailsBean {
	
	private int apartmentId;
	private int depositAmt;
	private int rent;
	private Date availablityFrom;
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String utilities;
	private String area;
	private String street;
	private String doorNo;
	private String city;
	private int no_of_rooms;
	private int no_of_bathroom;
	private String flooring;
	private String type_bathroom;
	
	public String getType_bathroom() {
		return type_bathroom;
	}
	public void setType_bathroom(String type_bathroom) {
		this.type_bathroom = type_bathroom;
	}
	
	public int getApartmentId() {
		return apartmentId;
	}
	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}
	public int getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(int depositAmt) {
		this.depositAmt = depositAmt;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public Date getAvailablityFrom() {
		return availablityFrom;
	}
	public void setAvailablityFrom(Date availablityFrom) {
		this.availablityFrom = availablityFrom;
	}
	public String getUtilities() {
		return utilities;
	}
	public void setUtilities(String utilities) {
		this.utilities = utilities;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getno_of_rooms() {
		return no_of_rooms;
	}
	public void setno_of_rooms(int no_of_rooms) {
		this.no_of_rooms = no_of_rooms;
	}
	public int getno_of_bathroom() {
		return no_of_bathroom;
	}
	public void setno_of_bathroom(int no_of_bathroom) {
		this.no_of_bathroom = no_of_bathroom;
	}
	public String getFlooring() {
		return flooring;
	}
	public void setFlooring(String flooring) {
		this.flooring = flooring;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + apartmentId;
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
		ApartmentDetailsBean other = (ApartmentDetailsBean) obj;
		if (apartmentId != other.apartmentId)
			return false;
		return true;
	}
	
	
	
}