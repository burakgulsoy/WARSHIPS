package ships;

import weapons.Weapon;

public class Ship {
        private String name;
        private double health;
        private double armor;
        Weapon weapons[];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    @Override
    public String toString() {
        return name;
    }
}
