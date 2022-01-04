import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student {
    private JLabel nomLabel;
    private JLabel note1Label;
    private JLabel note2Label;
    private JLabel note3Label;
    private JLabel totaleLabel;
    private JLabel AVGLabel;
    private JLabel gradeLabel;
    private JTextField textFieldNom;
    private JTextField txtnote1;
    private JTextField txtnote2;
    private JTextField txtnote3;
    private JTextField txttotal;
    private JTextField txtmoyenne;
    private JTextField txtgrade;
    private JButton buttonOK;
    private JPanel Main;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student");
        frame.setContentPane(new Student().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Student() {
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n1, n2, n3;
                double avg;

                n1 = Integer.parseInt(txtnote1.getText());
                n2 = Integer.parseInt(txtnote2.getText());
                n3 = Integer.parseInt(txtnote3.getText());

                int totale = (n1+n2+n3);
                avg = totale/3;
                txttotal.setText(totale+"");
                txtmoyenne.setText(avg+"");

                if(avg<10){
                    txtgrade.setText("Non valide");
                }
                else {
                    txtgrade.setText("Valide");
                }
            }
        });
    }
}
