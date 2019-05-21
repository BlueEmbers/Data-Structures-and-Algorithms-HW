package userAccounts;

import java.io.BufferedReader;
import java.io.FileReader;

public class Name {

	private String firstName;
	private String lastName;
	private String gender;


	public Name(String firstName, String lastName, String gender){
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}


	public void setListOfBoysNames() throws Exception {
		
		// TESTED //
		FileReader file = new FileReader("boys_names.txt");
		BufferedReader reader = new BufferedReader(file);
		
		String text = "";
		String line = reader.readLine();

	for(int i = 0; i < loadBoysNames.length; i++) {
		
		text = line;
		String[] s = text.split(" ");
		Name boyName = new Name();
		boyName.setFirstName(s[0]);
		boyName.setGender("B");
		this.loadBoysNames[i] = boyName;
		line  = reader.readLine();
	  }
	
	    reader.close();
    }


	public void setListOfGirlsNames() throws Exception {
	
		// TESTED //
		FileReader file = new FileReader("girls_names.txt");
		BufferedReader reader = new BufferedReader(file);
		
		String text = "";
		String line = reader.readLine();

	for(int i = 0; i < loadOfGirlsNames.length; i++) {
		
		text = line;
		String[] s = text.split(" ");
		Name girlName = new Name();
		girlName.setFirstName(s[0]);
		girlName.setGender("G");
		this.loadOfGirlsNames[i] = girlName;
		line  = reader.readLine();
	  }
	
	    reader.close();
		
	}


	public String[] getListOfLastNames() throws Exception {
		setListOfLastNames();
		return loadOfLastNames;
	}


	public void setListOfLastNames() throws Exception {
		
		// TESTED //
		FileReader file = new FileReader("Last Names.txt");
		BufferedReader reader = new BufferedReader(file);
		
		String text = "";
		String line = reader.readLine();

	for(int i = 0; i < loadOfLastNames.length; i++) {
		
		text = line;
		String[] s = text.split(" ");
		this.loadOfLastNames[i] = s[0];
		line  = reader.readLine();
	  }
	
	    reader.close();
	}


	public Name[] getListOfAllFirstNames() throws Exception {
		setListOfAllFirstNames();
		return loadAllFirstNames;
	}


	public void setListOfAllFirstNames() throws Exception {
		
		// TESTED //
	    int  i = 0;
	    int j = 0;
	    
	    setListOfBoysNames();
	    setListOfGirlsNames();
		
		while(i < loadBoysNames.length) {
			loadAllFirstNames[i] = loadBoysNames[i].clone();
		i++;
		}
		
		while(j < loadOfGirlsNames.length) {
			loadAllFirstNames[i] = loadOfGirlsNames[j].clone();
			i++;
			j++;
		}
		
	}
	
	private Name[] loadBoysNames = new Name[27];
	private Name[] loadOfGirlsNames = new Name[28];
	private String[] loadOfLastNames = new String[55];
	private Name[] loadAllFirstNames = new Name[55];


	public Name()
	{

	}
	
	public Name clone() {
		Name clone = new Name(firstName, lastName, gender);
		return clone;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}



}
