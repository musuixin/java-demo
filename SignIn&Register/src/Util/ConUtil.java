package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



//{
//   һ���������� {}  �����Ƿ��� �������̿�����䣨ѡ��  ѭ���� �������һ�������ֲ�������Ķ���  �ڴ������Ķ��� ���÷�Χ�������ڵ�ǰ��{}�� ������{} ��û�����Ȩ����
//}


//  ������Ĵ���  һ�� ����Ϊ�����Ĭд���� ����  һ�㹤���� ʹ�õ�ʱ��Խ��Խ��  ����ʹ�þ�̬��
//  ��Ĵ��� Ҫ��ȷ ��ǰ������������ܣ�  ����  ���ܺ���    �������ķ�װ��ԭ��
public class ConUtil {
    private static String  myDriverUrl = "com.mysql.cj.jdbc.Driver";
    private static String murl = "jdbc:mysql://localhost/demo?useSSL=FALSE&serverTimezone=UTC";
    private static String mName = "root";
    private static String mPwd = "******";

    public static Connection openConection(){
        Connection	 connection = null;
        try {
            Class.forName(myDriverUrl);
            connection = DriverManager.getConnection(murl,mName,mPwd);
        } catch (Exception e) {
            e.printStackTrace();
//			�� ����Ĵ�������쳣��  ���� ������û����ִ�е�����  �׳�һ��ը�� ը���ó���
            throw  new  RuntimeException("�Ұ��Լ�ը���ˣ������Һ���");
        }
        return    connection;
//		 System.out.println("�����쳣  ����ִ�����  ������ִ�в�֪���ǣ�����");
    }


    //�ر���Դ                                                      ��������Ҫ�رյ���Դ
    public static  void  myclose(Connection connection ,Statement statement){
//		��ǰ�� connerction һ�����ǿ���  һ��������ֵ������    ��ס��  ��ʶ��ϰ�ߣ� ���ر���Դ֮ǰһ��Ҫ�����жϿ�ֵ����

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
//		����  ǧ��Ҫ��if ��������else if���������� �����йر���Դ
    }
    //     ���������صĲ���
    public static  void  myclose(Connection connection){
        myclose(connection, null);
    }
    public static  void  myclose(Statement statement){
        myclose(null, statement);
    }

}










