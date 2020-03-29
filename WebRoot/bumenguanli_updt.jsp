<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<TITLE>修改部门管理</TITLE>
	    
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
	document.location.href="bumenguanli_add.jsp?id=<%=id%>";
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
			<form action="updateBumenguanli.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改部门管理<input type="hidden" name="id" value="${bumenguanli.id}" /></td>
						</tr>
						<tr ><td width="200">部门编号：</td><td><input name='bumenbianhao' type='text' id='bumenbianhao' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelbumenbianhao' /></td></tr>		<tr ><td width="200">部门名称：</td><td><input name='bumenmingcheng' type='text' id='bumenmingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelbumenmingcheng' /></td></tr>		<tr ><td width="200">部门电话：</td><td><input name='bumendianhua' type='text' id='bumendianhua' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelbumendianhua' />必需电话格式[7或8位电话，或11位手机]</td></tr>		<tr ><td width="200">部门传真：</td><td><input name='bumenchuanzhen' type='text' id='bumenchuanzhen' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">部门信息：</td><td><textarea name='bumenxinxi' cols='50' rows='5' id='bumenxinxi' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.bumenbianhao.value='${bumenguanli.bumenbianhao}';</script>	<script language="javascript">document.form1.bumenmingcheng.value='${bumenguanli.bumenmingcheng}';</script>	<script language="javascript">document.form1.bumendianhua.value='${bumenguanli.bumendianhua}';</script>	<script language="javascript">document.form1.bumenchuanzhen.value='${bumenguanli.bumenchuanzhen}';</script>	<script language="javascript">document.form1.bumenxinxi.value='${bumenguanli.bumenxinxi}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var bumenbianhaoobj = document.getElementById("bumenbianhao"); if(bumenbianhaoobj.value==""){document.getElementById("clabelbumenbianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入部门编号</font>";return false;}else{document.getElementById("clabelbumenbianhao").innerHTML="  "; } 	var bumenmingchengobj = document.getElementById("bumenmingcheng"); if(bumenmingchengobj.value==""){document.getElementById("clabelbumenmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入部门名称</font>";return false;}else{document.getElementById("clabelbumenmingcheng").innerHTML="  "; } 	var bumendianhuaobj = document.getElementById("bumendianhua"); if(bumendianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(bumendianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(bumendianhuaobj.value)){document.getElementById("clabelbumendianhua").innerHTML=""; }else{document.getElementById("clabelbumendianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}      


return true;   
}   
popheight=450;
</script>  
