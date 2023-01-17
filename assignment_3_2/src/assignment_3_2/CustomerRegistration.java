package assignment_3_2;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class CustomerRegistration extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField contactField;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JTextField emailField;
    private JTextArea addressArea;
    private JButton submitButton;
    private JButton clearButton;
    private JButton exitButton;

    public CustomerRegistration() {
        // Set the window title
        setTitle("Customer Registration");

        // Set the layout manager
        setLayout(null);
        
        // Window title
        JLabel titleLabel = new JLabel("Customer Registration Form");
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(200, 10, 600, 80);
        add(titleLabel);

        // Create and add the first name field
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(30, 120, 100, 25);
        add(firstNameLabel);
        firstNameField = new JTextField();
        firstNameField.setBounds(130, 120, 200, 25);
        add(firstNameField);

        // Create and add the last name field
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(30, 170, 100, 25);
        add(lastNameLabel);
        lastNameField = new JTextField();
        lastNameField.setBounds(130, 170, 200, 25);
        add(lastNameField);

        // Create and add the username field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(400, 120, 100, 25);
        add(usernameLabel);
        usernameField = new JTextField();
        usernameField.setBounds(500, 120, 200, 25);
        add(usernameField);

        // Create and add the password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(400, 170, 100, 25);
        add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(500, 170, 200, 25);
        add(passwordField);

        // Create and add the contact field
        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(30, 230, 100, 25);
        add(contactLabel);
        contactField = new JTextField();
        contactField.setBounds(130, 230, 200, 25);
        add(contactField);

        // Create and add the gender radio buttons
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(400, 230, 100, 25);
        add(genderLabel);
        maleButton = new JRadioButton("Male");
        maleButton.setBounds(500, 230, 60, 25);
        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(570, 230, 80, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        add(maleButton);
        add(femaleButton);

        // Create and add the email field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 280, 100, 25);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(130, 280, 200, 25);
        add(emailField);

        // Create and add the address area
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(400, 280, 100, 25);
        add(addressLabel);
        addressArea = new JTextArea();
        addressArea.setBounds(500, 280, 200, 100);
        add(addressArea);

        // Create and add the submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 430, 100, 25);
        
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input data
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String contact = contactField.getText();
                String gender = maleButton.isSelected() ? "Male" : "Female";
                //String gender = maleButton.isSelected();
                String email = emailField.getText();
                String address = addressArea.getText();

                // Connect to the database
                try (Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Customer_database", "root", "rootSQL123")) {

                    // Create the insert statement
                    String sql = "INSERT INTO customer_details (first_name, last_name, username, password, contact, gender, email, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = con.prepareStatement(sql);

                    // Set the values for the prepared statement
                    pstmt.setString(1, firstName);
                    pstmt.setString(2, lastName);
                    pstmt.setString(3, username);
                    pstmt.setString(4, password);
                    pstmt.setString(5, contact);
                    pstmt.setString(6, gender);
                    pstmt.setString(7, email);
                    pstmt.setString(8, address);

                    // Execute the insert statement
                    pstmt.executeUpdate();

                    // Confirm the insertion
                    JOptionPane.showMessageDialog(CustomerRegistration.this, "Customer Details saved successfully");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(CustomerRegistration.this, "Error saving customer details: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(submitButton);

        // Create and add the clear button
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(300, 430, 100, 25);
        
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all the fields
                firstNameField.setText("");
                lastNameField.setText("");
                usernameField.setText("");
                passwordField.setText("");
                contactField.setText("");
                genderGroup.clearSelection();
                emailField.setText("");
                addressArea.setText("");
            }
        });
        add(clearButton);

        // Create and add the exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(450, 430, 100, 25);

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);
    }
    
    public static void main(String[] args) {
        CustomerRegistration frame = new CustomerRegistration();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(730, 550);
        frame.setVisible(true);
    }
}

