import java.sql.*;
import java.util.Scanner;
import java.util.*;
import java.sql.*;
import java.io.File;
import java.lang.reflect.Array;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        int choice;
        do {
            Scanner userwords = new Scanner(System.in);
            try {
                System.out.println("Enter a word you want to add to the database");
                String word = userwords.next();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordoccurrences", "root", "lockbox$2473");
                PreparedStatement ps = connection.prepareStatement("insert into word (words) values (?)");
                ps.setString(1, word);
                ps.executeUpdate();
                System.out.println("Database after User Additions");
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("select * from word");
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Do you want to enter more words (Press 1 for yes)");
            choice = userwords.nextInt();

        } while (choice == 1);


        System.out.println("Frequency of each word added:");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordoccurrences", "root", "lockbox$2473");
            PreparedStatement ps = connection.prepareStatement("insert into word (words) values (?)");
            ps.setString(1, Fileconverter.wordArray.get());
            ps.executeUpdate();
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }
