package com.mvc.upgrade.model.dao;

import com.mvc.upgrade.model.dto.BoardDto;

import java.util.List;

public interface BoardDao {
    String NAMESPACE = "myboard.";

    public List<BoardDto> selectList();
    public BoardDto selectOne(int myno);
    public int insert(BoardDto board);
    public int update(BoardDto board);
    public int delete(int myno);
}
