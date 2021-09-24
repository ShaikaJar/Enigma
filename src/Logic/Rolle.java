package Logic;

import java.util.Arrays;

public class Rolle {


    public static final Rolle Rolle1 = new Rolle(0,0);
    public static final Rolle Rolle2 = new Rolle(1,0);
    public static final Rolle Rolle3 = new Rolle(2,0);
    public static final Rolle Rolle4 = new Rolle(3,0);
    public static final Rolle Rolle5 = new Rolle(4,0);


    public int incrementPosition() {
        position = (position+1)%wiring.length;
        return position;
    }

    public int decrementPosition() {
        position = (position-1+wiring.length)%wiring.length;
        return position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position%wiring.length;
    }

    public char vorwärts(char input) {
        return (char) (runThrough(input , true));
    }

    public char rückwärts(char input) {
        return (char) (runThrough(input , false));
    }

    private static final int toChar = 'A';
    private char[] wiring;
    private int position = 0;

    private Rolle(int rotorNumber, int rotorPosition) {
        position = rotorPosition;
        switch (rotorNumber) {
            case 0:
                wiring = "EKMFLGDQVZNTOWYHXUSPAIBRCJ".toCharArray();
                break;
            case 1:
                wiring = "AJDKSIRUXBLHWTMCQGZNPYFVOE".toCharArray();
                break;
            case 2:
                wiring = "BDFHJLCPRTXVZNYEIWGAKMUSQO".toCharArray();
                break;
            case 3:
                wiring = "ESOVPZJAYQUIRHXLNFTGKDCMWB".toCharArray();
                break;
            case 4:
                wiring = "VZBRGITYUPSDNHLXAWMJQOFECK".toCharArray();
                break;
        }
    }

    private int runThrough(char character, boolean forward) {
        if (forward) {
            int input = character-toChar;
            return wiring[(input+position+wiring.length)%wiring.length];
        } else {
            for (int i = 0; i < wiring.length; i++) {
                if(wiring[i] == character)
                    return (char)(i+toChar);
            }
        }
        return 'A'-1;
    }
}