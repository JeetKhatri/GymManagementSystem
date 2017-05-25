package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.TrainerScheduleBean;
import com.designhub.fitnessplus.bean.TrainerScheduleDetailsBean;
import com.designhub.fitnessplus.util.DBConnection;

public class TrainerScheduleDAO 
{
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	boolean result = false;
	
	public boolean insert(TrainerScheduleBean trainerScheduleBean){
		
		conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO trainerSchedule(trainerId) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,trainerScheduleBean.getTrainerId());
				
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
	
	

	public List<TrainerScheduleBean> list(){
		
		List<TrainerScheduleBean> listOfTrainerSchedule = new ArrayList<TrainerScheduleBean>();
		
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select *" +
			 					" from trainer m,trainerSchedule ms" +
			 					" where m.trainerId=ms.trainerId";
			 
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				TrainerScheduleBean trainerSchedule = null;
				while(rs.next()){
					trainerSchedule = new TrainerScheduleBean();
				
					trainerSchedule.setTrainerId(rs.getString("trainerId"));
					//trainerSchedule.setTrainerScheduleId(rs.getString("trainerScheduleId"));
					trainerSchedule.setTrainerFirstName(rs.getString("trainerFirstName"));
					trainerSchedule.setTrainerLastName(rs.getString("trainerLastName"));
					trainerSchedule.setTrainerScheduleId(rs.getString("trainerScheduleId"));
					
									
					listOfTrainerSchedule.add(trainerSchedule);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listOfTrainerSchedule.size());
		return listOfTrainerSchedule;
	}

	
	public boolean delete(String trainerScheduleId) {
		 
		 conn=DBConnection.getConnection();	
			System.out.println("trainerScheduleid "+trainerScheduleId);
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM trainerSchedule WHERE trainerScheduleId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,trainerScheduleId);
			
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
	
	public String getByPK(String trainerId) {
		System.out.println("Trainer Id" + trainerId);
		String scheduleId="";
		 conn=DBConnection.getConnection();	
		  
		 if(conn!=null){
			 String selectSQL = "Select trainerScheduleId from trainerSchedule WHERE trainerId=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1, trainerId);
				
				rs = pstmt.executeQuery();

				
				while(rs.next()){
					scheduleId=rs.getString("trainerScheduleId");
					
				
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	System.out.println("Scheudle ID " + scheduleId);
	return scheduleId;
	}
	
	public boolean update(TrainerScheduleDetailsBean trainerScheduleDetailsBean) {
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String updateSQL = "UPDATE trainerSchedule set trainerId=? WHERE trainerScheduleId=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1,trainerScheduleDetailsBean.getTrainerId());
				pstmt.setString(2, trainerScheduleDetailsBean.getTrainerScheduledetailsId());
				
				
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

