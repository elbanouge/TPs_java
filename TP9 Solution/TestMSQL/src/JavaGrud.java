import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JavaGrud {
    private JPanel Main;
    private JTextField txtname;
    private JButton buttonadd;
    private JButton deleteButton;
    private JButton updateButton;
    private JTextField txtprdID;
    private JTextField txtqty;
    private JTextField txtprice;
    private JLabel productIDLabel;
    private JButton searchButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("JavaGrud");
        frame.setContentPane(new JavaGrud().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JavaGrud() {
        Connect();
        buttonadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name,price,qty;

                name = txtname.getText();
                price = txtprice.getText();
                qty = txtqty.getText();

                try {
                    pst = con.prepareStatement("insert into products(NomPrd,PricePrd,QtyPrd)values(?,?,?)");
                    pst.setString(1, name);
                    pst.setString(2, price);
                    pst.setString(3, qty);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Addedddddd!!!!");

                    txtname.setText("");
                    txtprice.setText("");
                    txtqty.setText("");
                    txtname.requestFocus();
                }

                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String pid = txtprdID.getText();
                    pst = con.prepareStatement("select * from products where IdPrd = ?");
                    pst.setString(1, pid);
                    ResultSet rs = pst.executeQuery();

                    if(rs.next()==true)
                    {
                        String name = rs.getString(2);
                        String price = rs.getString(3);
                        String qty = rs.getString(4);

                        txtname.setText(name);
                        txtprice.setText(price);
                        txtqty.setText(qty);
                    }
                    else
                    {
                        txtname.setText("");
                        txtprice.setText("");
                        txtqty.setText("");
                        JOptionPane.showMessageDialog(null,"Invalid Product ID");

                    }
                }

                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pid,name,price,qty;

                name = txtname.getText();
                price = txtprice.getText();
                qty = txtqty.getText();
                pid = txtprdID.getText();

                try {

                    pst = con.prepareStatement("update products set NomPrd = ?,PricePrd = ?,QtyPrd = ? where IdPrd = ?");
                    pst.setString(1, name);
                    pst.setString(2, price);
                    pst.setString(3, qty);
                    pst.setString(4, pid);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Updateee!!!!!");

                    txtname.setText("");
                    txtprice.setText("");
                    txtqty.setText("");
                    txtname.requestFocus();
                    txtprdID.setText("");
                }

                catch (SQLException e1)
                {

                    e1.printStackTrace();
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bid;

                bid = txtprdID.getText();


                try {
                    pst = con.prepareStatement("delete from products  where IdPrd = ?");
                    pst.setString(1, bid);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleteeeeee!!!!!");

                    txtname.setText("");
                    txtprice.setText("");
                    txtqty.setText("");
                    txtname.requestFocus();
                    txtprdID.setText("");
                }

                catch (SQLException e1)
                {

                    e1.printStackTrace();
                }
            }
        });
    }

    Connection con;
    PreparedStatement pst;

    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3310/bibliotheque", "root","");
            System.out.println("Success");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
