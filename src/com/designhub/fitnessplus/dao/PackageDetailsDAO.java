package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.PackageDetailsBean;
import com.designhub.fitnessplus.util.DBConnection;

public class PackageDetailsDAO 
{
	

	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	boolean result = false;
	int rowsAffected;
	public boolean insert(PackageDetailsBean packageDetailsBean){
		
		conn=DBConnection.getConnection();	
		 if(conn!=null){
			
			 try{
				String insertSQL = "INSERT INTO packageDetails" +
								    "(packageDurationId,packageRate,packageDetailsId,packageId) " +
								    "values(?,?,?,?)";
				
				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1,packageDetailsBean.getPackageDurationId());
				pstmt.setString(2,packageDetailsBean.getPackageRate());
				pstmt.setString(3,packageDetailsBean.getPackageDetailsId());
				pstmt.setString(4,packageDetailsBean.getPackageId());
				
				
				rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Inserted......");

				} else {
					 String deleteSQL="delete from package where packageId=LAST_INSERT_ID()";
					 pstmt = conn.prepareStatement(deleteSQL);
					 rowsAffected=pstmt.executeUpdate();
					 if(rowsAffected>0)
					 {
						 System.out.println("Data is RollBacked");
					 }
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
	
	

	public List<PackageDetailsBean> list(){
		
		List<PackageDetailsBean> listOfpackageDetails = new ArrayList<PackageDetailsBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from package,packageDetails,packageDuration " +
			 					"WHERE package.packageId = packageDetails.packageId " +
			 					"AND packageDuration.packageDurationId = packageDetails.packageDurationId " +
			 					"order by packageDetailsId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				PackageDetailsBean packageDetailsBean = null;
				while(rs.next()){
					packageDetailsBean = new PackageDetailsBean();
				
					packageDetailsBean.setPackageDetailsId(rs.getString("packageDetailsId"));
					packageDetailsBean.setPackageDurationId(rs.getString("packageDurationId"));
					packageDetailsBean.setPackageId(rs.getString("packageId"));
					packageDetailsBean.setPackageRate(rs.getString("packageRate"));
					packageDetailsBean.setPackageName(rs.getString("packageName"));
					packageDetailsBean.setPackageDurationTime(rs.getString("packageDurationTime"));
					listOfpackageDetails.add(packageDetailsBean);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listOfpackageDetails.size());
		return listOfpackageDetails;
	}

	
	public boolean delete(String packageDetailsId) {
		 
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM packageDetails WHERE packageDetailsId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,packageDetailsId);
			
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Deleted......");

				} else {
					System.out.println(rowsAffected + " Row(s) Deleted......");

				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		 return result;
	}
	
	public boolean deleteByPackageId(String packageId) {
		 
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM packageDetails WHERE packageId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,packageId);
			
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Deleted......");

				} else {
					System.out.println(rowsAffected + " Row(s) Deleted......");

				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		 return result;
	}
	
	public PackageDetailsBean getByPK(String packageDetailsId) {
		
		 conn=DBConnection.getConnection();	
		 PackageDetailsBean packageDetailsBean =new PackageDetailsBean();
		 
		 if(conn!=null){
			 String selectSQL = "Select * from package,packageDetails,packageDuration where package.packageId = packageDetails.packageId and packageDuration.packageDurationId = packageDetails.packageDurationId AND packageDetailsId=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1, packageDetailsId);
				
				rs = pstmt.executeQuery();

				
				while(rs.next()){
					packageDetailsBean.setPackageName(rs.getString("packageName"));
					packageDetailsBean.setPackageDetailsId(rs.getString("packageDetailsId"));
					packageDetailsBean.setPackageDurationId(rs.getString("packageDurationId"));
					packageDetailsBean.setPackageId(rs.getString("packageId"));
					packageDetailsBean.setPackageRate(rs.getString("packageRate"));
					packageDetailsBean.setPackageDurationTime(rs.getString("packageDurationTime"));
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	return packageDetailsBean;
	}
	
	public boolean update(PackageDetailsBean packageDetailsBean) {
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String updateSQL = "UPDATE packageDetails set packageDurationId=?,packageRate=? WHERE packageDetailsId=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, packageDetailsBean.getPackageDurationId());
				pstmt.setString(2,packageDetailsBean.getPackageRate());
				pstmt.setString(3, packageDetailsBean.getPackageDetailsId());
				
				
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
}
