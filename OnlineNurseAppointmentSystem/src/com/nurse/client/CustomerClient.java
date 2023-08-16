package com.nurse.client;

import java.util.List;
import java.util.Scanner;

import com.nurse.controllers.AppointmentController;
import com.nurse.controllers.CustomerController;
import com.nurse.controllers.NurseController;
import com.nurse.controllers.ServicesController;
import com.nurse.entity.Appointment;
import com.nurse.entity.Customer;
import com.nurse.entity.Nurse;
import com.nurse.entity.Services;

public class CustomerClient {

	public static void main(String[] args) {
		int choice = -1;
		int innerChoice = -1;
		
		int custId = 0;
		int nurseId= 0;
		int serviceId = 0, cvv=0, pin=0;
		int appointmentId=0;
		String appointmentDate=null;
		String appointmentTime=null;
		String description = null;
		float charges = 0;
		String name = null, debitCardNumber=null;
		String email = null;
		String mobileNo = null; 
		String address = null;
		String gender = null;
		boolean appointmentStatus=false;
		
		
		CustomerController customerController = new CustomerController();
		NurseController nurseController = new NurseController();
		ServicesController serviceController = new ServicesController();
		AppointmentController appointmentController = new AppointmentController();
		
		Customer customer = null;
		Nurse nurse = null;
		Services service = null;
		Appointment appointment = null;
		
		Scanner scInput = new Scanner(System.in);
		do{
			System.out.println("Following is the choice:");
			System.out.println("1. Customer");
			System.out.println("2. Nurse");
			System.out.println("3. Services");
			System.out.println("4. Appointment");
			System.out.println("5. Payment");
			System.out.println("0. Exit");
			
			choice = Integer.parseInt(scInput.nextLine());
			
			switch(choice) {
			case 1:
					do {
						System.out.println("Following is the choice:");
						System.out.println("1. Insert Customer");
						System.out.println("2. Update Customer");
						System.out.println("3. Delete Customer");
						System.out.println("4. View single customer");
						System.out.println("5. View all customers");
						System.out.println("0. Exit");
						
						innerChoice = Integer.parseInt(scInput.nextLine());
						
						switch(innerChoice) {
						case 1:
							System.out.print("Enter customer ID: ");
							custId = Integer.parseInt(scInput.nextLine());
							
							System.out.print("Enter name: ");
							name = scInput.nextLine();
							
							System.out.print("Enter email: ");
							email = scInput.nextLine();
							
							System.out.print("Enter mobile number: ");
							mobileNo = scInput.nextLine();
							
							System.out.print("Enter address: ");
							address = scInput.nextLine();
							
							System.out.print("Enter gender: ");
							gender = scInput.nextLine();
							
							customer = new Customer(custId, name, email, mobileNo, address, gender);
		
							customerController.insertCustomer(customer);
							break;
						case 2:
							System.out.print("Enter customer ID: ");
							custId = Integer.parseInt(scInput.nextLine());
							
							System.out.print("Enter name: ");
							name = scInput.nextLine();
							
							System.out.print("Enter email: ");
							email = scInput.nextLine();
							
							System.out.print("Enter mobile number: ");
							mobileNo = scInput.nextLine();
							
							System.out.print("Enter address: ");
							address = scInput.nextLine();
							
							System.out.print("Enter gender: ");
							gender = scInput.nextLine();
							
							customer = new Customer(custId, name, email, mobileNo, address, gender);
		
							customerController.updateCustomer(customer);
							break;
						case 3:
							System.out.print("Enter customer ID: ");
							custId = Integer.parseInt(scInput.nextLine());
							
							customerController.deleteCustomer(custId);
							break;
						case 4:
							System.out.print("Enter customer ID: ");
							custId = Integer.parseInt(scInput.nextLine());
							
							customer = customerController.viewCustomer(custId);
							System.out.println(customer);
							break;
						case 5:
							List<Customer>customers = customerController.viewAllCustomers();
							
							System.out.println("Following is the customer list:");
							
							for(Customer cust : customers) {
								System.out.println(cust);
							}
							break;							
						}
					}while(innerChoice != 0);
					break;
			case 2:
				do {
					System.out.println("Following is the choice:");
					System.out.println("1. Insert Nurse");
					System.out.println("2. Modify Nurse");
					System.out.println("3. Delete Nurse");
					System.out.println("4. View single nurse");
					System.out.println("5. View all nurses");
					System.out.println("0. Exit");
					
					innerChoice = Integer.parseInt(scInput.nextLine());
					
					switch(innerChoice) {
					case 1:
						System.out.print("Enter nurse ID: ");
						nurseId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter name: ");
						name = scInput.nextLine();
						
						System.out.print("Enter mobile number: ");
						mobileNo = scInput.nextLine();
						
						System.out.print("Enter address: ");
						address = scInput.nextLine();
						
						nurse = new Nurse(nurseId, name, mobileNo, address);
	
						nurseController.insertNurse(nurse);
						break;
					case 2:
						System.out.print("Enter nurse ID: ");
						nurseId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter name: ");
						name = scInput.nextLine();
						
						System.out.print("Enter mobile number: ");
						mobileNo = scInput.nextLine();
						
						System.out.print("Enter address: ");
						address = scInput.nextLine();
						
						nurse = new Nurse(nurseId, name, mobileNo, address);
	
						nurseController.updateNurse(nurse);
						break;
					case 3:
						System.out.print("Enter nurse ID: ");
						nurseId = Integer.parseInt(scInput.nextLine());
						
						nurseController.deleteNurse(nurseId);
						break;
					case 4:
						System.out.print("Enter nurse ID: ");
						nurseId = Integer.parseInt(scInput.nextLine());
						
						nurse = nurseController.viewNurse(nurseId);
						System.out.println(nurse);
						break;
					case 5:
						List<Nurse>nurses = nurseController.viewAllNurses();
						
						System.out.println("Following is the nurses list:");
						
						for(Nurse nrse : nurses) {
							System.out.println(nrse);
						}
						break;							
					}
				} while(innerChoice != 0);
				break;
				
			case 3:
				do {
					System.out.println("Following is the choice:");
					System.out.println("1. Insert Service");
					System.out.println("2. Modify Service");
					System.out.println("3. Delete Service");
					System.out.println("4. View single service");
					System.out.println("5. View all services");
					System.out.println("0. Exit");
					
					innerChoice = Integer.parseInt(scInput.nextLine());
					
					switch(innerChoice) {
					case 1:
						System.out.print("Enter service ID: ");
						serviceId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter service name: ");
						name = scInput.nextLine();
						
						System.out.print("Enter service description: ");
						description = scInput.nextLine();
						
						System.out.print("Enter service charges: ");
						charges = Float.parseFloat(scInput.nextLine());
						
						service = new Services(serviceId, name, description, charges);
	
						serviceController.insertService(service);
						break;
					case 2:
						System.out.print("Enter service ID: ");
						serviceId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter service name: ");
						name = scInput.nextLine();
						
						System.out.print("Enter service description: ");
						description = scInput.nextLine();
						
						System.out.print("Enter service charges: ");
						charges = Float.parseFloat(scInput.nextLine());
						
						service = new Services(serviceId, name, description, charges);
						serviceController.updateService(service);
						break;
					case 3:
						System.out.print("Enter service ID: ");
						serviceId = Integer.parseInt(scInput.nextLine());
						
						serviceController.deleteService(serviceId);
						break;
					case 4:
						System.out.print("Enter service ID: ");
						serviceId = Integer.parseInt(scInput.nextLine());
						
						service = serviceController.viewService(serviceId);
						System.out.println(service);
						break;
					case 5:
						List<Services>services = serviceController.viewAllServices();
						
						System.out.println("Following is the services list:");
						
						for(Services nrse : services) {
							System.out.println(nrse);
						}
						break;							
					}
				} while(innerChoice != 0);
				break;
				
			case 4:
				do {
					
					System.out.println("Following is the choice:");
					System.out.println("1. Insert Appointment");
					System.out.println("2. Update Appointment");
					System.out.println("3. Delete Appointment");
					System.out.println("4. View single Appointment");
					System.out.println("5. View all Appointment");
					System.out.println("0. Exit");
					
					innerChoice = Integer.parseInt(scInput.nextLine());
					
					switch(innerChoice) {
					case 1:
						System.out.print("Enter Appointment ID: ");
						appointmentId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter User ID: ");
						custId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter NurseId: ");
						nurseId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter SurviceId: ");
						serviceId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter Appointment Date : ");
						appointmentDate = scInput.nextLine();
						
						appointmentStatus=true;
						
						
						appointment = new Appointment(appointmentId, custId, nurseId, serviceId, appointmentDate, appointmentStatus);
						
						appointmentController.insertAppointment(appointment);
						
						break;
					case 2:
						System.out.print("Enter Appointment ID: ");
						appointmentId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter User ID: ");
						custId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter NurseId: ");
						nurseId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter SurviceId: ");
						serviceId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter Appointment Date : ");
						appointmentDate = scInput.nextLine();
						
						appointmentStatus=true;
						
						
						appointment = new Appointment(appointmentId, custId, nurseId, serviceId, appointmentDate, appointmentStatus);
						appointmentController.updateAppointment(appointment);
						
						break;
					case 3:
						System.out.print("Enter Appointment ID: ");
						appointmentId = Integer.parseInt(scInput.nextLine());
						
						appointmentController.deleteAppointment(appointmentId);
						
						break;
					case 4:
						System.out.print("Enter Appointment ID: ");
						appointmentId = Integer.parseInt(scInput.nextLine());
						
						appointment = appointmentController.veiwAppointment(appointmentId);  
						System.out.println(appointment);
						break;
					case 5:
						List<Appointment>appointments = appointmentController.veiwAllAppointment();
						
						System.out.println("Following is the appointment list:");
								
						for(Appointment ap : appointments) {
							System.out.println(ap);
						}
						break;
					}
			          } while(innerChoice != 0);
				       break;
			}
		}while(choice != 0);
		scInput.close();
	}
}
