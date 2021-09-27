package Logic;

public class Rollwerk {
    //Todo: Rollen definieren

    //Todo: Umkehrwalze definieren

    /**
     * Ein Rollwerk mit drei ausgewählten Rollen, die in der angegebenen Reihenfolge zur Verschlüsselung benutzt werden
     * @param rolle1 Erste Rolle
     * @param rolle2 Zweite Rolle
     * @param rolle3 Dritte Rolle
     */
    public Rollwerk(Rolle rolle1, Rolle rolle2, Rolle rolle3) {
        //Todo: Rollen speichern

        //Todo: Umkehrwalze anlegen
    }

    /**
     * Schickt ein Signal vorwärts durch die drei Rollen, die UmkehrWalze und dann rückwärts durch die drei Rollen
     * @param eingabe Zeichen, das verschlüsselt werden soll
     * @return Ergebnis der Verschlüsselung
     */
    public char verschlüsseln(char eingabe) {
        //Todo: vorwärts durch alle Rollen

        //Todo: Umdrehen in UmkehrWalze

        //Todo: Rückwärts durch alle Rollen

        //Todo: Verschlüsseltes Zeichen zurückgeben
        return eingabe;
    }

    /**
     * Dreht die Rollen zur nächsten Position
     * Die erste Rolle wird immer um eine Position gedreht.
     * Hat die erste Rolle eine Umdrehung zurückgelegt, dreht die zweite Rolle sich um eine Position
     * Hat die zweite Rolle eine Umdrehung zurückgelegt, dreht die dritte Rolle sich um eine Position
     */
    public void drehen() {
        //Todo: Rolle Drehen
    }

    /**
     * Gibt die Position der Rollen zurück
     * @return Ein Array dessen Werte die Position der zugehörigen Rolle angibt. bsp. array[0] → Erste Rolle
     */
    public int[] getRollenPositionen() {
        //Todo: Rollen-Positionen als Array zurückgeben
        return new int[]{0,0,0};
    }


    /**
     * Setzt die Position der Rollen
     * @param positionen  Ein Array dessen Werte die Position der zugehörigen Rolle angibt. bsp. array[0] → Erste Rolle
     */
    public void setRollenPositionen(int[] positionen) {
        //Todo: Rollen-Positionen setzen
        //      Bei einer Array-Länge ungleich 3 soll eine IllegalArgumentException geworfen werden
    }

}
