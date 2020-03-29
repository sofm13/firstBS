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
		<TITLE>修改合同生成</TITLE>
	    
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
	document.location.href="hetongshengcheng_add.jsp?id=<%=id%>";
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
			<form action="updateHetongshengcheng.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改合同生成<input type="hidden" name="id" value="${hetongshengcheng.id}" /></td>
						</tr>
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">设备名称：</td><td><input name='shebeimingcheng' type='text' id='shebeimingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">合同编号：</td><td><input name='hetongbianhao' type='text' id='hetongbianhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">合同内容：</td><td><textarea name='hetongneirong' cols='50' rows='5' id='hetongneirong' onblur='checkform()' style='border:solid 1px #000000; color:#666666' ></textarea>&nbsp;*<label id='clabelhetongneirong' /></td></tr>		<tr ><td width="200">采购公司：</td><td><input name='caigougongsi' type='text' id='caigougongsi' value='' onblur='checkform()' size='50' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelcaigougongsi' /></td></tr>		<tr ><td width="200">采购日期：</td><td><input name='caigouriqi' type='text' id='caigouriqi' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">采购人：</td><td><input name='caigouren' type='text' id='caigouren' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.bianhao.value='${hetongshengcheng.bianhao}';</script>	<script language="javascript">document.form1.shebeimingcheng.value='${hetongshengcheng.shebeimingcheng}';</script>	<script language="javascript">document.form1.hetongbianhao.value='${hetongshengcheng.hetongbianhao}';</script>	<script language="javascript">document.form1.hetongneirong.value='${hetongshengcheng.hetongneirong}';</script>	<script language="javascript">document.form1.caigougongsi.value='${hetongshengcheng.caigougongsi}';</script>	<script language="javascript">document.form1.caigouriqi.value='${hetongshengcheng.caigouriqi}';</script>	<script language="javascript">document.form1.caigouren.value='${hetongshengcheng.caigouren}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var hetongneirongobj = document.getElementById("hetongneirong"); if(hetongneirongobj.value==""){document.getElementById("clabelhetongneirong").innerHTML="&nbsp;&nbsp;<font color=red>请输入合同内容</font>";return false;}else{document.getElementById("clabelhetongneirong").innerHTML="  "; } 	var caigougongsiobj = document.getElementById("caigougongsi"); if(caigougongsiobj.value==""){document.getElementById("clabelcaigougongsi").innerHTML="&nbsp;&nbsp;<font color=red>请输入采购公司</font>";return false;}else{document.getElementById("clabelcaigougongsi").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
