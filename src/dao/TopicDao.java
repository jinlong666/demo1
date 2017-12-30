package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import entity.News;
import entity.Page;

public class TopicDao {
	
	public static final TopicDao dao=new TopicDao();  //骚包的创建对象
	public static final int PAGESIZE =20;  //规定每页显示20条
	
	//查询所有主题
	public List<Category> findAllTitle() {
		String sql = "select catename,id from category";
		BaseDao bd = new BaseDao();
		List<Category> list = bd.query(sql);
		return list;
		
		
	}
	
	// 查找分类是否存在,true表示存在
		public boolean findTitle(String name) {
			List<Category> list = findAllTitle();
			for (Category c : list) {
				System.out.println(c.getCatename());
				if (c.getCatename().equals(name)  ) {  
					return true;
				}
			}
			return false;
		}
	
	//添加主题
	public int addTitle(String str) {
		BaseDao bd = new BaseDao();
		String sql = "insert into category(catename) values(?)";
		return bd.executeUpdate(sql, str);
	}
	
	//分页显示所有标题
	public Page<Category> findAllTitle(int pageNo){
		if(pageNo<1) {
			pageNo=1;
		}
		BaseDao bd = new BaseDao();
		String sql = "select count(1) from category ";	//查询总页数
		Connection con = bd.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Category> list2 = new ArrayList<Category>(); 
		String sql2 = "select id,catename from category order by id desc limit ?,? ";
		Page<Category> page = new Page<Category>();  //实体页数类的实例page
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
				Category c = new Category();
					c.setId(rs.getLong("id"));
					c.setCatename(rs.getString("catename"));
				list2.add(c);
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
		public int del(String id) {
			String sql = "delete  from category where id=";
			BaseDao bd = new BaseDao();
			return bd.executeUpdate(sql, id);
		}
}
