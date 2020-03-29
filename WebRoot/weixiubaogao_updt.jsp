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
		<TITLE>修改维修报告</TITLE>
	    
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
	document.location.href="weixiubaogao_add.jsp?id=<%=id%>";
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
			<form action="updateWeixiubaogao.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改维修报告<input type="hidden" name="id" value="${weixiubaogao.id}" /></td>
						</tr>
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">设备名称：</td><td><input name='shebeimingcheng' type='text' id='shebeimingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">情况简述：</td><td><input name='qingkuangjianshu' type='text' id='qingkuangjianshu' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">维修原因：</td><td><textarea name='weixiuyuanyin' cols='50' rows='5' id='weixiuyuanyin' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' ></textarea>&nbsp;*<label id='clabelweixiuyuanyin' /></td></tr>		<tr ><td width="200">维修结果：</td><td><input name='weixiujieguo' type='text' id='weixiujieguo' value='' onblur='checkform()' size='50' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelweixiujieguo' /></td></tr>		<tr ><td width="200">维修人：</td><td><input name='weixiuren' type='text' id='weixiuren' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelweixiuren' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.bianhao.value='${weixiubaogao.bianhao}';</script>	<script language="javascript">document.form1.shebeimingcheng.value='${weixiubaogao.shebeimingcheng}';</script>	<script language="javascript">document.form1.qingkuangjianshu.value='${weixiubaogao.qingkuangjianshu}';</script>	<script language="javascript">document.form1.weixiuyuanyin.value='${weixiubaogao.weixiuyuanyin}';</script>	<script language="javascript">document.form1.weixiujieguo.value='${weixiubaogao.weixiujieguo}';</script>	<script language="javascript">document.form1.weixiuren.value='${weixiubaogao.weixiuren}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var weixiuyuanyinobj = document.getElementById("weixiuyuanyin"); if(weixiuyuanyinobj.value==""){document.getElementById("clabelweixiuyuanyin").innerHTML="&nbsp;&nbsp;<font color=red>请输入维修原因</font>";return false;}else{document.getElementById("clabelweixiuyuanyin").innerHTML="  "; } 	var weixiujieguoobj = document.getElementById("weixiujieguo"); if(weixiujieguoobj.value==""){document.getElementById("clabelweixiujieguo").innerHTML="&nbsp;&nbsp;<font color=red>请输入维修结果</font>";return false;}else{document.getElementById("clabelweixiujieguo").innerHTML="  "; } 	var weixiurenobj = document.getElementById("weixiuren"); if(weixiurenobj.value==""){document.getElementById("clabelweixiuren").innerHTML="&nbsp;&nbsp;<font color=red>请输入维修人</font>";return false;}else{document.getElementById("clabelweixiuren").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
