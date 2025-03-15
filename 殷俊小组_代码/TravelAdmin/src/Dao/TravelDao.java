package Dao;


import entity.Travel;
import util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TravelDao {
    public List<Travel> list() {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句
        String sql = "select id,title,time,content from travel";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        // 创建一个 List 集合用于存放查询结果
        List<Travel> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {//循环获取每个查询结果
                //获取查询结果中的各个字段值，括号里的字符串代表数据库中的字段名，你要获取哪个字段的值就填哪个字段名
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String time = resultSet.getString("time");
                String content = resultSet.getString("content");

                //将获取到的字段值封装到一个对象中，再将这个对象添加到 List 集合中
                list.add(new Travel(id, title, time, content));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        //返回查询结果list
        return list;
    }


    public Integer save(Travel travel){
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句，？是占位符
        String sql = "insert into travel (title,content,tupian) values(?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;

        try {
            statement = connection.prepareStatement(sql);
            // 为占位符赋值，第一个参数是第几个占位符，第二个参数是要赋的值
            statement.setString(1, travel.getTravelTime());
            statement.setString(2, travel.getTravelContent());
            statement.setString(3, "http://localhost:8081/springboot073x3/upload/note5.webp");

            result = statement.executeUpdate();//执行 SQL 语句，result 是执行结果，如果执行成功则 result 为 1
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        //返回执行结果
        return result;
    }

    public Integer update(Travel travel) {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句，？是占位符
        String sql = "update travel set title = ?,content = ? where id = ?";
        PreparedStatement statement = null;
        Integer result = null;

        try {
            statement = connection.prepareStatement(sql);
            // 为占位符赋值，第一个参数是第几个占位符，第二个参数是要赋的值
            statement.setString(1, travel.getTravelTime());
            statement.setString(2, travel.getTravelContent());
            statement.setInt(3, travel.getId());
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


    public Integer delete(Integer id) {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句
        String sql = "delete from travel where id = " + id;
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
