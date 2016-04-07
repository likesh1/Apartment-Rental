/**
 * 
 */
package org.apartments.uncc.dao.impl.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apartments.uncc.dao.UserDao;
import org.apartments.uncc.dao.impl.UserDaoImpl;
import org.apartments.uncc.dao.impl.stub.UserDaoImplStub;
import org.apartments.uncc.dao.impl.stub.UserDaoStub;
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.apartments.uncc.dao.impl.UserDaoImpl#isValidUser(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testIsValidUser() {
		try {
			System.out.println("Its Working!!!");
			System.out.println("------"+userDao.isValidUser("pborate@uncc.edu", "pritam"));
			assertFalse("Test case Failed",userDao.isValidUser("pborate@uncc.edu", "pritam123"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fail("Not yet implemented");
	}

}
