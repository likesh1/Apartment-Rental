/**
 * 
 */
package org.apartments.uncc.delegate;

import java.sql.SQLException;

import org.apartments.uncc.exceptions.InvalidCredentialsException;
import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.service.UserService;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;

/**
 * @author Pritam
 *
 */
public class LoginDelegate {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public UserDetailsBean isValidUser(LoginBean loginBean) throws SQLException, InvalidCredentialsException
	{
	     return userService.isValidUser(loginBean);
	}

	public void activateAccount(String username) {
		// TODO Auto-generated method stub
		userService.activateAccount(username);
	}

}
