package weapons;

public class Weapon {

    private double damageHealth;
    private double damageArmor;
    private int number;
    private String name;
    private double shootingRate;

    public double getShootingRate() {
        return shootingRate;
    }

    public void setShootingRate(double shootingRate) {
        this.shootingRate = shootingRate;
    }

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
