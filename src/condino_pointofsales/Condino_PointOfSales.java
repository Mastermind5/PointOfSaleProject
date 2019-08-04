/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package condino_pointofsales;

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
          
    WriteMainMenu();
      Scanner input = new Scanner(System.in);
        System.out.print("Choice: ");
         
      int MenuChoice = input.nextInt();
        
      
   
            switch(MenuChoice){

        case 1:
       WriteMcDoMenu();
          
          
      
        break;
        
        case 2: 
            
        
        break;
      
        default:
            System.out.println("Ye");
    };
            
        
       
    }//End Main Function
    
    public static void  WriteMainMenu(){
        System.out.println("=================Welcome to McDonalds=================");
        System.out.println("1. Take Order \n2. Edit McDonals Menu \n3. Exit application ");

    }
    
    public static void WriteMcDoMenu(){
        System.out.println("1-pc. Chicken Mcdo With Fries \t\t\t\t Php112.0 \n1-pc  Scipy Chicken McDo w/ McSpaghetti"
                +" \t\t Php146.0\n1-pc. Spicy Chicken McDo w/ Rice & Mushroom Soup \t Php146.0\n1-pc. Chicken Mcdo w/ Spaghetti \t\t\t Php144.0"
                +"\n1-pc Chicken Mcdo w/ Rice & Mushroom Soup \t\t Php144.0");
    }
    }
    


