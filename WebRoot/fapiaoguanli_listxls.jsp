<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="fapiaoguanlihsgb" scope="page" class="com.bean.FapiaoguanliBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=fapiaoguanli.xls");
%>
<html>
  <head>
    <title>��Ʊ����</title>
  </head>

  <body >
 <%
			String sql="select * from fapiaoguanli  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>���</td>    <td align='center'>�豸����</td>    <td align='center'>��Ʊ���</td>        <td align='center'>��Ʊ���</td>    <td align='center'>��¼��</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=fapiaoguanlihsgb.getAllFapiaoguanli(8);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.shebeimingcheng}</td>    <td>${u.fapiaobianhao}</td>        <td>${u.fapiaojine}</td>    <td>${u.jiluren}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

