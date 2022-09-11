package com.example;
import org.springframework.jdbc.core.JdbcTemplate;
/*Driver
 * Connection-spring.xml -url,username,pwd
 * statement
 * execution
 * close
 * 
 * */
public class StudentDAO {
private JdbcTemplate temp;

public void setTemp(JdbcTemplate temp) {
	this.temp = temp;
}


public int insert(Student s) {
	String sql="insert into student values("+s.getSid()+",'"+s.getSname()+"','"+s.getSemail()+"',"+s.getPhono()+")";
	System.out.println(sql);
	//insert,update,delete -executeUpdate()
	return temp.update(sql);
}

}
