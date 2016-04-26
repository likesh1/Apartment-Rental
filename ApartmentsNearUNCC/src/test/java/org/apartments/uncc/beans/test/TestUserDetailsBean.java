package org.apartments.uncc.beans.test;

import static org.junit.Assert.*;

import org.apartments.uncc.viewBeans.OwnerBean;
import org.apartments.uncc.viewBeans.RegistrationBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;
import org.aspectj.lang.annotation.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUserDetailsBean {
	UserDetailsBean userDetailsBean;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
		
	@Before
	public void setUp() throws Exception {
		userDetailsBean=new UserDetailsBean();
	}

	@After(value = "")
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testUserRole() {
		userDetailsBean.setUserRole("student");
		assertEquals("student", userDetailsBean.getUserRole());
	}
		
	@Test
	public void testFname() {
		userDetailsBean.setfName("khyati");
		assertEquals("khyati", userDetailsBean.getfName());
	}
	
	@Test
	public void testVerificationCode() {
		userDetailsBean.setVerificationCode(12344);
		assertEquals(12344, userDetailsBean.getVerificationCode());
	}
	
	@Test
	public void testUserName() {
		userDetailsBean.setUsername("ksavakia@uncc.edu");
		assertEquals("ksavakia@uncc.edu", userDetailsBean.getUsername());
	}	

}
