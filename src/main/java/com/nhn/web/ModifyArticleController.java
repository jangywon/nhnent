package com.nhn.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nhn.dao.DataDAO;
import com.nhn.service.NewArticleCommand;

@Controller
@RequestMapping("/modifyArticle")
public class ModifyArticleController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView modifyForm(Locale locale, ModelAndView model, HttpServletRequest httpServletRequest) {

		String num = String.valueOf(httpServletRequest.getParameter("num"));
		model = new ModelAndView("modifyArticleForm");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataDAO dataDao =(DataDAO) ac.getBean("DataDAO");
		NewArticleCommand article = (NewArticleCommand)dataDao.searchOne(num);
		model.addObject("article", article);
		return model;
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void modifyUpdate(@ModelAttribute("modleAndAttribute") NewArticleCommand modleAndAttribute, HttpServletResponse response) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataDAO datadao = (DataDAO) ac.getBean("DataDAO");
		
	}
}
