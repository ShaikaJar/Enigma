package UI;

import Logic.Enigma;
import Logic.Rolle;
import Logic.Rollwerk;
import Logic.SteckBrett;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;

public class EnigmaController {
    public static EnigmaController instance;
    private final Enigma enigma;

    @FXML
    Group out;
    @FXML
    Group in;
    @FXML
    Group rolle;
    @FXML
    Group steckBrett;

    KeyboardDisplay displayIn;
    KeyboardDisplay displayOut;

    RolleDisplay rolleDisplay;

    SteckDisplay steckDisplay;


    @FXML
    private void initialize(){
        in.getChildren().add(displayIn = new KeyboardDisplay());
        out.getChildren().add(displayOut = new KeyboardDisplay());
        rolle.getChildren().add(rolleDisplay = new RolleDisplay(enigma.getRollenPositionen()));
        steckBrett.getChildren().add(steckDisplay = new SteckDisplay(enigma::ausstecken, enigma::einstecken));
    }

    public EnigmaController() {
        this.enigma = new Enigma(
                new Rollwerk(Rolle.Rolle1,Rolle.Rolle2,Rolle.Rolle3),
                new SteckBrett()
        );
        instance = this;
    }

    private int active = 0;
    private char activeInput = (char)-1;
    private char activeChar;

    public void handleKey(KeyEvent keyEvent) {

        if(active >0) return;
        displayIn.clear();
        displayOut.clear();
        //clear();
        //clearIdentity();
        active++;

        char in = keyEvent.getCharacter().charAt(0);
        if(!Character.isAlphabetic(in))
            return;
        if(activeInput != (char)-1)
            return;

        activeInput = Character.toUpperCase(in);
        activeChar = enigma.verschlüsseln(in);

        displayOut.setActive(activeChar);
        displayIn.setActive(activeInput);
        //getButtonIdenty((char) activeInput).setStyle(activeStyle);
        //getButton((char) activeChar).setStyle(activeStyle);
        rolleDisplay.update(enigma.getRollenPositionen());
        rolleDisplay.setOnReset(mouseEvent -> {
            enigma.setPositionen(new int[]{0,0,0});
            rolleDisplay.update(enigma.getRollenPositionen());
        });
    }

    public void handleRelease(KeyEvent keyEvent){
        //System.out.println(keyEvent.toString());
        active--;
        if(active<=0 && activeInput == Character.toUpperCase(keyEvent.getText().charAt(0))) {
            //clear();
            //clearIdentity();
            activeInput = (char)-1;
            activeChar = (char)-1;
        }
    }

}
