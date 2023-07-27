<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="application/json; charset=utf-8"
    pageEncoding="utf-8"%>
<%
System.out.println("취소시 sessioId = " + session.getId());

session.setAttribute("loop", false);
//"{\"status\":1,\"message\":'취소를 설정하였습니다'}"
JSONObject jsonResult = new JSONObject();
jsonResult.put("status", 1);
jsonResult.put("message", "취소를 설정하였습니다");
out.clear();
out.println(jsonResult);
%>