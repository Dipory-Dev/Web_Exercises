package com.boot.crud.model.biz;

import com.boot.crud.model.dto.CRUDDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUDDaoImpl {
    private final CRUDDao dao;

    public CRUDDaoImpl(CRUDDao dao) {
        this.dao = dao;
    }

    public List<CRUDDto> getAll() {
        return dao.findAll();
    }

    public CRUDDto getOne(int seq) {
        return dao.getOne(seq);
    }

    public CRUDDto insert(CRUDDto dto) {
        return dao.save(dto);
    }

    public CRUDDto update(CRUDDto dto) {
        return dao.save(dto);
    }

    public void delete(int seq) {
        dao.deleteById(seq);
    }
}
