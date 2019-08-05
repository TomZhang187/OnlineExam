package com.fs.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.po.Stu;
import com.fs.po.Teacher;
import com.fs.service.StuService;
import com.fs.service.teacherService;

@Controller
public class CommController {
	
	@Autowired
	private teacherService teacherserviceImpl;
	
	@Autowired
	private StuService stuimpl;
	
	
	@RequestMapping("login.do")
	public String login(String no,String pwd,String role,HttpServletResponse resp) {
		
			if("teacher".equals(role)) {  //老师登录
				
			Teacher tc = this.teacherserviceImpl.login(no, pwd);
			System.out.println(tc.getId());
			
			if(tc!=null) {  //成功
				String teacherJson = null;
				
				//转码
				try {
					teacherJson = URLEncoder.encode(tc.toString(),"UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Cookie cookie = new Cookie("teacher",teacherJson);
//				cookie.setMaxAge(60*60*24);
				resp.addCookie(cookie);
				
				return "/WEB-INF/teacher.html";
			}else {//失败
				return "/login.html";
			}	
		}else if("student".equals(role)) {//学生登录
			return "/login.html";
			
		}else {//有问题
			return "/login.html";
			
		}	
		
	}
	
	@ResponseBody
	@RequestMapping("/ajaxlogin.do")
	public Object ajaxlogin(String no,String pwd,String role,HttpServletResponse resp) {
		
		
		if("teacher".equals(role)) {
			Teacher teacher = this.teacherserviceImpl.login(no, pwd);
			return teacher;
		}else if("student".equals(role)) {
			Stu student = new Stu();
			student = this.stuimpl.selectStubynoandpwd(no, pwd);
			System.out.println(student);
			return student;
		}else {
			return null;
		}
				
		
		
		
	}
	
	

}
