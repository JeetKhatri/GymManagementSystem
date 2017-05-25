package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.GymDetailsBean;
import com.designhub.fitnessplus.util.DBConnection;

public class GymDetailsDAO 
{
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	int r=0;
	boolean result = false;
	public boolean insert(GymDetailsBean gymDetailsBean){
		
		conn=DBConnection.getConnection();
		 if(conn!=null){
			 String insertSQL = "INSERT INTO gymDetails(gymAddress,gymPhoneNo,cityId,areaId) " +
			 					"values(?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,gymDetailsBean.getGymAddress());
				pstmt.setString(2,gymDetailsBean.getGymPhoneNo());
				pstmt.setString(3,gymDetailsBean.getCityId());
				pstmt.setString(4,gymDetailsBean.getAreaId());
				
				
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
	
	

	public List<GymDetailsBean> list(){
		
		List<GymDetailsBean> listOfgymDetails = new ArrayList<GymDetailsBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = " Select * from gymDetails,area,city" +
			 					" where city.cityId=gymDetails.cityId AND" +
			 					" area.areaId=gymDetails.areaId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				GymDetailsBean gym = null;
				while(rs.next()){
					gym = new GymDetailsBean();
				
					gym.setGymDetailsId(rs.getString("gymDetailsId"));
					gym.setGymAddress(rs.getString("gymAddress"));
					gym.setGymPhoneNo(rs.getString("gymPhoneNo"));
					gym.setAreaName(rs.getString("areaName"));	
					gym.setAreaId(rs.getString("areaId"));
					gym.setCityName(rs.getString("cityName"));
					gym.setCityId(rs.getString("cityId"));
					
					listOfgymDetails.add(gym);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listOfgymDetails.size());
		return listOfgymDetails;
	}

	
	public boolean delete(String gymDetailsId) {
		 
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM gymDetails WHERE gymDetailsId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,gymDetailsId);
			
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
	
	public GymDetailsBean getByPK(String cityId) {
		
		 conn=DBConnection.getConnection();	
		 GymDetailsBean gym =new GymDetailsBean();
		 
		 if(conn!=null){
			 String selectSQL = " Select * from gymDetails,area,city" +
			 					" where city.cityId=gymDetails.cityId AND" +
			 					" area.areaId=gymDetails.areaId AND" + 
			 					" gymDetailsId=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1, cityId);
				
				rs = pstmt.executeQuery();

				
				while(rs.next()){
					
					gym.setGymDetailsId(rs.getString("gymDetailsId"));
					gym.setGymAddress(rs.getString("gymAddress"));
					gym.setGymPhoneNo(rs.getString("gymPhoneNo"));
					gym.setAreaName(rs.getString("areaName"));	
					gym.setAreaId(rs.getString("areaId"));
					gym.setCityName(rs.getString("cityName"));
					gym.setCityId(rs.getString("cityId"));

					
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	return gym;
	}
	
	public boolean update(GymDetailsBean gymDetailsBean) {
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String updateSQL = "UPDATE gymDetails set gymAddress=?,gymPhoneNo=?, " +
			 					"cityId=?,areaId=? WHERE gymDetailsId=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1, gymDetailsBean.getGymAddress());
				pstmt.setString(2,gymDetailsBean.getGymPhoneNo());
				pstmt.setString(3, gymDetailsBean.getCityId());
				pstmt.setString(4, gymDetailsBean.getAreaId());
				pstmt.setString(5, gymDetailsBean.getGymDetailsId());
				
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
