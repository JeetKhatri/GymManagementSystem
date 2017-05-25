package com.designhub.fitnessplus.bean;

public class GymDetailsBean 
{
	private String gymDetailsId;
	private String gymAddress;
	private String gymPhoneNo;
	private String areaId;
	private String areaName;
	private String cityId;
	private String cityName;
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getGymAddress() {
		return gymAddress;
	}
	public void setGymAddress(String gymAddress) {
		this.gymAddress = gymAddress;
	}
	public String getGymPhoneNo() {
		return gymPhoneNo;
	}
	public void setGymPhoneNo(String gymPhoneNo) {
		this.gymPhoneNo = gymPhoneNo;
	}
	public String getGymDetailsId() {
		return gymDetailsId;
	}
	public void setGymDetailsId(String gymDetailsId) {
		this.gymDetailsId = gymDetailsId;
	}
	
}
