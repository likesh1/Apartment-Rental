package org.apartments.uncc.beans.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apartments.uncc.viewBeans.FilterBean;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.OwnerBean;
import org.aspectj.lang.annotation.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFilterBean {
	FilterBean filterBean;
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
		filterBean=new FilterBean();
	}

	
	@Test
	public void testBathFilter() {
		List<String> bathFilter = new ArrayList<String>();
		bathFilter.add("Common");
		bathFilter.add("Attached");
		
		filterBean.setBathFilter(bathFilter);
		assertEquals(2,filterBean.getBathFilter().size());
	}
	
	@Test
	public void testFloorFilter() {
		List<String> floorFilter = new ArrayList<String>();
		floorFilter.add("Wooden");
		floorFilter.add("Carpet");
		
		filterBean.setFloorFilter(floorFilter);
		assertEquals(2,filterBean.getFloorFilter().size());
	}
	
	@Test
	public void testRentFilter() {
		List<String> rentFilter = new ArrayList<String>();
		rentFilter.add("$200-$300");
		rentFilter.add("$300-$400");
		rentFilter.add("$400-$500");
		
		filterBean.setRentFilter(rentFilter);
		assertEquals(3,filterBean.getRentFilter().size());
	}
	
	@Test
	public void testRoomFilter() {
		List<Integer> roomFilter = new ArrayList<Integer>();
		roomFilter.add(3);
		roomFilter.add(4);
		roomFilter.add(1);
		roomFilter.add(2);
		
		filterBean.setRoomFilter(roomFilter);
		assertEquals(4,filterBean.getRoomFilter().size());
	}
	
	@After(value = "")
	public void tearDown() throws Exception {
		
	}
}
