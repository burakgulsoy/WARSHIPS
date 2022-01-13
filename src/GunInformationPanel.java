import weapons.*;

import javax.swing.*;
import java.awt.*;

public class GunInformationPanel extends JFrame {

    JTextArea txtAreaArmorPiercingShots = new JTextArea();
    JTextArea txtAreaArtillery = new JTextArea();
    JTextArea txtAreaTorpedo = new JTextArea();
    JTextArea txtAreaTurretGun = new JTextArea();

    JTextArea txtAreaGuns[] = {txtAreaArmorPiercingShots, txtAreaArtillery, txtAreaTorpedo, txtAreaTurretGun};

    ArmorPiercingShots armorPiercingShots = new ArmorPiercingShots();
    Artillery artillery = new Artillery();
    Torpedo torpedo = new Torpedo();
    TurretGuns turretGuns = new TurretGuns();

    Weapon weapons[] = {armorPiercingShots, artillery, torpedo, turretGuns};


    public GunInformationPanel() {
        setLayout(new FlowLayout());
        setSize(275, 200);
        setDesign();
    }

    void setDesign() {

        for (int i = 0; i < txtAreaGuns.length; i++) {
            add(txtAreaGuns[i]);
            txtAreaGuns[i].setEditable(false);
        }

        for (int i = 0; i < txtAreaGuns.length; i++) {
            txtAreaGuns[i].setText(weapons[i].toString() + "\n\n"
            + "Health Damage: " + weapons[i].getDamageHealth() + "\n"
            + "Armor Damage: " + weapons[i].getDamageArmor());
        }

        setResizable(false);

    }



}
