package com.briup.cms.service;

import java.util.List;

import com.briup.cms.bean.Category;

/**
 * 栏目管理的接口
 * 定义系统功能
 * @author licy
 * @date 2016.5.7
 * */
public interface ICategoryService {
	/**
	 * 添加栏目
	 * */
	void add(Category category);
	
	/**
	 * 查询所有栏目信息
	 * */
	List<Category> list();
	
	/**
	 * 通过id删除栏目
	 * */
	void delete(long id);
}
