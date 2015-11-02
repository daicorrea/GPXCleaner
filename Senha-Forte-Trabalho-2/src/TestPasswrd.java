
public class TestPasswrd {
	public static void TestPasswrds() 
	{
		
		//Nao considerado senha
		//CheckStrength.checkWordLevel(""));
		CheckStrength.checkWordLevel("passwrd");
		CheckStrength.checkWordLevel("oi");
		CheckStrength.checkWordLevel("31102015");
		
		//Teste para Level Easy:
		
		CheckStrength.checkWordLevel("OiComovai");
		CheckStrength.checkWordLevel("Oi123");
		CheckStrength.checkWordLevel("sunshine7");
		
		//Teste para Level Medium:
		
		CheckStrength.checkWordLevel("OiComovai?");
		CheckStrength.checkWordLevel("hdusaoU2");
		CheckStrength.checkWordLevel("sunshine7382");
		CheckStrength.checkWordLevel("hojeedia31102015");
		
		//Teste para Level Strong:
		
		CheckStrength.checkWordLevel("Hojeedia31102015");
		CheckStrength.checkWordLevel("OiePMo/!");
		CheckStrength.checkWordLevel("Bsi@CCet@");
		CheckStrength.checkWordLevel("OiComovai");
		
		//Teste para Level Very Strong:
		
		CheckStrength.checkWordLevel("!ShaujsHjdi892@");
		CheckStrength.checkWordLevel("SenhasFortesSaoGr@ndes2");
		CheckStrength.checkWordLevel("Bsi@CCet@Un1r10");
		
		//Teste para Level Extremely Strong:
		
		CheckStrength.checkWordLevel("!ShaujsHjdi892@muitoGrande@#");
		CheckStrength.checkWordLevel("OiePMo/!@#$%^^&2");
	
	}
}
