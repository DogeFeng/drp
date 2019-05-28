package com.yootk.drp.dao.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.drp.dao.IMemberDAO;
import org.junit.Test;

import java.sql.SQLException;

public class MemberDAOImplTest {
    @Autowired
    private IMemberDAO memberDAO ;

   private IMemberDAO impl = new MemberDAOImpl();


    @Test
    public void findById() {
        try {
            System.out.println(this.impl.findById("yootk1"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}