package Logic;

public class Rolle {


    public static final Rolle Rolle1 = new Rolle(VerkabelungsVorlage.rollen[0]);
    public static final Rolle Rolle2 = new Rolle(VerkabelungsVorlage.rollen[1]);
    public static final Rolle Rolle3 = new Rolle(VerkabelungsVorlage.rollen[2]);
    public static final Rolle Rolle4= new Rolle(VerkabelungsVorlage.rollen[3]);
    public static final Rolle Rolle5 = new Rolle(VerkabelungsVorlage.rollen[4]);


    //Todo: Array für Verkabelung definieren
    //Todo: Position definieren;

    /**
     * Eine Rolle, die die angegebene Verkabelung benutzt und in der Stellung 0 startet
     * @param verkabelung Ein Array, das die Position der Buchstaben im Alphabet auf einen neuen Buchstaben übersetzt
     */
    private Rolle(char[] verkabelung) {
        //Todo: Verkabelung speichern
        //Todo: Position auf 0 starten
    }


    /**
     * Dreht die Rolle auf die nächste Position
     * @return Position der Rolle nach Drehung
     */
    public int drehen() {
        //Todo: Position um 1 erhöhen. Positionen größer 26 sollten wieder bei 0 beginnen
        return 0; //Todo: Neue Position zurückgeben
    }

    /**
     * @return Position der Rolle
     */
    public int getPosition() {
        return 0; //Todo: Position zurückgeben
    }

    /**
     * @param position Position auf die, die Rolle gesetzt werden soll. Erwarte Wert zwischen 0 (inklusiv) und 26 (exklusiv)
     * @throws IllegalArgumentException falls die Position nicht im erlaubten bereich liegt
     */
    public void setPosition(int position) {
        //Todo: Positionen die nicht zwischen 0 (inklusiv) und 26 (exklusiv) sollen eine IllegalArgumentException werfen
        //  Gebt in der Exception die Nachricht "Position liegt nicht zwischen 0 (inklusiv) und 26 (exklusiv)" aus

        //Todo: Position setzen
    }

    /**
     * Schickt ein Signal vorwärts durch die Rolle
     * @param eingabe Zeichen, das durch die Rolle geschickt werden soll
     * @return Ergebnis der Verschlüsselung
     */
    public char vorwärts(char eingabe) {
        //Todo: Zeichen vorwärts durch Rolle schicken

        //Todo: Ergebnis der Verschlüsselung ausgeben
        return eingabe;
    }


    /**
     * Schickt ein Signal rückwärts durch die Rolle
     * @param eingabe Zeichen, das durch die Rolle geschickt werden soll
     * @return Ergebnis der Verschlüsselung
     */
    public char rückwärts(char eingabe) {
        //Todo: Zeichen rückwärts durch Rolle schicken

        //Todo: Ergebnis der Verschlüsselung ausgeben
        return eingabe;
    }

}