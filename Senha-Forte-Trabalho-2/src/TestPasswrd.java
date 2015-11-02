
public class TestPasswrd {
	public static void TestPasswrds() 
	{
		
		//Nao considerado senha
		//System.out.println(CheckStrength.checkPasswordStrength(""));
		System.out.println(CheckStrength.checkPasswordStrength("passwrd"));
		System.out.println(CheckStrength.checkPasswordStrength("oi"));
		System.out.println(CheckStrength.checkPasswordStrength("31102015"));
		
		//Teste para Level Easy:
		
		System.out.println(CheckStrength.checkPasswordStrength("OiComovai"));
		System.out.println(CheckStrength.checkPasswordStrength("Oi123"));
		System.out.println(CheckStrength.checkPasswordStrength("sunshine7"));
		
		//Teste para Level Medium:
		
		System.out.println(CheckStrength.checkPasswordStrength("OiComovai?"));
		System.out.println(CheckStrength.checkPasswordStrength("hdusaoU2"));
		System.out.println(CheckStrength.checkPasswordStrength("sunshine7382"));
		System.out.println(CheckStrength.checkPasswordStrength("hojeedia31102015"));
		
		//Teste para Level Strong:
		
		System.out.println(CheckStrength.checkPasswordStrength("Hojeedia31102015"));
		System.out.println(CheckStrength.checkPasswordStrength("OiePMo/!"));
		System.out.println(CheckStrength.checkPasswordStrength("Bsi@CCet@"));
		System.out.println(CheckStrength.checkPasswordStrength("OiComovai"));
		
		//Teste para Level Very Strong:
		
		System.out.println(CheckStrength.checkPasswordStrength("!ShaujsHjdi892@"));
		System.out.println(CheckStrength.checkPasswordStrength("SenhasFortesSaoGr@ndes2"));
		System.out.println(CheckStrength.checkPasswordStrength("Bsi@CCet@Un1r10"));
		
		//Teste para Level Extremely Strong:
		
		System.out.println(CheckStrength.checkPasswordStrength("!ShaujsHjdi892@muitoGrande@#"));
		System.out.println(CheckStrength.checkPasswordStrength("OiePMo/!@#$%^^&2"));
	
	}
}
