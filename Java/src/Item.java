
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GjejevetePC
 */
public class Item {
   
    private static final AtomicInteger count = new AtomicInteger(0);
    private  String name;
    private  int id;
    private  int CategoryID;
    private  double price;
    
    public Item(String name, int id, double price,int categoryid) 
    {
        super();
        this.name = name;
        this.id = count.incrementAndGet();
        this.price = price;
        this.CategoryID = categoryid;
    }
    
        public Item(String name, int id, double price ) 
    {
        super();
        this.name = name;
        this.id = count.incrementAndGet();
        this.price = price;
         
    }

    public static AtomicInteger getCount() 
    {
        return count;
    }

    public String getName() 
    {
        return name;
    }

    public int getId() 
    {
        return id;
    }

    public double getPrice()
    {
        return price;
    }
}


