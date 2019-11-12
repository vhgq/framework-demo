package org.smart4j.framework.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;


public final class DatabaseHelper {

    private static Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);

    private static ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<>();

    public static void beginTransaction(){
        Connection conn = DBUtil.getConnection();
        if (conn != null){
            try {
                conn.setAutoCommit(false);
            }catch (SQLException e){
                LOGGER.error("begin transaction failure", e);
                throw new RuntimeException(e);
            }finally {
                CONNECTION_HOLDER.set(conn);
            }
        }
    }

    public static void commitTransaction(){
        Connection conn = DBUtil.getConnection();
        if (conn != null){
            try {
                conn.commit();
                conn.close();
            }catch (SQLException e){
                LOGGER.error("commit transaction failure", e);
                throw new RuntimeException(e);
            }finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }

    public static void rollbackTransaction(){
        Connection conn = DBUtil.getConnection();
        if (conn != null){
            try {
                conn.rollback();
                conn.close();
            }catch (SQLException e){
                LOGGER.error("rollback transaction failure", e);
                throw new RuntimeException(e);
            }finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }
}
