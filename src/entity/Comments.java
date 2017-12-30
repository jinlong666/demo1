package entity;

import java.util.Date;

public class Comments {
	private int cid; //评论编号
	private long cnid; //'新闻编号'
	private String ccontent; //'评论内容',
	private Date cdate; 	//'评论时间'
	private String cip;  	//'ip地址'
	private String cauthor;	//评论作者'
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public long getCnid() {
		return cnid;
	}
	public void setCnid(long cnid) {
		this.cnid = cnid;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	public String getCauthor() {
		return cauthor;
	}
	public void setCauthor(String cauthor) {
		this.cauthor = cauthor;
	}
	
	
}
