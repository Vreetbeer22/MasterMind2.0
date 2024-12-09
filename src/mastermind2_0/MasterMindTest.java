package mastermind2_0;

import java.util.Random;
import java.util.Scanner;

public class MasterMindTest {

	public static void main(String[] args) {
		
		final String wit = "wi";
		final String zwart = "zw";
		final String punt = " - ";
		
		final String[] kleuren = {"ro", "bl", "gr", "ge", "pa", "or"};
		Random rnd = new Random();
		
		String[] code = new String[4];
		for (int i =0; i < code.length; i++) {
			code[i] = kleuren[rnd.nextInt(kleuren.length)];
		}
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welkom bij mastermind!");
		System.out.println("Het doel van het spel is om de code te kraken");
		System.out.println("Hier heb je 10 rondes voor");
		System.out.println("Er zijn 6 kleuren die je kan raden, de kleuren zijn:");
		System.out.println("(rood)-ro, (blauw)-bl, (groen)-gr, (geel)-ge, (paars)-pa en (oranje)-or");
		System.out.println("De code is "+code.length+" kleuren lang dus je vult elke ronde "+code.length+" kleuren in");
		System.out.println("Als je een kleur op de goede plek hebt staan krijg je de kleur wit terug");
		System.out.println("Als de kleur niet goed maar wel in de code zit krijg je de kleur zwart terug");
		System.out.println("als de kleur helemaal niet in de code zit krijg je ' - ' terug");
		System.out.println("Veel succes!! \n");
		
		for (int ronde =1; ronde <= 10; ronde++) {
		
		System.out.println("code "+ronde+" vul je code ("+code.length+" kleuren) in:");
		String[] codebreaker = new String[code.length];
			for (int i = 0; i < code.length; i++) {
				Boolean geldigekleur = false;
				while (!geldigekleur) {
					System.out.println("Vul hier kleur "+(i+1)+" in");
					codebreaker[i] = sc.next();
					for (String kleur : kleuren) {
			            if (kleur.equals(codebreaker[i])) {
			                geldigekleur = true;
			                break;
			            }
			        }
					if (!geldigekleur) {
			            System.out.println("Ongeldige invoer. Kies een kleur uit: ro, bl, gr, ge, pa, or.");
			        } else {
			            codebreaker[i] = codebreaker[i];
			        }
				}
			}
		
			String[] resultaat = new String[code.length];
			boolean[] codegebruikt = new boolean[code.length];	// Om te markeren welke codeposities al gebruikt zijn	
            boolean[] breakergebruikt = new boolean[code.length];		// Om te markeren welke codebreaker posities al verwerkt zijn
            int codegoed = 0;
            
            //controleren voor goed/wit
            for (int i = 0; i < code.length; i++) {
                if (codebreaker[i].equals(code[i])) {
                    resultaat[i] = wit;
                    codegebruikt[i] = true;
                    breakergebruikt[i] = true;
                    codegoed++;
                }
            }
            
            //controleren voor half goed/zwart
            for (int i = 0; i < code.length; i++) {
                if (breakergebruikt[i]) continue;	// Skip als de codebreaker al verwerkt is
                for (int j = 0; j < code.length; j++) {
                    if (!codegebruikt[j] && codebreaker[i].equals(code[j])) {
                        resultaat[i] = zwart;
                        codegebruikt[j] = true;
                        breakergebruikt[i] = true;
                        break;
                    }
                }
            }
            
            //rest als niks goed is/punt
            for (int i = 0; i < code.length; i++) {
                if (resultaat[i] == null) {
                    resultaat[i] = punt;
                }
            }
            
            //resultaten weergeven
            for (String res : resultaat) {
                System.out.print(res + " ");
            }
            System.out.println();
               
		if (codegoed == code.length) {
			System.out.println("Gefeliciteerd je hebt gewonnen!");
			break;
		}
		else {
			codegoed = 0;
		}
		
		if (ronde == 10) {
			System.out.println("Helaas je hebt verloren :(");
			System.out.print("De code was: ");
			for (String cod : code) {
				System.out.print(cod + ", ");
			}
		}
		System.out.println();
		
		}
		sc.close();	
	}
}