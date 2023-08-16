package com.nurse.dao;
import java.util.List;
import com.nurse.entity.Appointment;

public interface IAppointmentDAO {
	int insert(Appointment appointment);
	int update(Appointment appointment);
	int delete(int appointmentId);
	Appointment viewOne(int appointmentId);
	List<Appointment> viewAll();
}
