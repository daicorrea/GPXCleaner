package model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;


public class Password {
	
	public String password;
	List<String> Dictionary = Arrays.asList("Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Orange", "Blue");  // Pode pegar de um repositório ou classe       
	public Password(){
		
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean verifiedPassword(String password){
		if (this.passwordSize(password)){
			if (this.hasNumber(password)) {
				if (this.hasUpper(password)) {
					if (this.hasLower(password)) {
						if (this.hasPunctuation(password)) {
							if (this.inDictionary(password)) {
								return true;
							}
						}
					}
				}
			}
		} else{
			return false;
		}
		return false;
	}
	
	public boolean passwordSize(String password) {
		if (password.length() > 7){
			return true;
		} else{
			return false;
		}
	}
	
	public boolean hasNumber(String password) {
		if (password.matches(".*\\d+.*")){
			return true;
		} else{
			return false;
		}
	}
	
	public boolean hasUpper(String password){
		String lower = password.toLowerCase();
		if (!password.equals(lower)){
			return true;
		} else{
			return false;
		}
	}
	
	public boolean hasLower(String password){
		String upper = password.toUpperCase();
		if (!password.equals(upper)){
			return true;
		} else{
			return false;
		}
	}
	
	public boolean hasPunctuation(String password){
		if (password.matches("(.*)[\.!\?,.;:-'\"](.*)")){
			return true;
		} else{
			return false;
		}
	}
	
	public void isDate(String password) throws ParseException {
		String day = password.substring(0,1);
		String month = password.substring(2,3);
		String year = password.substring(4,7);
		String completeDate = day+"/"+month+"/"+year;
		this.isValidDate(completeDate);   
	}
	
	public boolean isValidDate(String inDate) {
    SimpleDateFormat formatter = new SimpleDateFormat("DD-MM-YYYY"); 
    formatter.setLenient(false);
    try {
      formatter.parse(inDate.trim());
    } catch (ParseException pe) {
      return false;
    }
    return true;
  } 
        public  boolean inDictionary(String password) {
	 boolean contains = Dictionary.contains(password);
         return contains;
            }
}	
