

package com.onlineshop;

import java.io.Serializable;


public class Catalogue implements Serializable{
    public static final long serialVersionUID = -1L;
    private int itemid;
    private int Categoryid;
    private String item;
    private double ppu;
    
    public Catalogue()
    {
        
    }
    
    public int getitemid()
    {
        return itemid;
    }
    
    public int getCategoryid()
    {
        return Categoryid;
    }
    
    public String getitem()
    {
        return item;
    }
    
    public double getppu()
    {
        return ppu;
    }
    
    public void setitemid(int itemid)
    {
        this.itemid = itemid;
    }
    
    public void setCategoryid(int Categoryid)
    {
        this.Categoryid = Categoryid;
    }
    
    public void setitem(String item)
    {
        this.item = item;
    }
    
    public void setppu(double ppu)
    {
        this.ppu = ppu;
    }
    
    
}
