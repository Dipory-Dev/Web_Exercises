package com.mvc.service;

import com.mvc.dao.MyMVCDao;
import com.mvc.dao.MyMVCDaoImpl;
import com.mvc.dto.MyMVC;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class MyMVCServiceImpl implements MyMVCService{
    private MyMVCDao dao = new MyMVCDaoImpl();

    @Override
    public List<MyMVC> selectAll() {
        Connection con = getConnection();
        List<MyMVC> res = new ArrayList<>();

        res = dao.selectAll(con);
        close(con);
        return res;
    }

    @Override
    public MyMVC selectOne(int seq) {
        MyMVC res = new MyMVC();
        Connection con = getConnection();
        res = dao.selectOne(con, seq);
        close(con);
        return res;
    }

    @Override
    public boolean insert(MyMVC dto) {
        Connection con = getConnection();
        boolean res = false;
        res = dao.insert(con, dto);

        if (res) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return res;
    }

    @Override
    public boolean update(MyMVC dto) {
        Connection con = getConnection();
        boolean res = false;
        res = dao.update(con, dto);

        if (res) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return res;
    }

    @Override
    public boolean delete(int seq) {
        boolean res = false;
        Connection con = getConnection();
        res = dao.delete(con, seq);

        if (res) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return res;
    }
}
