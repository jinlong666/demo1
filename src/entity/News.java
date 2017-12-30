package entity;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
	private long  id, cate_id ;
	private Date pub_date;
	private String  content,author,summary,title;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCate_id() {
		return cate_id;
	}
	public void setCate_id(long cate_id) {
		this.cate_id = cate_id;
	}
	public Date getPub_date() {
		return pub_date;
	}
	public void setPub_date(Date pub_date) {
		this.pub_date = pub_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", cate_id=" + cate_id + ", pub_date=" + pub_date + ", content=" + content
				+ ", author=" + author + ", summary=" + summary + ", title=" + title + "]";
	}
	
	
}
