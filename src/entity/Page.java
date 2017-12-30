package entity;

import java.io.Serializable;
import java.util.*;
/**
 * 分页类
 * @author key1032722147
 *
 * @param <t>
 */
public class Page<T> implements Serializable{	
	private List<T> datas = new ArrayList<T>(0);  //每次分页的对象的集合
	private int pageNo = 1;		// 当前页号
	private int pageSize = 20;	// 每页条数
	private int pageNums;	// 总页数
	
	public Page() {
	}
	//2参构造
	
	public Page(List<T> datas, int pageNo) {
		super();
		this.datas = datas;
		this.pageNo = pageNo;
	}
	//3参构造
	public Page(List<T> datas, int pageNo, int pageNums) {
		super();
		this.datas = datas;
		this.pageNo = pageNo;
		this.pageNums = pageNums;
	}
	
	
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNums() {
		return pageNums;
	}
	public void setPageNums(int pageNums) {
		this.pageNums = pageNums;
	}
	
	
}
