package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.ActivityBean;
import com.designhub.fitnessplus.util.DBConnection;

public class ActivityDAO 
{
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	boolean result = false;
	
	public boolean insert(ActivityBean activitybean){
		
		conn=DBConnection.getConnection();	
		
		 if(conn!=null){
			 String insertSQL = "insert into Activity(ActivityName) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,activitybean.getActivityName());
				
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
	
		public List<ActivityBean> list(){
		
		List<ActivityBean> listOfActivity = new ArrayList<ActivityBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){

			 
			 String selectSQL = "select * from Activity order by activityId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				ActivityBean activityBean = null;

				while(rs.next()){
					
					activityBean = new ActivityBean();
					System.out.println("ID : "+rs.getString("ActivityId"));
					activityBean.setActivityId(rs.getString("ActivityId"));
					activityBean.setActivityName(rs.getString("ActivityName"));
					listOfActivity.add(activityBean);
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		 	System.out.println("Size : "+listOfActivity.size());
			return listOfActivity;
		}

	
		public boolean delete(String activityId) {
			 
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String deleteSQL = "delete from Activity where ActivityId=?";
				 
				 try {
					pstmt = conn.prepareStatement(deleteSQL);
					
					pstmt.setString(1,activityId);
				
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

		public ActivityBean getByPK(String activityId) {
			
			 conn=DBConnection.getConnection();	
			 ActivityBean activity = new ActivityBean();			 
			 if(conn!=null){
				 
							 
				 String selectSQL = "Select * from activity WHERE activityId=?";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
				
					pstmt.setString(1, activityId);
					
					rs = pstmt.executeQuery();

					
					while(rs.next()){
						activity.setActivityId(rs.getString("ActivityId"));
						activity.setActivityName(rs.getString("activityName"));
						
					
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return activity;
		}
		
		public boolean update(ActivityBean activity) {
			
			 conn=DBConnection.getConnection();	
			 if(conn!=null){
				 String updateSQL = "update Activity set ActivityName=? where ActivityId=?";
				 
				 try {
					pstmt = conn.prepareStatement(updateSQL);
					
					
					pstmt.setString(1,activity.getActivityName());
					pstmt.setString(2,activity.getActivityId());
					
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
