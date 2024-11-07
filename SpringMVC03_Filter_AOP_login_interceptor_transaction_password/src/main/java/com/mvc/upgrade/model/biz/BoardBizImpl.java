package com.mvc.upgrade.model.biz;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardBizImpl implements BoardBiz{

    @Autowired
    private BoardDao dao;

    @Override
    public List<BoardDto> selectList() {
        List<BoardDto> list = dao.selectList();
        return list;
    }

    @Override
    public BoardDto selectOne(int myno) {
        BoardDto dto = dao.selectOne(myno);
        return dto;
    }

    @Override
    public int insert(BoardDto board) {
        int res = dao.insert(board);
        return res;
    }

    @Override
    public int update(BoardDto board) {
        int res = dao.update(board);
        return res;
    }

    @Override
    public int delete(int myno) {
        int res = dao.delete(myno);
        return res;
    }

    @Override
    @Transactional
    public String test() {
        dao.insert(new BoardDto(0, "transaction1", "test", "insert", null));
        String test = dao.test();
        test.length();
        return null;
    }

}
