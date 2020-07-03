package com.study.member.vo;

import com.study.common.vo.PagingVO;

@SuppressWarnings("serial")
public class MemberSearchVO extends PagingVO {
	private String searchType;
	private String searchWord;
	private String searchJob;
	private String searchLike;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getSearchJob() {
		return searchJob;
	}
	public void setSearchJob(String searchJob) {
		this.searchJob = searchJob;
	}
	public String getSearchLike() {
		return searchLike;
	}
	public void setSearchLike(String searchLike) {
		this.searchLike = searchLike;
	}
	public MemberSearchVO(String searchType, String searchWord, String searchJob, String searchLike) {
		super();
		this.searchType = searchType;
		this.searchWord = searchWord;
		this.searchJob = searchJob;
		this.searchLike = searchLike;
	}
	public MemberSearchVO() {
		// TODO Auto-generated constructor stub
	}
	
}
