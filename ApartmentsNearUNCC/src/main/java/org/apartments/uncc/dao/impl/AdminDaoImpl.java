package org.apartments.uncc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apartments.uncc.dao.AdminDao;


public class AdminDaoImpl implements AdminDao {


	
	DataSource dataSource;

	public DataSource getDataSource()
	{
			return this.dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
			this.dataSource = dataSource;
	}
	
	@Override
	public List<String> listOfOwner() throws SQLException {
		// TODO Auto-generated method stub
		List<String> owner=new ArrayList<String>();
		String query = "select oEmail from ApartmentOwner where oIsActive=?";
		try {
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setBoolean(1, false);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			owner.add(rs.getString("oEmail"));
		}
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		System.out.println("hiiikkshkjbk");
		return owner;
	}

	@Override
	public boolean makeOwnerActive(String email) {
		// TODO Auto-generated method stub
		
		String query = "Update ApartmentOwner set oIsActive=true where oEmail=?";
		try {
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);
		int rs = pstmt.executeUpdate();
		if (rs>0) {
			return true;
		}
			
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
		
		return false;
	} 
}
