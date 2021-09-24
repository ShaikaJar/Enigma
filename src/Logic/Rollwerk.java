package Logic;

public class Rollwerk {
    private Rolle rolleEins;
    private Rolle rolleZwei;
    private Rolle rolleDrei;
    private UmkehrWalze umkehrWalze = UmkehrWalze.UMKEHR_WALZE_A;

    public Rollwerk(Rolle rolleEins, Rolle rolleZwei, Rolle rolleDrei) {
        this.rolleEins = rolleEins;
        this.rolleZwei = rolleZwei;
        this.rolleDrei = rolleDrei;
    }

    public char verschlüsseln(char input) {
        // Verschlüssel den char
        char forward1 = rolleEins.vorwärts(input);
        char forward2 = rolleZwei.vorwärts(forward1);
        char forward3 = rolleDrei.vorwärts(forward2);

        char reflected = umkehrWalze.reflektieren(forward3);

        char backwards3 = rolleDrei.rückwärts(reflected);
        char backwards2 = rolleZwei.rückwärts(backwards3);
        char backwards1 = rolleEins.rückwärts(backwards2);

        return backwards1;
    }

    public void vorwärtsDrehen() {
        rolleEins.incrementPosition();
        if (rolleEins.getPosition() == 0) {
            rolleZwei.incrementPosition();
            if (rolleZwei.getPosition() == 0) {
                rolleDrei.incrementPosition();
            }
        }
    }

    public int[] getRollenPositionen() {
        return new int[]{
                rolleEins.getPosition(),
                rolleZwei.getPosition(),
                rolleDrei.getPosition(),
        };
    }

    public void setRollenPositionen(int[] positionen) {
        if(positionen.length != 3 )
            throw new IllegalArgumentException();
        rolleEins.setPosition(positionen[0]%26);
        rolleZwei.setPosition(positionen[1]%26);
        rolleDrei.setPosition(positionen[2]%26);
    }

}
