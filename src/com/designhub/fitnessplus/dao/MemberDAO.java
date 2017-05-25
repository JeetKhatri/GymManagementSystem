package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.designhub.fitnessplus.util.*;
import com.designhub.fitnessplus.bean.MemberBean;

public class MemberDAO 
{

	private Connection conn = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;
	
	private boolean result = false;
	
	
	public boolean insert(MemberBean memberBean){
		
		conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO MEMBER(areaId,cityId,memberFirstName," +
			 					" memberLastName,memberEmail,memberGender" +
			 					" ,memberDOB,memberAddress,memberPhoneNo,memberPassword," +
			 		          	" memberIsActive,memberTypeId,securityQuestionId,answer) " +
			 		            " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,memberBean.getAreaId());
				pstmt.setString(2,memberBean.getCityId());
				pstmt.setString(3,memberBean.getMemberFirstName());
				pstmt.setString(4,memberBean.getMemberLastName());
				pstmt.setString(5,memberBean.getMemberEmail());
				pstmt.setString(6,memberBean.getMemberGender());
				pstmt.setString(7,memberBean.getMemberDOB());
				pstmt.setString(8,memberBean.getMemberAddress());
				pstmt.setString(9,memberBean.getMemberPhoneNo());
				pstmt.setString(10,memberBean.getMemberPassword());
				pstmt.setString(11,memberBean.getMemberIsActive());
				pstmt.setString(12,memberBean.getMemberTypeId());
				pstmt.setString(13,memberBean.getQuestionId());
				pstmt.setString(14,memberBean.getAnswer());
				
				
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
	
	
	public List<MemberBean> list(){
		
		List<MemberBean> listOFMembers = new ArrayList<MemberBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from MEMBER,AREA,CITY,MEMBERTYPE " + 
					 			"where member.areaId = area.areaId " +
					 			"AND member.cityId=city.cityId " +
					 			"AND member.memberTypeId=memberType.memberTypeId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				MemberBean memberbean = null;
				while(rs.next()){
					memberbean = new MemberBean();
					
					
					memberbean.setMemberId(rs.getString("memberId"));
					memberbean.setMemberIsActive(rs.getString("memberIsActive"));
					memberbean.setMemberAddress(rs.getString("memberAddress"));
					memberbean.setMemberDOB(rs.getString("memberDOB"));
					memberbean.setMemberEmail(rs.getString("memberEmail"));
					memberbean.setMemberFirstName(rs.getString("memberFirstName"));
					memberbean.setMemberGender(rs.getString("memberGender"));
					memberbean.setMemberLastName(rs.getString("memberLastName"));
					memberbean.setMemberPassword(rs.getString("memberPassword"));
					memberbean.setMemberPhoneNo(rs.getString("memberPhoneNo"));
					
					
					
					memberbean.setCityId(rs.getString("cityId"));
					memberbean.setCityName(rs.getString("cityName"));
				
					memberbean.setAreaId(rs.getString("areaId"));
					memberbean.setAreaName(rs.getString("areaName"));
					
					memberbean.setMemberTypeId(rs.getString("memberTypeId"));
					memberbean.setMemberTypeName(rs.getString("memberTypeName"));
					
					memberbean.setAnswer(rs.getString("answer"));
					memberbean.setQuestionId(rs.getString("securityQuestionId"));
					//memberbean.setQuestion(rs.getString("securityQuestion"));
					
					
					listOFMembers.add(memberbean);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listOFMembers.size());
		return listOFMembers;
	}

	public boolean delete(String memberId) {
		 
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM member WHERE memberId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,memberId);
			
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
	
	public MemberBean getByPK(String memberId) {
		
		 conn=DBConnection.getConnection();	
		 
		 MemberBean member =new MemberBean();
		 
			 if(conn!=null){
			
				 String selectSQL = "Select * from MEMBER,AREA,CITY,MEMBERTYPE " + 
					 				"where member.areaId = area.areaId " +
					 				"AND member.cityId=city.cityId " +
					 				"AND member.memberTypeId=memberType.memberTypeId " +
					 				"AND memberId=?";
				 try
				 {
					pstmt = conn.prepareStatement(selectSQL);
				
					pstmt.setString(1, memberId);
					
					rs = pstmt.executeQuery();
	
					
					while(rs.next()){
						 
						member.setMemberId(rs.getString("memberId"));
						member.setMemberIsActive(rs.getString("memberIsActive"));
						member.setMemberAddress(rs.getString("memberAddress"));
						member.setMemberDOB(rs.getString("memberDOB"));
						member.setMemberEmail(rs.getString("memberEmail"));
						member.setMemberFirstName(rs.getString("memberFirstName"));
						member.setMemberGender(rs.getString("memberGender"));
						member.setMemberLastName(rs.getString("memberLastName"));
						member.setMemberPassword(rs.getString("memberPassword"));
						member.setMemberPhoneNo(rs.getString("memberPhoneNo"));
						
						
						
						member.setCityId(rs.getString("cityId"));
						member.setCityName(rs.getString("cityName"));
					
						member.setAreaId(rs.getString("areaId"));
						member.setAreaName(rs.getString("areaName"));
						
						member.setMemberTypeId(rs.getString("memberTypeId"));
						member.setMemberTypeName(rs.getString("memberTypeName"));
						
					
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return member;
	}
	
	public boolean update(MemberBean memberBean) {
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String updateSQL = "UPDATE member set areaId=?,cityId=?,memberFirstName=?,memberLastName=?," +
			 					"memberEmail=?,memberGender=?,memberDOB=?,memberAddress=?,memberPhoneNo=?," +
			 					"memberIsActive=?,memberTypeId=? " +
			 					"WHERE MEMBERID=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				System.out.println(memberBean.getMemberId());
				
				pstmt.setString(1,memberBean.getAreaId());
				pstmt.setString(2,memberBean.getCityId());
				pstmt.setString(3,memberBean.getMemberFirstName());
				pstmt.setString(4,memberBean.getMemberLastName());
				pstmt.setString(5,memberBean.getMemberEmail());
				pstmt.setString(6,memberBean.getMemberGender());
				pstmt.setString(7,memberBean.getMemberDOB());
				pstmt.setString(8,memberBean.getMemberAddress());
				pstmt.setString(9,memberBean.getMemberPhoneNo());
				pstmt.setString(10,memberBean.getMemberIsActive());
				pstmt.setString(11,memberBean.getMemberTypeId());
				pstmt.setString(12,memberBean.getMemberId());
				
								
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Updated......");

				} else {
					System.out.println(rowsAffected + " Row(s) Updated......");

				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		 return result;
	}
	
	public boolean updatePassword(String memberId, String password) {

		boolean flag = false;
		conn = DBConnection.getConnection();
		if (conn != null) {
			String updateSQL = "update member set memberPassword=? where memberId=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, password);
				pstmt.setString(2, memberId);
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected > 0) {
					flag = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

}

