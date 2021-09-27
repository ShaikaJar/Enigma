package Logic;

public class UmkehrWalze {

    static final UmkehrWalze UMKEHR_WALZE_A = new UmkehrWalze(VerkabelungsVorlage.umkehrwalzen[0]);

    //Todo: Array für verkabelung definieren


    /**
     * Umkehrwalze, die Buchstaben tauscht
     * @param verkabelung Ein Array, das einem Zeichen nach dessen Position im Alphabet ein Zeichen zuweist, durch das es ersetzt werden soll
     */
    private UmkehrWalze(char[] verkabelung) {
        //Todo: Verkabelung speichern
    }


    /**
     * Tauscht die Zeichen
     * @param eingabe Zeichen, das getauscht werden soll
     * @return Zeichen nach Tauschung
     */
    public char reflektieren(char eingabe) {
        //Todo: Zeichen ausgeben mit dem Eingabe verkabelt ist
        return eingabe;
    }
}
