package Dao;

import entity.Brief;
import entity.Product;
import util.JDBCUtil;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BriefDao {

    public Integer update(Brief brief) {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句，？是占位符
        String sql = "update brief set brief = ? where id = ?";
        PreparedStatement statement = null;
        Integer result = null;

        try {
            statement = connection.prepareStatement(sql);
            // 为占位符赋值，第一个参数是第几个占位符，第二个参数是要赋的值
            statement.setString(1, brief.getText());
            statement.setInt(2, brief.getId());
            // 执行 SQL 语句, result 是执行结果，如果执行成功则 result 为 1
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        // 返回执行结果
        return result;
    }



}
