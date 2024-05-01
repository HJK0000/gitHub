package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.IUserDao;
import com.example.demo.domain.User;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MyController {
	
	@Autowired
	IUserDao dao;
	
	@RequestMapping({"/", "/index"})
	public String root() {
		
		return "index";
	}
	
	@RequestMapping("/list")
	public void list(Model model) {
		log.info("list 실행......");
		model.addAttribute("list", dao.getUserList());
	}
	
	@RequestMapping("/saveForm")
	public void svaeForm() {
		log.info("saveForm 실행.........");
	}
	
	@RequestMapping("/save")
	public String save(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		User user = new User(id, pw);
		int result = dao.saveUser(user);
		if(result == 1) {
			System.out.println("등록 성공");
		}else {
			System.out.println("등록 실패");
		}
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("uno") String uno) {
		int uno_ = Integer.parseInt(uno);
		int result = dao.deleteUser(uno_);
		if(result == 1) {
			log.info("삭제 성공");
		}else {
			log.info("삭제 실패");
		}
		return "redirect:list";
	}
	
	@RequestMapping("/detail")
	public void detail(@RequestParam("uno") String uno, Model model) {
		int uno_ = Integer.parseInt(uno);
		model.addAttribute("dto", dao.getUser(uno_));
	}
	
	
	
	
}
