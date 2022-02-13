package demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
//import org.springframework.jdbc.core.RowCallbackHandler;
//import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Service;

import demo.model.MainEmp;
import demo.service.intf.MainEmpInterface;


@Service
@Qualifier("main")
public class MainEmpServices implements MainEmpInterface
{
	@Autowired
	JdbcTemplate jdbc;
	@Override
	public String addnewemp(MainEmp e) {
		// TODO Auto-generated method stub
		jdbc.execute("insert into empdetails (id,name,phone,email,position,workloc) values ("+e.getId()+",'"+e.getName()+"','"+e.getPhone()+"','"+e.getEmail()+"','"+e.getPosition()+"','"+e.getWorklocation()+"');");
		return "added new emp";
	}

	@Override
	public List<MainEmp> displayall() {
		// TODO Auto-generated method stub
	/*	RowCountCallbackHandler countCallback = new RowCountCallbackHandler();  
		 jdbc.query("select * from empdetails", countCallback);
		 return countCallback.getRowCount();*/
		List<MainEmp> emps= jdbc.query("select * from empdetails",new ResultSetExtractor<List<MainEmp>>() {

			@Override
			public List<MainEmp> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<MainEmp> list= new ArrayList<MainEmp>();
				while(rs.next()) {
					MainEmp m= new MainEmp();
					m.setId(rs.getInt("id"));
					m.setName(rs.getString("name"));
					m.setPhone(rs.getString("phone"));m.setEmail(rs.getString("email"));
					m.setPosition(rs.getString("position"));
					m.setWorklocation(rs.getString("workloc"));
					list.add(m);
				}
				return list;
			}
			
		});
		return emps;
				// not reusable
	}

	@Override
	public List<MainEmp> displayspecific(MainEmp e) {
		// TODO Auto-generated method stub
		int id=e.getId();
		String sql1="select * from empdetails where id="+id;
		List<MainEmp> emps= jdbc.query(sql1,new ResultSetExtractor<List<MainEmp>>() {

			@Override
			public List<MainEmp> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<MainEmp> list= new ArrayList<MainEmp>();
				while(rs.next()) {
					MainEmp m= new MainEmp();
					m.setId(rs.getInt("id"));
					m.setName(rs.getString("name"));
					m.setPhone(rs.getString("phone"));m.setEmail(rs.getString("email"));
					m.setPosition(rs.getString("position"));
					m.setWorklocation(rs.getString("workloc"));
					list.add(m);
				}
				return list;
			}
			
		});
		return emps;
		
		
	}

	@Override
	public String updateemp(MainEmp e) {
		// TODO Auto-generated method stub
		String sql2="update empdetails"+" set name='"+e.getName()+"', phone='"+e.getPhone()+"', email='"+e.getEmail()+"', position='"+e.getPosition()+"', workloc='"+e.getWorklocation()+"' where id="+e.getId();
		//sql2="update empdetail set name=?, phone= ?, email=?,position=?,
	//	jdbc.update(sql2,e.getName(),e.getPhone(),e.getEmail(),e.getPosition(),e.getWorklocation());
		jdbc.update(sql2);
		return "Updation success";
	}

	@Override
	public String deleteemp(MainEmp e) {
		// TODO Auto-generated method stub
		String sql2="delete from empdetails where id="+e.getId();
		jdbc.execute(sql2);
		return "Deletion success";
		
	}

}
