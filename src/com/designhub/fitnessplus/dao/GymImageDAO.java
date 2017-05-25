package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.GymImageBean;
import com.designhub.fitnessplus.util.DBConnection;

public class GymImageDAO {

	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	boolean result = false;
	public boolean insert(GymImageBean gymImageBean){
		
		conn=DBConnection.getConnection();	
			System.out.println("Id--->" + gymImageBean.getGymDetailsId());
			System.out.println("Id--->" + gymImageBean.getGymImagePath());
		 if(conn!=null){
			 String insertSQL = "INSERT INTO GYMIMAGE(gymDetailsId,gymImagePath) " +
					 			"values(?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,gymImageBean.getGymDetailsId());
				pstmt.setString(2,gymImageBean.getGymImagePath());
				
				
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
	
	

	public List<GymImageBean> list(){
		
		List<GymImageBean> listOfGymImage = new ArrayList<GymImageBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "SELECT * FROM GYMDETAILS,GYMIMAGE " +
			 					"where gymDetails.gymDetailsId=gymImage.gymDetailsId";
			 					
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				GymImageBean gymImage = null;
				while(rs.next()){
					gymImage = new GymImageBean();

					gymImage.setGymDetailsId(rs.getString("gymDetailsId"));
					gymImage.setGymImagePath(rs.getString("gymImagePath"));
					gymImage.setGymImageId(rs.getString("gymImageId"));

					
					
					
					listOfGymImage.add(gymImage);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listOfGymImage.size());
		return listOfGymImage;
	}

	
	public boolean delete(String gymImageId) {
		 
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM gymImage WHERE gymImageId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,gymImageId);
			
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
	
	public GymImageBean getByPK(String gymImageId) {
		
		 conn=DBConnection.getConnection();	
		 GymImageBean gymImage =new GymImageBean();
		 
		 if(conn!=null){
			 String selectSQL = "SELECT * FROM GYMDETAILS,GYMIMAGE " +
	 							"where gymDetails.gymDetailsId=gymImage.gymDetailsId " + 
			 					"AND gymImageId=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1, gymImageId);
				
				rs = pstmt.executeQuery();

				
				while(rs.next()){
					 
					gymImage.setGymDetailsId(rs.getString("gymDetailsId"));
					gymImage.setGymImagePath(rs.getString("gymImagePath"));
					gymImage.setGymImageId(rs.getString("gymImageId"));

				
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	return gymImage;
	}
	
	public boolean update(GymImageBean gymImageBean) {
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String updateSQL = "UPDATE gymImage set gymDetailsId=?,gymImagePath=? " + 
			 					"AND gymImageId=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1,gymImageBean.getGymDetailsId());
				pstmt.setString(2,gymImageBean.getGymImagePath());
				pstmt.setString(3,gymImageBean.getGymImageId());
								
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
