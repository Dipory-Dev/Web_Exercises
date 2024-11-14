package com.boot.jdbc.model.mapper;

import com.boot.jdbc.model.dto.MyDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MyBoardMapper {

    @Select("select * from myboard order by myno desc")
    List<MyDto> selectList();

    @Select("select * from myboard where myno = #{myno}")
    MyDto selectOne(int myno);

    @Insert("insert into myboard values (seq_my.nextval, #{myname}, #{mytitle}, #{mycontent}, current_date)")
    int insert(MyDto dto);

    @Update("update myboard set mytitle = #{mytitle}, mycontent = #{mycontent} where myno = #{myno}")
    int update(MyDto dto);

    @Delete("delete from myboard where myno = #{myno}")
    int delete(int myno);
}
