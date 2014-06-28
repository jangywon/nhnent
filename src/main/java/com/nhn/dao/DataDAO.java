package com.nhn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nhn.service.NewArticleCommand;

public class DataDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	public DataSource getDataSource(){
		return dataSource;
	}                  

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// insert data 
	public int add(NewArticleCommand article){
		boolean isValidEmail = Pattern.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", article.getEmail());
		if(isValidEmail){
			
			System.out.println("E-mail Check Success");
		//insert into guestbook(num,email,password,contents,writedate,modifydate) VALUES(NULL,'hyunsoo@ajou.ac.kr','hyunsoo', 'blade AND soul', SYS_TIMESTAMP, null)
		String sql = "insert into guestbook (num,email,password,contents,writedate,modifydate) values (NULL, '"+article.getEmail()+"' , '"+article.getPassword()+"' , '"+article.getContents()+"' , SYS_TIMESTAMP , null );";
		return jdbcTemplate.update(sql);
		}else{
			
			System.out.println("E-mail Check Fail");
			return 0;
		}
	}




	// update modified data
	public int modify(NewArticleCommand article){
		NewArticleCommand compareArticle = this.searchOne(String.valueOf(article.getNum()));


		String originPassword = compareArticle.getPassword();
		String inputPassword = article.getPassword();

		System.out.println("origin Password = "+originPassword);
		System.out.println("input Passwrod = "+inputPassword);
		if(inputPassword.equals(originPassword)){
			System.out.println("====================");
			System.out.println("password check success");
			System.out.println("====================");
			String sql = "update guestbook SET contents = '"+article.getContents()+"', modifydate = SYS_TIMESTAMP WHERE num = "+article.getNum()+";";
			return jdbcTemplate.update(sql);
		}
		else{

			System.out.println("====================");
			System.out.println("password check fail");
			System.out.println("====================");
			return 0;
		}
	}





	public NewArticleCommand searchOne(String num){

		String sql = "select * from guestbook WHERE num = "+num;
		RowMapper mapper = new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
				NewArticleCommand article = new NewArticleCommand();
				article.setNum(rs.getInt("num"));
				article.setEmail(rs.getString("email"));
				article.setPassword(rs.getString("password"));
				article.setContents(rs.getString("contents"));
				article.setWritedate(rs.getString("writedate"));
				article.setModifydate(rs.getString("modifydate"));
				return article;
			}
		};

		System.out.println(jdbcTemplate.queryForObject(sql, mapper).toString());
		return jdbcTemplate.queryForObject(sql, mapper);	

	}

	// Search All data
	public List<NewArticleCommand> searchAll(){

		String sql = "select * from guestbook";
		// RowMapper??? ResultSet??? ???????????? ????????? ??????????????? ????????? ??????.
		RowMapper mapper = new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
				NewArticleCommand article = new NewArticleCommand();

				article.setNum(rs.getInt("num"));
				article.setEmail(rs.getString("email"));
				article.setPassword(rs.getString("password"));
				article.setContents(rs.getString("contents"));
				article.setWritedate(rs.getString("writedate"));
				article.setModifydate(rs.getString("modifydate"));
				return article;
			}
		};
		return jdbcTemplate.query(sql, mapper);
	}
}
