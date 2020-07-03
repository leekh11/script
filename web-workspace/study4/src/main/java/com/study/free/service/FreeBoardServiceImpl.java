package com.study.free.service;

import java.util.List;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.attach.dao.IAttachDao;
import com.study.attach.vo.AttachVO;
import com.study.exception.BizException;
import com.study.exception.BizNotEffectedException;
import com.study.exception.BizNotFoundException;
import com.study.exception.BizPasswordNotMatchedException;
import com.study.free.dao.IFreeBoardDao;
import com.study.free.vo.FreeBoardSearchVO;
import com.study.free.vo.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements IFreeBoardService {

	@Autowired
	private IFreeBoardDao freeBoardDao;
	@Autowired
	private IAttachDao attachDao;

	@Override
	public List<FreeBoardVO> getBoardList(FreeBoardSearchVO searchVO) throws BizException {
		// 페이징 계산
		int cnt = freeBoardDao.getBoardCount(searchVO);
		searchVO.setTotalRowCount(cnt);
		searchVO.setting();
		List<FreeBoardVO> list = freeBoardDao.getBoardList(searchVO);

		// 목록의 첨부파일을 가져오기 위해

		// n+1쿼리 (한번의 쿼리에 하위쿼리 n번이 발생)
//		if (list != null) {
//			for (FreeBoardVO vo : list) {
//				vo.setAttaches(attachDao.getAttachByParentNoList(vo.getBoNum()));
//			}
//		}

		return list;
	}

	@Override
	public FreeBoardVO getBoard(int boNum) throws BizException {
		FreeBoardVO freeBoard = freeBoardDao.getBoard(boNum);
		if (freeBoard == null) {
			throw new BizNotFoundException("게시판[" + boNum + "] 조회 실패 ");
		}
		freeBoard.setAttaches(attachDao.getAttachByParentNoList(boNum));
		return freeBoard;
	}

	@Override
	public void registBoard(FreeBoardVO board) throws BizException {
		int cnt = freeBoardDao.insertBoard(board);
		if (cnt < 1) {
			throw new BizNotEffectedException("게시판등록이 되지 않았습니다.", board);
		}
		// 첨부파일이 존재하는 경우 첨부파일 등록 , parentNo 설정 필요
		List<AttachVO> atchList = board.getAttaches();
		if (atchList != null) {
			for (AttachVO vo : atchList) {
				vo.setAtchParentNo(board.getBoNum());
				attachDao.insertAttach(vo);
			}
		}
	}

	@Override
	public void modifyBoard(FreeBoardVO board) throws BizException {
		// 패스워드 비교
		FreeBoardVO vo = freeBoardDao.getBoard(board.getBoNum());
		if (vo == null) {
			throw new BizNotFoundException("글번호 [" + board.getBoNum() + "]이 존재하지 않습니다.");
		}
		if (!vo.getBoPass().equals(board.getBoPass())) {
			throw new BizPasswordNotMatchedException("패스워드가 일치하지 않습니다.");
		}
		int cnt = freeBoardDao.updateBoard(board);
		if (cnt < 1) {
			throw new BizNotEffectedException("게시판 수정이 되지 않았습니다.", board);
		}
	}

	@Override
	public void removeBoard(FreeBoardVO board) throws BizException {
		// 패스워드 비교
		FreeBoardVO vo = freeBoardDao.getBoard(board.getBoNum());
		if (!vo.getBoPass().equals(board.getBoPass())) {
			throw new BizPasswordNotMatchedException("패스워드가 일치하지 않습니다.");
		}

		int cnt = freeBoardDao.deleteBoard(board);
		if (cnt < 1) {
			throw new BizNotEffectedException("게시판 삭제가 되지 않았습니다.", board);
		}
	}

	@Override
	public void increaseHit(int boNum) throws BizException {
		freeBoardDao.increaseHit(boNum);
	}
	
	private FreeBoardVO dummyCreate() {
	    FreeBoardVO vo = new FreeBoardVO();
	    vo.setBoCategory("BC01");
	    vo.setBoTitle("트랜잭션 테스트를 하고 있습니다.");
	    vo.setBoWriter("밀키스");
	    vo.setBoPass("1004");
	    vo.setBoContent("트랜잭션 테스트");
	    vo.setBoIp("192.168.10.14");
	    return vo;
	}

	@Override
	public void test1() throws Exception {
		// 2개의 쿼리가 모두 정상적인 경우
		FreeBoardVO board = dummyCreate();
		freeBoardDao.insertBoard(board);
		freeBoardDao.insertBoard(board);
	}

	@Override
	public void test2() throws Exception {
		// 2개의 쿼리 실행 후 CheckedException을 던졌을 때
		FreeBoardVO board = dummyCreate();
		freeBoardDao.insertBoard(board);
		freeBoardDao.insertBoard(board);
		throw new DataFormatException("날짜 형식이 올바르지 않습니다.");
	}

	@Override
	public void test3() throws Exception {
		// 2개의 쿼리 실행 후 UnCheckedException을 던졌을 때
		FreeBoardVO board = dummyCreate();
		freeBoardDao.insertBoard(board);
		freeBoardDao.insertBoard(board);
		throw new BizNotEffectedException("해당 정보를 등록하지 못했습니다.");
	}

}