package com.boot.jdbc.model.biz;

import com.boot.jdbc.model.dto.MyDto;
import com.boot.jdbc.model.mapper.MyBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBizImpl implements MyBiz{

    @Autowired
    private MyBoardMapper mapper;

    @Override
    public List<MyDto> selectList() {
        return mapper.selectList();
    }

    @Override
    public MyDto selectOne(int myno) {
        return mapper.selectOne(myno);
    }

    @Override
    public int insert(MyDto dto) {
        return 0;
    }

    @Override
    public int update(MyDto dto) {
        return 0;
    }

    @Override
    public int delete(int myno) {
        return 0;
    }
}
