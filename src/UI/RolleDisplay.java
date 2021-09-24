package UI;

import Logic.Rolle;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.util.function.BiConsumer;
import java.util.function.Consumer;


public class RolleDisplay extends Group {

    Button[] rollen = new Button[3];
    int[] rollenPos = new int[3];

    Button reset;

    final Consumer<int[]> onSetPosition;

    RolleDisplay(int[] positionen, Consumer<int[]> onSetPosition) {
        this.onSetPosition = onSetPosition;
        this.rollenPos = positionen;
        for (int i = 0; i < 3; i++) {
            rollen[i] = new Button(text(positionen[i]));
            rollen[i].setLayoutX(40 * i);
            rollen[i].setLayoutY(0);
            rollen[i].setVisible(true);
            int index = i;
            rollen[i].setOnMouseClicked(mouseEvent -> {
                int[] newPos = new int[]{rollenPos[0],rollenPos[1],rollenPos[2]};
                newPos[index]= (newPos[index]+1)%26;
                this.onSetPosition.accept(newPos);
            });
            this.getChildren().add(rollen[i]);
        }


        reset = new Button("Reset");
        reset.setLayoutX(40 * 4);
        reset.setLayoutY(0);
        reset.setOnMouseClicked(mouseEvent -> onSetPosition.accept(new int[]{0,0,0}));
        reset.setVisible(true);
        this.getChildren().add(reset);
    }

    private String text(int pos) {
        return (char) (pos + 'A') + "";
    }


    public void update(int[] positionen) {
        this.rollenPos = positionen;
        for (int i = 0; i < 3; i++) {
            rollen[i].setText(text(positionen[i]));
        }
    }

}
