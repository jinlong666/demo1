package Impor;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;



import dao.BaseDao;
import entity.*;

/**
 * 新闻实现类
 * @author key1032722147
 *
 */
public class NewsIndexImpor extends BaseDao {
	Connection con = super.getConnection();
		//主页查询新闻表
		public List<News> findNews(String sql) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			News news = null;
			List<News> list = new ArrayList<News>();
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					news = new News();
					news.setId(rs.getLong("id"));
					news.setCate_id(rs.getLong("cate_id"));
					news. setPub_date(rs.getTimestamp("pub_date"));

					news.setContent(rs.getString("content"));
					news.setAuthor(rs.getString("author"));
					news.setSummary(rs.getString("summary"));
					news.setTitle(rs.getString("title"));
					list.add(news);
				}
				
			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				closeAll(null, ps, rs);
			}
			return list;
				
		}
	//点击新闻标题显示新闻
		public List<News>  content(String id) {
			String sql = "select * from news where cate_id=" + id;
			List<News> list = findNews(sql);
			return list;
			
		}
	//主界面---左侧置顶新闻分页
	public List<News> sidebar(int i) {
		String sql ="select * from news where cate_id=" + i +" limit 6 ";
		List<News> list = findNews(sql);
		return list;
	}
	//主界面-----倒叙分页查看所有新闻表
		public List<News> findAllNews() {
			String sql ="select * from news order by id desc limit 20" ;
			List<News> list =findNews(sql);
			return list;
		}
	//主界面----新闻分类表
	public List<Category> getAllNews()  {
		String sql ="select * from category";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Category cg = null;
		List<Category> list = new ArrayList<Category>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				cg = new Category();
				cg.setId(rs.getLong("id"));
				cg.setCatename(rs.getString("catename"));
				list.add(cg);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, ps, rs);
		}
		return list;
	}
	
	//主页用户登陆验证
	public boolean login(String name, String pass) {
		String sql = "select Uid from user where userName=? and pass=?";
		
		Connection con =super.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if(rs.next()) 
				return true;
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			closeAll(null, ps, rs);
		}
		return false;
	}
	
	
}
