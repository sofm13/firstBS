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
	<TITLE>���������ѯ</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">���������б�</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="baofeishenqingList.do" name="myform" method="post">
									��ѯ   ��ţ�<input name="bianhao" type="text" id="bianhao" style='border:solid 1px #000000; color:#666666' size="12" />  �豸���ƣ�<input name="shebeimingcheng" type="text" id="shebeimingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  �����ˣ�<input name="baofeiren" type="text" id="baofeiren" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="��ѯ" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">���</td>
                            <td align='center'>���</td>    <td align='center'>�豸����</td>        <td align='center'>��������</td>    <td align='center'>������</td>    <td  width='80' align='center'>�Ƿ����</td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> ���ʱ�� </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> ���� </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.bianhao}</td>    <td>${u.shebeimingcheng}</td>        <td>${u.baofeishuliang}</td>    <td>${u.baofeiren}</td>    <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=baofeishenqing'"/></td>
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"> <!--lianjie1--> <a href="baofeishenqingDetail.do?id=${u.id}">��ϸ</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="baofeishenqingList.do?page=1" >��ҳ</a>
             <a href="baofeishenqingList.do?page=${page.page-1 }"> ��һҳ</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="baofeishenqingList.do?page=${page.page+1 }">��һҳ</a>
			<a href="baofeishenqingList.do?page=${page.totalPage }">ĩҳ</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>

