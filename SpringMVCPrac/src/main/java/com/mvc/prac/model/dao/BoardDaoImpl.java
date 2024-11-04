package com.mvc.prac.model.dao;

import com.mvc.prac.model.dto.BoardDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDaoImpl implements BoardDao{

    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<BoardDto> selectList() {
        List<BoardDto> res = new ArrayList<BoardDto>();

        try {
            res = sqlSession.selectList(NAMESPACE + "selectList");
        } catch (Exception e) {
            System.out.println("[ERROR] : Select List Error");
            e.printStackTrace();
        }
        return res;
    }

    public BoardDto selectOne(String myno) {
        return null;
    }

    public int insert(BoardDto dto) {
        return 0;
    }

    public int update(BoardDto dto) {
        return 0;
    }

    public int delete(String myno) {
        return 0;
    }
}
