package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TodoDAO;
import com.example.demo.vo.TodoVO;

@Service
@Transactional
public class TodoService {
	@Autowired
	private TodoDAO todoDAO;
	
	public int insert(TodoVO todoVO) {
		return todoDAO.insert(todoVO);
	}
	
	public int update(TodoVO todoVO) {
		return todoDAO.update(todoVO);
	}
	
	public int delete(TodoVO todoVO) {
		return todoDAO.delete(todoVO);
	}
	
	public void bulkInsert() {
		TodoVO todoVO = new TodoVO();
		for (int i=0;i<2500;i++) {
			todoVO.setTitle("리엑트의 기초 알아보기 할일 " + i);
			todoVO.setChecked_yn(i % 3 == 0 ? 'Y' : 'N');
			todoDAO.insert(todoVO);
		}
	}

	public List<TodoVO> todoList() {
		return todoDAO.todoList2();
	}
}
