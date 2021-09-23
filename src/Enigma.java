import Logic.Rolle;
import Logic.Rollwerk;
import Logic.SteckBrett;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Enigma {


    private Rollwerk rollwerk;
    private InputStreamReader inputStream;
    private OutputStreamWriter outputStream;
    private SteckBrett steckBrett;

    public Enigma(Rollwerk rollwerk, SteckBrett steckBrett, InputStreamReader inputStream, OutputStreamWriter outputStream) {
        this.rollwerk = rollwerk;
        this.steckBrett = steckBrett;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        Stream.generate(() -> {
                    try {
                        return Character.toUpperCase((char)inputStream.read());
                    } catch (IOException e) {
                        e.printStackTrace();
                        return '@';
                    }
                }).map(character -> character==' '||character=='\n'?character:((character>='A' && character<='Z')?verschlüsseln(character):'_'))
                .forEach(c -> {
                    try {
                        outputStream.write(c);
                        outputStream.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    //qtiab
    public static void main(String[] args) {
        Enigma enigma = new Enigma(
                        new Rollwerk(Rolle.Rolle1,Rolle.Rolle2,Rolle.Rolle3),
                        new SteckBrett(),
                        new InputStreamReader(System.in),
                        new OutputStreamWriter(System.out)
        );

    }

    public char verschlüsseln(char in) {

        //Signal durch Steckbrett schicken
        char verschlüsselt = steckBrett.tauschen(in);

        //Signal durch Rollwerk schicken
        verschlüsselt = rollwerk.verschlüsseln(verschlüsselt);
        //Rollwerk auf nächste Position
        rollwerk.vorwärtsDrehen();

        //Signal durch Steckbrett schicken
        verschlüsselt = steckBrett.tauschen(verschlüsselt);

        return verschlüsselt;
    }
}
