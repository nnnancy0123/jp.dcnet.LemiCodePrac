package jdbcPr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JdbcController {

 public static void main(String[] args) {

  // 指定要读取的文本文件路径
  String filePath = "/Users/nancyjin/Desktop/test/test.txt";

  BufferedReader reader = null;

  List<JdbcObj> list = new ArrayList<JdbcObj>();

  // 创建一个 BufferedReader 实例以读取文件
  try {
   reader = new BufferedReader(new FileReader(filePath));
   // 用于保存每行的字符串
   String line;

   while ((line = reader.readLine()) != null) {

    String[] parts = line.split(",");
    JdbcObj obj = new JdbcObj();

    obj.setId(Integer.valueOf(parts[0]));
    obj.setAge(Integer.valueOf(parts[1]));
    obj.setGender(parts[2]);
    obj.setAddress(parts[3]);
    list.add(obj);
   }

  } catch (IOException e) {
   // TODO 自動生成された catch ブロック
   e.printStackTrace();
  }
  
  JdbcService personService = new JdbcService();
  personService.addPerson(list);

 }

}