package com.designhub.fitnessplus.bean;

public class TrainerScheduleBean {

	private String trainerId;
	private String trainerScheduleId;
	private String trainerFirstName;
	private String trainerLastName;
	
	
	public String getTrainerFirstName() {
		return trainerFirstName;
	}

	public void setTrainerFirstName(String trainerFirstName) {
		this.trainerFirstName = trainerFirstName;
	}

	public String getTrainerLastName() {
		return trainerLastName;
	}

	public void setTrainerLastName(String trainerLastName) {
		this.trainerLastName = trainerLastName;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerScheduleId() {
		return trainerScheduleId;
	}

	public void setTrainerScheduleId(String trainerScheduleId) {
		this.trainerScheduleId = trainerScheduleId;
	}

}
