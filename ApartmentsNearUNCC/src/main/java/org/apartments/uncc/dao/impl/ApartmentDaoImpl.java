package org.apartments.uncc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apartments.uncc.dao.ApartmentDao;
import org.apartments.uncc.viewBeans.ApartmentDetailsBean;
import org.apartments.uncc.viewBeans.ApartmentReviewBean;
import org.apartments.uncc.viewBeans.OwnerBean;
import org.apartments.uncc.viewBeans.TenantBean;

public class ApartmentDaoImpl implements ApartmentDao{

	DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<ApartmentDetailsBean> getApartmentList(String location) {
		// TODO Auto-generated method stub
		List<ApartmentDetailsBean> apartment = new ArrayList<ApartmentDetailsBean>();
		String query = "Select * from Apartments where area=?";
		//Connection con = DatabaseConnection.connect();
		
		ResultSet rs=null;
//		PreparedStatement pstmt=null;
		System.out.println("Inside AparmentDaoImpl");
		try {
		
			//pstmt = con.prepareStatement(query);
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, location);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ApartmentDetailsBean apt = new ApartmentDetailsBean();
				apt.setApartmentId(rs.getInt("apartmentId"));
				apt.setDepositAmt(rs.getInt("depositAmt"));
				apt.setRent(rs.getInt("rent"));
				apt.setAvailablityFrom(rs.getDate("availablityFrom"));
				apt.setUtilities(rs.getString("utilities"));
				apt.setArea(rs.getString("area"));
				apt.setStreet(rs.getString("street"));
				apt.setDoorNo(rs.getString("doorNo"));
				apt.setCity(rs.getString("city"));
				apt.setno_of_rooms(rs.getInt("no_of_rooms"));
				apt.setno_of_bathroom(rs.getInt("no_of_bathroom"));
				apt.setFlooring(rs.getString("flooring"));
				apt.setType_bathroom(rs.getString("type_bathroom"));
				apartment.add(apt);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			
		}

