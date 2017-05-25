package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.FeedbackSubjectBean;
import com.designhub.fitnessplus.util.DBConnection;

public class FeedbackSubjectDAO {
	private PreparedStatement pstmt=null;
	private Connection conn=null;
	int rowsAffected=0;
	boolean result=false;
		public boolean insert(FeedbackSubjectBean feedbackSubjectbean) {
			conn=DBConnection.getConnection();
			try {
				String insertSQL="insert into feedbackSubject(feedbackSubjectName) values (?)";
				pstmt=conn.prepareStatement(insertSQL);
				pstmt.setString(1, feedbackSubjectbean.getFeedbackSubjectName());
				rowsAffected=pstmt.executeUpdate();
				if (rowsAffected > 0) 
					result=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		public List<FeedbackSubjectBean> list() {
			java.util.List<FeedbackSubjectBean> feedbacksubjectlist = new ArrayList<FeedbackSubjectBean>();
			
			conn=DBConnection.getConnection();
			FeedbackSubjectBean feedbacksubjectbean;
			String selectSQL="select * from feedbackSubject order by feedbackSubjectId";
			
			ResultSet rs=null;
			try {
				pstmt=conn.prepareStatement(selectSQL);
				rs=pstmt.executeQuery(selectSQL);
				while(rs.next())
				{
					feedbacksubjectbean=new FeedbackSubjectBean();
					feedbacksubjectbean.setFeedbackSubjectId(rs.getString("feedbackSubjectId"));
					feedbacksubjectbean.setFeedbackSubjectName(rs.getString("feedbackSubjectName"));
					feedbacksubjectlist.add(feedbacksubjectbean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return feedbacksubjectlist;
		}
public  boolean delete(String feedbackSubjectid){
			
			String deleteSQL="delete from feedbackSubject where feedbackSubjectId = ?";
			conn=DBConnection.getConnection();
			try {
				pstmt=conn.prepareStatement(deleteSQL);
				pstmt.setString(1, feedbackSubjectid);
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
public FeedbackSubjectBean getByPK(String feedbackSubjectId) {
	
		FeedbackSubjectBean feedbacksubjectbean;
		feedbacksubjectbean=new FeedbackSubjectBean();
		String selectSQL="select * from feedbackSubject where feedbackSubjectId = ?";
		conn=DBConnection.getConnection();
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(selectSQL);
			pstmt.setString(1, feedbackSubjectId);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				feedbacksubjectbean.setFeedbackSubjectId(rs.getString("feedbackSubjectId"));
				feedbacksubjectbean.setFeedbackSubjectName(rs.getString("feedbackSubjectName"));
			}	
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return feedbacksubjectbean;
}
public boolean update(FeedbackSubjectBean feedbackSubjectBean) {
		conn=DBConnection.getConnection();
		try {
			String updateSQL="update feedbackSubject set feedbackSubjectName = ? where feedbacksubjectId = ?";
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, feedbackSubjectBean.getFeedbackSubjectName());
			pstmt.setString(2, feedbackSubjectBean.getFeedbackSubjectId());
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


