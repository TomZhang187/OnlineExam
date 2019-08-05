package com.fs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.po.Examination;
import com.fs.po.Grade;
import com.fs.po.Subject;
import com.fs.service.ExaminationService;
import com.fs.service.GradeService;
import com.fs.service.SubjectService;
import com.fs.util.PublicDate;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectService impl;
	
	@Autowired
	private ExaminationService examimpl;
	
	@Autowired
	private GradeService gradeimpl;
	
	@ResponseBody
	@RequestMapping("showsubject.do")
	public List<Subject> getAllSubject(int stu_id) {
		
		Examination exam = this.examimpl.selectExamBystuid(stu_id);
		List<Subject> list = this.impl.getSubjectByIdandNum(exam.getId(),exam.getSubjectNum());	
		
		
		return list;	
	}
	
	@ResponseBody
	@RequestMapping("/getGrade.do")
	public String getGrade(String[] grade) {
		
		for(int i=0;i<grade.length;i++) {
			System.out.println(grade[i]);
		}

		return null;
	}
	@ResponseBody
	@RequestMapping("/showSubject.do")
	public List<Subject> getGrade() {
	
		
		return this.impl.selectAllSubject();
	}
	
	@ResponseBody
	@RequestMapping("/deletesub.do")
	public String deleteSubject(int id) {
		
		System.out.println("进来了算法");
		int r = this.impl.deleteSubject(id);
		if(r==1) {
			return  PublicDate.YES;
		}else {
			return PublicDate.NO;
		}
	}
	@ResponseBody
	@RequestMapping("/addSubject.do")
	public String addSubject(String title,String itema,String itemb,String itemc,String itemd,String answer,int categoryId) {
		Subject sub = new Subject();
		sub.setTitle(title);
		sub.setItema(itema);
		sub.setItemb(itemb);
		sub.setItemc(itemc);
		sub.setItemd(itemd);
		sub.setAnswer(answer);
		sub.setCategoryId(categoryId);
	
		System.out.println("进来了算法");
		int r = this.impl.insertSubject(sub);
		if(r==1) {
			return  PublicDate.YES;
		}else {
			return PublicDate.NO;
		}
	}
	
	@ResponseBody
	@RequestMapping("/addGrade.do")
	public String addGrade(int stu_id,int score) {
		Examination exam = new Examination();
		exam = this.examimpl.selectExamBystuid(stu_id);
		Grade grade = new Grade();
		grade.setStuId(stu_id);
		grade.setExaminationId(exam.getId());
		grade.setExaminationName(exam.getName());
		grade.setScore(score);
		int r = this.gradeimpl.addGrade(grade);
		if(r==1) {
			return PublicDate.YES;
					
		}else {
			return PublicDate.NO;
		}
		
		
		
	}
	

}
