package userAccounts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserAccountBag {
	
	private int size;
	private int next;
	private UserAccount[] listOfAccounts;
	
	
	public UserAccountBag() throws Exception {
		next = 0;
		listOfAccounts = new UserAccount[5000];
		UserAccount newAcct = new UserAccount();
		
		for(int i = 0; i < 3000; i++) {
			listOfAccounts[next] = newAcct.emitUserAccount();
			next++;
		}
	}
	
	
	public UserAccountBag(int size) {
		next = 0;
		this.size = size;
		listOfAccounts = new UserAccount[size];
	}
	
	
	
	public boolean insertAccount(UserAccount newAcct) {
		
		listOfAccounts[next] = newAcct;
		next++;
		return true;
	}
	


	public boolean searchAccount(String userName, String passWord){
		 
		    UserAccount node;
	        UserAccount temp;
	        int i = 0;
	        while (i < next && !listOfAccounts[i].getUserName().equals(userName)) {
	            i++;
	        }
	        if (i == next){ 
	        	System.out.print("HEY");
	            return false;
	        }
	        
	        if(!listOfAccounts[i].getPassword().equals(passWord)) {
	        	return false;
	        }
	        
	        node = listOfAccounts[i];
	        if (i != 0){ // bubble-up accessed node
	            temp = listOfAccounts[i - 1];
	            listOfAccounts[i - 1] = listOfAccounts[i];
	            listOfAccounts[i] = temp;
	        }
		return true;
	}


	public boolean searchAccount(String username){
		return true;
	}

	
	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public int getNext() {
		return next;
	}


	public void setNext(int next) {
		this.next = next;
	}


	public UserAccount[] getListOfAccounts() {
		return listOfAccounts;
	}


	public void setListOfAccounts(UserAccount[] listOfAccounts) {
		this.listOfAccounts = listOfAccounts;
	}
	


}
