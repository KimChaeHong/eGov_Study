package com.mycompany.miniproject.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.miniproject.dto.Ch13Board;

@Mapper
public interface Ch13BoardDao {
	public int insert(Ch13Board board);
}
