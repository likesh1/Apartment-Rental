package org.apartments.uncc.delegate;

import java.sql.SQLException;

import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.service.UserService;
import org.apartments.uncc.viewBeans.MailBean;
import org.apartments.uncc.viewBeans.RegistrationBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;

public class MailDelegate {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void sendEnquiryMail(MailBean mailBean) {
		// TODO Auto-generated method stub
		userService.sendEnquiryMail(mailBean);
	}

}
