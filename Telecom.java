import java.io.*;
import java.sql.*;
import java.servlet.*;
import java.servlet.http.*;
public class Telecom extends HTTPServlet
{
 public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
try{
class.forName("com.jdbc.mysql.driver);
Connection con=DriverManager.getConnection(jdbc:mysql://localhost:3306/mysql/plandb,"root","mysql");//establishing database connection
Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from plandb");//plandb is a database table where plan details are presnted.
out.println("<table border=1 width=50% height=50%>");
             out.println("<tr><th>planname</th><th>monthlyrental</th><th>freeinternet</th><th>freecalls</th><th>freesms</th><th>callcharges</th><th>smscharges</th><th>datacharges</th><th>roamingcharges</th><tr>");
             while (rs.next()) {
                 String pn = rs.getString("planname");
                   String mr = rs.getString("monthlyrental");
                    String fi = rs.getString("freeinternet");
  String fc= rs.getString("freecalls");
  String fs= rs.getString("freesms");
  String cc= rs.getString("callcharges");
  String sc= rs.getString("smscharges");
   String dc= rs.getString("datacharges");
     String rc= rs.getString("roamingcharges");
               
                 out.println("<tr><td>" +  pn+ "</td><td>" + mr + "</td><td>" + fi+ "</td><td>" + fc+ "</td><td>" + fs+ "</td><td>" + cc+ "</td><td>" + sc+ "</td><td>" + dc+ "</td><td>" + rc+ "</td></tr>"); 
             
             out.println("</table>");
             out.println("</html></body>");//printing the fetched plan details
             con.close();
            }
             catch (Exception e) {
             out.println("error");
         }
     }
 
 