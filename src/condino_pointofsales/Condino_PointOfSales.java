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
            System.out.println("lol");
        
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
        System.out.print("1-pc. Chicken Mcdo With Fries \n Php112.0 \n 1-pc  Scipy Chicken McDo w/ McSpaghetti "
                +"\nPhp146.0 1-pc. Spicy Chicken McDo w/ Rice & Mushroom soup \n Php146.\n 1-pc. Chicken Mcdo w/ Spaghetti \n Php.144"
                +"1-pc Chicken Mcdo w/ Rice & Mushroom Soup\n Php.144");
    }
    }
    


