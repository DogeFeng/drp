package com.yootk.drp.dao.member_module;


import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.IBaseDAO;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.drp.vo.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface IMemberDAO extends IBaseDAO<String, Member> {
}
