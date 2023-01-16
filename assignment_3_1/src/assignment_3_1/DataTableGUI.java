package assignment_3_1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DataTableGUI extends JFrame {

	// Declare JTable, JTextFields
    private JTable table;
    private JTextField txtBatchNo;
    private JTextField txtProductID;
    private JTextField txtPrice;
    private JTextField txtQuantity;

    public static void main(String[] args) {
    	// Launch the GUI
        EventQueue.invokeLater(() -> {
            DataTableGUI frame = new DataTableGUI();
            frame.setVisible(true);
        });
    }

    public DataTableGUI() {
    	// Set the window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 300);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        Color blue = new Color(220, 255, 255);
        contentPane.setBackground(blue);
        setBackground(blue);
        setTitle("Updating the Table");
        
        // Create the table with column headers
        table = new JTable(new DefaultTableModel(new Object[][] { }, new String[] { "Batch No", "Product ID", "Price", "Quantity" }));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 11, 480, 137);
        contentPane.add(scrollPane);

        // Create the batch no label and text field
        JLabel lblBatchNo = new JLabel("Batch No:");
        lblBatchNo.setBounds(10, 159, 80, 14);
        contentPane.add(lblBatchNo);

        txtBatchNo = new JTextField();
        txtBatchNo.setBounds(85, 156, 86, 20);
        contentPane.add(txtBatchNo);
        txtBatchNo.setColumns(5);

        // Create the product ID label and text field
        JLabel lblProductId = new JLabel("Product ID:");
        lblProductId.setBounds(190, 159, 80, 14);
        contentPane.add(lblProductId);

        txtProductID = new JTextField();
        txtProductID.setBounds(275, 156, 86, 20);
        contentPane.add(txtProductID);
        txtProductID.setColumns(10);

        // Create the price label and text field
        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(10, 209, 80, 14);
        contentPane.add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(85, 206, 86, 20);
        contentPane.add(txtPrice);
        txtPrice.setColumns(10);

        // Create the quantity label and text field
        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(190, 209, 80, 14);
        contentPane.add(lblQuantity);

        txtQuantity = new JTextField();
        txtQuantity.setBounds(275, 206, 86, 20);
        contentPane.add(txtQuantity);
        
        // Create the insert button
        JButton btnInsert = new JButton("Insert");
        btnInsert.setBounds(400, 155, 89, 23);
        contentPane.add(btnInsert);
        
        // Add action listener to insert button to add data to table
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// Validate data for integers
            	try {
                    int batchNo = Integer.parseInt(txtBatchNo.getText());
                    int productID = Integer.parseInt(txtProductID.getText());
                    int price = Integer.parseInt(txtPrice.getText());
                    int quantity = Integer.parseInt(txtQuantity.getText());
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{batchNo, productID, price, quantity});
                    txtBatchNo.setText("");
                    txtProductID.setText("");
                    txtPrice.setText("");
                    txtQuantity.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid integers for Batch No, Product ID, Price and Quantity.");
                }
            }
        });
        
        // Create the exit button
        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(400, 205, 89, 23);
        contentPane.add(btnExit);
        
        // Add action listener to exit button to exit the program
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
        
        