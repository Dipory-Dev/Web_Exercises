package com.mvc.upgrade.model.dao;

import com.mvc.upgrade.model.dto.BoardDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDaoImpl implements BoardDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<BoardDto> selectList() {
        List<BoardDto> list = new ArrayList<BoardDto>();

        try {
            list = sqlSession.selectList(NAMESPACE + "selectList");
        } catch (Exception e) {
            System.out.println("[Error] : Select List Error");
            e.printStackTrace();
        }

        return list;
    }
    @Override
    public BoardDto selectOne(int myno) {
        BoardDto dto = null;
        try {
            dto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
        } catch (Exception e) {
            System.out.println("[Error] : Select List Error");
            e.printStackTrace();
        }
        return dto;
    }

    @Override
    public int insert(BoardDto board) {
        int res = 0;

        try {
            res = sqlSession.insert(NAMESPACE + "insert", board);
        } catch (Exception e) {
            System.out.println("[Error] : Insert Error");
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int update(BoardDto board) {
        return 0;
    }

    @Override
    public int delete(int myno) {
        return 0;
    }
}
