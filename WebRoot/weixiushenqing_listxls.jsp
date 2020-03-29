<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="weixiushenqinghsgb" scope="page" class="com.bean.WeixiushenqingBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=weixiushenqing.xls");
%>
<html>
  <head>
    <title>Œ¨–ﬁ…Í«Î</title>
  </head>

  <body >
 <%
			String sql="select * from weixiushenqing  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">–Ú∫≈</td>
    <td align='center'>±‡∫≈</td>    <td align='center'>…Ë±∏√˚≥∆</td>        <td align='center'>…Í«Î»À</td>    <td  width='80' align='center'> «∑Ò…Û∫À</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">ÃÌº” ±º‰</td>
    
  </tr>
   <%		
				List pagelist3=weixiushenqinghsgb.getAllWeixiushenqing(7);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.shebeimingcheng}</td>        <td>${u.shenqingren}</td>    <td align='center'>${u.issh} <input type="button" value="…Û∫À" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=weixiushenqing'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

