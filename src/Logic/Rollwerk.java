package Logic;

public class Rollwerk {
    private Rolle rolleEins;
    private Rolle rolleZwei;
    private Rolle rolleDrei;

    public Rollwerk(Rolle rolleEins, Rolle rolleZwei, Rolle rolleDrei) {
        this.rolleEins = rolleEins;
        this.rolleZwei = rolleZwei;
        this.rolleDrei = rolleDrei;
    }

    public char verschlüsseln(char input){
        // Verschlüssel den char
        char forward1 = rolleEins.vorwärts(input);
        char forward2 = rolleZwei.vorwärts(forward1);
        char forward3 = rolleDrei.vorwärts(forward2);

        char reflected = UmkehrWalze.reflektieren(forward3);

        char backwards3 = rolleDrei.rückwärts(reflected);
        char backwards2 = rolleZwei.rückwärts(backwards3);
        char backwards1 = rolleEins.rückwärts(backwards2);

        vorwärtsDrehen();

        return backwards1;
    }

    public char entschlüsseln(char input){
        // Verschlüssel den char
        char forward1 = rolleEins.rückwärts(input);
        char forward2 = rolleZwei.rückwärts(forward1);
        char forward3 = rolleDrei.rückwärts(forward2);

        char reflected = UmkehrWalze.reflektieren(forward3);

        char backwards3 = rolleEins.vorwärts(reflected);
        char backwards2 = rolleZwei.vorwärts(backwards3);
        char backwards1 = rolleDrei.vorwärts(backwards2);

        rückwärtsDrehen();

        return backwards1;
    }

    private void vorwärtsDrehen(){
        rolleEins.incrementPosition();
        if (rolleEins.getPosition() == 0) {
            rolleZwei.incrementPosition();
            if (rolleZwei.getPosition() == 0) {
                rolleDrei.incrementPosition();
            }
        }
    }

    private void rückwärtsDrehen(){
        rolleEins.decrementPosition();
        if (rolleEins.getPosition() == 25) {
            rolleZwei.decrementPosition();
            if (rolleZwei.getPosition() == 25) {
                rolleDrei.decrementPosition();
            }
        }
    }

}
