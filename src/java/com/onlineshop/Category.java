

package com.onlineshop;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author Joel
 */
public class Category implements Serializable{
    public static final long serialVersionUID = -1L;
    private int Categoryid;
    private String CategoryDesc;
    
    public Category(){
        
    }
    
    public int getCategoryid()
    {
        return Categoryid;
    }
    
    public String getCategoryDesc()
    {
        return CategoryDesc;
    }
    
    public void setCategoryid(int Categoryid)
    {
        this.Categoryid = Categoryid;
    }
    
    public void setCategoryDesc(String CategoryDesc)
    {
        this.CategoryDesc = CategoryDesc;
    }
    
    
}
