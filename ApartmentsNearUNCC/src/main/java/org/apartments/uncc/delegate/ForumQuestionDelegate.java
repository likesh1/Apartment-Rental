package org.apartments.uncc.delegate;

import java.sql.SQLException;
import java.util.List;

import org.apartments.uncc.exceptions.ErrorInAddingQuestion;
import org.apartments.uncc.service.ForumQuestionService;
import org.apartments.uncc.viewBeans.ForumQuestionsBean;

public class ForumQuestionDelegate {

	private ForumQuestionService questionService;

	public ForumQuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(ForumQuestionService questionService) {
		this.questionService = questionService;
	}

	public List<ForumQuestionsBean> getQuestionsList() throws SQLException
	{
	     return questionService.getQuestionsList();
	}

	public boolean addQuestion(ForumQuestionsBean questionBean) throws ErrorInAddingQuestion {
		
		return questionService.addQuestion(questionBean);
		
	}
	
}
