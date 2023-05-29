package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void addGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.addGuest()");
		sqlSession.insert("guestbook.insertGuest", guestbookVo);
	}
	
	
	
	public List<GuestbookVo> selectGuestList() {
		System.out.println("GuestbookDao.selectGuestList()");
		List<GuestbookVo> guestbookList = sqlSession.selectList("guestbook.selectList");
		return guestbookList;
	}
	
	
	public int deleteGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.deleteGuest()");
		int count = sqlSession.delete("guestbook.delete", guestbookVo);
		System.out.println(count);
		return count;
	}
/*public void insertGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.insertGuest()");
		sqlSession.insert("guestbook.insert",guestbookVo);	
	}*/}
