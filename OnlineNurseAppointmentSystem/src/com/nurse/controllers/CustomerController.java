package com.nurse.controllers;
import java.util.List;

import com.nurse.entity.Customer;
import com.nurse.service.CustomerService;
import com.nurse.service.CustomerServiceImpl;

public class CustomerController {

	private CustomerService customerService;

	public CustomerController() {
		customerService = new CustomerServiceImpl();
	}
	
	public void insertCustomer(Customer customer) {
		int status = customerService.insertCustomer(customer);
		
		if(status > 0) {
			System.out.println("Record inserted successfully.");
		}else {
			System.out.println("Record couldn't be inserted");
		}
	}
	
	public void updateCustomer(Customer customer) {
		int status = customerService.updateCustomer(customer);
		
		if(status > 0) {
			System.out.println("Record updated successfully.");
		}else {
			System.out.println("Record couldn't be updated");
		}
	}
	
	public void deleteCustomer(int custId) {
		int status = customerService.deleteCustomer(custId);
		
		if(status > 0) {
			System.out.println("Record deleted successfully.");
		}else {
			System.out.println("Record couldn't be deleted");
		}
	}
	
	public Customer viewCustomer(int custId) {
		Customer customer = customerService.viewCustomer(custId);
		return customer;
	}
	
	public List<Customer> viewAllCustomers(){
		return customerService.viewCustomers();
	}
}
