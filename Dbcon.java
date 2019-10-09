import java.sql.*;
public class Dbcon{
public static void main(String arg[])throws ClassNotFoundException,SQLException{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##gajanan","gajanan");
Statement stm=con.createStatement();
ResultSet rs=stm.executeQuery("select * from emp");
while(rs.next()){
System.out.println(rs.getString(2)+"\t"+rs.getString(3));
		}
		con.close();
	}

}
