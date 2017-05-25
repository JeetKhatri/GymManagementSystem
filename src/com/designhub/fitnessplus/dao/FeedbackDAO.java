package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.FeedbackBean;
import com.designhub.fitnessplus.util.*;

public class FeedbackDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	boolean result = false;
	private ResultSet rs = null;

	public boolean insert(FeedbackBean feedbackbean) {
		conn = DBConnection.getConnection();
		int rowsAffected = 0;
		try {
			String insertSQL = "insert into feedback(name,emailID,feedbackDateTime,feedbackSubjectid,feedbackContent) values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, feedbackbean.getName());
			pstmt.setString(2, feedbackbean.getEmail());
			pstmt.setString(3, feedbackbean.getDate());
			pstmt.setString(4, feedbackbean.getFeedbackSubjectId());
			pstmt.setString(5, feedbackbean.getContent());
			rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<FeedbackBean> list() {
		List<FeedbackBean> feedbacklist = new ArrayList<FeedbackBean>();

		FeedbackBean feedbackbean = null;
		String selectSQL = "select * from feedback,feedbacksubject where " +
							"feedback.feedBacksubjectId=feedBacksubject.feedBacksubjectId";
		
		conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				feedbackbean = new FeedbackBean();
				feedbackbean.setContent(rs.getString("feedbackContent"));
				feedbackbean.setDate(rs.getString("feedbackDateTime"));
				feedbackbean.setEmail(rs.getString("emailId"));
				feedbackbean.setName(rs.getString("name"));
				feedbackbean.setFeedbackSubjectId(rs.getString("feedbackSubjectId"));
				feedbackbean.setFeedbackId(rs.getString("feedbackId"));
				feedbackbean.setFeedbackSubjectName(rs.getString("feedbackSubjectName"));
				
				feedbacklist.add(feedbackbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feedbacklist;
	}

	public boolean delete(String feedbackId) {

		String deleteSQL = "delete from feedback where feedbackId = ?";
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setString(1, feedbackId);
			int rowAffected = pstmt.executeUpdate();
			if (rowAffected > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public FeedbackBean getByPK(String feedbackId) {
		FeedbackBean feedbackbean;
		feedbackbean = new FeedbackBean();
		String selctSQL = "select * from feedback where feedbackId = ?";

		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(selctSQL);
			pstmt.setString(1, feedbackId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				feedbackbean.setContent(rs.getString("feedbackContent"));
				feedbackbean.setDate(rs.getString("feedbackDateTime"));
				feedbackbean.setEmail(rs.getString("emailId"));
				feedbackbean.setName(rs.getString("name"));
				feedbackbean.setFeedbackSubjectId(rs
						.getString("feedbackSubjectId"));
				feedbackbean.setFeedbackId(rs.getString("feedbackId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feedbackbean;
	}

	public boolean update(FeedbackBean feedbackbean) {
		conn = DBConnection.getConnection();
		try {
			String updateSQL = "update feedback set name=?,feedbackSubjectID=?,feedbackContent=? where feedbackId=?";
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setString(1, feedbackbean.getName());
			pstmt.setString(2, feedbackbean.getFeedbackSubjectId());
			pstmt.setString(3, feedbackbean.getContent());
			pstmt.setString(4, feedbackbean.getFeedbackId());
			int rowAffected = pstmt.executeUpdate();
			if (rowAffected > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}