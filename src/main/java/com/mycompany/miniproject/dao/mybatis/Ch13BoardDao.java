package com.mycompany.miniproject.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.miniproject.dto.Ch13Board;
import com.mycompany.miniproject.dto.Ch13Pager;


@Mapper
public interface Ch13BoardDao {
	public int insert(Ch13Board board);
	public List<Ch13Board> selectList(Ch13Pager pager);
	public int countRows();
}
