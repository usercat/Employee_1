<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<frameset rows="80,*">
   <frame name="top" src="<%=request.getContextPath()%>/frame/top.jsp">
   <frameset cols="150,*" id="main">

      <frame src="<%=request.getContextPath()%>/frame/left.jsp"> 
     <frame name="right" src="<%=request.getContextPath()%>/frame/right.jsp">
   </frameset>
</frameset>