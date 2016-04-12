/**
 * 
 */
package org.apartments.uncc.service;

import java.sql.SQLException;

import org.apartments.uncc.exceptions.InvalidCredentialsException;
import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.RegistrationBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;

/**
 * @author Pritam
 *
 */
public interface UserService {
	public UserDetailsBean isValidUser(LoginBean loginBean) throws SQLException, InvalidCredentialsException;
	public boolean isValidRegistration(RegistrationBean registratinBean)throws SQLException,InvalidEmailIdException;
	public int getVerificationCode();
	public void sendVerificationMail(UserDetailsBean userDetails);
	public void activateAccount(String username);
}
