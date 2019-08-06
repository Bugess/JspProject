package statmentAndPrepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
  
public class statmentAndPrepareStatement {
    public static void main(String[] args) {
  
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
  
        String sql = "insert into hero values(?,?,?,?)";
        Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "0404094");
            PreparedStatement ps = c.prepareStatement(sql);
        
            // Statement需要进行字符串拼接，可读性和维修性比较差
            //Statement s = c.createStatement();
            //String sql0 = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
            //s.execute(sql0);
  
            // PreparedStatement 使用参数设置，可读性好，不易犯错
            ps.setInt(1, 6);
            ps.setString(2, "提莫");
            ps.setFloat(3, 313.0f);
            ps.setInt(4, 50);
            
            int count = ps.executeUpdate();
            if (count>0) {
				System.out.println("成功！！");
			}
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
}