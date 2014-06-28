package com.nhn.service;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nhn.dao.DataDAO;
public class JdbcTestClient {

	public static void main(String[] args) {
		// configuration metadata? ???.
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataDAO empdao = (DataDAO) ac.getBean("DataDAO");
		List lemp = (List)empdao.searchAll();
		if(lemp != null){
			Iterator empIter= lemp.iterator();
			System.out.println("======= all list ======");
			while(empIter.hasNext()){
				NewArticleCommand emplist = (NewArticleCommand)empIter.next();
				System.out.println("num"+emplist.getNum());
				System.out.println("email:"+emplist.getEmail());
				System.out.println("password:"+emplist.getPassword());
				System.out.println("contents"+emplist.getContents());
				System.out.println("=====================");
			}
		}
		else{
			System.out.println("data is empty");
		}
	}
}