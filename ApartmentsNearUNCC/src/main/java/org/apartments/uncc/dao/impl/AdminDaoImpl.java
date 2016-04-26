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
		String query = "select email_id from login where userRole=?;";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, "owner");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			owner.add(rs.getString("email_id"));
		}
		return owner;
	} 
}
