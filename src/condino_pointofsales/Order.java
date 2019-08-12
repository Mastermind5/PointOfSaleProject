/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package condino_pointofsales;

import java.util.ArrayList;

/**
 *
 * @author bland
 */
public class Order extends MenuItem {
    
    private ArrayList<MenuItem> OrderList = new ArrayList<MenuItem>() ;
    private ArrayList<MenuItem> MenuList;
    
    Order(ArrayList<MenuItem> MenuList){ //Constructor
        
    }
    Order( ArrayList<MenuItem> MenuList, MenuItem item){
        
    }
    Order(MenuItem item){
        
    }
    
    public void AddItem(MenuItem item){ //Adds Item to OrderList
        OrderList.add(item);
   
    }
    public double Compute(){
        double Amount = 0;
        
        for(MenuItem item : OrderList){
             Amount = Amount + item.getItemPrice();
        }
        
        return Amount;
    }
    
    
}
