package test;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class AddTrain extends GenericServlet {
	public Connection con;
	public void init()throws ServletException{
		con=DBConnection.getCon();
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Long trainno=Long.parseLong(req.getParameter("trainno"));
		String tname=req.getParameter("tname");
		String fstation=req.getParameter("fstation");
		String lstation=req.getParameter("tstation");
		int availability=Integer.parseInt(req.getParameter("availability"));
		try {
			PreparedStatement ps=con.prepareStatement("insert into train1 values(?,?,?,?,?)");
			ps.setLong(1,trainno);
			ps.setString(2, tname);
			ps.setString(3,fstation);
			ps.setString(4, lstation);
			ps.setInt(5, availability);
			int k=ps.executeUpdate();
			if(k>0)
			{
				pw.println("Add train in to the database table....");
				RequestDispatcher rd=req.getRequestDispatcher("ViewTrain.html");
				rd.include(req,res);
			}
		}catch(Exception e) {
			
		}

}

}
