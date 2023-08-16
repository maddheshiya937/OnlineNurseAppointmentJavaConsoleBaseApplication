package com.nurse.service;

import java.util.List;

import com.nurse.dao.IServicesDAO;
import com.nurse.dao.ServicesDAOImpl;
import com.nurse.entity.Services;

public class ServicesServiceImpl implements ServicesService {

	private IServicesDAO serviceDAO;
	
	public ServicesServiceImpl() {
		serviceDAO = new ServicesDAOImpl();
	}
	
	@Override
	public int insertService(Services service) {
		return serviceDAO.insert(service);
	}

	@Override
	public int updateService(Services service) {
		return serviceDAO.update(service);
	}

	@Override
	public int deleteService(int serviceId) {
		return serviceDAO.delete(serviceId);
	}

	@Override
	public Services viewService(int serviceId) {
		return serviceDAO.viewOne(serviceId);
	}

	@Override
	public List<Services> viewServices() {
		return serviceDAO.viewAll();
	}

}
