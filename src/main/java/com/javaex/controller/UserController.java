package com.javaex.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	
	//회원가입
	@RequestMapping(value="/user/join", method= {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("Controller.join()");
		userservice.join(userVo);
		return "/WEB-INF/views/user/joinOk.jsp";
		
	}

	// 회원가입 폼
	@RequestMapping(value = "/user/joinForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {
		System.out.println("UserController.joinForm()");
		return "/WEB-INF/views/user/joinForm.jsp";
	}

	/* 회원가입
	@RequestMapping(value = "/user/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.join()");

		int count = userservice.join(userVo);
		if (count > 0) {
			return "/WEB-INF/views/user/joinOk.jsp";
		} else {
			return "redirect:/user/joinForm";
		}
	}*/

	// 로그인폼
	@RequestMapping(value = "/user/loginForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.loginForm()");
		return "/WEB-INF/views/user/loginForm.jsp";
	}

	// 로그인 되기
	@RequestMapping(value = "/user/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.login()");
		UserVo authUser = userservice.login(userVo);
		System.out.println(authUser);
		
		if(authUser != null) {//로그인성공 했을 때
			System.out.println("로그인 성공");
			//세션에 저장
			session.setAttribute("authUser", authUser);
			//메인으로 리다이렉트
			return "redirect:/main";
			
		}else {//로그인 실패시
			System.out.println("로그인 실패");
			//로그인폼으로 보내기
			return "redirect:/user/loginForm?result=fail";
		}		
	}
	
	//로그아웃
	@RequestMapping(value="/user/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController.logout()");
		session.removeAttribute("authUser"); //세션날라감
		session.invalidate(); 
		return "/WEB-INF/views/main/main.jsp";
	}
	
	// 회원 정보가져온 수정폼
	@RequestMapping(value = "/user/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(HttpSession session, Model model) {
		System.out.println("UserController.modifyForm()");
		
		session.getAttribute("authUser");//세션에서 authUser부르기		
		UserVo authUser = (UserVo)session.getAttribute("authUser");// 세션에 넣었던 이름그대로 형변환해서 꺼내기(번호와 이름)
		
		int no = authUser.getNo();//값을 getNo 번호만 뽑기
		
		UserVo userVo = userservice.modifyForm(no);
		System.out.println(userVo);
		model.addAttribute("modifyUser",userVo);
		
		return "/WEB-INF/views/user/modifyForm.jsp";
	}
	
	//회원정보 수정
	@RequestMapping(value="/user/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.modify()");
		UserVo vo = (UserVo)session.getAttribute("authUser");
		userVo.setNo(vo.getNo());	
		userservice.modify(userVo);	
		vo.setName(userVo.getName());
		
		
		return "redirect:/user/modifyForm";
	}
}
