package org.apartments.uncc.beans.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.apartments.uncc.viewBeans.ApartmentDetailsBean;
import org.aspectj.lang.annotation.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestApartmentDetailsBean {
	ApartmentDetailsBean apartmentDetailsBean;
	
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
		apartmentDetailsBean=new ApartmentDetailsBean();
	}
		
	@Test
	public void testApartmentId() {
		apartmentDetailsBean.setApartmentId(1);
		assertEquals(1, apartmentDetailsBean.getApartmentId());
	}
	
	@Test
	public void testDepositAmount() {
		apartmentDetailsBean.setDepositAmt(400);
		assertEquals(400, apartmentDetailsBean.getDepositAmt());
	}
	
	@Test
	public void testRent() {
		apartmentDetailsBean.setRent(350);
		assertEquals(350, apartmentDetailsBean.getRent());
	}
	
	@Test
	public void testavailablityFrom() {
		
		java.util.Date date = new Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		apartmentDetailsBean.setDate(sqlDate.toString());
		assertEquals(sqlDate.toString(), apartmentDetailsBean.getDate());
	}
	
	@Test
	public void testUtilities() {
		apartmentDetailsBean.setUtilities("Internet,Water and electricity");
		assertEquals("Internet,Water and electricity", apartmentDetailsBean.getUtilities());
	}
	@Test
	public void testArea() {
		apartmentDetailsBean.setArea("UT Drive");
		assertEquals("UT Drive", apartmentDetailsBean.getArea());
	}
	
	@Test
	public void testStreet() {
		apartmentDetailsBean.setStreet("University City");
		assertEquals("University City", apartmentDetailsBean.getStreet());
	}

	@Test
	public void testDoorNo() {
		apartmentDetailsBean.setDoorNo("9548B");
		assertEquals("9548B", apartmentDetailsBean.getDoorNo());
	}
	
	@Test
	public void testCity() {
		apartmentDetailsBean.setCity("Charlotte");
		assertEquals("Charlotte", apartmentDetailsBean.getCity());
	}
	
	@Test
	public void testNo_of_rooms() {
		apartmentDetailsBean.setno_of_bathroom(4);
		assertEquals(4, apartmentDetailsBean.getno_of_bathroom());
	}
	
	@Test
	public void testNo_of_bathroom() {
		apartmentDetailsBean.setno_of_bathroom(2);
		assertEquals(2, apartmentDetailsBean.getno_of_bathroom());
	}
	
	@Test
	public void testFlooring() {
		apartmentDetailsBean.setFlooring("Wooden");
		assertEquals("Wooden", apartmentDetailsBean.getFlooring());
	}
	
	@Test
	public void testType_Bathroom() {
		apartmentDetailsBean.setType_bathroom("Common");
		assertEquals("Common", apartmentDetailsBean.getType_bathroom());
	}
	
	@After(value = "")
	public void tearDown() throws Exception {
		
	}
}
