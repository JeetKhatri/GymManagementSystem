package com.designhub.fitnessplus.bean;

public class MemberScheduleBean 
{
	private String memberId;
	private String memberScheduleId;
	private String memberFirstName;
	private String memberLastName;
	
	
	public String getMemberFirstName() {
		return memberFirstName;
	}
	public void setMemberFirstName(String memberFirstName) {
		this.memberFirstName = memberFirstName;
	}
	public String getMemberLastName() {
		return memberLastName;
	}
	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberScheduleId() {
		return memberScheduleId;
	}
	public void setMemberScheduleId(String memberScheduleId) {
		this.memberScheduleId = memberScheduleId;
	}
	
}
