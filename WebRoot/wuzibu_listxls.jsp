<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="wuzibuhsgb" scope="page" class="com.bean.WuzibuBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=wuzibu.xls");
%>
<html>
  <head>
    <title>���ʲ�</title>
  </head>

  <body >
 <%
			String sql="select * from wuzibu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>�˺�</td>    <td align='center'>����</td>    <td align='center'>����</td>    <td align='center'>��������</td>    <td align='center'>��λ</td>    <td align='center'>��ϵ�绰</td>    <td align='center'>�ֻ�</td>    <td align='center'>��ͥ��ַ</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=wuzibuhsgb.getAllWuzibu(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.zhanghao}</td>    <td>${u.mima}</td>    <td>${u.xingming}</td>    <td>${u.bumenmingcheng}</td>    <td>${u.gangwei}</td>    <td>${u.lianxidianhua}</td>    <td>${u.shouji}</td>    <td>${u.jiatingdizhi}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

