﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>添加发票管理</TITLE>
	    

 	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>      
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="fapiaoguanli_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addFapiaoguanli.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加发票管理</td>
						</tr>
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.bianhao.value='<%=connDbBean.readzd("shebeishenqing","bianhao","id",request.getParameter("id"))%>';document.form1.bianhao.setAttribute("readOnly",'true');</script>		<tr ><td width="200">设备名称：</td><td><input name='shebeimingcheng' type='text' id='shebeimingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.shebeimingcheng.value='<%=connDbBean.readzd("shebeishenqing","shebeimingcheng","id",request.getParameter("id"))%>';document.form1.shebeimingcheng.setAttribute("readOnly",'true');</script>		<tr ><td width="200">发票编号：</td><td><input name='fapiaobianhao' type='text' id='fapiaobianhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">发票内容：</td><td><textarea name='fapiaoneirong' cols='50' rows='5' id='fapiaoneirong' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		<tr ><td width="200">发票金额：</td><td><input name='fapiaojine' type='text' id='fapiaojine' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelfapiaojine' />必需数字型</td></tr>		<tr ><td width="200">记录人：</td><td><input name='jiluren' type='text' id='jiluren' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var fapiaojineobj = document.getElementById("fapiaojine"); if(fapiaojineobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(fapiaojineobj.value)){document.getElementById("clabelfapiaojine").innerHTML=""; }else{document.getElementById("clabelfapiaojine").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}      


return true;   
}   
popheight=450;
</script>  
