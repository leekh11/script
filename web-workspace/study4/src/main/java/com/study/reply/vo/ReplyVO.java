package com.study.reply.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ReplyVO {
	private int reNo;            /*댓글번호*/
	private String reCategory;      /*분류(BOARD, PDS, FREE, ...)*/
	private int reParentNo;      /*부모 번호*/
	private String reMemId;         /*작성자ID*/
	private String reContent;       /*댓글 내용*/
	private String reIp;            /*IP*/
	private String reRegDate;       /*댓글 등록일자*/
	private String reModDate;       /*댓글 수정일자*/
	private String reMemName;		/* 작성자 이름
	*/
	
	@Override
	public String toString() {
		// apache commons Lang TostringBuilder 
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public ReplyVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ReplyVO(int reNo, String reCategory, int reParentNo, String reMemId, String reContent, String reIp,
			String reRegDate, String reModDate, String reMemName) {
		super();
		this.reNo = reNo;
		this.reCategory = reCategory;
		this.reParentNo = reParentNo;
		this.reMemId = reMemId;
		this.reContent = reContent;
		this.reIp = reIp;
		this.reRegDate = reRegDate;
		this.reModDate = reModDate;
		this.reMemName = reMemName;
	}

	public int getReNo() {
		return reNo;
	}

	public void setReNo(int reNo) {
		this.reNo = reNo;
	}

	public String getReCategory() {
		return reCategory;
	}

	public void setReCategory(String reCategory) {
		this.reCategory = reCategory;
	}

	public int getReParentNo() {
		return reParentNo;
	}

	public void setReParentNo(int reParentNo) {
		this.reParentNo = reParentNo;
	}

	public String getReMemId() {
		return reMemId;
	}

	public void setReMemId(String reMemId) {
		this.reMemId = reMemId;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public String getReIp() {
		return reIp;
	}

	public void setReIp(String reIp) {
		this.reIp = reIp;
	}

	public String getReRegDate() {
		return reRegDate;
	}

	public void setReRegDate(String reRegDate) {
		this.reRegDate = reRegDate;
	}

	public String getReModDate() {
		return reModDate;
	}

	public void setReModDate(String reModDate) {
		this.reModDate = reModDate;
	}

	public String getReMemName() {
		return reMemName;
	}

	public void setReMemName(String reMemName) {
		this.reMemName = reMemName;
	}
	
	
}
