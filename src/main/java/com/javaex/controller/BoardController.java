package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(@RequestParam(value="keyword", required = false, defaultValue = "" ) String keyword, Model model) {
		System.out.println("BoardController.list()");
		List<BoardVo> boardList = boardService.getList(keyword);
		model.addAttribute("boardList", boardList);
		return "/board/list";
	}
	
	@RequestMapping(value="/board/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("BoardController.writeForm()");
		
		return "/board/writeForm";
	}
	
	@RequestMapping(value="/board/insert", method= {RequestMethod.GET, RequestMethod.POST})
	public String insert(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController.insert()");
		boardVo.set
	
		
		return "";
	}
	
}
