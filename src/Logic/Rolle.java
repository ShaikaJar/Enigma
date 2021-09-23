package Logic;

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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position%wiring.length;
    }

    public char forwaerts(char c) {
        return (char) (runThrough(c - toChar, true) + toChar);
    }

    public char rueckwaerts(char c) {
        return (char) (runThrough(c - toChar, false) + toChar);
    }

    private static final int toChar = 'A';
    private int[][] wiring;
    private int position = 0;

    private Rolle(int rotorNumber, int rotorPosition) {
        position = rotorPosition;
        switch (rotorNumber) {
            case 0:
                wiring = new int[][]{{0, 15}, {1, 4}, {2, 25}, {3, 20}, {4, 14}, {5, 7}, {6, 23}, {7, 18}, {8, 2}, {9, 21}, {10, 5}, {11, 12}, {12, 19}, {13, 1}, {14, 6}, {15, 11}, {16, 17}, {17, 8}, {18, 13}, {19, 16}, {20, 9}, {21, 22}, {22, 0}, {23, 24}, {24, 3}, {25, 10}};
                break;
            case 1:
                wiring = new int[][]{{0, 25}, {1, 14}, {2, 20}, {3, 4}, {4, 18}, {5, 24}, {6, 3}, {7, 10}, {8, 5}, {9, 22}, {10, 15}, {11, 2}, {12, 8}, {13, 16}, {14, 23}, {15, 7}, {16, 12}, {17, 21}, {18, 1}, {19, 11}, {20, 6}, {21, 13}, {22, 9}, {23, 17}, {24, 0}, {25, 19}};
                break;
            case 2:
                wiring = new int[][]{{0, 4}, {1, 7}, {2, 17}, {3, 21}, {4, 23}, {5, 6}, {6, 0}, {7, 14}, {8, 1}, {9, 16}, {10, 20}, {11, 18}, {12, 8}, {13, 12}, {14, 25}, {15, 5}, {16, 11}, {17, 24}, {18, 13}, {19, 22}, {20, 10}, {21, 19}, {22, 15}, {23, 3}, {24, 9}, {25, 2}};
                break;
            case 3:
                wiring = new int[][]{{0, 8}, {1, 12}, {2, 4}, {3, 19}, {4, 2}, {5, 6}, {6, 5}, {7, 17}, {8, 0}, {9, 24}, {10, 18}, {11, 16}, {12, 1}, {13, 25}, {14, 23}, {15, 22}, {16, 11}, {17, 7}, {18, 10}, {19, 3}, {20, 21}, {21, 20}, {22, 15}, {23, 14}, {24, 9}, {25, 13}};
                break;
            case 4:
                wiring = new int[][]{{0, 16}, {1, 22}, {2, 4}, {3, 17}, {4, 19}, {5, 25}, {6, 20}, {7, 8}, {8, 14}, {9, 0}, {10, 18}, {11, 3}, {12, 5}, {13, 6}, {14, 7}, {15, 9}, {16, 10}, {17, 15}, {18, 24}, {19, 23}, {20, 2}, {21, 21}, {22, 1}, {23, 13}, {24, 12}, {25, 11}};
                break;
        }
    }

    private int runThrough(int input, boolean forward) {

        if (forward) {
            input = (input + position) % 26;

            return wiring[input][1];
        } else {
            for (int i = 0; i < 26; i++) {
                if (input == wiring[i][1]) {
                    int output = (wiring[i][0] - position);
                    while (output < 0) {
                        output = 26 + output;
                    }
                    output = output % 26;

                    return output;
                }
            }
        }
        return -1;
    }
}