		return apartment;
	}
	

	@Override
	public Map getApartmentDetails(int id) {
		// TODO Auto-generated method stub
		Map apartmentDetails = new HashMap();
		String query = "Select * from Apartments where apartmentId=?";
		apartmentDetails.put("ApartmentDetails", getApartmentInfo(query, id));
		query = "Select * from Tenant where apartmentId=?";
		apartmentDetails.put("TenantDetails", getTenantDetails(query, id));
		query = "Select * from ApartmentOwner where ownerId IN(select ownerId from Apartments where apartmentId=? )";
		apartmentDetails.put("OwnerDetails", getOwnerDetails(query, id));
		query = "Select rating,comments from Feedback where apartmentId=?";
		apartmentDetails.put("ReviewAndRatings", getReviewComments(query, id));
		query = "select photo from aptImages where apartmentId=?";
		apartmentDetails.put("images", getImages(query, id));
		
		return apartmentDetails;
	}

	private List<String> getImages(String query, int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		List<String> imageList = new ArrayList<String>();
		try {
			
			//pstmt = con.prepareStatement(query);
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				imageList.add(rs.getString(1));
			}
		}catch (SQLException e) {

			e.printStackTrace();
			
		}
			return imageList;
	}

	private List<ApartmentReviewBean> getReviewComments(String query, int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		List<ApartmentReviewBean> apartmentReviews = new ArrayList<ApartmentReviewBean>();
		try {
			
			//pstmt = con.prepareStatement(query);
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ApartmentReviewBean review = new ApartmentReviewBean();
				review.setComments(rs.getString("comments"));
				review.setRating(rs.getInt("rating"));
				apartmentReviews.add(review);	
			}
			

		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return apartmentReviews;
	
	}

	private OwnerBean getOwnerDetails(String query, int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		OwnerBean owner = new OwnerBean();
		try {
			
			//pstmt = con.prepareStatement(query);
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				owner.setoEmail(rs.getString("oEmail"));
				owner.setoFirstName(rs.getString("oFirstName"));
				owner.setoLastName(rs.getString("oLastName"));
				owner.setoPassword(rs.getString("oPassword"));
				owner.setoPhoneNo(rs.getLong("oPhoneNo"));
				owner.setOwnerId(rs.getInt("ownerId"));
				
			}
			

		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return owner;
	}

	private List<TenantBean> getTenantDetails(String query, int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		List<TenantBean> tenants = new ArrayList<TenantBean>();
		
		try {
			
			//pstmt = con.prepareStatement(query);
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TenantBean tenant = new TenantBean();
				tenant.setApartmentId(rs.getInt("apartmentId"));
				tenant.setDegree(rs.getString("degree"));
				tenant.setEating_pref(rs.getString("Eating_pref"));
				tenant.setMajor(rs.getString("Major"));
				tenant.setNationality(rs.getString("Nationality"));
				tenant.setTage(rs.getInt("tage"));
				tenant.settBOD(rs.getDate("tBOD"));
				tenant.settEmail(rs.getString("tEmail"));
				tenant.setTenantId(rs.getInt("tenantId"));
				tenant.setTfirstName(rs.getString("tfirstName"));
				tenant.setTgender(rs.getString("tgender"));
				tenant.setTlastName(rs.getString("tlastName"));
				tenant.settPassword(rs.getString("tPassword"));
				tenant.settPhoneNo(rs.getString("tPhoneNo"));
				tenant.setVisa_status(rs.getString("tPassword"));
				tenants.add(tenant);
			}
			

		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return tenants;
	}

	private ApartmentDetailsBean getApartmentInfo(String query, int id) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		ApartmentDetailsBean apt = new ApartmentDetailsBean();
		try {
			
			//pstmt = con.prepareStatement(query);
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				apt.setApartmentId(rs.getInt("apartmentId"));
				apt.setDepositAmt(rs.getInt("depositAmt"));
				apt.setRent(rs.getInt("rent"));
				apt.setAvailablityFrom(rs.getDate("availablityFrom"));
				apt.setUtilities(rs.getString("utilities"));
				apt.setArea(rs.getString("area"));
				apt.setStreet(rs.getString("street"));
				apt.setDoorNo(rs.getString("doorNo"));
				apt.setCity(rs.getString("city"));
				apt.setno_of_rooms(rs.getInt("no_of_rooms"));
				apt.setno_of_bathroom(rs.getInt("no_of_bathroom"));
				apt.setFlooring(rs.getString("flooring"));
				
				
			}
			

		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return apt;
	}

	@Override
	public List<ApartmentDetailsBean> getApartmentDetails(String emailId) {
		// TODO Auto-generated method stub
		List<ApartmentDetailsBean> apartment = new ArrayList<ApartmentDetailsBean>();
		String query = "Select * from Apartments where ownerId=(select ownerId from ApartmentOwner where oEmail=?)";
		//Connection con = DatabaseConnection.connect();
		
		ResultSet rs=null;
//		PreparedStatement pstmt=null;
		System.out.println("Inside AparmentDaoImpl");
		try {
		
			//pstmt = con.prepareStatement(query);
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
			pstmt.setString(1, emailId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ApartmentDetailsBean apt = new ApartmentDetailsBean();
				apt.setApartmentId(rs.getInt("apartmentId"));
				apt.setDepositAmt(rs.getInt("depositAmt"));
				apt.setRent(rs.getInt("rent"));
				apt.setAvailablityFrom(rs.getDate("availablityFrom"));
				apt.setUtilities(rs.getString("utilities"));
				apt.setArea(rs.getString("area"));
				apt.setStreet(rs.getString("street"));
				apt.setDoorNo(rs.getString("doorNo"));
				apt.setCity(rs.getString("city"));
				apt.setno_of_rooms(rs.getInt("no_of_rooms"));
				apt.setno_of_bathroom(rs.getInt("no_of_bathroom"));
				apt.setFlooring(rs.getString("flooring"));
				apt.setType_bathroom(rs.getString("type_bathroom"));
				apartment.add(apt);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			
		}

		return apartment;
	}

	@Override
	public int getNewApartmentId(ApartmentDetailsBean aptDetails,String email) {
		// TODO Auto-generated method stub
		int id=getOwnerId(email);
		
		
		String query = "insert into Apartments(ownerId,depositAmt,rent,availablityFrom,utilities,area,street,doorNo,city,no_of_rooms,type_bathroom,flooring) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
		ResultSet rs=null;
		PreparedStatement pstmt;
		System.out.println("Date is - "+aptDetails.getDate());
		java.util.Date dateJ=new java.util.Date(aptDetails.getDate());
		java.sql.Date dateS=new java.sql.Date(dateJ.getTime());
		try {
			pstmt = dataSource.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, id);
			pstmt.setInt(2, aptDetails.getDepositAmt());
			pstmt.setInt(3, aptDetails.getRent());
			pstmt.setDate(4, dateS);
			pstmt.setString(5, aptDetails.getUtilities());
			pstmt.setString(6, aptDetails.getArea());
			pstmt.setString(7, aptDetails.getStreet());
			pstmt.setString(8, aptDetails.getDoorNo());
			pstmt.setString(9, aptDetails.getCity());
			pstmt.setInt(10, aptDetails.getno_of_rooms());
			pstmt.setString(11, aptDetails.getType_bathroom());
			pstmt.setString(12, aptDetails.getFlooring());
			pstmt.execute();
			//pstmt.executeUpdate();
			rs=pstmt.getGeneratedKeys();//executeUpdate().     //pstmt.executeUpdate(query, autoGeneratedKeys)
			while(rs.next())
				System.out.println("Apt Id is - "+rs.getLong(1));
			
			//rs = pstmt.executeQuery();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	private int getOwnerId(String email) {
		// TODO Auto-generated method stub
		int ownerId=-1;
		ResultSet rs=null;
		String query1="select ownerId from ApartmentOwner where oEmail=?";
		PreparedStatement pstmt;
		try {
			pstmt = dataSource.getConnection().prepareStatement(query1);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			rs.next();
			ownerId=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ownerId;
	}
	
	public int getOwnerId(int aptId){
		int ownerId=-1;
		ResultSet rs=null;
		String query1="select ownerId from Apartments where apartmentId=?";
		PreparedStatement pstmt;
		try {
			pstmt = dataSource.getConnection().prepareStatement(query1);
			pstmt.setInt(1, aptId);
			rs = pstmt.executeQuery();
			rs.next();
			ownerId=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ownerId;
	}

}