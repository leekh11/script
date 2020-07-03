package com.study.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.study.exception.BizNotEffectedException;
import com.study.exception.BizNotFoundException;
import com.study.member.dao.IMemberDao;
import com.study.member.vo.MemberSearchVO;
import com.study.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements IMemberService {

	@Autowired
	private IMemberDao MemberDao;

	@Override
	public void registMember(MemberVO member) {
		try {
		int cnt = MemberDao.InsertMember(member);
		if (cnt < 1) {
			throw new BizNotEffectedException("회원등록이 되지 않았습니다.", member);
		}
		}catch (DuplicateKeyException e) {
			throw new DuplicateKeyException(e.getMessage(), e);
		}
	}

	@Override
	public void modifyMember(MemberVO member) {
		int cnt = MemberDao.updateMember(member);
		if (cnt < 1) {
			throw new BizNotEffectedException("회원등록이 수정 되지 않았습니다.", member);
		}
	}

	@Override
	public void removeMember(MemberVO member) {
		@SuppressWarnings("unused")
		int cnt = MemberDao.deleteMember(member);
	}

	@Override
	public MemberVO getMember(String memId) {
		MemberVO member = MemberDao.getMember(memId);
		if (member == null) {
			throw new BizNotFoundException("회원 [" + memId + "] 조회 실패");
		}
		return member;
	}

	@Override
	public List<MemberVO> getMemberList(MemberSearchVO searchVO) {
		int cnt = MemberDao.getMemberCount(searchVO);
		searchVO.setTotalRowCount(cnt);
		searchVO.setting();
		List<MemberVO> list = MemberDao.getMemberList(searchVO);
		return list;
	}

}
