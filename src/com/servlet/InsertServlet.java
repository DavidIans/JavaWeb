package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
 




import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;
import com.servlet.*;
public class InsertServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String table = request.getParameter("table"); 
		String id = request.getParameter("key"); 
		
	
		
		List<String>list=new ArrayList<String>();
	UserDaoImpl us=new UserDaoImpl();
	for(int i=0;i< us.xiala(list,table).size();i++)
		     {
		String b=String.valueOf(i);
		String column=request.getParameter(b);
		String value=request.getParameter("value"+i);
		  us.insert(table, column ,value);
		  }
		
	  			request.setAttribute("xiaoxi","����ɹ�");  //��request���з��ò���
			//request.setAttribute("xiaoxi", "ע��ɹ�");
			request.getRequestDispatcher("/insert2.jsp").forward(request, response);  //ת������¼ҳ��
		
	}
	
	}

