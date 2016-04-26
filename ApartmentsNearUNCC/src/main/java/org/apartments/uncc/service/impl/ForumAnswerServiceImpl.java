package org.apartments.uncc.service.impl;

import java.util.List;

import org.apartments.uncc.dao.ForumAnswersDao;
import org.apartments.uncc.exceptions.ErrorInAddingReply;
import org.apartments.uncc.service.ForumAnswerService;
import org.apartments.uncc.viewBeans.ForumAnswersBean;

public class ForumAnswerServiceImpl implements ForumAnswerService {
	
	private ForumAnswersDao forumAnswersDao;

	public ForumAnswersDao getAnswersDao() {
		return forumAnswersDao;
	}

	public void setAnswersDao(ForumAnswersDao answersDao) {
		this.forumAnswersDao = answersDao;
	}
	
	@Override
	public List<ForumAnswersBean> getAnswersList(int questionNum) {
		// TODO Auto-generated method stub
		return forumAnswersDao.getAnswersList(questionNum);
	}

	@Override
	public boolean addAnswer(ForumAnswersBean forumAnswerBean) throws ErrorInAddingReply {
		// TODO Auto-generated method stub
		return forumAnswersDao.addAnswer(forumAnswerBean);
	}


}
