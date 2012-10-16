package com.hashedin.picaso;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




import javax.sql.DataSource;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class Fetchdata {
	
	List <MyType> myList = new ArrayList<MyType>();
	private JdbcTemplate jdbcTemplate;
	
	public Fetchdata() {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		DataSource dataSource1 = factory.getBean(DataSource.class);
		this.jdbcTemplate = new JdbcTemplate(dataSource1);
	}
	
	public List<MyType> getalbums(){
		
	  myList=jdbcTemplate.query("select id,description from albums",new RowMapper<MyType>(){
		  public MyType mapRow(ResultSet rs, int rowNum) throws SQLException {
				MyType m = new MyType();
				m.setId(rs.getString(1));
				m.setDesc(rs.getString(2));
				return m;
		  }
		  
	  });
	  return myList;

				
				
			
	}
}
