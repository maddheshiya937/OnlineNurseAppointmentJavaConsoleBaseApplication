package com.nurse.controllers;
import java.util.List;

import com.nurse.entity.Appointment;
import com.nurse.service.AppointmentServiceImpl;
import com.nurse.service.AppointmentService;



public class AppointmentController {

	private AppointmentService appointmentService;

	public AppointmentController() {
		appointmentService = new AppointmentServiceImpl();
	}
	
	public void insertAppointment(Appointment appointment) {
		int status = appointmentService.insertAppointment(appointment);
		
		if(status > 0) {
			System.out.println("Record inserted successfully.");
		}else {
			System.out.println("Record couldn't be inserted");
		}
	}
	
	public void updateAppointment(Appointment appointment) {
		int status = appointmentService.updateAppointment(appointment);
		
		if(status > 0) {
			System.out.println("Record updated successfully.");
		}else {
			System.out.println("Record couldn't be updated");
		}
	}
	
	public void deleteAppointment(int appointmentId) {
		int status = appointmentService.deleteAppointment(appointmentId);
		
		if(status > 0) {
			System.out.println("Record deleted successfully.");
		}else {
			System.out.println("Record couldn't be deleted");
		}
	}
	
	public Appointment veiwAppointment(int appointmentId) {
		Appointment appointment = appointmentService.viewAppointment(appointmentId);
		return appointment;
	}
	
	public List<Appointment>veiwAllAppointment(){
		return appointmentService.viewAppointment();
	}
}