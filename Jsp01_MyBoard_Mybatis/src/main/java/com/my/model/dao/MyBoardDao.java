package com.my.model.dao;

import com.my.model.dto.MyBoard;
<<<<<<< HEAD
=======
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

>>>>>>> Jsp01_MyBoard_Mybatis/main

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class MyBoardDao {
    Connection con = null;
    String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
    String user = "kjs";
    String password = "1234";


    public MyBoardDao() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("01. Connecting to driver...");
        } catch (ClassNotFoundException e) {
            System.out.println("01. Failed to connect oracle driver");
            e.printStackTrace();
        }
    }


    public List<MyBoard> selectAll() {
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select * from MyBoard";
        List<MyBoard> res = new ArrayList<>();

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("02. Connected to database...");
        } catch (SQLException e) {
            System.out.println("02. Failed to connect oracle driver");
        }

        try {
            stmt = con.createStatement();
            System.out.println("03. SQL is ready : " + sql);

            rs = stmt.executeQuery(sql);
            System.out.println("04. Run SQL and return");

            while(rs.next()) {
                MyBoard tmp = new MyBoard(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getDate(5));

                res.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("03. Failed to execute query");
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
                System.out.println("05. End database connection");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("05. Failed to close database connection");
            }
        }


=======
public class MyBoardDao extends SqlMapConfig{

    public List<MyBoard> selectAll() {
        List<MyBoard> res = new ArrayList<>();
        SqlSession session = null;

        try {
            session = getSqlSessionFactory().openSession(true);
            res = session.selectList("com.my.model.dao.MyBoardDao.selectAll");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }



>>>>>>> Jsp01_MyBoard_Mybatis/main
        return res;
    }

    public MyBoard selectOne(int myno) {
        MyBoard res = new MyBoard();
<<<<<<< HEAD
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("02. Connected to database...");
        } catch (SQLException e) {
            System.out.println("02. Failed to connect oracle driver");
        }

        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from MyBoard where myno = ?";

        try {
            System.out.println("03. SQL is ready : " + sql);
            ps = con.prepareStatement(sql);
            ps.setInt(1, myno);
            int st = ps.executeUpdate();

            if(st > 0) {
                rs = ps.executeQuery();
                if(rs.next()) {
                    res = new MyBoard(rs.getInt(1), rs.getString(2), rs.getString(3),
                            rs.getString(4), rs.getDate(5));
                }
            }
            System.out.println("04. Run SQL and return");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
                System.out.println("05. End database connection");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("05. Failed to close database connection");
            }

        }


=======
        SqlSession session = null;

        try{
            session = getSqlSessionFactory().openSession(true);
            res = session.selectOne("com.my.model.dao.MyBoardDao.selectOne", myno);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

>>>>>>> Jsp01_MyBoard_Mybatis/main
        return res;
    }


    public int insert(MyBoard dto) {
        int res = 0;
<<<<<<< HEAD
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("02. Connected to database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement ps = null;
        String sql = "insert into MYBOARD values(SEQ_MYBOARD.NEXTVAL,?,?,?,CURRENT_DATE)";
        System.out.println("03. SQL is ready : " + sql);

        try {
            ps = con.prepareStatement(sql);
            System.out.println("______________________________________");
            ps.setString(1, dto.getMyname());
            ps.setString(2, dto.getMytitle());
            ps.setString(3, dto.getMycontent());
            System.out.println("______________________________________");
            System.out.println("Name: " + dto.getMyname());
            System.out.println("Title: " + dto.getMytitle());
            System.out.println("Content: " + dto.getMycontent());

            System.out.println("04. Run SQL and return");
            res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("04. Failed to execute query");
        } finally {
            try {
                ps.close();
                con.close();
                System.out.println("05. End database connection");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("05. Failed to close database connection");
            }
        }

        return res;
    }

    public int update(MyBoard dto) {
        int res = 0;
        PreparedStatement ps = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("02. Connected to database...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("02. Failed to connect oracle driver");
        }

        String sql = "update MYBOARD set mytitle = ?, mycontent = ? where myno = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getMytitle());
            ps.setString(2, dto.getMycontent());
            ps.setInt(3, dto.getMyno());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++dao update+++++++++++++++++++");
            System.out.println("dto.getMytitle(): " + dto.getMytitle());
            System.out.println("dto.getMycontent(): " + dto.getMycontent());
            System.out.println("dto.getMyno(): " + dto.getMyno());
            System.out.println("03. SQL is ready : " + sql);
            res = ps.executeUpdate();
            System.out.println("04. Run SQL and return");
            System.out.println("______________________________________");
            System.out.println("Dao res : " + res);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("03. Failed to execute query");
        } finally {
            try {
                ps.close();
                con.close();
                System.out.println("05. End database connection");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("05. Failed to close database connection");
            }
        }

        return res;
    }

    public int delete(int myno) {
        int res = 0;

        PreparedStatement ps = null;
        String sql = "delete from MyBoard where myno = ?";

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("02. Connected to database...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("02. Failed to connect oracle driver");
        }

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, myno);
            System.out.println("03. SQL is ready : " + sql);

            res = ps.executeUpdate();
            System.out.println("++++++++++++++++++++++++++++");
            System.out.println("DAO res = " + res);
            System.out.println("++++++++++++++++++++++++++++");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("03. Failed to execute query");
        } finally {
            try {
                ps.close();
                con.close();
                System.out.println("05. End database connection");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("05. Failed to close database connection");
            }
=======
        SqlSession session = null;
        try {
            session = getSqlSessionFactory().openSession(true);
            res = session.insert("com.my.model.dao.MyBoardDao.insert", dto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
>>>>>>> Jsp01_MyBoard_Mybatis/main
        }

        return res;
    }
}
