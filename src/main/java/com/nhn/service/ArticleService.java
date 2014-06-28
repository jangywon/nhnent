package com.nhn.service;

import org.springframework.stereotype.Service;

@Service
public class ArticleService {

	public void writeArticle(NewArticleCommand command) {
		System.out.println("command : " + command);
	}
}
