/**
 * 
 */
package org.apartments.uncc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apartments.uncc.dao.UserDao;
import org.apartments.uncc.exceptions.InvalidCredentialsException;
import org.apartments.uncc.exceptions.InvalidEmailIdException;
import org.apartments.uncc.viewBeans.LoginBean;
import org.apartments.uncc.viewBeans.RegistrationBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;

/**
 * @author Pritam Borate
 *
 */
public class UserDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see org.apartments.uncc.dao.UserDao#isValidUser(java.lang.String, java.lang.String)
	 */
	
	DataSource dataSource;

	public DataSource getDataSource()
	{
			return this.dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
			this.dataSource = dataSource;
	}
	
	@Override
	public UserDetailsBean isValidUser(LoginBean loginBean) throws SQLException, InvalidCredentialsException {
		// TODO Auto-generated method stub
		String query = "select email_id, userRole from login where Email_id = ? and Password = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, loginBean.getUsername());
		pstmt.setString(2, loginBean.getPassword());
		ResultSet resultSet = pstmt.executeQuery();
		UserDetailsBean user;
		if (resultSet.next())
		{	
			user=new UserDetailsBean();
			user.setUsername(resultSet.getString(1));
			user.setUserRole(resultSet.getString(2));
			user.setfName(getFName(loginBean.getUsername(),user.getUserRole()));
		}
		else
				throw new InvalidCredentialsException("Invalid Credentials!!");
		return user;
	}

	private String getFName(String username, String userRole) {
		// TODO Auto-generated method stub
		String fName="";
		String query ="";
		if(userRole.equals("student"))
			query="select firstName from students where semail = ?";
		else
			query="select oFirstName from ApartmentOwner where oemail = ?";
		try {
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, username);
			ResultSet resultSet = pstmt.executeQuery();
			
			if (resultSet.next())
			{	
				fName=resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fName;
	}

	@Override
	public boolean isValidRegistration(RegistrationBean registratinBean) throws SQLException, InvalidEmailIdException{
		// TODO Auto-generated method stub
		System.out.println("------Inside userDao-------"+registratinBean.getUserRole());
		String query = "Select * from login where email_id = ?";
		String detailedQuery = "";
		if(registratinBean.getUserRole().equals("owner"))
		{
			detailedQuery="insert into ApartmentOwner(oFirstName,oLastName,oEmail,oPassword) values (?,?,?,?)";
		}
		else
			detailedQuery="insert into students(firstName,lastName,sEmail,sPassword) values (?,?,?,?)";
		
		PreparedStatement pstmtLogin,pstmt;
		try {
			pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, registratinBean.getEmail());
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next())
				throw new InvalidEmailIdException("Email Id already exist, Please Use another email id.");
			else
			{
				//query="insert into students(firstName,lastName,sEmail,sPassword) values (?,?,?,?)";
				pstmtLogin = dataSource.getConnection().prepareStatement("insert into login(email_id,password,userRole) values (?,?,?)");
				pstmtLogin.setString(1, registratinBean.getEmail());
				pstmtLogin.setString(2, registratinBean.getPassword());
				pstmtLogin.setString(3, registratinBean.getUserRole());
				pstmtLogin.executeUpdate();
				pstmt = dataSource.getConnection().prepareStatement(detailedQuery);
				pstmt.setString(1, registratinBean.getFname());
				pstmt.setString(2, registratinBean.getLname());
				pstmt.setString(3, registratinBean.getEmail());
				pstmt.setString(4, registratinBean.getPassword());
				pstmt.executeUpdate();
				System.out.println("---------Inserted In DB----------");
				
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----Error While insertion------");
		return false;
		
	}

	@Override
	public void activateAccount(String username) {
		// TODO Auto-generated method stub
		String query="update login set isActive=true where email_id=?";
		PreparedStatement pstmt;
		try {
			pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.executeUpdate();
			System.out.println("Updated Account!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
