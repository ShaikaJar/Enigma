package UI;

import Logic.Rolle;
import javafx.scene.Group;
import javafx.scene.control.Button;


public class RolleDisplay extends Group {

    Button[] rollen = new Button[3];

    RolleDisplay(int[] positionen){
        double layoutX = 0;//this.getParent().getLayoutX();
        double layoutY = 0;//this.getParent().getLayoutX();
        this.setLayoutX(layoutX);
        this.setLayoutY(layoutY);
        this.setStyle("-fx-background-color: #999999;");
        for (int i = 0; i < rollen.length; i++) {
            rollen[i] = new Button(text(positionen[i]));
            rollen[i].setLayoutX(layoutX+40*i);
            rollen[i].setLayoutY(layoutY);
            rollen[i].setVisible(true);
            this.getChildren().add(rollen[i]);
        }
    }

    private String text(int pos){
        return (pos>=10?"":"0")+pos;
    }


    public void update(int[] positionen){
        for (int i = 0; i < rollen.length; i++) {
            rollen[i].setText(text(positionen[i]));
        }
    }

}
