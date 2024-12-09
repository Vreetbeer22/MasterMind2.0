for (int i = 0; i < code.length; i++) {
    boolean validInput = false;
    while (!validInput) {
        System.out.print("Voer kleur " + (i + 1) + " in: ");
        String input = sc.next();
        for (String kleur : kleuren) {
            if (kleur.equals(input)) {
                validInput = true;
                break;
            }
        }
        if (!validInput) {
            System.out.println("Ongeldige invoer. Kies een kleur uit: ro, bl, gr, ge, pa, or.");
        } else {
            codebreaker[i] = input;
        }
    }
}