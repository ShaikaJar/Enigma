package Logic;

public class VerkabelungsVorlage {

    public static final char[][] rollen = new char[][]{
            "EKMFLGDQVZNTOWYHXUSPAIBRCJ".toCharArray(),
            "AJDKSIRUXBLHWTMCQGZNPYFVOE".toCharArray(),
            "BDFHJLCPRTXVZNYEIWGAKMUSQO".toCharArray(),
            "ESOVPZJAYQUIRHXLNFTGKDCMWB".toCharArray(),
            "VZBRGITYUPSDNHLXAWMJQOFECK".toCharArray()
    };
    public static final char[][] umkehrwalzen = new char[][]{
            "EJMZALYXVBWFCRQUONTSPIKHGD".toCharArray()
    };

    /**
     * @param zeichen Zeichen dessen Position bestimmt werden soll
     * @return Position des Zeichens im Alphabet
     */
    public static int positionImAlphabet(char zeichen){
        return Character.toUpperCase(zeichen)-'A';
    }


    /**
     * @param position Position im Alphabet, für die das Zeichen bestimmt werden soll
     * @return Zeichen, dessen Position im Alphabet der gegebenen Position entspricht
     */
    public static char zeichenNachPositionImAlphabet(int position){
        return (char)(position+'A');
    }
}
