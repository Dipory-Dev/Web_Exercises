package com.boot.jpa.model.dao;

import com.boot.jpa.model.entity.JpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaDao extends JpaRepository<JpaEntity, Integer> {

    public List<JpaEntity> findAll();

    public JpaEntity save(JpaEntity dao);
}
