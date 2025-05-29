package methods;
import items.Item;
import containers.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import containers.*;
import java.util.HashMap;
public class Calculation {
	
	// List to store the items and containers
    private List<Item> items;
    private List<Container> containers;
    private Map<String, Integer> itemQuantities;

    // Constructor to initialize the lists
    public Calculation() {
        items = new ArrayList<>();
        containers = new ArrayList<>();
        itemQuantities = new HashMap<>();
    }

    // Method to add items to the list
    public void addItems(Item item, int quantity) {
    	 items.add(item);
         String itemName = item.getName();
         itemQuantities.put(itemName, itemQuantities.getOrDefault(itemName, 0) + quantity);
    	// Add the specified number of items to the list
        for (int i = 0; i < quantity; i++) {
            items.add(item);
        }
    }
    public Map<String, Integer> getItemQuantities() {
        return itemQuantities;
    }
    
    // Method to calculate the best shipping methods based on volume
    public void calculateBestShipping() {
        // Calculate the total volume of all items
        double totalVolume = calculateTotalVolume();

        // Variables to track the number of big and small containers needed
        int bigContainerCount = 0;
        int smallContainerCount = 0;
        
        // Determine the number of containers required based on total volume
        while (totalVolume > 0) {
            if (totalVolume >= getBigContainerVolume()) {
                // Add a big container if there is enough volume remaining
                bigContainerCount++;
                totalVolume -= getBigContainerVolume();
            } else {
                // Add a small container if there is not enough volume for a big container
                smallContainerCount++;
                totalVolume -= getSmallContainerVolume();
            }
        }
        
        // Print the shipping methods
        System.out.println("Shipping Methods:");
        if (bigContainerCount > 0) {
            System.out.println(bigContainerCount + " Big Container(s)");
        }
        if (smallContainerCount > 0) {
            System.out.println(smallContainerCount + " Small Container(s)");
        }
    }

    // Method to calculate the total volume of all items
    public double calculateTotalVolume() {
        double totalVolume = 0.0;
        for (Item item : items) {
            // Calculate the volume of each item and sum them up
            totalVolume += item.calculateVolume();
        }
        return totalVolume;
    }
    
 // Method to get the volume of a big container
    public double getBigContainerVolume() {
        // Create a new instance of the BigContainer class and calculate its volume
        return new BigContainer().calculateVolume();
    }

    // Method to get the volume of a small container
    public double getSmallContainerVolume() {
        // Create a new instance of the SmallContainer class and calculate its volume
        return new SmallContainer().calculateVolume();
    }

    // Method to print the details of each item only once
    public void printItemInfo() {
        System.out.println("Item Details:");
        // List to keep track of printed item names
        List<String> printedItems = new ArrayList<>();

        for (Item item : items) {
            String itemName = item.getName();
            if (!printedItems.contains(itemName)) {
                // Print the item details if it hasn't been printed before
                System.out.println(item);
                printedItems.add(itemName);
            }
        }

        System.out.println();
    }
    
    // Method to get the cost of a big container
    private double getBigContainerCost() {
        return 1800.0;
    }
    
 // Method to get the cost of a small container
    private double getSmallContainerCost() {
        return 1000.0;
    }

    // Method to calculate the total shipping price based on container costs
    public double calculateShippingPrice() {
        double totalVolume = calculateTotalVolume();
        double bigContainerCost = getBigContainerCost();
        double smallContainerCost = getSmallContainerCost();

        int bigContainerCount = 0;
        int smallContainerCount = 0;

        while (totalVolume > 0) {
            if (totalVolume >= getBigContainerVolume()) {
                bigContainerCount++;
                totalVolume -= getBigContainerVolume();
            } else {
                smallContainerCount++;
                totalVolume -= getSmallContainerVolume();
            }
        }

        // Calculate the shipping price based on the number of containers and their costs
        return (bigContainerCount * bigContainerCost) + (smallContainerCount * smallContainerCost);
    }
    
    // Method to print the calculated shipping price
    public void printShippingPrice() {
        double shippingPrice = calculateShippingPrice();
        double totalWeigth = calculateTotalWeight();
        System.out.println("Shipping Price: " + shippingPrice + " Euros");
        System.out.println("Total Weight: " + totalWeigth + " kg");
    }  
    
    public double calculateTotalWeight() {
        double totalWeight = 0.0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
    //This part is for the GUI, in order to print the information
    public String getItemDetails() {
        StringBuilder sb = new StringBuilder();
        List<String> printedItems = new ArrayList<>();

        for (Item item : items) {
            String itemName = item.getName();
            if (!printedItems.contains(itemName)) {
                sb.append(item.toString()).append("\n");
                printedItems.add(itemName);
            }
        }

        return sb.toString();
    }
    
    public String getShippingMethods() {
        StringBuilder shippingMethods = new StringBuilder();
        int bigContainerCount = 0;
        int smallContainerCount = 0;
        double totalVolume = calculateTotalVolume();

        while (totalVolume > 0) {
            if (totalVolume >= getBigContainerVolume()) {
                bigContainerCount++;
                totalVolume -= getBigContainerVolume();
            } else {
                smallContainerCount++;
                totalVolume -= getSmallContainerVolume();
            }
        }

        if (bigContainerCount > 0) {
            shippingMethods.append(bigContainerCount).append(" Big Container(s)\n");
        }
        if (smallContainerCount > 0) {
            shippingMethods.append(smallContainerCount).append(" Small Container(s)\n");
        }

        return shippingMethods.toString();
    }
    public class ProductItem {
        private String name;
        private int quantity;

        public ProductItem(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }
    }
    
}
