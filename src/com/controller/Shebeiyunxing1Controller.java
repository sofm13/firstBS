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

import com.entity.Shebeiyunxing1;
import com.server.Shebeiyunxing1Server;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class Shebeiyunxing1Controller {
	@Resource
	private Shebeiyunxing1Server shebeiyunxing1Service;


   
	@RequestMapping("addShebeiyunxing1.do")
	public String addShebeiyunxing1(HttpServletRequest request,Shebeiyunxing1 shebeiyunxing1,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shebeiyunxing1.setAddtime(time.toString().substring(0, 19));
		shebeiyunxing1Service.add(shebeiyunxing1);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shebeiyunxingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shebeiyunxingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShebeiyunxing1.do")
	public String doUpdateShebeiyunxing1(int id,ModelMap map,Shebeiyunxing1 shebeiyunxing1){
		shebeiyunxing1=shebeiyunxing1Service.getById(id);
		map.put("shebeiyunxing", shebeiyunxing1);
		return "shebeiyunxing1_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shebeiyunxing1Detail.do")
	public String shebeiyunxing1Detail(int id,ModelMap map,Shebeiyunxing1 shebeiyunxing1){
		shebeiyunxing1=shebeiyunxing1Service.getById(id);
		map.put("shebeiyunxing1", shebeiyunxing1);
		return "shebeiyunxing1_detail";
	}
//	前台详细
	@RequestMapping("sbyx1Detail.do")
	public String sbyx1Detail(int id,ModelMap map,Shebeiyunxing1 shebeiyunxing1){
		shebeiyunxing1=shebeiyunxing1Service.getById(id);
		map.put("shebeiyunxing1", shebeiyunxing1);
		return "shebeiyunxing1detail";
	}
//	
	@RequestMapping("updateShebeiyunxing1.do")
	public String updateShebeiyunxing1(int id,ModelMap map,Shebeiyunxing1 shebeiyunxing1,HttpServletRequest request,HttpSession session){
		shebeiyunxing1Service.update(shebeiyunxing1);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shebeiyunxingList.do";
	}

//	分页查询
	@RequestMapping("shebeiyunxing1List.do")
	public String shebeiyunxing1List(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing1 shebeiyunxing1, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing1> list=shebeiyunxing1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing1_list";
	}
	
	@RequestMapping("shebeiyunxing1_yanben1.do")
	public String shebeiyunxing1_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing1 shebeiyunxing, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing1> list=shebeiyunxing1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing1_yanben1";
	}
	@RequestMapping("shebeiyunxing1_yanben2.do")
	public String shebeiyunxing1_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing1 shebeiyunxing1, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing1> list=shebeiyunxing1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing1_yanben2";
	}
	@RequestMapping("shebeiyunxing1_yanben3.do")
	public String shebeiyunxing1_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing1 shebeiyunxing, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing1> list=shebeiyunxing1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing1_yanben3";
	}
	@RequestMapping("shebeiyunxing1_yanben4.do")
	public String shebeiyunxing1_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing1 shebeiyunxing1, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing1> list=shebeiyunxing1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing1_yanben4";
	}
	@RequestMapping("shebeiyunxing1_yanben5.do")
	public String shebeiyunxing1_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing1 shebeiyunxing1, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing1> list=shebeiyunxing1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing1_yanben5";
	}
	
	
	
	@RequestMapping("sbyx1List.do")
	public String sbyx1List(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing1 shebeiyunxing1, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing1> list=shebeiyunxing1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing1list";
	}
	@RequestMapping("sbyx1Listtp.do")
	public String sbyx1Listtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing1 shebeiyunxing1, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing1> list=shebeiyunxing1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing1listtp";
	}
	
	@RequestMapping("deleteShebeiyunxing1.do")
	public String deleteShebeiyunxing1(int id,HttpServletRequest request){
		shebeiyunxing1Service.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shebeiyunxingList.do";
	}
	
	
}
