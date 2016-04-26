package org.apartments.uncc.service;

import java.util.List;

import org.apartments.uncc.exceptions.ErrorInAddingQuestion;
import org.apartments.uncc.viewBeans.ForumQuestionsBean;

public interface ForumQuestionService {

	public List<ForumQuestionsBean> getQuestionsList();
	public boolean addQuestion(ForumQuestionsBean questionBean) throws ErrorInAddingQuestion;
}
