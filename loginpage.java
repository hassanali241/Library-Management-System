import java.awt.event.*;
import javax.swing.*;

public class loginpage implements ActionListener {

    JFrame frame = new JFrame("Login");
    JButton loginButton = new JButton("Login");
    JLabel UserId = new JLabel("User ID");
    JTextField Usertext = new JTextField();
    JLabel Password = new JLabel("Password");
    JPasswordField Passtext = new JPasswordField();
    JLabel message = new JLabel();

    public loginpage() {
        ImageIcon icon = new ImageIcon("logo.png"); // <- put your logo file in the same folder
        frame.setIconImage(icon.getImage());
        
        UserId.setBounds(50,100,75,25);
        Password.setBounds(50, 150, 75, 25);
        Passtext.setBounds(125,150,200,25);
        Usertext.setBounds(125,100,200,25);
        loginButton.setBounds(125,200,100,50);
        message.setBounds(125,250,250,35);
        
        loginButton.addActionListener(this);

        frame.add(UserId); 
        frame.add(Password);
        frame.add(Usertext);
        frame.add(Passtext);
        frame.add(loginButton);
        frame.add(message);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        }

        public void actionPerformed(ActionEvent e){
            if(e.getSource()== loginButton ){
                String userID = Usertext.getText().trim(); 
                String pass = Passtext.getText().trim();

                if(userID.equals("hassan") && pass.equals("123")){
                    message.setText("Login Successful!");
                    frame.dispose();
                    library library = new library();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong UserID or Password!.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
        
                frame.revalidate();
                frame.repaint();
            }
        }
}