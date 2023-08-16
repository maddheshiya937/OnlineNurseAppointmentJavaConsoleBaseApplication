package com.nurse.controllers;
import java.util.List;

import com.nurse.entity.Services;
import com.nurse.service.ServicesService;
import com.nurse.service.ServicesServiceImpl;


public class ServicesController {

	private ServicesService servicesService;

	public ServicesController() {
		servicesService = new ServicesServiceImpl();
	}
	
	public void insertService(Services service) {
		int status = servicesService.insertService(service);
		
		if(status > 0) {
			System.out.println("Record inserted successfully.");
		}else {
			System.out.println("Record couldn't be inserted");
		}
	}
	
	public void updateService(Services service) {
		int status = servicesService.updateService(service);
		
		if(status > 0) {
			System.out.println("Record updated successfully.");
		}else {
			System.out.println("Record couldn't be updated");
		}
	}
	
	public void deleteService(int serviceId) {
		int status = servicesService.deleteService(serviceId);
		
		if(status > 0) {
			System.out.println("Record deleted successfully.");
		}else {
			System.out.println("Record couldn't be deleted");
		}
	}
	
	public Services viewService(int serviceId) {
		Services service = servicesService.viewService(serviceId);
		return service;
	}
	
	public List<Services> viewAllServices(){
		return servicesService.viewServices();
	}
}
