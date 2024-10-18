package com.mvc.dao;


import com.mvc.dto.MVCBoardDto;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        SqlSession session = null;
        try {
            session = getSqlSessionFactory().openSession(false);
            res = session.insert(namespace + "insert", board);

            if (res > 0) {
                session.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }



        return res;
    }

    public int update (MVCBoardDto board) {
        int res = 0;
        SqlSession session = null;

        try {
            session = getSqlSessionFactory().openSession(false);
            res = session.update(namespace + "update", board);
            if (res > 0) {
                session.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return res;
    }

    public int delete(int seq) {
        int res = 0;
        SqlSession session = null;
        try {
            session = getSqlSessionFactory().openSession(false);
            res = session.delete(namespace + "delete", seq);
            if (res > 0) {
                session.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return res;
    }

    public int multiDelete(String[] seq) {
        int res = 0;
        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("seq", seq);
        SqlSession session = null;
        try {
            session = getSqlSessionFactory().openSession(false);
            res = session.delete(namespace + "muldel", map);
            if (res > 0) {
                session.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return res;
    }
}
