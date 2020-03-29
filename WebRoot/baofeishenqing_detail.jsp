<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>报废申请详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  报废申请详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${baofeishenqing.bianhao}</td>     <td width='11%'>设备名称：</td><td width='39%'>${baofeishenqing.shebeimingcheng}</td></tr><tr>     <td width='11%'>报废原因：</td><td width='39%'>${baofeishenqing.baofeiyuanyin}</td>     <td width='11%'>报废数量：</td><td width='39%'>${baofeishenqing.baofeishuliang}</td></tr><tr>     <td width='11%'>报废人：</td><td width='39%'>${baofeishenqing.baofeiren}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

