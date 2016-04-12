/**
 * 
 */
package org.apartments.uncc.service.impl;

import java.sql.SQLException;

import org.apartments.uncc.dao.UserDao;
import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.service.UserService;
import org.apartments.uncc.utilities.ICodeGenerator;
import org.apartments.uncc.utilities.ISendEmail;
import org.apartments.uncc.viewBeans.MailBean;
import org.apartments.uncc.viewBeans.RegistrationBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;

/**
 * @author Pritam
 *
 */
public class UserServiceImpl implements UserService {

	/* (non-Javadoc)
	 * @see org.apartments.uncc.service.UserService#isValidUser(java.lang.String, java.lang.String)
	 */
	
	


	private UserDao userDao;
	private ICodeGenerator codeGenerator;
	private ISendEmail sendMail;
	
	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ICodeGenerator getCodeGenerator() {
		return codeGenerator;
	}


	public void setCodeGenerator(ICodeGenerator codeGenerator) {
		this.codeGenerator = codeGenerator;
	}

	public ISendEmail getSendMail() {
		return sendMail;
	}


	public void setSendMail(ISendEmail sendMail) {
		this.sendMail = sendMail;
	}


	@Override
	public boolean isValidUser(String username, String password) throws SQLException{
		// TODO Auto-generated method stub
		return userDao.isValidUser(username, password);
	}


	@Override
	public boolean isValidRegistration(RegistrationBean registrationBean) throws SQLException, InvalidEmailIdException {
		// TODO Auto-generated method stub
		return userDao.isValidRegistration(registrationBean);
	}


	@Override
	public int getVerificationCode() {
		// TODO Auto-generated method stub
		return codeGenerator.getVerificationCode();
	}


	@Override
	public void sendVerificationMail(UserDetailsBean userDetails) {
		// TODO Auto-generated method stub
		sendMail.sendEmail(userDetails);
	}
	
	@Override
	public void sendEnquiryMail(MailBean mailBean) {
		// TODO Auto-generated method stub
		sendMail.sendEmail(mailBean);
	}

}
