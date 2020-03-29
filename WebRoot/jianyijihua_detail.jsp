<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>建议计划详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  建议计划详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>计划名称：</td><td width='39%'>${jianyijihua.jihuamingcheng}</td>     <td width='11%'>计划描述：</td><td width='39%'>${jianyijihua.jihuamiaoshu}</td></tr><tr>     <td width='11%'>录入时间：</td><td width='39%'>${jianyijihua.lurushijian}</td>     <td width='11%'>录入人员：</td><td width='39%'>${jianyijihua.lururenyuan}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

