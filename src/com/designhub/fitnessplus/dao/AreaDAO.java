package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.AreaBean;
import com.designhub.fitnessplus.util.DBConnection;

public class AreaDAO 
{

	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	boolean result = false;
	public boolean insert(AreaBean areaBean){
		
		conn=DBConnection.getConnection();	
			System.out.println("Call" +areaBean.getAreaPincode());
		 if(conn!=null){
			 String insertSQL = "INSERT INTO area(areaName,cityId,areaPincode) values(?,?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,areaBean.getAreaName());
				pstmt.setString(2, areaBean.getCityId());
				pstmt.setString(3, areaBean.getAreaPincode());
				
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
	
	

	public List<AreaBean> list(){
		
		List<AreaBean> listOfArea = new ArrayList<AreaBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
/*			
			 "select * from bus,bus_type,bus_category,city " +
				"where bus.bus_type_id=bus_type.bus_type_id and " +
				"bus.bus_category_id=bus_category.bus_category_id and "+ 
				"bus.bus_depo_id=city.city_id");

*/
			/* "Select * from area,city" + 
				"where area.cityId = city.cityId";*/
			 
			 String selectSQL = "Select * from area,city where area.cityId = city.cityId order by areaId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				AreaBean area = null;
				while(rs.next()){
					area = new AreaBean();
				
					area.setAreaId(rs.getString("areaId"));
					area.setAreaName(rs.getString("areaName"));
					area.setCityId(rs.getString("cityId"));
					area.setAreaPincode(rs.getString("areaPincode"));
					area.setCityName(rs.getString("cityName"));
					listOfArea.add(area);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listOfArea.size());
		return listOfArea;
}

	
	public boolean delete(String areaId) {
		 
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM area WHERE areaId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,areaId);
			
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
	
	public AreaBean getByPK(String areaId) {
		
		 conn=DBConnection.getConnection();	
		 AreaBean area =new AreaBean();
		 
		 if(conn!=null){
			 
						 
			 String selectSQL = "Select * from area WHERE areaId=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1, areaId);
				
				rs = pstmt.executeQuery();

				
				while(rs.next()){
					 
					area.setAreaId(rs.getString("areaId"));
					area.setAreaName(rs.getString("areaName"));
					area.setCityId(rs.getString("cityId"));
					area.setAreaPincode(rs.getString("areaPincode"));
					
				
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	return area;
	}
	
	public boolean update(AreaBean areaBean) {
		 conn=DBConnection.getConnection();	
			System.out.println("area Name-> "  + areaBean.getAreaName());
			System.out.println("area Id-> "  + areaBean.getAreaId());
			System.out.println("City Id-> "  + areaBean.getCityId());
		 if(conn!=null){
			 String updateSQL = "UPDATE area set areaName=?,cityId=?,areaPincode=? WHERE areaId=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				
				pstmt.setString(1,areaBean.getAreaName());
				pstmt.setString(2, areaBean.getCityId());
				pstmt.setString(3, areaBean.getAreaPincode());
				pstmt.setString(4, areaBean.getAreaId());
				
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
