package com.boot.crud.model.biz;

import com.boot.crud.model.dto.CRUDDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRUDDao extends JpaRepository<CRUDDto, Integer> {
}
