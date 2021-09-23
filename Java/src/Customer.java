
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GjejevetePC
 */
public class Customer {
 

	private String name;
	private String surname;
	private String address;
	private String phoneNumber;
	private int ID;
	private static int count = 0;
	
        
        public Customer () { // Empty Constructor- is needed to create a new instance via reflection by your persistence framework. 
		
	}
        //Constructor- is used to initialize the state of an object.
	public Customer (String name, String surname, String address, String phoneNumber) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		ID = ++count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getID() {
		return ID;
	}
        
        @Override
        public String toString(){
            return ("Customer (" + ID + "): " + name + " " + surname
                    + " / address " + address
                    + " / phone number " + phoneNumber);
        }
        
        public String printInfo(){
            return toString();
        }
}

