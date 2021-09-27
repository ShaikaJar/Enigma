package Logic;

public class Rollwerk {
    private Rolle rolle1;
    private Rolle rolle2;
    private Rolle rolle3;
    private UmkehrWalze umkehrWalze = UmkehrWalze.UMKEHR_WALZE_A;

    /**
     * Ein Rollwerk mit drei ausgewählten Rollen, die in der angegebenen Reihenfolge zur Verschlüsselung benutzt werden
     * @param rolle1 Erste Rolle
     * @param rolle2 Zweite Rolle
     * @param rolle3 Dritte Rolle
     */
    public Rollwerk(Rolle rolle1, Rolle rolle2, Rolle rolle3) {
        this.rolle1 = rolle1;
        this.rolle2 = rolle2;
        this.rolle3 = rolle3;
    }

    /**
     * Schickt ein Signal vorwärts durch die drei Rollen, die UmkehrWalze und dann rückwärts durch die drei Rollen
     * @param eingabe Zeichen, das verschlüsselt werden soll
     * @return Ergebnis der Verschlüsselung
     */
    public char verschlüsseln(char eingabe) {

        //vorwärts durch alle Rollen
        char vorwärts1 = rolle1.vorwärts(eingabe);
        char vorwärts2 = rolle2.vorwärts(vorwärts1);
        char vorwärts3 = rolle3.vorwärts(vorwärts2);

        //Umdrehen in UmkehrWalze
        char umgedreht = umkehrWalze.reflektieren(vorwärts3);

        //Rückwärts durch alle Rollen
        char rückwärts3 = rolle3.rückwärts(umgedreht);
        char rückwärts2 = rolle2.rückwärts(rückwärts3);
        char rückwärts1 = rolle1.rückwärts(rückwärts2);

        return rückwärts1;
    }

    /**
     * Dreht die Rollen zur nächsten Position
     * Die erste Rolle wird immer um eine Position gedreht.
     * Hat die erste Rolle eine Umdrehung zurückgelegt, dreht die zweite Rolle sich um eine Position
     * Hat die zweite Rolle eine Umdrehung zurückgelegt, dreht die dritte Rolle sich um eine Position
     */
    public void drehen() {
        rolle1.drehen();
        if (rolle1.getPosition() == 0) {
            rolle2.drehen();
            if (rolle2.getPosition() == 0) {
                rolle3.drehen();
            }
        }
    }

    /**
     * Gibt die Position der Rollen zurück
     * @return Ein Array dessen Werte die Position der zugehörigen Rolle angibt. bsp. array[0] → Erste Rolle
     */
    public int[] getRollenPositionen() {
        return new int[]{
                rolle1.getPosition(),
                rolle2.getPosition(),
                rolle3.getPosition(),
        };
    }


    /**
     * Setzt die Position der Rollen
     * @param positionen  Ein Array dessen Werte die Position der zugehörigen Rolle angibt. bsp. array[0] → Erste Rolle
     */
    public void setRollenPositionen(int[] positionen) {
        if(positionen.length != 3 )
            throw new IllegalArgumentException();
        rolle1.setPosition(positionen[0]%26);
        rolle2.setPosition(positionen[1]%26);
        rolle3.setPosition(positionen[2]%26);
    }

}
