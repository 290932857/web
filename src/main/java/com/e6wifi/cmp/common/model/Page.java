package com.e6wifi.cmp.common.model;
import java.util.List;

public class Page implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6793124399221970782L;
	private int size;// 页面大小
	private int rowCount;// 数据总行数
	private int current;// 当前页
	private int index;//当前页索引查询
	private int next;// 下一页
	private int up;// 上一页
	private int count;// 页面数
	private List<?> list;

	private int sequenceNumber ;
	
	public Page(){
		this.rowCount = 0;
		this.current = 0;
		this.next = 0;
		this.up = 0;
		this.count = 1;
		this.sequenceNumber = 0;
	}
	
	public Page(int current, int size) {
		this.size = size;
		this.current = current;
		if(current == 0) {
			this.index = 0;
		} else {
			this.index = (this.current - 1) * size;
		}
		this.rowCount = 0;
		this.next = 0;
		this.up = 0;
		this.count = 1;
		this.sequenceNumber = 0;
	}
	
	public Page(int rowCount, int current, int next, int up, int count) {
		this.rowCount = rowCount;
		this.current = current;
		this.next = next;
		this.up = up;
		
		this.count = count;
		if(count<=1){
			sequenceNumber = 0;
			count = 1;
		}else{
			this.sequenceNumber = (this.current-1)*this.size;
		}
	}
	public Page(int rowCount, int current, int pageSize) {

		if (rowCount == 0) {
			return;
		}

		this.rowCount = rowCount;
		this.current = current;
		this.size = pageSize;

		if (this.size == 0) this.size = 25;

		this.count = (this.rowCount + this.size - 1) / this.size;
		this.count = (this.count > 0) ? this.count : 1;
		if (current > count) {
			this.current = count;
		}
		if (current <= 1) {
			this.current = 1;
			this.sequenceNumber = 0;
		}else{
			this.sequenceNumber = (this.current-1)*this.size;
		}
		this.next = this.current + 1 < this.count ? this.current + 1 : this.count;
		this.up = this.current - 1 > 0 ? this.current - 1 : 1;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		if (rowCount == 0) {
			return;
		}
		this.rowCount = rowCount;
		this.count = (this.rowCount + this.size - 1) / this.size;
		this.count = (this.count > 0) ? this.count : 1;
		if (current > count) {
			this.current = count;
		}
		if (current <= 1) {
			this.current = 1;
			this.sequenceNumber = 0;
		}else{
			this.sequenceNumber = (this.current-1)*this.size;
		}
		this.next = this.current + 1 < this.count ? this.current + 1 : this.count;
		this.up = this.current - 1 > 0 ? this.current - 1 : 1;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}


	public int getSequenceNumber() {
		return sequenceNumber;
	}


	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public static void main(String[] args) {
		Page page = new Page(2, 10);
		page.setRowCount(182);
		
		System.out.println("页数： " + page.count + "  上一页：" + page.up + "  当前页：" + page.current 
				+ "  下一页：" + page.next + "  总数据：" + page.rowCount + "  每页：" + page.size + "  索引开始：" + page.index);
	}

}
