import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelBook implements ActionListener {
    private JFrame frame;
    JButton back , DelButton;
    JTextField IDField;
    
    public DelBook() {
        frame = new JFrame("Delete Book");
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JLabel authorLabel = new JLabel("ID NUMBER:");
        IDField = new JTextField(20);
        DelButton = new JButton("Delete");
        DelButton.addActionListener(this);

        back= new JButton("Back");
        back.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2 , 50,50)); 

        panel.add(authorLabel);
        panel.add(IDField);
        panel.add(back); 
        panel.add(DelButton);

        frame.add(panel);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            frame.dispose();
        } else if (e.getSource() == DelButton) {
            String input = IDField.getText().trim(); 
                        
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter an ID to delete the book!");
            } else {
                try {
                    int id = Integer.parseInt(input);
                    DatabaseConnection d = new DatabaseConnection();
                    d.deleteBook(id);
                    JOptionPane.showMessageDialog(frame, "Book is deleted Successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid ID! Please enter a valid number.");
                }
            }
        }
    }
    
}    
    