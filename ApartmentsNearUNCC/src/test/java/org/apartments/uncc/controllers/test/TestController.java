/**
 * 
 */
package org.apartments.uncc.controllers.test;

import static org.junit.Assert.*;

import java.util.Locale;

import org.apartments.uncc.controllers.HomeController;
import org.apartments.uncc.viewBeans.LoginBean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

/**
 * @author Pritam
 *
 */

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml","file:src/test/resources/root-context-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestController {

	/**
	 * @throws java.lang.Exception
	 */
	
	@Autowired
    ApplicationContext applicationContext;
    @InjectMocks
	@Autowired
	HomeController homeController;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private HandlerAdapter handlerAdapter;
    private Locale locale;
    private LoginBean loginBean;
    private MockMvc mockMvc;
    
    //private Model model;
     
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 MockitoAnnotations.initMocks(this);
		request=new MockHttpServletRequest();
		response= new MockHttpServletResponse();
		handlerAdapter=new AnnotationMethodHandlerAdapter();
		loginBean=new LoginBean();
		mockMvc=MockMvcBuilders.standaloneSetup(homeController).build();
		//handlerAdapter.
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.apartments.uncc.controllers.HomeController#welcomeGuest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletRequest)}.
	 * @throws Exception 
	 */
	@Test
	public void testHome() throws Exception {
		request.setRequestURI("/welcomeGuest");
		request.setMethod("GET");
		final ModelAndView model=handlerAdapter.handle(request, response, homeController);
		assertEquals("welcomeGuest", model.getViewName());
		//fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link org.apartments.uncc.controllers.HomeController#login.do(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletRequest, org.apartments.uncc.viewBeans.LoginBean)}.
	 * @throws Exception 
	 */
	@Test
	public void testLoginDoForValidLoginDetails() throws Exception{
		loginBean.setUsername("pborate@uncc.edu");
		loginBean.setPassword("pritam");
		//final ModelAndView model=handlerAdapter.handle(request, response,homeController);
		mockMvc.perform(post("/login.do").flashAttr("loginBean", loginBean)).andExpect(status().isOk())
        .andExpect(view().name("welcomeStudent"));

	}
	
	@Test
	public void testLoginDoForInValidLoginDetails() throws Exception{
		loginBean.setUsername("pborate1@uncc.edu");
		loginBean.setPassword("pritam");
		//final ModelAndView model=handlerAdapter.handle(request, response,homeController);
		mockMvc.perform(post("/login.do").flashAttr("loginBean", loginBean)).andExpect(status().isOk())
        .andExpect(view().name("home"));

	}

}
