package com.study.free.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.groups.Default;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.study.attach.vo.AttachVO;
import com.study.code.service.ICommonCodeService;
import com.study.code.vo.CodeVO;
import com.study.common.group.Regist;
import com.study.common.util.StudyAttachUtils;
import com.study.common.vo.ResultMessageVO;
import com.study.exception.BizNotEffectedException;
import com.study.exception.BizNotFoundException;
import com.study.exception.BizPasswordNotMatchedException;
import com.study.free.service.IFreeBoardService;
import com.study.free.vo.FreeBoardSearchVO;
import com.study.free.vo.FreeBoardVO;

@Controller
public class FreeBoardController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	// 스프링에서는 new 생성자 x
	@Autowired
	private IFreeBoardService boardService; // = new FreeBoardServiceImpl();
	@Autowired
	private ICommonCodeService codeService; // = new CommonCodeServiceImpl();
	@Autowired
	private StudyAttachUtils attachUtils;

	/*
	 * @Autowired public void setCodeService(ICommonCodeService codeService) {
	 * this.codeService = codeService; }
	 */

	// 컨트롤러에서 반복적으로 사용되는 참조데이터(코드성자료)
	// 요청 메서드 전에 모델에 담아주는 것 -> @ModelAttribute
	@ModelAttribute("cateList")
	public List<CodeVO> categoryDate() {
		logger.debug("codeList 처리");
		List<CodeVO> codeList = codeService.getCodeListByParent("BC00");
		return codeList;
	}

	// ModelAndView에 모델정보와 뷰이름을 담고 리턴
	// 파라미터에 커멘드 객체(VO)를 사용하면 요청파라미터 바인딩, 모델에 저장
	// 모델에 저장되는 이름이 클래스이름(첫글자 소문자)
	@RequestMapping("/free/freeList.wow")
	public ModelAndView freeList(@ModelAttribute("searchVO") FreeBoardSearchVO searchVO) throws Exception {
		logger.debug("List 메서드 진입");
		logger.debug("searchVO= {}", searchVO);
		ModelAndView mav = new ModelAndView();

		List<FreeBoardVO> list = boardService.getBoardList(searchVO);

		// 과정 4. 모델로 부터 전달 받은 결과물을 속성에 저장
		mav.addObject("freeList", list);
		mav.setViewName("free/freeList");

		return mav;
	}

	// 메서드 파라미터에 프리미티형 기술 자동으로 요청 파라미터이름과 같다면 바인딩
	// 만약, 요청파라미터 이름 변수이름이 다르면 @RequestParam
	@RequestMapping("/free/freeView.wow")
	public String freeView(@RequestParam(name = "boNum", required = false, defaultValue = "333") int boNum, Model model)
			throws Exception {
		try {
			boardService.increaseHit(boNum);

			FreeBoardVO board = boardService.getBoard(boNum);
			if (board != null) {
				boardService.increaseHit(boNum);
			}
			model.addAttribute("board", board);

			return "free/freeView";
		} catch (BizNotFoundException e) {
			logger.warn(e.getMessage(), e);
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle("게시판 조회 실패").setMessage("해당 게시물이 존재하지 않거나 삭제 되었습니다").setUrl("freeList.wow")
					.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}

	}

	@RequestMapping(value = "/free/freeEdit.wow", method = RequestMethod.GET)
	public String freeEdit(int boNum, Model model) throws Exception {
		logger.debug("boNum= {}", boNum);
		// validation
		try {
			FreeBoardVO board = boardService.getBoard(boNum);

			model.addAttribute("board", board);

			return "free/freeEdit";
		} catch (BizNotFoundException e) {
			logger.warn(e.getMessage(), e);
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle("게시판 조회 실패").setMessage("해당 게시물이 존재하지 않거나 삭제 되었습니다").setUrl("freeList.wow")
					.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}

	@RequestMapping(value = "/free/freeModify.wow", method = RequestMethod.POST)
	public String freeModify(@ModelAttribute("board") @Valid FreeBoardVO freeboard, BindingResult errors,
			HttpServletRequest req, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		try {
			// 검증
//			if(StringUtils.isEmpty(freeboard.getBoTitle())) {}
			if (errors.hasErrors()) {
//				model.addAttribute("board" , freeboard)
				return "free/freeEdit";
			}

			freeboard.setBoIp(req.getRemoteAddr());
			boardService.modifyBoard(freeboard);

			messageVO.setResult(true).setTitle("게시판 수정 성공").setMessage("게시판 수정 성공!").setUrl("freeList.wow")
					.setUrlTitle("목록으로");
			// 없음/ 수정안됨/ 패스워드 일치
		} catch (BizNotFoundException e) {
			e.printStackTrace();

			messageVO.setResult(false).setTitle("게시판 수정 실패").setMessage("해당 게시물이 존재하지 않습니다!").setUrl("freeList.wow")
					.setUrlTitle("목록으로");

		} catch (BizPasswordNotMatchedException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("게시판 수정 실패").setMessage("비밀번호를 확인하여 주세요!");

		} catch (BizNotEffectedException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("게시판 수정 실패").setMessage("해당 게시물 정보를 변경하지 못했습니다.!")
					.setUrl("freeList.wow").setUrlTitle("목록으로");
		}
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping(value = "/free/freeForm.wow")
	public String freeForm(Model model) throws Exception {
		model.addAttribute("board", new FreeBoardVO());
		return "free/freeForm";
	}

	@RequestMapping(value = "/free/freeRegist.wow", method = RequestMethod.POST)
	public String freeRegist(@RequestParam(name = "boFiles", required = false) MultipartFile[] boFiles,
			HttpServletRequest req,
			@ModelAttribute("board") @Validated(value = { Default.class, Regist.class }) FreeBoardVO freeboard,
			BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			return "free/freeForm";
		}
		// 첨부파일이 있는지 확인
		if (boFiles != null) {
			logger.debug("----------------------------------");
			List<AttachVO> attaches = attachUtils.getAttachListByMultiparts(boFiles, "FREE", "freeboard");
			freeboard.setAttaches(attaches);
			logger.debug("---------------------------------");
		}

		freeboard.setBoIp(req.getRemoteAddr());
		boardService.registBoard(freeboard);
		return "redirect:freeList.wow";
	}

	@RequestMapping(value = "/free/freeDel.wow", method = RequestMethod.POST)
	public String freeDel(@ModelAttribute("board") @Valid FreeBoardVO freeboard, BindingResult errors,
			HttpServletRequest req, Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		try {
			// 검증
//			if(StringUtils.isEmpty(freeboard.getBoTitle())) {}
			if (errors.hasErrors()) {
//				model.addAttribute("board" , freeboard)
				return "free/freeEdit";
			}

			freeboard.setBoIp(req.getRemoteAddr());
			boardService.removeBoard(freeboard);

			messageVO.setResult(true).setTitle("게시판 삭제 성공").setMessage("게시판 삭제 성공!").setUrl("freeList.wow")
					.setUrlTitle("목록으로");
			// 없음/ 수정안됨/ 패스워드 일치
		} catch (BizNotFoundException e) {
			e.printStackTrace();

			messageVO.setResult(false).setTitle("게시판 삭제 실패").setMessage("해당 게시물이 존재하지 않습니다!").setUrl("freeList.wow")
					.setUrlTitle("목록으로");

		} catch (BizPasswordNotMatchedException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("게시판 삭제 실패").setMessage("비밀번호를 확인하여 주세요!");

		} catch (BizNotEffectedException e) {
			e.printStackTrace();
			messageVO.setResult(false).setTitle("게시판 삭제 실패").setMessage("해당 게시물 정보를 변경하지 못했습니다.!")
					.setUrl("freeList.wow").setUrlTitle("목록으로");
		}
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping("/free/test1.wow")
	public String test1(Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		boardService.test1();
		messageVO.setResult(false).setTitle("게시판 트랜잭션 테스트1").setMessage("모든 정보가 성공적일때, DB 확인 요망 ");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping("/free/test2.wow")
	public String test2(Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		boardService.test2();
		messageVO.setResult(false).setTitle("게시판 트랜잭션 테스트2").setMessage("일부 정보가 실패일때(Checked Exception), DB 확인 요망 ");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

	@RequestMapping("/free/test3.wow")
	public String test3(Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		boardService.test3();
		messageVO.setResult(false).setTitle("게시판 트랜잭션 테스트3").setMessage("일부 정보가 실패일때(UnChecked Exception), DB 확인 요망 ");
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}

}
