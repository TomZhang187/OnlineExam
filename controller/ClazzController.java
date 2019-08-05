package com.fs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.po.Clazz;
import com.fs.service.clazzService;
import com.fs.util.PublicDate;
import com.fs.vo.ClazzVo;


@Controller
public class ClazzController {
	
	@Autowired
	private clazzService serviceimpl;
	
	
	
	@RequestMapping("/getclazz.do")
	@ResponseBody
	public List<ClazzVo> getAllclazz(){
		List<ClazzVo> list = this.serviceimpl.getAllclazz();
		
		return  list;
		
	}
	
	@ResponseBody
	@RequestMapping("/deleteclazz.do")
	public String deleteClazz(int id) {
		
		int r = this.serviceimpl.deleteClazz(id);
		if(r==1) {
			return PublicDate.YES;
		}else {
			return PublicDate.NO;
		}
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="/addClazz.do")
	public String addClazz(String name, String major) {
		Clazz clazz = new Clazz();
		clazz.setName(name);
		clazz.setMajor(major);
		int r = this.serviceimpl.addClazz(clazz);
		if(r==1) {
			return PublicDate.YES;
		}else {
			return PublicDate.NO;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/getClazzByLike.do")
	public List<ClazzVo> getClazzByLike(String key) {
		List<ClazzVo> list = this.serviceimpl.getClazzByLike(key);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/updateByid.do")
	public String UpdateById(int id,String name,String major) {
		Clazz clazz = new Clazz();
        clazz.setId(id);
        clazz.setName(name);
        clazz.setMajor(major);
        int r = this.serviceimpl.UpdateByid(clazz);
        if(r==1) {
        	return PublicDate.YES;
        }else {
        	return PublicDate.NO;
        }
              
	}
	
	
	
	

}
