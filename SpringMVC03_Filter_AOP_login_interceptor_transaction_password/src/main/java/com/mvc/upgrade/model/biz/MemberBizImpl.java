package com.mvc.upgrade.model.biz;

import com.mvc.upgrade.model.dao.MemberDao;
import com.mvc.upgrade.model.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberBizImpl implements MemberBiz{

    @Autowired
    private MemberDao dao;

    @Override
    public MemberDto login(MemberDto dto) {
        return dao.login(dto);
    }

    @Override
    public int insert(MemberDto dto) {
        return dao.insert(dto);
    }
}
