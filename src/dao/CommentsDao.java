package dao;

import java.text.SimpleDateFormat;
import java.util.List;

import entity.Comments;

public class CommentsDao {
	public static CommentsDao dao = new CommentsDao();
	BaseDao bd = new BaseDao();
		// 删除评论
		public int delCom(long cnid) {
			String sql = "delete from comments where cnid=?";
			return bd.executeUpdate(sql, cnid);
		}

		// 获取某一条新闻下的评论
		public List<Comments> findComments(String cnid) {
			String sql = "select cauthor,cip,cdate,ccontent from comments where cnid="
					+ cnid;
			return bd.query2(sql);
		}

		// 新增一条评论
		public int addCom(Comments c) {
			String sql = "insert into comments(cnid,ccontent,cdate,cip,cauthor) values(?,?,?,?,?)";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String cdate = sdf.format(c.getCdate());
			Object[] args = { c.getCnid(), c.getCcontent(), cdate, c.getCip(),
					c.getCauthor() };
			return bd.executeUpdate(sql, args);
		}
	

}
