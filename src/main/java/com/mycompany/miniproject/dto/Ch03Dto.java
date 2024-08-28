package com.mycompany.miniproject.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Ch03Dto {
	String param1;
	int param2;
	double param3;
	boolean param4;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	Date param5;

}
