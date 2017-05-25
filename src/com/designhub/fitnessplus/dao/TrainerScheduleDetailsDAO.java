package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.TrainerScheduleDetailsBean;
import com.designhub.fitnessplus.util.DBConnection;

public class TrainerScheduleDetailsDAO {

	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	boolean result = false;
	public boolean insert(TrainerScheduleDetailsBean trainerScheduleDetailsBean){
		
		conn=DBConnection.getConnection();	
		System.out.println(trainerScheduleDetailsBean.getActivityId()+" <-acivity DAO-> "+trainerScheduleDetailsBean.getTrainerId());
		 if(conn!=null)
		 {
			 try
			 {
			 boolean chk=false;
			 System.out.println("sdfdsf-> "+trainerScheduleDetailsBean.getTrainerId());
			 pstmt = conn.prepareStatement("select * from trainerSchedule where trainerId=?");
			 pstmt.setString(1,trainerScheduleDetailsBean.getTrainerId());
			 rs = pstmt.executeQuery();
			 while(rs.next()){
				 chk=true;
			 }
			 
			 if(chk)
			 {
				 String getTrainerScheduleId="select trainerScheduleId from trainerSchedule where trainerId=?";
				 pstmt = conn.prepareStatement(getTrainerScheduleId);
				 pstmt.setString(1, trainerScheduleDetailsBean.getTrainerId());
				 
				ResultSet rs =pstmt.executeQuery();
				String trainerScheduleId="";
				while(rs.next())
				{
					trainerScheduleId=rs.getString("trainerScheduleId");
					System.out.println("--->,,,,,,"+trainerScheduleId);
				}
				 
				 
				 System.out.println("1 record");
				 String insertSQL = "INSERT INTO trainerScheduleDetails" +
				 					"(trainerActivityId,trainerStartTime,trainerEndTime,trainerDay,trainerScheduleId) " +
				 					"values(?,?,?,?,?)";
					pstmt = conn.prepareStatement(insertSQL);
					
					pstmt.setString(1,trainerScheduleDetailsBean.getActivityId());
					pstmt.setString(2,trainerScheduleDetailsBean.getTrainerStartTime());
					pstmt.setString(3,trainerScheduleDetailsBean.getTrainerEndTime());
					pstmt.setString(4,trainerScheduleDetailsBean.getTrainerDay());
					pstmt.setString(5,trainerScheduleId);
					
					System.out.println(insertSQL);
					
					int rowsAffected = pstmt.executeUpdate();
					
					if (rowsAffected > 0) {
						result=true;
						System.out.println(rowsAffected + " Row(s) Inserted......");

					} else {
					
				 System.out.println("No insert");
					}
			 }else{
				 
				 System.out.println("2 record");
				 String insertTrainerScheduleSQL="insert into trainerSchedule(trainerId) values(?)";			 
					
				 	pstmt = conn.prepareStatement(insertTrainerScheduleSQL);
					pstmt.setString(1,trainerScheduleDetailsBean.getTrainerId());
					
					int rowsAffected=pstmt.executeUpdate();
					 
					if(rowsAffected==0)
					return false;
					else {
						System.out.println("ADDed TrainerSchedule.");
					}
				
					String insertSQL = "INSERT INTO trainerScheduleDetails(trainerActivityId,trainerStartTime,trainerEndTime,trainerDay,trainerScheduleId) values(?,?,?,?,LAST_INSERT_ID())";
					pstmt = conn.prepareStatement(insertSQL);
					
					pstmt.setString(1,trainerScheduleDetailsBean.getActivityId());
					pstmt.setString(2,trainerScheduleDetailsBean.getTrainerStartTime());
					pstmt.setString(3,trainerScheduleDetailsBean.getTrainerEndTime());
					pstmt.setString(4,trainerScheduleDetailsBean.getTrainerDay());
					
					rowsAffected = pstmt.executeUpdate();
					
					if (rowsAffected > 0) {
						result=true;
						System.out.println(rowsAffected + " Row(s) Inserted......");

					} else {
						 String deleteSQL="delete from trainerSchedule where trainerScheduleId=LAST_INSERT_ID()";
						 pstmt = conn.prepareStatement(deleteSQL);
						 rowsAffected=pstmt.executeUpdate();
						 if(rowsAffected>0)
						 {
							 System.out.println("Data is RollBacked");
						 }
					}
				 
			 }
			/* if(r>0)
			 {
				 System.out.println("1 Record Insert");
			 }else{
				 System.out.println("2 Record Insert");
			 }
			 */
			 /*String insertTrainerScheduleSQL="insert into trainerSchedule(trainerId) values(?)";			 
				pstmt = conn.prepareStatement(insertTrainerScheduleSQL);
				pstmt.setInt(1,Integer.parseInt(trainerScheduleDetailsBean.getTrainerId()));
				int rowsAffected=pstmt.executeUpdate();
				 
				if(rowsAffected==0)
				return false;
				else {
					System.out.println("ADDed TrainerSchedule.");
				}
			
				String insertSQL = "INSERT INTO trainerScheduleDetails(trainerActivityId,trainerStartTime,trainerEndTime,trainerDay,trainerScheduleId) values(?,?,?,?,LAST_INSERT_ID())";
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,trainerScheduleDetailsBean.getActivityId());
				pstmt.setString(2,trainerScheduleDetailsBean.getTrainerStartTime());
				pstmt.setString(3,trainerScheduleDetailsBean.getTrainerEndTime());
				pstmt.setString(4,trainerScheduleDetailsBean.getTrainerDay());
				
				rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Inserted......");

				} else {
					 String deleteSQL="delete from trainerSchedule where trainerScheduleId=LAST_INSERT_ID()";
					 pstmt = conn.prepareStatement(deleteSQL);
					 rowsAffected=pstmt.executeUpdate();
					 if(rowsAffected>0)
					 {
						 System.out.println("Data is RollBacked");
					 }

				}*/
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
	
	

	public List<TrainerScheduleDetailsBean> list(String trainerId){
		
		List<TrainerScheduleDetailsBean> listOfTrainerScheduleDetails = new ArrayList<TrainerScheduleDetailsBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 
			 String selectSQL = "select * from trainerScheduleDetails,trainerschedule,Activity" +
			 					" WHERE trainerScheduledetails.trainerScheduleId=trainerschedule.trainerscheduleId" +
			 					" AND trainerscheduleDetails.traineractivityId=Activity.activityId" +
			 					" AND trainerSchedule.trainerId=? " +
			 					" order by trainerScheduleDetailsId";
			 
			 
			 /*String selectSQL = "Select * from trainer,trainerSchedule,trainerScheduleDetails,activity " +
			 					"where trainer.trainerId=trainerSchedule.trainerId " +
					 			"AND trainerScheduleDetails.trainerScheduleId=trainerSchedule.trainerScheduleId " +
					 			"AND trainerScheduleDetails.trainerActivityId=activity.activityId " +
					 			"order by trainerScheduleDetailsId";*/
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1,trainerId);
				
				rs = pstmt.executeQuery();

				TrainerScheduleDetailsBean trainerScheduleDetailsBean = null;
				while(rs.next()){
					trainerScheduleDetailsBean = new TrainerScheduleDetailsBean();
				
					trainerScheduleDetailsBean.setActivityId(rs.getString("activityId"));
					trainerScheduleDetailsBean.setActivityName(rs.getString("activityName"));
					trainerScheduleDetailsBean.setTrainerDay(rs.getString("trainerDay"));
					trainerScheduleDetailsBean.setTrainerEndTime(rs.getString("trainerEndTime"));
					trainerScheduleDetailsBean.setTrainerScheduledetailsId(rs.getString("trainerScheduledetailsId"));
					trainerScheduleDetailsBean.setTrainerScheduleId(rs.getString("trainerScheduleId"));
					trainerScheduleDetailsBean.setTrainerStartTime(rs.getString("trainerStartTime"));
					trainerScheduleDetailsBean.setTrainerId(rs.getString("trainerId"));

					listOfTrainerScheduleDetails.add(trainerScheduleDetailsBean);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listOfTrainerScheduleDetails.size());
		return listOfTrainerScheduleDetails;
	}

	
	public boolean delete(String trainerScheduleDetailsId) {
		 
		     conn=DBConnection.getConnection();	
		     System.out.println("mScheId -> "+trainerScheduleDetailsId);
			 if(conn!=null){
			 String deleteSQL = "DELETE FROM trainerScheduleDetails WHERE trainerScheduleDetailsId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,trainerScheduleDetailsId);
			
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) deleted......");

				} else {
					System.out.println(rowsAffected + " Row(s) deleted......");

				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		 return result;
	}
	
	public boolean deleteByTrainerScheduleId(String trainerScheduleId) {
		 
	     conn=DBConnection.getConnection();	
	     System.out.println("mScheId -> "+trainerScheduleId);
		 if(conn!=null){
		 String deleteSQL = "DELETE FROM trainerScheduleDetails WHERE trainerScheduleId=?";
		 
		 try {
			pstmt = conn.prepareStatement(deleteSQL);
			
			pstmt.setString(1,trainerScheduleId);
		
			int rowsAffected = pstmt.executeUpdate();
			
			if (rowsAffected > 0) {
				result=true;
				System.out.println(rowsAffected + " Row(s) deleted......");

			} else {
				System.out.println(rowsAffected + " Row(s) deleted......");

			}
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 
	 }
	 return result;
}
	public TrainerScheduleDetailsBean getByPK(String trainerScheduleDetailsId) {
		
		 conn=DBConnection.getConnection();	
		 
		 TrainerScheduleDetailsBean trainerScheduleDetails =new TrainerScheduleDetailsBean();
		 
		 if(conn!=null){
			 String selectSQL ="Select * from trainer,trainerSchedule,trainerScheduleDetails,activity " +
	 							"where trainer.trainerId=trainerSchedule.trainerId " +
			 					"AND trainerScheduleDetails.trainerScheduleId=trainerSchedule.trainerScheduleId " +
			 					"AND trainerScheduleDetails.trainerActivityId=activity.activityId " +
			 					"AND trainerScheduleDetailsId=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1, trainerScheduleDetailsId);
				
				rs = pstmt.executeQuery();
					
				
				while(rs.next()){
					 
					trainerScheduleDetails.setTrainerId(rs.getString("trainerId"));
					trainerScheduleDetails.setActivityId(rs.getString("activityId"));
					trainerScheduleDetails.setActivityName(rs.getString("activityName"));
					trainerScheduleDetails.setTrainerDay(rs.getString("trainerDay"));
					trainerScheduleDetails.setTrainerEndTime(rs.getString("trainerEndTime"));
					trainerScheduleDetails.setTrainerScheduledetailsId(rs.getString("trainerScheduledetailsId"));
					trainerScheduleDetails.setTrainerScheduleId(rs.getString("trainerScheduleId"));
					trainerScheduleDetails.setTrainerStartTime(rs.getString("trainerStartTime"));
					
					trainerScheduleDetails.setTrainerFirstName(rs.getString("trainerFirstName"));
					trainerScheduleDetails.setTrainerLastName(rs.getString("trainerLastName"));
				System.out.println("trainerID   - > " + rs.getString("trainerId"));
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	return trainerScheduleDetails;
	}
	
	public boolean update(TrainerScheduleDetailsBean trainerScheduleDetailsBean) {
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String updateSQL = "UPDATE trainerScheduleDetails set trainerActivityId=?,trainerStartTime=?,trainerEndTime=?," +
			 					"trainerDay=? " +
			 					"WHERE trainerScheduleDetailsId=?";
			 
			 
			 System.out.println("Schedule Details" + trainerScheduleDetailsBean.getTrainerScheduledetailsId()) ;
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1, trainerScheduleDetailsBean.getActivityId());
				pstmt.setString(2,trainerScheduleDetailsBean.getTrainerStartTime());
				pstmt.setString(3, trainerScheduleDetailsBean.getTrainerEndTime());
				pstmt.setString(4,trainerScheduleDetailsBean.getTrainerDay());
				pstmt.setString(5, trainerScheduleDetailsBean.getTrainerScheduledetailsId());
				
				
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



public  int getTrainerId(String trainerScheduleDetailsId) {
		int trainerId=0;
		String selectSQL="select trainerId from trainerSchedule,trainerScheduleDetails where trainerScheduleDetailsId=? and trainerSchedule.trainerScheduleId=trainerScheduleDetails.trainerScheduleId";
		conn=DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1, trainerScheduleDetailsId);
			
			rs = pstmt.executeQuery();
				
			
			while(rs.next()){
				trainerId=rs.getInt("trainerID");
			}
			System.out.println("MEMBERID--->"+trainerId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainerId;
	}
}

