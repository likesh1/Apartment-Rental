/**
 * 
 */
package org.apartments.uncc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apartments.uncc.dao.UserDao;
import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.viewBeans.RegistrationBean;

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
		String query = "Select count(1) from user_details where username = ? and password = ?";
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

	@Override
	public boolean isValidRegistration(RegistrationBean registratinBean) throws SQLException, InvalidEmailIdException{
		// TODO Auto-generated method stub
		String query = "Select count(1) from user_details where semail = ?";
		PreparedStatement pstmt;
		try {
			pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, registratinBean.getEmail());
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next())
				throw new InvalidEmailIdException("Email Id already exist, Please Use another email id.");
			else
					return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

}
