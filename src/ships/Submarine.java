package ships;

import ships.Ship;
import weapons.Torpedo;
import weapons.Weapon;

public class Submarine extends Ship {
    private String name = "Submarine";
    private double armor = 1000;
    private double health = 800;
    Torpedo torpedo = new Torpedo();
    Weapon weapons[] = {torpedo};

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getArmor() {
        return armor;
    }

    @Override
    public void setArmor(double armor) {
        this.armor = armor;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    public Torpedo getTorpedo() {
        return torpedo;
    }

    public void setTorpedo(Torpedo torpedo) {
        this.torpedo = torpedo;
    }

    public String[] getActionMessage() {
        String actions[] = {"Use Torpedo, (" + torpedo.getNumber() + ") left"};
        return actions;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    @Override
    public String toString() {
        return name;
    }
}
