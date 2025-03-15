package Dao;

import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    public boolean[] adminLogin(String admin_name, String password) {
        boolean[] results = new boolean[2];
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean is_username = false;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, admin_name);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                is_username = resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        results[0] = is_username;
        //该管理员存在
        if (is_username) {
            String passwordSql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
            try {
                statement = connection.prepareStatement(passwordSql);
                statement.setString(1, admin_name);
                statement.setString(2, password);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    results[1] = resultSet.getInt(1) > 0;  // 如果密码正确，则设置为true
                }
        }catch(SQLException e) {
                e.printStackTrace();
    }finally {
                JDBCUtil.release(connection, statement, resultSet);
            }
        }
        return results;
    }


    /*public boolean[] userLogin(String user_name, String password) {
        boolean[] results = new boolean[2];
        Connection connection = JDBCUtil.getConnection();
        String sql = "SELECT COUNT(*) FROM youke WHERE youkezhanghao = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean is_username = false;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user_name);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                is_username = resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        results[0] = is_username;
        //该用户存在
        if (is_username) {
        //此处可添加检测封禁状态
            String passwordSql = "SELECT COUNT(*) FROM youke WHERE youkezhanghao = ? AND mima = ?";
            try {
                statement = connection.prepareStatement(passwordSql);
                statement.setString(1, user_name);
                statement.setString(2, password);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    results[1] = resultSet.getInt(1) > 0;  // 如果密码正确，则设置为true
                }
            }catch(SQLException e) {
                e.printStackTrace();
            }finally {
                JDBCUtil.release(connection, statement, resultSet);
            }
        }
        return results;
    }*/
}
