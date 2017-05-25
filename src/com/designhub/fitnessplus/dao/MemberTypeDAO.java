package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.MemberTypeBean;
import com.designhub.fitnessplus.util.DBConnection;


public class MemberTypeDAO {


		private Connection conn = null;
		private PreparedStatement pstmt =null;
		private ResultSet rs = null;
		
		boolean result = false;
		public boolean insert(MemberTypeBean memberTypeBean){
			
			conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String insertSQL = "INSERT INTO MEMBERTYPE(memberTypeName) values(?)";
				 
				 try {
					pstmt = conn.prepareStatement(insertSQL);
					
					pstmt.setString(1,memberTypeBean.getMemberTypeName());
					
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
		
		

		public List<MemberTypeBean> list(){
			
			List<MemberTypeBean> listOfMemberType = new ArrayList<MemberTypeBean>();
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String selectSQL = "Select * from memberType order by memberTypeId";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
				
					rs = pstmt.executeQuery();

					MemberTypeBean memberType = null;
					while(rs.next()){
						memberType = new MemberTypeBean();
					
						memberType.setMemberTypeId(rs.getString("memberTypeId"));
						memberType.setMemberTypeName(rs.getString("memberTypeName"));
										
						listOfMemberType.add(memberType);
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
				 
				 
			 }
			System.out.println("Size : "+listOfMemberType.size());
			return listOfMemberType;
		}

		
		public boolean delete(String memberTypeId) {
			 
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String deleteSQL = "DELETE FROM memberType WHERE memberTypeId=?";
				 
				 try {
					pstmt = conn.prepareStatement(deleteSQL);
					
					pstmt.setString(1,memberTypeId);
				
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
		
		public MemberTypeBean getByPK(String memberTypeId) {
			
			 conn=DBConnection.getConnection();	
			 MemberTypeBean memberType =new MemberTypeBean();
			 
			 if(conn!=null){
				 String selectSQL = "Select * from memberType WHERE MEMBERTYPEID=?";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
				
					pstmt.setString(1, memberTypeId);
					
					rs = pstmt.executeQuery();

					
					while(rs.next()){
						 
						memberType.setMemberTypeId(rs.getString("MEMBERTYPEID"));
						memberType.setMemberTypeName(rs.getString("MEMBERTYPENAME"));
						
						
					
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return memberType;
		}
		
		public boolean update(MemberTypeBean memberTypeBean) {
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String updateSQL = "UPDATE memberType set memberTypeName=? WHERE MEMBERTYPEID=?";
				 
				 try {
					pstmt = conn.prepareStatement(updateSQL);
					
					pstmt.setString(1,memberTypeBean.getMemberTypeName());
					pstmt.setString(2,memberTypeBean.getMemberTypeId());
					
					
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
