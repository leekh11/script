package com.study.code.service;

import java.util.List;

import com.study.code.vo.CodeVO;
import com.study.exception.BizException;

public interface ICommonCodeService {

	List<CodeVO> getCodeListByParent(String code) throws BizException;

}
