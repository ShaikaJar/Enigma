package UI;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Skin;
import javafx.scene.layout.HBox;

import java.util.*;

class KeyboardDisplay extends Group {

    String activeStyle = "-fx-background-color: #ff8800;";
    String inActiveStyle = "-fx-background-color: #CCCCCC;";

    private final Button[][] buttons = new Button[][]
            {
                {
                        new Button("Q"),
                        new Button("W"),
                        new Button("E"),
                        new Button("R"),
                        new Button("T"),
                        new Button("Z"),
                        new Button("U"),
                        new Button("I"),
                        new Button("O"),
                        new Button("P"),
                }, {
                        new Button("A"),
                        new Button("S"),
                        new Button("D"),
                        new Button("F"),
                        new Button("G"),
                        new Button("H"),
                        new Button("J"),
                        new Button("K"),
                        new Button("L"),
                }, {
                        new Button("Y"),
                        new Button("X"),
                        new Button("C"),
                        new Button("V"),
                        new Button("B"),
                        new Button("N"),
                        new Button("M"),
                }
            };

    char active = (char) -1;

    KeyboardDisplay() {

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                Button b = buttons[i][j];
                b.setLayoutX((40 * j) + (30 * i));
                b.setLayoutY(40 * i);
                //b.setDisable(true);
                b.setVisible(true);
                this.getChildren().add(b);
            }
        }

        clear();
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

    public void setActive(char input) {
        getButton(input).ifPresent(button -> button.setStyle(activeStyle));
        if (input != active)
            getButton(active).ifPresent(button -> button.setStyle(inActiveStyle));
        active = input;
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
