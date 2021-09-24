package Logic;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class Enigma {


    private Rollwerk rollwerk;
    private SteckBrett steckBrett;

    public Enigma(Rollwerk rollwerk, SteckBrett steckBrett) {
        this.rollwerk = rollwerk;
        this.steckBrett = steckBrett;
    }

    //qtiab
    public static void main(String[] args) {
        Enigma enigma = new Enigma(
                        new Rollwerk(Rolle.Rolle1,Rolle.Rolle2,Rolle.Rolle3),
                        new SteckBrett()
        );


        Scanner sc = new Scanner(System.in);
        while(true){
            if(!sc.hasNextLine())
                continue;
            String inString = sc.nextLine();
            StringBuffer out = new StringBuffer();
            for (char inChar :
                    inString.toCharArray()) {
                out.append(enigma.verschlüsseln(inChar));
            }
            System.out.println(out);
        }

    }

    public char ausstecken(char stecker){
        return steckBrett.ausstecken(stecker);
    }

    public void einstecken(char steckerEins, char steckerZwei){
        steckBrett.einstecken(steckerEins,steckerZwei);
    }

    public char verschlüsseln(char in) {

        in = Character.toUpperCase(in);

        //Signal durch Steckbrett schicken
        char verschlüsselt = steckBrett.tauschen(in);

        //Signal durch Rollwerk schicken
        verschlüsselt = rollwerk.verschlüsseln(verschlüsselt);
        //Rollwerk auf nächste Position
        rollwerk.vorwärtsDrehen();

        //Signal durch Steckbrett schicken
        verschlüsselt = steckBrett.tauschen(verschlüsselt);

        System.out.println(in+"->"+verschlüsselt);

        return verschlüsselt;
    }

    public int[] getRollenPositionen(){
        return rollwerk.getRollenPositionen();
    }

    public void setPositionen(int[] positionen){
        rollwerk.setRollenPositionen(positionen);
    }
}
