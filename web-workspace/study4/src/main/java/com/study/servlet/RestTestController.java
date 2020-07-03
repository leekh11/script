package com.study.servlet;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.free.vo.FreeBoardVO;
import com.study.member.service.IMemberService;
import com.study.member.vo.MemberVO;

@Controller
public class RestTestController {
	
	@RequestMapping("/rest/test1")
	@ResponseBody
	public String test1() {
		
		return "rest/test";
	}
	@RequestMapping("/rest/test2")
	@ResponseBody
	public FreeBoardVO test2() {
		FreeBoardVO vo = new FreeBoardVO();
		vo.setBoNum(25);
		vo.setBoTitle("오늘은 화요일입니다");
		return vo;
	}
	@Inject
	private IMemberService memberService; 
	
	@RequestMapping("/member/{memId}/{state}")
	public	@ResponseBody MemberVO test3(@PathVariable("mem") String memId
										, @PathVariable("state") String state) {
		System.out.println("memId = " + memId);
		System.out.println("state = " + state);
		MemberVO vo = memberService.getMember(memId);
		return vo;
	}
	
}
