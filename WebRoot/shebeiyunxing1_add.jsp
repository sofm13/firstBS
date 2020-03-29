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
		<TITLE>添加</TITLE>
	    

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
	document.location.href="shebeiyunxing1_add.jsp?id=<%=id%>&bianhao="+document.form1.bianhao.value;
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
			<form action="addShebeiyunxing1.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加煤质信息</td>
						</tr>
						<tr ><td width="100">编号：</td><td><select name='bianhao' id='bianhao' style='height:20px; border:solid 1px #000000; color:#666666' onChange='gows();'><%=connDbBean.hsggetoption2("shebeiguanli","bianhao")%></select>&nbsp;*<label id='clabelbianhao' /></td></tr>		<tr ><td width="200">设备名称：</td><td><input name='shebeimingcheng' type='text' id='shebeimingcheng' style='border:solid 1px #000000; color:#666666' >&nbsp;*<label id='clabelshebeimingcheng' /></td></tr>		<tr ><td width="200">参数记录：</td><td><textarea  value='项目编号' name='rizhi' cols='118' rows='3' id='rizhi' onblur='' style='border:solid 1px #000000; color:#666666' >功率因数:    日平均负荷:        日厂用电量:       日最高负荷:       日最低负荷:       日耗中煤:       发电标煤耗:     日制工业水量:       日除盐水耗水量:       日拉矸石量:       日入厂煤量:       累计矸石量:       排渣量:</textarea></td></tr>		<tr ><td width="200">记录人：</td><td><textarea name='canshu' cols='15' rows='1' id='canshu' onblur='checkform()' style='border:solid 1px #000000; color:#666666' ></textarea>&nbsp;*<label id='clabelcanshu' /></td></tr>		
		
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

<%
if(request.getParameter("bianhao")==null || request.getParameter("bianhao").equals("")){}else{
%>
<script language="javascript">
document.form1.bianhao.value="<%=connDbBean.readzd("shebeiguanli","bianhao","bianhao",request.getParameter("bianhao"))%>";document.form1.shebeimingcheng.value="<%=connDbBean.readzd("shebeiguanli","shebeimingcheng","bianhao",request.getParameter("bianhao"))%>";

</script>
<%
}
%>




<script language=javascript >  
 
 function checkform(){  
 
	var bianhaoobj = document.getElementById("bianhao"); if(bianhaoobj.value==""){document.getElementById("clabelbianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入编号</font>";return false;}else{document.getElementById("clabelbianhao").innerHTML="  "; } 	var shebeimingchengobj = document.getElementById("shebeimingcheng"); if(shebeimingchengobj.value==""){document.getElementById("clabelshebeimingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入设备名称</font>";return false;}else{document.getElementById("clabelshebeimingcheng").innerHTML="  "; } 	var canshuobj = document.getElementById("canshu"); if(canshuobj.value==""){document.getElementById("clabelcanshu").innerHTML="&nbsp;&nbsp;<font color=red>请输入参数</font>";return false;}else{document.getElementById("clabelcanshu").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
