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

import com.entity.Shebeiyunxing2;
import com.server.Shebeiyunxing2Server;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class Shebeiyunxing2Controller {
	@Resource
	private Shebeiyunxing2Server shebeiyunxing2Service;


   
	@RequestMapping("addShebeiyunxing2.do")
	public String addShebeiyunxing2(HttpServletRequest request,Shebeiyunxing2 shebeiyunxing2,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shebeiyunxing2.setAddtime(time.toString().substring(0, 19));
		shebeiyunxing2Service.add(shebeiyunxing2);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shebeiyunxingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shebeiyunxingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShebeiyunxing2.do")
	public String doUpdateShebeiyunxing2(int id,ModelMap map,Shebeiyunxing2 shebeiyunxing2){
		shebeiyunxing2=shebeiyunxing2Service.getById(id);
		map.put("shebeiyunxing", shebeiyunxing2);
		return "shebeiyunxing2_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shebeiyunxing2Detail.do")
	public String shebeiyunxing2Detail(int id,ModelMap map,Shebeiyunxing2 shebeiyunxing2){
		shebeiyunxing2=shebeiyunxing2Service.getById(id);
		map.put("shebeiyunxing2", shebeiyunxing2);
		return "shebeiyunxing2_detail";
	}
//	前台详细
	@RequestMapping("sbyx2Detail.do")
	public String sbyx2Detail(int id,ModelMap map,Shebeiyunxing2 shebeiyunxing2){
		shebeiyunxing2=shebeiyunxing2Service.getById(id);
		map.put("shebeiyunxing2", shebeiyunxing2);
		return "shebeiyunxing2detail";
	}
//	
	@RequestMapping("updateShebeiyunxing2.do")
	public String updateShebeiyunxing2(int id,ModelMap map,Shebeiyunxing2 shebeiyunxing2,HttpServletRequest request,HttpSession session){
		shebeiyunxing2Service.update(shebeiyunxing2);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shebeiyunxingList.do";
	}

//	分页查询
	@RequestMapping("shebeiyunxing2List.do")
	public String shebeiyunxing2List(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing2 shebeiyunxing2, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing2Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing2> list=shebeiyunxing2Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing2_list";
	}
	
	@RequestMapping("shebeiyunxing2_yanben1.do")
	public String shebeiyunxing2_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing2 shebeiyunxing2, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing2Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing2> list=shebeiyunxing2Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing2_yanben1";
	}
	@RequestMapping("shebeiyunxing2_yanben2.do")
	public String shebeiyunxing2_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing2 shebeiyunxing2, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing2Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing2> list=shebeiyunxing2Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing2_yanben2";
	}
	@RequestMapping("shebeiyunxing2_yanben3.do")
	public String shebeiyunxing2_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing2 shebeiyunxing2, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing2Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing2> list=shebeiyunxing2Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing2_yanben3";
	}
	@RequestMapping("shebeiyunxing2_yanben4.do")
	public String shebeiyunxing2_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing2 shebeiyunxing2, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing2Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing2> list=shebeiyunxing2Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing2_yanben4";
	}
	@RequestMapping("shebeiyunxing2_yanben5.do")
	public String shebeiyunxing2_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing2 shebeiyunxing2, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing2Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing2> list=shebeiyunxing2Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing2_yanben5";
	}
	
	
	
	@RequestMapping("sbyx2List.do")
	public String sbyx2List(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing2 shebeiyunxing2, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing2Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing2> list=shebeiyunxing2Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing2list";
	}
	@RequestMapping("sbyx2Listtp.do")
	public String sbyx2Listtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing2 shebeiyunxing2, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing2Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing2> list=shebeiyunxing2Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing2listtp";
	}
	
	@RequestMapping("deleteShebeiyunxing2.do")
	public String deleteShebeiyunxing2(int id,HttpServletRequest request){
		shebeiyunxing2Service.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shebeiyunxingList.do";
	}
	
	
}
