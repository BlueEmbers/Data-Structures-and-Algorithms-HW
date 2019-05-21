package GUI2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import userAccounts.UserAccount;
import userAccounts.UserAccountBag;


public class SignUp extends JFrame {

	public SignUp(String title) {

		super(title);

		// SET LAYOUT
		setLayout(new FlowLayout(FlowLayout.LEFT));

		// CREATE COMPONENTS
		JButton finished = new JButton("Done");

		JLabel firstName = new JLabel("First Name: ");
		JLabel lastName = new JLabel("Last Name: ");
		JLabel gender = new JLabel("Gender: ");
		JLabel userName = new JLabel("Username: ");
		JLabel passWord = new JLabel("Password: ");
		JLabel gpa = new JLabel("GPA: ");

		JTextField firstNameField = new JTextField(10);
		JTextField lastNameField = new JTextField(10);
		JTextField genderField = new JTextField(10);
		JTextField userNameField = new JTextField(10);
		JTextField passWordField = new JTextField(10);
		JTextField gpaField = new JTextField(10);

		//ADD COMPONENTS TO PANE
		
		add(firstName);
		add(firstNameField);
		add(lastName);
		add(lastNameField);
		add(gender);
		add(genderField);
		add(userName);
		add(userNameField);
		add(passWord);
		add(passWordField);
		add(gpa);
		add(gpaField);
		add(finished);
		
		
		// ADD BEHAVIOR
		finished.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				String firstName = firstNameField.getText();
				String lastName = lastNameField.getText();
				String gender = genderField.getText();
				String userName = userNameField.getText();
				String passWord = passWordField.getText();
				String gpa = gpaField.getText();
				
				UserAccount newAcct = new UserAccount(firstName, lastName, gender, userName, passWord);
				
				if(newAcct.checkPassWord(passWord) == false) {
					JOptionPane.showMessageDialog(null,"Please enter password. Must include Capital, lowercase, number and sign.");
				}
				
				else if(newAcct.checkGPAEntry(gpa) == true) {
					
					try {
						UserAccountBag acctBag = new UserAccountBag();
						
						if(acctBag.insertAccount(newAcct) == false) {
							JOptionPane.showMessageDialog(null,"Username is taken");
						}
						else {
							JOptionPane.showMessageDialog(null,"Success");
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null,"Please enter GPA in format for ex 1.2");
				}
				
			}
		});


	}


}


