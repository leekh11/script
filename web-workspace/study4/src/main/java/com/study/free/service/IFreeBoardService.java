package com.study.free.service;

import java.util.List;

import com.study.exception.BizException;
import com.study.free.vo.FreeBoardSearchVO;
import com.study.free.vo.FreeBoardVO;

public interface IFreeBoardService {
	public List<FreeBoardVO> getBoardList(FreeBoardSearchVO searchVO) throws BizException;

	public FreeBoardVO getBoard(int boNum) throws BizException;

	public void registBoard(FreeBoardVO board) throws BizException;

	public void modifyBoard(FreeBoardVO board) throws BizException;

	public void removeBoard(FreeBoardVO board) throws BizException;

	public void increaseHit(int boNum) throws BizException;

	// transaction test 를 위한 임시 메서드
	public void test1() throws Exception;

	public void test2() throws Exception;

	public void test3() throws Exception;

}