package com.briup.cms.web.action.manager;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Category;
import com.briup.cms.service.IArticleService;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.impl.ArticleServiceImpl;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private ICategoryService categoryService 
								= new CategoryServiceImpl();
	private IArticleService articleService 
								= new ArticleServiceImpl();
	
	private List<Category> categoryList;
	
	private String title;
	private String author;
	private String content;
	private Long c_id;
	
	
	@Action(value="toAddArticle",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/addArticle.jsp")
	})
	public String toAddArticle(){
		categoryList = categoryService.list();
		return "success";
	}
	
	/**
	 * 添加栏目
	 * */
	@Action("addArticle")
	public void addArticle(){
		Article article = new Article(null, title, author, content, new Date(), c_id);
		articleService.add(article);
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}
}
