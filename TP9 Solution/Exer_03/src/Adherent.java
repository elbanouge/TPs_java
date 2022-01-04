import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Adherent {
    private JTextField txtnom;
    private JTextField txtprenom;
    private JFormattedTextField txttel;
    private JFormattedTextField txtlogin;
    private JPasswordField txtpass;
    private JRadioButton femmeRadioButton;
    private JButton ajouterEnregistrementButton;
    private JCheckBox tennisCheckBox;
    private JFormattedTextField txtDate;
    private JPanel Main;
    private JTextField txtpayer;
    private JTextArea txtadrs;
    private JRadioButton hommeRadioButton;
    private JButton ajouterUneTableButton;
    private JButton modifierButton;
    private JButton supprimerButton;
    private JButton affichierTableButton;
    private JButton afficherTabAvecPreButton;
    private JButton fermerButton;
    private JCheckBox squashCheckBox;
    private JCheckBox natationCheckBox;
    private JCheckBox athlethismeCheckBox;
    private JCheckBox randomméCheckBox;
    private JCheckBox footCheckBox;
    private JCheckBox baskeetCheckBox;
    private JCheckBox volleyCheckBox;
    private JCheckBox pelanqueCheckBox;
    private JButton rechercherButton;
    private JTextField txtrech;
    private JButton ajouterButton;
    private Afficher afficher;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Adherent");
        frame.setContentPane(new Adherent().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    Connection con;
    PreparedStatement pst;
    Statement stmt;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3310/bibliotheque", "root", "");
            System.out.println("Success");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private SimpleDateFormat dateFormat;
    private MaskFormatter formatterTel;


    private String nom, prenom, tel, login, pass, adrs;
    private String date;
    private double montant;
    private byte sexe = 0;
    private String sport = "";
    private String rch;

    public Adherent() {
        Connect();

        // Ajouter event
        ajouterEnregistrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nom = txtnom.getText();
                prenom = txtprenom.getText();
                date = txtDate.getText();
                tel = txttel.getText();
                login = txtlogin.getText();
                pass = txtpass.getText();
                montant = Double.parseDouble(txtpayer.getText());
                adrs = txtadrs.getText();

                if (hommeRadioButton.isSelected()) {
                    sexe = 1;
                } else if (femmeRadioButton.isSelected()) {
                    sexe = 0;
                }

                if (tennisCheckBox.isSelected()) {
                    sport += tennisCheckBox.getText() + ";";
                }
                if (squashCheckBox.isSelected()) {
                    sport += squashCheckBox.getText() + ";";
                }
                if (natationCheckBox.isSelected()) {
                    sport += natationCheckBox.getText() + ";";
                }
                if (athlethismeCheckBox.isSelected()) {
                    sport += athlethismeCheckBox.getText() + ";";
                }
                if (randomméCheckBox.isSelected()) {
                    sport += randomméCheckBox.getText() + ";";
                }
                if (footCheckBox.isSelected()) {
                    sport += footCheckBox.getText() + ";";
                }
                if (baskeetCheckBox.isSelected()) {
                    sport += baskeetCheckBox.getText() + ";";
                }
                if (volleyCheckBox.isSelected()) {
                    sport += volleyCheckBox.getText() + ";";
                }
                if (pelanqueCheckBox.isSelected()) {
                    sport += pelanqueCheckBox.getText() + ";";
                }


                try {
                    pst = con.prepareStatement("insert into adherents(Nom,Prenom,DateInscrp,Tel,Login,MotPass,Montant,Adresse,Sexe,TypesB)values(?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, nom);
                    pst.setString(2, prenom);
                    pst.setString(3, date);
                    pst.setString(4, tel);
                    pst.setString(5, login);
                    pst.setString(6, pass);
                    pst.setDouble(7, montant);
                    pst.setString(8, adrs);
                    pst.setByte(9, sexe);
                    pst.setString(10, sport);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Ajouter adhrent avec succes");

                    txtnom.requestFocus();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Fermer event
        fermerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(fermerButton, "Vous avez vraiment quiter ce programme !!! ", "Attention", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        ajouterUneTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creating the Statement
                try {
                    stmt = con.createStatement();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                //Query to create a table
                String query = "CREATE TABLE CUSTOMERS("
                        + "ID INT NOT NULL, "
                        + "NAME VARCHAR (20) NOT NULL, "
                        + "AGE INT NOT NULL, "
                        + "SALARY DECIMAL (18, 2), "
                        + "ADDRESS CHAR (25) , "
                        + "PRIMARY KEY (ID))";
                try {
                    stmt.execute(query);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Table creer avec succes");
            }
        });
        rechercherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    rch = txtrech.getText();
                    pst = con.prepareStatement("select * from adherents where IdAdhr = ?");
                    pst.setString(1, rch);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next() == true) {
                        String nom = rs.getString(2);
                        String prenom = rs.getString(3);
                        String date = rs.getString(4);
                        String tel = rs.getString(5);
                        String login = rs.getString(6);
                        String pass = rs.getString(7);
                        String montant = rs.getString(8);
                        String adrs = rs.getString(9);
                        Byte sexe = rs.getByte(10);
                        String types = rs.getString(11);

                        txtnom.setText(nom);
                        txtprenom.setText(prenom);
                        txtDate.setText(date);
                        txttel.setText(tel);
                        txtlogin.setText(login);
                        txtpass.setText(pass);
                        txtpayer.setText(montant);
                        txtadrs.setText(adrs);

                        if (sexe == 1) {
                            hommeRadioButton.setSelected(true);
                        } else {
                            femmeRadioButton.setSelected(true);
                        }

                        String[] typS = types.split(";");

                        JOptionPane.showMessageDialog(null, types);

                        for (int i = 0; i < typS.length; i++) {

                            if (typS[i].equals("Tennis")) {
                                tennisCheckBox.setSelected(true);
                            }
                            if (typS[i].equals("Squash")) {
                                squashCheckBox.setSelected(true);
                            }
                            if (typS[i].equals("Natation")) {
                                natationCheckBox.setSelected(true);
                            }
                            if (typS[i].equals("Athlethisme")) {
                                athlethismeCheckBox.setSelected(true);
                            }
                            if (typS[i].equals("Randommé")) {
                                randomméCheckBox.setSelected(true);
                            }
                            if (typS[i].equals("Foot")) {
                                footCheckBox.setSelected(true);
                            }
                            if (typS[i].equals("Baskeet")) {
                                baskeetCheckBox.setSelected(true);
                            }
                            if (typS[i].equals("Volley")) {
                                volleyCheckBox.setSelected(true);
                            }
                            if (typS[i].equals("Pelanque")) {
                                pelanqueCheckBox.setSelected(true);
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "L'adehrent recherche n'existe pas");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rch = txtrech.getText();

                nom = txtnom.getText();
                prenom = txtprenom.getText();
                date = txtDate.getText();
                tel = txttel.getText();
                login = txtlogin.getText();
                pass = txtpass.getText();
                montant = Double.parseDouble(txtpayer.getText());
                adrs = txtadrs.getText();

                if (hommeRadioButton.isSelected()) {
                    sexe = 1;
                } else if (femmeRadioButton.isSelected()) {
                    sexe = 0;
                }

                if (tennisCheckBox.isSelected()) {
                    sport += tennisCheckBox.getText() + ";";
                }
                if (squashCheckBox.isSelected()) {
                    sport += squashCheckBox.getText() + ";";
                }
                if (natationCheckBox.isSelected()) {
                    sport += natationCheckBox.getText() + ";";
                }
                if (athlethismeCheckBox.isSelected()) {
                    sport += athlethismeCheckBox.getText() + ";";
                }
                if (randomméCheckBox.isSelected()) {
                    sport += randomméCheckBox.getText() + ";";
                }
                if (footCheckBox.isSelected()) {
                    sport += footCheckBox.getText() + ";";
                }
                if (baskeetCheckBox.isSelected()) {
                    sport += baskeetCheckBox.getText() + ";";
                }
                if (volleyCheckBox.isSelected()) {
                    sport += volleyCheckBox.getText() + ";";
                }
                if (pelanqueCheckBox.isSelected()) {
                    sport += pelanqueCheckBox.getText() + ";";
                }

                try {

                    pst = con.prepareStatement("update adherents set Nom = ?,Prenom = ?,DateInscrp = ?,Tel = ?,Login = ?,MotPass = ?,Montant = ?,Adresse = ?,Sexe = ?,TypesB = ? where IdAdhr = ?");
                    pst.setString(1, nom);
                    pst.setString(2, prenom);
                    pst.setString(3, date);
                    pst.setString(4, tel);
                    pst.setString(5, login);
                    pst.setString(6, pass);
                    pst.setDouble(7, montant);
                    pst.setString(8, adrs);
                    pst.setByte(9, sexe);
                    pst.setString(10, sport);
                    pst.setString(11, rch);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "L'Adherent modifier avec sucees.");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                rch = txtrech.getText();

                try {
                    pst = con.prepareStatement("delete from adherents  where IdAdhr = ?");
                    pst.setString(1, rch);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Adherent suprimé avec succes.");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        affichierTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    afficher.getPanel1().setVisible(true);
                    Main.setVisible(false);
                } catch (Exception ex) {
                    System.out.println("Erreur: " + ex);
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        txtDate = new JFormattedTextField(dateFormat);
        txtDate.setValue(new Date());

        try {
            formatterTel = new MaskFormatter("0#.##.##.##.##");
            txttel = new JFormattedTextField(formatterTel);
            txttel.setValue("06.15.76.57.67");

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
