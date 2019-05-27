package com.yootk.common.dbc;

import static org.junit.Assert.*;

public class DatabaseConnectionTest {

    @org.junit.Test
    public void getConnection() {
        System.out.println(DatabaseConnection.getConnection());
    }
}