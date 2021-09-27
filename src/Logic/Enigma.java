package Logic;

import java.util.Scanner;

public class Enigma {


    private Rollwerk rollWerk;
    private SteckBrett steckBrett;

    /**
     * Eine Enigma, die das gegebene Rollwerk und Steckbrett verwendet
     * @param rollWerk Rollwerk, das zur Verschlüsselung benutzt werden soll
     * @param steckBrett Steckbrett, das zur Verschlüsselung benutzt werden soll
     */
    public Enigma(Rollwerk rollWerk, SteckBrett steckBrett) {
        this.rollWerk = rollWerk;
        this.steckBrett = steckBrett;
    }

    //qtiab
    public static void main(String[] args) {
        Enigma enigma = new Enigma(
                        new Rollwerk(Rolle.Rolle1,Rolle.Rolle2,Rolle.Rolle3),
                        new SteckBrett()
        );


        Scanner sc = new Scanner(System.in);
        while(true){
            if(!sc.hasNextLine())
                continue;
            String inString = sc.nextLine();
            StringBuffer out = new StringBuffer();
            for (char inChar :
                    inString.toCharArray()) {
                out.append(enigma.verschlüsseln(inChar));
            }
            System.out.println(out);
        }

    }


    /**
     *
     * @param stecker Stecker der ausgesteckt werden soll
     * @return Der Stecker mit dem der gegebene Stecker verbunden war. Falls ungesteckert der Stecker selbst
     */
    public char ausstecken(char stecker){
        return steckBrett.ausstecken(stecker);
    }


    /**
     *
     * Beide Stecker werden miteinander verbunden
     *
     * @param stecker1 Erster Stecker
     * @param stecker2 Zweiter Stecker
     */
    public void einstecken(char stecker1, char stecker2){
        steckBrett.einstecken(stecker1,stecker2);
    }

    /**
     * Verschlüsselt einen Charakter, indem es ihn zunächst durch das Steckbrett schickt, dann vorwärts durch alle Rollen schickt,
     * dann durch die Umkehrwalze, dann rückwärts durch alle Rollen und dann erneut durch das Steckbrett
     * @param eingabe Der Charakter der verschlüsselt werden soll
     * @return Ergebnis der Verschlüsselung
     */
    public char verschlüsseln(char eingabe) {

        eingabe = Character.toUpperCase(eingabe);

        //Signal durch Steckbrett schicken
        char verschlüsselt = steckBrett.tauschen(eingabe);

        //Signal durch Rollwerk schicken
        verschlüsselt = rollWerk.verschlüsseln(verschlüsselt);
        //Rollwerk auf nächste Position
        rollWerk.drehen();

        //Signal durch Steckbrett schicken
        verschlüsselt = steckBrett.tauschen(verschlüsselt);

        System.out.println(eingabe+"->"+verschlüsselt);

        return verschlüsselt;
    }

    /**
     * Gibt Position aller Rollen zurück
     * @return Ein Array, in dem die Position der Rollen in Reihenfolge der Rollen gespeichert ist. Erste Rolle -> Index 0, etc
     */
    public int[] getRollenPositionen(){
        return rollWerk.getRollenPositionen();
    }


    /**
     * Setzt Position aller Rollen
     * @param positionen  Ein Array, in dem die Position der Rollen in Reihenfolge der Rollen gespeichert ist. Erste Rolle -> Index 0, etc
     */
    public void setPositionen(int[] positionen){
        rollWerk.setRollenPositionen(positionen);
    }
}
