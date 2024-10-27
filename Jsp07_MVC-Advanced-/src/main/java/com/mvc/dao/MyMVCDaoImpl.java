package com.mvc.dao;

import com.mvc.dto.MyMVC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static common.JDBCTemplate.close;

public class MyMVCDaoImpl implements MyMVCDao {
    @Override
    public List<MyMVC> selectAll(Connection con) {
        List<MyMVC> res = new ArrayList<MyMVC>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = MyMVCDao.selectAllsql;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MyMVC tmp = new MyMVC(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5));
                res.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(ps);
        }
        return res;
    }

    @Override
    public MyMVC selectOne(Connection con, int seq) {
        MyMVC res = new MyMVC();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(MyMVCDao.selectOnesql);
            ps.setInt(1, seq);
            rs = ps.executeQuery();
            while (rs.next()) {
                res.setSeq(rs.getInt(1));
                res.setWriter(rs.getString(2));
                res.setTitle(rs.getString(3));
                res.setContent(rs.getString(4));
                res.setDate(rs.getDate(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(ps);
        }
        return res;
    }

    @Override
    public boolean insert(Connection con, MyMVC dto) {
        boolean res = false;
        PreparedStatement ps = null;
        String sql = MyMVCDao.insertSql;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getWriter());
            ps.setString(2, dto.getTitle());
            ps.setString(3, dto.getContent());
            res = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }
        return res;
    }

    @Override
    public boolean update(Connection con, MyMVC dto) {
        boolean res = false;
        PreparedStatement ps = null;
        String sql = MyMVCDao.updateSql;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getTitle());
            ps.setString(2, dto.getContent());
            ps.setDate(3, (Date) dto.getDate());
            ps.setInt(4, dto.getSeq());
            res = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
        }
        return res;
    }

    @Override
    public boolean delete(Connection con, int seq) {
        boolean res = false;
        PreparedStatement ps = null;
        String sql = MyMVCDao.deleteSql;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, seq);
            res = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
        }
        return res;
    }
}
