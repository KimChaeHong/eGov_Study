package com.mycompany.miniproject.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.miniproject.dao.mybatis.Ch13BoardDao;
import com.mycompany.miniproject.dto.Ch13Board;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch13BoardService {
	
	@Autowired
	private Ch13BoardDao boardDao;
	
	//게시물 목록 가져오기
		public List<Ch13Board> getBoardList(){
			return null;
		}
		
		//게시물 하나 가져오기
		public Ch13Board getBoard(int bno) {
			return null;
		}
	
	//게시물 작성
	public void writeBoard(Ch13Board board) {
		
		log.info("실행");
		boardDao.insert(board);
	}
}
