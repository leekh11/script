package com.study.free.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.exception.DaoException;
import com.study.free.vo.FreeBoardSearchVO;
import com.study.free.vo.FreeBoardVO;


//mybatis가 자동으로 구현체를 생성해줌 
@Mapper
public interface IFreeBoardDao {
	
	public int getBoardCount( FreeBoardSearchVO searchVO) throws DaoException;
	
	/**
	 * <b>자유게시판 목록</b>을 반환한다.
	 * @param searchVO TODO
	 * @param Connection 
	 * @return 게시판목록 List&lt;FreeBoardVO&gt;
	 * @throws DaoException
	 */	
	public List<FreeBoardVO> getBoardList( FreeBoardSearchVO searchVO) throws DaoException;	
	/**
	 * 글번호에 해당하는 게시물 반환 
	 * @param conn
	 * @param boNum 
	 * @return FreeBoardVO
	 * @throws DaoException
	 */
  public FreeBoardVO getBoard( int boNum) throws DaoException;
  
  public int insertBoard(FreeBoardVO board) throws DaoException;
  
  public int updateBoard(FreeBoardVO board) throws DaoException;	
  public int deleteBoard(FreeBoardVO board) throws DaoException;
  
  /**
   * 해당 글번호의 조회수를 1 증가시킨다. 
   * @param conn
   * @param boNum
   * @return
   * @throws DaoException
   */
  public int increaseHit(int boNum) throws DaoException;
  
}