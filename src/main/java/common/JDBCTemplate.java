package common;

import java.sql.*;


public class JDBCTemplate {
    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("01. Connecting to Oracle Database ...");
        }catch (ClassNotFoundException e) {
            System.out.println("01. Failed to connect to Oracle Database");
            e.printStackTrace();
        }

        Connection con = null;
        String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String user = "kjs";
        String password = "1234";

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("02. Connected to Oracle Database successfully");
        } catch (SQLException e) {
            System.out.println("02. Failed to connect to Oracle Database");
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement st) {
        try {
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
