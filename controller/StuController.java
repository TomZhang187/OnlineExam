package com.fs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.po.Stu;
import com.fs.po.Clazz;
import com.fs.service.StuService;
import com.fs.util.PublicDate;
import com.fs.vo.ClazzVo;
import com.fs.po.Stu;

@Controller
public class StuController {
	
	@Autowired
	private StuService service;
	
	@ResponseBody
	@RequestMapping("/getstubyclzzid.do")
	public List<Stu> getStuByclazzid(int clazzId) {
		List<Stu> list = new ArrayList();
		list = this.service.getAllStuByclazzid(clazzId);
		
		return list;
	}
	
	
	@RequestMapping("/intoStu.do")
	public String intoStu(int clazzId, String clazzName, HttpServletRequest req) {
		Clazz cla = new Clazz();
		cla.setId(clazzId);
		cla.setName(clazzName);
		req.setAttribute("clazz", cla);
		return "/WEB-INF/stu.jsp"; 
	}
	
	@ResponseBody
	@RequestMapping("/search.do")
	public List<Stu> getStu(String key,int 	clazzId){
		System.out.println(key);
		System.out.println(clazzId);
	    List<Stu> list = new ArrayList();
		Stu stu = new Stu();
		stu.setClazzId(clazzId);	
		stu.setName(key);		
	    list = this.service.getStu(stu);		
		return list;	
	}
	
	@ResponseBody
	@RequestMapping("/addstu.do")
	public String addStu(String name,String sex,int age,String no,String pwd,int clazz) {
		
		Stu stu = new Stu();
		stu.setName(name);
		stu.setSex(sex);
		stu.setClazzId(clazz);
		stu.setAge(age);
		stu.setNo(no);
		stu.setPwd(pwd);
		
		int r = this.service.addStu(stu);	
		if(r==1) {
			return PublicDate.YES;
		}else {
			return PublicDate.NO;
		}
	}
    
	@ResponseBody
	@RequestMapping("/deletestu.do")
	public String deletestu(int id) {
		
		int r = this.service.deleteStu(id);
		if(r==1) {
			return  PublicDate.YES;
		}else {
			return PublicDate.NO;
		}
	}
	
	
	@ResponseBody
	@RequestMapping("updateStu.do")
    public String UpdateStu(String name,String no,String pwd,String sex,int clazzid) {
    	Stu stu = new Stu();
    	stu.setName(name);
    	stu.setNo(no);
    	stu.setPwd(pwd);
    	stu.setSex(sex);
    	stu.setClazzId(clazzid);
    	int r = this.service.updateByid(stu);
    	
    	if(r==1) {
    		return PublicDate.YES;
    	}else {
    		return PublicDate.NO;
    	}	
    }
	
	@ResponseBody
	@RequestMapping("/updatepwd.do")
	public String update(String no,String pwd) {
		Stu stu = new Stu();
		stu.setNo(no);
		stu.setPwd(pwd);
		int r = this.service.updateByid(stu);
		if(r==1) {
			return PublicDate.YES;
		}else {
			return PublicDate.NO;
		}
		
		
		
	}
	
	@RequestMapping("/toStudentPage.do")
	public String toStuMain () {
		
		return "/WEB-INF/stuMain.html";
	}
	
	@RequestMapping("/toquerygrade.do")
	public String toquerygrade() {
		return "/WEB-INF/querygrade.html";
	}
	
	@RequestMapping("/tojoinexam.do")
	public String tojoinexam() {
		return "/WEB-INF/joinexam.html";
	}
	
	
	
	
	
	
	
	

}
