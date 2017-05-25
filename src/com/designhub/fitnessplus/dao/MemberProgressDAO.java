package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


import com.designhub.fitnessplus.bean.MemberProgressBean;
import com.designhub.fitnessplus.bean.ProgressBean;
import com.designhub.fitnessplus.util.*;

public class MemberProgressDAO {
	private static PreparedStatement pstmt=null;
	private Connection conn=null;
	int rowsAffected=0;
	private boolean result=false;
	ResultSet rs=null;
	boolean chk=false;
	public boolean insert(ProgressBean progressBean) {
		conn=DBConnection.getConnection();
		try {
			String selectSQL="select * from memberprogress where memberId= ?";
			pstmt=conn.prepareStatement(selectSQL);
			System.out.println("memberIIIIIIId-->"+progressBean.getMemberId());
			pstmt.setString(1, progressBean.getMemberId());
			ResultSet rs=pstmt.executeQuery();
			int progressId=0;
			 while(rs.next()){
				 progressId=rs.getInt("progressId");
				 chk=true;
			 }
			if(!chk)
			{
				String insertSQL="insert into memberProgress(memberId) values ( ? )";
				pstmt=conn.prepareStatement(insertSQL);
				pstmt.setString(1, progressBean.getMemberId());
				rowsAffected=pstmt.executeUpdate();
				if(rowsAffected==0)
					return false;
				
				System.out.println("after MemberProgress");
				String insertProgressSQL="insert into memberprogressdetails(height,weight,bmi,biceps,hips,thigh,neck,forearms,chest,calves,bodyfat,waist, " +
						" progressDateTime,progressId) values (?,?,?,?,?,?,?,?,?,?,?,?,?,LAST_INSERT_ID())";
			//	System.out.println("progressId-->");
				pstmt=conn.prepareStatement(insertProgressSQL);
				pstmt.setString(1,progressBean.getHeight());
				pstmt.setString(2,progressBean.getWeight());
				pstmt.setString(3,progressBean.getBmi());
				pstmt.setString(4, progressBean.getBiceps());
				pstmt.setString(5,progressBean.getHips());
				pstmt.setString(6,progressBean.getThigh());
				pstmt.setString(7,progressBean.getNeck());
				pstmt.setString(8,progressBean.getForearms());
				pstmt.setString(9,progressBean.getChest());
				pstmt.setString(10,progressBean.getCalves());
				pstmt.setString(11,progressBean.getBodyfat());
				pstmt.setString(12,progressBean.getWaist());
				pstmt.setString(13,progressBean.getDatetime());
				rowsAffected=pstmt.executeUpdate();
				if(rowsAffected>0)
				{
					result=true;
				}
				else {
					String deleteSQL="delete from memberProgress where progressId=LAST_INSERT_ID()";//String DeleteSQL="ROLLBACK"; in TutoPoint learn SQL->transection
					 pstmt = conn.prepareStatement(deleteSQL);
					 rowsAffected=pstmt.executeUpdate();
					 if(rowsAffected>0)
					 {
						 System.out.println("Data is RollBacked");
					 }
					result=false;
				}
			}
			else
			{
				System.out.println("else");
				
				String insertProgressSQL="insert into memberprogressdetails(height,weight,bmi,biceps,hips,thigh,neck,forearms,chest,calves,bodyfat,waist, " +
					" progressDateTime,progressId) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				System.out.println("progressId-->");
				pstmt=conn.prepareStatement(insertProgressSQL);
				pstmt.setString(1,progressBean.getHeight());
				pstmt.setString(2,progressBean.getWeight());
				pstmt.setString(3,progressBean.getBmi());
				pstmt.setString(4, progressBean.getBiceps());
				pstmt.setString(5,progressBean.getHips());
				pstmt.setString(6,progressBean.getThigh());
				pstmt.setString(7,progressBean.getNeck());
				pstmt.setString(8,progressBean.getForearms());
				pstmt.setString(9,progressBean.getChest());
				pstmt.setString(10,progressBean.getCalves());
				pstmt.setString(11,progressBean.getBodyfat());
				pstmt.setString(12,progressBean.getWaist());
				pstmt.setString(13,progressBean.getDatetime());
				pstmt.setInt(14,progressId);
//			System.out.println(insertSQL);
//			System.out.println("Waist---->\t"+progressBean.getWaist());
			rowsAffected=pstmt.executeUpdate();
			if(rowsAffected>0)
			{
				result=true;
			}
			else
				result=false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
		
		/*public java.util.List<ProgressBean> list(){
			java.util.List<ProgressBean> progresslist=new ArrayList<ProgressBean>();
			
			String query="select * from memberprogressdetails,memberprogress " +
					"where memberprogressdetails.progressId=memberprogress.progressId";
			ProgressBean progressBean;
			conn=DBConnection.getConnection();
			ResultSet rs=null;
			try {
				pstmt=conn.prepareStatement(query);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					progressBean=new ProgressBean();
					System.out.println("<----");
					
					progressBean.setProgressDetailId(rs.getString("progressDetailId"));
					progressBean.setHeight(rs.getString("height"));
					progressBean.setWeight(rs.getString("weight"));
					progressBean.setBmi(rs.getString("bmi"));
					progressBean.setBiceps(rs.getString("biceps"));
					progressBean.setHips(rs.getString("hips"));
					progressBean.setThigh(rs.getString("thigh"));
					progressBean.setNeck(rs.getString("neck"));
					progressBean.setForearms(rs.getString("forearms"));
					progressBean.setChest(rs.getString("chest"));
					progressBean.setCalves(rs.getString("calves"));
					progressBean.setBodyfat(rs.getString("bodyfat"));
					progressBean.setWaist(rs.getString("waist"));
					progressBean.setDatetime(rs.getString("progressDateTime"));
					progresslist.add(progressBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return progresslist;
		}*/
	
public List<MemberProgressBean> list(){
		
		List<MemberProgressBean> listOfMemberProgress = new ArrayList<MemberProgressBean>();
		
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select *" +
			 					" from member m,memberProgress ms" +
			 					" where m.memberId=ms.memberId";
			 
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				MemberProgressBean memberProgressBean = null;
				while(rs.next()){
					memberProgressBean = new MemberProgressBean();
				
					memberProgressBean.setMemberId(rs.getString("memberId"));
					//memberSchedule.setMemberScheduleId(rs.getString("memberScheduleId"));
					memberProgressBean.setMemberFirstName(rs.getString("memberFirstName"));
					memberProgressBean.setMemberLastName(rs.getString("memberLastName"));
					memberProgressBean.setProgressId(rs.getString("progressId"));
					
									
					listOfMemberProgress.add(memberProgressBean);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		//System.out.println("Size : "+listOfMemberProgress.size());
		return listOfMemberProgress;
	}
		public ProgressBean getByPK(String progressDetailid){
			
			ProgressBean progressBean=new ProgressBean();
			String selectSQL="select * from memberprogressdetails where progressDetailId = ?";
			conn=DBConnection.getConnection();
			ResultSet rs=null;
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setString(1, progressDetailid);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					progressBean.setProgressDetailId(rs.getString("progressDetailId"));
					progressBean.setHeight(rs.getString("height"));
					progressBean.setWeight(rs.getString("weight"));
					progressBean.setBmi(rs.getString("bmi"));
					progressBean.setBiceps(rs.getString("biceps"));
					progressBean.setHips(rs.getString("hips"));
					progressBean.setThigh(rs.getString("thigh"));
					progressBean.setNeck(rs.getString("neck"));
					progressBean.setForearms(rs.getString("forearms"));
					progressBean.setChest(rs.getString("chest"));
					progressBean.setCalves(rs.getString("calves"));
					progressBean.setBodyfat(rs.getString("bodyfat"));
					progressBean.setWaist(rs.getString("waist"));
					progressBean.setDatetime(rs.getString("progressDateTime"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return progressBean;
		}
		
		public boolean update(ProgressBean progressBean)
		{
			conn=DBConnection.getConnection();
			try {
				String updateSQL="update memberprogressdetails SET height=?,weight=?,bmi=?,hips=?,thigh=?,neck=?,forearms=?,chest=?,calves=?,bodyfat=?,waist=?,biceps=? where progressDetailid=?";
				pstmt=conn.prepareStatement(updateSQL);
				pstmt.setString(1,progressBean.getHeight());
				pstmt.setString(2,progressBean.getWeight());
				pstmt.setString(3,progressBean.getBmi());
				pstmt.setString(4,progressBean.getHips());
				pstmt.setString(5,progressBean.getThigh());
				pstmt.setString(6,progressBean.getNeck());
				pstmt.setString(7,progressBean.getForearms());
				pstmt.setString(8,progressBean.getChest());
				pstmt.setString(9,progressBean.getCalves());
				pstmt.setString(10,progressBean.getBodyfat());
				pstmt.setString(11,progressBean.getWaist());
				pstmt.setString(12,progressBean.getBiceps());
				pstmt.setString(13,progressBean.getProgressDetailId());
				rowsAffected=pstmt.executeUpdate();
				if(rowsAffected>0)
				{
					result=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		public boolean delete(String progressId) {

			conn=DBConnection.getConnection();
			String deleteSQL="delete from memberprogress where progressID = "+progressId;
			try {
				pstmt=conn.prepareStatement(deleteSQL);
				rowsAffected=pstmt.executeUpdate();
				if(rowsAffected>0)
				{
					result=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
}
