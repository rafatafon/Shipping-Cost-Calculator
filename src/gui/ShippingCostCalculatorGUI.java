package gui;
import methods.Calculation;
import containers.*;
import items.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ShippingCostCalculatorGUI extends JFrame {
	
	 private JLabel lblTitle;
	    private JLabel lblProduct;
	    private JComboBox<String> cmbProduct;
	    private JLabel lblQuantity;
	    private JTextField txtQuantity;
	    private JButton btnAddProduct;
	    private JButton btnCalculate;
	    private JTextArea txtOutput;
	    private Calculation calculation;
	    private JButton btnShowOrder; 
	    private OrderPage orderPage; 
	    private JButton btnReset;

	    public ShippingCostCalculatorGUI() {
	        // Initialize the calculation object
	        calculation = new Calculation();

	        // Set up the frame
	        setTitle("Shipping Cost Calculator");
	        setSize(400, 350);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new FlowLayout());

	        // Create and configure the components
	        lblTitle = new JLabel("Shipping Cost Calculator");
	        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));

	        lblProduct = new JLabel("Product:");
	        cmbProduct = new JComboBox<>(new String[]{"Laptop", "Mouse", "Desktop", "LCD"});
	        lblQuantity = new JLabel("Quantity:");
	        txtQuantity = new JTextField(5);

	        btnAddProduct = new JButton("Add Product");
	        btnCalculate = new JButton("Calculate");
	        btnReset = new JButton("Reset");
	        txtOutput = new JTextArea(10, 30);
	        txtOutput.setEditable(false);
	        
	        // Add components to the frame
	        add(lblTitle);
	        add(lblProduct);
	        add(cmbProduct);
	        add(lblQuantity);
	        add(txtQuantity);
	        add(btnAddProduct);
	        add(btnCalculate);
	        add(btnReset);
	        add(new JScrollPane(txtOutput));

	        // Add action listeners to the buttons
	        btnAddProduct.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                addProduct();
	            }
	        });

	        btnCalculate.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                calculateShipping();
	            }
	        });
	        // Add item change listener to reset quantity counter
	        cmbProduct.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                resetQuantityCounter();
	            }
	        });
	        
	        btnShowOrder = new JButton("Show Order"); // Create the new button

	        // Add the new button to the frame
	        add(btnShowOrder);

	        // Create a new instance of OrderPage
	        orderPage = new OrderPage();

	        // Add an action listener to the Show Order button
	        btnShowOrder.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                showOrderPage();
	            }
	        });
	        btnReset.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                resetInputs();
	            }
	        });
	    }
	    private void resetInputs() {
	        cmbProduct.setSelectedIndex(0);
	        txtQuantity.setText("");
	        txtOutput.setText("");
	        calculation = new Calculation();
	    }
	    // Method to reset quantity counter
	       private void resetQuantityCounter() {
	    	   txtQuantity.setText("");
	       }
		private void showOrderPage() {
	        // Update the order details in the OrderPage
	        orderPage.updateOrderDetails(calculation.getItemQuantities());

	        // Show the OrderPage
	        orderPage.setVisible(true);
	    }

	    // Inner class for OrderPage
	    private class OrderPage extends JFrame {
	        private JTextArea txtOrderDetails;

	        public OrderPage() {
	            setTitle("Your Order");
	            setSize(300, 200);
	            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	            setLayout(new FlowLayout());

	            txtOrderDetails = new JTextArea(8, 25);
	            txtOrderDetails.setEditable(false);

	            add(txtOrderDetails);
	        }
	        
	        public void updateOrderDetails(Map<String, Integer> itemQuantities) {
	            // Clear the existing text
	            txtOrderDetails.setText("");

	            // Append the order details for each item
	            for (String item : itemQuantities.keySet()) {
	                int quantity = itemQuantities.get(item);
	                txtOrderDetails.append(item + ": " + quantity + "\n");
	            }
	        }
	    }
	    
	    private void addProduct() {
	        try {
	            String selectedProduct = cmbProduct.getSelectedItem().toString();
	            int quantity = Integer.parseInt(txtQuantity.getText());
	            switch (selectedProduct) {
	                case "Laptop":
	                    calculation.addItems(new Item("Laptop", 60, 50, 50, 6.5), quantity);
	                    break;
	                case "Mouse":
	                    calculation.addItems(new Item("Mouse", 30, 30, 20, 0.2), quantity);
	                    break;
	                case "Desktop":
	                    calculation.addItems(new Item("Desktop", 100, 150, 50, 20), quantity);
	                    break;
	                case "LCD":
	                    calculation.addItems(new Item("LCD", 120, 140, 80, 2.6), quantity);
	                    break;
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "Invalid quantity input. Please enter a valid number.");
	        }
	        // Reset the quantity input field to 1
	        txtQuantity.setText("✓");
	    }
	   
	    private void calculateShipping() {
	        try {
	            calculation.calculateBestShipping();
	            double shippingPrice = calculation.calculateShippingPrice();
	            double totalVolume = calculation.calculateTotalVolume();
	            txtOutput.setText("Item Details:\n" + calculation.getItemDetails() + "\n");
		        txtOutput.append("Shipping Methods:\n" + calculation.getShippingMethods() + "\n");
		        txtOutput.append("Shipping Price:\n" + shippingPrice + " Euros\n");
		        txtOutput.append("Total Weight:\n" + calculation.calculateTotalWeight() + " kg\n");
		        txtOutput.append("Total Volume:\n" + totalVolume + " m³\n");
	            
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(this, "An error occurred during shipping calculation.");
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new ShippingCostCalculatorGUI().setVisible(true);
	            }
	        });
	    } 
}
