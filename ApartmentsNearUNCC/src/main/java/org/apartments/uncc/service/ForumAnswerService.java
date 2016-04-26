package org.apartments.uncc.service;

import java.util.List;

import org.apartments.uncc.exceptions.ErrorInAddingReply;
import org.apartments.uncc.viewBeans.ForumAnswersBean;

public interface ForumAnswerService {

	public List<ForumAnswersBean> getAnswersList(int questionNum);

	public boolean addAnswer(ForumAnswersBean forumAnswerBean) throws ErrorInAddingReply;
}
