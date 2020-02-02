


package com.util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBconn {
	static String url = "jdbc:mysql://localhost:3306/bishe1?&useSSL=false&serverTimezone=UTC";
	static String username = "root"; 
	static String password = ""; 
	static Connection  conn  ;
	static ResultSet rs  ;
	static PreparedStatement ps ;
	public static void init(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("success");
		} catch (Exception e) {
			System.out.println("init [SQL���������ʼ��ʧ�ܣ�]");
			e.printStackTrace();
		}
	}
	public static void prestate(String sql){
		try {
			
			PreparedStatement ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addColumn(String sql){
		try{
			Statement ps;
			ps=conn.createStatement();
			ps.execute(sql);
			
		}
		catch(SQLException e){
			System.out.println("sql�������ʧ��");
			e.printStackTrace();
		}
	}
	public static void insert(String sql){
		try{
			Statement ps;
			ps=conn.createStatement();
			ps.execute(sql);
			
		}
		catch(SQLException e){
			System.out.println("sql�������ʧ��");
			e.printStackTrace();
		}
	}
	public static  List<String> select(String sql,List<String> list){
	list=new ArrayList<String>();
		
		try{
			DBconn.init();
			 Statement Statement=conn.createStatement();
			rs=Statement.executeQuery(sql);
			ResultSetMetaData rsmd=rs.getMetaData();
			 int size=rsmd.getColumnCount();
	           for(int i=1;i<=size;i++)
	        	   {
	        	   list.add(rsmd.getColumnName(i));
	        
	           }
	           rs.close();
	             conn.close();
		}catch(SQLException e){
			System.out.println("sql���ݿ���ɾ���쳣");
			e.printStackTrace();
		}
		return list;
	}
	public static void createTable(String sql){
		try{
			
			Statement ps;
			ps=conn.createStatement();
			ps.execute(sql);
		}
		catch(SQLException e){
			System.out.println("sql���ݿⴴ��ʧ��");
			e.printStackTrace();
		}
	
	}
	public static int addUpdDel(String sql){
		int i = 0;
		try {
			PreparedStatement ps =  conn.prepareStatement(sql);
			i =  ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql���ݿ���ɾ���쳣");
			e.printStackTrace();
		}
		
		return i;
	}
	public static ResultSet selectSql(String sql){
		try {
			ps =  conn.prepareStatement(sql);
			rs =  ps.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("sql���ݿ��ѯ�쳣");
			e.printStackTrace();
		}
		return rs;
	}
	public static void closeConn(){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("sql���ݿ�ر��쳣");
			e.printStackTrace();
		}
	}
}

