/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package condino_pointofsales;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author bland
 */

public class Condino_PointOfSales  {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws IOException {
    Boolean MainLoop = true;
   
    ArrayList<MenuItem> AvailableMenuList =  ReadList();
   
    
    
      while(MainLoop){//Start Main Loop
    WriteMainMenu();
    System.out.print("Choice: ");
    Scanner input = new Scanner(System.in);
    int MenuChoice = input.nextInt();
    
    
       switch(MenuChoice){

       case 1: //Takes Order
       Order  order = new Order(AvailableMenuList);
       System.out.print("\n");
       WriteMcDoMenu(AvailableMenuList);
       
      
        break;
        case 2: //Edits Menu
            
       EditMcDoMenu(AvailableMenuList);
       
        break;    
        case 3: //Closes Application
            System.out.println("Application Shuting Down!");
            MainLoop = false;
            break;
      
        default:
            System.out.println("Input Wrong! Try Again");
            };
            
        }//End of Main Loop
       
    }//End Main Function
    
    
    
    public ArrayList<MenuItem> GetMenuList(ArrayList<MenuItem> List){ //Gets List from txt
        
        
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
         while(EditMcDoMenuLoop){
        System.out.println("\n=================Edit McDonalds Menu=================");
        System.out.println("1. Show Menu\n2. Add Item \n3. Remove Item \n4. Exit to Main Menu ");
        System.out.print("Choice: ");
        choice = new Scanner(System.in).nextInt();
        
        
         switch(choice){
            
             case 1:
                 WriteMcDoMenu(List);
                 break;
              case 2: //Adds Item to List
                   int listLenght = List.size();
                   String itemName;
                   
                   Boolean case1Loop = true;
                   double itemPrice = 0;
                        System.out.print("Name of Item: ");
                        itemName = new Scanner(System.in).next(); //Does Not Take Spaces (Name it as one Ex. FriedChicken)
                        
                        while(case1Loop){
                        try{
                        System.out.print("\nPrice of Item: ");
                        itemPrice = new Scanner(System.in).nextDouble();
                        itemPrice = Math.round(itemPrice);
                        
                            if(itemPrice<=0){
                                System.out.println("Error: Item must be at least P 1");
                                case1Loop = true;
                            }
                            else
                                case1Loop = false;
                        
                            }catch(InputMismatchException  e){
                           System.out.println("Error: "+ e);
                           case1Loop = true;
                            }
                       
                        }
                        
                        AddItemToList(List,new MenuItem(listLenght++,itemName,itemPrice));
                        System.out.println("Item Added");
                        WriteList(List);
                        
                        
                        
                  break;

              case 3://Removes Items to the List\ //Error with itemNumber
                  Scanner input = new Scanner (System.in);
                  
                  Boolean case3Loop = true;
                  int orderNumber = 0;
                  while(case3Loop){
                      
                      try{
                          System.out.print("Order Number: ");
                           orderNumber = input.nextInt();
                      }catch(InputMismatchException e){
                          System.out.println("Error: "+e);
                      }
                          if(orderNumber>List.size()||orderNumber<0){
                                    System.out.println("Error: Order Number Out of Bounds!");
                             }
                          else{
                              break;
                          }       
                  }
                  
                   MenuItem removeItem = MenuItem.getItemFromList(List, orderNumber);
                   
                   System.out.println("Remove item #"+removeItem.getItemNumber()+": "+"  "+removeItem.getItemName()+" with price "  + removeItem.getItemPrice() );
    
                   List.remove(removeItem.getItemNumber());// Removes item From List
                   int i = 0 ;
                   for(MenuItem reIterate : List){ //Re Iterates the Menu
                        reIterate.setItemNumber(i);
                        
                   }
                      WriteList(List);
                   
                  break;
              case 4://Returns to Main Menu
                  EditMcDoMenuLoop = false;
                  break;
              default: 
                  System.out.println("Input Wrong! Try Again");
                  break;
                 
            }
        }       
 
    }
     
    /////////////////////////////////////End of 2nd Option
    
    public static void WriteMcDoMenu(ArrayList<MenuItem> List){
           
           String MenuList="=================McDonalds' Menu=================\n"
                   + "Item Number \t\t Item \t\t\t Item Price";
    
           for (MenuItem item : List) {
               
                        String itemName = item.getItemName();
                        String itemPrice = Double.toString(item.getItemPrice());
                        String itemNumber = Integer.toString(item.getItemNumber());
                      
                MenuList = MenuList.concat("\n"+itemNumber+"\t\t\t"+itemName+"\t\t\tP"+itemPrice+"");
               
		}
           System.out.println(MenuList);
           System.out.println("Number of Items on Menu: "+ List.size());
           
            if(List.isEmpty()){
               System.out.println("Menu :No Menu Available");
           }
         
    }
    
    
    public static ArrayList<MenuItem> ReadList() throws FileNotFoundException, IOException{
        
        ArrayList<MenuItem> CSVList = new ArrayList();
        String FileName = "MenuList.csv";
        File MenuListFile = new File(FileName);
         String line = "",cvsSplitBy = ",";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(MenuListFile));
        String newLine;
         while ((newLine = bufferedReader.readLine()) != null) {
               String[] country = newLine.split(cvsSplitBy);
               int orderNumber = Integer.parseInt(country[0]);
               String Name = country[1];
               double price = Double.parseDouble(country[2]);
               
               CSVList.add(new MenuItem(orderNumber,Name,price));
                  }
         
         return CSVList;
    
    }
    
    public static void WriteList(ArrayList<MenuItem> List){
        
        String FileName = "MenuList.csv";
        File MenuListFile = new File(FileName);
            try{
              
                FileWriter fileWriter = new FileWriter(MenuListFile);
                        
  
                BufferedWriter buffWriter = new BufferedWriter(fileWriter);
                try (PrintWriter printWriter = new PrintWriter(buffWriter)) {
                   
                    
                    for(MenuItem Item : List){
                        printWriter.println(Item.getItemNumber()+", "+Item.getItemName()+", "+Item.getItemPrice());
                    }
                    printWriter.flush();
                    printWriter.close(); 
                }
             
            }catch(IOException e){
             
                System.out.println("WriteList Error: "+e);
            }
    }
    
    
}//End of Class

    
    


