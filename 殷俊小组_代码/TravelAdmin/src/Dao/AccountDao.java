package Dao;

import entity.Account;
import entity.Product;
import util.JDBCUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    public List<Account> list() {
        // 获取数据库连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "select id,youkezhanghao,youkexingming,xingbie,lianxifangshi,shenfenzheng,youxiang,is_banned from youke";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Account> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {//循环获取每个查询结果
                //获取查询结果中的各个字段值，括号里的字符串代表数据库中的字段名，你要获取哪个字段的值就填哪个字段名
                long id = resultSet.getLong("id");
                String youkezhanghao = resultSet.getString("youkezhanghao");
                String youkexingming = resultSet.getString("youkexingming");
                String xingbie = resultSet.getString("xingbie");
                String lianxifangshi = resultSet.getString("lianxifangshi");
                String shenfenzheng = resultSet.getString("shenfenzheng");
                String youxiang = resultSet.getString("youxiang");
                boolean is_banned = resultSet.getBoolean("is_banned");
                String is_bannedStr;
                if(is_banned) {
                    is_bannedStr="是";
                }
                else{
                    is_bannedStr="否";
                }
                //将获取到的字段值封装到一个 Account 对象中，再将这个对象添加到 List 集合中
                //System.out.println(id+" "+youkezhanghao+" "+youkexingming+" "+xingbie+" "+lianxifangshi+" "+shenfenzheng+" "+youxiang+" "+is_bannedStr);
                list.add(new Account(id, youkezhanghao, youkexingming, xingbie, lianxifangshi, shenfenzheng, youxiang,is_bannedStr));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        //返回查询结果list
        return list;
    }

    //检查黑名单中是否已存在该账号，有则返回true，无则返回false
    public boolean checkBan(String youkezhanghao) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "SELECT COUNT(*) FROM heimingdan WHERE youkezhanghao = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean isBanned = false;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, youkezhanghao);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isBanned = resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return isBanned;
    }
    public Integer ban(Long id, int type, String reason) {
        Connection connection = JDBCUtil.getConnection();
        String selectSql = "SELECT youkezhanghao FROM youke WHERE id = ?";
        String insertSql = "INSERT INTO heimingdan (youkezhanghao, fengjinyuanyin, bantype, bantime) VALUES (?, ?, ?, CURRENT_TIMESTAMP)";
        String updateSql = "UPDATE youke SET `is_banned` = 1 WHERE id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        CallableStatement callableStatement = null;
        Integer insertResult = null;
        Integer updateResult = null;

        try {
            // 获取用户账号
            statement = connection.prepareStatement(selectSql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            String youkezhanghao = null;
            if (resultSet.next()) {
                youkezhanghao = resultSet.getString("youkezhanghao");
                System.out.println("用户ID对应的账号为："+youkezhanghao);
            }
            if (youkezhanghao == null) {
                System.out.println("用户ID未找到，封禁失败。");
                return 0;
            }

            // 插入封禁记录
            statement.close();
            statement = connection.prepareStatement(insertSql);
            statement.setString(1, youkezhanghao);
            statement.setString(2, reason);
            statement.setInt(3, type);
            insertResult = statement.executeUpdate();
            System.out.println("插入操作已执行:"+insertResult);

            // 更新 youke 表中的封禁状态
            statement.close();
            statement = connection.prepareStatement(updateSql);
            statement.setLong(1, id);
            updateResult = statement.executeUpdate();
            System.out.println("更新操作已执行:"+updateResult);

            // 调用数据库存储过程
            callableStatement = connection.prepareCall("{CALL update_unbantime()}");
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return insertResult != null && insertResult > 0 && updateResult != null && updateResult > 0 ? 1 : 0;
    }

    public Integer unban(Long id) {
        Connection connection = JDBCUtil.getConnection();
        String selectSql = "SELECT youkezhanghao FROM youke WHERE id = ?";
        String deleteSql = "DELETE FROM heimingdan WHERE youkezhanghao = ?";
        String updateSql = "UPDATE youke SET `is_banned` = 0 WHERE id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer deleteResult = null;
        Integer updateResult = null;

        try {
            // 获取用户账号
            statement = connection.prepareStatement(selectSql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            String youkezhanghao = null;
            if (resultSet.next()) {
                youkezhanghao = resultSet.getString("youkezhanghao");
            }
            if (youkezhanghao == null) {
                System.out.println("用户ID未找到，解封失败。");
                return 0;
            }

            // 删除封禁记录
            resultSet.close();
            statement.close();
            statement = connection.prepareStatement(deleteSql);
            statement.setString(1, youkezhanghao);
            deleteResult = statement.executeUpdate();
            System.out.println("删除操作已执行:"+deleteResult);
            // 更新 youke 表中的封禁状态
            statement.close();
            statement = connection.prepareStatement(updateSql);
            statement.setLong(1, id);
            updateResult = statement.executeUpdate();
            System.out.println("更新操作已执行:"+updateResult);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return deleteResult != null && deleteResult > 0 && updateResult != null && updateResult > 0 ? 1 : 0;
    }

    //重置密码
    public Integer reset(Long id) {
        Connection connection = JDBCUtil.getConnection();
        String updateSql = "UPDATE youke SET mima = '123456' WHERE id = "+id;
        PreparedStatement statement = null;
        Integer result = null;
        try  {
            statement = connection.prepareStatement(updateSql);
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection,statement,null);
        }
        return result;
    }
}
