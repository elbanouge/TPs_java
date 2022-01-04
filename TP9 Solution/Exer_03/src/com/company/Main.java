package com.company;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends JFrame {
    private JButton button2 = new JButton("Center");

    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JPanel panel5 = new JPanel();
    private JPanel panel6 = new JPanel();
    private JPanel panel7 = new JPanel();

    private JLabel label;
    private JTextField textField;
    private JRadioButton radioButtonM, radioButtonF;
    private JCheckBox checkBox;

    //Adressse
    private JTextArea areaAdresse;
    private JScrollPane scrollPane;

    //Date Formater
    private JFormattedTextField textFieldDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("'Le' dd/MM/yyyy 'à' hh:mm:ss");

    //Telephone Formater
    private JFormattedTextField textFieldTel;
    private MaskFormatter formatterTel = null;

    //Password Formater
    private JPasswordField passwordField;

    //Prix Fomater
    private JFormattedTextField textFieldPrix;

    public Main() throws HeadlessException {
        setTitle("Gestion d'une base de données");

        /* Pannel 1 */
        panel.setLayout(new BorderLayout());
        panel.add(panel2);
        panel.add(panel4, BorderLayout.EAST);
        panel.add(panel6, BorderLayout.SOUTH);
        this.add(panel);

        /* Pannel 2 */
        panel2.setLayout(new BorderLayout());
        panel2.add(panel3, BorderLayout.NORTH);
        panel2.add(panel7, BorderLayout.CENTER);
        panel2.add(panel5, BorderLayout.SOUTH);

        panel3.setLayout(new GridLayout(14, 1));
        label = new JLabel("Nom : ");
        panel3.add(label);

        textField = new JTextField();
        panel3.add(textField);

        label = new JLabel("Prenom : ");
        panel3.add(label);

        textField = new JTextField();
        panel3.add(textField);

        label = new JLabel("Date d'inscription : ");
        panel3.add(label);

        textFieldDate = new JFormattedTextField(dateFormat);
        textFieldDate.setValue(new Date());
        panel3.add(textFieldDate);

        label = new JLabel("Téléphone : ");
        panel3.add(label);

        try {
            formatterTel = new MaskFormatter("0#.##.##.##.##");
            textFieldTel = new JFormattedTextField(formatterTel);
            textFieldTel.setValue("06.15.76.57.67");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        panel3.add(textFieldTel);

        label = new JLabel("Login : ");
        panel3.add(label);

        textField = new JTextField();
        panel3.add(textField);

        label = new JLabel("Mode de passe : ");
        panel3.add(label);

        passwordField = new JPasswordField();
        panel3.add(passwordField);

        label = new JLabel("Montant a payer : ");
        panel3.add(label);

        textFieldPrix = new JFormattedTextField(new DecimalFormat("#,##.00 DH"));
        textFieldPrix.setValue(24.56);
        panel3.add(textFieldPrix);

        panel7.setLayout(new GridLayout(2, 1));
        label = new JLabel("Adresse : ");
        panel7.add(label);

        areaAdresse = new JTextArea(10,2);
        scrollPane = new JScrollPane(areaAdresse);
        panel7.add(scrollPane);

        panel4.setLayout(new GridLayout(9, 1));
        checkBox = new JCheckBox("Tennis");
        panel4.add(checkBox);
        checkBox = new JCheckBox("Tennis");
        panel4.add(checkBox);
        checkBox = new JCheckBox("Tennis");
        panel4.add(checkBox);
        checkBox = new JCheckBox("Tennis");
        panel4.add(checkBox);
        checkBox = new JCheckBox("Tennis");
        panel4.add(checkBox);
        checkBox = new JCheckBox("Tennis");
        panel4.add(checkBox);
        checkBox = new JCheckBox("Tennis");
        panel4.add(checkBox);
        checkBox = new JCheckBox("Tennis");
        panel4.add(checkBox);
        checkBox = new JCheckBox("Tennis");
        panel4.add(checkBox);

        panel5.setLayout(new FlowLayout());
        label = new JLabel("Sexe : ");
        panel5.add(label);
        radioButtonM = new JRadioButton("Homme");
        radioButtonF = new JRadioButton("Femme");
        radioButtonF.setSelected(true);
        panel5.add(radioButtonF);
        panel5.add(radioButtonM);
        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonF);
        group.add(radioButtonM);

        panel6.setLayout(new FlowLayout());
        panel6.add(new JButton("Ajouter enreg"));
        panel6.add(new JButton("Annuler"));
        panel6.add(new JButton("Annuler"));
        panel6.add(new JButton("Annuler"));
        panel6.add(new JButton("Annuler"));
        panel6.add(new JButton("Annuler"));
        panel6.add(new JButton("Annuler"));


        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
