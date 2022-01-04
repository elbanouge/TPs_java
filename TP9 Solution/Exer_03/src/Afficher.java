import javax.swing.*;

public class Afficher {

    private JTable table1;
    private JPanel panel1;

    public JPanel getPanel1() {
        return panel1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Afficher");
        frame.setContentPane(new Afficher().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
