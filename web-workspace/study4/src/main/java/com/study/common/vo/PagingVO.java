package com.study.common.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// 모든 목록(list에서 사용할 페이징 처리 vo)

@SuppressWarnings("serial")
public class PagingVO implements Serializable {

	private int curPage; // 현재 페이지 번호 (1)
	private int rowSizePerPage; // 한 페이지당 레코드 수 (10)
	
	private int firstRow; // 시작 레크드 번호
	private int lastRow; // 마지막 레크드 번호
	private int totalRowCount; // 총 레코드 건수 (별도 설정)
	private int totalPageCount; // 총 페이지 건수 

	private int pageSize; // 페이지 리스트에서 보여줄 페이지 갯수 (5)
	private int startPage; // 페이지 리스트에서 시작 페이지 번호
	private int endPage; // 페이지 리스트에서 마지막 페이지 번호
	
	public void setting() {
		if(curPage <1) curPage =1;
		if(rowSizePerPage<1) rowSizePerPage =10;
		if(pageSize <1) pageSize = 10;
		// 계산 curpage = 1;
		firstRow = (curPage-1)*rowSizePerPage +1;
		lastRow = curPage*rowSizePerPage ;
		totalPageCount = ((totalRowCount-1) / rowSizePerPage) +1;
		// pageSize가 5라면
		// curPage = 3      1 2 3 4 5 fP=1. lP=5
		// curPAge = 6      6 7 8 9 10 fP=6 , lP = 10 
		// curPAge = 9      6 7 8 9 10 fP=6 , lP = 10 
		startPage = ((curPage - 1) / pageSize) *pageSize + 1;
		endPage = startPage + pageSize -1;
		if(endPage > totalPageCount) endPage = totalPageCount;
	}

	@Override
	public String toString() {
		// apache commons Lang TostringBuilder
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public PagingVO() {
		// TODO Auto-generated constructor stub
	}

	public PagingVO(int curPage, int rowSizePerPage, int firstRow, int lastRow, int totalRowCount, int totalPageCount,
			int pageSize, int startPage, int endPage) {
		super();
		this.curPage = curPage;
		this.rowSizePerPage = rowSizePerPage;
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.totalRowCount = totalRowCount;
		this.totalPageCount = totalPageCount;
		this.pageSize = pageSize;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getRowSizePerPage() {
		return rowSizePerPage;
	}

	public void setRowSizePerPage(int rowSizePerPage) {
		this.rowSizePerPage = rowSizePerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getLastRow() {
		return lastRow;
	}

	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	

}