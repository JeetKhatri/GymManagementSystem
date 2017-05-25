package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.PackageBean;
import com.designhub.fitnessplus.util.DBConnection;

public class PackageDAO 
{

	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	boolean result = false;
	public boolean insert(PackageBean packageBean){
		
		conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO package(packageName) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,packageBean.getPackageName());
				
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
	
	

public List<PackageBean> list(){
		
		List<PackageBean> listOfpackage = new ArrayList<PackageBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from package";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				PackageBean packages = null;
				while(rs.next()){
					packages = new PackageBean();
				
					packages.setPackageId(rs.getString("packageId"));
					packages.setPackageName(rs.getString("packageName"));
									
					listOfpackage.add(packages);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listOfpackage.size());
		return listOfpackage;
}

	
	public boolean delete(String packageId) {
		 
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM package WHERE packageId=?";
			 
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
	
	public PackageBean getByPK(String packageId) {
		
		 conn=DBConnection.getConnection();	
		 PackageBean packageBean=new PackageBean();
		 
		 if(conn!=null){
			 String selectSQL = "Select * from package WHERE packageId=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setString(1, packageId);
				
				rs = pstmt.executeQuery();

				
				while(rs.next()){
					
					packageBean.setPackageId(rs.getString("packageId"));
					packageBean.setPackageName(rs.getString("packageName"));
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	return packageBean;
	}
	
	public boolean update(PackageBean packageBean) {
		 conn=DBConnection.getConnection();	
		
		 if(conn!=null){
			 String updateSQL = "UPDATE package set packageName=? WHERE packageId=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1,packageBean.getPackageName());
				pstmt.setString(2, packageBean.getPackageId());
				
				
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
