package com.mycompany.miniproject.contorller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.miniproject.dto.Ch03Dto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch03")
public class Ch03Contorller {
	
	//GET 방식 데이터 읽기
	//요청 파라미터명과 동일한 매개변수 선언
	@GetMapping("/receiveParamData")
	public String receiveParamData(
			String param1, 
			String param2, 
			String param3, 
			String param4, 
			String param5, 
			Model model) {
		
		model.addAttribute("param1", param1);
		model.addAttribute("param2", param2);
		model.addAttribute("param3", param3);
		model.addAttribute("param4", param4);
		model.addAttribute("param5", param5);
		
		return "ch03/receiveParamData";
	}
	
	//POST 방식 데이터 읽기
	@GetMapping("/postMethodForm")
	public String postMethodForm() {
		return "ch03/postMethodForm";
	}
	
	@PostMapping("/receivePostMethodForm")
	public String receivePostMethodForm(
			String param1, 
			int param2, 
			double param3, 
			boolean param4, 
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date param5, 
			Model model){
		
			model.addAttribute("param1", param1);
			model.addAttribute("param2", param2);
			model.addAttribute("param3", param3);
			model.addAttribute("param4", param4);
			model.addAttribute("param5", param5);
			
			return "ch03/receiveParamData";
	}
	
	//파라미터 생략 시 디폴트 값 설정
	@GetMapping("/defaultValue")
	public String defaultValue(
			String param1,
			@RequestParam(defaultValue ="0") int param2, 
			@RequestParam(defaultValue="0.0")double param3, 
			@RequestParam(defaultValue="false")boolean param4, 
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date param5, 
			Model model) {
			
			model.addAttribute("param1", param1);
			model.addAttribute("param2", param2);
			model.addAttribute("param3", param3);
			model.addAttribute("param4", param4);
			model.addAttribute("param5", param5);
		
			return "ch03/receiveParamData";
	}
	
	//파라미터명과 매개변수명이 다를 경우
	@GetMapping("/otherArgName")
	public String otherArgName(
			@RequestParam("param1") String arg1, 
			@RequestParam("param2") int arg2,
			@RequestParam("param3") double arg3,
			@RequestParam("param4") boolean arg4,
			@RequestParam("param5") String arg5,
			Model model){

			model.addAttribute("param1", arg1);
			model.addAttribute("param2", arg2);
			model.addAttribute("param3", arg3);
			model.addAttribute("param4", arg4);
			model.addAttribute("param5", arg5);
		
			return "ch03/receiveParamData";
	}
	
	//DTO로 파라미터 값을 모두 받기
	@GetMapping("/commandObject")
	public String commandObject(Ch03Dto dto) {
		return "ch03/receiveCommandObject";
	}
	
	//AJAX로 보낸 데이터를 DTO로 받기
	@GetMapping("/ajaxParam")
	public String ajaxParam() {
		return "ch03/ajaxParam";
	}
	
	@PostMapping("/requestAjax")
	public void requestAjax(Ch03Dto dto, HttpServletResponse response ) throws Exception {
		log.info(dto.toString());
		JSONObject jsonObject = new JSONObject();
		String json = jsonObject.toString();
		
		response.setContentType("application/json; charset=UTF-8"); 
		PrintWriter pw = response.getWriter();
		
		pw.println(json);
		pw.flush();
		pw.close();
	}

	
	
}
