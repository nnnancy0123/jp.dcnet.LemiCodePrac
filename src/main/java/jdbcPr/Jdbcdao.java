package jdbcPr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Jdbcdao {

 // PostgreSQL数据库连接信息
 static final String DB_URL = "jdbc:postgresql://localhost:5432/users";
 static final String USER = "postgres";
 static final String PASS = "postgres";

 public void addPerson(List<JdbcObj> list) {

  Connection conn = null;
  PreparedStatement stmt = null;

  // 注册 JDBC 驱动
  try {
   Class.forName("org.postgresql.Driver");

   // 打开一个连接
   System.out.println("连接数据库...");
   conn = DriverManager.getConnection(DB_URL, USER, PASS);

   for (JdbcObj obj : list) {
    // SQL 插入语句
    String sql = "INSERT INTO book_info (id, age, gender, addrese) VALUES (?, ?, ?, ?)";

    // 创建 PreparedStatement 对象
    stmt = conn.prepareStatement(sql);

    // 设置插入的值
    stmt.setInt(1, obj.getId());
    stmt.setInt(2, obj.getAge());
    stmt.setString(3, obj.getGender());
    stmt.setString(4, obj.getAddress());

    // 执行插入操作
    int rowsAffected = stmt.executeUpdate();

    if (rowsAffected > 0) {
     System.out.println("数据插入成功！");
    } else {
     System.out.println("数据插入失败！");

    }

   }

   //   String sql = "SELECT * FROM book_info;";
   //   ResultSet rs = stmt.executeQuery(sql);
   //   System.out.println(9999);
   // 处理结果集
   //   while (rs.next()) {
   //    // 通过字段检索
   //    int id = rs.getInt("id");
   //    String name = rs.getString("author");
   //    String title = rs.getString("title");
   //
   //    // 输出数据
   //    System.out.print("ID: " + id);
   //    System.out.print("姓名: " + name);
   //    System.out.println(title);
   //   }

  } catch (ClassNotFoundException | SQLException e) {
   // TODO 自動生成された catch ブロック
   e.printStackTrace();
  }

 }

}