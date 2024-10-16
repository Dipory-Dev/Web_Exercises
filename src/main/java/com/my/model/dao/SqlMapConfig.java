package com.my.model.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlMapConfig {

    private SqlSessionFactory sqlSessionFactory;

    public SqlSessionFactory getSqlSessionFactory() {

//      Config.xml 경로
        String resource = "db/Config.xml";
//      Config.xml 파일정보 읽기
        try {
            Reader reader = Resources.getResourceAsReader(resource);

//          읽어온 정보를 가지고 SqlSessionFactory 객체 생성
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sqlSessionFactory;
    }
}
