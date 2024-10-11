package com.login.dao;

import com.login.dto.MyMember;
import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyMemberDao {
    public MyMember login(String myid, String mypw) {
        MyMember res = new MyMember();
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from mymember where myid = ? and mypw = ? and myenabled = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, myid);
            ps.setString(2, mypw);
            ps.setString(3, "Y");
            rs = ps.executeQuery();
            while (rs.next()) {
                res.setMyno(rs.getInt(1));
                res.setMyid(rs.getString(2));
                res.setMypw(rs.getString(3));
                res.setMyname(rs.getString(4));
                res.setMyaddr(rs.getString(5));
                res.setMyphone(rs.getString(6));
                res.setMyemail(rs.getString(7));
                res.setMyenabled(rs.getString(8));
                res.setMyrole(rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(ps);
            close(con);
        }
        return res;
    }

    public List<MyMember> selectAll() {
        List<MyMember> res = new ArrayList<MyMember>();
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from mymember order by myno desc ";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MyMember m = new MyMember();
                m.setMyno(rs.getInt(1));
                m.setMyid(rs.getString(2));
                m.setMypw(rs.getString(3));
                m.setMyname(rs.getString(4));
                m.setMyaddr(rs.getString(5));
                m.setMyphone(rs.getString(6));
                m.setMyemail(rs.getString(7));
                m.setMyenabled(rs.getString(8));
                m.setMyrole(rs.getString(9));
                res.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(ps);
            close(con);
        }
        return res;
    }

    public MyMember selectUser(int myno) {
        MyMember res = new MyMember();
        String sql = "select * from mymember where myno = ?";
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, myno);
            rs = ps.executeQuery();
            while (rs.next()) {
                res.setMyno(rs.getInt(1));
                res.setMyid(rs.getString(2));
                res.setMypw(rs.getString(3));
                res.setMyname(rs.getString(4));
                res.setMyaddr(rs.getString(5));
                res.setMyphone(rs.getString(6));
                res.setMyemail(rs.getString(7));
                res.setMyenabled(rs.getString(8));
                res.setMyrole(rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(ps);
            close(con);
        }
        return res;
    }

    public int updaterole(int myno, String myrole) {
        int res = 0;
        Connection con = getConnection();
        PreparedStatement ps = null;
        String sql = "update mymember set myrole = ? where myno = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, myrole);
            ps.setInt(2, myno);
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
            close(con);
        }

        return res;
    }

    public boolean idChk(String myid) {
        boolean res = true;
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from mymember where myid = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, myid);
            rs = ps.executeQuery();
            if (rs.next()) {
                res = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(ps);
            close(con);
        }
        return res;
    }

    public int insertuser(MyMember dto) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        int res = 0;
        String sql = " insert into mymember values(seq_mymember.nextval,?,?,?,?,?,?,'Y','User')";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getMyid());
            ps.setString(2, dto.getMypw());
            ps.setString(3, dto.getMyname());
            ps.setString(4, dto.getMyaddr());
            ps.setString(5, dto.getMyphone());
            ps.setString(6, dto.getMyemail());
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public int deleteuser(int myno) {
        int res = 0;
        Connection con = getConnection();
        PreparedStatement ps = null;
        String sql = "update mymember set myenabled = 'N' where myno = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, myno);
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return res;
    }
}
