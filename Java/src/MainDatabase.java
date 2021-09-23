

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GjejevetePC
 */
public class MainDatabase implements Serializable {
    public static ArrayList<User> accounts = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();

    public MainDatabase(){
        if (getAccount("Denalda") == null) {
            User Denalda = new Manager("Denalda", "Bali", "denalda", "1234", "Tirane", "123", "123",1);
            accounts.add(Denalda);
        }  
         if (getWaiterAccount("Waiter1") == null){
          User Waiter1 = new Waiter ("Mark", "Smith", "mark", "1234", "Tirane", "123", "123",2);
          accounts.add(Waiter1);   
        } 
        if (getWaiterAccount("Waiter2") == null){
          User Waiter2 = new Waiter ("Rahul", "Moller", "rahul", "1234", "Tirane", "123", "123",2);
          accounts.add(Waiter2);
        }
        if (getWaiterAccount("Waiter3") == null){
          User Waiter3 = new Waiter ("Fred", "Robin", "fred", "1234", "Tirane", "123", "123",2);
          accounts.add(Waiter3);
        }
        if (getWaiterAccount("Waiter4") == null){
          User Waiter4 = new Waiter ("Maria", "Singh", "maria", "1234", "Tirane", "123", "123",2);
          accounts.add(Waiter4);
        }
        if (getWaiterAccount("Waiter5") == null){
          User Waiter5 = new Waiter ("Steve", "Brown", "steve", "1234", "Tirane", "123", "123",2);
          accounts.add(Waiter5);  
      }
    }
    
     public User GetUserByID(int id)
    {
       
         for(User cust : accounts) {
                if(cust.getID() == id){
                  return cust;
                }
            }
         return null;
    }
    
    
    public ArrayList<User>  PrintWaiterList()
    {
        ArrayList<User> list = new ArrayList<>();
         for(User cust : accounts) {
                if(cust.getUserType() == 2){
                   list.add(cust);
                }
            }
         return list;
    }
    
    public Customer getCustomer(int id) {
        try {
            for(Customer cust : customers) {
                if(cust.getID() == id){
                    return cust;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getAccount(String username) {
        for(User acc : accounts) {
            if(acc.getUsername().equals(username)) {
                return acc;
            }
        }
        return null;
    }
    
    public User getWaiterAccount (String username){
    for (User Waiteracc : accounts){
        if (Waiteracc.getUsername().equals(username)){
            
        }
      }
   return null; 
   }
        
    public void addCustomer(Customer customer) 
    {
        customers.add(customer);
    }
    
    public User AuthenticateUser(String username, String password) 
    {
        
        
         for(User u : accounts){
             
             if(u.getUsername().equals(username)&& u.getPassword().equals(password))
             {
                 return u;
             }
          
        }
         return null;
        
    }

    public User getUserById(int id)
    {
        for(User user : accounts){
            if(user.getID() == id){
                return user;
            }
        }
        return null;
    }

 public static ArrayList<String> getNames(ArrayList<Customer> customers){
        ArrayList<String> nameList = new ArrayList<>();
        for(Customer cust : customers){
            nameList.add(cust.getName());
        }
        return nameList;
  }    
 
    public void applyDiscounts(double loyalDiscount, double discount, double companyDiscount) {
        for (Customer customer : customers) {
            if (customer instanceof LoyalCustomer) {
                ((LoyalCustomer) customer).setDiscount(discount);
            } else if (customer instanceof CompanyCustomer) {
                ((CompanyCustomer) customer).setDiscount(discount);
                ((CompanyCustomer) customer).setCompanyDiscount(companyDiscount);
            }
        }
    }
}

