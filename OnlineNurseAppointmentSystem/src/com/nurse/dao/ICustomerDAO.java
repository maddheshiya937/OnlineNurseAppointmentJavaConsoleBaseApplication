package com.nurse.dao;

import java.util.List;

import com.nurse.entity.Customer;

public interface ICustomerDAO {
	int insert(Customer customer);
	int update(Customer customer);
	int delete(int custId);
	Customer viewOne(int custId);
	List<Customer> viewAll();
}