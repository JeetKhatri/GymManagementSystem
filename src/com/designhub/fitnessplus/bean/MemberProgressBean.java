package com.designhub.fitnessplus.bean;

public class MemberProgressBean {
	
	private String progressId;
	private String memberId;
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
	public String getProgressId() {
		return progressId;
	}
	public void setProgressId(String progressId) {
		this.progressId = progressId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
