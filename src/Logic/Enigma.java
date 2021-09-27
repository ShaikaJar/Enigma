package Logic;

import java.util.Scanner;

public class Enigma {


    //Todo: Rollwerk definieren
    //Todo: Steckbrett definieren

    /**
     * Eine Enigma, die das gegebene Rollwerk und Steckbrett verwendet
     * @param rollWerk Rollwerk, das zur Verschlüsselung benutzt werden soll
     * @param steckBrett Steckbrett, das zur Verschlüsselung benutzt werden soll
     */
    public Enigma(Rollwerk rollWerk, SteckBrett steckBrett) {
        //Todo: Rollwerk speichern
        //Todo: Steckbrett speichern
    }



    /**
     *
     * @param stecker Stecker der ausgesteckt werden soll
     * @return Der Stecker mit dem der gegebene Stecker verbunden war. Falls ungesteckert der Stecker selbst
     */
    public char ausstecken(char stecker){
        //Todo: Stecker ausstecken

        return stecker; //Todo: Stecker, der ausgesteckt wurde zurückgeben
    }


    /**
     *
     * Beide Stecker werden miteinander verbunden
     *
     * @param stecker1 Erster Stecker
     * @param stecker2 Zweiter Stecker
     */
    public void einstecken(char stecker1, char stecker2){
        //TODO: stecker1 und stecker2 auf Steckbrett verbinden
    }

    /**
     * Verschlüsselt einen Charakter, indem es ihn zunächst durch das Steckbrett schickt, dann vorwärts durch alle Rollen schickt,
     * dann durch die Umkehrwalze, dann rückwärts durch alle Rollen und dann erneut durch das Steckbrett
     * @param eingabe Der Charakter der verschlüsselt werden soll
     * @return Ergebnis der Verschlüsselung
     */
    public char verschlüsseln(char eingabe) {

        //Todo: Signal durch Steckbrett schicken

        //Todo: Signal durch Rollwerk schicken

        //Todo: Rollwerk drehen

        //Todo: Signal durch Steckbrett schicken

        //Todo: Verschlüsseltes Zeichen zurück geben
        return eingabe;
    }

    /**
     * Gibt Position aller Rollen zurück
     * @return Ein Array, in dem die Position der Rollen in Reihenfolge der Rollen gespeichert ist. Erste Rolle -> Index 0, etc
     */
    public int[] getRollenPositionen(){
        //Todo: Position der Rollen zurück geben
        return new int[]{0,0,0};
    }


    /**
     * Setzt Position aller Rollen
     * @param positionen  Ein Array, in dem die Position der Rollen in Reihenfolge der Rollen gespeichert ist. Erste Rolle -> Index 0, etc
     */
    public void setPositionen(int[] positionen){
        //Todo: Position der Rollen setzen
    }
}
