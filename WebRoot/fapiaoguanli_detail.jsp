<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>发票管理详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  发票管理详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${fapiaoguanli.bianhao}</td>     <td width='11%'>设备名称：</td><td width='39%'>${fapiaoguanli.shebeimingcheng}</td></tr><tr>     <td width='11%'>发票编号：</td><td width='39%'>${fapiaoguanli.fapiaobianhao}</td>     <td width='11%'>发票内容：</td><td width='39%'>${fapiaoguanli.fapiaoneirong}</td></tr><tr>     <td width='11%'>发票金额：</td><td width='39%'>${fapiaoguanli.fapiaojine}</td>     <td width='11%'>记录人：</td><td width='39%'>${fapiaoguanli.jiluren}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

