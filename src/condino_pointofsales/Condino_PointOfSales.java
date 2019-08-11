/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package condino_pointofsales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author bland
 */

public class Condino_PointOfSales {

    /**
     * @param args the command line arguments
     */
    
   
    
    public static void main(String[] args) {
    Boolean MainLoop = true;
    ArrayList<MenuItem> AvailableMenuList = new ArrayList<>();
    
    
   
         
     
        
      while(MainLoop){//Start Main Loop
    WriteMainMenu();
    System.out.print("Choice: ");
    Scanner input = new Scanner(System.in);
    int MenuChoice = input.nextInt();
    
    
       switch(MenuChoice){

       case 1:
           System.out.print("\n");
       WriteMcDoMenu(AvailableMenuList);
      
        break;
        
        case 2:
            
            EditMcDoMenu(AvailableMenuList);
            
            
      
            
            
            
        break;
        
        case 3:
            System.out.println("Application Shuting Down!");
            MainLoop = false;
            break;
      
        default:
            System.out.println("Input Wrong! Try Again");
            };
            
        }//End of Main Loop
       
    }//End Main Function
    
    public ArrayList<MenuItem> GetMenuList(ArrayList<MenuItem> List){
        
        
        return List;
    }
    
    public static void AddItemToList(ArrayList<MenuItem> List, MenuItem NewMenuItem  ){
        
        List.add(NewMenuItem);
        
    }
    
    /////////////////////////////////////////////////////////
    // User response//
    ////////////////////////////////////////////////////////
    
    public static void  WriteMainMenu(){
        System.out.println("\n=================Welcome to McDonalds=================");
        System.out.println("1. Take Order \n2. Edit McDonalds Menu \n3. Exit application ");
    }
    //////////////////////// 2nd Option
    public static void  EditMcDoMenu(ArrayList<MenuItem> List){
        int choice;
        Boolean EditMcDoMenuLoop = true;
        System.out.println("\n=================Welcome to McDonalds=================");
        System.out.println("1. Add Item \n2. Remove Item \n3. Exit to Main Menu ");
        System.out.print("Choice: ");
        choice = new Scanner(System.in).nextInt();
        
        while(EditMcDoMenuLoop){
         switch(choice){
            
              case 1: 
                   String itemName;
                   double itemPrice;
                        System.out.print("Name of Item: ");
                        itemName = new Scanner(System.in).next();
                        System.out.print("\nPrice of Item: ");
                        itemPrice = new Scanner(System.in).nextDouble();
                        itemPrice = Math.round(itemPrice);
                        
                        AddItemToList(List,new MenuItem(0,itemName,itemPrice));
                  break;
              case 2:
                  break;
              case 3:
                  EditMcDoMenuLoop = false;
                  break;
              default: 
                  System.out.println("Input Wrong! Try Again");
                  break;
                 
            }
        }
        
     
        
       
     
     
    }
       public boolean AddItem(){// Adds Items to List
            
            return true;
        }
    /////////////////////////////////////End of 2nd Option
    
    public static void WriteMcDoMenu(ArrayList<MenuItem> List){
           
           String MenuList="=================McDonalds' Menu=================";
          
           

           for (MenuItem item : List) {
               
                        String itemName = item.getItemName();
                        String itemPrice = Double.toString(item.getItemPrice());
                        String itemNumber = Integer.toString(item.getItemNumber());
                      
                MenuList = MenuList.concat("\n"+itemName+"\t\tP "+itemPrice+"\t\t"+itemNumber+"\n");
               
		}
           System.out.println(MenuList);
           
            if(List.isEmpty()){
               System.out.println("Menu :No Menu Available");
           }
         
    }
    
   
    }
    


