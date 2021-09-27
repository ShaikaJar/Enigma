package Logic;

public class Rolle {


    public static final Rolle Rolle1 = new Rolle(WiringTemplate.rollen[0]);
    public static final Rolle Rolle2 = new Rolle(WiringTemplate.rollen[1]);
    public static final Rolle Rolle3 = new Rolle(WiringTemplate.rollen[2]);
    public static final Rolle Rolle4= new Rolle(WiringTemplate.rollen[3]);
    public static final Rolle Rolle5 = new Rolle(WiringTemplate.rollen[4]);

    /**
     * Eine Rolle, die die angegebene Verkabelung benutzt und in der Stellung 0 startet
     * @param verkabelung Ein Array, das die Position der Buchstaben im Alphabet auf einen neuen Buchstaben übersetzt
     */
    private Rolle(char[] verkabelung) {
        this.position = 0;
        this.verkabelung = verkabelung;
    }


    /**
     * Dreht die Rolle auf die nächste Position
     * @return Position der Rolle nach Drehung
     */
    public int drehen() {
        position = (position+1)% verkabelung.length;
        return position;
    }

    /**
     * @return Position der Rolle
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position Position auf die, die Rolle gesetzt werden soll. Erwarte Wert zwischen 0 (inklusiv) und 26 (exklusiv)
     * @throws IllegalArgumentException falls die Position nicht im erlaubten bereich liegt
     */
    public void setPosition(int position) {
        if(position >=26 || position < 0)
            throw new IllegalArgumentException("Position liegt nicht zwischen 0 (inklusiv) und 26 (exklusiv)");
        this.position = position% verkabelung.length;
    }

    /**
     * Schickt ein Signal vorwärts durch die Rolle
     * @param eingabe Zeichen, das durch die Rolle geschickt werden soll
     * @return Ergebnis der Verschlüsselung
     */
    public char vorwärts(char eingabe) {
        return (char) (runThrough(eingabe , true));
    }


    /**
     * Schickt ein Signal rückwärts durch die Rolle
     * @param eingabe Zeichen, das durch die Rolle geschickt werden soll
     * @return Ergebnis der Verschlüsselung
     */
    public char rückwärts(char eingabe) {
        return (char) (runThrough(eingabe , false));
    }

    private char[] verkabelung;
    private int position = 0;


    private int runThrough(char character, boolean forward) {
        character = Character.toUpperCase(character);
        if (forward) {
            int input = WiringTemplate.positionImAlphabet(character);
            return verkabelung[(input+position+ verkabelung.length)% verkabelung.length];
        } else {
            for (int i = 0; i < verkabelung.length; i++) {
                if(verkabelung[(i+position)% verkabelung.length] == character)
                    return (WiringTemplate.zeichenNachPositionImAlphabet(i));
            }
        }
        return 'A'-1;
    }
}