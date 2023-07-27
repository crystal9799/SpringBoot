package com.example.demo.vo;

import lombok.Data;

@Data
public class TodoVO {
	private int     id;
	private String  title;
	private boolean checked;
	private char    checked_yn;
	private String  regDate;
	private String  modDate;
}
