package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.TodoVO;

@Mapper
public interface TodoDAO {
	int insert(TodoVO todoVO);
	int update(TodoVO todoVO);
	int delete(TodoVO todoVO);
	List<TodoVO> todoList();	//mapping 함
	List<TodoVO> todoList2();	//mapping 안함
}
