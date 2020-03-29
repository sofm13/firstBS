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
		<TITLE>修改技术协议</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="jishuxieyi_add.jsp?id=<%=id%>";
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
			<form action="updateJishuxieyi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改技术协议<input type="hidden" name="id" value="${jishuxieyi.id}" /></td>
						</tr>
						<tr ><td width="200">协议编号：</td><td><input name='xieyibianhao' type='text' id='xieyibianhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">协议名称：</td><td><input name='xieyimingcheng' type='text' id='xieyimingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelxieyimingcheng' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">协议内容：</td><td><textarea name='xieyineirong' cols='50' rows='5' id='xieyineirong' onblur='checkform()' class="form-control" style="width:600px; height:80px;" ></textarea>&nbsp;*<label id='clabelxieyineirong' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">协议甲方：</td><td><input name='xieyijiafang' type='text' id='xieyijiafang' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelxieyijiafang' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">协议乙方：</td><td><input name='xieyiyifang' type='text' id='xieyiyifang' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelxieyiyifang' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">签约人：</td><td><input name='qianyueren' type='text' id='qianyueren' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelqianyueren' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">签订日期：</td><td><input name='qiandingriqi' type='text' id='qiandingriqi' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" />&nbsp;*<label id='clabelqiandingriqi' style='margin-top:16px;' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.xieyibianhao.value='${jishuxieyi.xieyibianhao}';</script>	<script language="javascript">document.form1.xieyimingcheng.value='${jishuxieyi.xieyimingcheng}';</script>	<script language="javascript">document.form1.xieyineirong.value='${jishuxieyi.xieyineirong}';</script>	<script language="javascript">document.form1.xieyijiafang.value='${jishuxieyi.xieyijiafang}';</script>	<script language="javascript">document.form1.xieyiyifang.value='${jishuxieyi.xieyiyifang}';</script>	<script language="javascript">document.form1.qianyueren.value='${jishuxieyi.qianyueren}';</script>	<script language="javascript">document.form1.qiandingriqi.value='${jishuxieyi.qiandingriqi}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var xieyimingchengobj = document.getElementById("xieyimingcheng"); if(xieyimingchengobj.value==""){document.getElementById("clabelxieyimingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入协议名称</font>";return false;}else{document.getElementById("clabelxieyimingcheng").innerHTML="  "; } 	var xieyineirongobj = document.getElementById("xieyineirong"); if(xieyineirongobj.value==""){document.getElementById("clabelxieyineirong").innerHTML="&nbsp;&nbsp;<font color=red>请输入协议内容</font>";return false;}else{document.getElementById("clabelxieyineirong").innerHTML="  "; } 	var xieyijiafangobj = document.getElementById("xieyijiafang"); if(xieyijiafangobj.value==""){document.getElementById("clabelxieyijiafang").innerHTML="&nbsp;&nbsp;<font color=red>请输入协议甲方</font>";return false;}else{document.getElementById("clabelxieyijiafang").innerHTML="  "; } 	var xieyiyifangobj = document.getElementById("xieyiyifang"); if(xieyiyifangobj.value==""){document.getElementById("clabelxieyiyifang").innerHTML="&nbsp;&nbsp;<font color=red>请输入协议乙方</font>";return false;}else{document.getElementById("clabelxieyiyifang").innerHTML="  "; } 	var qianyuerenobj = document.getElementById("qianyueren"); if(qianyuerenobj.value==""){document.getElementById("clabelqianyueren").innerHTML="&nbsp;&nbsp;<font color=red>请输入签约人</font>";return false;}else{document.getElementById("clabelqianyueren").innerHTML="  "; } 	var qiandingriqiobj = document.getElementById("qiandingriqi"); if(qiandingriqiobj.value==""){document.getElementById("clabelqiandingriqi").innerHTML="&nbsp;&nbsp;<font color=red>请输入签订日期</font>";return false;}else{document.getElementById("clabelqiandingriqi").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
