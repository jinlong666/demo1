package dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.*;
import javax.sql.DataSource;


import entity.Category;
import entity.Comments;
import entity.News;



public class BaseDao {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private Connection con = null;
	
	//静态代码块，保证类加载的同时执行
	static {
		init();
	}
	//从配置文件中获得参数
	public static void init() {
		//创建Properties类的对象
		Properties pt = new Properties();
		String file = "dataBase.properties";
		//加载配置文件到输入流
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(file);
		//从输入流中读取属性
		try {
			pt.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = pt.getProperty("driver");
		url = pt.getProperty("url");
		user = pt.getProperty("user");
		password = pt.getProperty("password");
		
	}
	
	//加载驱动并连接数据库
	public Connection getConnection() {
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	/*//public static DataSource ds = getDs();
	//创建数据库连接池
    public Connection getConnection () {
        Connection conn = null;
        try { //获取与逻辑名相关联的数据源对象
             Context ctx = new InitialContext();
             DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/news");
             conn = ds.getConnection();	  
             System.out.println("Connection hashcode:" +conn.hashCode());
        } catch (Exception exception) {
              exception.printStackTrace();
        } 
        return conn;
    } */ 

	
	//关闭所有资源
	public void closeAll(Connection con, PreparedStatement ps , ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	

/*	//管理页 查看评论页的信息
		public List<Comments> showNews(String sql) {
			con = getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			Comments cg = null;
			List<Comments> list = new ArrayList<Comments>();
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					cg = new Comments();
					cg.setCid(rs.getInt("cid"));
					cg.setCnid(rs.getLong("cnid"));
					cg.setCcontent(rs.getString("ccontent"));
					cg.setCdate(rs.getTimestamp("cdate"));   //
					cg.setCip(rs.getString("cip"));  
					cg.setCauthor(rs.getString("cauthor"));
					list.add(cg);
				}
				
			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				closeAll(con, ps, rs);
			}
			return list;
				
		}*/
	
	/*
	 * 增  删  改 的集合方法
	 */
			public int executeUpdate(String sql, Object... args) {
				con = getConnection();
				PreparedStatement ps = null;
				try {
					ps = con.prepareStatement(sql);
					for (int i = 0; i < args.length; i++) {
						ps.setObject(i + 1, args[i]);
					}
					return ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
					return -1;
				} finally {
					closeAll(con, ps, null);
				}

			}
			
		/*
		 * 查询方法
		 */
			public  List<Category> query(String sql) {
				List<Category> list = new ArrayList<Category>();
				con = getConnection();
				PreparedStatement ps = null;
				ResultSet rs = null;
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					while (rs.next()) {
						Category c = new Category();
						c.setId(rs.getLong("id"));
						c.setCatename(rs.getString("catename"));
						//c.setShowOntop(rs.getInt("showOntop"));
						list.add(c);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					closeAll(con, ps, rs);
				}
				return list;
			}
			
			public  List<Comments> query2(String sql) {
				List<Comments> list = new ArrayList();
				con = getConnection();
				PreparedStatement ps = null;
				ResultSet rs = null;
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					while (rs.next()) {
						Comments c = new Comments();
						c.setCid(rs.getInt("cid"));
						c.setCnid(rs.getLong("cnid"));
						c.setCcontent(rs.getString("ccontent"));
						c.setCdate(rs.getDate("cdate"));
						c.setCip(rs.getString("cip"));
						c.setCauthor(rs.getString("cauthor"));
						list.add(c);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					closeAll(con, ps, rs);
				}
				return list;
			}
			

}
