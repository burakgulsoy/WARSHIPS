package weapons;

public class ArmorPiercingShots extends Weapon{
    private double damageHealth = 125;
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
        return "Armor Piercing Shots";
    }
}
