package com.onlineshop;

import java.io.Serializable;

public class Cart implements Serializable{
    public static final long serialVersionUID = -1L;
    private int customerid;
    private int itemid;
    private int quantity;
    private double price;
    private double totalprice;
    private String itemname;
    
    public Cart() {
        
    }
    
    public int getCustomerid()
    {
        return customerid;
    }
    
    public int getItemid()
    {
        return itemid;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public double gettotalprice()
    {
        return totalprice;
    }
    
    public String getitemname()
    {
        return itemname;
    }
    
    public void setCustomerid(int customerid)
    {
        this.customerid = customerid;
    }
    
    public void setItemid(int itemid)
    {
        this.itemid = itemid;
    }
    
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public void settotalprice(double totalprice)
    {
        this.totalprice = totalprice;
    }
    
    public void setitemname(String itemname)
    {
        this.itemname = itemname;
    }
}
