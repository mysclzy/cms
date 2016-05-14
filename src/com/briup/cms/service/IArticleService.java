package com.briup.cms.service;

import java.util.List;

import com.briup.cms.bean.Article;

public interface IArticleService {
	void add(Article article);
	
	List<Article> findAll();
	
	void delete(long id);
	
	Article scanner(long id);
	
}
