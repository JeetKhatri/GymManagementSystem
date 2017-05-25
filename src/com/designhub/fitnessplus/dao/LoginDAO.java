package com.designhub.fitnessplus.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.designhub.fitnessplus.bean.AdminBean;
import com.designhub.fitnessplus.bean.MemberBean;
import com.designhub.fitnessplus.bean.TrainerBean;
import com.designhub.fitnessplus.util.DBConnection;

public class LoginDAO {

	PreparedStatement pstmt = null;
	java.sql.Connection conn = null;
	ResultSet rs = null;

	public boolean adminLogin(String email, String password) {

		System.out.println("Email"  + email);
		System.out.println("Password"  + password);
		conn = DBConnection.getConnection();
		String selcetSQL = "select * from admin where adminEmail=? AND adminPassword=?";
		boolean result = false;
		AdminBean adminBean = new AdminBean();

		try {
			pstmt = conn.prepareStatement(selcetSQL);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = true;
				adminBean.setAdminId(rs.getString("adminId"));
				adminBean.setAreaId(rs.getString("areaId"));
				adminBean.setAdminFirstName(rs.getString("adminFirstName"));
				adminBean.setAdminLastName(rs.getString("adminLastName"));
				adminBean.setAdminEmail(rs.getString("adminEmail"));
				adminBean.setAdminGender(rs.getString("adminGender"));
				adminBean.setAdminDOB(rs.getString("adminDOB"));
				adminBean.setAdminAddress(rs.getString("adminAddress"));
				adminBean.setAdminPhoneNo(rs.getString("adminPhoneNo"));
				adminBean.setAdminPassword(rs.getString("adminPassword"));
				adminBean.setAdminIsActive(rs.getString("adminIsActive"));

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return result;
	}

	public AdminBean adminLoginBean(String email, String password) {

		conn = DBConnection.getConnection();
		String selcetSQL = "select * from admin where adminEmail=? AND adminPassword=?";
		boolean result = false;
		AdminBean adminBean = new AdminBean();

		try {
			pstmt = conn.prepareStatement(selcetSQL);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = true;
				adminBean.setAdminId(rs.getString("adminId"));
				adminBean.setAreaId(rs.getString("areaId"));
				adminBean.setAdminFirstName(rs.getString("adminFirstName"));
				adminBean.setAdminLastName(rs.getString("adminLastName"));
				adminBean.setAdminEmail(rs.getString("adminEmail"));
				adminBean.setAdminGender(rs.getString("adminGender"));
				adminBean.setAdminDOB(rs.getString("adminDOB"));
				adminBean.setAdminAddress(rs.getString("adminAddress"));
				adminBean.setAdminPhoneNo(rs.getString("adminPhoneNo"));
				adminBean.setAdminPassword(rs.getString("adminPassword"));
				adminBean.setAdminIsActive(rs.getString("adminIsActive"));

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return adminBean;
	}

	public boolean memberLogin(String email, String password) {

		boolean result = false;
		conn = DBConnection.getConnection();
		String selcetSQL = "select * from member where memberEmail=? AND memberPassword=?";
		MemberBean memberBean = new MemberBean();

		try {
			pstmt = conn.prepareStatement(selcetSQL);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = true;
				memberBean.setAreaId(rs.getString("areaId"));
				memberBean.setMemberIsActive(rs.getString("memberIsActive"));
				memberBean.setMemberAddress(rs.getString("memberAddress"));
				memberBean.setMemberDOB(rs.getString("memberDOB"));
				memberBean.setMemberEmail(rs.getString("memberEmail"));
				memberBean.setMemberFirstName(rs.getString("memberFirstName"));
				memberBean.setMemberGender(rs.getString("memberGender"));
				memberBean.setMemberId(rs.getString("memberId"));
				memberBean.setMemberLastName(rs.getString("memberLastName"));
				memberBean.setMemberPassword(rs.getString("memberPassword"));
				memberBean.setMemberPhoneNo(rs.getString("memberPhoneNo"));
				memberBean.setMemberTypeId(rs.getString("memberTypeId"));
				memberBean.setCityId(rs.getString("cityId"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return result;
	}

	public MemberBean memberLoginBean(String email, String password) {

		boolean result = false;
		conn = DBConnection.getConnection();
		String selcetSQL = "Select * from MEMBER,AREA,CITY,MEMBERTYPE " + 
					 		"where member.areaId = area.areaId " +
					 		"AND member.cityId=city.cityId " +
					 		"AND member.memberTypeId=memberType.memberTypeId" + 
						   " AND memberEmail=? AND memberPassword=?";
		MemberBean memberBean = new MemberBean();

		try {
			pstmt = conn.prepareStatement(selcetSQL);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = true;
				memberBean.setAreaId(rs.getString("areaId"));
				memberBean.setMemberIsActive(rs.getString("memberIsActive"));
				memberBean.setMemberAddress(rs.getString("memberAddress"));
				memberBean.setMemberDOB(rs.getString("memberDOB"));
				memberBean.setMemberEmail(rs.getString("memberEmail"));
				memberBean.setMemberFirstName(rs.getString("memberFirstName"));
				memberBean.setMemberGender(rs.getString("memberGender"));
				memberBean.setMemberId(rs.getString("memberId"));
				memberBean.setMemberLastName(rs.getString("memberLastName"));
				memberBean.setMemberPassword(rs.getString("memberPassword"));
				memberBean.setMemberPhoneNo(rs.getString("memberPhoneNo"));
				memberBean.setMemberTypeId(rs.getString("memberTypeId"));
				memberBean.setCityId(rs.getString("cityId"));
				memberBean.setCityName(rs.getString("cityName"));
			
				memberBean.setAreaId(rs.getString("areaId"));
				memberBean.setAreaName(rs.getString("areaName"));
				
				memberBean.setMemberTypeId(rs.getString("memberTypeId"));
				memberBean.setMemberTypeName(rs.getString("memberTypeName"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return memberBean;
	}

	public boolean trainerLogin(String email, String password) {

		System.out.println(email);
		System.out.println(password);
		conn = DBConnection.getConnection();
		boolean result = false;
		String selcetSQL = "select * from trainer where trainerEmail=? and trainerPassword=?";

		TrainerBean trainerBean = new TrainerBean();

		try {
			pstmt = conn.prepareStatement(selcetSQL);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = true;
				System.out.println("------");
				trainerBean.setAreaId(rs.getString("areaId"));
				// trainerBean.setTrainerIsActive(rs.getString("trainerActive"));
				trainerBean.setTrainerAddress(rs.getString("trainerAddress"));
				trainerBean.setTrainerDOB(rs.getString("trainerDOB"));
				trainerBean.setTrainerEmail(rs.getString("trainerEmail"));
				trainerBean.setTrainerFirstName(rs
						.getString("trainerFirstName"));
				trainerBean.setTrainerGender(rs.getString("trainerGender"));
				trainerBean.setTrainerId(rs.getString("trainerId"));
				trainerBean.setTrainerLastName(rs.getString("trainerLastName"));
				trainerBean.setTrainerPassWord(rs.getString("trainerPassWord"));
				trainerBean.setTrainerPhoneNo(rs.getString("trainerPhoneNo"));
				trainerBean.setTrainerExperience(rs
						.getString("trainerExperience"));

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return result;
	}

	public TrainerBean trainerLoginBean(String email, String password) {

		System.out.println(email);
		System.out.println(password);
		conn = DBConnection.getConnection();
		boolean result = false;
		String selcetSQL = "Select * from TRAINER,AREA,CITY " + 
					 		"where trainer.areaId = area.areaId " +
					 		"AND trainer.cityId=city.cityId " +
						   " AND trainerEmail=? AND trainerPassword=?";
		TrainerBean trainerBean = new TrainerBean();

		try {
			pstmt = conn.prepareStatement(selcetSQL);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = true;
				System.out.println("------");
				trainerBean.setAreaId(rs.getString("areaId"));
				// trainerBean.setTrainerIsActive(rs.getString("trainerActive"));
				trainerBean.setTrainerAddress(rs.getString("trainerAddress"));
				trainerBean.setTrainerDOB(rs.getString("trainerDOB"));
				trainerBean.setTrainerEmail(rs.getString("trainerEmail"));
				trainerBean.setTrainerFirstName(rs
						.getString("trainerFirstName"));
				trainerBean.setTrainerGender(rs.getString("trainerGender"));
				trainerBean.setTrainerId(rs.getString("trainerId"));
				trainerBean.setTrainerLastName(rs.getString("trainerLastName"));
				trainerBean.setTrainerPassWord(rs.getString("trainerPassWord"));
				trainerBean.setTrainerPhoneNo(rs.getString("trainerPhoneNo"));
				trainerBean.setTrainerExperience(rs
						.getString("trainerExperience"));
				trainerBean.setCityId(rs.getString("cityId"));
				trainerBean.setCityName(rs.getString("cityName"));
			
				trainerBean.setAreaId(rs.getString("areaId"));
				trainerBean.setAreaName(rs.getString("areaName"));
			
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return trainerBean;
	}

	public MemberBean getForgotDetailMember(String memberEmail) {
		MemberBean memberBean = new MemberBean();
		conn = DBConnection.getConnection();
		if (conn != null) {
			String selectSQL = "select * from member,securityQuestions " +
								"where member.securityQuestionId=securityQuestions.securityQuestionId " +
								"AND memberEmail=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setString(1, memberEmail);
				ResultSet rs = pstmt.executeQuery();
				int cnt = 0;
				while (rs.next()) {
					memberBean.setMemberId(rs.getString("memberId"));
					memberBean.setQuestion(rs.getString("securityQuestion"));
					cnt++;
				}

				memberBean.setCityId(String.valueOf(cnt)); // Use as Flag
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return memberBean;

	}

	public TrainerBean getForgotDetailTrainer(String trainerEmail) {
		TrainerBean trainerBean = new TrainerBean();
		conn = DBConnection.getConnection();
		if (conn != null) {
			String selectSQL = "select * from trainer,securityQuestions " +
								"where trainer.securityQuestionId=securityQuestions.securityQuestionId " +
								"AND trainerEmail=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setString(1, trainerEmail);
				ResultSet rs = pstmt.executeQuery();
				int cnt = 0;
				while (rs.next()) {
					trainerBean.setTrainerId(rs.getString("trainerId"));
					trainerBean.setQuestion(rs.getString("securityQuestion"));
					cnt++;
				}

				trainerBean.setCityId(String.valueOf(cnt)); // Use as Flag
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return trainerBean;

	}

	public boolean checkSecurityAnswer(String memberId,String securityAnswer) {
		
		conn=DBConnection.getConnection();
		boolean flag=false;
		
		if(conn!=null)
		{
			String selectSQL="select * from member " +
							 "where answer=? AND memberId=?";
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setString(1,securityAnswer);
				pstmt.setString(2,memberId);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					flag=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}
		return flag;
		
	}

	
}
