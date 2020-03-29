<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>维修报告详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  维修报告详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${weixiubaogao.bianhao}</td>     <td width='11%'>设备名称：</td><td width='39%'>${weixiubaogao.shebeimingcheng}</td></tr><tr>     <td width='11%'>情况简述：</td><td width='39%'>${weixiubaogao.qingkuangjianshu}</td>     <td width='11%'>维修原因：</td><td width='39%'>${weixiubaogao.weixiuyuanyin}</td></tr><tr>     <td width='11%'>维修结果：</td><td width='39%'>${weixiubaogao.weixiujieguo}</td>     <td width='11%'>维修人：</td><td width='39%'>${weixiubaogao.weixiuren}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

