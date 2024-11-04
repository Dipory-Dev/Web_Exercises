package com.mvc.prac.model.biz;

import com.mvc.prac.model.dao.BoardDao;
import com.mvc.prac.model.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardBizImpl implements BoardBiz{

    @Autowired
    private BoardDao dao;

    public List<BoardDto> selectList() {
        List<BoardDto> res = dao.selectList();
        return res;
    }

    public BoardDto selectOne(int myno) {
        return null;
    }

    public int insert(BoardDto dto) {
        return 0;
    }

    public int update(BoardDto dto) {
        return 0;
    }

    public int delete(int myno) {
        return 0;
    }
}
