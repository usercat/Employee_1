<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 部门管理</td>
</tr>
<tr>
<td align="right" > <a href="${ pageContext.request.contextPath}/department_saveUI.action">添加</a></td>
</tr>
</table>
<br/>
<table cellspacing="0" border="1" class="table1">
<thead>
   <tr><th width="450">部门名称</th><th  width="450">编辑</th></tr>
</thead>
<tbody>
<tr>
<td align="center">财务部</td>
<td align="center"><a href="editDept.html"><img src="<%=request.getContextPath()%>/images/编辑.png"/></a></td>
</tr>
</tbody>
</table>
<br/>


<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第1/3页</span>
   <apan>
       <a href="#">[首页]</a>&nbsp;&nbsp;
       <a href="#">[上一页]</a>&nbsp;&nbsp;
       <a href="#">[下一页]</a>&nbsp;&nbsp;
       <a href="#">[尾页]</a>&nbsp;&nbsp;
   </span>
</td>
</tr>
</table>
</body>
</html>