package Logic;

import java.util.Arrays;

public class Rolle {


    static final Rolle Rolle1 = new Rolle(WiringTemplate.rollen[0],0);
    static final Rolle Rolle2 = new Rolle(WiringTemplate.rollen[2],0);
    static final Rolle Rolle3 = new Rolle(WiringTemplate.rollen[3],0);
    static final Rolle Rolle4= new Rolle(WiringTemplate.rollen[4],0);
    static final Rolle Rolle5 = new Rolle(WiringTemplate.rollen[5],0);


    private Rolle(char[] wiring, int rotorPosition) {
        position = rotorPosition;
    }


    public int drehen() {
        position = (position+1)%wiring.length;
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