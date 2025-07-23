import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateBook implements ActionListener {
    private JFrame frame;
    JButton back , addButton;
    JTextField IDField , genreField , authorField , titleField ;
    
    public updateBook() {
        frame = new JFrame("Update Book");
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JLabel IDLabel = new JLabel("ID Number:");
        IDField = new JTextField(20);

 
        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(20);
        
        JLabel genreLabel = new JLabel("Genre:");
        genreField = new JTextField(20);

        JLabel authorLabel = new JLabel("Author:");
        authorField = new JTextField(20);

        addButton = new JButton("update");
        addButton.addActionListener(this);

        back= new JButton("Back");
        back.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2 , 30,30)); 
        panel.add(IDLabel);
        panel.add(IDField);
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(genreLabel);
        panel.add(genreField);
        panel.add(authorLabel);
        panel.add(authorField);
        panel.add(back); 
        panel.add(addButton);

        frame.add(panel);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            frame.dispose();
        }
        else if(e.getSource() == addButton){

            String idtxt = IDField.getText();
            String name = titleField.getText();
            String genre = genreField.getText();
            String author = authorField.getText();
            
            if (idtxt.isEmpty() || name.isEmpty() || genre.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all the textfields to add the book!");
            }
            else{
                try{    
                    int id = Integer.parseInt(idtxt);

                    DatabaseConnection d = new DatabaseConnection();
                    boolean updated = d.updatebook(id, name, genre, author);
                    if(updated)
                    {
                        JOptionPane.showMessageDialog(addButton, "Book is updated Successfully!");
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "No book found with ID " + id);
                    }
                }catch(NumberFormatException f){
                    JOptionPane.showMessageDialog(frame, "ID should be a valid number!");
                }   
            }
        }
    }
}

    

