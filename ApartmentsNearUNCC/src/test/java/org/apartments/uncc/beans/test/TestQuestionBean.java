package org.apartments.uncc.beans.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apartments.uncc.viewBeans.FilterBean;
import org.apartments.uncc.viewBeans.ForumQuestionsBean;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.OwnerBean;
import org.aspectj.lang.annotation.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestQuestionBean {
	ForumQuestionsBean forumQuestionsBean;
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
		forumQuestionsBean=new ForumQuestionsBean();
	}

	
	@Test
	public void testQno() {
		
		forumQuestionsBean.setQno(1);
		assertEquals(1,forumQuestionsBean.getQno());
	}
	
	@Test
	public void testDescription() {
		
		forumQuestionsBean.setDescription("Can we share the room?");
		assertEquals("Can we share the room?",forumQuestionsBean.getDescription());
	}
	
	@Test
	public void testFname() {
		
		forumQuestionsBean.setFname("Khyati");
		assertEquals("Khyati",forumQuestionsBean.getFname());
	}
	
	@Test
	public void testEmail() {
		
		forumQuestionsBean.setEmail("ksavakia@uncc.edu");
		assertEquals("ksavakia@uncc.edu",forumQuestionsBean.getEmail());
	}
	
	@After(value = "")
	public void tearDown() throws Exception {
		
	}
}
