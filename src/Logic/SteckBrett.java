package Logic;

import java.util.stream.IntStream;

public class SteckBrett {
    private static final int toChar = 'A';

    private int[] wiring = IntStream.range('A','Z'+1).toArray();

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
        ausstecken(steckerEins);
        ausstecken(steckerZwei);
        wiring[steckerEins-toChar] = steckerZwei;
        wiring[steckerZwei-toChar] = steckerEins;
        System.out.println(steckerEins+"<->"+steckerZwei);
    }


    /**
     *Falls zwischen diesem und einem anderen Stecker eine Verbindung existiert wird diese entfernt
     *
     * @param stecker Stecker, dessen Verbindung getrennt wird
     * @return Der Stecker mit dem der gegebene Stecker verbunden war. Falls ungesteckert der Stecker selbst
     * **/
    public char ausstecken(char stecker){
        char other = (char)wiring[stecker-toChar];
        wiring[other-toChar]=other;
        wiring[stecker-toChar]= stecker;
        System.out.println(stecker+"<- | ->"+other);
        return other;
    }

    /**
     *
     * @param input Zeichen, dass getauscht werden soll
     * @return Das Zeichen, mit dem der Input verbunden ist
     */
    public char tauschen(char input){
        return (char)wiring[input-toChar];
    }




}
