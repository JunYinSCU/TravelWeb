package Dao;


import entity.News;
import entity.Travel;
import util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {
    public List<News> list() {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句
        String sql = "select id,title,introduction,content,addtime from news";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        // 创建一个 List 集合用于存放查询结果
        List<News> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {//循环获取每个查询结果
                //获取查询结果中的各个字段值，括号里的字符串代表数据库中的字段名，你要获取哪个字段的值就填哪个字段名
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String introduction = resultSet.getString("introduction");
                String content = resultSet.getString("content");
                String addTime = resultSet.getString("addtime");

                //将获取到的字段值封装到一个对象中，再将这个对象添加到 List 集合中
                list.add(new News(id, title, introduction, content, addTime));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        //返回查询结果list
        return list;
    }


    public Integer save(News news){
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句，？是占位符
        String sql = "insert into news (title,introduction,content,picture) values(?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;

        try {
            statement = connection.prepareStatement(sql);
            // 为占位符赋值，第一个参数是第几个占位符，第二个参数是要赋的值
            statement.setString(1, news.getTitle());
            statement.setString(2, news.getIntroduction());
            statement.setString(3, news.getContent());
            statement.setString(4, "http://localhost:8081/springboot073x3/upload/gonggao.webp");

            result = statement.executeUpdate();//执行 SQL 语句，result 是执行结果，如果执行成功则 result 为 1
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        //返回执行结果
        return result;
    }

    public Integer update(News news) {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句，？是占位符
        String sql = "update news set title = ?,introduction = ?, content = ?,addtime = ? where id = ?";
        PreparedStatement statement = null;
        Integer result = null;

        try {
            statement = connection.prepareStatement(sql);
            // 为占位符赋值，第一个参数是第几个占位符，第二个参数是要赋的值
            statement.setString(1, news.getTitle());
            statement.setString(2, news.getIntroduction());
            statement.setString(3, news.getContent());
            statement.setString(4, news.getAddTime());
            statement.setInt(5, news.getId());
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


    public Integer delete(int id) {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句
        String sql = "delete from news where id = " + id;
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
