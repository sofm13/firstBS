<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="jishuxieyihsgb" scope="page" class="com.bean.JishuxieyiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=jishuxieyi.xls");
%>
<html>
  <head>
    <title>技术协议</title>
  </head>

  <body >
 <%
			String sql="select * from jishuxieyi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>协议编号</td>    <td align='center' bgcolor='#ebf0f7'>协议名称</td>        <td align='center' bgcolor='#ebf0f7'>协议甲方</td>    <td align='center' bgcolor='#ebf0f7'>协议乙方</td>    <td align='center' bgcolor='#ebf0f7'>签约人</td>    <td  width='65' align='center' bgcolor='#ebf0f7'>签订日期</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=jishuxieyihsgb.getAllJishuxieyi(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xieyibianhao}</td>    <td>${u.xieyimingcheng}</td>        <td>${u.xieyijiafang}</td>    <td>${u.xieyiyifang}</td>    <td>${u.qianyueren}</td>    <td>${u.qiandingriqi}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

