/**
 * 
 */
package org.apartments.uncc.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apartments.uncc.delegate.ApartmentListDelegate;
import org.apartments.uncc.delegate.ForumAnswerDelegate;
import org.apartments.uncc.delegate.ForumQuestionDelegate;
import org.apartments.uncc.exceptions.ErrorInAddingQuestion;
import org.apartments.uncc.exceptions.ErrorInAddingReply;
import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.viewBeans.ApartmentDetailsBean;
import org.apartments.uncc.viewBeans.ForumAnswersBean;
import org.apartments.uncc.viewBeans.ForumQuestionsBean;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.RegistrationBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.PreparedStatement.ParseInfo;

/**
 * @author Pritam
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private ForumQuestionDelegate questionListDelegate;
	
	@Autowired
	private ForumAnswerDelegate forumAnswerDelegate;
	
	
	@RequestMapping(value="/logout.do", method= RequestMethod.GET)
	public String logout(HttpServletRequest request)    
	{ 
		HttpSession session=request.getSession();
		System.out.println("Session is : "+ session.getAttribute("user"));
		session.invalidate();
		//System.out.println("Session is : "+ session.getAttribute("user"));
		return "redirect:/";
	}	

	@RequestMapping(value="/discussionforum.do", method= RequestMethod.GET)
	public ModelAndView discussionForum(HttpServletRequest request, HttpServletResponse response)   
	{ 
		System.out.println("Controller Called");
		HttpSession session= request.getSession();
		try {
			//apartment=apt.aparmentAll();
			List<ForumQuestionsBean> questions=questionListDelegate.getQuestionsList();	
			session.setAttribute("questions", questions);
			ForumQuestionsBean questionBean=new ForumQuestionsBean();
			request.setAttribute("questionbean", questionBean);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView model= new ModelAndView("discussionForum");
		return model;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/addquestion", method = RequestMethod.POST)
	public String addQuestion(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("questionbean")ForumQuestionsBean questionBean){
			
		HttpSession session=request.getSession();
		
		List<ForumQuestionsBean> questions = (List<ForumQuestionsBean>) session.getAttribute("questions");
		System.out.println(questions.size());
		try {		
		UserDetailsBean userDetails=(UserDetailsBean) session.getAttribute("user");//new UserDetailsBean();
		System.out.println(userDetails.getfName());
		questionBean.setFname(userDetails.getfName());
		questionBean.setEmail(userDetails.getUsername());
		questionListDelegate.addQuestion(questionBean);
		questions.add(questionBean);
		
		} catch (ErrorInAddingQuestion e) {
				// TODO Auto-generated catch block
				request.setAttribute("questionbean", questionBean);
				request.setAttribute("questionErrorMessage", e.getMessage());
				System.out.println(e.getMessage());
			
			}
		session.setAttribute("questions", questions);
		
		// model=new ModelAndView("discussionForum");
		return "redirect:/forum";		
	
	}
	
	@RequestMapping(value="/forum", method = RequestMethod.GET)
	public ModelAndView getForum(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("error is ---" + request.getAttribute("questionErrorMessage"));
		if (request.getAttribute("questionErrorMessage")!=null)
		{
			request.setAttribute("questionErrorMessage", request.getAttribute("questionErrorMessage"));
		}
		ForumQuestionsBean questionBean=new ForumQuestionsBean();
		request.setAttribute("questionbean", questionBean);
		ModelAndView model= new ModelAndView("discussionForum");
		return model;
		
		}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/answers.do", method= RequestMethod.GET)
	public ModelAndView answersForum(HttpServletRequest request, HttpServletResponse response, @RequestParam("qno")String questionNum) { 

		HttpSession session= request.getSession();
		ForumQuestionsBean qBean=new ForumQuestionsBean();
		qBean.setQno(Integer.parseInt(questionNum));
		List<ForumQuestionsBean> questionBean=(List<ForumQuestionsBean>) session.getAttribute("questions");
		int index=questionBean.indexOf(qBean);
		qBean=questionBean.get(index);
		
		session.setAttribute("questionNum", qBean.getQno());
		session.setAttribute("description",qBean.getDescription());
		//apartment=apt.aparmentAll();
		List<ForumAnswersBean> answers = null;
		try {
		 answers = forumAnswerDelegate.getAnswersList(questionNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		session.setAttribute("answers", answers);
		
		ForumAnswersBean forumAnswerBean=new ForumAnswersBean();
		forumAnswerBean.setQno(Integer.parseInt(questionNum));
		request.setAttribute("answerbean", forumAnswerBean);
		
		ModelAndView model= new ModelAndView("answers");
		return model;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/addanswer", method = RequestMethod.POST)
	public String addAnswer(HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute("answerbean")ForumAnswersBean forumAnswerBean){
		
		HttpSession session=request.getSession();
		
		List<ForumAnswersBean> answers=(List<ForumAnswersBean>) session.getAttribute("answers");
		try {
		UserDetailsBean userDetails=(UserDetailsBean) session.getAttribute("user");//new UserDetailsBean();
		//how to add question number
		//System.out.println("hiiiii"+request.getParameter("questionNum"));
		
		forumAnswerBean.setQno(Integer.parseInt(session.getAttribute("questionNum").toString()));
		forumAnswerBean.setFname(userDetails.getfName());
		forumAnswerBean.setEmail(userDetails.getUsername());
		forumAnswerDelegate.addAnswer(forumAnswerBean);
		answers.add(forumAnswerBean);
		} catch (ErrorInAddingReply e) {
			// TODO Auto-generated catch block
			request.setAttribute("answerbean", forumAnswerBean);
			request.setAttribute("questionErrorMessage", e.getMessage());
			System.out.println(e.getMessage());
		
		}
		session.setAttribute("answers", answers);
		session.setAttribute("description", session.getAttribute("description"));
		return "redirect:/answerforum";
	}
	
	@RequestMapping(value="/answerforum", method = RequestMethod.GET)
	public ModelAndView getAnswerForum(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("error is ---" + request.getAttribute("replyErrorMessage"));
		if (request.getAttribute("replyErrorMessage")!=null)
		{
			request.setAttribute("replyErrorMessage", request.getAttribute("replyErrorMessage"));
		}
		ForumAnswersBean forumAnswerBean=new ForumAnswersBean();
		request.setAttribute("answerbean", forumAnswerBean);
		ModelAndView model= new ModelAndView("answers");
		return model;
		
		}
	
}
