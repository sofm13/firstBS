<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="bumenguanlihsgb" scope="page" class="com.bean.BumenguanliBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=bumenguanli.xls");
%>
<html>
  <head>
    <title>���Ź���</title>
  </head>

  <body >
 <%
			String sql="select * from bumenguanli  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>���ű��</td>    <td align='center'>��������</td>    <td align='center'>���ŵ绰</td>    <td align='center'>���Ŵ���</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=bumenguanlihsgb.getAllBumenguanli(7);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bumenbianhao}</td>    <td>${u.bumenmingcheng}</td>    <td>${u.bumendianhua}</td>    <td>${u.bumenchuanzhen}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

