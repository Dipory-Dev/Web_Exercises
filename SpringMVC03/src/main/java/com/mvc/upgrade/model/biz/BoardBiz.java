package com.mvc.upgrade.model.biz;

import com.mvc.upgrade.model.dto.BoardDto;

import java.util.List;

public interface BoardBiz {

    public List<BoardDto> selectList();
    public BoardDto selectOne(int myno);
    public void insert(BoardDto board);
    public void update(BoardDto board);
    public void delete(int myno);
}
