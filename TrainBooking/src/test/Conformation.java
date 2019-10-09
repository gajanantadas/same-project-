package test;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class Conformation extends GenericServlet {
	public void init()throws ServletException{
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	String fname=req.getParameter("fname");
	int age=Integer.parseInt(req.getParameter("age"));
	String rc=req.getParameter("rc");
	String fstation=req.getParameter("fstation");
	String dstation=req.getParameter("dstation");
	Float tc=Float.parseFloat(req.getParameter("tc"));
	pw.println("<br>passengername:" +fname);
	pw.println("<br>passengerAge:" +age);
	pw.println("<br>ReservationChoice: "+rc);
	pw.println("<br>firstStation:"+fstation);
	pw.println("<br>dstation:"+dstation);
	pw.println("<br>TicketCharge:"+tc);
	}
	public void destroy() {	
	}
}
