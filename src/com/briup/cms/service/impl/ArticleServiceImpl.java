package com.briup.cms.service.impl;

import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.dao.ArticleDao;
import com.briup.cms.service.IArticleService;

public class ArticleServiceImpl implements IArticleService {
	private ArticleDao articleDao = new ArticleDao();
	@Override
	public void add(Article article) {
		articleDao.save(article);
	}

	@Override
	public List<Article> findAll() {
		return articleDao.findAll();
	}

	@Override
	public void delete(long id) {
		
	}

	@Override
	public Article scanner(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
