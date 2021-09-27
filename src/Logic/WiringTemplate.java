package Logic;

public class WiringTemplate {

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
    public static int positionImAlphabet(char zeichen){
        return Character.toUpperCase(zeichen)-'A';
    }
    public static char zeichenNachPositionImAlphabet(int position){
        return (char)(position+'A');
    }
}
