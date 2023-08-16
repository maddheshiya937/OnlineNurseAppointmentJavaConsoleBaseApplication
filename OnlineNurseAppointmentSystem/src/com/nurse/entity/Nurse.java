package com.nurse.entity;

import java.util.Objects;

public class Nurse {
    private int nurseId;
    private String nurseName;
    private String nurseMobileNumber;
    private String nurseAddress;
    
    public Nurse(int nurseId, String nurseName, String nurseMobileNumber, String nurseAddress) {
        this.nurseId = nurseId;
        this.nurseName = nurseName;
        this.nurseMobileNumber = nurseMobileNumber;
        this.nurseAddress = nurseAddress;
    }
    
    public int getNurseId() {
        return nurseId;
    }
    
    public void setNurseId(int id) {
    	nurseId = id;
    }
    
    public String getNurseName() {
        return nurseName;
    }
    
    public void setNurseName(String name) {
        nurseName = name;
    }
    
    public String getNurseMobileNumber() {
        return nurseMobileNumber;
    }
    
    public void setNurseMobileNumber(String number) {
        nurseMobileNumber = number;
    }
    
    public String getNurseAddress() {
        return nurseAddress;
    }
    
    public void setNurseAddress(String address) {
        nurseAddress = address;
    }

	@Override
	public String toString() {
		return "Nurse [nurseId=" + nurseId + ", nurseName=" + nurseName + ", nurseMobileNumber=" + nurseMobileNumber
				+ ", nurseAddress=" + nurseAddress + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nurseAddress, nurseId, nurseMobileNumber, nurseName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nurse other = (Nurse) obj;
		return Objects.equals(nurseAddress, other.nurseAddress) && nurseId == other.nurseId
				&& Objects.equals(nurseMobileNumber, other.nurseMobileNumber)
				&& Objects.equals(nurseName, other.nurseName);
	}
    
}