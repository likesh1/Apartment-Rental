package org.apartments.uncc.beans.test;

import static org.junit.Assert.*;

import org.apartments.uncc.viewBeans.ApartmentReviewBean;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.OwnerBean;
import org.aspectj.lang.annotation.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestApartmentReviewBean {
	ApartmentReviewBean apartmentReviewBean;
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
		apartmentReviewBean=new ApartmentReviewBean();
	}

	@Test
	public void testRating() {
		apartmentReviewBean.setRating(3);
		assertEquals(3, apartmentReviewBean.getRating());
	}
	
	@Test
	public void testComment() {
		apartmentReviewBean.setComments("Its amazing");
		assertEquals("Its amazing", apartmentReviewBean.getComments());
	}
	
	@After(value = "")
	public void tearDown() throws Exception {
		
	}
}
