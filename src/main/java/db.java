import java.sql.*;
import java.util.*;
public class db{
    public static void main(String args[]){
        try{
            Scanner scan = new Scanner(System.in);
            String Firstname = scan.nextLine();
            String Lastname = scan.nextLine();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbconnection","root","");
//here sonoo is database name, root is username and password
            String query = " insert into users (first_name, last_name)"
                    + " values (?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, Firstname);
            preparedStmt.setString (2, Lastname);


            preparedStmt.execute();
            ResultSet rs=preparedStmt.executeQuery("select * from users");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}