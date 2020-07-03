package com.study.free.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import com.study.attach.vo.AttachVO;
import com.study.common.group.Modify;

@SuppressWarnings("serial") // serializable
public class FreeBoardVO implements Serializable {
	
	@Min(value = 1, groups =Modify.class , message = "글번호 설정되지 않음!")
	private int boNum; /* 글번호 */
	@NotBlank(message = "글제목은 필수 입니다.")
	@Size(min = 2, message = "글제목은 2글자 이상으로 입력하세요" )
	private String boTitle; /* 글제목 */
	
	private String boCategory; /* 글분류 */
	@NotNull(message ="작성자는 필수 입니다")
	@Pattern(regexp = "^[가-힣]+$", message = "한글만 사용 가능")
	private String boWriter; /* 작성자명 */
	@NotBlank(message = "패스워드는 필수 입니다.")
	@Size(min = 4, max = 16, message = "패스워드는 4글자 이상 16글자 이하")
	private String boPass; /* 비밀번호 */
	private String boContent; /* 내용 */
	private String boIp; /* 등록자 IP */
	private int boHit; /* 조회수 */
	private String boRegDate; /* 등록일자 */
	private String boModDate; /* 수정일자 */
	private String boDelYn; /* 삭제 여부 */
	private String boCategoryNm; /* 글분류 명 */
	
	
	//=============================================================
	/**첨부파일 경로를 보관할 리스트
	 * freeboard : attach = 1:n 관계 (collection)
	 * 
	 */
	
	
	private List<AttachVO> attaches ; 	/* 첨부파일 리스트 */
	private int[] delAtchNos; 	/* 삭제할 대상 첨부파일 번호 */

	

	public List<AttachVO> getAttaches() {
		return attaches;
	}

	public void setAttaches(List<AttachVO> attaches) {
		this.attaches = attaches;
	}

	public int[] getDelAtchNos() {
		return delAtchNos;
	}

	public void setDelAtchNos(int[] delAtchNos) {
		this.delAtchNos = delAtchNos;
	}

	
	
	public String getBoCategoryNm() {
		return boCategoryNm;
	}

	public void setBoCategoryNm(String boCategoryNm) {
		this.boCategoryNm = boCategoryNm;
	}

	@Override
	public String toString() {
		// apache commons Lang TostringBuilder
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}


	public FreeBoardVO(int boNum, String boTitle, String boCategory, String boWriter, String boPass, String boContent,
			String boIp, int boHit, String boRegDate, String boModDate, String boDelYn, String boCategoryNm) {
		super();
		this.boNum = boNum;
		this.boTitle = boTitle;
		this.boCategory = boCategory;
		this.boWriter = boWriter;
		this.boPass = boPass;
		this.boContent = boContent;
		this.boIp = boIp;
		this.boHit = boHit;
		this.boRegDate = boRegDate;
		this.boModDate = boModDate;
		this.boDelYn = boDelYn;
		this.boCategoryNm = boCategoryNm;
	}

	public FreeBoardVO() {
		// TODO Auto-generated constructor stub
	}

	public int getBoNum() {
		return boNum;
	}

	public void setBoNum(int boNum) {
		this.boNum = boNum;
	}

	public String getBoTitle() {
		return boTitle;
	}

	public void setBoTitle(String boTitle) {
		this.boTitle = boTitle;
	}

	public String getBoCategory() {
		return boCategory;
	}

	public void setBoCategory(String boCategory) {
		this.boCategory = boCategory;
	}

	public String getBoWriter() {
		return boWriter;
	}

	public void setBoWriter(String boWriter) {
		this.boWriter = boWriter;
	}

	public String getBoPass() {
		return boPass;
	}

	public void setBoPass(String boPass) {
		this.boPass = boPass;
	}

	public String getBoContent() {
		return boContent;
	}

	public void setBoContent(String boContent) {
		this.boContent = boContent;
	}

	public String getBoIp() {
		return boIp;
	}

	public void setBoIp(String boIp) {
		this.boIp = boIp;
	}

	public int getBoHit() {
		return boHit;
	}

	public void setBoHit(int boHit) {
		this.boHit = boHit;
	}

	public String getBoRegDate() {
		return boRegDate;
	}

	public void setBoRegDate(String boRegDate) {
		this.boRegDate = boRegDate;
	}

	public String getBoModDate() {
		return boModDate;
	}

	public void setBoModDate(String boModDate) {
		this.boModDate = boModDate;
	}

	public String getBoDelYn() {
		return boDelYn;
	}

	public void setBoDelYn(String boDelYn) {
		this.boDelYn = boDelYn;
	}

}
