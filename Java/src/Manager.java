/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GjejevetePC
 */
public class Manager extends User {
	private String internalPhoneNumber;
	private final int position = 0;
        
        

	public Manager(String name, String surname, String username, String password, String address, String phoneNumber, String internalPhoneNumber) {
		super(name, surname, username, password, address, phoneNumber);
		this.internalPhoneNumber = internalPhoneNumber;
	}
        public Manager(String name, String surname, String username, String password, String address, String phoneNumber, String internalPhoneNumber, int UserType) {
		super(name, surname, username, password, address, phoneNumber,UserType);
		this.internalPhoneNumber = internalPhoneNumber;
	}


        
	public String getInternalPhoneNumber(){
		return internalPhoneNumber;
	}
	

	public void setInternalPhoneNumber(String internalPhoneNumber){
		this.internalPhoneNumber = internalPhoneNumber;
	}

	public boolean isManager(){
		if(this.position == 0){
			return true;
		}
		return false;
	}

}


