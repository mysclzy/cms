package com.briup.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.common.ConnectionFactory;

public class ArticleDao  {
	public void deleteById(long id){
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try{
				//获取连接
				conn = ConnectionFactory.getConn();
				String sql = "delete from t_article where id = ?";
				//预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				pstmt.executeUpdate();
			}finally{
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void save(Article article){
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try{
				//获取连接
				conn = ConnectionFactory.getConn();
				String sql = "insert into t_article("
						+ "title,author,content,publisurDate,c_id) values(?,?,?,?,?)";
				//预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, article.getTitle());
				pstmt.setString(2, article.getAuthor());
				pstmt.setString(3, article.getContent());
				//  java.sql.Date		java.util.Date
				long time = article.getPublisurDate().getTime();
				pstmt.setDate(4, new Date(time));
				pstmt.setLong(5, article.getC_id());
				//执行sql
				pstmt.executeUpdate();
			}finally{
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有
	 * */
	public List<Article> findAll(){
		List<Article> list = new ArrayList<Article>();
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				//获取连接
				conn = ConnectionFactory.getConn();
				String sql = "select * from t_article";
				//预处理sql
				pstmt = conn.prepareStatement(sql);
				//执行
				rs = pstmt.executeQuery();
				//处理接过去
				while(rs.next()){
					long id = rs.getLong("id");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String author = rs.getString("author");
					java.util.Date publisurDate = rs.getDate("publisurDate");
					long c_id = rs.getLong("c_id");
					
					Article article = new Article(id, title, author, content, publisurDate, c_id);
					list.add(article);
				}
			}finally{
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}
