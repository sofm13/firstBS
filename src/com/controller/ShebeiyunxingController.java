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

import com.entity.Shebeiyunxing;
import com.server.ShebeiyunxingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShebeiyunxingController {
	@Resource
	private ShebeiyunxingServer shebeiyunxingService;


   
	@RequestMapping("addShebeiyunxing.do")
	public String addShebeiyunxing(HttpServletRequest request,Shebeiyunxing shebeiyunxing,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shebeiyunxing.setAddtime(time.toString().substring(0, 19));
		shebeiyunxingService.add(shebeiyunxing);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shebeiyunxingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shebeiyunxingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShebeiyunxing.do")
	public String doUpdateShebeiyunxing(int id,ModelMap map,Shebeiyunxing shebeiyunxing){
		shebeiyunxing=shebeiyunxingService.getById(id);
		map.put("shebeiyunxing", shebeiyunxing);
		return "shebeiyunxing_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shebeiyunxingDetail.do")
	public String shebeiyunxingDetail(int id,ModelMap map,Shebeiyunxing shebeiyunxing){
		shebeiyunxing=shebeiyunxingService.getById(id);
		map.put("shebeiyunxing", shebeiyunxing);
		return "shebeiyunxing_detail";
	}
//	前台详细
	@RequestMapping("sbyxDetail.do")
	public String sbyxDetail(int id,ModelMap map,Shebeiyunxing shebeiyunxing){
		shebeiyunxing=shebeiyunxingService.getById(id);
		map.put("shebeiyunxing", shebeiyunxing);
		return "shebeiyunxingdetail";
	}
//	
	@RequestMapping("updateShebeiyunxing.do")
	public String updateShebeiyunxing(int id,ModelMap map,Shebeiyunxing shebeiyunxing,HttpServletRequest request,HttpSession session){
		shebeiyunxingService.update(shebeiyunxing);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shebeiyunxingList.do";
	}

//	分页查询
	@RequestMapping("shebeiyunxingList.do")
	public String shebeiyunxingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing shebeiyunxing, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing> list=shebeiyunxingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing_list";
	}
	
	@RequestMapping("shebeiyunxing_yanben1.do")
	public String shebeiyunxing_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing shebeiyunxing, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing> list=shebeiyunxingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing_yanben1";
	}
	@RequestMapping("shebeiyunxing_yanben2.do")
	public String shebeiyunxing_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing shebeiyunxing, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing> list=shebeiyunxingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing_yanben2";
	}
	@RequestMapping("shebeiyunxing_yanben3.do")
	public String shebeiyunxing_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing shebeiyunxing, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing> list=shebeiyunxingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing_yanben3";
	}
	@RequestMapping("shebeiyunxing_yanben4.do")
	public String shebeiyunxing_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing shebeiyunxing, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing> list=shebeiyunxingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing_yanben4";
	}
	@RequestMapping("shebeiyunxing_yanben5.do")
	public String shebeiyunxing_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing shebeiyunxing, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing> list=shebeiyunxingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing_yanben5";
	}
	
	
	
	@RequestMapping("sbyxList.do")
	public String sbyxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing shebeiyunxing, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing> list=shebeiyunxingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxinglist";
	}
	@RequestMapping("sbyxListtp.do")
	public String sbyxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing shebeiyunxing, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing> list=shebeiyunxingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxinglisttp";
	}
	
	@RequestMapping("deleteShebeiyunxing.do")
	public String deleteShebeiyunxing(int id,HttpServletRequest request){
		shebeiyunxingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shebeiyunxingList.do";
	}
	
	
}
