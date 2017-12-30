package entity;

public class Category {
	private long id; //类别编号
	private String catename; //名字
	private int showOntop; //是否显示
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	public int getShowOntop() {
		return showOntop;
	}
	public void setShowOntop(int showOntop) {
		this.showOntop = showOntop;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", catename=" + catename + ", showOntop=" + showOntop + "]";
	}
	
	
}
