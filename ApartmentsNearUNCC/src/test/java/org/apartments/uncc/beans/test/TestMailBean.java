package org.apartments.uncc.beans.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apartments.uncc.viewBeans.FilterBean;
import org.apartments.uncc.viewBeans.ForumAnswersBean;
import org.apartments.uncc.viewBeans.ForumQuestionsBean;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.MailBean;
import org.apartments.uncc.viewBeans.OwnerBean;
import org.aspectj.lang.annotation.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMailBean {
	MailBean mailBean;
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
		mailBean=new MailBean();
	}
	
	@Test
	public void testEmail() {
		
		mailBean.setTo("ksavakia@uncc.edu");
		assertEquals("ksavakia@uncc.edu",mailBean.getTo());
	}
	
	@Test
	public void testMailbody() {
		
		mailBean.setMailbody("Dear Sir, Good Morning!");
		assertEquals("Dear Sir, Good Morning!",mailBean.getMailbody());
	}
	
	@After(value = "")
	public void tearDown() throws Exception {
		
	}
}
