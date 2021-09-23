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

    public char vorwärts(char c) {
        return (char) (runThrough(c - toChar, true) + toChar);
    }

    public char rückwärts(char c) {
        return (char) (runThrough(c - toChar, false) + toChar);
    }

    private static final int toChar = 'A';
    private int[] wiring;
    private int position = 0;

    private Rolle(int rotorNumber, int rotorPosition) {
        position = rotorPosition;
        switch (rotorNumber) {
            case 0:
                wiring = new int[]{15, 4, 25 , 20 , 14 , 7 , 23 , 18 , 2 , 21 , 5 , 12 , 19 , 1 , 6 , 11 , 17 , 8 , 13 , 16 , 9 , 22 , 0 , 24 , 3 , 10 };
                break;
            case 1:
                wiring = new int[]{25, 14, 20 , 4 , 18 , 24 , 3 , 10 , 5 , 22 , 15 , 2 , 8 , 16 , 23 , 7 , 12 , 21 , 1 , 11 , 6 , 13 , 9 , 17 , 0 , 19 };
                break;
            case 2:
                wiring = new int[]{4, 7, 17 , 21 , 23 , 6 , 0 , 14 , 1 , 16 , 20 , 18 , 8 , 12 , 25 , 5 , 11 , 24 , 13 , 22 , 10 , 19 , 15 , 3 , 9 , 2 };
                break;
            case 3:
                wiring = new int[]{8, 12, 4 , 19 , 2 , 6 , 5 , 17 , 0 , 24 , 18 , 16 , 1 , 25 , 23 , 22 , 11 , 7 , 10 , 3 , 21 , 20 , 15 , 14 , 9 , 13 };
                break;
            case 4:
                wiring = new int[]{16, 22, 4 , 17 , 19 , 25 , 20 , 8 , 14 , 0 , 18 , 3 , 5 , 6 , 7 , 9 , 10 , 15 , 24 , 23 , 2 , 21 , 1 , 13 , 12 , 11 };
                break;
        }
    }

    private int runThrough(int input, boolean forward) {
        if (forward) {
            return wiring[(input+position+wiring.length)%wiring.length];
        } else {
            return (char) Arrays.stream(wiring).filter(i -> input == wiring[i]).findFirst().orElse(-1);
        }
    }
}