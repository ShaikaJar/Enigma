package Logic;

public class Rollwerk {
    private Rolle rolle1;
    private Rolle rolle2;
    private Rolle rolle3;
    private UmkehrWalze umkehrWalze = UmkehrWalze.UMKEHR_WALZE_A;

    public Rollwerk(Rolle rolle1, Rolle rolle2, Rolle rolle3) {
        this.rolle1 = rolle1;
        this.rolle2 = rolle2;
        this.rolle3 = rolle3;
    }

    public char verschlüsseln(char eingabe) {

        //vorwärts durch alle Rollen
        char vorwärts1 = rolle1.vorwärts(eingabe);
        char vorwärts2 = rolle2.vorwärts(vorwärts1);
        char vorwärts3 = rolle3.vorwärts(vorwärts2);

        //Umdrehen in Umkehrwalze
        char umgedreht = umkehrWalze.reflektieren(vorwärts3);

        //Rückwärts durch alle Rollen
        char rückwärts3 = rolle3.rückwärts(umgedreht);
        char rückwärts2 = rolle2.rückwärts(rückwärts3);
        char rückwärts1 = rolle1.rückwärts(rückwärts2);

        return rückwärts1;
    }

    public void drehen() {
        rolle1.drehen();
        if (rolle1.getPosition() == 0) {
            rolle2.drehen();
            if (rolle2.getPosition() == 0) {
                rolle3.drehen();
            }
        }
    }

    public int[] getRollenPositionen() {
        return new int[]{
                rolle1.getPosition(),
                rolle2.getPosition(),
                rolle3.getPosition(),
        };
    }

    public void setRollenPositionen(int[] positionen) {
        if(positionen.length != 3 )
            throw new IllegalArgumentException();
        rolle1.setPosition(positionen[0]%26);
        rolle2.setPosition(positionen[1]%26);
        rolle3.setPosition(positionen[2]%26);
    }

}
