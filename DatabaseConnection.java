import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DatabaseConnection {
    private Connection connection;
    private JFrame frame;
    private JTextArea textarea;

    String url = "jdbc:mysql://localhost:3306/library_database";
    String user = "root";
    String password = "12345";

    public DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAndShowGUI() {
        frame = new JFrame("Library Database Viewer");
      //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        textarea = new JTextArea();
        textarea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textarea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Dispose the window when back button is clicked
            }
        });
        frame.getContentPane().add(backButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void readlib() {
        String query = "SELECT book_id, book_name ,book_genre , book_author FROM books";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int book_id = resultSet.getInt("book_id");
                String book_name = resultSet.getString("book_name");
                String genre = resultSet.getString("book_genre");
                String author = resultSet.getString("book_author");

                textarea.append("ID: " + book_id  + ", Name: " + book_name + ", Genre: " + genre + ", Author: " + author + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int id) {
        String query = "DELETE FROM books WHERE book_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addbook(int book_id, String book_name,String book_genre , String book_author) {
        String query = "INSERT INTO books (book_id,book_name,book_genre,book_author) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, book_id);
            preparedStatement.setString(2, book_name);
            preparedStatement.setString(3,book_genre);
            preparedStatement.setString(4,book_author);
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updatebook(int book_id, String book_name, String book_genre, String book_author) {
    String query = "UPDATE books SET book_name = ?, book_genre = ?, book_author = ? WHERE book_id = ?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, book_name);
        preparedStatement.setString(2, book_genre);
        preparedStatement.setString(3, book_author);
        preparedStatement.setInt(4, book_id);

        int rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


}