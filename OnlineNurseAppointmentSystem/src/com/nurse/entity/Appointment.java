package com.nurse.entity;

public class Appointment {
        
		private int appointmentId;
        private int userId;
        private int nurseId;
        private int serviceId;
        private String date;
        private boolean appointmentStatus;
        
        public Appointment() {
        	
        }
        
        
        public Appointment(int appointmentId, int userId, int nurseId, int serviceId, String date, boolean appointmentStatus) {
    		super();
    		this.appointmentId = appointmentId;
    		this.userId = userId;
    		this.nurseId = nurseId;
    		this.serviceId = serviceId;
    		this.date = date;
    		this.appointmentStatus = appointmentStatus;
    	}


		public int getAppointmentId() {
			return appointmentId;
		}


		public void setAppointmentId(int appointmentId) {
			this.appointmentId = appointmentId;
		}


		public int getUserId() {
			return userId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}


		public int getNurseId() {
			return nurseId;
		}


		public void setNurseId(int nurseId) {
			this.nurseId = nurseId;
		}


		public int getServiceId() {
			return serviceId;
		}


		public void setServiceId(int serviceId) {
			this.serviceId = serviceId;
		}


		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}


		public boolean isAppointmentStatus() {
			return appointmentStatus;
		}


		public void setAppointmentStatus(boolean appointmentStatus) {
			this.appointmentStatus = appointmentStatus;
		}


		@Override
		public String toString() {
			return "Appointment [appointmentId=" + appointmentId + ", userId=" + userId + ", nurseId=" + nurseId
					+ ", serviceId=" + serviceId + ", date=" + date + ", appointmentStatus=" + appointmentStatus + "]";
		}
        
        
}
