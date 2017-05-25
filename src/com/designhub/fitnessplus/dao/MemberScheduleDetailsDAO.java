package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.MemberScheduleDetailsBean;
import com.designhub.fitnessplus.util.DBConnection;

public class MemberScheduleDetailsDAO {

	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	boolean result = false;
	public boolean insert(MemberScheduleDetailsBean memberScheduleDetailsBean){
		
		conn=DBConnection.getConnection();	
		System.out.println(memberScheduleDetailsBean.getActivityId()+" <-acivity DAO-> "+memberScheduleDetailsBean.getMemberId());
		 if(conn!=null)
		 {
			 try
			 {
			 boolean chk=false;
			 System.out.println("sdfdsf-> "+memberScheduleDetailsBean.getMemberId());
			 pstmt = conn.prepareStatement("select * from memberSchedule where memberId=?");
			 pstmt.setString(1,memberScheduleDetailsBean.getMemberId());
			 rs = pstmt.executeQuery();
			 while(rs.next()){
				 chk=true;
			 }
			 
			 if(chk)
			 {
				 System.out.println("1 record");
				 String getMemberScheduleId="select memberScheduleId from memberSchedule where memberId=?";
				 pstmt = conn.prepareStatement(getMemberScheduleId);
				 pstmt.setString(1, memberScheduleDetailsBean.getMemberId());
				 
				ResultSet rs =pstmt.executeQuery();
				String memberScheduleId="";
				while(rs.next())
				{
					memberScheduleId=rs.getString("memberScheduleId");
					
				}
				 
				 String insertSQL = "INSERT INTO memberScheduleDetails(memberActivityId,memberStartTime,memberEndTime" +
				 					",memberDay,memberScheduleId) " +
				 					"values(?,?,?,?,?)";
					pstmt = conn.prepareStatement(insertSQL);
					
					pstmt.setString(1,memberScheduleDetailsBean.getActivityId());
					pstmt.setString(2,memberScheduleDetailsBean.getMemberStartTime());
					pstmt.setString(3,memberScheduleDetailsBean.getMemberEndTime());
					pstmt.setString(4,memberScheduleDetailsBean.getMemberDay());
					pstmt.setString(5,memberScheduleId);
					
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
				 String insertMemberScheduleSQL="insert into memberSchedule(memberId) values(?)";			 
					
				 	pstmt = conn.prepareStatement(insertMemberScheduleSQL);
					pstmt.setString(1,memberScheduleDetailsBean.getMemberId());
					
					int rowsAffected=pstmt.executeUpdate();
					 
					if(rowsAffected==0)
					return false;
					else {
						System.out.println("ADDed MemberSchedule.");
					}
				
					String insertSQL = "INSERT INTO memberScheduleDetails(memberActivityId,memberStartTime,memberEndTime,memberDay,memberScheduleId) values(?,?,?,?,LAST_INSERT_ID())";
					pstmt = conn.prepareStatement(insertSQL);
					
					pstmt.setString(1,memberScheduleDetailsBean.getActivityId());
					pstmt.setString(2,memberScheduleDetailsBean.getMemberStartTime());
					pstmt.setString(3,memberScheduleDetailsBean.getMemberEndTime());
					pstmt.setString(4,memberScheduleDetailsBean.getMemberDay());
					
					rowsAffected = pstmt.executeUpdate();
					
					if (rowsAffected > 0) {
						result=true;
						System.out.println(rowsAffected + " Row(s) Inserted......");

					} else {
						 String deleteSQL="delete from memberSchedule where memberScheduleId=LAST_INSERT_ID()";
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
			 /*String insertMemberScheduleSQL="insert into memberSchedule(memberId) values(?)";			 
				pstmt = conn.prepareStatement(insertMemberScheduleSQL);
				pstmt.setInt(1,Integer.parseInt(memberScheduleDetailsBean.getMemberId()));
				int rowsAffected=pstmt.executeUpdate();
				 
				if(rowsAffected==0)
				return false;
				else {
					System.out.println("ADDed MemberSchedule.");
				}
			
				String insertSQL = "INSERT INTO memberScheduleDetails(memberActivityId,memberStartTime,memberEndTime,memberDay,memberScheduleId) values(?,?,?,?,LAST_INSERT_ID())";
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,memberScheduleDetailsBean.getActivityId());
				pstmt.setString(2,memberScheduleDetailsBean.getMemberStartTime());
				pstmt.setString(3,memberScheduleDetailsBean.getMemberEndTime());
				pstmt.setString(4,memberScheduleDetailsBean.getMemberDay());
				
				rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Inserted......");

				} else {
					 String deleteSQL="delete from memberSchedule where memberScheduleId=LAST_INSERT_ID()";
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
	
	

	public List<MemberScheduleDetailsBean> list(String memberId){
		
		List<MemberScheduleDetailsBean> listOfMemberScheduleDetails = new ArrayList<MemberScheduleDetailsBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 
			 String selectSQL = "select * from memberScheduleDetails,memberschedule,Activity" +
			 					" WHERE memberScheduledetails.memberScheduleId=memberschedule.memberscheduleId" +
			 					" AND memberscheduleDetails.memberactivityId=Activity.activityId" +
			 					" AND memberSchedule.memberId=? " +
			 					" order by memberScheduleDetailsId";
			 
			 
			 /*String selectSQL = "Select * from member,memberSchedule,memberScheduleDetails,activity " +
			 					"where member.memberId=memberSchedule.memberId " +
					 			"AND memberScheduleDetails.memberScheduleId=memberSchedule.memberScheduleId " +
					 			"AND memberScheduleDetails.memberActivityId=activity.activityId " +
					 			"order by memberScheduleDetailsId";*/
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1,memberId);
				
				rs = pstmt.executeQuery();

				MemberScheduleDetailsBean memberScheduleDetailsBean = null;
				while(rs.next()){
					memberScheduleDetailsBean = new MemberScheduleDetailsBean();
				
					memberScheduleDetailsBean.setActivityId(rs.getString("activityId"));
					memberScheduleDetailsBean.setActivityName(rs.getString("activityName"));
					memberScheduleDetailsBean.setMemberDay(rs.getString("memberDay"));
					memberScheduleDetailsBean.setMemberEndTime(rs.getString("memberEndTime"));
					memberScheduleDetailsBean.setMemberScheduledetailsId(rs.getString("memberScheduledetailsId"));
					memberScheduleDetailsBean.setMemberScheduleId(rs.getString("memberScheduleId"));
					memberScheduleDetailsBean.setMemberStartTime(rs.getString("memberStartTime"));
					memberScheduleDetailsBean.setMemberId(rs.getString("memberId"));

					listOfMemberScheduleDetails.add(memberScheduleDetailsBean);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listOfMemberScheduleDetails.size());
		return listOfMemberScheduleDetails;
	}

	
	public boolean delete(String memberScheduleDetailsId) {
		 
		     conn=DBConnection.getConnection();	
		     System.out.println("mScheId -> "+memberScheduleDetailsId);
			 if(conn!=null){
			 String deleteSQL = "DELETE FROM memberScheduleDetails WHERE memberScheduleDetailsId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,memberScheduleDetailsId);
			
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
	
	public boolean deleteByMemberScheduleId(String memberScheduleId) {
		 
	     conn=DBConnection.getConnection();	
	     System.out.println("mScheId -> "+memberScheduleId);
		 if(conn!=null){
		 String deleteSQL = "DELETE FROM memberScheduleDetails WHERE memberScheduleId=?";
		 
		 try {
			pstmt = conn.prepareStatement(deleteSQL);
			
			pstmt.setString(1,memberScheduleId);
		
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
	
	public MemberScheduleDetailsBean getByPK(String memberScheduleDetailsId) {
		
		 conn=DBConnection.getConnection();	
		 
		 MemberScheduleDetailsBean memberScheduleDetails =new MemberScheduleDetailsBean();
		 
		 if(conn!=null){
			 String selectSQL ="Select * from member,memberSchedule,memberScheduleDetails,activity " +
	 							"where member.memberId=memberSchedule.memberId " +
			 					"AND memberScheduleDetails.memberScheduleId=memberSchedule.memberScheduleId " +
			 					"AND memberScheduleDetails.memberActivityId=activity.activityId " +
			 					"AND memberScheduleDetailsId=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1, memberScheduleDetailsId);
				
				rs = pstmt.executeQuery();
					
				
				while(rs.next()){
					 
					memberScheduleDetails.setMemberId(rs.getString("memberId"));
					memberScheduleDetails.setActivityId(rs.getString("activityId"));
					memberScheduleDetails.setActivityName(rs.getString("activityName"));
					memberScheduleDetails.setMemberDay(rs.getString("memberDay"));
					memberScheduleDetails.setMemberEndTime(rs.getString("memberEndTime"));
					memberScheduleDetails.setMemberScheduledetailsId(rs.getString("memberScheduledetailsId"));
					memberScheduleDetails.setMemberScheduleId(rs.getString("memberScheduleId"));
					memberScheduleDetails.setMemberStartTime(rs.getString("memberStartTime"));
					
					memberScheduleDetails.setMemberFirstName(rs.getString("memberFirstName"));
					memberScheduleDetails.setMemberLastName(rs.getString("memberLastName"));
				System.out.println("memberID   - > " + rs.getString("memberId"));
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	return memberScheduleDetails;
	}
	
	public boolean update(MemberScheduleDetailsBean memberScheduleDetailsBean) {
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String updateSQL = "UPDATE memberScheduleDetails set memberActivityId=?,memberStartTime=?,memberEndTime=?," +
			 					"memberDay=? " +
			 					"WHERE memberScheduleDetailsId=?";
			 
			 
			 System.out.println("Schedule Details" + memberScheduleDetailsBean.getMemberScheduledetailsId()) ;
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1, memberScheduleDetailsBean.getActivityId());
				pstmt.setString(2,memberScheduleDetailsBean.getMemberStartTime());
				pstmt.setString(3, memberScheduleDetailsBean.getMemberEndTime());
				pstmt.setString(4,memberScheduleDetailsBean.getMemberDay());
				pstmt.setString(5, memberScheduleDetailsBean.getMemberScheduledetailsId());
				
				
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



public  int getMemberId(String memberScheduleDetailsId) {
		int memberId=0;
		String selectSQL="select memberId from memberSchedule,memberScheduleDetails where memberScheduleDetailsId=? and memberSchedule.memberScheduleId=memberScheduleDetails.memberScheduleId";
		conn=DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1, memberScheduleDetailsId);
			
			rs = pstmt.executeQuery();
				
			
			while(rs.next()){
				memberId=rs.getInt("memberID");
			}
			System.out.println("MEMBERID--->"+memberId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberId;
	}
}

