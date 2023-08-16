package com.nurse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nurse.entity.Appointment;
import com.nurse.utility.DBUtil;


public class AppointmentDAOImpl implements IAppointmentDAO {
	
	@Override
	public int insert(Appointment appointment) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("INSERT INTO appointment VALUES(?,?,?,?,?,?)");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, appointment.getAppointmentId());
			pstStudent.setInt(2, appointment.getUserId());
			pstStudent.setInt(3, appointment.getNurseId());
			pstStudent.setInt(4, appointment.getServiceId());
			pstStudent.setString(5, appointment.getDate());
			pstStudent.setBoolean(6, appointment.isAppointmentStatus());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record inserted successfully with Appointment ID " + appointment.getAppointmentId());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		return status;
	}

	@Override
	public int update(Appointment appointment) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("UPDATE appointment SET customerId=?, nurseId=?, serviceId=?, appointmentDate=?, appointmentStatus=?"
				+ "  WHERE appointmentId=?");

		try {
			connStudent = DBUtil.createConnection();
			
			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, appointment.getUserId());
			pstStudent.setInt(2, appointment.getNurseId());
			pstStudent.setInt(3, appointment.getServiceId());
			pstStudent.setString(4, appointment.getDate());
			pstStudent.setBoolean(5, appointment.isAppointmentStatus());
			pstStudent.setInt(6, appointment.getAppointmentId());

	        status = pstStudent.executeUpdate();

			System.out.println("Record updated successfully with customer ID " + appointment.getAppointmentId());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		return status;
	}
	

	@Override
	public int delete(int appointmentId) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("DELETE FROM appointment WHERE appointmentId=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, appointmentId);
			

			status = pstStudent.executeUpdate();

			System.out.println("Record deleted successfully with appointment ID " + appointmentId);
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		return status;
	
	}

	@Override
	public Appointment viewOne(int appointmentId) {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("SELECT * FROM appointment WHERE appointmentId=?");

		Appointment appointment = null;
		
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, appointmentId);
			

			ResultSet rsAppointment = pstStudent.executeQuery();

			while(rsAppointment.next()){ 
				appointment = new Appointment();
				appointment.setAppointmentId(rsAppointment.getInt("appointmentId"));
				appointment.setUserId(rsAppointment.getInt("customerId"));
				appointment.setNurseId(rsAppointment.getInt("nurseId"));
				appointment.setServiceId(rsAppointment.getInt("serviceId"));
				appointment.setDate(rsAppointment.getString("appointmentDate"));
				appointment.setAppointmentStatus(rsAppointment.getBoolean("appointmentStatus"));
				
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		
		return appointment;
	}

	@Override
	public List<Appointment> viewAll() {
		
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsAppointment = null;
		String sql = new String("SELECT * FROM appointment");

		Appointment appointment = null;
		List<Appointment>appointments = new ArrayList<>();
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);

			rsAppointment = pstStudent.executeQuery();

			while(rsAppointment.next()) {
				appointment = new Appointment();
				appointment.setAppointmentId(rsAppointment.getInt("appointmentId"));
				appointment.setUserId(rsAppointment.getInt("customerId"));
				appointment.setNurseId(rsAppointment.getInt("nurseId"));
				appointment.setServiceId(rsAppointment.getInt("serviceId"));
				appointment.setDate(rsAppointment.getString("appointmentDate"));
				appointment.setAppointmentStatus(rsAppointment.getBoolean("appointmentStatus"));
				
				
				appointments.add(appointment);
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		
		return appointments;
	}
	
}
