import ships.*;
import weapons.ArmorPiercingShots;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ShipInformationPanel extends JFrame {

    JTextArea txtAreaArmoredShip = new JTextArea();
    JTextArea txtAreaCruiser = new JTextArea();
    JTextArea txtAreaDestroyer = new JTextArea();
    JTextArea txtAreaFrigate = new JTextArea();
    JTextArea txtAreaSubmarine = new JTextArea();
    JTextArea txtAreaEmpty = new JTextArea();

    JTextArea txtAreaShips[] = {txtAreaArmoredShip, txtAreaCruiser, txtAreaDestroyer, txtAreaFrigate, txtAreaSubmarine};

    ArmoredShip armoredShip = new ArmoredShip();
    Cruiser cruiser = new Cruiser();
    Destroyer destroyer = new Destroyer();
    Frigate frigate = new Frigate();
    Submarine submarine = new Submarine();


    Ship ships[] = {armoredShip, cruiser, destroyer, frigate, submarine};

    public ShipInformationPanel() {
        setLayout(new GridLayout(2, 3));
        setSize(700, 500);
        setDesign();
    }

    void setDesign() {
        //add(new JLabel(new ImageIcon("src/icons/Ships.png")));
        add(txtAreaEmpty);
        txtAreaEmpty.setEditable(false);

        for (int i = 0; i < txtAreaShips.length; i++) {
            add(txtAreaShips[i]);
            txtAreaShips[i].setEditable(false);
        }

        for (int i = 0; i < txtAreaShips.length; i++) {
            txtAreaShips[i].setText(ships[i].getName() + "\n\n"
                            + "Health and Armor: " + ships[i].getHealth() + " - " + ships[i].getArmor() + "\n"
                            + criticalRate(ships[i]) + "\n"
                            + failureRate(ships[i]) + "\n\n"
                            + "Guns" + "\n"
                            + gunInformation(ships[i])
                    // add advantage disadvantage
            );

        }

        setResizable(false);

    }

    String criticalRate(Ship ship) {

        String critical = "";

        for (int i = 0; i < txtAreaShips.length; i++) {
            if (ship instanceof ArmoredShip) {
                critical = "Critical hit chance: 1/5, rank (1)";
            } else if (ship instanceof Cruiser) {
                critical = "Critical hit chance: 1/8, rank (4)";
            } else if (ship instanceof Destroyer) {
                critical = "Critical hit chance: 1/6, rank (2)";
            } else if (ship instanceof Frigate) {
                critical = "Critical hit chance: 1/7, rank (3)";
            } else { //Submarine
                critical = "Critical hit chance: 1/10, rank (5)";
            }

        }

        return critical;
    }

    String failureRate(Ship ship) {

        String failure = "";

        for (int i = 0; i < txtAreaShips.length; i++) {
            if (ship instanceof ArmoredShip) {
                failure = "System failure chance: 1/7, rank (2)";
            } else if (ship instanceof Cruiser) {
                failure = "System failure chance: 1/9, rank (4)";
            } else if (ship instanceof Destroyer) {
                failure = "System failure chance: 1/6, rank (1)";
            } else if (ship instanceof Frigate) {
                failure = "System failure chance: 1/8, rank (3)";
            } else { //Submarine
                failure = "System failure chance: 1/10, rank (5)";
            }

        }

        return failure;
    }

    String gunInformation(Ship ship) {
/*
elle yazmadan veriyi çekmenin yolunu bul
silah sayısı choosewindow bölümünde belirlendiği için şimdilik silah sayısını dinamik çekemiyorum
silah isimleri konusunda yaşanılan problem, nedense aynısını 5 kere yapıyor. += operatörünü tekrar kontrol et.
 */
        String gunInfo = "";

        if (ship instanceof ArmoredShip) {
            gunInfo += "Turret Gun (50)";
        } else if (ship instanceof Cruiser) {
            gunInfo += "Turret Gun (50)" + "\n" + "Armor Piercing shots (4)";
        } else if (ship instanceof Destroyer) {
            gunInfo += "Turret Gun (50)" + "\n" + "Armor Piercing shots (2)";
        } else if (ship instanceof Frigate) {
            gunInfo += "Turret Gun (50)" + "\n" + "Artillery (2)";
        } else { //Submarine
            gunInfo += "Torpedo (20)";
        }


        return gunInfo;
    }


}
