package Logic;

public class UmkehrWalze {
    private static final int toChar = 'A';
    private static final int[] wiring = new int[]{21, 10, 22, 17, 6, 8, 4, 19, 5, 25, 1, 20, 18, 15, 16, 13, 14, 3, 12, 7, 11, 0, 2, 24, 23, 9};

    public static char reflektieren(char input) {
        return (char) ((char) (wiring[(input - toChar) % wiring.length])+toChar);
    }
}
