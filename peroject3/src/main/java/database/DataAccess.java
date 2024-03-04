package database;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import javax.swing.table.DefaultTableModel;
import java.sql.*;



public class DataAccess {
    static Connection conn;
    static ResultSet resultSet;
    static Statement statement;
    public DataAccess(){
    }
    public boolean connect() {
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://aws.connect.psdb.cloud/proiectpt?sslMode=VERIFY_IDENTITY",
                    "efd511otgvxp65omenxa",
                    "pscale_pw_4po37VwB5AdRwisvCRSJnBgadO0cUGpFVGUaKixYVXu");

            return true;
        } catch (SQLException e) {
            System.out.println("ERROR: SQLException connection: " + e.getMessage());
            return false;
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: ClassNotFoundException connection: " + e.getMessage());
            return false;
        }
    }
    public void display(ResultSet rs) {
        // Set up JFrame
        JFrame frame = new JFrame("Query Results");
        frame.setSize(800, 600);

        try {
            // Get the column names
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = rsmd.getColumnName(i);
            }

            // Get the data
            Object[][] data = new Object[1000][columnCount];
            int row = 0;
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    data[row][i - 1] = rs.getObject(i);
                }
                row++;
            }

            // Create a table model
            DefaultTableModel model = new DefaultTableModel(data, columnNames);

            // Create a table
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane);
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }
    public void close(){
        if(conn!=null){
            close(conn);
        }
        if(resultSet!=null){
            close(resultSet);
        }
        if(statement!=null){
            close(statement);
        }
    }
    public static void close(Connection connection) {
        // Step 6: Close the connection
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("ERROR: SQLException close"+e.getMessage());
        }
    }
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("An error occured while trying to close the statement");
            }
        }
    }
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("An error occured while trying to close the ResultSet");
            }
        }
    }
    public Connection getConnection() {
        connect();
        return conn;
    }
}
