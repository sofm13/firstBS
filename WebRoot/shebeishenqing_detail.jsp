<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>设备申请详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  设备申请详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${shebeishenqing.bianhao}</td>     <td width='11%'>设备名称：</td><td width='39%'>${shebeishenqing.shebeimingcheng}</td></tr><tr>     <td width='11%'>申请数量：</td><td width='39%'>${shebeishenqing.shenqingshuliang}</td>     <td width='11%'>申请原因：</td><td width='39%'>${shebeishenqing.shenqingyuanyin}</td></tr><tr>     <td width='11%'>拒绝原因：</td><td width='39%'>${shebeishenqing.jujueyuanyin}</td>     <td width='11%'>备注：</td><td width='39%'>${shebeishenqing.beizhu}</td></tr><tr>     <td width='11%'>申请部门：</td><td width='39%'>${shebeishenqing.shenqingbumen}</td>     <td width='11%'>申请人：</td><td width='39%'>${shebeishenqing.shenqingren}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

