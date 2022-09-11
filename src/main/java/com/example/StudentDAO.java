package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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

/*sql query
 * statement/preparedStatement
 * executeQuery->ResultSet(table ref)
 * */

public List<Student> getallstudents(){
	String sql="select * from student";
	return temp.query(sql, new ResultSetExtractor<List<Student>>() {

		public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			ArrayList<Student> list=new ArrayList<Student>();
			
			while(rs.next()) {
				Student s=new Student();
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setSemail(rs.getString(3));
				s.setPhono(rs.getInt(4));
				list.add(s);
			}
			return list;
		}
	});
}


}


