package userAccounts;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class UserAccount {

	private String firstName;
	private String lastName;
	private static int ID = 10000000;
	private String iD;
	private String gender;
	private String userName;
	private String password;
	private String gpa;
	

	// TESTED //
	public UserAccount(Name name){
		this.firstName = name.getFirstName();
		this.lastName = name.getLastName();
		this.gender = name.getGender();
		this.ID++; 
		this.iD = Integer.toString(this.ID);
		this.userName = emitUserName(this.firstName, this.lastName, this.iD);
		this.password = emitPassword();
		this.gpa = emitGPA();

	}
	
	
	public UserAccount(String firstName, String lastName, String gender, String passWord, String gpa){
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.ID++; 
		this.iD = Integer.toString(this.ID);
		this.userName = emitUserName(firstName, lastName, this.iD);
		
		if(checkPassWord(passWord) == false) {
			this.password = "0";
		}
		else {
		this.password = passWord;
		}
		
		if(checkGPAEntry(gpa) == false) {
			this.gpa = "0";
		}
		else {
			this.gpa = gpa;	
		}
		
	}


    public UserAccount() {

	}
    


	//EMITTERS
	public Name emitFirstName(Name[] listOfAllFirstNames){

		// TESTED //
		int max = listOfAllFirstNames.length;
        int randomNumber = (int) (Math.random() * max);
        return listOfAllFirstNames[randomNumber];

	}
	


	public String emitLastName(String[] listOfLastNames){

		// TESTED //
		int max = listOfLastNames.length;
        int randomNumber = (int) (Math.random() * max);
        return listOfLastNames[randomNumber];

	}
	


	public boolean isMale(Name firstName){
		if(firstName.getGender() == "B"){
			return true;
		}
		else
		return false;
	}
	


	public String emitID(){
		// TESTED //
		this.ID++; 
		this.iD = Integer.toString(this.ID);
		return this.iD;
	}
	


	public String emitGPA(){
      // TESTED //
	  double random = (Math.random() * 5.0);
	  DecimalFormat df = new DecimalFormat("#.#");
	  String randomGPA = df.format(random);

	  return randomGPA;
	}
	


	public String emitUserName(String firstName, String lastName, String iD){

		// TESTED //
		int j = 0;
		char [] lastNameCharArray = lastName.toCharArray();
		char [] firstNameCharArray = firstName.toCharArray();
		char [] iDCharArray = iD.toCharArray();


		if(lastNameCharArray.length < 4) {

			char [] userNameCharArray = new char[lastNameCharArray.length + 2];

			for(int i = 0; i < lastNameCharArray.length; i++) {

				userNameCharArray[i] = lastNameCharArray[i];
				j = i + 1;
			}

			userNameCharArray[j] = firstNameCharArray[0];
			j++;
			userNameCharArray[j] = iDCharArray[7];

			String userNameString = new String(userNameCharArray);

			return userNameString;

		}
		else {

			char [] userNameCharArray = new char[6];

			for(int i = 0; i < 4; i++){

				userNameCharArray[i] = lastNameCharArray[i];
				j = i + 1;
			}

			userNameCharArray[j] = firstNameCharArray[0];
			j++;
			userNameCharArray[j] = iDCharArray[7];

			String userNameString = new String(userNameCharArray);

			return userNameString;
		}

	}
	


	public String emitPassword(){
		
		// TESTED //
		char [] passWordCharArray = new char[8];
		
		int randomChar = (int)(Math.random() * (127 - 33)) + 33;
		passWordCharArray[0] = (char)randomChar;
		
		randomChar = (int)(Math.random() * (91 - 65)) + 65; // CAPITAL LETTERS
		passWordCharArray[1] = (char)randomChar; 
		
        randomChar = (int)(Math.random() * (123 - 97)) + 97; // LOWER CASE LETTERS
		passWordCharArray[2] = (char)randomChar;
		
        randomChar = (int)(Math.random() * (58 - 48)) + 48; // NUMBERS
		passWordCharArray[3] = (char)randomChar;
		
		// SYMBOLS
		randomChar = (int)(Math.random() * (48 - 33)) + 33; // ! - /
		passWordCharArray[4] = (char)randomChar;
		
		randomChar = (int)(Math.random() * (65 - 58)) + 58; // : - @
		passWordCharArray[5] = (char)randomChar;
		
		randomChar = (int)(Math.random() * (97 - 91)) + 91; // [ - `
		passWordCharArray[6] = (char)randomChar;
		
		randomChar = (int)(Math.random() * (127 - 123)) + 123; // { - ~
		passWordCharArray[7] = (char)randomChar;
		
		 
		String passWordString = new String(passWordCharArray);
		return passWordString;
	}
	
	
	
	public UserAccount emitUserAccount() throws Exception {
		
		// TESTED //
		Name name = new Name();
		  
		  Name[] listOfAllFirstNames = name.getListOfAllFirstNames();
		  String[] listOfLastNames = name.getListOfLastNames();
		  UserAccount acct = new UserAccount();
		  
		  name = acct.emitFirstName(listOfAllFirstNames);
		  name.setLastName(acct.emitLastName(listOfLastNames));
		  
		  UserAccount newAcct = new UserAccount(name);
		  return newAcct;
	}
	
	
	
	public boolean checkPassWord(String passWord) {
		
		// TESTED //
		int numCase = 0;
	    int specCase = 0;
	    int upCase = 0;
	    int loCase = 0;
	    
	char[] charPassWordArray = passWord.toCharArray();
		
		if(charPassWordArray.length < 8) {
			return false;
		}
		
		for(int i = 0; i < charPassWordArray.length; i++) {
			char c = charPassWordArray[i];
			
			if(Character.isUpperCase(c)){
                upCase++;
            }
            if(Character.isLowerCase(c)){
                loCase++;
            }
            if(Character.isDigit(c)){
               numCase++;
            }
            if(c >= 33 && c <= 47||c >= 58 && c <= 64 || c >= 91 && c <= 96 || c >= 123 && c <= 126){
                specCase++;
            }
            
            if(c < 33 || c >= 127) {
            	return false;
            }
        }
		
		if(specCase >= 1 && loCase >= 1 && upCase >= 1 && numCase >=1){
            return true;
        }
		else{
			return false;
		}
	}
	
	
	
	public boolean checkGPAEntry(String gpa) {
		
		// TESTED //
		char[] gpaCharArray = gpa.toCharArray();
		
		if(gpaCharArray.length != 3) {
			return false;
		}
		
		if(gpaCharArray[0] < 48 || gpaCharArray[0] > 52) {
			return false;
		}
		
		if(gpaCharArray[1] != '.') {
			return false;
		}
		
		if(gpaCharArray[2] < 48 || gpaCharArray[2] > 57) {
			return false;
		}
			
		return true;
	}
	
	
	public UserAccount clone() {
		UserAccount clone = new UserAccount(firstName, lastName, gender, password, gpa);
		return clone;
	}




	//GETTERS
	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getiD() {
		return iD;
	}


	public String getGender() {
		return gender;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}


	public String getGpa() {
		return gpa;
	}






}
