package com.nurse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nurse.entity.Customer;
import com.nurse.utility.DBUtil;

public class CustomerDAOImpl implements ICustomerDAO {

	@Override
	public int insert(Customer customer) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("INSERT INTO customer VALUES(?,?,?,?,?,?)");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, customer.getCustomerId());
			pstStudent.setString(2, customer.getCustomerName());
			pstStudent.setString(3, customer.getCustomerEmail());
			pstStudent.setString(4, customer.getCustomerMobileNumber());
			pstStudent.setString(5, customer.getCustomerAddress());
			pstStudent.setString(6, customer.getCustomerGender());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record inserted successfully with customer ID " + customer.getCustomerId());
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
	public int update(Customer customer) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("UPDATE customer SET customerName=?, customerEmail=?, mobileno=?, address=?, gender=?"
				+ " WHERE customerId=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
	        pstStudent.setString(1, customer.getCustomerName());
	        pstStudent.setString(2, customer.getCustomerEmail());
	        pstStudent.setString(3, customer.getCustomerMobileNumber());
	        pstStudent.setString(4, customer.getCustomerAddress());
	        pstStudent.setString(5, customer.getCustomerGender());
	        pstStudent.setInt(6, customer.getCustomerId());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record updated successfully with customer ID " + customer.getCustomerId());
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
	public int delete(int custId) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("DELETE FROM customer WHERE customerId=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, custId);
			

			status = pstStudent.executeUpdate();

			System.out.println("Record deleted successfully with customer ID " + custId);
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
	public Customer viewOne(int custId) {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsCustomer = null;
		String sql = new String("SELECT * FROM customer WHERE customerId=?");

		Customer customer = null;
		
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, custId);
			

			rsCustomer = pstStudent.executeQuery();

			while(rsCustomer.next()) {
				customer = new Customer(custId, sql, sql, sql, sql, sql);
				customer.setCustomerId(rsCustomer.getInt("customerId"));
				customer.setCustomerName(rsCustomer.getString("customerName"));
				customer.setCustomerEmail(rsCustomer.getString("customerEmail"));
				customer.setCustomerMobileNumber(rsCustomer.getString("mobileno"));
				customer.setCustomerAddress(rsCustomer.getString("address"));
				customer.setCustomerGender(rsCustomer.getString("gender"));
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
		
		return customer;
	}

	@Override
	public List<Customer> viewAll() {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsCustomer = null;
		String sql = new String("SELECT * FROM customer");

		Customer customer = null;
		List<Customer>customers = new ArrayList<>();
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);

			rsCustomer = pstStudent.executeQuery();

			while(rsCustomer.next()) {
				customer = new Customer(0, sql, sql, sql, sql, sql);
				customer.setCustomerId(rsCustomer.getInt("customerId"));
				customer.setCustomerName(rsCustomer.getString("customerName"));
				customer.setCustomerEmail(rsCustomer.getString("customerEmail"));
				customer.setCustomerMobileNumber(rsCustomer.getString("mobileno"));
				customer.setCustomerAddress(rsCustomer.getString("address"));
				customer.setCustomerGender(rsCustomer.getString("gender"));
				
				customers.add(customer);
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
		
		return customers;
	}

}