package org.apartments.uncc.beans.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apartments.uncc.viewBeans.FilterBean;
import org.apartments.uncc.viewBeans.ForumAnswersBean;
import org.apartments.uncc.viewBeans.ForumQuestionsBean;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.OwnerBean;
import org.aspectj.lang.annotation.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAnswersBean {
	ForumAnswersBean forumAnswersBean;
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
		forumAnswersBean=new ForumAnswersBean();
	}

	
	@Test
	public void testQno() {
		
		forumAnswersBean.setQno(1);
		assertEquals(1,forumAnswersBean.getQno());
	}
	
	@Test
	public void testReply() {
		
		forumAnswersBean.setReply("Yeah!!");
		assertEquals("Yeah!!",forumAnswersBean.getReply());
	}
	
	@Test
	public void testFname() {
		
		forumAnswersBean.setFname("Khyati");
		assertEquals("Khyati",forumAnswersBean.getFname());
	}
	
	@Test
	public void testEmail() {
		
		forumAnswersBean.setEmail("ksavakia@uncc.edu");
		assertEquals("ksavakia@uncc.edu",forumAnswersBean.getEmail());
	}
	
	@After(value = "")
	public void tearDown() throws Exception {
		
	}
}
