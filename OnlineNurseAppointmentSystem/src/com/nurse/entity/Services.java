package com.nurse.entity;

import java.util.Objects;

public class Services{
    private int serviceId;
    private String serviceName;
    private String serviceDescription;
    private float serviceCharges;
    
    public Services(int serviceId, String serviceName, String serviceDescription, float serviceCharges){
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.serviceCharges = serviceCharges;
    }
    
    public void setServiceName(String serviceName){
        this.serviceName = serviceName;
    }
    
    public String getServiceName(){
        return serviceName;
    } 
    
    public void setServiceId(int serviceId){
        this.serviceId = serviceId;
    }
    
    public int getServiceId(){
        return serviceId;
    }
    
    public void setServiceDescription(String serviceDescription){
        this.serviceDescription = serviceDescription;
    }
    
    
    public String getServiceDescription(){
        return serviceDescription;
    } 
    
    public void setServiceCharges(float serviceCharges){
        this.serviceCharges = serviceCharges;
    }
    
    public float getServiceCharges(){
        return serviceCharges;
    }

	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceDescription="
				+ serviceDescription + ", serviceCharges=" + serviceCharges + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(serviceCharges, serviceDescription, serviceId, serviceName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Services other = (Services) obj;
		return Float.floatToIntBits(serviceCharges) == Float.floatToIntBits(other.serviceCharges)
				&& Objects.equals(serviceDescription, other.serviceDescription) && serviceId == other.serviceId
				&& Objects.equals(serviceName, other.serviceName);
	} 
    
    
}