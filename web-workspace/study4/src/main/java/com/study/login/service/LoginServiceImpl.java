package com.study.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.exception.BizException;
import com.study.exception.BizNotFoundException;
import com.study.exception.BizPasswordNotMatchedException;
import com.study.login.vo.UserVO;
import com.study.member.dao.IMemberDao;
import com.study.member.vo.MemberVO;

@Service
public class LoginServiceImpl  implements ILoginService{
	
	@Autowired
	private IMemberDao memberDao;
	
	@Override
	public UserVO loginCheck(UserVO user) throws BizException {
			MemberVO member = memberDao.getMember(user.getUserId());		
			if(member == null) {
				throw new BizNotFoundException("회원 [" + user.getUserId() + "] 조회 실패");
			}
			if( ! member.getMemPass().equals(user.getUserPass())) {
				throw new BizPasswordNotMatchedException("입력하시 패스워드가 올바르지 않습니다.");
			}
			UserVO vo = new UserVO();
			vo.setUserId(user.getUserId());
			vo.setUserPass(user.getUserPass());
			vo.setUserName(member.getMemName());
			vo.setUserRole("MEMBER");
			return vo;
	}

	@Override
	public void logout(UserVO user) throws BizException {
		
		
		
	}

}
