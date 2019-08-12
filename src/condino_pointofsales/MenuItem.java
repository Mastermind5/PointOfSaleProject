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

public class MenuItem {

     private int itemNumber;
     private String itemName;
     private double itemPrice;
     
     MenuItem(){
         
     }
  
    
     MenuItem(int itemNumber, String itemName,double itemPrice){
         this.itemName = itemName;
         this.itemNumber = itemNumber;
         this.itemPrice = itemPrice;
     }
     
      public static MenuItem getItemFromList(ArrayList<MenuItem> List,int OrderNumber){
            MenuItem item = new MenuItem();
            
                  for (MenuItem findItem: List) {
               
                       if(findItem.getItemNumber() == OrderNumber){
                           item = findItem;
                       }
		}
            
            return item;
        }
     
    /**
     * @return the itemNumber
     */
    public int getItemNumber() {
        return itemNumber;
    }

    /**
     * @param itemNumber the itemNumber to set
     */
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemPrice
     */
    public double getItemPrice() {
        return itemPrice;
    }

    /**
     * @param itemPrice the itemPrice to set
     */
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    
   
    
     
    
}
