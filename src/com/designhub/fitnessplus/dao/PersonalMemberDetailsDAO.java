package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.MemberBean;
import com.designhub.fitnessplus.bean.MemberProgressDetailsBean;
import com.designhub.fitnessplus.util.DBConnection;

public class PersonalMemberDetailsDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;
	
public MemberBean list(String memberId){
	MemberBean memberbean = new MemberBean();
		
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from MEMBER,AREA,CITY,MEMBERTYPE " + 
					 			"where member.areaId = area.areaId " +
					 			"AND member.cityId=city.cityId " +
					 			"AND member.memberTypeId=memberType.memberTypeId " +
					 			"And member.memberId= ?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setString(1, memberId);
				rs = pstmt.executeQuery();

				
				while(rs.next()){
					memberbean.setMemberId(rs.getString("memberId"));
					memberbean.setMemberIsActive(rs.getString("memberIsActive"));
					memberbean.setMemberAddress(rs.getString("memberAddress"));
					memberbean.setMemberDOB(rs.getString("memberDOB"));
					memberbean.setMemberEmail(rs.getString("memberEmail"));
					memberbean.setMemberFirstName(rs.getString("memberFirstName"));
					memberbean.setMemberGender(rs.getString("memberGender"));
					memberbean.setMemberLastName(rs.getString("memberLastName"));
					memberbean.setMemberPassword(rs.getString("memberPassword"));
					memberbean.setMemberPhoneNo(rs.getString("memberPhoneNo"));
					
					
					
					memberbean.setCityId(rs.getString("cityId"));
					memberbean.setCityName(rs.getString("cityName"));
				
					memberbean.setAreaId(rs.getString("areaId"));
					memberbean.setAreaName(rs.getString("areaName"));
					
					memberbean.setMemberTypeId(rs.getString("memberTypeId"));
					memberbean.setMemberTypeName(rs.getString("memberTypeName"));
					
					memberbean.setAnswer(rs.getString("answer"));
					memberbean.setQuestionId(rs.getString("securityQuestionId"));
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		return memberbean;
	}

public java.util.List<MemberProgressDetailsBean> progressList(String memberId){
	java.util.List<MemberProgressDetailsBean> progresslist=new ArrayList<MemberProgressDetailsBean>();
	
	System.out.println("MemberId-------1>"+memberId);
	String query="select * from memberprogressdetails,memberprogress where memberprogressdetails.progressId=memberprogress.progressId AND memberProgress.memberId=?";
	MemberProgressDetailsBean memberProgressDetailsBean;
	conn=DBConnection.getConnection();
	ResultSet rs=null;
	try {
		pstmt=conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			memberProgressDetailsBean=new MemberProgressDetailsBean();
			System.out.println("<----");
			System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
			memberProgressDetailsBean.setProgressDetailId(rs.getString("progressDetailId"));
			memberProgressDetailsBean.setHeight(rs.getString("height"));
			memberProgressDetailsBean.setWeight(rs.getString("weight"));
			memberProgressDetailsBean.setBmi(rs.getString("bmi"));
			memberProgressDetailsBean.setBiceps(rs.getString("biceps"));
			memberProgressDetailsBean.setHips(rs.getString("hips"));
			memberProgressDetailsBean.setThigh(rs.getString("thigh"));
			memberProgressDetailsBean.setNeck(rs.getString("neck"));
			memberProgressDetailsBean.setForearms(rs.getString("forearms"));
			memberProgressDetailsBean.setChest(rs.getString("chest"));
			memberProgressDetailsBean.setCalves(rs.getString("calves"));
			memberProgressDetailsBean.setBodyfat(rs.getString("bodyfat"));
			memberProgressDetailsBean.setWaist(rs.getString("waist"));
			memberProgressDetailsBean.setDatetime(rs.getString("progressDateTime"));
			progresslist.add(memberProgressDetailsBean);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return progresslist;
}

}
