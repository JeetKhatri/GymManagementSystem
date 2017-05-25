package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.AreaBean;
import com.designhub.fitnessplus.util.DBConnection;

public class AjaxDataDAO {
	
	public List<AreaBean> getAllArea(String cityId) throws SQLException, Exception {

		Statement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<AreaBean> allAreas = null;

		AreaBean bean = null;

		con = DBConnection.getConnection();

		if (con != null) {
		
			stmt = con.createStatement();
			String selectSQL = "SELECT * FROM  AREA WHERE CITYID = "+ cityId;
			System.out.println(selectSQL);
			rs = stmt.executeQuery(selectSQL);

			if (rs != null) {
				bean = new AreaBean();
				allAreas = new ArrayList<AreaBean>();
				bean.setAreaId("");
				bean.setAreaName(" -- Select Area -- ");
				allAreas.add(bean);
				/*for (long infinit = 0; infinit <= 200000000; infinit++) {
					
					This code will generate delay.
					 *Remove this for loop for in project.
					
				}*/
				while (rs.next()) {
					bean = new AreaBean();
					bean.setAreaId(rs.getString("AREAID"));
					bean.setAreaName(rs.getString("AREANAME"));
					bean.setAreaPincode(rs.getString("AREAPINCODE"));
					bean.setCityId(rs.getString("CITYID"));
					allAreas.add(bean);
				}
			}
		}
		System.out.println("AREA List : "+allAreas.size());
		return allAreas;
	}

	/*public List<AreaBean> getAllPackageDuration(String packageId) throws SQLException, Exception {

		Statement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<PackageDurationBean> allPackageDuration = null;

		PackageDurationBean bean = null;

		con = DBConnection.getConnection();

		if (con != null) {
		
			stmt = con.createStatement();
			String selectSQL = "SELECT PACKAGEDURATIONID FROM  PACKAGEDETAILS WHERE PACKAGEID = "+ cityId;
			System.out.println(selectSQL);
			rs = stmt.executeQuery(selectSQL);

			if (rs != null) {
				bean = new PackageDurationBean();
				allAreas = new ArrayList<AreaBean>();
				bean.setAreaId("");
				bean.setAreaName(" -- Select Area -- ");
				allAreas.add(bean);
				for (long infinit = 0; infinit <= 200000000; infinit++) {
					
					This code will generate delay.
					 *Remove this for loop for in project.
					
				}
				while (rs.next()) {
					bean = new AreaBean();
					bean.setAreaId(rs.getString("AREAID"));
					bean.setAreaName(rs.getString("AREANAME"));
					bean.setAreaPincode(rs.getString("AREAPINCODE"));
					bean.setCityId(rs.getString("CITYID"));
					allAreas.add(bean);
				}
			}
		}
		System.out.println("AREA List : "+allAreas.size());
		return allAreas;
	}*/
}
