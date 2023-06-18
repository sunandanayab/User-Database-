//UserRegisterDemo.java
import java.sql.*;
import java.util.Scanner;
class UserRegister
{
void register() throws Exception
{
   Class.forName("oracle.jdbc.driver.OracleDriver");
   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE","system","admin");
  //Step-1
 String dq="insert into userDet values(?,?)";
 PreparedStatement pst=conn.prepareStatement(dq);
 //Step-2
 Scanner s=new Scanner(System.in);
 System.out.println("Enter your Username");
 String uname=s.nextLine();
 System.out.println("Enter your password");
 String pwd=s.nextLine();
 pst.setString(1,uname);
 pst.setString(2,pwd);
 //Step-3
 int res=pst.executeUpdate();
 System.out.println("\t" +res+ "record is updated -----verify");
 }
}
class UserRegistration
{
	public static void main(String[] args) throws Exception
	{
     UserRegister ud=new UserRegister();
         ud.register();
	}
}//UserRegisterDemo--ELC
