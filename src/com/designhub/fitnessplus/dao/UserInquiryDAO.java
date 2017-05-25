package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.designhub.fitnessplus.bean.UserInquiryBean;
import com.designhub.fitnessplus.util.DBConnection;

public class UserInquiryDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	private boolean result = false;
	
	public boolean insert(UserInquiryBean userInquiryBean)
	{
		
		try {
			conn = DBConnection.getConnection();
			if(conn!=null)
			{
				String insertSQL = "INSERT INTO USERINQUIRY(firstName,lastName,email,phoneNo,inquiryMassage,isAttendedBy,inquiryDate) " +
									"VALUES(?,?,?,?,?,?,?)";

				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1, userInquiryBean.getFirstName());
				pstmt.setString(2, userInquiryBean.getLastName());
				pstmt.setString(3, userInquiryBean.getEmail());
				pstmt.setString(4, userInquiryBean.getPhoneNo());
				pstmt.setString(5, userInquiryBean.getInquiryMassage());
				pstmt.setString(6, userInquiryBean.getIsAttendedBy());
				pstmt.setString(7, userInquiryBean.getInquiryDate());
				
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected > 0) {
					System.out.println(rowAffected + " Row(s) Inserted....");
					result = true;
				}
				else {		
					System.out.println(rowAffected + " Row(s) Inserted....");
					result = false;
				}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<UserInquiryBean> list() {
		List<UserInquiryBean> listOfUserInquiry = new ArrayList<UserInquiryBean>();

		try {
			conn = DBConnection.getConnection();
			if (conn != null) 
			{
				String selectSQL = "SELECT * FROM USERINQUIRY,ADMIN where " +
									"userInquiry.isAttendedBy=admin.adminId ";
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				UserInquiryBean userInquiryBean = null;

				while (rs.next()) {
					userInquiryBean = new UserInquiryBean();

					userInquiryBean.setInquiryId(rs.getString("inquiryId"));
					userInquiryBean.setFirstName(rs.getString("firstName"));
					userInquiryBean.setLastName(rs.getString("lastName"));
					userInquiryBean.setEmail(rs.getString("email"));
					userInquiryBean.setPhoneNo(rs.getString("phoneNo"));
					userInquiryBean.setInquiryMassage(rs.getString("inquiryMassage"));
					userInquiryBean.setInquiryDate(rs.getString("inquiryDate"));
					userInquiryBean.setIsAttendedBy(rs.getString("isAttendedBy"));
					userInquiryBean.setAdminFirstName(rs.getString("adminFirstName"));
					userInquiryBean.setAdminLastName(rs.getString("adminLastName"));
					
					listOfUserInquiry.add(userInquiryBean);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfUserInquiry;

	}
	public boolean delete(String inquiryId) {

		try {
			conn = DBConnection.getConnection();
			if (conn != null) {
				String deleteSQL = "DELETE FROM USERINQUIRY WHERE inquiryId=?";
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setString(1, inquiryId);
				System.out.println(inquiryId);
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected > 0) {
					result = true;
					System.out.println(rowAffected + " Row(s) are deleted");
				} else {
					result = false;
					System.out.println(rowAffected + " Row(s) are deleted");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public UserInquiryBean getByPK(String inquiryId) 
	{
		UserInquiryBean userInquiry = new UserInquiryBean();
		try {
			conn = DBConnection.getConnection();
			if (conn != null) 
			{
				String selectSQL = "SELECT * FROM USERINQUIRY WHERE inquiryId=?";			
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setString(1, inquiryId);
				rs = pstmt.executeQuery();
				while (rs.next()) 
				{	
					userInquiry.setInquiryId(rs.getString("inquiryId"));
					userInquiry.setFirstName(rs.getString("firstName"));
					userInquiry.setLastName(rs.getString("lastName"));
					userInquiry.setEmail(rs.getString("email"));
					userInquiry.setPhoneNo(rs.getString("phoneNo"));
					userInquiry.setInquiryMassage(rs.getString("inquiryMassage"));
					userInquiry.setInquiryDate(rs.getString("inquiryDate"));
					userInquiry.setIsAttendedBy(rs.getString("isAttendedBy"));
					userInquiry.setAdminFirstName(rs.getString("adminFirstName"));
					userInquiry.setAdminLastName(rs.getString("adminLastName"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInquiry;
	}
	
	public Boolean update(UserInquiryBean userInquiryBean)
	{
		try {
			conn = DBConnection.getConnection();
			if(conn!=null)
			{
				String updateSQL = "UPDATE USERINQUIRY SET firstName=?,lastName=?,email=?,phoneNo=?,inquiryMassage=?," +
									"isAttendedBy=?,inquiryDate=? WHERE inquiryId=?";
				pstmt = conn.prepareStatement(updateSQL);		
				
				pstmt.setString(1, userInquiryBean.getFirstName());
				pstmt.setString(2, userInquiryBean.getLastName());
				pstmt.setString(3, userInquiryBean.getEmail());
				pstmt.setString(4, userInquiryBean.getPhoneNo());
				pstmt.setString(5, userInquiryBean.getInquiryMassage());
				pstmt.setString(6, userInquiryBean.getIsAttendedBy());
				pstmt.setString(7, userInquiryBean.getInquiryDate());
				pstmt.setString(8, userInquiryBean.getInquiryId());
				
				int rowAffected = pstmt.executeUpdate();
		
				if(rowAffected>0)
				{
					result = true;
					System.out.println("Updated.....");
				}
				else
				{
					result = false;
					System.out.println("Updated Fail.....");
				}	
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}

