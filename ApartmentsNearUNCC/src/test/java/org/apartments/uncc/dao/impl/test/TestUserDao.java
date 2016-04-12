/**
 * 
 */
package org.apartments.uncc.dao.impl.test;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apartments.uncc.dao.UserDao;
import org.apartments.uncc.dao.impl.UserDaoImpl;
import org.apartments.uncc.dao.impl.stub.UserDaoImplStub;
import org.apartments.uncc.dao.impl.stub.UserDaoStub;
import org.apartments.uncc.exceptions.InvalidCredentialsException;
import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.RegistrationBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.*;
/**
 * @author Pritam
 *
 */


@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml","file:src/test/resources/root-context-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserDao {
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private UserDao userDao;
	@Autowired
	DataSource dataSource;
	private UserDetailsBean userBean;
	private LoginBean loginBean;
	private RegistrationBean registrationBean;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//userDao=new UserDaoImpl();
		PreparedStatement pst=dataSource.getConnection().prepareStatement("insert into login(email_id,password,userRole) values(\"pritam.borate16@gmail.com\",\"pritam\",\"student\")");
		pst.executeUpdate();
		loginBean=new LoginBean();
		loginBean.setUsername("pritam.borate16@gmail.com");
		loginBean.setPassword("pritam");
		//PreparedStatement pstmt=dataSource.getConnection().prepareStatement("");
		registrationBean=new RegistrationBean();
		registrationBean.setEmail("test123@test.com");
		registrationBean.setFname("Test");
		registrationBean.setLname("Name");
		registrationBean.setPassword("Dummy");
		registrationBean.setUserRole("owner");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		PreparedStatement pstmt=dataSource.getConnection().prepareStatement("delete from apartmentOwner where oemail=\"test123@test.com\"");
		pstmt.executeUpdate();
		PreparedStatement pst=dataSource.getConnection().prepareStatement("delete from login where email_id IN (\"pritam.borate16@gmail.com\",\"test123@test.com\")");
		pst.executeUpdate();
	}
	/**
	 * Test method for {@link org.apartments.uncc.dao.impl.UserDaoImpl#isValidRegistration(org.apartments.uncc.viewBeans.RegistrationBean)}.
	 * @throws InvalidEmailIdException 
	 * @throws SQLException  
	 */
	@Test
	public void testIsValidRegistration() throws SQLException, InvalidEmailIdException{
		System.out.println("---Registration successful---"+userDao.isValidRegistration(registrationBean));
		PreparedStatement pstmt=dataSource.getConnection().prepareStatement("select email_id from login where email_id=\"test123@test.com\"");
		ResultSet resultSet=pstmt.executeQuery();
		String login_email_id="",owner_email="";
		while(resultSet.next())
			{
				login_email_id=resultSet.getString(1) ;
			}
		pstmt=dataSource.getConnection().prepareStatement("select oemail from apartmentOwner where oemail=\"test123@test.com\"");
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			owner_email=rs.getString(1);
		}
		assertEquals("test123@test.com", login_email_id);
		assertEquals("test123@test.com", owner_email);
		
	}
	

	/**
	 * Test method for {@link org.apartments.uncc.dao.impl.UserDaoImpl#isValidUser(java.lang.String, java.lang.String)}.
	 * @throws InvalidCredentialsException 
	 */
	@Test
	public void testIsValidUser() throws InvalidCredentialsException {
		try {
			//System.out.println("Its Working!!!");
			System.out.println("------"+userDao.isValidUser(loginBean));
			assertEquals("Login Successful!!!","pritam.borate16@gmail.com",userDao.isValidUser(loginBean).getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fail("Not yet implemented");
	}

}
