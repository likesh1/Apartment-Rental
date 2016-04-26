/**
 * 
 */
package org.apartments.uncc.controllers.test;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apartments.uncc.controllers.HomeController;
import org.apartments.uncc.controllers.UserController;
import org.apartments.uncc.viewBeans.ForumAnswersBean;
import org.apartments.uncc.viewBeans.ForumQuestionsBean;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

/**
 * @author Pritam
 *
 */
@SessionAttributes({"questions"})
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
    @Autowired
	DataSource dataSource;
    
    
    @Autowired
	UserController userController;
    private ForumQuestionsBean forumQuestionBean;
    private ForumAnswersBean forumAnswersBean;
    private MockMvc mockMvc2;
    
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
		
		forumQuestionBean=new ForumQuestionsBean();
		forumAnswersBean=new ForumAnswersBean();
		mockMvc2=MockMvcBuilders.standaloneSetup(userController).build();
		
		PreparedStatement pst1=dataSource.getConnection().prepareStatement("insert into questions(description,fname,email) values"
				+ "(\"What is the utility amount?\",\"Khyati\",\"ksavakia@uncc.edu\"),"
				+ ""+"(\"Can two people share a room?\",\"Saranya\",\"sprabhu1@uncc.edu\"),"
				+ ""+"(\"How many months is the lease?\",\"Pritam\",\"pborate@uncc.edu\")");
		pst1.executeUpdate();
		
		String query = "Select * from questions";
		
		ResultSet rs=null;
		List<ForumQuestionsBean> questionList = new ArrayList<ForumQuestionsBean>();
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			ForumQuestionsBean questions = new ForumQuestionsBean();
			questions.setQno(rs.getInt("qno"));
			questions.setDescription(rs.getString("description"));
			questions.setFname(rs.getString("fname"));
			questions.setEmail(rs.getString("email"));
			questionList.add(questions);
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("question", questionList);
		
		
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
        .andExpect(view().name("home"));

	}
	 
	@Test
	public void testLoginDoForInValidLoginDetails() throws Exception{
		loginBean.setUsername("pborate1@uncc.edu");
		loginBean.setPassword("pritam");
		//final ModelAndView model=handlerAdapter.handle(request, response,homeController);
		mockMvc.perform(post("/login.do").flashAttr("loginBean", loginBean)).andExpect(status().isOk())
        .andExpect(view().name("home"));

	}
	
	//test successful
	@Test
	public void testForumQuestion() throws Exception{
		
		request.setRequestURI("/discussionforum.do");
		request.setMethod("GET");
		final ModelAndView model=handlerAdapter.handle(request, response, userController);
		assertEquals("discussionForum", model.getViewName());
	}
	
	@Test
	public void testRedirectForumQuestion() throws Exception{
		
		forumQuestionBean.setQno(9);
		forumQuestionBean.setEmail("pborate@uncc.edu");
		forumQuestionBean.setDescription("How far are the shopping malls");
		forumQuestionBean.setFname("pritam");
		
		//final ModelAndView model=handlerAdapter.handle(request, response,homeController);
		mockMvc.perform(post("/addquestion").flashAttr("questionbean", forumQuestionBean)).andExpect(status().isOk())
        .andExpect(redirectedUrl("/forum"));
	}
	
	//successful test
	@Test
	public void testForumAddNewQuestion() throws Exception{
		
		forumQuestionBean.setQno(9);
		forumQuestionBean.setEmail("pborate@uncc.edu");
		forumQuestionBean.setDescription("How far are the shopping malls");
		forumQuestionBean.setFname("pritam");
		
		request.setRequestURI("/forum");
		request.setMethod("GET");
		final ModelAndView model=handlerAdapter.handle(request, response, userController);
		model.addObject("questionbean", forumQuestionBean);
		assertEquals("discussionForum", model.getViewName());
	}
	
	@Test
	public void testForumAnswers() throws Exception{
		
		HttpSession session=request.getSession();
		session.getAttribute("question");
		mockMvc.perform(get("/answers.do?qno=1")).andExpect(status().isOk())
        .andExpect(view().name("answers"));
	}
	
	

}
