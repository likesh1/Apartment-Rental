package org.apartments.uncc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apartments.uncc.dao.ApartmentDao;
import org.apartments.uncc.viewBeans.ApartmentDetailsBean;

public class ApartmentDaoImpl implements ApartmentDao{

	DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<ApartmentDetailsBean> getApartmentList() {
		// TODO Auto-generated method stub
		List<ApartmentDetailsBean> apartment = new ArrayList<ApartmentDetailsBean>();
		String query = "Select * from Apartments";
		//Connection con = DatabaseConnection.connect();
		
		ResultSet rs=null;
//		PreparedStatement pstmt=null;
		System.out.println("Inside AparmentDaoImpl");
		try {
		
			//pstmt = con.prepareStatement(query);
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				ApartmentDetailsBean apt = new ApartmentDetailsBean();
				apt.setApartmentId(rs.getInt("apartmentId"));
				apt.setDepositAmt(rs.getInt("depositAmt"));
				apt.setRent(rs.getInt("rent"));
				apt.setAvailablityFrom(rs.getDate("availablityFrom"));
				apt.setUtilities(rs.getString("utilities"));
				apt.setArea(rs.getString("area"));
				apt.setStreet(rs.getString("street"));
				apt.setDoorNo(rs.getString("doorNo"));
				apt.setCity(rs.getString("city"));
				apt.setno_of_rooms(rs.getInt("no_of_rooms"));
				apt.setno_of_bathroom(rs.getInt("no_of_bathroom"));
				apt.setFlooring(rs.getString("flooring"));
				apartment.add(apt);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			
		}

		return apartment;
	}
	/*
	public List<ApartmentDetailsBean> aparmentAll() throws SQLException {
		
		List<ApartmentDetailsBean> apartment = new ArrayList<ApartmentDetailsBean>();
		String query = "Select * from Apartments";
		Connection con = DatabaseConnection.connect();
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		System.out.println("Inside AparmentDaoImpl");
		try {
		
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ApartmentDetailsBean apt = new ApartmentDetailsBean();
				apt.setApartmentId(rs.getInt("apartmentId"));
				apt.setDepositAmt(rs.getInt("depositAmt"));
				apt.setRent(rs.getInt("rent"));
				apt.setAvailablityFrom(rs.getDate("availablityFrom"));
				apt.setUtilities(rs.getString("utilities"));
				apt.setArea(rs.getString("area"));
				apt.setStreet(rs.getString("street"));
				apt.setDoorNo(rs.getString("doorNo"));
				apt.setCity(rs.getString("city"));
				apt.setno_of_rooms(rs.getInt("no_of_rooms"));
				apt.setno_of_bathroom(rs.getInt("no_of_bathroom"));
				apt.setFlooring(rs.getString("flooring"));
				apartment.add(apt);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			
		}

		return apartment;
	
	}*/

}