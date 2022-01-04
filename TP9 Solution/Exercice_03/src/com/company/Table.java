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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Table extends JFrame {
    public JTable tab = new JTable();
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    public Table() {
        this.setTitle("Table");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(600, 400);
        show_adherent();
    }

    ArrayList<Adherent> AdherentList() {
        ArrayList<Adherent> AdherentList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3310/bibliotheque", "root", "");
            st = con.createStatement();
            System.out.println("accès avec succès");
            String query1 = "select * from adherent";
            rs = st.executeQuery(query1);
            Adherent adherent;
            while (rs.next()) {
                adherent = new Adherent(rs.getString("Nom"), rs.getString("Date"), rs.getString("Login"), rs.getString("Metier"), rs.getString("Genre"), rs.getString("Sport"), rs.getBytes("Image"));
                AdherentList.add(adherent);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return AdherentList;
    }

    public void show_adherent() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3310/bibliotheque", "root", "");
            st = con.createStatement();
            System.out.println("accès avec succès");
            DefaultTableModel model = new DefaultTableModel(new String[]{"Nom", "Date", "Login", "Metier", "Genre", "Sport", "Image"}, 0);
            String sql = "select * from adherent";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String d = rs.getString("Nom");
                String da = rs.getString("Date");
                String e = rs.getString("Login");
                String f = rs.getString("Metier");
                String g = rs.getString("Genre");
                String h = rs.getString("Sport");
                String i = rs.getString("Image");
                model.addRow(new Object[]{d, da, e, f, g, h, i});
                tab.setModel(model);
                JScrollPane pane = new JScrollPane(tab);
                getContentPane().add(pane, BorderLayout.CENTER);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        tab.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i = tab.getSelectedRow();
                TableModel model = tab.getModel();
                Main ex = new Main();
                ex.setFNom(model.getValueAt(i, 0).toString());
                try {
                    int srow = tab.getSelectedRow();
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(srow, 1));
                    ex.dateChooser.setValue(date);
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, a);
                }
                ex.setLogin(model.getValueAt(i, 2).toString());
                String metier = model.getValueAt(i, 3).toString();
                switch (metier) {
                    case "Fonctionnaire":
                        ex.CBox.setSelectedIndex(0);
                        break;
                    case "Employé":
                        ex.CBox.setSelectedIndex(1);
                        break;
                    case "Fonction libérale":
                        ex.CBox.setSelectedIndex(2);
                        break;
                    case "Sans emploi":
                        ex.CBox.setSelectedIndex(3);
                        break;
                }
                String genre = model.getValueAt(i, 4).toString();
                if (genre.equals("Homme"))
                    ex.homme.setSelected(true);
                if (genre.equals("Femme"))
                    ex.femme.setSelected(true);
                String cbox = model.getValueAt(i, 5).toString();
                String[] eachSport = cbox.split(" ");
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
                byte[] img = (AdherentList().get(i).getImage());
                ImageIcon ImgIcn = new ImageIcon(new
                        ImageIcon(img).getImage().getScaledInstance(120, 120,
                        Image.SCALE_SMOOTH));
                Main.getLbl().setIcon(ImgIcn);
            }
        });
    }
    public static void main(String[] args) {
        Table t = new Table();
        t.setVisible(true);
    }
}

