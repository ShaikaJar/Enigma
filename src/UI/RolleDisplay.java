package UI;

import Logic.Rolle;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;


public class RolleDisplay extends Group {

    Button[] rollen = new Button[3];
    
    Button reset;

    RolleDisplay(int[] positionen){
        this.setStyle("-fx-background-color: #999999;");
        for (int i = 0; i < 3; i++) {
            rollen[i] = new Button(text(positionen[i]));
            rollen[i].setLayoutX(40*i);
            rollen[i].setLayoutY(0);
            rollen[i].setVisible(true);
            this.getChildren().add(rollen[i]);
        }


        reset = new Button("Reset");
        reset.setLayoutX(40*4);
        reset.setLayoutY(0);
        reset.setVisible(true);
        this.getChildren().add(reset);
    }
    
    public void setOnReset(EventHandler<MouseEvent> resetHandler){
        reset.setOnMouseClicked(resetHandler);
    }

    private String text(int pos){
        return (char)(pos+'A')+"";
    }


    public void update(int[] positionen){
        for (int i = 0; i < 3; i++) {
            rollen[i].setText(text(positionen[i]));
        }
    }

}
