package org.apartments.uncc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apartments.uncc.dao.ForumQuestionsDao;
import org.apartments.uncc.exceptions.ErrorInAddingQuestion;
import org.apartments.uncc.exceptions.InvalidCredentialsException;
import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.viewBeans.ForumQuestionsBean;

public class ForumQuestionsDaoImpl implements ForumQuestionsDao{
	
	DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<ForumQuestionsBean> getQuestionsList(){
		List<ForumQuestionsBean> questionList = new ArrayList<ForumQuestionsBean>();
		String query = "Select * from questions";
		
		ResultSet rs=null;
		System.out.println("Inside Forum dao Impl");
		try {
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ForumQuestionsBean questions = new ForumQuestionsBean();
				questions.setQno(rs.getInt("qno"));
				questions.setDescription(rs.getString("description"));
				questions.setFname(rs.getString("fname"));
				questions.setEmail(rs.getString("email"));
				questionList.add(questions);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			
		}

		return questionList;
	}

	@Override
	public boolean addQuestion(ForumQuestionsBean questionBean) throws ErrorInAddingQuestion {
		
		String query="insert into questions(description,fname,email) values(?,?,?)";
		PreparedStatement pstmt;
		
		try {
			pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, questionBean.getDescription());
			pstmt.setString(2, questionBean.getFname());
			pstmt.setString(3, questionBean.getEmail());
			pstmt.executeUpdate();
			System.out.println("---------Inserted In DB----------");
			
			return true;
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			throw new ErrorInAddingQuestion("Error while connecting to DB. Kindly Try after sometime.");
		//e.printStackTrace();
		
		//return false;
		}
	}
}
