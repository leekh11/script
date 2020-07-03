package com.study.common.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

@SuppressWarnings("serial")
public class ResultMessageVO implements Serializable {
	private boolean result;
	private String title;
	private String message;
	private String url;
	private String urlTitle;
	
	// getter/ setter 생성
	// setter 메서드는 void 가 아닌 해당 객체를 리턴하도록 변경한다.
	// Method chaining은 여러 메서드 호출을 하나의 실행문으로 호출 가능하도록 하는 형태이다.
	public ResultMessageVO(boolean result, String title, String message, String url, String urlTitle) {
		super();
		this.result = result;
		this.title = title;
		this.message = message;
		this.url = url;
		this.urlTitle = urlTitle;
	}
	
	public ResultMessageVO() {
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public boolean isResult() {
		return result;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public String getUrl() {
		return url;
	}

	public String getUrlTitle() {
		return urlTitle;
	}
	

	// 메서드 체이닝!! setter -> return this
	
	public ResultMessageVO setResult(boolean result) {
		this.result = result;
		return this;
	}

	public ResultMessageVO setTitle(String title) {
		this.title = title;
		return this;
	}

	public ResultMessageVO setMessage(String message) {
		this.message = message;
		return this;
	}

	public ResultMessageVO setUrl(String url) {
		this.url = url;
		return this;
	}

	public ResultMessageVO setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
		return this;
	}



	
}