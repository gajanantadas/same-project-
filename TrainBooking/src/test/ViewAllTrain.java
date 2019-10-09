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

public class ViewAllTrain extends GenericServlet {
	public Connection con;
	public void init()throws ServletException{
		con=DBConnection.getCon();
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<html><body>");
		try {
			PreparedStatement ps=con.prepareStatement("select * from Train1");
			ResultSet rs=ps.executeQuery();
			 pw.println("<table border=2 width=30% height=30% bordercolor=red bgcolor=lightgreen >");
             pw.println("<tr><th>TrainNo</th><th>TrainName</th><th>Fstation</th><th>lstation</th><th>Availabiity</th><tr>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req,res);
			while(rs.next()) {
				pw.println("<br> <tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)+ "</td><td>"+ rs.getString(4) +"</td><td>"+ rs.getInt(5) +"</td></tr>"); 
				}
			pw.println("</table>");
            pw.println("</html></body>"); 
		}catch(Exception e) {}
}

}
