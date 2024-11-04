package com.mvc.prac.model.dao;

import com.mvc.prac.model.dto.BoardDto;

import java.util.List;

public interface BoardDao {
    String NAMESPACE = "myboard.";

    public List<BoardDto> selectList();
    public BoardDto selectOne(String myno);
    public int insert(BoardDto dto);
    public int update(BoardDto dto);
    public int delete(String myno);
}
