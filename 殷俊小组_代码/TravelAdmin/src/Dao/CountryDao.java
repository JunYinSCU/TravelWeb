package Dao;

import entity.Country;
import util.JDBCUtil;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CountryDao
{
    public List<Country> list() {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句
        String sql = "select * from shengqu";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        // 创建一个 List 集合用于存放查询结果
        List<Country> list = new ArrayList<>();

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {//循环获取每个查询结果
                //获取查询结果中的各个字段值，括号里的字符串代表数据库中的字段名，你要获取哪个字段的值就填哪个字段名
                int id = resultSet.getInt("id");
                String shengqu = resultSet.getString("shengqu");
                //将获取到的字段值封装到一个 Country 对象中，再将这个对象添加到 List 集合中
                list.add(new Country(shengqu,id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        //返回查询结果list
        return list;
    }


    public Integer save(Country country) throws ParseException {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句，？是占位符
        String sql = "insert into shengqu(shengqu) values(?)";
        PreparedStatement statement = null;
        Integer result = null;

        try {
            statement = connection.prepareStatement(sql);
            // 为占位符赋值，第一个参数是第几个占位符，第二个参数是要赋的值
            statement.setString(1, country.getCountyName());
            result = statement.executeUpdate();//执行 SQL 语句，result 是执行结果，如果执行成功则 result 为 1
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        //返回执行结果
        return result;
    }

    public Integer update(Country country) {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句，？是占位符
        String sql = "UPDATE shengqu SET shengqu = ? WHERE id = ?";
        PreparedStatement statement = null;
        Integer result = null;

        try {
            statement = connection.prepareStatement(sql);
            // 为占位符赋值，第一个参数是第几个占位符，第二个参数是要赋的值
            statement.setString(1, country.getCountyName());
            statement.setInt(2, country.getId());
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


    public Integer delete(String shengqu) {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句
        String sql = "DELETE FROM shengqu WHERE shengqu = '" + shengqu + "'";
        PreparedStatement statement = null;
        Integer result = null;

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeUpdate();//执行 SQL 语句，result 是执行结果，如果执行成功则 result 为 1
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }
}
