<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shengdiaobuhsgb" scope="page" class="com.bean.ShengdiaobuBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shengdiaobu.xls");
%>
<html>
  <head>
    <title>������</title>
  </head>

  <body >
 <%
			String sql="select * from shengdiaobu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>�˺�</td>    <td align='center'>����</td>    <td align='center'>����</td>    <td  width='40' align='center'>�Ա�</td>    <td align='center'>��������</td>    <td align='center'>��λ</td>    <td align='center'>��ϵ�绰</td>    <td align='center'>�ֻ�</td>    <td align='center'>��ͥ��ַ</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=shengdiaobuhsgb.getAllShengdiaobu(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.zhanghao}</td>    <td>${u.mima}</td>    <td>${u.xingming}</td>    <td align='center'>${u.xingbie}</td>    <td>${u.bumenmingcheng}</td>    <td>${u.gangwei}</td>    <td>${u.lianxidianhua}</td>    <td>${u.shouji}</td>    <td>${u.jiatingdizhi}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

