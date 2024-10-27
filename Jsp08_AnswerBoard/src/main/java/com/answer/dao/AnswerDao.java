package com.answer.dao;

import com.answer.dto.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static common.JDBCTemplate.*;
public class AnswerDao {
    public List<Answer> selectAll() {
        List<Answer> res = new ArrayList<Answer>();
        Connection con = getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String sql = "select * from answerboard order by gno desc, gseq";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                Answer tmp = new Answer();
                tmp.setBno(rs.getInt(1));
                tmp.setGno(rs.getInt(2));
                tmp.setGseq(rs.getInt(3));
                tmp.setTitletab(rs.getInt(4));
                tmp.setTitle(rs.getString(5));
                tmp.setContent(rs.getString(6));
                tmp.setWriter(rs.getString(7));
                tmp.setRegdate(rs.getDate(8));
                res.add(tmp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(ps);
            close(con);
        }
        return res;
    }

    public int insert(Answer dto) {
        int res = 0;
        Connection con = getConnection();
        PreparedStatement ps = null;
        String sql = "insert into answerboard values" +
                "(bno_seq.nextval, gno_seq.nextval, 1, 0,?,?,?,current_date)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getTitle());
            ps.setString(2, dto.getContent());
            ps.setString(3, dto.getWriter());
            res = ps.executeUpdate();
            if(res > 0) {
                commit(con);
            } else {
                rollback(con);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(con);
        }
        return res;
    }

    public Answer selectOne(int bno) {
        Answer res = new Answer();
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from answerboard where bno = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, bno);
            rs = ps.executeQuery();
            if(rs.next()) {
                res.setBno(rs.getInt(1));
                res.setGno(rs.getInt(2));
                res.setGseq(rs.getInt(3));
                res.setTitletab(rs.getInt(4));
                res.setTitle(rs.getString(5));
                res.setContent(rs.getString(6));
                res.setWriter(rs.getString(7));
                res.setRegdate(rs.getDate(8));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(ps);
            close(con);
        }
        return res;
    }

    public int update(Answer dto) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        String sql = "update answerboard set title = ?, content = ? where bno = ?";
        int res = 0;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getTitle());
            ps.setString(2, dto.getContent());
            ps.setInt(3, dto.getBno());
            res = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(con);
        }
        return res;
    }

    public int updateAnswer(int pgno, int pgseq) {
        int res = 0;
        Connection con = getConnection();
        PreparedStatement ps = null;
        String sql = "update answerboard set gseq = (gseq + 1) where gno = ? and gseq > ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pgno);
            ps.setInt(2, pgseq);
            res = ps.executeUpdate();

            if (res > 0) {
                commit(con);
            } else {
                rollback(con);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(con);
        }

        return res;
    }

    public int insertAnswer(Answer dto) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        int res = 0;

//        INSERT INTO answerboard VALUES
//        (bno_seq.nextval,
//                (SELECT gno FROM answerboard WHERE bno=1),
//        (SELECT gseq FROM answerboard WHERE bno=1) + 1,
//                (SELECT titletab FROM answerboard WHERE bno=1) + 2,
//                'Re : 첫번째 글', '1번 글의 답글', '유저2', current_date
//);

        String sql = "insert into answerboard values (bno_seq.nextval, ?, ?, ?, ?, ?, ?, current_date)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dto.getGno());
            ps.setInt(2, dto.getGseq());
            ps.setInt(3, dto.getTitletab());
            ps.setString(4, dto.getTitle());
            ps.setString(5, dto.getContent());
            ps.setString(6, dto.getWriter());
            res = ps.executeUpdate();
            if(res > 0) {
                commit(con);
            } else {
                rollback(con);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(con);
        }

        return res;
    }
}
