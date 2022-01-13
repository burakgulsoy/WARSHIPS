import ships.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseWindow extends JFrame {

    JLabel lblFirstPlayerName, lblSecondPlayerName, lblFirstShipName, lblSecondShipName, lblFirstPlayer, lblSecondPlayer;
    JTextField txtFirstPlayerName, txtSecondPlayerName;

    Cruiser cruiser1 = new Cruiser();
    Cruiser cruiser2 = new Cruiser();
    Destroyer destroyer1 = new Destroyer();
    Destroyer destroyer2 = new Destroyer();
    Submarine submarine1 = new Submarine();
    Submarine submarine2 = new Submarine();
    Frigate frigate1 = new Frigate();
    Frigate frigate2 = new Frigate();
    ArmoredShip armoredShip1 = new ArmoredShip();
    ArmoredShip armoredShip2 = new ArmoredShip();

    Ship ships1[] = {cruiser1, destroyer1, submarine1, frigate1, armoredShip1};
    DefaultComboBoxModel<Ship> dcbmShip1 = new DefaultComboBoxModel<Ship>(ships1);
    JComboBox<Ship> cbShip1 = new JComboBox<Ship>(dcbmShip1);

    Ship ships2[] = {cruiser2, destroyer2, submarine2, frigate2, armoredShip2};
    DefaultComboBoxModel<Ship> dcbmShip2 = new DefaultComboBoxModel<Ship>(ships2);
    JComboBox<Ship> cbShip2 = new JComboBox<Ship>(dcbmShip2);

    JButton btnClear = new JButton("Clear");
    JButton btnStart = new JButton("Start");
    JButton btnSeeShips = new JButton("Ship information");
    JButton btnSeeGuns = new JButton("Gun information");

    JPanel pnlLeft = new JPanel(new BorderLayout());
    JPanel pnlRight = new JPanel(new BorderLayout());
    JPanel pnlInformation = new JPanel(new FlowLayout());

    JPanel pnlLeftCenter = new JPanel(new GridLayout(2, 2));
    JPanel pnlRightCenter = new JPanel(new GridLayout(2, 2));
    JPanel pnlRightButtons = new JPanel(new BorderLayout());
    JPanel pnlRightButtons2 = new JPanel(new FlowLayout());


    GameWindow gw = new GameWindow();
    ShipInformationPanel shipInformationPanel = new ShipInformationPanel();
    GunInformationPanel gunInformationPanel = new GunInformationPanel();

    public ChooseWindow() {
        super("Login Window");
        setLayout(new GridLayout(2, 2));
        setSize(450, 190);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDesign();
        setListeners();

    }

    public static void main(String[] args) {
        new ChooseWindow().setVisible(true);
    }

    void setDesign() {
        lblFirstPlayerName = new JLabel("Name: ");
        lblSecondPlayerName = new JLabel("Name: ");
        lblFirstShipName = new JLabel("Ship: ");
        lblSecondShipName = new JLabel("Ship: ");
        lblFirstPlayer = new JLabel("First Player");
        lblSecondPlayer = new JLabel("Second Player");

        txtFirstPlayerName = new JTextField();
        txtSecondPlayerName = new JTextField();

        pnlInformation.add(btnSeeShips);
        pnlInformation.add(btnSeeGuns);


        pnlLeft.add(lblFirstPlayer, BorderLayout.NORTH);
        pnlLeftCenter.add(lblFirstPlayerName);
        pnlLeftCenter.add(txtFirstPlayerName);
        pnlLeftCenter.add(lblFirstShipName);
        pnlLeftCenter.add(cbShip1);
        pnlLeft.add(pnlLeftCenter, BorderLayout.CENTER);

        pnlRight.add(lblSecondPlayer, BorderLayout.NORTH);
        pnlRightCenter.add(lblSecondPlayerName);
        pnlRightCenter.add(txtSecondPlayerName);
        pnlRightCenter.add(lblSecondShipName);
        pnlRightCenter.add(cbShip2);
        pnlRight.add(pnlRightCenter, BorderLayout.CENTER);

        pnlRightButtons2.add(btnClear);
        pnlRightButtons2.add(btnStart);
        pnlRightButtons.add(pnlRightButtons2, BorderLayout.SOUTH);

        add(pnlLeft);
        add(pnlRight);
        add(pnlInformation);
        add(pnlRightButtons);

        setResizable(false);
    }

    void setListeners() {
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtFirstPlayerName.setText("");
                txtSecondPlayerName.setText("");
                if (cbShip1.getSelectedItem() != null && cbShip2.getSelectedItem() != null) {
                    cbShip1.setSelectedIndex(0);
                    cbShip2.setSelectedIndex(0);
                }
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!((!txtFirstPlayerName.getText().equals("") && !txtSecondPlayerName.getText().equals("")) && (cbShip1.getSelectedIndex() != -1 && cbShip2.getSelectedIndex() != -1))) {
                    return;
                }
                setVisible(false);

                settings();
                gw.setVisible(true);
            }
        });

        btnSeeShips.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shipInformationPanel.setVisible(true);
            }
        });

        btnSeeGuns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gunInformationPanel.setVisible(true);
            }
        });

    }

    public void setNames() { // girilen oyuncu isimlerini ikinci ekranda düzenliyor
        String space = "";
        for (int i = 0; i < 18; i++) {
            space += "  ";
        }
        gw.setPlayerNames(txtFirstPlayerName.getText(), txtSecondPlayerName.getText());
        gw.setShipNames(space + cbShip1.getSelectedItem().toString(), space + cbShip2.getSelectedItem().toString());
    }

    public void setShips() {
        gw.setShips((Ship) cbShip1.getSelectedItem(), (Ship) cbShip2.getSelectedItem());
    }

    public void setWeapons() {

        switch (cbShip1.getSelectedItem().toString()) {
            case "Cruiser":
                cruiser1.getTurretGuns().setNumber(50);
                cruiser1.getArmorPiercingShots().setNumber(4);
                break;
            case "Destroyer":
                destroyer1.getTurretGuns().setNumber(50);
                destroyer1.getArmorPiercingShots().setNumber(2);
                break;
            case "Submarine":
                submarine1.getTorpedo().setNumber(20);
                break;
            case "Frigate":
                frigate1.getTurretGuns().setNumber(50);
                frigate1.getArtillery().setNumber(2);
                break;
            case "Armored Ship":
                armoredShip1.getTurretGun().setNumber(50);
                break;
        }

        switch (cbShip2.getSelectedItem().toString()) {
            case "Cruiser":
                cruiser2.getTurretGuns().setNumber(50);
                cruiser2.getArmorPiercingShots().setNumber(4);
                break;
            case "Destroyer":
                destroyer2.getTurretGuns().setNumber(50);
                destroyer2.getArmorPiercingShots().setNumber(2);
                break;
            case "Submarine":
                submarine2.getTorpedo().setNumber(20);
                break;
            case "Frigate":
                frigate2.getTurretGuns().setNumber(50);
                frigate2.getArtillery().setNumber(2);
                break;
            case "Armored Ship":
                armoredShip2.getTurretGun().setNumber(50);
                break;
        }


    }

    /*
    setActions() methodu için:
    GameWindow Action cb elemanları burada ekleniyor
    Health ve armor ilk olarak burada yazılıyor
    Gemi resimleri burada değişiyor
    multiplier ayarlaması
     */
    public void setActions() {

        switch (cbShip1.getSelectedItem().toString()) {
            case "Cruiser":
                for (int i = 0; i < cruiser1.getActionMessage().length; i++) {
                    gw.dcbmAction1.addElement(cruiser1.getActionMessage()[i]);
                    gw.lblHealthBar1.setText(cruiser1.getHealth() + " - " + cruiser1.getArmor());
                    gw.lblShipIcon1.setIcon(new ImageIcon("src/icons/Cruiser.png"));
                    gw.setCritical_multiplier1(8);
                    gw.setFailure_multiplier1(9);
                }

                break;
            case "Destroyer":
                for (int i = 0; i < destroyer1.getActionMessage().length; i++) {
                    gw.dcbmAction1.addElement(destroyer1.getActionMessage()[i]);
                    gw.lblHealthBar1.setText(destroyer1.getHealth() + " - " + destroyer1.getArmor());
                    gw.lblShipIcon1.setIcon(new ImageIcon("src/icons/Destroyer.png"));
                    gw.setCritical_multiplier1(6);
                    gw.setFailure_multiplier1(6);
                }
                break;
            case "Submarine":
                for (int i = 0; i < submarine1.getActionMessage().length; i++) {
                    gw.dcbmAction1.addElement(submarine1.getActionMessage()[i]);
                    gw.lblHealthBar1.setText(submarine1.getHealth() + " - " + submarine1.getArmor());
                    gw.lblShipIcon1.setIcon(new ImageIcon("src/icons/Submarine.png"));
                    gw.setCritical_multiplier1(10);
                    gw.setFailure_multiplier1(10);
                }
                break;
            case "Frigate":
                for (int i = 0; i < frigate1.getActionMessage().length; i++) {
                    gw.dcbmAction1.addElement(frigate1.getActionMessage()[i]);
                    gw.lblHealthBar1.setText(frigate1.getHealth() + " - " + frigate1.getArmor());
                    gw.lblShipIcon1.setIcon(new ImageIcon("src/icons/Frigate.png"));
                    gw.setCritical_multiplier1(7);
                    gw.setFailure_multiplier1(8);
                }
                break;
            case "Armored Ship":
                for (int i = 0; i < armoredShip1.getActionMessage().length; i++) {
                    gw.dcbmAction1.addElement(armoredShip1.getActionMessage()[i]);
                    gw.lblHealthBar1.setText(armoredShip1.getHealth() + " - " + armoredShip1.getArmor());
                    gw.lblShipIcon1.setIcon(new ImageIcon("src/icons/Armored Ship.png"));
                    gw.setCritical_multiplier1(5);
                    gw.setFailure_multiplier1(7);
                }
                break;
        }

        switch (cbShip2.getSelectedItem().toString()) {
            case "Cruiser":
                for (int i = 0; i < cruiser2.getActionMessage().length; i++) {
                    gw.dcbmAction2.addElement(cruiser2.getActionMessage()[i]);
                    gw.lblHealthBar2.setText(cruiser2.getHealth() + " - " + cruiser2.getArmor());
                    gw.lblShipIcon2.setIcon(new ImageIcon("src/icons/Cruiser.png"));
                    gw.setCritical_multiplier2(8);
                    gw.setFailure_multiplier2(9);

                }
                break;
            case "Destroyer":
                for (int i = 0; i < destroyer2.getActionMessage().length; i++) {
                    gw.dcbmAction2.addElement(destroyer2.getActionMessage()[i]);
                    gw.lblHealthBar2.setText(destroyer2.getHealth() + " - " + destroyer2.getArmor());
                    gw.lblShipIcon2.setIcon(new ImageIcon("src/icons/Destroyer.png"));
                    gw.setCritical_multiplier2(6);
                    gw.setFailure_multiplier2(6);

                }
                break;
            case "Submarine":
                for (int i = 0; i < submarine2.getActionMessage().length; i++) {
                    gw.dcbmAction2.addElement(submarine2.getActionMessage()[i]);
                    gw.lblHealthBar2.setText(submarine2.getHealth() + " - " + submarine2.getArmor());
                    gw.lblShipIcon2.setIcon(new ImageIcon("src/icons/Submarine.png"));
                    gw.setCritical_multiplier2(10);
                    gw.setFailure_multiplier2(10);


                }
                break;
            case "Frigate":
                for (int i = 0; i < frigate2.getActionMessage().length; i++) {
                    gw.dcbmAction2.addElement(frigate2.getActionMessage()[i]);
                    gw.lblHealthBar2.setText(frigate2.getHealth() + " - " + frigate2.getArmor());
                    gw.lblShipIcon2.setIcon(new ImageIcon("src/icons/Frigate.png"));
                    gw.setCritical_multiplier2(7);
                    gw.setFailure_multiplier2(8);

                }
                break;
            case "Armored Ship":
                for (int i = 0; i < armoredShip2.getActionMessage().length; i++) {
                    gw.dcbmAction2.addElement(armoredShip2.getActionMessage()[i]);
                    gw.lblHealthBar2.setText(armoredShip2.getHealth() + " - " + armoredShip2.getArmor());
                    gw.lblShipIcon2.setIcon(new ImageIcon("src/icons/Armored Ship.png"));
                    gw.setCritical_multiplier2(5);
                    gw.setFailure_multiplier2(7);
                }
                break;
        }

    }

    public void settings() {
        setNames();
        setShips();
        setWeapons();
        setActions();
    }


}
