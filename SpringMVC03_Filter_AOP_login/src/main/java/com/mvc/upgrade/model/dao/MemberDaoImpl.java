package com.mvc.upgrade.model.dao;

import com.mvc.upgrade.model.dto.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao{

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public MemberDto login(MemberDto dto) {
        MemberDto res = null;
        try {
            res = sqlSession.selectOne(NAMESPACE + "login", dto);
        } catch (Exception e) {
            System.out.println("[error] : Login Failed");
            e.printStackTrace();
        }

        return res;
    }
}
