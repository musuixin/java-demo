package mysql;


import Util.CheckStrUtil;
import Util.ConUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @date 2018.12.24
 * @author musuixin1
 */
public class Check {

    public static boolean login(String name,String pwd){
         int[] ints=new int[10];
        Connection conn = ConUtil.openConection();
        boolean yz=false;
        name= CheckStrUtil.getStringNoBlank(name);
        pwd= CheckStrUtil.getStringNoBlank(pwd);
        try {
            PreparedStatement pr = conn.prepareStatement("select * from user where uname=? and upwd=?");
            System.out.println(name);
            pr.setString(1, name);
            pr.setString(2, pwd);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                yz=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ConUtil.myclose(conn);
        return yz;
    }
    public static boolean register(String uname,String upwd,String email){
        Connection conn = ConUtil.openConection();
        uname=CheckStrUtil.getStringNoBlank(uname);
        upwd=CheckStrUtil.getStringNoBlank(upwd);
        email=CheckStrUtil.getStringNoBlank(email);
        System.out.println(uname);
        try {
            PreparedStatement pr = conn.prepareStatement("insert into user(uname,upwd,email) values (?,?,?)");
            pr.setString(1, uname);
            pr.setString(2, upwd);
            pr.setString(3, email);
            pr.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        finally {
            ConUtil.myclose(conn);
        }
        return true;
    }
    public static  boolean uname(String uname){
        Connection conn = ConUtil.openConection();
        uname=CheckStrUtil.getStringNoBlank(uname);
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select * from user where uname=?");
            preparedStatement.setString(1,uname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConUtil.myclose(conn);
        }

            return false;
    }
}
