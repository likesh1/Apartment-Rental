package org.apartments.uncc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apartments.uncc.dao.ForumAnswersDao;
import org.apartments.uncc.exceptions.ErrorInAddingReply;
import org.apartments.uncc.viewBeans.ForumAnswersBean;

public class ForumAnswersDaoImpl implements ForumAnswersDao{
	
	DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<ForumAnswersBean> getAnswersList(int questionNum)  {
		List<ForumAnswersBean> answersList = new ArrayList<ForumAnswersBean>();
		String query = "Select * from answers where qno=?";
		
		ResultSet rs=null;
		System.out.println("Inside Forum answer dao Impl");
		try {
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setInt(1, questionNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ForumAnswersBean questions = new ForumAnswersBean();
				questions.setAnswerno(rs.getInt("answerno"));
				questions.setReply(rs.getString("reply"));
				questions.setFname(rs.getString("fname"));
				questions.setEmail(rs.getString("email"));
				answersList.add(questions);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		System.out.println(answersList.size()+"sizeeee" );
		return answersList;
	}

	@Override
	public boolean addAnswer(ForumAnswersBean forumAnswerBean) throws ErrorInAddingReply {
		// TODO Auto-generated method stub
		String query="insert into answers(qno,reply,fname,email) values(?,?,?,?)";
		PreparedStatement pstmt;
		
		try {
			pstmt = dataSource.getConnection().prepareStatement(query);
			System.out.println(forumAnswerBean.getQno());
			pstmt.setInt(1, forumAnswerBean.getQno());
			pstmt.setString(2, forumAnswerBean.getReply());
			pstmt.setString(3, forumAnswerBean.getFname());
			pstmt.setString(4, forumAnswerBean.getEmail());
			pstmt.executeUpdate();
			System.out.println("---------Inserted In DB----------");
			
			return true;
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			
		e.printStackTrace();
		
		return false;
		}
	}
}

