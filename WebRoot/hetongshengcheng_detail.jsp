<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>合同生成详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  合同生成详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${hetongshengcheng.bianhao}</td>     <td width='11%'>设备名称：</td><td width='39%'>${hetongshengcheng.shebeimingcheng}</td></tr><tr>     <td width='11%'>合同编号：</td><td width='39%'>${hetongshengcheng.hetongbianhao}</td>     <td width='11%'>合同内容：</td><td width='39%'>${hetongshengcheng.hetongneirong}</td></tr><tr>     <td width='11%'>采购公司：</td><td width='39%'>${hetongshengcheng.caigougongsi}</td>     <td width='11%'>采购日期：</td><td width='39%'>${hetongshengcheng.caigouriqi}</td></tr><tr>     <td width='11%'>采购人：</td><td width='39%'>${hetongshengcheng.caigouren}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

