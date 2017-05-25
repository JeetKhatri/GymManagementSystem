package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.designhub.fitnessplus.util.*;
import com.designhub.fitnessplus.bean.TrainerBean;

public class TrainerDAO 
{

	private Connection conn = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;
	@SuppressWarnings("unused")
	private int rowsAffected=0;
	boolean result=false;
	
public boolean insert(TrainerBean trainerBean){
		
		conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO trainer(areaId,trainerFirstName,trainerLastName,trainerEmail,trainerGender" +
			 					",trainerDOB,trainerAddress,trainerPhoneNo,trainerPassword,trainerIsActive" +
			 					",trainerExperience,cityId,securityQuestionId,answer) " +
			 					"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,trainerBean.getAreaId());
				pstmt.setString(2,trainerBean.getTrainerFirstName());
				pstmt.setString(3,trainerBean.getTrainerLastName());
				pstmt.setString(4,trainerBean.getTrainerEmail());
				pstmt.setString(5,trainerBean.getTrainerGender());
				pstmt.setString(6,trainerBean.getTrainerDOB());
				pstmt.setString(7,trainerBean.getTrainerAddress());
				pstmt.setString(8,trainerBean.getTrainerPhoneNo());
				pstmt.setString(9,trainerBean.getTrainerPassWord());
				pstmt.setString(10,trainerBean.getTrainerIsActive());
				pstmt.setString(11, trainerBean.getTrainerExperience());
				pstmt.setString(12, trainerBean.getCityId());
				pstmt.setString(13,trainerBean.getQuestionId());
				pstmt.setString(14,trainerBean.getAnswer());
				
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 
		 }
		
		return result;
	}
	
	public List<TrainerBean> list(){
		
		List<TrainerBean> listOFTrainer = new ArrayList<TrainerBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from trainer,area,city " +
			 					"where trainer.areaId=area.areaId And " +
			 					"trainer.cityId=city.cityId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				TrainerBean trainerBean = null;
				while(rs.next()){
					trainerBean = new TrainerBean();
					
					
					
					trainerBean.setAreaId(rs.getString("areaId"));
					trainerBean.setAreaName(rs.getString("areaName"));
					trainerBean.setCityId(rs.getString("cityId"));
					trainerBean.setCityName(rs.getString("cityName"));
					trainerBean.setTrainerIsActive(rs.getString("trainerIsActive"));
					trainerBean.setTrainerAddress(rs.getString("trainerAddress"));
					trainerBean.setTrainerDOB(rs.getString("trainerDOB"));
					trainerBean.setTrainerEmail(rs.getString("trainerEmail"));
					trainerBean.setTrainerFirstName(rs.getString("trainerFirstName"));
					trainerBean.setTrainerGender(rs.getString("trainerGender"));
					trainerBean.setTrainerId(rs.getString("trainerId"));
					trainerBean.setTrainerLastName(rs.getString("trainerLastName"));
					trainerBean.setTrainerPassWord(rs.getString("trainerPassWord"));
					trainerBean.setTrainerPhoneNo(rs.getString("trainerPhoneNo"));
					trainerBean.setTrainerExperience(rs.getString("trainerExperience"));
					trainerBean.setAnswer(rs.getString("answer"));
					trainerBean.setQuestionId(rs.getString("securityQuestionId"));
					
					
				
					listOFTrainer.add(trainerBean);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listOFTrainer.size());
		return listOFTrainer;
	}

	public boolean delete(String trainerId) {
		 
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM trainer WHERE trainerId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,trainerId);
			
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

public TrainerBean getByPK(String trainerId){
		
		 conn=DBConnection.getConnection();	
		 TrainerBean trainerBean = null;
			trainerBean = new TrainerBean();
		 if(conn!=null){
			 
			 String selectSQL = "Select * from trainer,area,city " +
		 						"where trainer.areaId=area.areaId And " +
		 						"trainer.cityId=city.cityId And " +
		 						"trainerId=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setString(1, trainerId);
			
				rs = pstmt.executeQuery();
				while(rs.next()){
					trainerBean.setAreaId(rs.getString("areaId"));
					trainerBean.setAreaName(rs.getString("areaName"));
					trainerBean.setCityId(rs.getString("cityId"));
					trainerBean.setCityName(rs.getString("cityName"));
					trainerBean.setTrainerIsActive(rs.getString("trainerIsActive"));
					trainerBean.setTrainerAddress(rs.getString("trainerAddress"));
					trainerBean.setTrainerDOB(rs.getString("trainerDOB"));
					trainerBean.setTrainerEmail(rs.getString("trainerEmail"));
					trainerBean.setTrainerFirstName(rs.getString("trainerFirstName"));
					trainerBean.setTrainerGender(rs.getString("trainerGender"));
					trainerBean.setTrainerId(rs.getString("trainerId"));
					trainerBean.setTrainerLastName(rs.getString("trainerLastName"));
					trainerBean.setTrainerPassWord(rs.getString("trainerPassWord"));
					trainerBean.setTrainerPhoneNo(rs.getString("trainerPhoneNo"));
					trainerBean.setTrainerExperience(rs.getString("trainerExperience"));
					trainerBean.setAnswer(rs.getString("answer"));
					trainerBean.setQuestionId(rs.getString("securityQuestionId"));
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		return trainerBean;
	}
public boolean update(TrainerBean trainerBean) {
	 conn=DBConnection.getConnection();	
		
	 if(conn!=null){
		 String updateSQL = "UPDATE trainer set areaId=?,cityId=?,trainerFirstName=?,trainerLastName=?,trainerGender=?," +
		 					"trainerDOB=?,trainerAddress=?,trainerPhoneNo=?,trainerIsActive=? " +
		 					"where trainerId=?";
		 
		 try {
			 System.out.println(trainerBean.getTrainerId());
			 
			pstmt = conn.prepareStatement(updateSQL);
			
			pstmt.setString(1,trainerBean.getAreaId());
			pstmt.setString(2,trainerBean.getCityId());
			pstmt.setString(3,trainerBean.getTrainerFirstName());
			pstmt.setString(4,trainerBean.getTrainerLastName());
			pstmt.setString(5,trainerBean.getTrainerGender());
			pstmt.setString(6,trainerBean.getTrainerDOB());
			pstmt.setString(7,trainerBean.getTrainerAddress());
			pstmt.setString(8,trainerBean.getTrainerPhoneNo());
			pstmt.setString(9,trainerBean.getTrainerExperience());
			pstmt.setString(10,trainerBean.getTrainerId());
			
							
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




