package Dao;

import entity.Order;
import entity.Product;
import util.JDBCUtil;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public List<Order> list() {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句
        String sql = "select id,youkezhanghao,lianxifangshi,shenfenzheng,jingdianmingcheng,piaoshu,zongjine,goupiaoshijian from jingdiangoupiaodingdan";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        // 创建一个 List 集合用于存放查询结果
        List<Order> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {//循环获取每个查询结果
                //获取查询结果中的各个字段值，括号里的字符串代表数据库中的字段名，你要获取哪个字段的值就填哪个字段名
                long id = resultSet.getLong("id");
                String youkezhanghao = resultSet.getString("youkezhanghao");
                String lianxifangshi = resultSet.getString("lianxifangshi");
                String shenfenzheng = resultSet.getString("shenfenzheng");
                String jingdianmingcheng = resultSet.getString("jingdianmingcheng");
                int piaoshu = resultSet.getInt("piaoshu");
                String zongjine = resultSet.getString("zongjine");
                String goupiaoshijian = resultSet.getString("goupiaoshijian");

                //将获取到的字段值封装到一个 Order 对象中，再将这个对象添加到 List 集合中
                list.add(new Order(id, youkezhanghao, lianxifangshi, shenfenzheng, jingdianmingcheng, piaoshu, zongjine, goupiaoshijian));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        //返回查询结果list
        return list;
    }


    public Integer save(Order order) throws ParseException {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句，？是占位符
        String sql = "insert into jingdiangoupiaodingdan(youkezhanghao,lianxifangshi,shenfenzheng,jingdianmingcheng,piaoshu,zongjine,goupiaoshijian) values(?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        // 创建 SimpleDateFormat 对象，用于将日期字符串转换为 Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String goupiaoshijianStr = order.getGoupiaoshijian();
        java.util.Date parsedDate = sdf.parse(goupiaoshijianStr);
        // 将 Date 转换为 Timestamp
        Timestamp goupiaoshijianTimestamp = new Timestamp(parsedDate.getTime());

        try {
            statement = connection.prepareStatement(sql);
            // 为占位符赋值，第一个参数是第几个占位符，第二个参数是要赋的值
            statement.setString(1, order.getYoukezhanghao());
            statement.setString(2, order.getLianxifangshi());
            statement.setString(3, order.getShenfenzheng());
            statement.setString(4, order.getJingdianmingcheng());
            statement.setInt(5, order.getPiaoshu());
            statement.setString(6, order.getZongjine());
            statement.setTimestamp(7, goupiaoshijianTimestamp);

            result = statement.executeUpdate();//执行 SQL 语句，result 是执行结果，如果执行成功则 result 为 1
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        //返回执行结果
        return result;
    }

    public Integer update(Order order) {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句，？是占位符
        String sql = "update jingdiangoupiaodingdan set youkezhanghao = ?,lianxifangshi = ?,shenfenzheng = ?,jingdianmingcheng = ?,piaoshu = ?,zongjine = ?,goupiaoshijian = ? where id = ?";
        PreparedStatement statement = null;
        Integer result = null;
        // 创建 SimpleDateFormat 对象，用于将日期字符串转换为 Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String goupiaoshijianStr = order.getGoupiaoshijian();
        java.util.Date parsedDate = null;
        try {
            parsedDate = sdf.parse(goupiaoshijianStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        // 将 Date 转换为 Timestamp
        Timestamp goupiaoshijianTimestamp = new Timestamp(parsedDate.getTime());

        try {
            statement = connection.prepareStatement(sql);
            // 为占位符赋值，第一个参数是第几个占位符，第二个参数是要赋的值
            statement.setString(1, order.getYoukezhanghao());
            statement.setString(2, order.getLianxifangshi());
            statement.setString(3, order.getShenfenzheng());
            statement.setString(4, order.getJingdianmingcheng());
            statement.setInt(5, order.getPiaoshu());
            statement.setString(6, order.getZongjine());
            statement.setTimestamp(7, goupiaoshijianTimestamp);
            statement.setLong(8, order.getId());
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


    public Integer delete(Long id) {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句
        String sql = "delete from jingdiangoupiaodingdan where id = " + id;
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
