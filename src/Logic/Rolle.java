package Logic;

import java.util.Arrays;

public enum Rolle {


    Rolle1(0,0),
    Rolle2(1,0),
    Rolle3(2,0),
    Rolle4(3,0),
    Rolle5(4,0);


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
        character = Character.toUpperCase(character);
        if (forward) {
            int input = character-toChar;
            return wiring[(input+position+wiring.length)%wiring.length];
        } else {
            for (int i = 0; i < wiring.length; i++) {
                if(wiring[(i+position)%wiring.length] == character)
                    return (char)(i+toChar);
            }
        }
        return 'A'-1;
    }
}