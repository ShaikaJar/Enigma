package UI;

import javafx.scene.Group;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.UnaryOperator;

public class SteckDisplay extends Group {

    String activeStyle = "-fx-background-color: #ff8855;";
    String inActiveStyle = "-fx-background-color: #DDDDDD;";


    private final Button[][] buttons = new Button[][]
            {
                    {
                            new Button("A"),
                            new Button("B"),
                            new Button("C"),
                            new Button("D"),
                            new Button("E"),
                            new Button("F"),
                            new Button("G"),
                    },{
                            new Button("H"),
                            new Button("I"),
                            new Button("J"),
                            new Button("K"),
                            new Button("L"),
                            new Button("M"),
                    }, {
                            new Button("N"),
                            new Button("O"),
                            new Button("P"),
                            new Button("Q"),
                            new Button("R"),
                            new Button("S"),
                            new Button("T"),
                    },{
                            new Button("U"),
                            new Button("V"),
                            new Button("W"),
                            new Button("X"),
                            new Button("Y"),
                            new Button("Z"),
                    }
            };



    UnaryOperator<Character> onDisconnect;
    BiConsumer<Character, Character> onConnect;

    public SteckDisplay(UnaryOperator<Character> onDisconnect, BiConsumer<Character, Character> onConnect) {
        this.onDisconnect = onDisconnect;
        this.onConnect = onConnect;

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                char character = buttons[i][j].getText().charAt(0);
                buttons[i][j].setOnMouseClicked(mouseEvent -> handleClick(character));
                buttons[i][j].setLayoutX((40 * i) );
                buttons[i][j].setLayoutY(40 * j+(20*(i%2)));
                buttons[i][j].setStyle(inActiveStyle);
                buttons[i][j].setVisible(true);
                this.getChildren().add(buttons[i][j]);
            }
        }
    }

    private char active = 'A'-1;

    private static String getColor(char a, char b){
        int code = a*b * (a+b);
        Random rnd = new Random(code);

        Color color = Color.getHSBColor(rnd.nextFloat(), 0.8f, 0.8f);

        int red = color.getRed();
        int green =color.getGreen();
        int blue= color.getBlue();

        String hex = String.format("%02X%02X%02X", red, green, blue);

        System.out.println("Hex:"+hex);
        return "-fx-background-color: #"+hex.substring(2)+";";
    }


    private Optional<Button> getButton(char c) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (buttons[i][j].getText().charAt(0) == Character.toUpperCase(c))
                    return Optional.of(buttons[i][j]);
            }
        }
        return Optional.empty();
    }

    private void handleClick(char character){
        if(active != 'A'-1){
            //Falls berits ein Knopf aktiv ist
            if(character == active)
                disconnect(active);
            else
                connect(character, active);
        }else{
            active = character;
            getButton(active).ifPresent(button -> button.setStyle(activeStyle));
        }

    }

    public void connect(char input, char other) {


        //Verbindungen löschen
        disconnect(input);
        disconnect(other);

        //neue verbindung anlegen
        onConnect.accept(input,other);


        //Falls neue verbindung etabliert wurde, anzeigen
        if(input != other) {
            String style = getColor(input, other);
            getButton(input).ifPresent(button -> button.setStyle(style));
            getButton(other).ifPresent(button -> button.setStyle(style));
        }

        active = 'A'-1;
    }

    public void disconnect(char input) {
        char other = onDisconnect.apply(input);
        disconnectDisplay(input, other);
    }

    public void disconnectDisplay(char one, char two){
        getButton(one).ifPresent(button -> button.setStyle(inActiveStyle));
        getButton(two).ifPresent(button -> button.setStyle(inActiveStyle));
        active = 'A'-1;
    }

    public void clear() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setStyle(inActiveStyle);
                //System.out.println(inActiveStyle);
            }
        }
    }



}
