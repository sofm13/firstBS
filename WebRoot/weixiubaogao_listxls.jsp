<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="weixiubaogaohsgb" scope="page" class="com.bean.WeixiubaogaoBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=weixiubaogao.xls");
%>
<html>
  <head>
    <title>维修报告</title>
  </head>

  <body >
 <%
			String sql="select * from weixiubaogao  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>编号</td>    <td align='center'>设备名称</td>    <td align='center'>情况简述</td>        <td align='center'>维修结果</td>    <td align='center'>维修人</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=weixiubaogaohsgb.getAllWeixiubaogao(8);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.shebeimingcheng}</td>    <td>${u.qingkuangjianshu}</td>        <td>${u.weixiujieguo}</td>    <td>${u.weixiuren}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

