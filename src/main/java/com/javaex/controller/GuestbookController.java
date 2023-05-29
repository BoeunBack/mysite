package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
	//필드
	@Autowired
	private GuestbookService guestbookService;
	//생성자
	//메서드 getset
	//메서드 일반
	
	//add
	@RequestMapping(value="/guestbook/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@RequestAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.add()");
		guestbookService.addGuest(guestbookVo);
		
		return "guestbook/addList";		
	}	
	
	//리스트 
	@RequestMapping(value="/guestbook/addList", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		System.out.println("GuestbookController.addList()");
		
		List<GuestbookVo> guestbookList = guestbookService.getGuestList();		
		System.out.println(guestbookList);
		model.addAttribute("guestList", guestbookList);
		return "guestbook/addList";		
	}
	
	//진짜 삭제
	@RequestMapping(value="/guestbook/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.delete()");
		guestbookService.deleteGuest(guestbookVo);
		
		return "redirect:/addList";
	}
	//삭제폼(비밀번호 입력폼)
	@RequestMapping(value="/guestbook/deleteForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		System.out.println("Guestbook.deletFrom()");
		
		return "guestbook/deleteForm";
	}	
}
