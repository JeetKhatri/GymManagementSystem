package com.designhub.fitnessplus.bean;


public class FeedbackBean {

		private String date;
		private String name;
		private String email;
		private String content;
		private String subject;
		private String feedbackId; 
		private String feedbackSubjectId;
		private String feedbackSubjectName;
		public String getFeedbackSubjectName() {
			return feedbackSubjectName;
		}

		public void setFeedbackSubjectName(String feedbackSubjectName) {
			this.feedbackSubjectName = feedbackSubjectName;
		}

		public String getFeedbackId() {
			return feedbackId;
		}

		public void setFeedbackId(String feedbackId) {
			this.feedbackId = feedbackId;
		}

		public String getFeedbackSubjectId() {
			return feedbackSubjectId;
		}

		public void setFeedbackSubjectId(String feedbackSubjectId) {
			this.feedbackSubjectId = feedbackSubjectId;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
		
}
