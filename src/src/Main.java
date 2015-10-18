package src;

import model.Password;

public class Main {
	
	public static void main(String[] args){
		Password passwrd = new Password();
		passwrd.setPassword("12345678");
		if(verifiedPassword(passwrd)){
			//TODO Senha forte else Senha Fraca
		};
	}
}
