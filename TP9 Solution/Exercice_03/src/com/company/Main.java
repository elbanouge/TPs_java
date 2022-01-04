package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends JFrame implements ActionListener {

    private JPanel pan1 = new JPanel();
    private JPanel pan2 = new JPanel();
    private JPanel pan3 = new JPanel();
    private JPanel pan4 = new JPanel();
    private JPanel pan5 = new JPanel();
    private JPanel pan6 = new JPanel();
    public JTextField FNom = new JTextField("", 20);
    public JFormattedTextField dateChooser;
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
    JButton ajouter = new JButton("Ajouter enregi");
    JButton fermer = new JButton("Fermer");
    JButton modifier = new JButton("Modifier");
    JButton supprimer = new JButton("Supprimer");
    JButton afficher = new JButton("Afficher tab");
    JButton ajouter_table = new JButton("Ajouter une table");
    JButton reset = new JButton("Vider");
    String[] list = {"Fonctionnaire", "Salarié", "Fonction libérale", "Sans emploi"};
    public JComboBox CBox = new JComboBox(list);
    public JTextField login = new JTextField("", 20);
    public static JLabel lbl_img = new JLabel();
    public JButton BchImg = new JButton("Choisir une photo");
    public byte[] imag_adherent = null;
    public static String FichNom = null;
    private static Connection con;
    private static Statement st;
    private static ResultSet rs;

    public void setFNom(String nom) {
        FNom.setText(nom);
    }

    public void setDate(JFormattedTextField date) {
        dateChooser.setValue(date);
    }

    public void setLogin(String l) {
        login.setText(l);
    }

    public void setCBoxm(String cbox) {
        CBox.setSelectedItem(cbox);
    }

    public static JLabel getLbl() {
        return lbl_img;
    }

    public static String getFichNom() {
        return FichNom;
    }

    public Main() throws HeadlessException {
        setTitle("Gestion des adhérents");
        setSize(850, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pan1.setLayout(new BorderLayout());
        pan1.add(pan6, BorderLayout.SOUTH); // ajouter pan6 au sud de pan1
        pan1.add(pan2);
        pan1.add(pan4, BorderLayout.EAST);
        this.add(pan1);
        pan2.setLayout(new BorderLayout());
        pan2.add(pan3, BorderLayout.NORTH);
        JPanel pan7 = new JPanel();
        pan7.add(lbl_img);
        pan7.add(BchImg);
        pan2.add(pan7, BorderLayout.CENTER);
        pan2.add(pan5, BorderLayout.SOUTH); // ajouter pan5 au sud de pan2

        pan3.setLayout(new GridLayout(8, 1));
        pan3.add(new JLabel("Nom"));
        pan3.add(FNom);
        pan3.add(new JLabel("Date d'inscription"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dateChooser = new JFormattedTextField(sdf);
        dateChooser.setValue(new Date());
        pan3.add(dateChooser);
        pan3.add(new JLabel("Login"));
        pan3.add(login);
        pan3.add(new JLabel("Metier"));
        pan3.add(CBox);
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
        pan5.add(new JLabel("Metier"));
        pan5.add(homme);
        pan5.add(femme);
        homme.setMnemonic('H');
        femme.setMnemonic('F');
        groupe.add(homme);
        groupe.add(femme);
        pan6.setLayout(new FlowLayout());
        pan6.add(ajouter);
        pan6.add(ajouter_table);
        pan6.add(modifier);
        pan6.add(supprimer);
        pan6.add(afficher);
        pan6.add(reset);
        pan6.add(fermer);
        setVisible(true);

        ajouter.addActionListener(this);
        modifier.addActionListener(this);
        supprimer.addActionListener(this);
        afficher.addActionListener(this);
        ajouter_table.addActionListener(this);
        reset.addActionListener(this);
        BchImg.addActionListener(this);

        // fermeture avec confirmation
        fermer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                sortieAvecConf();
            }
        });
    }

    public static void main(String[] args) {
        // connexion à la base de données “base” qui contient la table Adherent
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3310/bibliotheque", "root", "");
            st = con.createStatement();
            System.out.println("accès avec succès");
        } catch (Exception ex) {
            System.out.println("Erreur: " + ex);
        }
        // fin de a connexion à la base de données

        new Main();
    }

    void sortieAvecConf() {
        if (JOptionPane.showConfirmDialog(this,
                "Voulez-vous vraiment quitter ce programme?",
                "Attention!",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Genre = "", Sport = "", Metier = "";
        Object source = e.getSource();
        if (source == BchImg) {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            FichNom = f.getAbsolutePath();
            ImageIcon ImgIcn = new ImageIcon(new ImageIcon(FichNom).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
            lbl_img.setIcon(ImgIcn);
            try {
                File image = new File(FichNom);
                FileInputStream fis = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = fis.read(buf)) != -1; ) {
                    bos.write(buf, 0, readNum);
                }
                imag_adherent = bos.toByteArray();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        } // fermeture de if (source==BchImg)

        if (source == ajouter) {
            try {
                st = con.createStatement();
                String requete = "INSERT INTO adherent(Nom, Date, Login, Metier, Genre, Sport, Image) VALUES( ?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(requete);
                ps.setString(1, FNom.getText());
                String date = dateChooser.getText();
                ps.setString(2, date);
                ps.setString(3, login.getText());
                Metier = CBox.getSelectedItem().toString();
                ps.setString(4, Metier);
                if (homme.isSelected()) Genre = "Homme";
                if (femme.isSelected()) Genre = "Femme";
                ps.setString(5, Genre);
                if (foot.isSelected()) Sport += foot.getText() + " ";
                if (basket.isSelected()) Sport += basket.getText() + " ";
                if (tennis.isSelected()) Sport += tennis.getText() + " ";
                if (squash.isSelected()) Sport += squash.getText() + " ";
                if (natation.isSelected()) Sport += natation.getText() + " ";
                if (athletisme.isSelected()) Sport += athletisme.getText() + " ";
                if (randonnee.isSelected()) Sport += randonnee.getText() + " ";
                if (volley.isSelected()) Sport += volley.getText() + " ";
                if (pelanque.isSelected()) Sport += pelanque.getText() + " ";
                ps.setString(6, Sport);
                ps.setBytes(7, imag_adherent);
                int nb = ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Inserted successfully");
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }

        if (source == reset) {
            FNom.setText("");
            dateChooser.setValue(new Date());
            login.setText("");
            groupe.clearSelection();
            CBox.setSelectedIndex(0);
            if (foot.isSelected()) foot.setSelected(false);
            if (basket.isSelected()) basket.setSelected(false);
            if (tennis.isSelected()) tennis.setSelected(false);
            if (squash.isSelected()) squash.setSelected(false);
            if (natation.isSelected()) natation.setSelected(false);
            if (athletisme.isSelected()) athletisme.setSelected(false);
            if (randonnee.isSelected()) randonnee.setSelected(false);
            if (volley.isSelected()) volley.setSelected(false);
            if (pelanque.isSelected()) pelanque.setSelected(false);
            lbl_img.setIcon(null);
        }

        if (source == modifier) {
            try {
                Table t = new Table();

                String log = login.getText();
                String requete = "UPDATE adherent set Nom=?, Date=?, Metier=?, Genre=?, Sport =?,Image =?where Login = '" + log + "' ";
                PreparedStatement ps = con.prepareStatement(requete);
                ps.setString(1, FNom.getText());
                String date = dateChooser.getText();
                ps.setString(2, date);
                Metier = CBox.getSelectedItem().toString();
                ps.setString(3, Metier);
                if (homme.isSelected()) Genre = "Homme";
                if (femme.isSelected()) Genre = "Femme";
                ps.setString(4, Genre);

                if (foot.isSelected()) Sport += foot.getText() + " ";
                if (basket.isSelected()) Sport += basket.getText() + " ";
                if (tennis.isSelected()) Sport += tennis.getText() + " ";
                if (squash.isSelected()) Sport += squash.getText() + " ";
                if (natation.isSelected()) Sport += natation.getText() + " ";
                if (athletisme.isSelected()) Sport += athletisme.getText() + " ";
                if (randonnee.isSelected()) Sport += randonnee.getText() + " ";
                if (volley.isSelected()) Sport += volley.getText() + " ";
                if (pelanque.isSelected()) Sport += pelanque.getText() + " ";
                ps.setString(5, Sport);
                ps.setBytes(6, imag_adherent);
                int nb = ps.executeUpdate();

                // refresh JTable
                /*DefaultTableModel model = (DefaultTableModel) t.tab.getModel();
                model.setRowCount(0);
                t.show_adherent();
                t.setVisible(true);*/
                //////////
                JOptionPane.showMessageDialog(null, "Updated successfully");
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }

        if (source == supprimer) {
            try {
                Table t = new Table();
                String log = login.getText();
                String requete = "delete from Adherent WHERE Login ='" + log + "'";
                st.executeUpdate(requete);

                // refresh JTable
                /*DefaultTableModel model= (DefaultTableModel)t.tab.getModel();
                model.setRowCount(0);
                t.show_adherent();
                t.setVisible(true);*/
                //////////
                JOptionPane.showMessageDialog(null, "Deleted successfully");
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }

        if (source == afficher) {
            try {
                Table tab = new Table();
                tab.setVisible(true);
                setVisible(false);
            } catch (Exception ex) {
                System.out.println("Erreur: " + ex);
            }
        }

        if (source == ajouter_table) {
            try {
                Statement st = con.createStatement();
                String requete = "CREATE TABLE Personne(id int not null auto_increment, prenom VARCHAR(15), nom varchar(15), age INT, primary key(id))";
                st.executeUpdate(requete);
                JOptionPane.showMessageDialog(null, "Table created successfully");
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        } // Fermeture de la méthode actionPerformed
    } // fermeture du constructeur
}


