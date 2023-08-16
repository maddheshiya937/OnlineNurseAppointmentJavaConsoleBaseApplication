package com.nurse.service;

import java.util.List;

import com.nurse.entity.Appointment;


public interface AppointmentService {
	public int insertAppointment(Appointment appointment);
	public int updateAppointment(Appointment appointment);
	public int deleteAppointment(int appointmentId);
	public Appointment viewAppointment(int appointmentId);
	public List<Appointment>viewAppointment();
}
