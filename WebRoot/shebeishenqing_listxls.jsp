<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shebeishenqinghsgb" scope="page" class="com.bean.ShebeishenqingBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shebeishenqing.xls");
%>
<html>
  <head>
    <title>�豸����</title>
  </head>

  <body >
 <%
			String sql="select * from shebeishenqing  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>���</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">����ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=shebeishenqinghsgb.getAllShebeishenqing(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>
