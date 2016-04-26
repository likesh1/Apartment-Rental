package org.apartments.uncc.service.impl;

import java.util.List;

import org.apartments.uncc.dao.ForumQuestionsDao;
import org.apartments.uncc.exceptions.ErrorInAddingQuestion;
import org.apartments.uncc.service.ForumQuestionService;
import org.apartments.uncc.viewBeans.ForumQuestionsBean;

public class ForumQuestionServiceImpl implements ForumQuestionService{

	private ForumQuestionsDao questionDao;
	
	public ForumQuestionsDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(ForumQuestionsDao questionDao) {
		this.questionDao = questionDao;
	}

	@Override
	public List<ForumQuestionsBean> getQuestionsList() {
		// TODO Auto-generated method stub
		
		return questionDao.getQuestionsList();
	}

	public boolean addQuestion(ForumQuestionsBean questionBean) throws ErrorInAddingQuestion {
		// TODO Auto-generated method stub
		return questionDao.addQuestion(questionBean);
	}
}
