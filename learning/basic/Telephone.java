package learning.basic;

import java.util.Scanner;
import java.util.logging.*;

public class Telephone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
    
        do {
            number = scanner.nextInt();
    
            switch (number) {
                
                case 1:
                System.out.println("Language selection");
                break;                    
                
                case 2:
                System.out.println("Customer support");
                break;        
                
                case 3:
                System.out.println("Check the balance");
                break;        
                
                case 4:
                System.out.println("Check the loan balance");
                break;
                
                case 0:
                System.out.println("Exit");
                break; 
                
                default:
                break;                    
            }

        } while (number != 0);

        scanner.close();
    }

}
