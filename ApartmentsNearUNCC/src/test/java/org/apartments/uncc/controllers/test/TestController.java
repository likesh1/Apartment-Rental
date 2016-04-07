/**
 * 
 */
package org.apartments.uncc.controllers.test;

import static org.junit.Assert.*;

import java.util.Locale;

import org.apartments.uncc.controllers.HomeController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
    @Autowired
	HomeController homeController;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private HandlerAdapter handlerAdapter;
    private Locale locale;
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
		request=new MockHttpServletRequest();
		response= new MockHttpServletResponse();
		handlerAdapter=new AnnotationMethodHandlerAdapter();
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

}
