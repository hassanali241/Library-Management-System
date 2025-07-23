import java.awt.event.*;
import javax.swing.*;

public class library implements ActionListener{
    JFrame frame1;
    JFrame frame2;
    JLabel label1;
    JButton view_but;
    JButton add;
    JButton del;
    JButton update;
    
 
    

    public library(){

        frame1 = new JFrame("Menu");

        ImageIcon icon = new ImageIcon("logo.png"); // <- put your logo file in the same folder
        frame1.setIconImage(icon.getImage());

        view_but = new JButton("View Books");
        view_but.setBounds(20,20,120,25);
        view_but.addActionListener(this);

        add = new JButton("Add Book");
        add.setBounds(200,20,120,25);
        add.addActionListener(this);

        del = new JButton("Delete Book");
        del.setBounds(380,20,120,25);
        del.addActionListener(this);

        update = new JButton("Update Book");
        update.setBounds(560,20,120,25);
        update.addActionListener(this);

        frame1.add(view_but);
        frame1.add(add);
        frame1.add(del);
        frame1.add(update);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(800,200);
        frame1.setLayout(null);
        frame1.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == view_but){
            DatabaseConnection dbConnection = new DatabaseConnection();
            dbConnection.createAndShowGUI();
            dbConnection.readlib();
        }
        else if(e.getSource() == add){
            AddBook a = new AddBook();
        }    
        else if(e.getSource() == del){
            DelBook d = new DelBook();
        }
        else if(e.getSource() == update){
            updateBook up = new updateBook();
        }    
    }
        
}