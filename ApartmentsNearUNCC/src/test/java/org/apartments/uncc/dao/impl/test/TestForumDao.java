package org.apartments.uncc.dao.impl.test;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apartments.uncc.dao.ForumAnswersDao;
import org.apartments.uncc.dao.ForumQuestionsDao;
import org.apartments.uncc.exceptions.ErrorInAddingQuestion;
import org.apartments.uncc.exceptions.ErrorInAddingReply;
import org.apartments.uncc.viewBeans.ForumAnswersBean;
import org.apartments.uncc.viewBeans.ForumQuestionsBean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml","file:src/test/resources/root-context-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestForumDao {

	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private ForumQuestionsDao forumQuestionDao;
	@Autowired
	private ForumAnswersDao forumAnswerDao;
	@Autowired
	DataSource dataSource;
	private ForumQuestionsBean forumQuestionsBean;
	private ForumAnswersBean forumAnswersBean;
	

	/**
	 * @throws java.lang.Exception
	 */
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
		//userDao=new UserDaoImpl();
		PreparedStatement pst1=dataSource.getConnection().prepareStatement("insert into questions(description,fname,email) values"
				+ "(\"What is the utility amount?\",\"Khyati\",\"ksavakia@uncc.edu\"),"
				+ ""+"(\"Can two people share a room?\",\"Saranya\",\"sprabhu1@uncc.edu\"),"
				+ ""+"(\"How many months is the lease?\",\"Pritam\",\"pborate@uncc.edu\")");
		pst1.executeUpdate();
		
		PreparedStatement pst2=dataSource.getConnection().prepareStatement("insert into answers(qno,reply,fname,email) values"
				+ "(1,\"Its 40$.\",\"Saranya\",\"sprabhu1@uncc.edu\"),"
				+ ""+"(1,\"Utilities depend on your selection except for electricity and water which will be added by default.\",\"Pritam\",\"pborate@uncc.edu\"),"
				+ ""+"(2,\"No you can not share rooms since they are not big enough for 2 people to accomodate.\",\"Pritam\",\"pborate@uncc.edu\")");
		pst2.executeUpdate();
				
		forumQuestionsBean=new ForumQuestionsBean();
		forumQuestionsBean.setQno(1);
		forumQuestionsBean.setDescription("What is the lease period?");
		forumQuestionsBean.setFname("Khyati");
		forumQuestionsBean.setEmail("ksavakia@uncc.edu");
		
		forumAnswersBean=new ForumAnswersBean();
		forumAnswersBean.setQno(1);
		forumAnswersBean.setAnswerno(1);
		forumAnswersBean.setFname("Pritam");
		forumAnswersBean.setEmail("pborate@uncc.edu");
		forumAnswersBean.setReply("$50 is the total amount");
		
//		forumQuestionsBean.get(1).setQno(2);
//		forumQuestionsBean.get(1).setDescription("Can two people share a room?");
//		forumQuestionsBean.get(1).setFname("Saranya");
//		forumQuestionsBean.get(1).setEmail("sprabhu1@uncc.edu");
//		
//		forumQuestionsBean.get(2).setQno(3);
//		forumQuestionsBean.get(2).setDescription("How many months is the lease?");
//		forumQuestionsBean.get(2).setFname("Pritam");
//		forumQuestionsBean.get(2).setEmail("pborate@uncc.edu");
//		//PreparedStatement pstmt=dataSource.getConnection().prepareStatement("");
//		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
				
//		PreparedStatement pstmt2=dataSource.getConnection().prepareStatement("delete from answers where answerno>0");
//		pstmt2.executeUpdate();
//		PreparedStatement pstmt1=dataSource.getConnection().prepareStatement("delete from questions where qno>0");
//		pstmt1.executeUpdate();
		
	}
	
	@Test
	public void getTestQuestionsList() throws SQLException{
				
		List<ForumQuestionsBean> forumQuestionBean = forumQuestionDao.getQuestionsList();
		//assertEquals(expected, actual);
		assertEquals(3, forumQuestionBean.size());
		assertNotEquals(2, forumQuestionBean.size());
		
	}
	
	@Test
	public void getTestAnswersList() throws SQLException{
				
		List<ForumAnswersBean> forumAnswersBean = forumAnswerDao.getAnswersList(1);
		//assertEquals(expected, actual);
		assertEquals(4, forumAnswersBean.size());
		assertNotEquals(3, forumAnswersBean.size());
		
		forumAnswersBean = forumAnswerDao.getAnswersList(2);
		//assertEquals(expected, actual);
		assertEquals(2, forumAnswersBean.size());
		assertNotEquals(1, forumAnswersBean.size());
		
	}
	
	@Test
	public void testAddQuestion() throws ErrorInAddingQuestion
	{
		boolean result=forumQuestionDao.addQuestion(forumQuestionsBean);
		assertTrue("Added question successfully", result);
	}
	
	@Test
	public void testAddAnswer() throws ErrorInAddingReply
	{
		boolean result=forumAnswerDao.addAnswer(forumAnswersBean);
		assertTrue("Added reply successfully", result);
	}
	
}
