<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>部门管理详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  部门管理详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>部门编号：</td><td width='39%'>${bumenguanli.bumenbianhao}</td>     <td width='11%'>部门名称：</td><td width='39%'>${bumenguanli.bumenmingcheng}</td></tr><tr>     <td width='11%'>部门电话：</td><td width='39%'>${bumenguanli.bumendianhua}</td>     <td width='11%'>部门传真：</td><td width='39%'>${bumenguanli.bumenchuanzhen}</td></tr><tr>     <td width='11%'>部门信息：</td><td width='39%'>${bumenguanli.bumenxinxi}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

