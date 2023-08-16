package com.nurse.dao;

import java.util.List;
import com.nurse.entity.Services;

public interface IServicesDAO {
	int insert(Services service);
	int update(Services service);
	int delete(int serviceId);
	Services viewOne(int serviceId);
	List<Services> viewAll();
}