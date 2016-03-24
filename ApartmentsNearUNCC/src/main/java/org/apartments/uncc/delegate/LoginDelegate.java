/**
 * 
 */
package org.apartments.uncc.delegate;

import java.sql.SQLException;

import org.apartments.uncc.service.UserService;

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
	
	public boolean isValidUser(String username, String password) throws SQLException
	{
	     return userService.isValidUser(username, password);
	}

}
