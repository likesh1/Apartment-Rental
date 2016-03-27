/**
 * 
 */
package org.apartments.uncc.service.impl;

import java.sql.SQLException;

import org.apartments.uncc.dao.UserDao;
import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.service.UserService;
import org.apartments.uncc.viewBeans.RegistrationBean;

/**
 * @author Pritam
 *
 */
public class UserServiceImpl implements UserService {

	/* (non-Javadoc)
	 * @see org.apartments.uncc.service.UserService#isValidUser(java.lang.String, java.lang.String)
	 */
	
	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public boolean isValidUser(String username, String password) throws SQLException{
		// TODO Auto-generated method stub
		return userDao.isValidUser(username, password);
	}


	@Override
	public boolean isValidRegistration(RegistrationBean registratinBean) throws SQLException, InvalidEmailIdException {
		// TODO Auto-generated method stub
		return userDao.isValidRegistration(registratinBean);
	}

}
