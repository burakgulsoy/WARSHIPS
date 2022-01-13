package ships;

import weapons.Artillery;
import weapons.TurretGuns;
import weapons.Weapon;

public class Frigate extends Ship{

    private String name = "Frigate";
    private double armor = 1200;
    private double health = 1000;
    TurretGuns turretGuns = new TurretGuns();
    Artillery artillery = new Artillery();
    Weapon weapons[] = {turretGuns,artillery};

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

    public TurretGuns getTurretGuns() {
        return turretGuns;
    }

    public void setTurretGuns(TurretGuns turretGuns) {
        this.turretGuns = turretGuns;
    }

    public Artillery getArtillery() {
        return artillery;
    }

    public void setArtillery(Artillery artillery) {
        this.artillery = artillery;
    }

    public String[] getActionMessage() {
        String actions[] = {"Use Turret Gun, (" + turretGuns.getNumber() + ") left","Use Artillery, (" + artillery.getNumber() + ") left"};
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
