/**
 * 
 */
package org.apartments.uncc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apartments.uncc.dao.UserDao;

/**
 * @author Pritam Borate
 *
 */
public class UserDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see org.apartments.uncc.dao.UserDao#isValidUser(java.lang.String, java.lang.String)
	 */
	
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
	public boolean isValidUser(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		String query = "Select count(1) from students where sEmail = ? and sPassword = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
				return (resultSet.getInt(1) > 0);
		else
				return false;
		//return false;
	}

}
