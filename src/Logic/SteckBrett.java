package Logic;

import java.util.stream.IntStream;

public class SteckBrett {

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
        wiring[VerkabelungsVorlage.positionImAlphabet(steckerEins)] = steckerZwei;
        wiring[VerkabelungsVorlage.positionImAlphabet(steckerZwei)] = steckerEins;
        System.out.println(steckerEins+"<->"+steckerZwei);
    }


    /**
     *Falls zwischen diesem und einem anderen Stecker eine Verbindung existiert wird diese entfernt
     *
     * @param stecker Stecker, dessen Verbindung getrennt wird
     * @return Der Stecker mit dem der gegebene Stecker verbunden war. Falls ungesteckert der Stecker selbst
     * **/
    public char ausstecken(char stecker){
        char anderer = (char)wiring[VerkabelungsVorlage.positionImAlphabet(stecker)];
        wiring[VerkabelungsVorlage.positionImAlphabet(anderer)]=anderer;
        wiring[VerkabelungsVorlage.positionImAlphabet(stecker)]= stecker;
        System.out.println(stecker+"<- | ->"+anderer);
        return anderer;
    }

    /**
     *
     * @param eingabe Zeichen, dass getauscht werden soll
     * @return Das Zeichen, mit dem der Input verbunden ist
     */
    public char tauschen(char eingabe){
        return (char)wiring[VerkabelungsVorlage.positionImAlphabet(eingabe)];
    }




}
