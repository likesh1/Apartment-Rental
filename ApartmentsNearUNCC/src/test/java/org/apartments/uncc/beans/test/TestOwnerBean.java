package org.apartments.uncc.beans.test;

import static org.junit.Assert.*;

import org.apartments.uncc.viewBeans.OwnerBean;
import org.apartments.uncc.viewBeans.RegistrationBean;
import org.aspectj.lang.annotation.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestOwnerBean {
	OwnerBean ownerBean;
	
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
		ownerBean=new OwnerBean();
	}

	@After(value = "")
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testOwnerId() {
		ownerBean.setOwnerId(1);
		assertEquals(1, ownerBean.getOwnerId());
	}
	
	@Test
	public void testPassword() {
		ownerBean.setoPassword("saranya");
		assertEquals("saranya", ownerBean.getoPassword());
	}
	
	@Test
	public void testFname() {
		ownerBean.setoFirstName("Saranya");
		assertEquals("Saranya", ownerBean.getoFirstName());
	}
	
	@Test
	public void testLname() {
		ownerBean.setoLastName("Prakash");
		assertEquals("Prakash", ownerBean.getoLastName());
	}
	
	@Test
	public void testEmail() {
		ownerBean.setoEmail("sprakash@uncc.edu");
		assertEquals("sprakash@uncc.edu", ownerBean.getoEmail());
	}
	
	@Test
	public void testPhone() {
		ownerBean.setoPhoneNo(1046453210);
		assertEquals(1046453210, ownerBean.getoPhoneNo());
	}

}
