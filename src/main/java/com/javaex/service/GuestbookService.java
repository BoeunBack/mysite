package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	@Autowired
	private GuestbookDao guestbookDao; //클래스명, Service 객체변수명.
	
	public List<GuestbookVo> getGuestList() {
		System.out.println("GuestbookService.getGuestList()");
		List<GuestbookVo> guestbookList = guestbookDao.selectGuestList();
		return guestbookList;
	}
	
	public void addGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestService.addGuest()");
		guestbookDao.addGuest(guestbookVo);	
	}
		
	public void deleteGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.deleteGuest()");
		System.out.println(guestbookVo);
		guestbookDao.deleteGuest(guestbookVo);
		
	}


/*public void addGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.addGuest()");
		System.out.println(guestbookVo);
		
		guestbookDao.insertGuest(guestbookVo);
	}*/
	}