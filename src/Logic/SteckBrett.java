package Logic;

import java.util.stream.IntStream;

public class SteckBrett {

    //Todo: Array für Verkabelung definieren

    /**
     *
     * Zwischen den beiden Steckern wird eine Verbindung hergestellt.
     * Jede bestehende verbindung der beiden Stecker wird getrennt.
     * @param steckerEins Erster Stecker
     * @param steckerZwei Zweiter Stecker
     *
     * @see SteckBrett#ausstecken(char)
     * **/
    public void einstecken(char steckerEins, char steckerZwei){
        //Todo: Beide Stecker ausstecken

        //Todo: Die beiden Stecker mit einander Verbinden
    }


    /**
     *Falls zwischen diesem und einem anderen Stecker eine Verbindung existiert wird diese entfernt
     *
     * @param stecker Stecker, dessen Verbindung getrennt wird
     * @return Der Stecker mit dem der gegebene Stecker verbunden war. Falls ungesteckert der Stecker selbst
     * **/
    public char ausstecken(char stecker){
        //Todo: Verbundenen Stecker suchen und jeweils mit sich selbst verbinden

        //Todo: Vorher verbundenen Stecker zurückgeben
        return stecker;
    }

    /**
     *
     * @param eingabe Zeichen, dass getauscht werden soll
     * @return Das Zeichen, mit dem der Input verbunden ist
     */
    public char tauschen(char eingabe){
        //Todo: Zeichen ausgeben, mit dem die Eingabe verbunden ist
        return eingabe;
    }




}
