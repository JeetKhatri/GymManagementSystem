package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.PackageDurationBean;
import com.designhub.fitnessplus.util.DBConnection;

public class PackageDurationDAO 
{
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	boolean result = false;
	public boolean insert(PackageDurationBean packageDurationBean){
		
		conn=DBConnection.getConnection();	
		 if(conn!=null){
			 String insertSQL = "INSERT INTO packageDuration(packageDurationTime) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,packageDurationBean.getPackageDurationTime());
				
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
	
	

	public List<PackageDurationBean> list(){
		
		List<PackageDurationBean> listOfPackageDuration = new ArrayList<PackageDurationBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){

			 String selectSQL = "Select * from packageDuration order by packageDurationId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				PackageDurationBean packageDuration = null;
				while(rs.next()){
					packageDuration = new PackageDurationBean();
				
					packageDuration.setPackageDurationId(rs.getString("packageDurationId"));
					packageDuration.setPackageDurationTime(rs.getString("packageDurationTime"));
					listOfPackageDuration.add(packageDuration);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listOfPackageDuration.size());
		return listOfPackageDuration;
}

	
	public boolean delete(String packageDurationId) {
		 
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM packageDuration WHERE packageDurationId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,packageDurationId);
			
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
	
	public PackageDurationBean getByPK(String packageDurationId) {
		
		 conn=DBConnection.getConnection();	
		 PackageDurationBean packageDuration =new PackageDurationBean();
		 
		 if(conn!=null){
			 
						 
			 String selectSQL = "Select * from packageDuration WHERE packageDurationId=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1, packageDurationId);
				
				rs = pstmt.executeQuery();

				
				while(rs.next()){
					 
					packageDuration.setPackageDurationId(rs.getString("packageDurationId"));
					packageDuration.setPackageDurationTime(rs.getString("packageDurationTime"));
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	return packageDuration;
	}
	
	public boolean update(PackageDurationBean packageDurationBean) {
		 conn=DBConnection.getConnection();	
		 if(conn!=null){
			 String updateSQL = "UPDATE packageDuration set packageDurationTime=? WHERE packageDurationId=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				System.out.println("asfdf -> "+packageDurationBean.getPackageDurationId());
				pstmt.setString(1,packageDurationBean.getPackageDurationTime());
				pstmt.setString(2, packageDurationBean.getPackageDurationId());
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
