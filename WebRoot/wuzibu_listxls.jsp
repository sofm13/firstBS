<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="wuzibuhsgb" scope="page" class="com.bean.WuzibuBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=wuzibu.xls");
%>
<html>
  <head>
    <title>物资部</title>
  </head>

  <body >
 <%
			String sql="select * from wuzibu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>账号</td>    <td align='center'>密码</td>    <td align='center'>姓名</td>    <td align='center'>部门名称</td>    <td align='center'>岗位</td>    <td align='center'>联系电话</td>    <td align='center'>手机</td>    <td align='center'>家庭地址</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
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

