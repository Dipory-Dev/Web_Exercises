package com.mvc.service;

import com.mvc.dto.MyMVC;

import java.util.List;

public interface MyMVCService {
    public List<MyMVC> selectAll();
    public MyMVC selectOne(int seq);
    public boolean insert(MyMVC dto);
    public boolean update(MyMVC dto);
    public boolean delete(int seq);

}
