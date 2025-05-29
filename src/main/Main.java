package main;
import items.Item;
import methods.Calculation;
import java.util.Scanner;
public class Main {
	 public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		 // This is the Main to Test the Program
		  Calculation calculation = new Calculation();
	        Scanner scanner = new Scanner(System.in);

	        // Add product details
	        calculation.addItems(new Item("Laptop", 60, 50, 50, 6.5), 1);
	        calculation.addItems(new Item("Mouse", 30, 30, 20, 0.2), 1);
	        calculation.addItems(new Item("Desktop", 100, 150, 50, 20), 1);
	        calculation.addItems(new Item("LCD Screen", 120, 140, 80, 2.6), 1);

	        // Read the order
	        System.out.print("Enter the quantity of laptops: ");
	        int laptopQuantity = scanner.nextInt();
	        System.out.print("Enter the quantity of mice: ");
	        int mouseQuantity = scanner.nextInt();
	        System.out.print("Enter the quantity of desktops: ");
	        int desktopQuantity = scanner.nextInt();
	        System.out.print("Enter the quantity of LCD screens: ");
	        int lcdScreenQuantity = scanner.nextInt();

	        // Add the order to the calculation
	        calculation.addItems(new Item("Laptop", 60, 50, 50, 6.5), laptopQuantity);
	        calculation.addItems(new Item("Mouse", 30, 30, 20, 0.2), mouseQuantity);
	        calculation.addItems(new Item("Desktop", 100, 150, 50, 20), desktopQuantity);
	        calculation.addItems(new Item("LCD Screen", 120, 140, 80, 2.6), lcdScreenQuantity);

	        scanner.close();

	        // Print the item details and calculate the best shipping methods
	        calculation.printItemInfo();
	        calculation.calculateBestShipping();
	        calculation.printShippingPrice();
	    }

}
	
