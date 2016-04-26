package org.apartments.uncc.dao;

import java.util.List;

import org.apartments.uncc.exceptions.ErrorInAddingQuestion;
import org.apartments.uncc.viewBeans.ForumAnswersBean;
import org.apartments.uncc.viewBeans.ForumQuestionsBean;

public interface ForumQuestionsDao {
	public List<ForumQuestionsBean> getQuestionsList();
	public boolean addQuestion(ForumQuestionsBean questionBean) throws ErrorInAddingQuestion;
	
}
