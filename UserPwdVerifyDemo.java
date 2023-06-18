import oracle.jdbc.driver.OracleDriver;
import java.sql.*;
import java.util.Scanner;
class UserPwdVerify
{
void verify() throws Exception
{
DriverManager.registerDriver(new OracleDriver());
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE","system","admin");
//accept username and password
Scanner s=new Scanner(System.in);
System.out.println("Enter your User Name");
String uname=s.nextLine();
System.out.println("Enter your Password");
String pwd=s.nextLine();
//prepare query
String sq="select * from userDet where uname=? and pwd=?";
PreparedStatement pst=conn.prepareStatement(sq);
pst.setString(1,uname);
pst.setString(2,pwd);
//execute query
ResultSet rs=pst.executeQuery();
if(rs.next())
{
System.out.println("Login Successful");
}
else
{
	System.out.println("Login Denied");
}
}//verify
}//UserPwdVerify---BLC

