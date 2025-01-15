package mastermind2_0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MasterMind {

	public static void main(String[] args) {
		functionsMasterMind mn = new functionsMasterMind();
		
		int codegoed = 0;
		int codelengte = 4;
		String[] code = new String[codelengte];
		
		final ArrayList<String> kleuren = new ArrayList<String>(Arrays.asList("ro","bl","ge","gr","pa","or"));
		Random rnd = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welkom bij mastermind!");
		System.out.println("Het doel van het spel is om de code te kraken");
		System.out.println("Voordat we gaan beginnen wat wil je doen?\n");
		
		boolean start = false;
		while (!start) {
			System.out.println("1 - De regels lezen.");
			System.out.println("2 - De lengte van de code zien.");
			System.out.println("3 - De kleuren zien.");
			System.out.println("4 - Het spel spelen!");
			System.out.println("Maak je keuze:");
			try {
			int keuze = sc.nextInt();
			if (keuze == 1||keuze == 2||keuze == 3||keuze == 4) {
				switch(keuze) {
					case 1:
						System.out.println("\nDe regels:");
						System.out.println("Het doel van het spel is om de code te kraken.");
						System.out.println("Hier heb je 10 rondes voor.");
						System.out.println("Er zijn verschillende kleuren die je kan gebruiken in je code.");
						System.out.println("De standaart kleuren zijn:");
						System.out.println("(rood)-ro, (blauw)-bl, (groen)-gr, (geel)-ge, (paars)-pa en (oranje)-or.");
						System.out.println("Je kan de kleuren nog aanpassen als je wilt");
						System.out.println("De code is "+codelengte+" kleuren lang dus je vult elke ronde "+codelengte+" kleuren in");
						System.out.println("Als je een kleur op de goede plek hebt staan krijg je de kleur wit terug");
						System.out.println("Als de kleur niet goed maar wel in de code zit krijg je de kleur zwart terug");
						System.out.println("als de kleur helemaal niet in de code zit krijg je ' - ' terug");
						System.out.println("Veel succes!! \n");
						break;
						
					case 2:
						boolean codeaanpassen = false;
						while (!codeaanpassen) {
							System.out.println("\nJe code in nu "+codelengte+" kleuren lang");
							System.out.println("wat wil je nu doen?");
							System.out.println("1 - De lengte van je code aanpassen.");
							System.out.println("2 - De lengte van je code zo houden.");
							
							try {
								int codekeuze = sc.nextInt();
							if (codekeuze == 1||codekeuze == 2) {
								switch(codekeuze) {
									case 1:
										System.out.println("\nWat is de lengte die je de code wil maken?");
										codelengte = sc.nextInt();
										System.out.println("Je code is nu "+codelengte+" kleuren lang");
										break;
									case 2:
										System.out.println("\nPrima de code is nu "+codelengte+" kleuren lang");
										codeaanpassen = true;
										break;
								}
							}
							else {
								System.out.println("\ndit is niet een van de opties kies iets anders");
							}
							}
							catch (Exception ex) {
								System.out.println("\nFout: Voer een geldig getal in.");
								sc.nextLine();
							}
						}
						break;
					case 3:
						boolean kleurenaanpassen = false;
						while(!kleurenaanpassen) {
							System.out.println("\nDe kleuren die je nu gebruikt zijn:");
							for (int i = 0; i < kleuren.size(); i++) {
								System.out.print(kleuren.get(i)+", ");
							}
							System.out.println("\nwat wil je nu doen?");
							System.out.println("1 - Kleuren toevoegen.");
							System.out.println("2 - Kleuren verwijderen.");
							System.out.println("3 - De kleuren zijn goed zo!");
							try {
							int kleurenkeuze = sc.nextInt();
							if (kleurenkeuze == 1||kleurenkeuze == 2||kleurenkeuze == 3) {
								switch(kleurenkeuze) {
									case 1:
										System.out.println("\nwelke kleur wil je toevoegen? Gebruik alleen de eerste 2 letters van de kleur.");
										String nieuwekleur = sc.next();
										kleuren.add(nieuwekleur);
										System.out.println(nieuwekleur+" is toegevoegd aan je kleuren!");
										break;
										
									case 2:
										System.out.println("\nwelke kleur wil je verwijderen? kies uit:");
										for (String kle : kleuren) {
											System.out.print(kle + ", ");
										}
										String kleurweg = sc.next();
										kleuren.remove(kleurweg);
										System.out.println(kleurweg+" is uit je kleuren weggehaald.");
										break;
										
									case 3:
										System.out.println("\nOke de kleuren zijn goed zo!\n");
										kleurenaanpassen = true;
										break;
										
								}
							}
							else {
								System.out.println("\ndit is niet een van de opties kies iets anders");
							}
							}
							catch (Exception ex) {
								System.out.println("\nFout: Voer een geldig getal in.");
								sc.nextLine();
							}

						}
						break;
						
					case 4:
						System.out.println("\noke tijd om het spel te gaan spelen.");
						System.out.println("Succes!");
						start = true;
						break;
						
				}
			}
			else {
				System.out.println("dit is niet een van de opties kies iets anders");
			}
			}
			catch (Exception ex) {
				System.out.println("\nFout: Voer een geldig getal in.");
				sc.nextLine();
			}
			
		}

		code = mn.codemaker();

		for (int ronde =1; ronde <= 10; ronde++) {
			
			mn.kleurcontroleer(ronde);
			
			codegoed = mn.codecontroleren();
	        
			mn.overwinningchecken(ronde);

			
			}
			sc.close();	
		
	}
}