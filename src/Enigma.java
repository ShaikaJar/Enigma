import Logic.Rolle;
import Logic.UmkehrWalze;

import java.util.Scanner;

public class Enigma {
    //qtiab
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        verschluesselLoop:
        while (true) {
            String input = sc.nextLine().toUpperCase();
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(c == ' '){
                    output.append(c);
                } else if((c >= 'A' && c <= 'Z')){
                    output.append(verschlüsseln(c));
                }
                else{
                    System.out.println("Ungültige eingabe programm beendet");
                    break verschluesselLoop;
                }
            }

            System.out.println("Verschlüsselt: " + input +" zu " + output);

        }
        System.out.println();
    }


    public static Rolle activeRolle1 = Rolle.Rolle1;
    public static Rolle activeRolle2 = Rolle.Rolle2;
    public static Rolle activeRolle3 = Rolle.Rolle3;

    public static char verschlüsseln(char in) {
        // Verschlüssel den char
        char forward1 = activeRolle1.forwaerts(in);
        char forward2 = activeRolle2.forwaerts(forward1);
        char forward3 = activeRolle3.forwaerts(forward2);

        char reflected = UmkehrWalze.reflektieren(forward3);

        char backwards3 = activeRolle3.rueckwaerts(reflected);
        char backwards2 = activeRolle2.rueckwaerts(backwards3);
        char backwards1 = activeRolle1.rueckwaerts(backwards2);

        // Verschiebe die Rollen
        activeRolle1.incrementPosition();
        if (activeRolle1.getPosition() == 0) {
            activeRolle2.incrementPosition();
            if (activeRolle2.getPosition() == 0) {
                activeRolle3.incrementPosition();
            }
        }

        return backwards1;
    }
}
