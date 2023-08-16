package com.nurse.service;

import java.util.List;
import com.nurse.entity.Nurse;

public interface NurseService {
	public int insertNurse(Nurse nurse);
	public int updateNurse(Nurse nurse);
	public int deleteNurse(int nurseId);
	public Nurse viewNurse(int nurseId);
	public List<Nurse>viewNurses();
}