package com.nurse.service;
import java.util.List;

import com.nurse.entity.Services;

public interface ServicesService {
	public int insertService(Services service);
	public int updateService(Services service);
	public int deleteService(int serviceId);
	public Services viewService(int serviceId);
	public List<Services>viewServices();
}