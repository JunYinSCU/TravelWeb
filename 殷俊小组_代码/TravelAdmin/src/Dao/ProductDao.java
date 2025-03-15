package Dao;


import entity.Product;
import util.JDBCUtil;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public List<Product> list() {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句
        String sql = "select id,jingdianmingcheng,jingdiandengji,jingdianjieshao,suozaishengqu,suozaichengshi,suozaidiqu,meitiankaifangshijian,meitianguanbishijian,beizhu,jiage from jingdianxinxi";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        // 创建一个 List 集合用于存放查询结果
        List<Product> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {//循环获取每个查询结果
                //获取查询结果中的各个字段值，括号里的字符串代表数据库中的字段名，你要获取哪个字段的值就填哪个字段名
                int id = resultSet.getInt("id");
                String jingdianmingcheng = resultSet.getString("jingdianmingcheng");
                String jingdiandengji = resultSet.getString("jingdiandengji");
                String jingdianjieshao = resultSet.getString("jingdianjieshao");
                String suozaishengqu = resultSet.getString("suozaishengqu");
                String suozaichengshi = resultSet.getString("suozaichengshi");
                String suozaidiqu = resultSet.getString("suozaidiqu");
                String meitiankaifangshijian = resultSet.getString("meitiankaifangshijian");
                String meitianguanbishijian = resultSet.getString("meitianguanbishijian");
                String beizhu = resultSet.getString("beizhu");
                String jiage = resultSet.getString("jiage");
                //将获取到的字段值封装到一个 Product 对象中，再将这个对象添加到 List 集合中
                list.add(new Product(id, jingdianmingcheng, jingdiandengji, jingdianjieshao, suozaishengqu, suozaichengshi, suozaidiqu, meitiankaifangshijian, meitianguanbishijian, beizhu, jiage));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        //返回查询结果list
        return list;
    }


    public Integer save(Product product) throws ParseException {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句，？是占位符
        String sql = "insert into jingdianxinxi(jingdianmingcheng,jingdiandengji,jingdianjieshao,suozaishengqu,suozaichengshi,suozaidiqu,meitiankaifangshijian,meitianguanbishijian,beizhu,jiage,tupian) values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        // 创建 SimpleDateFormat 对象，用于将日期字符串转换为 Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String meitiankaifangshijianStr = product.getMeitiankaifangshijian();
        String meitianguanbishijianStr = product.getMeitianguanbishijian();
        java.util.Date parsedStartDate = sdf.parse(meitiankaifangshijianStr);
        java.util.Date parsedEndDate = sdf.parse(meitianguanbishijianStr);
        // 将 Date 转换为 Timestamp
        Timestamp startTimestamp = new Timestamp(parsedStartDate.getTime());
        Timestamp endTimestamp = new Timestamp(parsedEndDate.getTime());

        try {
            statement = connection.prepareStatement(sql);
            // 为占位符赋值，第一个参数是第几个占位符，第二个参数是要赋的值
            statement.setString(1, product.getJingdianmingcheng());
            statement.setString(2, product.getJingdiandengji());
            statement.setString(3, product.getJingdianjieshao());
            statement.setString(4, product.getSuozaishengqu());
            statement.setString(5, product.getSuozaishiqu());
            statement.setString(6, product.getSuozaidiqu());
            statement.setTimestamp(7, startTimestamp);
            statement.setTimestamp(8, endTimestamp);
            statement.setString(9, product.getBeizhu());
            statement.setInt(10, Integer.parseInt(product.getJiage()));
            statement.setString(11, "http://localhost:8081/springboot073x3/upload/OIP-C.jpg");

            result = statement.executeUpdate();//执行 SQL 语句，result 是执行结果，如果执行成功则 result 为 1
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        //返回执行结果
        return result;
    }

    public Integer update(Product product) {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        // SQL 语句，？是占位符
        String sql = "update jingdianxinxi set jingdianmingcheng = ?,jingdiandengji = ?,jingdianjieshao = ?,suozaishengqu = ?,suozaichengshi = ?,suozaidiqu = ?,meitiankaifangshijian = ?,meitianguanbishijian = ?,beizhu = ?,jiage = ? where id = ?";
        PreparedStatement statement = null;
        Integer result = null;
        // 创建 SimpleDateFormat 对象，用于将日期字符串转换为 Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String meitiankaifangshijianStr = product.getMeitiankaifangshijian();
        String meitianguanbishijianStr = product.getMeitianguanbishijian();
        java.util.Date parsedStartDate = null;
        java.util.Date parsedEndDate;
        try {
            parsedStartDate = sdf.parse(meitiankaifangshijianStr);
            parsedEndDate = sdf.parse(meitianguanbishijianStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        // 将 Date 转换为 Timestamp
        Timestamp startTimestamp = new Timestamp(parsedStartDate.getTime());
        Timestamp endTimestamp = new Timestamp(parsedEndDate.getTime());
        try {
            statement = connection.prepareStatement(sql);
            // 为占位符赋值，第一个参数是第几个占位符，第二个参数是要赋的值
            statement.setString(1, product.getJingdianmingcheng());
            statement.setString(2, product.getJingdiandengji());
            statement.setString(3, product.getJingdianjieshao());
            statement.setString(4, product.getSuozaishengqu());
            statement.setString(5, product.getSuozaishiqu());
            statement.setString(6, product.getSuozaidiqu());
            statement.setTimestamp(7, startTimestamp);
            statement.setTimestamp(8, endTimestamp);
            statement.setString(9, product.getBeizhu());
            statement.setInt(10, Integer.parseInt(product.getJiage()));
            statement.setInt(11, product.getId());
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
        String sql = "delete from jingdianxinxi where id = " + id;
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
