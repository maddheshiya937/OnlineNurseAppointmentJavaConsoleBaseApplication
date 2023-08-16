package com.nurse.service;

import java.util.List;

import com.nurse.dao.INurseDAO;
import com.nurse.dao.NurseDAOImpl;
import com.nurse.entity.Nurse;

public class NurseServiceImpl implements NurseService {

	private INurseDAO nurseDAO;
	
	public NurseServiceImpl() {
		nurseDAO = new NurseDAOImpl();
	}
	
	@Override
	public int insertNurse(Nurse nurse) {
		return nurseDAO.insert(nurse);
	}

	@Override
	public int updateNurse(Nurse nurse) {
		return nurseDAO.update(nurse);
	}

	@Override
	public int deleteNurse(int nurseId) {
		return nurseDAO.delete(nurseId);
	}

	@Override
	public Nurse viewNurse(int nurseId) {
		return nurseDAO.viewOne(nurseId);
	}

	@Override
	public List<Nurse> viewNurses() {
		return nurseDAO.viewAll();
	}

}
