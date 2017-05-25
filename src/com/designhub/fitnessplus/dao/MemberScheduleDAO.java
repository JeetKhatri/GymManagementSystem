package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.MemberScheduleBean;
import com.designhub.fitnessplus.bean.MemberScheduleDetailsBean;
import com.designhub.fitnessplus.util.DBConnection;

public class MemberScheduleDAO 
{
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	boolean result = false;
	
	public boolean insert(MemberScheduleBean memberScheduleBean){
		
		conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO memberSchedule(memberId) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,memberScheduleBean.getMemberId());
				
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Inserted......");

				} else {
					System.out.println(rowsAffected + " Row(s) Inserted......");

				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}finally{
			
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			 
		 }
		
		return result;
	}
	
	

	public List<MemberScheduleBean> list(){
		
		List<MemberScheduleBean> listOfMemberSchedule = new ArrayList<MemberScheduleBean>();
		
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select *" +
			 					" from member m,memberSchedule ms" +
			 					" where m.memberId=ms.memberId";
			 
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				MemberScheduleBean memberSchedule = null;
				while(rs.next()){
					memberSchedule = new MemberScheduleBean();
				
					memberSchedule.setMemberId(rs.getString("memberId"));
					//memberSchedule.setMemberScheduleId(rs.getString("memberScheduleId"));
					memberSchedule.setMemberFirstName(rs.getString("memberFirstName"));
					memberSchedule.setMemberLastName(rs.getString("memberLastName"));
					memberSchedule.setMemberScheduleId(rs.getString("memberScheduleId"));
					
									
					listOfMemberSchedule.add(memberSchedule);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listOfMemberSchedule.size());
		return listOfMemberSchedule;
	}

	
	public boolean delete(String memberScheduleId) {
		 
		 conn=DBConnection.getConnection();	
			System.out.println("memberScheduleid "+memberScheduleId);
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM memberSchedule WHERE memberScheduleId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,memberScheduleId);
			
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Inserted......");

				} else {
					System.out.println(rowsAffected + " Row(s) Inserted......");

				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		 return result;
	}
	
	public String getByPK(String memberId) {
		System.out.println("Member Id" + memberId);
		String scheduleId="";
		 conn=DBConnection.getConnection();	
		  
		 if(conn!=null){
			 String selectSQL = "Select memberScheduleId from memberSchedule WHERE memberId=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1, memberId);
				
				rs = pstmt.executeQuery();

				
				while(rs.next()){
					scheduleId=rs.getString("memberScheduleId");
					
				
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	System.out.println("Scheudle ID " + scheduleId);
	return scheduleId;
	}
	
	public boolean update(MemberScheduleDetailsBean memberScheduleDetailsBean) {
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String updateSQL = "UPDATE memberSchedule set memberId=? WHERE memberScheduleId=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1,memberScheduleDetailsBean.getMemberId());
				pstmt.setString(2, memberScheduleDetailsBean.getMemberScheduledetailsId());
				
				
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Inserted......");

				} else {
					System.out.println(rowsAffected + " Row(s) Inserted......");

				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		 return result;
	}
}

