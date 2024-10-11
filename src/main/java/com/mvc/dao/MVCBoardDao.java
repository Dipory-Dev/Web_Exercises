package com.mvc.dao;

import common.JDBCTemplate;
import common.JDBCTemplate.*;
import com.mvc.dto.MVCBoardDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static common.JDBCTemplate.*;

public class MVCBoardDao {

    public List<MVCBoardDto> selectAll() {
        List<MVCBoardDto> res = new ArrayList<>();
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM MVCBOARD ORDER BY SEQ DESC ";
        System.out.println("03. SQL is ready: " + sql);

        try {
            System.out.println(res);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                MVCBoardDto board = new MVCBoardDto(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5));
                res.add(board);
            }
            System.out.println("04. Success Execute Query and return result");
        } catch (SQLException e) {
            System.out.println("04. Failed Execute Query and return result");
            e.printStackTrace();
        } finally {
            close(rs);
            close(stmt);
            close(con);
        }
        return res;
    }

    public MVCBoardDto selectOne(int seq) {
        MVCBoardDto res = null;
        Connection con = getConnection();
        PreparedStatement ps = null;
        String sql = "SELECT * FROM MVCBOARD WHERE SEQ = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, seq);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = new MVCBoardDto(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getDate(5));
            }
            close(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
            close(con);
        }



        return res;
    }

    public int insert(MVCBoardDto board) {
        int res = 0;
        String sql = "insert into MVCBOARD values(seq_MVCBOARD.nextval, ?, ?, ?, default)";
        Connection con = getConnection();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, board.getWriter());
            ps.setString(2, board.getTitle());
            ps.setString(3, board.getContent());
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
            close(con);
        }
        return res;
    }

    public int update (MVCBoardDto board) {
        int res = 0;
        Connection con = getConnection();
        PreparedStatement ps = null;
        String sql = "update MVCBOARD set title = ?, content = ?, regdate = ? where seq = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, board.getTitle());
            ps.setString(2, board.getContent());
            if (board.getRegdate() != null) {
                java.sql.Date sqlDate = new java.sql.Date(board.getRegdate().getTime());
                ps.setDate(3, sqlDate);
            } else {
                ps.setDate(3, null);
            }
            ps.setInt(4, board.getSeq());
            res = ps.executeUpdate();
            System.out.println(res);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
            close(con);
        }
        return res;
    }

    public int delete(int seq) {
        int res = 0;
        Connection con = getConnection();
        PreparedStatement ps = null;
        String sql = "delete from MVCBOARD where seq = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, seq);
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
            close(con);
        }
        return res;
    }
}
