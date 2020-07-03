package com.study.member.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.code.service.ICommonCodeService;
import com.study.code.vo.CodeVO;
import com.study.common.vo.ResultMessageVO;
import com.study.exception.BizDuplicateException;
import com.study.exception.BizNotEffectedException;
import com.study.exception.BizNotFoundException;
import com.study.exception.BizPasswordNotMatchedException;
import com.study.free.vo.FreeBoardVO;
import com.study.member.service.IMemberService;
import com.study.member.vo.MemberSearchVO;
import com.study.member.vo.MemberVO;

@Controller
public class MemberController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	IMemberService memberService;
	@Autowired
	ICommonCodeService codeService; 
	
	@ModelAttribute("jobList")
	public List<CodeVO> JobDate(){
		logger.debug("codeList 처리");
		List<CodeVO> jobList = codeService.getCodeListByParent("JB00");
		return jobList;
	}
	@ModelAttribute("likeList")
	public List<CodeVO> LikeDate(){
		logger.debug("codeList 처리");
		List<CodeVO> likeList = codeService.getCodeListByParent("HB00");
		return likeList;
	}
	
	@RequestMapping("/member/memberList.wow")
	public ModelAndView memberList(@ModelAttribute("searchVO") MemberSearchVO searchVO) throws Exception {
		logger.debug("List 메서드 진입");
		logger.debug("searchVO= {}" , searchVO);		
		ModelAndView mav = new ModelAndView();

		List<MemberVO> list = memberService.getMemberList(searchVO);

		mav.addObject("memberList", list);
		mav.setViewName("member/memberList");
		
		return mav;
	}
	
	@RequestMapping("/member/memberView.wow")
	public String memberView(@RequestParam(name = "memId", required = false, defaultValue = "1") String id , Model model ) throws Exception {

		try {
			MemberVO member = memberService.getMember(id);

			model.addAttribute("member", member);

			return "member/memberView";
		} catch (BizNotFoundException e) {
			logger.warn(e.getMessage() , e);
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false)
				.setTitle("회원 가입 실패")
				.setMessage("해당 페이지 정보를 찾지 못했습니다.!")
				.setUrl("memberList.wow")
				.setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}
	
	@RequestMapping(value = "/member/memberEdit.wow" , method = RequestMethod.GET)
	public String memberEdit(String memId, Model model) throws Exception {
		logger.debug("memId= {}" , memId);
		try {
			MemberVO member = memberService.getMember(memId);
			model.addAttribute("member", member);
			return "member/memberEdit";
		} catch (BizNotFoundException e) {
			logger.warn(e.getMessage() , e);
			ResultMessageVO vo = new ResultMessageVO();
			vo.setResult(false).setTitle("회원 조회 실패")
										 .setMessage("해당 회원이이 존재하지 않거나 삭제 되었습니다")
										 .setUrl("memberList.wow")
										 .setUrlTitle("목록으로");
			model.addAttribute("messageVO", vo);
			return "common/message";
		}
	}
	
	@RequestMapping(value = "/member/memberModify.wow" , method = RequestMethod.POST)
	public String memberModify(@ModelAttribute("member") @Valid MemberVO member,
								BindingResult errors,
								Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		
		try {
			if(errors.hasErrors()) {
				return "member/memberEdit";
			}
			memberService.modifyMember(member);
			messageVO.setResult(true).setTitle("회원 수정 성공").setMessage("회원 수정 성공!").setUrl("memberList.wow")
			.setUrlTitle("목록으로");
		} catch (BizNotFoundException e) {
			logger.warn(e.getMessage() , e);

			messageVO.setResult(false)
								.setTitle("회원 수정 실패")
								.setMessage("해당 회원이 존재하지 않습니다!").setUrl("memberList.wow")
					.setUrlTitle("목록으로");

		} catch (BizPasswordNotMatchedException e) {
			logger.warn(e.getMessage() , e);
			messageVO.setResult(false)
								.setTitle("회원 수정 실패")
								.setMessage("비밀번호를 확인하여 주세요!");

		} catch(BizNotEffectedException e) {
			logger.warn(e.getMessage() , e);
			messageVO.setResult(false)
								.setTitle("회원 수정 실패")
								.setMessage("해당 회원 정보를 변경하지 못했습니다.!")
								.setUrl("memberList.wow")
								.setUrlTitle("목록으로");
		}
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}
	
	@RequestMapping(value = "/member/memberForm.wow" )
	public String memberForm(Model model) throws Exception {
		
		model.addAttribute("board", new FreeBoardVO());
		return "member/memberForm";
	}
	
	@RequestMapping(value = "/member/memberRegist.wow", method = RequestMethod.POST)
	public String memberRegist(@ModelAttribute("member") @Valid MemberVO member,
								BindingResult errors,
								Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		try {
			if(errors.hasErrors()) {
				return "member/memberForm";
			}
			memberService.registMember(member);
			messageVO.setResult(true)
								.setTitle("회원 가입 성공")
								.setMessage("회원가입 성공!")
								.setUrl("memberList.wow")
								.setUrlTitle("목록으로");
		} catch (BizDuplicateException e) {
			logger.warn(e.getMessage() , e);
			messageVO.setResult(false)
								.setTitle("회원 가입 실패")
								.setMessage("해당 아이디는 사용중입니다.!")
								.setUrl("memberList.wow")
								.setUrlTitle("목록으로");
		} 
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}
	
	@RequestMapping(value = "/member/memberRemove.wow" , method = RequestMethod.POST)
	public String memberRemove(@ModelAttribute("member") @Valid MemberVO member,
							BindingResult errors,
							Model model) throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		
		try {
			if(errors.hasErrors()) {
				return "member/memberEdit";
			}
			memberService.removeMember(member);
			messageVO.setResult(true)
								.setTitle("회원 삭제 성공")
								.setMessage("회원 삭제 성공!")
								.setUrl("memberList.wow")
								.setUrlTitle("목록으로");
		} catch (BizNotFoundException e) {
			e.printStackTrace();

			messageVO.setResult(false)
								.setTitle("회원 삭제 실패")
								.setMessage("해당 회원이 존재하지 않습니다!").setUrl("memberList.wow")
								.setUrlTitle("목록으로");

		} catch (BizPasswordNotMatchedException e) {
			e.printStackTrace();
			messageVO.setResult(false)
								.setTitle("회원 삭제 실패")
								.setMessage("비밀번호를 확인하여 주세요!");

		} catch(BizNotEffectedException e) {
			e.printStackTrace();
			messageVO.setResult(false)
								.setTitle("회원 삭제 실패")
								.setMessage("해당 회원 정보를 변경하지 못했습니다.!")
								.setUrl("memberList.wow")
								.setUrlTitle("목록으로");
		}



		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}
	
	
	
}
