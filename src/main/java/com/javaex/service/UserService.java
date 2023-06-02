package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
//	회원가입
	public void join(UserVo userVo) {
		System.out.println(userVo);
		userDao.insertUser(userVo);
		
	}
	
	
	//로그인
	public 	UserVo login(UserVo userVo) {
		System.out.println(userVo);
		
		UserVo authUser = userDao.selectUser(userVo);
		System.out.println(authUser);
		return authUser;
	}
	
	//수정폼 부르기
	public UserVo modifyForm(int no) {
		System.out.println("UserService.modifyForm()");
		System.out.println(no);
		UserVo userVo = userDao.selectUser(no);
		return userVo;		
	}
	
	//수정
	public void modify(UserVo userVo) {
		System.out.println("UserService.modify()");
		userDao.updateUser(userVo);
	
	}
	
	//
	public UserVo idcheck(String id ) {
		System.out.println("UserService.getUser()");
		System.out.println(id);
		UserVo userVo = userDao.selectUser(id);
		System.out.println(userVo);
		
		return userVo;
	}
	
	

}
//회원등록
//	public int join(UserVo userVo) {
//		System.out.println("UserService.join()");
//		System.out.println(userVo);
//		
//		int count = userDao.insertUser(userVo);
//		return count;

