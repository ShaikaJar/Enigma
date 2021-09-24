package Logic;

public class UmkehrWalze {
    private final int toChar = 'A';
    private final char[] wiring = "EJMZALYXVBWFCRQUONTSPIKHGD".toCharArray();

    public char reflektieren(char input) {
        return (wiring[(input - toChar) % wiring.length]);
    }
}
