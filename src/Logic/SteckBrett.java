package Logic;

import java.util.stream.IntStream;

public class SteckBrett {
    private static final int toChar = 'A';

    private int[] wiring = IntStream.range(0,26).toArray();

    /**
     *
     * Zwischen den beiden Steckern wird eine Verbindung hergestellt.
     * Jede bestehende verbindung der beiden Stecker wird getrennt.
     * @param steckerEins Erster Stecker
     * @param steckerZwei Zweiter Stecker
     *
     * @see SteckBrett#ausstecken(int)
     * **/
    public void einstecken(int steckerEins, int steckerZwei){
        ausstecken(steckerEins);
        ausstecken(steckerZwei);
        wiring[steckerEins] = steckerZwei;
        wiring[steckerZwei] = steckerEins;
    }


    /**
     *Falls zwischen diesem und einem anderen Stecker eine Verbindung existiert wird diese entfernt
     *
     * @param stecker Stecker, dessen Verbindung getrennt wird
     * **/
    public void ausstecken(int stecker){
        int other = wiring[stecker];
        wiring[other]=other;
        wiring[stecker]= stecker;
    }

    /**
     *
     * @param input Zeichen, dass getauscht werden soll
     * @return Das Zeichen, mit dem der Input verbunden ist
     */
    public char tauschen(char input){
        return (char) ((char) (wiring[(input - toChar +wiring.length) % wiring.length])+toChar);
    }




}
