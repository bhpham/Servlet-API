package net.mv.week2.Servlet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import net.mv.week2.util.ConnectionUtil;

public class DSServlet extends HttpServlet {
	
	@Resource(name="jdbc/oracle10g")
	private DataSource ds;

	@Override
	public void init() throws ServletException {
		ConnectionUtil util = ConnectionUtil.getConnectionUtil();
		util.setDataSource(ds);
	} 
}
