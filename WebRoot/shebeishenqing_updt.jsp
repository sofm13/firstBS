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
		<TITLE>修改设备申请</TITLE>
	    
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
	document.location.href="shebeishenqing_add.jsp?id=<%=id%>";
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
			<form action="updateShebeishenqing.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改设备申请<input type="hidden" name="id" value="${shebeishenqing.id}" /></td>
						</tr>
						<tr ><td width="200">编号：</td><td><select name='bianhao' id='bianhao' style='height:20px; border:solid 1px #000000; color:#666666' onChange='gows();'><%=connDbBean.hsggetoption2("shebeiguanli","bianhao")%></select>&nbsp;*<label id='clabelbianhao' /></td></tr>		<tr ><td width="200">设备名称：</td><td><input name='shebeimingcheng' type='text' id='shebeimingcheng' style='border:solid 1px #000000; color:#666666' >&nbsp;*<label id='clabelshebeimingcheng' /></td></tr>		<tr ><td width="200">申请数量：</td><td><input name='shenqingshuliang' type='text' id='shenqingshuliang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelshenqingshuliang' /></td></tr>		<tr ><td width="200">申请原因：</td><td><input name='shenqingyuanyin' type='text' id='shenqingyuanyin' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelshenqingyuanyin' /></td></tr>		<tr ><td width="200">拒绝原因：</td><td><input name='jujueyuanyin' type='text' id='jujueyuanyin' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		<tr ><td width="200">申请部门：</td><td><input name='shenqingbumen' type='text' id='shenqingbumen' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">申请人：</td><td><input name='shenqingren' type='text' id='shenqingren' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.bianhao.value='${shebeishenqing.bianhao}';</script>	<script language="javascript">document.form1.shebeimingcheng.value='${shebeishenqing.shebeimingcheng}';</script>	<script language="javascript">document.form1.shenqingshuliang.value='${shebeishenqing.shenqingshuliang}';</script>	<script language="javascript">document.form1.shenqingyuanyin.value='${shebeishenqing.shenqingyuanyin}';</script>	<script language="javascript">document.form1.jujueyuanyin.value='${shebeishenqing.jujueyuanyin}';</script>	<script language="javascript">document.form1.beizhu.value='${shebeishenqing.beizhu}';</script>	<script language="javascript">document.form1.shenqingbumen.value='${shebeishenqing.shenqingbumen}';</script>	<script language="javascript">document.form1.shenqingren.value='${shebeishenqing.shenqingren}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var bianhaoobj = document.getElementById("bianhao"); if(bianhaoobj.value==""){document.getElementById("clabelbianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入编号</font>";return false;}else{document.getElementById("clabelbianhao").innerHTML="  "; } 	var shebeimingchengobj = document.getElementById("shebeimingcheng"); if(shebeimingchengobj.value==""){document.getElementById("clabelshebeimingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入设备名称</font>";return false;}else{document.getElementById("clabelshebeimingcheng").innerHTML="  "; } 	var shenqingshuliangobj = document.getElementById("shenqingshuliang"); if(shenqingshuliangobj.value==""){document.getElementById("clabelshenqingshuliang").innerHTML="&nbsp;&nbsp;<font color=red>请输入申请数量</font>";return false;}else{document.getElementById("clabelshenqingshuliang").innerHTML="  "; } 	    var shenqingyuanyinobj = document.getElementById("shenqingyuanyin"); if(shenqingyuanyinobj.value==""){document.getElementById("clabelshenqingyuanyin").innerHTML="&nbsp;&nbsp;<font color=red>请输入申请原因</font>";return false;}else{document.getElementById("clabelshenqingyuanyin").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
