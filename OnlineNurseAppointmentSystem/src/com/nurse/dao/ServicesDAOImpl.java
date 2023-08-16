package com.nurse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nurse.entity.Services;
import com.nurse.utility.DBUtil;

public class ServicesDAOImpl implements IServicesDAO {

	@Override
	public int insert(Services service) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("INSERT INTO service VALUES(?,?,?,?)");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, service.getServiceId());
			pstStudent.setString(2, service.getServiceName());
			pstStudent.setString(3, service.getServiceDescription());
			pstStudent.setFloat(4, service.getServiceCharges());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record inserted successfully with nurse ID " + service.getServiceId());
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
	public int update(Services service) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("UPDATE service SET serviceName=?, serviceDescription=?, charges=?"
				+ " WHERE serviceId=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setString(1, service.getServiceName());
			pstStudent.setString(2, service.getServiceDescription());
			pstStudent.setFloat(3, service.getServiceCharges());
			pstStudent.setInt(4, service.getServiceId());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record updated successfully with nurse ID " + service.getServiceId());
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
	public int delete(int serviceId) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("DELETE FROM nurse WHERE serviceId=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, serviceId);
			

			status = pstStudent.executeUpdate();

			System.out.println("Record deleted successfully with service ID " + serviceId);
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
	public Services viewOne(int serviceId) {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsService = null;
		String sql = new String("SELECT * FROM service WHERE serviceId=?");

	    Services service = null;
		
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, serviceId);
			

			 rsService = pstStudent.executeQuery();

			while( rsService.next()) {
				service = new Services(serviceId, sql, sql, 0);
				service.setServiceId( rsService.getInt("serviceId"));
				service.setServiceName(rsService.getString("serviceName"));
				service.setServiceDescription(rsService.getString("serviceDescription"));
				service.setServiceCharges(rsService.getFloat("charges"));
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
		
		return service;
	}

	@Override
	public List<Services> viewAll() {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsService = null;
		String sql = new String("SELECT * FROM service");

		Services service = null;
		List<Services>services = new ArrayList<>();
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);

			 rsService = pstStudent.executeQuery();

				while( rsService.next()) {
					service = new Services(0, sql, sql, 0);
					service.setServiceId( rsService.getInt("serviceId"));
					service.setServiceName(rsService.getString("serviceName"));
					service.setServiceDescription(rsService.getString("serviceDescription"));
					service.setServiceCharges(rsService.getFloat("charges"));
					
					services.add(service);
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
		
		return services;
	}

}