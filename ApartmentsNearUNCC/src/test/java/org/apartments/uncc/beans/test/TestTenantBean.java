package org.apartments.uncc.beans.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.apartments.uncc.viewBeans.ApartmentDetailsBean;
import org.apartments.uncc.viewBeans.TenantBean;
import org.aspectj.lang.annotation.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTenantBean {
	TenantBean tenantBean;
	
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
		tenantBean=new TenantBean();
	}
		
	@Test
	public void testTenantId() {
		tenantBean.setTenantId(1);
		assertEquals(1, tenantBean.getTenantId());
	}
	
	@Test
	public void testApartmentId() {
		tenantBean.setApartmentId(1);
		assertEquals(1, tenantBean.getApartmentId());
	}	

	@Test
	public void testFname() {
		tenantBean.setTfirstName("khyati");
		assertEquals("khyati", tenantBean.getTfirstName());
	}
	
	@Test
	public void testLname() {
		tenantBean.setTlastName("savakia");
		assertEquals("savakia", tenantBean.getTlastName());
	}
	
	@Test
	public void testGender() {
		tenantBean.setTgender("Female");
		assertEquals("Female", tenantBean.getTgender());
	}
	
	@Test
	public void testAge() {
		tenantBean.setTage(23);
		assertEquals(23, tenantBean.getTage());
	}
	
	@Test
	public void testEmail() {
		tenantBean.settEmail("ksavakia@uncc.edu");
		assertEquals("ksavakia@uncc.edu", tenantBean.gettEmail());
	}
	
	@After(value = "")
	public void tearDown() throws Exception {
		
	}
}
