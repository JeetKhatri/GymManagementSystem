package com.designhub.fitnessplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.MemberScheduleDetailsBean;
import com.designhub.fitnessplus.bean.TrainerScheduleDetailsBean;
import com.designhub.fitnessplus.util.DBConnection;

public class GetScheduleDAO {

	private static PreparedStatement pstmt = null;
	private static Connection conn = null;
	int rowsAffected = 0;
	ResultSet rs = null;
	boolean chk = false;


	public List<MemberScheduleDetailsBean> memberList(String memberId) {

		List<MemberScheduleDetailsBean> listOfMemberScheduleDetails = new ArrayList<MemberScheduleDetailsBean>();
		conn = DBConnection.getConnection();

		if (conn != null) {

			String selectSQL = "select * from memberScheduleDetails,memberschedule,Activity"
					+ " WHERE memberScheduledetails.memberScheduleId=memberschedule.memberscheduleId"
					+ " AND memberscheduleDetails.memberactivityId=Activity.activityId"
					+ " AND memberSchedule.memberId=? "
					+ " order by memberScheduleDetailsId";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setString(1, memberId);

				rs = pstmt.executeQuery();

				MemberScheduleDetailsBean memberScheduleDetailsBean = null;
				while (rs.next()) {
					memberScheduleDetailsBean = new MemberScheduleDetailsBean();

					memberScheduleDetailsBean.setActivityId(rs
							.getString("activityId"));
					memberScheduleDetailsBean.setActivityName(rs
							.getString("activityName"));
					memberScheduleDetailsBean.setMemberDay(rs
							.getString("memberDay"));
					memberScheduleDetailsBean.setMemberEndTime(rs
							.getString("memberEndTime"));
					memberScheduleDetailsBean.setMemberScheduledetailsId(rs
							.getString("memberScheduledetailsId"));
					memberScheduleDetailsBean.setMemberScheduleId(rs
							.getString("memberScheduleId"));
					memberScheduleDetailsBean.setMemberStartTime(rs
							.getString("memberStartTime"));
					memberScheduleDetailsBean.setMemberId(rs
							.getString("memberId"));

					listOfMemberScheduleDetails.add(memberScheduleDetailsBean);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Size : " + listOfMemberScheduleDetails.size());
		return listOfMemberScheduleDetails;
	}

	public List<TrainerScheduleDetailsBean> trainerList(String trainerId) {

		List<TrainerScheduleDetailsBean> listOfTrainerScheduleDetails = new ArrayList<TrainerScheduleDetailsBean>();
		conn = DBConnection.getConnection();

		if (conn != null) {

			String selectSQL = "select * from trainerScheduleDetails,trainerschedule,Activity"
					+ " WHERE trainerScheduledetails.trainerScheduleId=trainerschedule.trainerscheduleId"
					+ " AND trainerscheduleDetails.traineractivityId=Activity.activityId"
					+ " AND trainerSchedule.trainerId=? "
					+ " order by trainerScheduleDetailsId";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setString(1, trainerId);

				rs = pstmt.executeQuery();

				TrainerScheduleDetailsBean trainerScheduleDetailsBean = null;
				while (rs.next()) {
					trainerScheduleDetailsBean = new TrainerScheduleDetailsBean();

					trainerScheduleDetailsBean.setActivityId(rs
							.getString("activityId"));
					trainerScheduleDetailsBean.setActivityName(rs
							.getString("activityName"));
					trainerScheduleDetailsBean.setTrainerDay(rs
							.getString("trainerDay"));
					trainerScheduleDetailsBean.setTrainerEndTime(rs
							.getString("trainerEndTime"));
					trainerScheduleDetailsBean.setTrainerScheduledetailsId(rs
							.getString("trainerScheduledetailsId"));
					trainerScheduleDetailsBean.setTrainerScheduleId(rs
							.getString("trainerScheduleId"));
					trainerScheduleDetailsBean.setTrainerStartTime(rs
							.getString("trainerStartTime"));
					trainerScheduleDetailsBean.setTrainerId(rs
							.getString("trainerId"));

					listOfTrainerScheduleDetails.add(trainerScheduleDetailsBean);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Size : " + listOfTrainerScheduleDetails.size());
		return listOfTrainerScheduleDetails;
	}

	
}
