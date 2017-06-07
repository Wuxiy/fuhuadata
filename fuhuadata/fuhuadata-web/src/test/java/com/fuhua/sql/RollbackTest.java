package com.fuhua.sql;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <p>User: wangjie
 * <p>Date: 5/31/2017
 */
public class RollbackTest {

    @Test
    public void testMysqlRollback() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://192.168.30.120:3306/fuhuadata?useUnicode=true&characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull",
                "root", "root");

        try {
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `s_factory` SET `abbr`='测试南通' WHERE `id`=2");

            stmt.close();
            throw new RuntimeException("fie");
//            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
        } finally {
            con.setAutoCommit(true);
            con.close();
        }
    }
}
