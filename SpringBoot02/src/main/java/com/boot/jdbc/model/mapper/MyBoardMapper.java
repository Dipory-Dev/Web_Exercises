package com.boot.jdbc.model.mapper;

import com.boot.jdbc.model.dto.MyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyBoardMapper {

    @Select("select * from myboard order by myno desc")
    List<MyDto> selectList();

    @Select("select * from myboard where myno = ${myno}")
    MyDto selectOne(int myno);
    int insert(MyDto dto);
    int update(MyDto dto);
    int delete(int myno);
}
