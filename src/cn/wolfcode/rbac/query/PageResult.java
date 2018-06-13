package cn.wolfcode.rbac.query;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageResult {
	public static final PageResult EMPTY_PAGERESULT = new PageResult(1, 3, 0, Collections.EMPTY_LIST);
	private int currentPage;
	private int pageSize;
	private int totalCount;
	private List<?> list;
	private int prevPage;
	private int nextPage;
	private int totalPage;
	public PageResult(int currentPage, int pageSize, int totalCount, List<?> list) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.list = list;
		if (totalCount < pageSize) {
			this.prevPage = 1;
			this.nextPage = 1;
			this.totalPage = 1;
		}
		this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize :totalCount / pageSize +1;
		this.prevPage = currentPage - 1 > 0 ? currentPage - 1 : 1;
		this.nextPage = currentPage + 1 > totalPage ? totalPage : currentPage + 1;
		
	}
	
}
