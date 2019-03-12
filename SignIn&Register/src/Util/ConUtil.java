package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



//{
//   一点出现了这个 {}  不管是方法 还是流程控制语句（选择  循环） 都会出现一个叫做局部作用域的东西  在此声明的东西 作用范围仅仅限于当前的{}中 ，除了{} 就没有这个权限了
//}


//  工具类的创建  一般 就是为了完成默写需求 所以  一般工具类 使用的时候越简单越好  建议使用静态的
//  类的创建 要明确 当前类的描述（功能）  尽量  功能合理    这就是类的封装的原则
public class ConUtil {
    private static String  myDriverUrl = "com.mysql.cj.jdbc.Driver";
    private static String murl = "jdbc:mysql://localhost/demo?useSSL=FALSE&serverTimezone=UTC";
    private static String mName = "root";
    private static String mPwd = "950405";

    public static Connection openConection(){
        Connection	 connection = null;
        try {
            Class.forName(myDriverUrl);
            connection = DriverManager.getConnection(murl,mName,mPwd);
        } catch (Exception e) {
            e.printStackTrace();
//			当 上面的代码出现异常后  后续 根本就没有在执行的意义  抛出一个炸弹 炸掉该程序
            throw  new  RuntimeException("我把自己炸死了，你有我恨吗？");
        }
        return    connection;
//		 System.out.println("你是异常  你出现错误了  但是我执行不知想那？？？");
    }


    //关闭资源                                                      参数传递要关闭的资源
    public static  void  myclose(Connection connection ,Statement statement){
//		当前的 connerction 一定不是空吗  一定有引用值个他吗？    记住点  常识（习惯） 当关闭资源之前一定要进行判断空值操作

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//		但是  千万不要用if 。。。。else if。。。。。 语句进行关闭资源
    }
    //     方法的重载的操作
    public static  void  myclose(Connection connection){
        myclose(connection, null);
    }
    public static  void  myclose(Statement statement){
        myclose(null, statement);
    }

}










