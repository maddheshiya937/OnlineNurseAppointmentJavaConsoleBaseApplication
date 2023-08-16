package com.nurse.entity;

import java.util.Objects;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String mobileNumber;
    private String address;
    private String gender;
    
    public Customer(int customerId, String customerName, String customerEmail, String mobileNumber, String address, String gender) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.gender = gender;
    }
    
    public int getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(int id) {
    	customerId = id;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String name) {
        customerName = name;
    }
    
    public String getCustomerEmail() {
        return customerEmail;
    }
    
    public void setCustomerEmail(String email) {
        customerEmail = email;
    }
    
    public String getCustomerMobileNumber() {
        return mobileNumber;
    }
    
    public void setCustomerMobileNumber(String number) {
        mobileNumber = number;
    }
    
    public String getCustomerAddress() {
        return address;
    }
    
    public void setCustomerAddress(String addrs) {
        address = addrs;
    }
    public String getCustomerGender() {
        return gender;
    }
    
    public void setCustomerGender(String gndr) {
        gender = gndr;
    }

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", mobileNumber=" + mobileNumber + ", address=" + address + ", gender=" + gender
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, customerEmail, customerId, customerName, gender, mobileNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(customerEmail, other.customerEmail)
				&& customerId == other.customerId && Objects.equals(customerName, other.customerName)
				&& Objects.equals(gender, other.gender) && Objects.equals(mobileNumber, other.mobileNumber);
	}
    
}