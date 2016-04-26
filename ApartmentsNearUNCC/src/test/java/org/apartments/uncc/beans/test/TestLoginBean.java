package org.apartments.uncc.beans.test;

import static org.junit.Assert.*;

import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.OwnerBean;
import org.aspectj.lang.annotation.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLoginBean {
	LoginBean loginBean;
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
		loginBean=new LoginBean();
	}

	
	@Test
	public void testUserName() {		
		loginBean.setUsername("ksavakia@uncc.edu");
		assertEquals("ksavakia@uncc.edu",loginBean.getUsername());
	}
	
	@Test
	public void testPassword() {
		loginBean.setPassword("khyati");
		assertEquals("khyati",loginBean.getPassword());
	}
	
	@After(value = "")
	public void tearDown() throws Exception {
		
	}
}
