import Logic.Rolle;
import Logic.UmkehrWalze;

import java.util.Scanner;

public class Enigma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String next = sc.nextLine();
            if(next.length() == 1){
                char c = next.charAt(0);
                if(c >= 'A' && c <= )
            }
            System.out.println();
        }
    }

    public static Rolle activeRolle1 = Rolle.Rolle1;
    public static Rolle activeRolle2 = Rolle.Rolle2;
    public static Rolle activeRolle3 = Rolle.Rolle3;

    public static UmkehrWalze umkehrWalze = new UmkehrWalze();

    public static char verschlüsseln(char in){
        // Verschlüssel den char
        char forward1 = activeRolle1.forwaerts(in);
        char forward2 = activeRolle2.forwaerts(forward1);
        char forward3 = activeRolle3.forwaerts(forward2);

        char reflected = umkehrWalze.reflektieren(forward3);

        char backwards3 = activeRolle3.rueckwaerts(reflected);
        char backwards2 = activeRolle2.rueckwaerts(backwards3);
        char backwards1 = activeRolle1.rueckwaerts(backwards2);

        // Verschiebe die Rollen
        activeRolle1.incrementPosition();
        if(activeRolle1.getPosition() == 0){
            activeRolle2.incrementPosition();
            if(activeRolle2.getPosition() == 0){
                activeRolle3.incrementPosition();
            }
        }

        return backwards1;
    }
}
