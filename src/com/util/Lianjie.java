
package com.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dao.*;

public class Lianjie {
    public static void main(String[] args){
    // �������ݿ�����  com.mysql.jdbc.Driver
        String driver = "com.mysql.cj.jdbc.Driver";
        // ��ȡmysql���ӵ�ַ
       String url = "jdbc:mysql://localhost:3306/bishe1?&useSSL=false&serverTimezone=UTC";
        // ��������
       String username = "root";
        // ���ݿ�����
        String password = "";
        // ��ȡһ�����ݵ�����
        Connection conn = null;
        // ��ȡ���ӵ�һ��״̬
       
    	
        try{
            Class.forName(driver);
            //getConnection()����������MySQL���ݿ⣡
            conn=DriverManager.getConnection(url,username,password);
            if(!conn.isClosed())
            System.out.println("���ݿ����ӳɹ���");
             //����statement���������ִ��SQL��䣡
            Statement Statement=conn.createStatement();
            //Ҫִ�е�SQL���
            String sql="select * from user" ;
            //ResultSet�࣬������Ż�ȡ�Ľ������
            ResultSet rs=Statement.executeQuery(sql);
             System.out.println("-------------------------------");
             System.out.println("ִ�н��������ʾ:");  
             System.out.println("-------------------------------");  
             System.out.println("id" + "\t" + "name"+"\t"+"pwd"+"\t"+"sex");  
             System.out.println("-------------------------------");  
             String id=null;
             String name=null;
             String math=null;
             String chinese=null;
             while(rs.next()){
                //��ȡ��ѧ�š���������
                 id=rs.getString("id");
                 //��ȡ����������������
                name=rs.getString("name");
                //��ȡ����ѧ�ɼ�����������
                math=rs.getString("pwd");
                //��ȡ�����ĳɼ�����������
                chinese=rs.getString("sex");
                //������
                System.out.println(id+"\t"+name+"\t"+math+"\t"+chinese);
             }
           String qwe="���ʱ�";
           String shuxing="����";
           String sql1 = "alter TABLE `"+qwe+"` add column "+shuxing+" varchar(10)";
       
      //  Statement.execute(sql1);
        //UserDaoImpl ps=new UserDaoImpl();
       // ps.createtable(qwe);
          List<String>list=new ArrayList<String>();
           System.out.println("dfsf");
           rs=Statement.executeQuery("select * from "+qwe);
           ResultSetMetaData rsmd=rs.getMetaData();//�õ�Ԫ������
           int size=rsmd.getColumnCount();
           for(int i=1;i<=size;i++)
        	   {
        	   list.add(rsmd.getColumnName(i));
           System.out.print(list.get(i-1)+"\n");
           }
             rs.close();
             conn.close();
        }
         catch(ClassNotFoundException e){
             //���ݿ��������쳣����
        System.out.println("���ݿ���������ʧ�ܣ�");
        e.printStackTrace();
         }
        catch(SQLException e1){
        //���ݿ�����ʧ���쳣����
         e1.printStackTrace();
        }
        catch(Exception e2){
        e2.printStackTrace();
        }
        finally{
             System.out.println("-------------------------------");  
            System.out.println("���ݿ����ݻ�ȡ�ɹ���");
        }
        }
        }


