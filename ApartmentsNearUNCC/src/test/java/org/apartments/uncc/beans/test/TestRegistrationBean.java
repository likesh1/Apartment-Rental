package org.apartments.uncc.beans.test;

import static org.junit.Assert.*;

import org.apartments.uncc.viewBeans.OwnerBean;
import org.apartments.uncc.viewBeans.RegistrationBean;
import org.aspectj.lang.annotation.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRegistrationBean {
	RegistrationBean registrationBean;

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
		registrationBean=new RegistrationBean();
	}

	@After(value = "")
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testUserRole() {
		registrationBean.setUserRole("student");
		assertEquals("student", registrationBean.getUserRole());
	}
	
	@Test
	public void testPassword() {
		registrationBean.setPassword("khyati");
		assertEquals("khyati", registrationBean.getPassword());
	}
	
	@Test
	public void testFname() {
		registrationBean.setFname("khyati");
		assertEquals("khyati", registrationBean.getFname());
	}
	
	@Test
	public void testLname() {
		registrationBean.setLname("savakia");
		assertEquals("savakia", registrationBean.getLname());
	}
	
	@Test
	public void testEmail() {
		registrationBean.setEmail("ksavakia@uncc.edu");
		assertEquals("ksavakia@uncc.edu", registrationBean.getEmail());
	}	

}
