package com.mvc.rest.model.dao;

import com.mvc.rest.model.dto.RestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RestDaoImpl implements RestDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<RestDto> rowMapper = (rs, rowNum) -> {
        RestDto dto = new RestDto();
        dto.setRestno(rs.getInt(1));
        dto.setRestid(rs.getString(2));
        dto.setRestpw(rs.getString(3));
        dto.setRestname(rs.getString(4));
        return dto;
    };

    @Override
    public List<RestDto> selectAll() {
        List<RestDto> res = new ArrayList<RestDto>();
        String sql = "select * from restboard";
        res = jdbcTemplate.query(sql, rowMapper);
        return res;
    }

    @Override
    public RestDto selectOne(int restno) {
        String sql = "select * from restboard where restno = ?";
        RestDto res = jdbcTemplate.queryForObject(sql, rowMapper, restno);
        return res;
    }

    @Override
    public int insert(RestDto dto) {
        String sql = "insert into restboard values(seq_rest.nextval, ?,?,?)";
        int res = jdbcTemplate.update(sql, dto.getRestid(), dto.getRestpw(), dto.getRestname());
        return res;
    }

    @Override
    public int update(RestDto dto) {
        String sql = "update restboard set restpw = ? where restno=?";
        int res = jdbcTemplate.update(sql, dto.getRestpw(), dto.getRestno());
        return res;
    }

    @Override
    public int delete(int restno) {
        String sql = "delete from restboard where restno=?";
        int res = jdbcTemplate.update(sql, restno);
        return res;
    }
}
