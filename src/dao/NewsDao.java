package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Impor.NewsIndexImpor;

import java.sql.*;

import entity.*;


public class NewsDao {
	public static final NewsDao dao=new NewsDao();  //骚包的创建对象
	public static final int PAGESIZE =20;  //规定每页显示20条
	
	
	/**
	*管理员界面的分页显示所有新闻
	*
	*/
	public Page<News> findAll(int pageNo){
		if(pageNo<1 ) {
			pageNo=1;
		}
		BaseDao bd = new BaseDao();
		String sql = "select count(1) from news ";	//查询总页数
		Connection con = bd.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<News> list2 = new ArrayList<News>(); 
		String sql2 = "select id,title,pub_date,author from news order by pub_date desc limit ?,? ";
		Page<News> page = new Page<News>();  //实体页数类的实例page
		int total=0;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				total = rs.getInt(1);// 获得总新闻条数
			}
			bd.closeAll(null, ps, rs);
			
			ps =con.prepareStatement(sql2);
			ps.setInt(1, (pageNo-1)*PAGESIZE);
			ps.setInt(2, PAGESIZE);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				News n = new News();
				n.setId(rs.getLong("id"));
				n.setTitle(rs.getString("title"));
				// 时间要注意.换成TimeStamp
				n.setPub_date(rs.getTimestamp("pub_date"));
				n.setAuthor(rs.getString("author"));
				list2.add(n);
			}
			int pageTotals = total / PAGESIZE + (total % PAGESIZE == 0 ? 0 : 1);  //总页数=总条数/每页的条数 + （总条数%每页的条数==0？0:1）
		
			page.setPageNums(pageTotals);  //总页数
			page.setDatas(list2); //把分页放到集合，然后把集合放到实体类中
			page.setPageSize(PAGESIZE); //页大小
			page.setPageNo(pageNo);	//当前页号
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bd.closeAll(con, ps, rs);
		}
		
		return page;
		
	}
	
	
	//管理元界面删除新闻
	public int del(long id) {
		String sql = "delete  from news where id=?";
		BaseDao bd = new BaseDao();
		return bd.executeUpdate(sql, id);
	}
	
	// 首页的分页显示单类新闻
		public Page<News> showNewsByTopic(int pageNo, int id) {
			if(pageNo<1) {
				pageNo=1;
			}
			BaseDao bd = new BaseDao();
			String sql = "select count(1) from news where cate_id="+id;	//查询总页数
			//List<News> list = bd.findNews(sql); //返回的集合长度就是所有新闻的条数
			Connection con = bd.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<News> list2 = new ArrayList<News>(); 
			String sql2 = "select id,cate_id,title,pub_date,author,content,summary from news where cate_id ="+id+" order by pub_date desc limit ?,? ";
			Page<News> page = new Page<News>();  //实体页数类的实例page
			int total = 0;
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					total = rs.getInt(1);// 获得总新闻条数
				}
				bd.closeAll(null, ps, rs);
				ps =con.prepareStatement(sql2);
				ps.setInt(1, (pageNo-1)*PAGESIZE);
				ps.setInt(2, PAGESIZE);
				rs = ps.executeQuery();
				while (rs.next()) {
					News n = new News();
					n.setId(rs.getLong("id"));
					n.setCate_id(rs.getLong("cate_id"));
					n.setTitle(rs.getString("title"));
					// 时间要注意.换成TimeStamp
					n.setPub_date(rs.getTimestamp("pub_date"));
					n.setAuthor(rs.getString("author"));
					n.setContent(rs.getString("content"));
					n.setSummary(rs.getString("summary"));
					list2.add(n);
				}
				int pageTotals = total / PAGESIZE + (total % PAGESIZE == 0 ? 0 : 1);  //总页数=总条数/每页的条数 + （总条数%每页的条数==0？0:1）
				page.setPageNums(pageTotals);  //总页数
				page.setDatas(list2); //把分页放到集合，然后把集合放到实体类中
				page.setPageSize(PAGESIZE); //页大小
				page.setPageNo(pageNo);	//当前页号
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				bd.closeAll(con, ps, rs);
			}
			
			return page;
			
		}
	
}
