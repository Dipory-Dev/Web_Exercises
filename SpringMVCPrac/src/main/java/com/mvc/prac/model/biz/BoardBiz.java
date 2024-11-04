package com.mvc.prac.model.biz;

import com.mvc.prac.model.dto.BoardDto;

import java.util.List;

public interface BoardBiz {
    public List<BoardDto> selectList();
    public BoardDto selectOne(int myno);
    public int insert(BoardDto dto);
    public int update(BoardDto dto);
    public int delete(int myno);
}
