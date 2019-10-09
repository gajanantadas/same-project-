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
public class ViewTrain extends GenericServlet {
	public Connection con;
	public void init()throws ServletException{
		con=DBConnection.getCon();
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Long  trainno=Long.parseLong(req.getParameter("trainno"));
		try {
			PreparedStatement ps=con.prepareStatement("select * from Train1 where trainno=?");
			ps.setLong(1, trainno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd=req.getRequestDispatcher("link.html");
				rd.include(req,res);
				pw.println("<br>trainno: "+rs.getLong(1));
				pw.println("<br>trainname: "+rs.getString(2));
				pw.println("<br>FirstStation :"+rs.getString(3));
				pw.println("<br>Laststation :"+rs.getString(4));
				pw.println("<br>Availability :"+rs.getInt(5));
			}
			else{
				pw.println("Invalid TrainNo plze Re Enter TrainNo");
				RequestDispatcher rd=req.getRequestDispatcher("ViewTrain.html");
				rd.include(req, res);
			}
		}catch(Exception e) {}
}

}
