package org.apartments.uncc.delegate;

import java.sql.SQLException;

import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.service.UserService;
import org.apartments.uncc.viewBeans.RegistrationBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;

public class RegistrationDelegate {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public boolean isValidRegistration(RegistrationBean registrationBean) throws SQLException, InvalidEmailIdException
	{
	     return userService.isValidRegistration(registrationBean);
	}

	public int getVerificationCode()
	{
		return userService.getVerificationCode();
	}

	public void sendVerificationMail(UserDetailsBean userDetails) {
		// TODO Auto-generated method stub
		userService.sendVerificationMail(userDetails);
	}

}
