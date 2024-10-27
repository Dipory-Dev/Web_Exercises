package com.mvc.dao;

import com.mvc.dto.MyMVC;

import java.sql.Connection;
import java.util.List;

public interface MyMVCDao {

    String selectAllsql = "select * from mymvc order by seq desc";
    String selectOnesql = "select * from mymvc where seq = ?";
    String insertSql = "insert into mymvc values(seq_mymvc.nextval, ?, ?, ?, current_date)";
    String updateSql = "update mymvc set title = ?, content = ?, regdate =? where seq = ?";
    String deleteSql = "delete from mymvc where seq = ?";

    public List<MyMVC> selectAll(Connection con);
    public MyMVC selectOne(Connection con, int seq);
    public boolean insert(Connection con, MyMVC dto);
    public boolean update(Connection con, MyMVC dto);
    public boolean delete(Connection con, int seq);
}
