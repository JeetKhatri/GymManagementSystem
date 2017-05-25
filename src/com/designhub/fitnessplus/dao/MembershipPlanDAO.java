package com.designhub.fitnessplus.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.designhub.fitnessplus.bean.MembershipPlanBean;
import com.designhub.fitnessplus.util.DBConnection;

public class MembershipPlanDAO 
{	
	Statement stmt=null;
	PreparedStatement pstmt=null;
	java.sql.Connection con=null;
	ResultSet rs=null;
	int r=0;
	
	public boolean insert(MembershipPlanBean plan) 
	{
		boolean error = false;
		try {			
			con = DBConnection.getConnection();
			if(con!= null)
			{		
				pstmt = con.prepareStatement("insert into membershipPlan(planName,planDetails,planDuration,planRate) values(?,?,?,?)");
				
				pstmt.setString(1,plan.getPlanName());
				pstmt.setString(2, plan.getPlanDetails());
				pstmt.setString(3,plan.getPlanDuration());
				pstmt.setString(4, plan.getPlanRate());
				r = pstmt.executeUpdate();
				if(r > 0)
				{
					error = true;
				}
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return error;
	}
	public List<MembershipPlanBean> list() 
	{
		List<MembershipPlanBean> listOfMemberShipPlan = new ArrayList<MembershipPlanBean>();
		try {
			con = DBConnection.getConnection();
		
		if (con != null) {

			String selectSQL = "SELECT * FROM membershipPlan";

			
				pstmt = con.prepareStatement(selectSQL);
				rs = pstmt.executeQuery();
				MembershipPlanBean memberShipPlanBean = null;

				while (rs.next()) {
					memberShipPlanBean = new MembershipPlanBean();

					memberShipPlanBean.setPlanId(rs.getString("planId"));
					memberShipPlanBean.setPlanName(rs.getString("planName"));
					memberShipPlanBean.setPlanDuration(rs.getString("planDuration"));
					memberShipPlanBean.setPlanDetails(rs.getString("planDetails"));
					memberShipPlanBean.setPlanRate(rs.getString("planRate"));
					
					

					listOfMemberShipPlan.add(memberShipPlanBean);

				}
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 
		return listOfMemberShipPlan;
	}
	
	public boolean delete(String membershipPlanId)
	{
		boolean chk = false;
		try {
			con = DBConnection.getConnection();
			if(con!= null)
			{	
				pstmt = con.prepareStatement("delete from membershipPlan where planId=?");
				pstmt.setString(1,membershipPlanId);
				int r = pstmt.executeUpdate();
				if(r == 1)
				{
					chk=true;
				}
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return chk;
	}
	
	public MembershipPlanBean getByPK(String membershipPlanId) 
	{	
		MembershipPlanBean plan = new MembershipPlanBean();
		try 
		{
			con=DBConnection.getConnection();	
			if(con!=null)
			{
			    String selectSQL = "Select * from membershipPlan Where planId=?"; 
				pstmt = con.prepareStatement(selectSQL);
				pstmt.setString(1, membershipPlanId);
				rs = pstmt.executeQuery();
				while(rs.next()){
					plan.setPlanId(rs.getString("planId"));
					plan.setPlanName(rs.getString("planName"));
					plan.setPlanDetails(rs.getString("planDetails"));
					plan.setPlanDuration(rs.getString("planDuration"));
					plan.setPlanRate(rs.getString("planRate"));
				}
		 }
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return plan;
	}
	
	public boolean update(MembershipPlanBean plan) 
	{
		boolean msg = false;
		try {			
			con = DBConnection.getConnection();
			if(con!= null)
			{		
				pstmt = con.prepareStatement("update membershipPlan set planName=?,planDetails=?,planDuration=?,planRate=? where planId=?");
				pstmt.setString(1,plan.getPlanName());
				pstmt.setString(2,plan.getPlanDetails());
				pstmt.setString(3,plan.getPlanDuration());
				pstmt.setString(4,plan.getPlanRate());
				pstmt.setString(5,plan.getPlanId());
				r = pstmt.executeUpdate();
				if(r > 0)
				{
					msg = true;
				}
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return msg;
	}
}
