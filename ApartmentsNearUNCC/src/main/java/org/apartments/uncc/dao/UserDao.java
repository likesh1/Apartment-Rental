package org.apartments.uncc.dao;

import java.sql.SQLException;

import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.viewBeans.RegistrationBean;

/**
 * @author Pritam Borate
 * This interface will be used to communicate with the
 * Database
 */
public interface UserDao
{
		public boolean isValidUser(String username, String password) throws SQLException;

		public boolean isValidRegistration(RegistrationBean registratinBean)throws SQLException, InvalidEmailIdException;
}
