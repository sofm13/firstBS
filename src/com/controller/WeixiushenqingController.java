package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Weixiushenqing;
import com.server.WeixiushenqingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class WeixiushenqingController {
	@Resource
	private WeixiushenqingServer weixiushenqingService;


   
	@RequestMapping("addWeixiushenqing.do")
	public String addWeixiushenqing(HttpServletRequest request,Weixiushenqing weixiushenqing,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		weixiushenqing.setAddtime(time.toString().substring(0, 19));
		weixiushenqingService.add(weixiushenqing);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "weixiushenqingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:weixiushenqingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateWeixiushenqing.do")
	public String doUpdateWeixiushenqing(int id,ModelMap map,Weixiushenqing weixiushenqing){
		weixiushenqing=weixiushenqingService.getById(id);
		map.put("weixiushenqing", weixiushenqing);
		return "weixiushenqing_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("weixiushenqingDetail.do")
	public String weixiushenqingDetail(int id,ModelMap map,Weixiushenqing weixiushenqing){
		weixiushenqing=weixiushenqingService.getById(id);
		map.put("weixiushenqing", weixiushenqing);
		return "weixiushenqing_detail";
	}
//	前台详细
	@RequestMapping("wxsqDetail.do")
	public String wxsqDetail(int id,ModelMap map,Weixiushenqing weixiushenqing){
		weixiushenqing=weixiushenqingService.getById(id);
		map.put("weixiushenqing", weixiushenqing);
		return "weixiushenqingdetail";
	}
//	
	@RequestMapping("updateWeixiushenqing.do")
	public String updateWeixiushenqing(int id,ModelMap map,Weixiushenqing weixiushenqing,HttpServletRequest request,HttpSession session){
		weixiushenqingService.update(weixiushenqing);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:weixiushenqingList.do";
	}

//	分页查询
	@RequestMapping("weixiushenqingList.do")
	public String weixiushenqingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiushenqing weixiushenqing, String bianhao, String shebeimingcheng, String qingkuangjianshu, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=weixiushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiushenqing> list=weixiushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiushenqing_list";
	}
	
	@RequestMapping("weixiushenqingListbg.do")
	public String weixiushenqingListbg(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiushenqing weixiushenqing, String bianhao, String shebeimingcheng, String qingkuangjianshu, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=weixiushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiushenqing> list=weixiushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiushenqing_listbg";
	}
	
	@RequestMapping("weixiushenqing_yanben1.do")
	public String weixiushenqing_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiushenqing weixiushenqing, String bianhao, String shebeimingcheng, String qingkuangjianshu, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=weixiushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiushenqing> list=weixiushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiushenqing_yanben1";
	}
	@RequestMapping("weixiushenqing_yanben2.do")
	public String weixiushenqing_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiushenqing weixiushenqing, String bianhao, String shebeimingcheng, String qingkuangjianshu, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=weixiushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiushenqing> list=weixiushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiushenqing_yanben2";
	}
	@RequestMapping("weixiushenqing_yanben3.do")
	public String weixiushenqing_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiushenqing weixiushenqing, String bianhao, String shebeimingcheng, String qingkuangjianshu, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=weixiushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiushenqing> list=weixiushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiushenqing_yanben3";
	}
	@RequestMapping("weixiushenqing_yanben4.do")
	public String weixiushenqing_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiushenqing weixiushenqing, String bianhao, String shebeimingcheng, String qingkuangjianshu, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=weixiushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiushenqing> list=weixiushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiushenqing_yanben4";
	}
	@RequestMapping("weixiushenqing_yanben5.do")
	public String weixiushenqing_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiushenqing weixiushenqing, String bianhao, String shebeimingcheng, String qingkuangjianshu, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=weixiushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiushenqing> list=weixiushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiushenqing_yanben5";
	}
	
	@RequestMapping("weixiushenqingList2.do")
	public String weixiushenqingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiushenqing weixiushenqing, String bianhao, String shebeimingcheng, String qingkuangjianshu, String shenqingren, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("shenqingren", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}
		
		
		int total=weixiushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiushenqing> list=weixiushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiushenqing_list2";
	}
	
	
	@RequestMapping("wxsqList.do")
	public String wxsqList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiushenqing weixiushenqing, String bianhao, String shebeimingcheng, String qingkuangjianshu, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=weixiushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiushenqing> list=weixiushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiushenqinglist";
	}
	@RequestMapping("wxsqListtp.do")
	public String wxsqListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiushenqing weixiushenqing, String bianhao, String shebeimingcheng, String qingkuangjianshu, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=weixiushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiushenqing> list=weixiushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiushenqinglisttp";
	}
	
	@RequestMapping("deleteWeixiushenqing.do")
	public String deleteWeixiushenqing(int id,HttpServletRequest request){
		weixiushenqingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:weixiushenqingList.do";
	}
	
	
}
