package weapons;

public class TurretGuns extends Weapon{

    private double damageHealth = 150;
    private double damageArmor = 100;
    private int number;

    public double getDamageHealth() {
        return damageHealth;
    }

    public void setDamageHealth(double damageHealth) {
        this.damageHealth = damageHealth;
    }

    public double getDamageArmor() {
        return damageArmor;
    }

    public void setDamageArmor(double damageArmor) {
        this.damageArmor = damageArmor;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Turret Gun";
    }
}
