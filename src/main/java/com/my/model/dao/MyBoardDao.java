package com.my.model.dao;

import com.my.model.dto.MyBoard;
import org.apache.ibatis.session.SqlSession;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyBoardDao extends SqlMapConfig{

    public List<MyBoard> selectAll() {
        List<MyBoard> res = new ArrayList<>();
        SqlSession session = null;

        session = getSqlSessionFactory().openSession(true);
        res = session.selectList("com.my.model.dao.MyBoardDao.selectAll");

        session.close();
        return res;
    }

    public MyBoard selectOne(int myno) {
        MyBoard res = new MyBoard();
        SqlSession session = null;

        session = getSqlSessionFactory().openSession(true);
        res = session.selectOne("com.my.model.dao.MyBoardDao.selectOne", myno);


        return res;
    }


    public int insert(MyBoard dto) {
        int res = 0;
        SqlSession session = null;
        session = getSqlSessionFactory().openSession(true);
        res = session.insert("com.my.model.dao.MyBoardDao.insert", dto);

        return res;
    }

    public int update(MyBoard dto) {
        int res = 0;


        return res;
    }

    public int delete(int myno) {
        int res = 0;


        return res;
    }
}
