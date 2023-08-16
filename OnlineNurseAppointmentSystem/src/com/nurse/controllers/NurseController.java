package com.nurse.controllers;
import java.util.List;

import com.nurse.entity.Nurse;
import com.nurse.service.NurseService;
import com.nurse.service.NurseServiceImpl;


public class NurseController {

	private NurseService nurseService;

	public NurseController() {
		nurseService = new NurseServiceImpl();
	}
	
	public void insertNurse(Nurse nurse) {
		int status = nurseService.insertNurse(nurse);
		
		if(status > 0) {
			System.out.println("Record inserted successfully.");
		}else {
			System.out.println("Record couldn't be inserted");
		}
	}
	
	public void updateNurse(Nurse nurse) {
		int status = nurseService.updateNurse(nurse);
		
		if(status > 0) {
			System.out.println("Record updated successfully.");
		}else {
			System.out.println("Record couldn't be updated");
		}
	}
	
	public void deleteNurse(int nurseId) {
		int status = nurseService.deleteNurse(nurseId);
		
		if(status > 0) {
			System.out.println("Record deleted successfully.");
		}else {
			System.out.println("Record couldn't be deleted");
		}
	}
	
	public Nurse viewNurse(int nurseId) {
		Nurse nurse = nurseService.viewNurse(nurseId);
		return nurse;
	}
	
	public List<Nurse> viewAllNurses(){
		return nurseService.viewNurses();
	}
}
