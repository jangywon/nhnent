package com.nhn.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nhn.dao.DataDAO;
import com.nhn.service.ArticleService;
import com.nhn.service.NewArticleCommand;

@Controller
@RequestMapping("/newArticle")
public class NewArticleController {
	@Autowired
	private ArticleService articleService;
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView form(Locale locale, ModelAndView model)  {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataDAO empdao = (DataDAO) ac.getBean("DataDAO");
		List lemp = (List)empdao.searchAll();
		ModelAndView modelAndView = new ModelAndView("newArticleForm");
		
		if(lemp != null){
			Iterator empIter= lemp.iterator();
			System.out.println("======= all list ======");
			while(empIter.hasNext()){
				NewArticleCommand emplist = (NewArticleCommand)empIter.next();
				System.out.println("num:"+emplist.getNum());
				System.out.println("contents:"+emplist.getContents());
				System.out.println("password:"+emplist.getPassword());
				System.out.println("email:"+emplist.getEmail());
				System.out.println("=====================");
			}
			modelAndView.addObject("list", lemp);
		}
		else{
			System.out.println("data is empty");
		}
		//		new JdbcTestClient();
		
		return modelAndView;
	}
	@RequestMapping(method = RequestMethod.POST)
	public void submit(@ModelAttribute("command") NewArticleCommand command) {
		System.out.println("submit");
		articleService.writeArticle(command);
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public void modifyData(@ModelAttribute("modleAndAttribute") ModelAndView modelAndView, NewArticleCommand modelAndAttribute, HttpServletResponse request, HttpServletResponse response){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataDAO dataDAO = (DataDAO) ac.getBean("DataDAO");
		dataDAO.modify(modelAndAttribute);
		try {
			response.sendRedirect("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public void submitData(@ModelAttribute("modleAndAttribute") NewArticleCommand modleAndAttribute, HttpServletResponse response){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataDAO dataDAO = (DataDAO) ac.getBean("DataDAO");
		dataDAO.add(modleAndAttribute);
		try {
			response.sendRedirect("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void setArticleService(ArticleService articleService) {
		System.out.println("setArticleService");
		this.articleService = articleService;
	}


}

