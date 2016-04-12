package org.apartments.uncc.dao;

import java.sql.SQLException;

import org.apartments.uncc.exceptions.InvalidCredentialsException;
import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.RegistrationBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;

/**
 * @author Pritam Borate
 * This interface will be used to communicate with the
 * Database
 */
public interface UserDao
{
		public UserDetailsBean isValidUser(LoginBean loginBean) throws SQLException, InvalidCredentialsException;

		public boolean isValidRegistration(RegistrationBean registratinBean)throws SQLException, InvalidEmailIdException;

		public void activateAccount(String username);
}
