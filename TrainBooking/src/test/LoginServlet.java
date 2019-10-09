package test;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class LoginServlet extends GenericServlet {
	public Connection con;
	public void init()throws ServletException{
		con=DBConnection.getCon();
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uname=req.getParameter("uname");
		String pword=req.getParameter("pword");
		try {
			PreparedStatement ps=con.prepareStatement("Select * from userreg1 where uname=? and pword=?");
			ps.setString(1,uname);
			ps.setString(2, pword);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				pw.println("welcome to OnlineTrain <b>:" +rs.getString(3));
				pw.println("<br>");
				RequestDispatcher rd=req.getRequestDispatcher("link.html");
				rd.include(req, res);
			}else {
				pw.println("invalid uname or password plze Re Enter correct user name or password");
				RequestDispatcher rd=req.getRequestDispatcher("Login.html");
				rd.include(req, res);
			}
		}catch(Exception e) {}
		}
}
