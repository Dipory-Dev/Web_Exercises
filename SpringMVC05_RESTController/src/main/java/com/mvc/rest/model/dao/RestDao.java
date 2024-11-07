package com.mvc.rest.model.dao;

import com.mvc.rest.model.dto.RestDto;

import java.util.List;

public interface RestDao {
    public List<RestDto> selectAll();
    public RestDto selectOne(int restno);
    public int insert(RestDto dto);
    public int update(RestDto dto);
    public int delete(int restno);
}
