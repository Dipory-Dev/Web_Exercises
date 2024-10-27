package com.bike.dao;

import com.bike.dto.BikeDto;
import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BikeDao {
    public int insert(List<BikeDto> dto) {
        int res = 0;
        Connection con = getConnection();
        PreparedStatement ps = null;
        String sql = "insert into bike_tb values(?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            for (BikeDto d : dto) {
                ps.setString(1, d.getAddr_gu());
                ps.setInt(2, d.getContent_id());
                ps.setString(3, d.getContent_nm());
                ps.setString(4, d.getNew_addr());
                ps.setInt(5, d.getCradle_count());
                ps.setDouble(6, d.getLongitude());
                ps.setDouble(7, d.getLatitude());
                ps.addBatch();
            }
            int[] tmp = ps.executeBatch();
            res = tmp.length;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(con);
        }
        return res;
    }

    public int delete(int cid) {
        int res = 0;
        Connection con = getConnection();
        PreparedStatement ps = null;
        String sql = "delete from bike_tb where content_id = ?";
        System.out.println(sql);
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cid);
            res = ps.executeUpdate();
            System.out.println(res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(con);
        }
        return res;
    }

    public int delall() {
        int res = 0;
        Connection con = getConnection();
        PreparedStatement ps = null;
        String sql = "delete from bike_tb";
        try {
            ps = con.prepareStatement(sql);
            res = ps.executeUpdate();
            if (res > 0) {
                commit(con);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return res;
    }
}
