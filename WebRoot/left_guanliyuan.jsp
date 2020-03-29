<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧导航</title>
<head>
<link rel="stylesheet" type="text/css" href="images/index.css">
<style type="text/css">
body{margin:0;padding:0;overflow-x:hidden;}
html, body{height:100%;}
img{border:none;}
*{font-family:'微软雅黑';font-size:12px;color:#626262;}
dl,dt,dd{display:block;margin:0;}
a{text-decoration:none;}

#bg{background-image:url(images/content/dotted.png);}
.container{width:100%;height:100%;margin:auto;}

/*left*/
.leftsidebar_box{width:183px;height:auto !important;overflow:visible !important;position:fixed;height:100% !important;background-color:#339999;}
.line{height:2px;width:100%;background-image:url(images/left/line_bg.png);background-repeat:repeat-x;}
.leftsidebar_box dt{padding-left:40px;padding-right:10px;background-repeat:no-repeat;background-position:10px center;color:#f5f5f5;font-size:14px;position:relative;line-height:37px;cursor:pointer;}
.leftsidebar_box dd{background-color:#339999;padding-left:40px;}
.leftsidebar_box dd a{color:#f5f5f5;line-height:20px;}
.leftsidebar_box dt img{position:absolute;right:10px;top:20px;}
.system_log dt{background-image:url(images/left/system.png)}
.custom dt{background-image:url(images/left/custom.png)}
.channel dt{background-image:url(images/left/channel.png)}
.app dt{background-image:url(images/left/app.png)}
.cloud dt{background-image:url(images/left/cloud.png)}
.syetem_management dt{background-image:url(images/left/syetem_management.png)}
.source dt{background-image:url(images/left/source.png)}
.statistics dt{background-image:url(images/left/statistics.png)}
.leftsidebar_box dl dd:last-child{padding-bottom:10px;}
</style>
</head>
<body id="bg">
<div class="container">
	<div class="leftsidebar_box">
	
<dl class="custom">
			<dt onClick="changeImage()">系统用户管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="allusersList.do" target="hsgmain">管理员用户</a></dd>
<dd><a href="mod.jsp" target="hsgmain">修改密码</a></dd>

		</dl>
<dl class="custom">
			<dt onClick="changeImage()">部门管理管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="bumenguanli_add.jsp" target="hsgmain">部门管理添加</a></dd>
<dd><a href="bumenguanliList.do" target="hsgmain">部门管理查询</a></dd>

		</dl>
<dl class="custom">
			<dt onClick="changeImage()">生调部管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="shengdiaobu_add.jsp" target="hsgmain">生调部添加</a></dd>
<dd><a href="shengdiaobuList.do" target="hsgmain">生调部查询</a></dd>

		</dl>
<dl class="custom">
			<dt onClick="changeImage()">物资部管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="wuzibu_add.jsp" target="hsgmain">物资部添加</a></dd>
<dd><a href="wuzibuList.do" target="hsgmain">物资部查询</a></dd>

		</dl>
<dl class="custom">
			<dt onClick="changeImage()">设备管理管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="shebeiguanli_add.jsp" target="hsgmain">设备管理添加</a></dd>
<dd><a href="shebeiguanliList.do" target="hsgmain">设备管理查询</a></dd>

		</dl>
<dl class="custom">
			<dt onClick="changeImage()">设备申请管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="shebeishenqingList.do" target="hsgmain">设备申请查询</a></dd>

		</dl>
<dl class="custom">
			<dt onClick="changeImage()">合同生成管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="shebeishenqingListht.do" target="hsgmain">合同生成添加</a></dd>
<dd><a href="hetongshengchengList.do" target="hsgmain">合同生成查询</a></dd>

		</dl>
<dl class="custom">
			<dt onClick="changeImage()">发票管理管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="shebeishenqingListfp.do" target="hsgmain">发票管理添加</a></dd>
<dd><a href="fapiaoguanliList.do" target="hsgmain">发票管理查询</a></dd>

		</dl>
<dl class="custom">
			<dt onClick="changeImage()">设备入库管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="shebeiruku_add.jsp" target="hsgmain">设备入库添加</a></dd>
<dd><a href="shebeirukuList.do" target="hsgmain">设备入库查询</a></dd>

		</dl>
<dl class="custom">
			<dt onClick="changeImage()">维修报告管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="weixiushenqingList.do" target="hsgmain">维修申请查询</a></dd>
			<dd><a href="weixiushenqingListbg.do" target="hsgmain">维修报告添加</a></dd>
<dd><a href="weixiubaogaoList.do" target="hsgmain">维修报告查询</a></dd>

		</dl>

<dl class="custom">
			<dt onClick="changeImage()">设备出库管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="shebeichuku_add.jsp" target="hsgmain">设备出库添加</a></dd>
<dd><a href="shebeichukuList.do" target="hsgmain">设备出库查询</a></dd>
	<dd><a href="chukushenqingList.do" target="hsgmain">出库申请查询</a></dd>
		</dl>
<dl class="custom">
			<dt onClick="changeImage()">报废申请管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="baofeishenqingList.do" target="hsgmain">报废申请查询</a></dd>

		</dl>
<dl class="custom">
			<dt onClick="changeImage()">设备运行管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="weijianjihua1_add.jsp" target="hsgmain">运行日志添加</a></dd>
			<dd><a href="weijianjihua1List2.do" target="hsgmain">运行日志查询</a></dd>
			<dd><a href="shebeiyunxingList.do" target="hsgmain">值长日志查询</a></dd>
			<dd><a href="shebeiyunxing2List.do" target="hsgmain">化学(水气)监督查询</a></dd>
			<dd><a href="shebeiyunxing3List.do" target="hsgmain">化学(油质)监督查询</a></dd>
			<dd><a href="shebeiyunxing1List.do" target="hsgmain">化学(煤质)监督查询</a></dd>

		</dl>
		
		<dl class="custom">
				<dt onClick="changeImage()">建议计划管理<img src="images/left/select_xl01.png"></dt>
			
<dd><a href="jianyijihuaList.do" target="hsgmain">建议计划查询</a></dd>
<dd><a href="weijianjihuaList2.do" target="hsgmain">维简计划查询</a></dd>

		</dl>

		

<dl class="custom">
			<dt onClick="changeImage()">技术协议管理<img src="images/left/select_xl01.png"></dt>
			<dd><a href="jishuxieyi_add.jsp" target="hsgmain">购买设备</a></dd>
<dd><a href="jishuxieyiList.do" target="hsgmain">购买设备查询</a></dd>

		</dl>

		
<dl class="custom">
			<dt onClick="changeImage()">设备管理统计<img src="images/left/select_xl01.png"></dt>
			<dd><a href="shebeiguanli_tj_shebeimingcheng.jsp" target="hsgmain">按设备名称统计</a></dd>
<dd><a href="shebeiguanli_tj_kucun.jsp" target="hsgmain">按库存统计</a></dd>

		</dl>



	
	</div>

</div>
<script type="text/javascript" src="images/jquery.js"></script>
<script type="text/javascript">
$(".leftsidebar_box dt").css({"background-color":"#339999"});
$(".leftsidebar_box dt img").attr("src","images/left/select_xl01.png");
$(function(){
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function(){
		$(".leftsidebar_box dt").css({"background-color":"#339999"})
		$(this).css({"background-color": "#339999"});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".leftsidebar_box dt img").attr("src","images/left/select_xl01.png");
		$(this).parent().find('img').attr("src","images/left/select_xl.png");
		$(".menu_chioce").slideUp(); 
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");
	});
})
</script>
</body>
</html>