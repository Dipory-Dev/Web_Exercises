package com.mvc.dao;


import com.mvc.dto.MVCBoardDto;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;


public class MVCBoardDao extends SqlMapConfig {

    private String namespace = "com.mvc.";

    public List<MVCBoardDto> selectAll() {
        List<MVCBoardDto> res = new ArrayList<>();
        SqlSession session = null;

        try {
            session = getSqlSessionFactory().openSession(true);
            res = session.selectList(namespace + "selectAll");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return res;
    }

    public MVCBoardDto selectOne(int seq) {
        MVCBoardDto res = null;
        SqlSession session = null;
        try {
            session = getSqlSessionFactory().openSession(false);
            res = session.selectOne(namespace + "selectOne", seq);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }


        return res;
    }

    public int insert(MVCBoardDto board) {
        int res = 0;

        return res;
    }

    public int update (MVCBoardDto board) {
        int res = 0;

        return res;
    }

    public int delete(int seq) {
        int res = 0;

        return res;
    }
}
