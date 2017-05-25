package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.AdminBean;
import com.designhub.fitnessplus.util.DBConnection;

public class AdminDAO {

	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	boolean result = false;
	public boolean insert(AdminBean adminBean){
		
		conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO ADMIN(areaId,adminFirstName,adminLastName,adminEmail,adminGender" +
			 		",adminDOB,adminAddress,adminPhoneNo,adminPassword,adminIsActive,cityId) values(?,?,?,?,?,?,?,?,?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,adminBean.getAreaId());
				pstmt.setString(2,adminBean.getAdminFirstName());
				pstmt.setString(3,adminBean.getAdminLastName());
				pstmt.setString(4,adminBean.getAdminEmail());
				pstmt.setString(5,adminBean.getAdminGender());
				pstmt.setString(6,adminBean.getAdminDOB());
				pstmt.setString(7,adminBean.getAdminAddress());
				pstmt.setString(8,adminBean.getAdminPhoneNo());
				pstmt.setString(9,adminBean.getAdminPassword());
				pstmt.setString(10,adminBean.getAdminIsActive());
				pstmt.setString(11,adminBean.getCityId());
				
				
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
	
	

	public List<AdminBean> list(){
		
		List<AdminBean> listOfAdmin = new ArrayList<AdminBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "SELECT * FROM ADMIN,AREA,CITY " +
			 					"where area.areaId=admin.areaId " +
			 					"AND city.cityId=admin.cityId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				AdminBean admin = null;
				while(rs.next()){
					admin = new AdminBean();

					admin.setAdminId(rs.getString("adminId"));
					admin.setAreaId(rs.getString("areaId"));
					admin.setAdminFirstName(rs.getString("adminFirstName"));
					admin.setAdminLastName(rs.getString("adminLastName"));
					admin.setAdminEmail(rs.getString("adminEmail"));
					admin.setAdminGender(rs.getString("adminGender"));
					admin.setAdminDOB(rs.getString("adminDOB"));
					admin.setAdminAddress(rs.getString("adminAddress"));
					admin.setAdminPhoneNo(rs.getString("adminPhoneNo"));
					admin.setAdminPassword(rs.getString("adminPassword"));
					admin.setAdminIsActive(rs.getString("adminIsActive"));
					admin.setAreaName(rs.getString("areaName"));
					admin.setCityName(rs.getString("cityName"));
					admin.setCityId(rs.getString("cityId"));

					
					
					
					listOfAdmin.add(admin);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listOfAdmin.size());
		return listOfAdmin;
	}

	
	public boolean delete(String adminId) {
		 
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM admin WHERE adminId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,adminId);
			
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
	
	public AdminBean getByPK(String adminId) {
		
		 conn=DBConnection.getConnection();	
		 AdminBean admin =new AdminBean();
		 
		 if(conn!=null){
			 String selectSQL = "SELECT * FROM ADMIN,AREA,CITY " +
			 					"where area.areaId=admin.areaId " +
			 					"AND city.cityId=admin.cityId " +
			 					"AND adminId=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1, adminId);
				
				rs = pstmt.executeQuery();

				
				while(rs.next()){
					 
					admin.setAdminId(rs.getString("adminId"));
					admin.setAreaId(rs.getString("areaId"));
					admin.setAdminFirstName(rs.getString("adminFirstName"));
					admin.setAdminLastName(rs.getString("adminLastName"));
					admin.setAdminEmail(rs.getString("adminEmail"));
					admin.setAdminGender(rs.getString("adminGender"));
					admin.setAdminDOB(rs.getString("adminDOB"));
					admin.setAdminAddress(rs.getString("adminAddress"));
					admin.setAdminPhoneNo(rs.getString("adminPhoneNo"));
					admin.setAdminPassword(rs.getString("adminPassword"));
					admin.setAdminIsActive(rs.getString("adminIsActive"));
					admin.setAreaName(rs.getString("areaName"));
					admin.setCityName(rs.getString("cityName"));
					System.out.println("Admin => " + rs.getString("cityId"));
					admin.setCityId(rs.getString("cityId"));

				
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	return admin;
	}
	
	public boolean update(AdminBean adminBean) {
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String updateSQL = "UPDATE admin set areaId=?,adminFirstName=?,adminLastName=?,adminEmail=?,adminGender=?," +
			 					"adminDOB=?,adminAddress=?,adminPhoneNo=?,adminPassword=?,adminIsActive=?,cityId=? " +
			 					"WHERE ADMINID=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1,adminBean.getAreaId());
				pstmt.setString(2,adminBean.getAdminFirstName());
				pstmt.setString(3,adminBean.getAdminLastName());
				pstmt.setString(4,adminBean.getAdminEmail());
				pstmt.setString(5,adminBean.getAdminGender());
				pstmt.setString(6,adminBean.getAdminDOB());
				pstmt.setString(7,adminBean.getAdminAddress());
				pstmt.setString(8,adminBean.getAdminPhoneNo());
				pstmt.setString(9,adminBean.getAdminPassword());
				pstmt.setString(10,adminBean.getAdminIsActive());
				pstmt.setString(11,adminBean.getCityId());
				pstmt.setString(12,adminBean.getAdminId());
								
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
