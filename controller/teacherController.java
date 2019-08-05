package com.fs.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fs.service.teacherService;

@Controller
public class teacherController {
	
	@Autowired
	public teacherService teacherServiceImpl;
	
	@RequestMapping("/subject.do")
	public String  subject(HttpServletRequest req) {	
			return "/WEB-INF/subject.html";					
	}
	
	@RequestMapping("/toTeacherPage.do")
	public String toTeacherPage() {
		return "/WEB-INF/teacher.html";
	}
	
	@RequestMapping("/toclazz.do")
	public String  clazz(HttpServletRequest req) {
		
		
		return "/Clazz.html";	
//		boolean flag = false; //是否登陆过
//		Cookie[] cookies = req.getCookies();
//		System.out.println(cookies);
//		if(cookies==null) {
//			System.out.println("cookies为空");
//			return "/login.html";
//		}else {//如果Cookie不为null
//			for (Cookie cookie2 : cookies) {
//				System.out.println(cookie2);
//				String name = cookie2.getName();
//				if("teacher".equals(name)) {
//					System.out.println("flag");
//					flag = true;
//					break;
//				}					
//			}
//			
//		}
//		if(flag) { //登录过
//			System.out.println("1223");
//			return "/WEB-INF/clazz.html";					
//		}else {//没有登录过
//			return "/login.html";
//		}			
		
		
	}
	
	
	
	
	
}
