package ships;

import weapons.ArmorPiercingShots;
import weapons.TurretGuns;
import weapons.Weapon;

public class Cruiser extends Ship{

    private String name = "Cruiser";
    private double armor = 1550;
    private double health = 900;
    ArmorPiercingShots armorPiercingShots = new ArmorPiercingShots();
    TurretGuns turretGuns = new TurretGuns();
    Weapon weapons[] = {armorPiercingShots,turretGuns};

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

    public ArmorPiercingShots getArmorPiercingShots() {
        return armorPiercingShots;
    }

    public void setArmorPiercingShots(ArmorPiercingShots armorPiercingShots) {
        this.armorPiercingShots = armorPiercingShots;
    }

    public TurretGuns getTurretGuns() {
        return turretGuns;
    }

    public void setTurretGuns(TurretGuns turretGuns) {
        this.turretGuns = turretGuns;
    }

    public String[] getActionMessage() {
        String actions[] = {"Use Turret Gun, (" + turretGuns.getNumber() + ") left", "Use Armor Piercing Shots, (" + armorPiercingShots.getNumber() + ") left"};
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
