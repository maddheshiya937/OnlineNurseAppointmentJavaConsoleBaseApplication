package com.nurse.service;

import java.util.List;

import com.nurse.entity.Customer;

public interface CustomerService {
	public int insertCustomer(Customer customer);
	public int updateCustomer(Customer customer);
	public int deleteCustomer(int custId);
	public Customer viewCustomer(int custId);
	public List<Customer>viewCustomers();
}