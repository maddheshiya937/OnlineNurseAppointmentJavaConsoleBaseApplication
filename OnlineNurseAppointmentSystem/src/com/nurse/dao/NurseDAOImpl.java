package com.nurse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nurse.entity.Nurse;
import com.nurse.utility.DBUtil;

public class NurseDAOImpl implements INurseDAO {

	@Override
	public int insert(Nurse nurse) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("INSERT INTO nurse VALUES(?,?,?,?)");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, nurse.getNurseId());
			pstStudent.setString(2, nurse.getNurseName());
			pstStudent.setString(3, nurse.getNurseMobileNumber());
			pstStudent.setString(4, nurse.getNurseAddress());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record inserted successfully with nurse ID " + nurse.getNurseId());
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
	public int update(Nurse nurse) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("UPDATE nurse SET nurseName=?, mobileno=?, address=?"
				+ " WHERE nurseId=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setString(1, nurse.getNurseName());
			pstStudent.setString(2, nurse.getNurseMobileNumber());
			pstStudent.setString(3, nurse.getNurseAddress());
			pstStudent.setInt(4, nurse.getNurseId());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record updated successfully with nurse ID " + nurse.getNurseId());
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
	public int delete(int nurseId) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("DELETE FROM nurse WHERE nurseId=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, nurseId);
			

			status = pstStudent.executeUpdate();

			System.out.println("Record deleted successfully with nurse ID " + nurseId);
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
	public Nurse viewOne(int nurseId) {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsNurse = null;
		String sql = new String("SELECT * FROM nurse WHERE nurseId=?");

	    Nurse nurse = null;
		
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, nurseId);
			

			 rsNurse = pstStudent.executeQuery();

			while( rsNurse.next()) {
				nurse = new Nurse(nurseId, sql, sql, sql);
				nurse.setNurseId( rsNurse.getInt("nurseId"));
				nurse.setNurseName(rsNurse.getString("nurseName"));
				nurse.setNurseMobileNumber(rsNurse.getString("mobileno"));
				nurse.setNurseAddress(rsNurse.getString("address"));
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
		
		return nurse;
	}

	@Override
	public List<Nurse> viewAll() {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsNurse = null;
		String sql = new String("SELECT * FROM nurse");

		Nurse nurse = null;
		List<Nurse>nurses = new ArrayList<>();
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);

			rsNurse = pstStudent.executeQuery();

			while( rsNurse.next()) {
				nurse = new Nurse(0, sql, sql, sql);
				nurse.setNurseId( rsNurse.getInt("nurseId"));
				nurse.setNurseName(rsNurse.getString("nurseName"));
				nurse.setNurseMobileNumber(rsNurse.getString("mobileno"));
				nurse.setNurseAddress(rsNurse.getString("address"));
				
				nurses.add(nurse);
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
		
		return nurses;
	}

}