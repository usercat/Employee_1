<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>编辑部门</title>
</head>
<body>

<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 部门编辑</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回 </a>
</td>
</tr>
</table>
<br/>
 <br>
<s:form id="saveForm" action="department_update" method="post" namespace="/">
<s:hidden name="did" value="%{model.did}"/>
<table style="font-size::16px">
<tr>
  <td>部门名称：</td>
  <td><s:textfield name="dname" value="%{model.dname}"/></td>
</tr>
<tr>
  <td>部门介绍：</td>
  <td></td>
</tr>
<tr>
  <td width="10%"></td>
  <td>
     <s:textarea rows="5" cols="50" name="ddesc" value="%{model.ddesc}"/>
  </td>
</tr>
</table>
</s:form>
</body>
</html> 
