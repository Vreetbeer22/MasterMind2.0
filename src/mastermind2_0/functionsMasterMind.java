package mastermind2_0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class functionsMasterMind extends MasterMind {

	final String wit = "wi";
	final String zwart = "zw";
	final String punt = " - ";
	int codelengte = 4;
	final ArrayList<String> kleuren = new ArrayList<String>(Arrays.asList("ro","bl","ge","gr","pa","or"));
	Random rnd = new Random();
	Scanner sc = new Scanner(System.in);
	String[] code = new String[codelengte];
	int ronde = 1;
	String[] codebreaker = new String[code.length];
	int codegoed = 0;
	
	public String[] codemaker() {
		for (int i =0; i < code.length; i++) {
			code[i] = kleuren.get(rnd.nextInt(kleuren.size()));
		}
		return code;
	}
	
	public String[] kleurcontroleer(int ronde) {
		System.out.println("code "+ronde+" vul je code ("+code.length+" kleuren) in:");
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
			            System.out.println("Ongeldige invoer. Kies een kleur uit: ");
			            for (String kleu : kleuren) {
			            	System.out.print(kleu+", ");
			            }
			        } else {
			            codebreaker[i] = codebreaker[i];
			        }
				}
			}
		return codebreaker;
	}
	
	public int codecontroleren() {
		String[] resultaat = new String[code.length];
		boolean[] codegebruikt = new boolean[code.length];	// Om te markeren welke codeposities al gebruikt zijn	
        boolean[] breakergebruikt = new boolean[code.length];		// Om te markeren welke codebreaker posities al verwerkt zijn
        
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
	    System.out.println(codegoed);
    
    return codegoed;
	}
	
	public void overwinningchecken(int ronde) {
		boolean codegeraden = false;
		
		if (codegoed == code.length) {
			System.out.println("\nGefeliciteerd je hebt gewonnen!");
			ronde = 10;
			codegeraden = true;
		}
		else {
			codegoed = 0;
		}
		
		if (ronde == 10 && !codegeraden) {
			System.out.println("\nHelaas je hebt verloren :(");
			System.out.print("De code was: ");
			for (String cod : code) {
				System.out.print(cod + ", ");
			}
		}
		System.out.println();
	}
	

	
	
}
