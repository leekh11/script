package com.study.member.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;


@SuppressWarnings("serial")
public class MemberVO implements Serializable {

	private String memId;           /*회원아이디*/
	@NotBlank(message = "패스워드는 필수 입니다.")
	@Size(min = 4, max = 16, message = "패스워드는 4글자 이상 16글자 이하")
	private String memPass;         /*회원비밀번호*/
	@NotNull(message ="이름 필수 입니다")
	@Pattern(regexp = "^[가-힣]+$", message = "한글만 사용 가능")
	private String memName;         /*회원이름*/
	private String memBir;          /*회원생일*/


	private String memZip;          /*우편번호*/
	private String memAdd1;         /*기본주소*/
	private String memAdd2;         /*상세주소*/
	private String memHp;           /*연락처*/
	private String memMail;         /*메일*/
	private String memJob;          /*직업*/
	private String memLike;         /*취미*/
	private int memMileage;      /*마일리지*/
	private String memDelYn;        /*탈퇴여부*/
	
	//
	private String memJobNm;  // 직업명
	private String memLikeNm; // 취미명 
	
	@Override
	public String toString() {
		// apache commons Lang TostringBuilder 
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public MemberVO(String memId, String memPass, String memName, String memBir, String memZip, String memAdd1,
			String memAdd2, String memHp, String memMail, String memJob, String memLike, int memMileage,
			String memDelYn, String memJobNm, String memLikeNm) {
		super();
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memBir = memBir;
		this.memZip = memZip;
		this.memAdd1 = memAdd1;
		this.memAdd2 = memAdd2;
		this.memHp = memHp;
		this.memMail = memMail;
		this.memJob = memJob;
		this.memLike = memLike;
		this.memMileage = memMileage;
		this.memDelYn = memDelYn;
		this.memJobNm = memJobNm;
		this.memLikeNm = memLikeNm;
	}

	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemBir() {
		return memBir;
	}
	public void setMemBir(String memBir) {
		this.memBir = memBir;
	}
	public String getMemZip() {
		return memZip;
	}
	public void setMemZip(String memZip) {
		this.memZip = memZip;
	}
	public String getMemAdd1() {
		return memAdd1;
	}
	public void setMemAdd1(String memAdd1) {
		this.memAdd1 = memAdd1;
	}
	public String getMemAdd2() {
		return memAdd2;
	}
	public void setMemAdd2(String memAdd2) {
		this.memAdd2 = memAdd2;
	}
	public String getMemHp() {
		return memHp;
	}
	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public String getMemJob() {
		return memJob;
	}
	public void setMemJob(String memJob) {
		this.memJob = memJob;
	}
	public String getMemLike() {
		return memLike;
	}
	public void setMemLike(String memLike) {
		this.memLike = memLike;
	}
	public int getMemMileage() {
		return memMileage;
	}
	public void setMemMileage(int memMileage) {
		this.memMileage = memMileage;
	}
	public String getMemDelYn() {
		return memDelYn;
	}
	public void setMemDelYn(String memDelYn) {
		this.memDelYn = memDelYn;
	}

	public String getMemJobNm() {
		return memJobNm;
	}

	public void setMemJobNm(String memJobNm) {
		this.memJobNm = memJobNm;
	}

	public String getMemLikeNm() {
		return memLikeNm;
	}

	public void setMemLikeNm(String memLikeNm) {
		this.memLikeNm = memLikeNm;
	}

}
