package org.apartments.uncc.delegate;

import java.sql.SQLException;
import java.util.List;

import org.apartments.uncc.exceptions.ErrorInAddingReply;
import org.apartments.uncc.service.ForumAnswerService;
import org.apartments.uncc.viewBeans.ForumAnswersBean;

public class ForumAnswerDelegate {
	
	private ForumAnswerService forumAnswerService;

	public ForumAnswerService getForumAnswerService() {
		return forumAnswerService;
	}

	public void setForumAnswerService(ForumAnswerService forumAnswerService) {
		this.forumAnswerService = forumAnswerService;
	}
	
	public List<ForumAnswersBean> getAnswersList(String questionNum) throws SQLException
	{
	     return forumAnswerService.getAnswersList(Integer.parseInt(questionNum));
	}
	
	public boolean addAnswer(ForumAnswersBean forumAnswerBean) throws ErrorInAddingReply {
		return forumAnswerService.addAnswer(forumAnswerBean);
	}
	
}
