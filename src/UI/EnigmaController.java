package UI;

import Logic.Enigma;
import Logic.Rolle;
import Logic.Rollwerk;
import Logic.SteckBrett;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;

import java.util.Arrays;

public class EnigmaController {
    public static EnigmaController instance;
    private Enigma enigma;

    String activeStyle = "-fx-background-color: #ff8800;";
    String inActiveStyle = "-fx-background-color: #CCCCCC;";


    private Button getButton(char c){
        return Arrays.stream(buttons).filter(button -> button.getId().charAt(0)==Character.toUpperCase(c)).findFirst().get();
    }
    Button[] buttons;


    @FXML
    Button Q;
    @FXML
    Button W;
    @FXML
    Button E;
    @FXML
    Button R;
    @FXML
    Button T;
    @FXML
    Button Z;
    @FXML
    Button U;
    @FXML
    Button I;
    @FXML
    Button O;
    @FXML
    Button P;

    @FXML
    Button A;
    @FXML
    Button S;
    @FXML
    Button D;
    @FXML
    Button F;
    @FXML
    Button G;
    @FXML
    Button H;
    @FXML
    Button J;
    @FXML
    Button K;
    @FXML
    Button L;

    @FXML
    Button Y;
    @FXML
    Button X;
    @FXML
    Button C;
    @FXML
    Button V;
    @FXML
    Button B;
    @FXML
    Button N;
    @FXML
    Button M;


    private Button getButtonIdenty(char c){
        return Arrays.stream(buttonsI).filter(button -> button.getId().charAt(0)==Character.toUpperCase(c)).findFirst().get();
    }
    Button[] buttonsI;

    @FXML
    Button Qi;
    @FXML
    Button Wi;
    @FXML
    Button Ei;
    @FXML
    Button Ri;
    @FXML
    Button Ti;
    @FXML
    Button Zi;
    @FXML
    Button Ui;
    @FXML
    Button Ii;
    @FXML
    Button Oi;
    @FXML
    Button Pi;

    @FXML
    Button Ai;
    @FXML
    Button Si;
    @FXML
    Button Di;
    @FXML
    Button Fi;
    @FXML
    Button Gi;
    @FXML
    Button Hi;
    @FXML
    Button Ji;
    @FXML
    Button Ki;
    @FXML
    Button Li;

    @FXML
    Button Yi;
    @FXML
    Button Xi;
    @FXML
    Button Ci;
    @FXML
    Button Vi;
    @FXML
    Button Bi;
    @FXML
    Button Ni;
    @FXML
    Button Mi;


    @FXML
    private void initialize(){
        buttons = new Button[]{Q, W, E, R, T, Z, U, I, O, P,
                A, S, D, F, G, H, J, K, L,
                Y, X, C, V, B, N, M};

        buttonsI = new Button[]{Qi, Wi, Ei, Ri, Ti, Zi, Ui, Ii, Oi, Pi,
                Ai, Si, Di, Fi, Gi, Hi, Ji, Ki, Li,
                Yi, Xi, Ci, Vi, Bi, Ni, Mi};
        clear();
        clearIdentity();
    }

    @FXML
    Group out;

    public EnigmaController() {
        this.enigma = new Enigma(
                new Rollwerk(Rolle.Rolle1,Rolle.Rolle2,Rolle.Rolle3),
                new SteckBrett()
        );
        instance = this;
    }


    private int active = 0;
    private int activeInput = -1;
    private char activeChar;

    public void handleKey(KeyEvent keyEvent) {

        if(active >0) return;
        clear();
        clearIdentity();
        active++;

        char in = keyEvent.getCharacter().charAt(0);
        if(!Character.isAlphabetic(in))
            return;
        if(activeInput != -1)
            return;

        activeInput = Character.toUpperCase(in);
        activeChar = enigma.verschlüsseln(in);


        getButtonIdenty((char) activeInput).setStyle(activeStyle);
        getButton((char) activeChar).setStyle(activeStyle);
    }

    public void handleRelease(KeyEvent keyEvent){
        //System.out.println(keyEvent.toString());
        active--;
        if(active<=0 && activeInput == Character.toUpperCase(keyEvent.getText().charAt(0))) {
            clear();
            clearIdentity();
            activeInput = -1;
            activeChar = (char)-1;
        }
    }

    private void clear(){
        for (Button b :
                buttons) {
            b.setStyle(inActiveStyle);
        }}


    private void clearIdentity(){
        for (Button b :
                buttonsI) {
            b.setStyle(inActiveStyle);
        }}
}
