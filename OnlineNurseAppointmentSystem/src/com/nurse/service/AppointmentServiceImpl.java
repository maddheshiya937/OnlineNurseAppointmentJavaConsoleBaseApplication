package com.nurse.service;

import java.util.List;

import com.nurse.dao.AppointmentDAOImpl;
import com.nurse.dao.IAppointmentDAO;
import com.nurse.entity.Appointment;

public class AppointmentServiceImpl implements AppointmentService {

	private IAppointmentDAO appointmentDAO;
	
	public AppointmentServiceImpl() {
		appointmentDAO = new AppointmentDAOImpl();
	}
	
	@Override
	public int insertAppointment(Appointment appointment) {
		return appointmentDAO.insert(appointment);
	}

	@Override
	public int updateAppointment(Appointment appointment) {
		return appointmentDAO.update(appointment);
	}

	@Override
	public int deleteAppointment(int appointmentId) {
		return appointmentDAO.delete(appointmentId);
	}

	@Override
	public Appointment viewAppointment(int appointmentId) {
		return appointmentDAO.viewOne(appointmentId);
	}

	@Override
	public List<Appointment> viewAppointment() {
		return appointmentDAO.viewAll();
	}

}
