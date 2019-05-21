package GUI2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import userAccounts.UserAccount;
import userAccounts.UserAccountBag;


public class Main extends JFrame {
	
	UserAccountBag acctBag = new UserAccountBag();
	FlowLayout flow = new FlowLayout();
	JPanel panel = new JPanel();
	
	public Main(String title) throws Exception {
		super(title);	
	    signIn();
	}
	
	
	public void signIn() {
		// SET LAYOUT
		flow.setHgap(20);
		flow.setVgap(10);
		panel.setLayout(flow);
		
		// CREATE COMPONENTS
		JButton signIn = new JButton("Sign In");
		JButton signUp = new JButton("Sign Up");
		
		JLabel userName = new JLabel("User Name: ");
		JLabel passWord = new JLabel("Password: ");
		
		JTextField userNameField = new JTextField(20);
		JTextField passWordField = new JTextField(20);
		
		//ADD COMPONENTS TO PANE
		panel.add(userName);
		panel.add(userNameField);
		panel.add(passWord);
		panel.add(passWordField);
		panel.add(signIn);
		panel.add(signUp);
		setContentPane(panel);
	    
	    // ADD BEHAVIOR
		signIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// USERNAME AND PASSWORD VALIDATION
				String userName = userNameField.getText();
				String passWord = passWordField.getText();
					
					if(acctBag.searchAccount(userName, passWord) == false) {
						// FAILURE
						JOptionPane.showMessageDialog(null,"             Password or Username is Wrong");
					} else {
						// DISPLAY SUCCESS
						JOptionPane.showMessageDialog(null,"             Successful Log in");
					}
					
				} 
				
			});
		
		
		signUp.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	signUp();
			}
			
		});
	}
	
	
	
	
	public void signUp(){
		
		// SET LAYOUT
    	panel.removeAll();
    	flow.setHgap(35);
    	flow.setVgap(10);
		panel.setLayout(flow);
		
		// CREATE COMPONENTS
		JButton finished = new JButton("Finished");
		
		JLabel firstName = new JLabel("First Name: ");
		JLabel lastName = new JLabel("Last Name: ");
		JLabel gender = new JLabel("Gender: ");
		JLabel gpa = new JLabel("GPA: ");
		JLabel passWord = new JLabel("Password: ");
		
		JTextField firstNameField = new JTextField(10);
		JTextField lastNameField = new JTextField(10);
		JTextField genderField = new JTextField(10);
		JTextField gpaField = new JTextField(10);
		JTextField userNameField = new JTextField(10);
		JTextField passWordField = new JTextField(10);
		
		//ADD COMPONENTS TO PANE
		panel.add(firstName);
		panel.add(firstNameField);
		panel.add(lastName);
		panel.add(lastNameField);
		panel.add(gender);
		panel.add(genderField);
		panel.add(gpa);
		panel.add(gpaField);
		panel.add(passWord);
		panel.add(passWordField);
		panel.add(finished);
		setContentPane(panel);
		
		
		// ADD BEHAVIOR
		finished.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				String firstName = firstNameField.getText();
				String lastName = lastNameField.getText();
				String gender = genderField.getText();
				String passWord = passWordField.getText();
				String gpa = gpaField.getText();
				
				if(firstNameField.getText().trim().isEmpty() || lastNameField.getText().trim().isEmpty() ||
						genderField.getText().trim().isEmpty() || passWordField.getText().trim().isEmpty() ||
						gpaField.getText().trim().isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"Please fill in all fields");
				}else {
				
				UserAccount newAcct = new UserAccount(firstName, lastName, gender, passWord, gpa);
				
						
				if(newAcct.checkPassWord(passWord) == false) {
					JOptionPane.showMessageDialog(null,"Please enter password once again");
				}
				else if(newAcct.checkGPAEntry(gpa) == true) {
						acctBag.insertAccount(newAcct);
						JOptionPane.showMessageDialog(null,"Success, Your Username Is: "+newAcct.getUserName());
						panel.removeAll();
						signIn();
						
				}else {
					JOptionPane.showMessageDialog(null,"Please enter GPA in format for ex 1.2");
				}
				
			}
		}
	});
	  
		
}
	
}
