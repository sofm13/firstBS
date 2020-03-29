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
		<TITLE>修改</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="weijianjihua1_add.jsp?id=<%=id%>";
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
			<form action="updateWeijianjihua1.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改运行日志<input type="hidden" name="id" value="${weijianjihua1.id}" /></td>
						</tr>
						<tr ><td width="200">部门：</td><td><input name='jihuamingcheng' type='text' id='jihuamingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabeljihuamingcheng' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">更新操作：</td><td><textarea name='jihuamiaoshu' cols='50' rows='5' id='jihuamiaoshu' onblur='checkform()' class="form-control" style="width:600px; height:80px;" ></textarea>&nbsp;*<label id='clabeljihuamiaoshu' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">录入时间：</td><td><input name='lurushijian' type='text' id='lurushijian' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" /></td></tr>		<tr ><td width="200">录入人员：</td><td><input name='lururenyuan' type='text' id='lururenyuan' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.jihuamingcheng.value='${weijianjihua.jihuamingcheng}';</script>	<script language="javascript">document.form1.jihuamiaoshu.value='${weijianjihua.jihuamiaoshu}';</script>	<script language="javascript">document.form1.lurushijian.value='${weijianjihua.lurushijian}';</script>	<script language="javascript">document.form1.lururenyuan.value='${weijianjihua.lururenyuan}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var jihuamingchengobj = document.getElementById("jihuamingcheng"); if(jihuamingchengobj.value==""){document.getElementById("clabeljihuamingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入计划名称</font>";return false;}else{document.getElementById("clabeljihuamingcheng").innerHTML="  "; } 	var jihuamiaoshuobj = document.getElementById("jihuamiaoshu"); if(jihuamiaoshuobj.value==""){document.getElementById("clabeljihuamiaoshu").innerHTML="&nbsp;&nbsp;<font color=red>请输入计划描述</font>";return false;}else{document.getElementById("clabeljihuamiaoshu").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
