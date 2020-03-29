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
	<TITLE>技术协议查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td height="30" colspan="17" background="images/table_header.gif">技术协议列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="jishuxieyiList.do" name="myform" method="post">
									查询   协议编号：<input name="xieyibianhao" type="text" id="xieyibianhao" class="form-control2" />  协议名称：<input name="xieyimingcheng" type="text" id="xieyimingcheng" class="form-control2" />  协议甲方：<input name="xieyijiafang" type="text" id="xieyijiafang" class="form-control2" />  协议乙方：<input name="xieyiyifang" type="text" id="xieyiyifang" class="form-control2" />  签约人：<input name="qianyueren" type="text" id="qianyueren" class="form-control2" />  签订日期：<input name="qiandingriqi1" type="text" id="qiandingriqi1"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" class="form-control2" />-<input name="qiandingriqi2" type="text" id="qiandingriqi2"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" class="form-control2" />
									<input type="submit" value="查询" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px" height="30">序号</td>
                            <td align='center' bgcolor='#ebf0f7'>协议编号</td>    <td align='center' bgcolor='#ebf0f7'>协议名称</td>        <td align='center' bgcolor='#ebf0f7'>协议甲方</td>    <td align='center' bgcolor='#ebf0f7'>协议乙方</td>    <td align='center' bgcolor='#ebf0f7'>签约人</td>    <td  width='65' align='center' bgcolor='#ebf0f7'>签订日期</td>    
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
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
                             <td>${u.xieyibianhao}</td>    <td>${u.xieyimingcheng}</td>        <td>${u.xieyijiafang}</td>    <td>${u.xieyiyifang}</td>    <td>${u.qianyueren}</td>    <td>${u.qiandingriqi}</td>    
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a class="btn btn-info btn-small" href="doUpdateJishuxieyi.do?id=${u.id }">编辑</a>  <a class="btn btn-info btn-small" href="deleteJishuxieyi.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a class="btn btn-info btn-small" href="jishuxieyiDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="jishuxieyiList.do?page=1" >首页</a>
             <a href="jishuxieyiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="jishuxieyiList.do?page=${page.page+1 }">下一页</a>
			<a href="jishuxieyiList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
