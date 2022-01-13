package ships;

import weapons.TurretGuns;
import weapons.Weapon;

public class ArmoredShip extends Ship{

    private String name = "Armored Ship";
    private double armor = 1800;
    private double health = 1150;
    TurretGuns turretGun = new TurretGuns();
    Weapon weapons[] = {turretGun};



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

    public TurretGuns getTurretGun() {
        return turretGun;
    }

    public void setTurretGun(TurretGuns turretGun) {
        this.turretGun = turretGun;
    }

    public String[] getActionMessage() {
        String actions[] = {"Use Turret Gun, (" + turretGun.getNumber() + ") left"};
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


