package Logic;

public class UmkehrWalze {

    static final UmkehrWalze UMKEHR_WALZE_A = new UmkehrWalze(WiringTemplate.umkehrwalzen[0]);

    private final char[] wiring;


    /**
     * Umkehrwalze, die Buchstaben tauscht
     * @param wiring Ein Array, das einem Zeichen nach dessen Position im Alphabet ein Zeichen zuweist, durch das es ersetzt werden soll
     */
    private UmkehrWalze(char[] wiring) {
        this.wiring = wiring;
    }


    /**
     * Tauscht die Zeichen
     * @param eingabe Zeichen, das getauscht werden soll
     * @return Zeichen nach Tauschung
     */
    public char reflektieren(char eingabe) {
        return (wiring[WiringTemplate.positionImAlphabet(eingabe) % wiring.length]);
    }
}
