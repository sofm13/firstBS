<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>技术协议详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  技术协议详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>协议编号：</td><td width='39%'>${jishuxieyi.xieyibianhao}</td>     <td width='11%'>协议名称：</td><td width='39%'>${jishuxieyi.xieyimingcheng}</td></tr><tr>     <td width='11%'>协议内容：</td><td width='39%'>${jishuxieyi.xieyineirong}</td>     <td width='11%'>协议甲方：</td><td width='39%'>${jishuxieyi.xieyijiafang}</td></tr><tr>     <td width='11%'>协议乙方：</td><td width='39%'>${jishuxieyi.xieyiyifang}</td>     <td width='11%'>签约人：</td><td width='39%'>${jishuxieyi.qianyueren}</td></tr><tr>     <td width='11%'>签订日期：</td><td width='39%'>${jishuxieyi.qiandingriqi}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

