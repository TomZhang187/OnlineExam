package com.fs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.po.Grade;
import com.fs.service.GradeService;

@Controller
public class GradeController {
	
	@Autowired
	private GradeService impl;
	
	@ResponseBody
	@RequestMapping(value="getdetails.do", produces={"application/json;charset=UTF-8"})
	public List<Grade> getStuDetails(int stu_id) {
		List<Grade> list = new ArrayList();
		list = this.impl.getGradeBystuid(stu_id);
		for (Grade grade : list) {
			grade.getExaminationName();
			System.out.println(grade);
		}
		return  list;
		
	}

}
