<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="hetongshengchenghsgb" scope="page" class="com.bean.HetongshengchengBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=hetongshengcheng.xls");
%>
<html>
  <head>
    <title>��ͬ����</title>
  </head>

  <body >
 <%
			String sql="select * from hetongshengcheng  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>���</td>    <td align='center'>�豸����</td>    <td align='center'>��ͬ���</td>        <td align='center'>�ɹ���˾</td>    <td  width='65' align='center'>�ɹ�����</td>    <td align='center'>�ɹ���</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=hetongshengchenghsgb.getAllHetongshengcheng(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.shebeimingcheng}</td>    <td>${u.hetongbianhao}</td>        <td>${u.caigougongsi}</td>    <td>${u.caigouriqi}</td>    <td>${u.caigouren}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

