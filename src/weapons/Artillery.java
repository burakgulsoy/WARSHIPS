package weapons;

public class Artillery extends Weapon{

    private double damageHealth = 500;
    private double damageArmor = 400;
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
        return "Artillery";
    }
}
