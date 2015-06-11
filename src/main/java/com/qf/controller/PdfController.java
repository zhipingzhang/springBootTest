package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.entity.User;


@Controller
public class PdfController {
	
	@ResponseBody
	@RequestMapping("/pdf/{id}")
	public User view(@PathVariable("id") Long id) {
		System.out.println(id);
		User user = new User();
		return user;
	}

}
