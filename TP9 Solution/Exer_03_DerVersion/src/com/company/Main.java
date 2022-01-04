package com.company;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends JFrame implements ActionListener {

    private JPanel pan1 = new JPanel();
    private JPanel pan2 = new JPanel();
    private JPanel pan3 = new JPanel();
    private JPanel pan4 = new JPanel();
    private JPanel pan5 = new JPanel();
    private JPanel pan6 = new JPanel();
    private JPanel pan7 = new JPanel();

    public JLabel label;
    public JTextField txtFNom = new JTextField(20);
    public JTextField txtFPrenom = new JTextField(20);
    public JTextField txtFLogin = new JTextField(20);
    public JFormattedTextField textFieldDate;
    public SimpleDateFormat dateFormat = new SimpleDateFormat("YYY-MM-dd");
    public JFormattedTextField textFieldTel;
    public MaskFormatter formatterTel = null;
    public JPasswordField passwordField;
    public JFormattedTextField textFieldPrix;
    public JTextArea areaAdresse;
    public JScrollPane scrollPane;

    public JCheckBox foot = new JCheckBox("Foot");
    public JCheckBox basket = new JCheckBox("Basket");
    public JCheckBox tennis = new JCheckBox("Tennis");
    public JCheckBox squash = new JCheckBox("Squash");
    public JCheckBox natation = new JCheckBox("Natation");
    public JCheckBox athletisme = new JCheckBox("Athlétisme");
    public JCheckBox randonnee = new JCheckBox("Randonnée");
    public JCheckBox volley = new JCheckBox("Volley");
    public JCheckBox pelanque = new JCheckBox("Pelanque");

    public JRadioButton homme = new JRadioButton("Homme");
    public JRadioButton femme = new JRadioButton("Femme");
    public ButtonGroup groupe = new ButtonGroup();

    public JButton ajouter = new JButton("Ajouter enregistrement");
    public JButton ajouter_table = new JButton("Ajouter une table");
    public JButton recherche = new JButton("Rechercher");
    public JButton modifier = new JButton("Modifier");
    public JButton supprimer = new JButton("Supprimer");
    public JButton afficher = new JButton("Afficher table");
    public JButton afficherPreSta = new JButton("Afficher table avec Pre Sta");
    public JButton fermer = new JButton("Fermer");

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Menu");

    private JMenuItem menuItem1 = new JMenuItem("Ajouter");
    private JMenuItem menuItem2 = new JMenuItem("Modifier");
    private JMenuItem menuItem3 = new JMenuItem("Supprimer");
    private JMenuItem menuItem4 = new JMenuItem("Afficher");
    private JMenuItem menuItem5 = new JMenuItem("Quitter");

    private static Connection con;
    private static Statement st;
    private static ResultSet rs;

    public void setFNom(String nom) {
        txtFNom.setText(nom);
    }

    public void setTxtFPrenom(String nom) {
        txtFPrenom.setText(nom);
    }

    public void setLogin(String l) {
        txtFLogin.setText(l);
    }


    public Main() throws HeadlessException {
        setTitle("Gestion d'une bases de donnnées");
        setSize(1000, 500);

        pan1.setLayout(new BorderLayout());
        pan1.add(pan6, BorderLayout.SOUTH); // ajouter pan6 au sud de pan1
        pan1.add(pan2);
        pan1.add(pan4, BorderLayout.EAST);
        this.add(pan1);
        pan2.setLayout(new BorderLayout());
        pan2.add(pan3, BorderLayout.NORTH);
        pan2.add(pan7, BorderLayout.CENTER);
        pan2.add(pan5, BorderLayout.SOUTH); // ajouter pan5 au sud de pan2

        pan3.setLayout(new GridLayout(14, 1));

        //MENU
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);
        menu.add(menuItem5);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        menuItem5.addActionListener(this);

        label = new JLabel("Nom : ");
        pan3.add(label);
        pan3.add(txtFNom);

        label = new JLabel("Prenom : ");
        pan3.add(label);
        pan3.add(txtFPrenom);

        label = new JLabel("Date d'inscription : ");
        pan3.add(label);
        textFieldDate = new JFormattedTextField(dateFormat);
        textFieldDate.setValue(new Date());
        pan3.add(textFieldDate);

        label = new JLabel("Téléphone : ");
        pan3.add(label);

        try {
            formatterTel = new MaskFormatter("0#.##.##.##.##");
            textFieldTel = new JFormattedTextField(formatterTel);
            textFieldTel.setValue("06.15.76.57.67");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        pan3.add(textFieldTel);

        label = new JLabel("Login : ");
        pan3.add(label);
        pan3.add(txtFLogin);

        label = new JLabel("Mode de passe : ");
        pan3.add(label);
        passwordField = new JPasswordField();
        pan3.add(passwordField);

        label = new JLabel("Montant a payer : ");
        pan3.add(label);
        textFieldPrix = new JFormattedTextField(new DecimalFormat("#,##.00 DH"));
        textFieldPrix.setValue(24.56);
        pan3.add(textFieldPrix);

        pan7.setLayout(new GridLayout(2, 1));
        pan7.add(new JLabel("Adresse : "));
        areaAdresse = new JTextArea(10, 0);
        scrollPane = new JScrollPane(areaAdresse);
        pan7.add(scrollPane);

        pan4.setLayout(new GridLayout(9, 1));
        pan4.add(tennis);
        pan4.add(squash);
        pan4.add(natation);
        pan4.add(athletisme);
        pan4.add(randonnee);
        pan4.add(foot);
        pan4.add(basket);
        pan4.add(volley);
        pan4.add(pelanque);

        pan5.setLayout(new FlowLayout());
        pan5.add(new JLabel("Sexe"));
        pan5.add(homme);
        pan5.add(femme);
        homme.setSelected(true);
        homme.setMnemonic('H');
        femme.setMnemonic('F');
        groupe.add(homme);
        groupe.add(femme);

        pan6.setLayout(new FlowLayout());
        pan6.add(ajouter);
        pan6.add(ajouter_table);
        pan6.add(recherche);
        pan6.add(modifier);
        pan6.add(supprimer);
        pan6.add(afficher);
        pan6.add(afficherPreSta);
        pan6.add(fermer);


        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        ajouter.addActionListener(this);
        ajouter_table.addActionListener(this);
        recherche.addActionListener(this);
        modifier.addActionListener(this);
        supprimer.addActionListener(this);
        afficher.addActionListener(this);
        afficherPreSta.addActionListener(this);

        // fermeture avec confirmation
        fermer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                sortieAvecConf();
            }
        });
    }

    public static void TestConnetion() {
        // connexion à la base de données “base” qui contient la table Adherent
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque", "root", "admin");
            st = con.createStatement();
            System.out.println("accès avec succès");
        } catch (Exception ex) {
            System.out.println("Erreur: " + ex);
        }
        // fin de a connexion à la base de données
    }

    public void sortieAvecConf() {
        if (JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment quitter ce programme?", "Attention!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }

    public static void main(String[] args) {
        TestConnetion();
        new Main();
    }

    private byte sexe = 0;

    public void Rechercher(String rch, String champ) {
        try {
            String sport = "";

            PreparedStatement pst = con.prepareStatement("select * from adherents where " + champ + " = ?");
            pst.setString(1, rch);
            ResultSet rs = pst.executeQuery();

            if (rs.next() == true) {
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String date = rs.getString(4);
                String tel = rs.getString(5);
                String login = rs.getString(6);
                String pass = rs.getString(7);
                Double montant = rs.getDouble(8);
                String adrs = rs.getString(9);
                Byte sexe = rs.getByte(10);
                String types = rs.getString(11);

                txtFNom.setText(nom);
                txtFPrenom.setText(prenom);
                textFieldDate.setText(date);
                textFieldTel.setText(tel);
                txtFLogin.setText(login);
                passwordField.setText(pass);
                textFieldPrix.setValue(montant);
                areaAdresse.setText(adrs);

                if (sexe == 1) {
                    homme.setSelected(true);
                } else {
                    femme.setSelected(true);
                }

                String[] typS = types.split(";");

                for (int i = 0; i < typS.length; i++) {

                    if (typS[i].equals("Tennis")) {
                        tennis.setSelected(true);
                    }
                    if (typS[i].equals("Squash")) {
                        squash.setSelected(true);
                    }
                    if (typS[i].equals("Natation")) {
                        natation.setSelected(true);
                    }
                    if (typS[i].equals("Athlétisme")) {
                        athletisme.setSelected(true);
                    }
                    if (typS[i].equals("Randonnée")) {
                        randonnee.setSelected(true);
                    }
                    if (typS[i].equals("Foot")) {
                        foot.setSelected(true);
                    }
                    if (typS[i].equals("Basket")) {
                        basket.setSelected(true);
                    }
                    if (typS[i].equals("Volley")) {
                        volley.setSelected(true);
                    }
                    if (typS[i].equals("Pelanque")) {
                        pelanque.setSelected(true);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "L'adehrent recherche n'existe pas", "Attention", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == ajouter || source == menuItem1) {
            try {
                String sport = "";

                st = con.createStatement();
                String requete = "insert into adherents(Nom,Prenom,DateInscrp,Tel,Login,MotPass,Montant,Adresse,Sexe,TypesB)values(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(requete);
                ps.setString(1, txtFNom.getText());
                ps.setString(2, txtFPrenom.getText());
                ps.setString(3, textFieldDate.getText());
                ps.setString(4, textFieldTel.getText());
                ps.setString(5, txtFLogin.getText());
                ps.setString(6, passwordField.getText());

                String[] prix = textFieldPrix.getText().split(" ");
                String[] pr = prix[0].split(",");
                ps.setDouble(7, Double.parseDouble(pr[0] + "." + pr[1]));
                ps.setString(8, areaAdresse.getText());

                if (homme.isSelected()) sexe = 1;
                ps.setByte(9, sexe);

                if (foot.isSelected()) sport += foot.getText() + ";";
                if (basket.isSelected()) sport += basket.getText() + ";";
                if (tennis.isSelected()) sport += tennis.getText() + ";";
                if (squash.isSelected()) sport += squash.getText() + ";";
                if (natation.isSelected()) sport += natation.getText() + ";";
                if (athletisme.isSelected()) sport += athletisme.getText() + ";";
                if (randonnee.isSelected()) sport += randonnee.getText() + ";";
                if (volley.isSelected()) sport += volley.getText() + ";";
                if (pelanque.isSelected()) sport += pelanque.getText() + ";";
                ps.setString(10, sport);

                int nb = ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ajouter adherent avec succes", "Succes", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }
        if (source == ajouter_table) {
            try {
                Statement st = con.createStatement();
                String requete = "CREATE TABLE Personne(id int not null auto_increment, prenom VARCHAR(15), nom varchar(15), age INT, primary key(id))";
                st.executeUpdate(requete);
                JOptionPane.showMessageDialog(null, "Table créer avec succes", "Succes", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }

        if (source == recherche) {
            String rch = txtFLogin.getText();
            Rechercher(rch, "Login");
        }

        if (source == afficherPreSta) {
            String rch = txtFNom.getText();
            Rechercher(rch, "Nom");
        }

        if (source == modifier || source == menuItem2) {
            try {
                String sport = "";

                String log = txtFLogin.getText();
                String requete = "update adherents set Nom = ?,Prenom = ?,DateInscrp = ?,Tel = ?,MotPass = ?,Montant = ?,Adresse = ?,Sexe = ?,TypesB = ? where Login = '" + log + "' ";
                PreparedStatement ps = con.prepareStatement(requete);
                ps.setString(1, txtFNom.getText());
                ps.setString(2, txtFPrenom.getText());
                ps.setString(3, textFieldDate.getText());
                ps.setString(4, textFieldTel.getText());
                ps.setString(5, passwordField.getText());

                String[] prix = textFieldPrix.getText().split(" ");
                String[] pr = prix[0].split(",");
                ps.setDouble(6, Double.parseDouble(pr[0] + "." + pr[1]));
                ps.setString(7, areaAdresse.getText());

                if (homme.isSelected()) sexe = 1;
                ps.setByte(8, sexe);

                if (foot.isSelected()) sport += foot.getText() + ";";
                if (basket.isSelected()) sport += basket.getText() + ";";
                if (tennis.isSelected()) sport += tennis.getText() + ";";
                if (squash.isSelected()) sport += squash.getText() + ";";
                if (natation.isSelected()) sport += natation.getText() + ";";
                if (athletisme.isSelected()) sport += athletisme.getText() + ";";
                if (randonnee.isSelected()) sport += randonnee.getText() + ";";
                if (volley.isSelected()) sport += volley.getText() + ";";
                if (pelanque.isSelected()) sport += pelanque.getText() + ";";
                ps.setString(9, sport);

                int nb = ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Modifier adherent avec succes", "Succes", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }
        if (source == supprimer || source == menuItem3) {
            try {
                String log = txtFLogin.getText();


                String requete = "delete from adherents WHERE Login ='" + log + "'";
                int n = st.executeUpdate(requete);
                if (n == 1) {
                    JOptionPane.showMessageDialog(null, "Suprimer adherent avec succes", "Succes", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Le champ login est vide", "Attention", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }

        if (source == afficher || source == menuItem4) {
            try {
                ListeAdherents tab = new ListeAdherents();
                tab.setVisible(true);
                setVisible(false);
            } catch (Exception ex) {
                System.out.println("Erreur: " + ex);
            }
        }

        if(source == menuItem5){
            sortieAvecConf();
        }
    }
}
