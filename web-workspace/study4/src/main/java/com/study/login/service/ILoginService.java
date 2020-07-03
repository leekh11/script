package com.study.login.service;

import com.study.exception.BizException;
import com.study.login.vo.UserVO;

public interface ILoginService {
	/**
	 * 사용자 로그인 체크 <br>
	 * 사용자가 없을때 : BizNotFoundEx.. <br>
	 * 패스워드 틀리때 : BizPasswordNotMatchedEx.. <br>
	 * @param user
	 * @return
	 * @throws BizException
	 */
	public UserVO loginCheck(UserVO user) throws BizException;
	
	/**
	 * 로그아웃 할때 처리 <br>
	 * 로그아웃 기록  
	 * @param user
	 * @throws BizException
	 */
	public void logout(UserVO user) throws BizException;
	
}
