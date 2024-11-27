package mastermind2_0;

import java.util.Random;
import java.util.Scanner;

public class MasterMind {

	public static void main(String[] args) {
		
		final String wit = "wi";
		final String zwart = "zw";
		final String punt = " - ";
		
		final String rood = "ro";
		final String blauw = "bl"; 
		final String groen = "gr";
		final String geel = "ge";
		final String paars = "pa";
		final String oranje = "or";
		
		String[] random = {rood, blauw, groen, geel, paars, oranje};
		Random rnd = new Random();
		
		String code1 = random[rnd.nextInt(random.length)];
		String code2 = random[rnd.nextInt(random.length)];
		String code3 = random[rnd.nextInt(random.length)];
		String code4 = random[rnd.nextInt(random.length)];
		int codegetal = 1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welkom bij mastermind!");
		System.out.println("Het doel van het spel is om de code te kraken");
		System.out.println("Hier heb je 10 rondes voor");
		System.out.println("Er zijn 6 kleuren die je kan raden, de kleuren zijn:");
		System.out.println("(rood)-ro, (blauw)-bl, (groen)-gr, (geel)-ge, (paars)-pa en (oranje)-or");
		System.out.println("De code is 4 kleuren lang dus je vult elke ronde 4 kleuren in");
		System.out.println("Als je een kleur op de goede plek hebt staan krijg je de kleur wit terug");
		System.out.println("Als de kleur niet goed maar wel in de code zit krijg je de kleur zwart terug");
		System.out.println("als de kleur helemaal niet in de code zit krijg je ' - ' terug");
		System.out.println("Veel succes!! \n");
		

		for (int i =10; i > 0; i--) {
		
		System.out.println("code "+codegetal);
		String codebreaker1_1 = sc.next();
		String codebreaker1_2 = sc.next();
		String codebreaker1_3 = sc.next();
		String codebreaker1_4 = sc.next();
		
		
		String codemaker1_1 = " ";
		if (codebreaker1_1.equals(code1)) {
			codemaker1_1 = wit;
		}//end if
		else if (codebreaker1_1.equals(code2)) {
			codemaker1_1 = zwart;
		}//end else if
		else if (codebreaker1_1.equals(code3)) {
			codemaker1_1 = zwart;
		}//end else if
		else if (codebreaker1_1.equals(code4)) {
			codemaker1_1 = zwart;
		}// end else if
		else {
			codemaker1_1 = punt;
		}//end else
		System.out.println(codemaker1_1);
		
		String codemaker1_2 = " ";
		if (codebreaker1_2.equals(code2)) {
			codemaker1_2 = wit;
		}//end if
		else if (codebreaker1_2.equals(code1)) {
			codemaker1_2 = zwart;
		}//end else if
		else if (codebreaker1_2.equals(code3)) {
			codemaker1_2 = zwart;
		}//end else if
		else if (codebreaker1_2.equals(code4)) {
			codemaker1_2 = zwart;
		}//end else if
		else {
			codemaker1_2 = punt;
		}//end else
		System.out.println(codemaker1_2);
		
		String codemaker1_3 = " ";
		if (codebreaker1_3.equals(code3)) {
			codemaker1_3 = wit;
		}//end if
		else if (codebreaker1_3.equals(code1)) {
			codemaker1_3 = zwart;
		}//end else if
		else if (codebreaker1_3.equals(code2)) {
			codemaker1_3 = zwart;
		}//end else if
		else if (codebreaker1_3.equals(code4)) {
			codemaker1_3 = zwart;
		}//end else if
		else {
			codemaker1_3 = punt;
		}// end else
		System.out.println(codemaker1_3);
		
		String codemaker1_4 = " ";
		if (codebreaker1_4.equals(code4)) {
			codemaker1_4 = wit;
		}//end if
		else if (codebreaker1_4.equals(code1)) {
			codemaker1_4 = zwart;
		}//end else if
		else if (codebreaker1_4.equals(code2)) {
			codemaker1_4 = zwart;
		}//end else if
		else if (codebreaker1_4.equals(code3)) {
			codemaker1_4 = zwart;
		}//end else if
		else {
			codemaker1_4 = punt;
		}//end else
		System.out.println(codemaker1_4);
		
		codegetal = ++codegetal;
		
		if (codebreaker1_1.equals(code1)) {
			
			if (codebreaker1_2.equals(code2)) {
				
				if (codebreaker1_3.equals(code3)) {
					
					if (codebreaker1_4.equals(code4)) {
						
						System.out.println("gefeliciteerd je hebt gewonnen!");
						break;
					}
					
				}
				
			}
			
		}
		if (i == 1) {
			
			System.out.println("helaas je hebt verloren.");
			break;
		}
}

		
		sc.close();
		
	}

}
