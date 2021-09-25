package Logic;

public class UmkehrWalze {

    static final UmkehrWalze UMKEHR_WALZE_A = new UmkehrWalze("EJMZALYXVBWFCRQUONTSPIKHGD".toCharArray());

    private final int toChar = 'A';
    private final char[] wiring;


    private UmkehrWalze(char[] wiring) {
        this.wiring = wiring;
    }

    public char reflektieren(char input) {
        return (wiring[(input - toChar) % wiring.length]);
    }
}
