<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>水气监督详情</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  水气监督:
  <br><br>
  
   <table width="100%" height="250px" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${shebeiyunxing2.bianhao}</td>     <td width='11%'>设备名称：</td><td width='39%'>${shebeiyunxing2.shebeimingcheng}</td></tr><tr>     <td width='11%'>参数记录：</td><td width='20%'>${shebeiyunxing2.rizhi}</td>     <td width='11%'>记录人：</td><td width='39%'>${shebeiyunxing2.canshu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

