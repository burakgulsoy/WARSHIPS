import ships.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameWindow extends JFrame {

    JLabel lblFirstPlayer, lblSecondPlayer, lblShipName1, lblShipName2, lblAction1, lblAction2, lblHealth1, lblHealth2, lblHealthBar1, lblHealthBar2, lblActionLog;


    JLabel lblShipIcon1 = new JLabel(new ImageIcon("src/icons/Armored Ship.png"));
    JLabel lblShipIcon2 = new JLabel(new ImageIcon("src/icons/Armored Ship.png"));

    JButton btnSubmit1, btnSubmit2;

    private double damage1 = 0;
    private double damage2 = 0;
    private int critical_multiplier1 = 1;
    private int critical_multiplier2 = 1;
    private int failure_multiplier1 = 1;
    private int failure_multiplier2 = 1;


    Ship ship1;
    Ship ship2;

    DefaultComboBoxModel dcbmAction1 = new DefaultComboBoxModel();
    JComboBox cbAction1 = new JComboBox(dcbmAction1);

    DefaultComboBoxModel<String> dcbmAction2 = new DefaultComboBoxModel<String>();
    JComboBox<String> cbAction2 = new JComboBox<String>(dcbmAction2);

    JTextArea txtAreaActionLog = new JTextArea();

    JPanel pnlAction1 = new JPanel(new FlowLayout());
    JPanel pnlAction2 = new JPanel(new FlowLayout());
    JPanel pnlSubmit1 = new JPanel(new FlowLayout());
    JPanel pnlSubmit2 = new JPanel(new FlowLayout());
    JPanel pnlHealth1 = new JPanel(new FlowLayout());
    JPanel pnlHealth2 = new JPanel(new FlowLayout());

    JPanel pnlNorth = new JPanel(new FlowLayout());
    JPanel pnlCenter = new JPanel(new GridLayout(5, 2));
    JPanel pnlSouth = new JPanel(new BorderLayout());


    public GameWindow() {
        super("Game Window");
        setLayout(new BorderLayout());
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDesign();
        setListeners();

    }

    void setDesign() {

        lblFirstPlayer = new JLabel("First Player");
        lblSecondPlayer = new JLabel("Second Player");

        lblShipName1 = new JLabel("Ship name");
        lblShipName2 = new JLabel("Ship name");
        lblAction1 = new JLabel("Action: ");
        lblAction2 = new JLabel("Action: ");
        lblHealth1 = new JLabel("Health and Armor: ");
        lblHealth2 = new JLabel("Health and Armor: ");
        lblHealthBar1 = new JLabel("100");
        lblHealthBar2 = new JLabel("100");
        lblActionLog = new JLabel("Action Log");

        btnSubmit1 = new JButton("Submit");
        btnSubmit2 = new JButton("Submit");

        pnlAction1.add(lblAction1);
        pnlAction1.add(cbAction1);
        pnlAction2.add(lblAction2);
        pnlAction2.add(cbAction2);

        pnlSubmit1.add(new JLabel(""));
        pnlSubmit1.add(btnSubmit1);
        pnlSubmit2.add(new JLabel(""));
        pnlSubmit2.add(btnSubmit2);

        pnlNorth.add(lblFirstPlayer);
        String a = "";
        for (int i = 0; i < 40; i++) {
            a += "  ";
        }
        pnlNorth.add(new JLabel(a));
        pnlNorth.add(lblSecondPlayer);
        add(pnlNorth, BorderLayout.NORTH);


        pnlCenter.add(lblShipIcon1);
        pnlCenter.add(lblShipIcon2);
        pnlCenter.add(lblShipName1);
        pnlCenter.add(lblShipName2);
        pnlCenter.add(pnlAction1);
        pnlCenter.add(pnlAction2);
        pnlCenter.add(pnlSubmit1);
        pnlCenter.add(pnlSubmit2);

        pnlHealth1.add(lblHealth1);
        pnlHealth1.add(lblHealthBar1);
        pnlCenter.add(pnlHealth1);

        pnlHealth2.add(lblHealth2);
        pnlHealth2.add(lblHealthBar2);
        pnlCenter.add(pnlHealth2);

        add(pnlCenter, BorderLayout.CENTER);

        pnlSouth.add(lblActionLog);
        pnlSouth.add(txtAreaActionLog);

        add(pnlSouth, BorderLayout.SOUTH);

        setResizable(false);

    }

    public void setCritical_multiplier1(int critical_multiplier1) {
        this.critical_multiplier1 = critical_multiplier1;
    }

    public void setCritical_multiplier2(int critical_multiplier2) {
        this.critical_multiplier2 = critical_multiplier2;
    }

    public void setFailure_multiplier1(int failure_multiplier1) {
        this.failure_multiplier1 = failure_multiplier1;
    }

    public void setFailure_multiplier2(int failure_multiplier2) {
        this.failure_multiplier2 = failure_multiplier2;
    }

    void setListeners() {
        btnSubmit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battle_1();

                if (ship2.getHealth() <= 0) {
                    JOptionPane.showMessageDialog(new Frame(), lblFirstPlayer.getText() + " Wins!");
                    System.exit(0);
                }
            }
        });

        btnSubmit2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battle_2();

                if (ship1.getHealth() <= 0) {
                    JOptionPane.showMessageDialog(new Frame(), lblSecondPlayer.getText() + " Wins!");
                    System.exit(0);
                }
            }
        });

        btnSubmit1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                for (int i = 0; i < ship1.getWeapons().length; i++) {
                    if (cbAction1.getSelectedItem().toString().contains(ship1.getWeapons()[i].toString())) {

                        if (ship1.getWeapons()[i].getNumber() == 0) {
                            btnSubmit1.setEnabled(false);
                        } else {
                            btnSubmit1.setEnabled(true);
                        }

                    }
                }

            }
        });

        btnSubmit2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                for (int i = 0; i < ship2.getWeapons().length; i++) {
                    if (cbAction2.getSelectedItem().toString().contains(ship2.getWeapons()[i].toString())) {

                        if (ship2.getWeapons()[i].getNumber() == 0) {
                            btnSubmit2.setEnabled(false);
                        } else {
                            btnSubmit2.setEnabled(true);
                        }
                    }
                }

            }
        });

        cbAction1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {

                for (int i = 0; i < ship1.getWeapons().length; i++) {
                    if (cbAction1.getSelectedItem().toString().contains(ship1.getWeapons()[i].toString())) {

                        if (ship1.getWeapons()[i].getNumber() == 0) {
                            btnSubmit1.setEnabled(false);
                        } else {
                            btnSubmit1.setEnabled(true);
                        }

                    }
                }
            }
        });

        cbAction2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {

                for (int i = 0; i < ship2.getWeapons().length; i++) {
                    if (cbAction2.getSelectedItem().toString().contains(ship2.getWeapons()[i].toString())) {

                        if (ship2.getWeapons()[i].getNumber() == 0) {
                            btnSubmit2.setEnabled(false);
                        } else {
                            btnSubmit2.setEnabled(true);
                        }

                    }
                }

            }
        });

        cbAction1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                for (int i = 0; i < ship1.getWeapons().length; i++) {
                    if (cbAction1.getSelectedItem().toString().contains(ship1.getWeapons()[i].toString())) {

                        dcbmAction1.setSelectedItem("Use " + ship1.getWeapons()[i].toString() + ", (" + ship1.getWeapons()[i].getNumber() + ") left");

                    }
                }


            }
        });

        cbAction2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                for (int i = 0; i < ship2.getWeapons().length; i++) {
                    if (cbAction2.getSelectedItem().toString().contains(ship2.getWeapons()[i].toString())) {

                        dcbmAction2.setSelectedItem("Use " + ship2.getWeapons()[i].toString() + ", (" + ship2.getWeapons()[i].getNumber() + ") left");

                    }
                }


            }
        });


    } // set listeners sonu

    public void setPlayerNames(String playerName_1, String playerName_2) {
        lblFirstPlayer.setText(playerName_1);
        lblSecondPlayer.setText(playerName_2);
    }

    public void setShipNames(String shipName_1, String shipName_2) {
        lblShipName1.setText(shipName_1);
        lblShipName2.setText(shipName_2);
    }

    public void setShips(Ship ship1, Ship ship2) {
        this.ship1 = ship1;
        this.ship2 = ship2;
    }


    public void battle_1() {
        boolean hit = criticalHit(critical_multiplier1);
        boolean failure = systemFailure(failure_multiplier1);

        for (int i = 0; i < ship1.getWeapons().length; i++) {
            if (cbAction1.getSelectedItem().toString().contains(ship1.getWeapons()[i].toString())) {

                if (ship2.getArmor() > 0) {  // kalkan bitmemişse önce kalkandan hasar alacak
                    damage1 = ship1.getWeapons()[i].getDamageArmor();
                } else {
                    damage1 = ship1.getWeapons()[i].getDamageHealth();
                }

                ship1.getWeapons()[i].setNumber(ship1.getWeapons()[i].getNumber() - 1); // vuruş yaptıkça kullanım hakkı azalacak
                dcbmAction1.setSelectedItem("Use " + ship1.getWeapons()[i].toString() + ", (" + ship1.getWeapons()[i].getNumber() + ") left");


            }
        }


        if (hit == true) {
            damage1 *= 1.5;
        }

        if (failure == true) {
            damage1 *= 0.7;
        }

        if (ship2.getArmor() > 0) { // kalkan 0'dan büyükse
            if (ship2.getArmor() - damage1 < 0) { // (kalkan - zarar) 0'dan küçükse
                double minus_health = ship2.getArmor() - damage1; // eksi olanı cana ekle, kalkanı sıfıra set et
                ship2.setHealth(ship2.getHealth() + minus_health);
                ship2.setArmor(0);
            } else { // kalkan - zarar 0'dan büyükse
                ship2.setArmor(ship2.getArmor() - damage1);
            }
        } else { // kalkan bitmişse
            ship2.setHealth(ship2.getHealth() - damage1);
        }

        if (ship2.getHealth() <= 0) {
            ship2.setHealth(0); // son vuruş canı eksiye götürmesin diye
        }

        if (hit == true) {
            if (failure == true) {
                txtAreaActionLog.setText("Critical hit with system failure! " + lblFirstPlayer.getText() + " dealed " + damage1 + " damage");
            } else {
                txtAreaActionLog.setText("Critical hit! " + lblFirstPlayer.getText() + " dealed " + damage1 + " damage");
            }
        } else {
            if (failure == true) {
                txtAreaActionLog.setText("System failure! " + lblFirstPlayer.getText() + " dealed " + damage1 + " damage");
            } else {
                txtAreaActionLog.setText(lblFirstPlayer.getText() + " dealed " + damage1 + " damage");
            }

        }
        lblHealthBar2.setText(ship2.getHealth() + " - " + ship2.getArmor());

    }

    public void battle_2() {
        boolean hit = criticalHit(critical_multiplier2);
        boolean failure = systemFailure(failure_multiplier2);

        for (int i = 0; i < ship2.getWeapons().length; i++) {
            if (cbAction2.getSelectedItem().toString().contains(ship2.getWeapons()[i].toString())) {

                if (ship1.getArmor() > 0) {  // kalkan bitmemişse önce kalkandan hasar alacak
                    damage2 = ship2.getWeapons()[i].getDamageArmor();
                } else {
                    damage2 = ship2.getWeapons()[i].getDamageHealth();
                }

                ship2.getWeapons()[i].setNumber(ship2.getWeapons()[i].getNumber() - 1); // vuruş yaptıkça kullanım hakkı azalacak
                dcbmAction2.setSelectedItem("Use " + ship2.getWeapons()[i].toString() + ", (" + ship2.getWeapons()[i].getNumber() + ") left");

            }
        }


        if (hit == true) {
            damage2 *= 1.5;
        }

        if (failure == true) {
            damage2 *= 0.7;
        }

        if (ship1.getArmor() > 0) { // kalkan 0'dan büyükse
            if (ship1.getArmor() - damage2 < 0) { // (kalkan - zarar) 0'dan küçükse
                double minus_health = ship1.getArmor() - damage2; // eksi olanı cana ekle, kalkanı sıfıra çek
                ship1.setHealth(ship1.getHealth() + minus_health);
                ship1.setArmor(0);
            } else { // kalkan - zarar 0'dan büyükse
                ship1.setArmor(ship1.getArmor() - damage2);
            }
        } else { // kalkan bitmişse
            ship1.setHealth(ship1.getHealth() - damage2);
        }

        if (ship1.getHealth() <= 0) { // son vuruş canı eksiye götürmesin diye
            ship1.setHealth(0);
        }

        if (hit == true) {
            if (failure == true) {
                txtAreaActionLog.setText("Critical hit with system failure! " + lblSecondPlayer.getText() + " dealed " + damage2 + " damage");
            } else {
                txtAreaActionLog.setText("Critical hit! " + lblSecondPlayer.getText() + " dealed " + damage2 + " damage");
            }
        } else {
            if (failure == true) {
                txtAreaActionLog.setText("System failure! " + lblSecondPlayer.getText() + " dealed " + damage2 + " damage");
            } else {
                txtAreaActionLog.setText(lblSecondPlayer.getText() + " dealed " + damage2 + " damage");
            }

        }

        lblHealthBar1.setText(ship1.getHealth() + " - " + ship1.getArmor());

    }

    boolean criticalHit(int multiplier) {
        Random r = new Random();
        int critical = r.nextInt(multiplier);
        boolean hit = true;

        if (critical != 0) {
            hit = false;
        }

        return hit;
        /*
        her gemi çeşidi için farklı bir multiplier var, [0,multiplier) olacağı için 0 her zaman boolean belirlemede kullanılabilir

        armored ship = 1/5
        destroyer = 1/6
        frigate = 1/7
        cruiser = 1/8
        submarine = 1/10
         */
    }

    boolean systemFailure(int failure_multiplier) {
        Random r = new Random();
        int fail = r.nextInt(failure_multiplier);
        boolean failure = true;

        if (fail != 0) {
            failure = false;
        }

        return failure;

        /*
        armored ship = 1/7
        destroyer = 1/6
        frigate = 1/8
        cruiser = 1/9
        submarine = 1/10
         */
    }


}









