package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListeAdherents extends JFrame {
    public JTable tab = new JTable();
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    public ListeAdherents() throws HeadlessException {
        this.setTitle("Table des adherents");
        this.add(tab);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900, 350);
        show_adherent();
    }

    public void show_adherent() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque", "root", "admin");
            st = con.createStatement();
            System.out.println("accès avec succès");
            DefaultTableModel model = new DefaultTableModel(new String[]{"Nom", "Prenom", "Date", "Telephone", "Login", "Mot de passe", "Montant", "Adresse", "Genre", "Sport"}, 0);
            String sql = "select * from adherents";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String n = rs.getString("Nom");
                String pr = rs.getString("Prenom");
                String da = rs.getString("DateInscrp");
                String tel = rs.getString("Tel");
                String lg = rs.getString("Login");
                String pass = rs.getString("MotPass");
                String mt = rs.getString("Montant");
                String adr = rs.getString("Adresse");
                String sexe = rs.getString("Sexe");
                String ty = rs.getString("TypesB");
                model.addRow(new Object[]{n, pr, da, tel, lg, pass, mt, adr, sexe, ty});
                tab.setModel(model);
                JScrollPane pane = new JScrollPane(tab);
                getContentPane().add(pane, BorderLayout.CENTER);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }

        tab.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i = tab.getSelectedRow();
                TableModel model = tab.getModel();
                Main ex = new Main();
                ex.setFNom(model.getValueAt(i, 0).toString());
                ex.setTxtFPrenom(model.getValueAt(i, 1).toString());
                try {
                    int srow = tab.getSelectedRow();
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(srow, 2));
                    ex.textFieldDate.setValue(date);
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, a);
                }

                try {
                    int srow = tab.getSelectedRow();
                    ex.textFieldTel.setValue(model.getValueAt(srow, 3).toString());

                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                ex.setLogin(model.getValueAt(i, 4).toString());
                ex.passwordField.setText(model.getValueAt(i, 5).toString());

                try {
                    int srow = tab.getSelectedRow();
                    double number = Double.parseDouble(model.getValueAt(srow,6).toString());
                    System.out.printf(""+number);
                    ex.textFieldPrix.setValue(number);
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, a);
                }

                ex.areaAdresse.setText(model.getValueAt(i, 7).toString());

                String genre = model.getValueAt(i, 8).toString();
                if (genre.equals("Homme"))
                    ex.homme.setSelected(true);
                if (genre.equals("Femme"))
                    ex.femme.setSelected(true);

                String cbox = model.getValueAt(i, 9).toString();
                String[] eachSport = cbox.split(";");
                for (String a : eachSport) {
                    switch (a) {
                        case "Foot":
                            ex.foot.setSelected(true);
                            break;
                        case "Basket":
                            ex.basket.setSelected(true);
                            break;
                        case "Tennis":
                            ex.tennis.setSelected(true);
                            break;
                        case "Squash":
                            ex.squash.setSelected(true);
                            break;
                        case "Natation":
                            ex.natation.setSelected(true);
                            break;
                        case "Athletisme":
                            ex.athletisme.setSelected(true);
                            break;
                        case "Randonnée":
                            ex.randonnee.setSelected(true);
                            break;
                        case "Volley":
                            ex.volley.setSelected(true);
                            break;
                        case "Pélanque":
                            ex.pelanque.setSelected(true);
                            break;
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        ListeAdherents adherents = new ListeAdherents();
        adherents.setVisible(true);
    }
}
