<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="jianyijihuahsgb" scope="page" class="com.bean.JianyijihuaBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=jianyijihua.xls");
%>
<html>
  <head>
    <title>建议计划</title>
  </head>

  <body >
 <%
			String sql="select * from jianyijihua  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>计划名称</td>        <td  width='65' align='center' bgcolor='#ebf0f7'>录入时间</td>    <td align='center' bgcolor='#ebf0f7'>录入人员</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=jianyijihuahsgb.getAllJianyijihua(6);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.jihuamingcheng}</td>        <td>${u.lurushijian}</td>    <td>${u.lururenyuan}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

