package com.nurse.dao;

import java.util.List;
import com.nurse.entity.Nurse;

public interface INurseDAO {
	int insert(Nurse nurse);
	int update(Nurse nurse);
	int delete(int nurseId);
	Nurse viewOne(int nurseId);
	List<Nurse> viewAll();
}