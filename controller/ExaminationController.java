package com.fs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.po.Examination;
import com.fs.po.Grade;
import com.fs.service.ExaminationService;
import com.fs.service.GradeService;
import com.fs.util.PublicDate;

@Controller
public class ExaminationController {
    
	@Autowired
	private ExaminationService impl;
	
	@Autowired
	private GradeService gradeimpl;
	
	@ResponseBody
	@RequestMapping("/getexambyteacherid.do")
	public List<Examination> getexambyteacherid(int teacher_id) {
		Examination exam = new Examination();
		exam.setTeacherId(teacher_id);
		exam.setState(1);
		List<Examination> list = new ArrayList();
		list = this.impl.getExambyteacherid(exam);
		
		if(list==null) {
			return null;
		}else {
			return list;
		}
		
	}
	
	
	@ResponseBody
	@RequestMapping("/finishexam.do")
	public String finishexam(String exam_name) {
		Examination exam = new Examination();
		exam.setName(exam_name);
		exam.setState(0);
		int r = this.impl.finishExam(exam);
		System.out.println(r);
		if(r==1) {
			return PublicDate.YES;
		}else {
			return PublicDate.NO;
		}
	}
	
	@ResponseBody
	@RequestMapping("/publishExam.do")
	public String publishExam(int clazz_id,String examname,String subjectNum,int teacherId) {
	
			
			Examination exam1 = new Examination();
			exam1.setName(examname);
			exam1.setTeacherId(teacherId);
			exam1.setState(0);
			List<Examination> list = new ArrayList();
			list = this.impl.getExambyteacherid(exam1);
			
			if(list.size()!=0) {
				exam1.setState(1);
				int st = Integer.parseInt(subjectNum);
				exam1.setSubjectNum(st);
				int r = this.impl.finishExam(exam1);
				System.out.println(r);
				if(r==1) {
					return PublicDate.YES;
				}else {
					return PublicDate.NO;
				}
				
				
				
			}else {
				Examination exam = new Examination();
				exam.setClazzId(clazz_id);
				exam.setName(examname);
				int st = Integer.parseInt(subjectNum);
				exam.setSubjectNum(st);
				exam.setTeacherId(teacherId);
				exam.setState(1);
				exam.setBeginTime(new Date());
				System.out.println(exam);
				
				int r = this.impl.publishExam(exam);
				if(r==1) {
					return PublicDate.YES;
				}else {
					return PublicDate.NO;
				}
			}
			
			
			
		
		
		
	}
	
	@ResponseBody
	@RequestMapping("/gojoinexam.do")
	public String getexamBystuid(String stu_id) {
		
		System.out.println(stu_id);
		Examination exam = new Examination();
		int id = Integer.parseInt(stu_id);
		exam = this.impl.selectExamBystuid(id);
		Grade grade = new Grade();
		grade.setStuId(id);
		grade.setExaminationName(exam.getName());
		List<Grade> gradelist = this.gradeimpl.selectGradeGeneral(grade);
		System.out.println(gradelist.toString());
		if(gradelist.toString()!="[]") {
			return PublicDate.NO;
			
		}else {
			if(exam!=null) {
				 return exam.getName();
			 }else {
				 return PublicDate.NO;
			 }
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/getAllexaName.do")
	public List<String> getAllexamName() {
	
		return this.impl.selectAllexam();
		
	}
	
	
	
	

}
