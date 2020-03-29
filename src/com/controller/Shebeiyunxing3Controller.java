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

import com.entity.Shebeiyunxing3;
import com.server.Shebeiyunxing3Server;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class Shebeiyunxing3Controller {
	@Resource
	private Shebeiyunxing3Server shebeiyunxing3Service;


   
	@RequestMapping("addShebeiyunxing3.do")
	public String addShebeiyunxing3(HttpServletRequest request,Shebeiyunxing3 shebeiyunxing3,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shebeiyunxing3.setAddtime(time.toString().substring(0, 19));
		shebeiyunxing3Service.add(shebeiyunxing3);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shebeiyunxingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shebeiyunxingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShebeiyunxing3.do")
	public String doUpdateShebeiyunxing3(int id,ModelMap map,Shebeiyunxing3 shebeiyunxing3){
		shebeiyunxing3=shebeiyunxing3Service.getById(id);
		map.put("shebeiyunxing", shebeiyunxing3);
		return "shebeiyunxing3_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shebeiyunxing3Detail.do")
	public String shebeiyunxing3Detail(int id,ModelMap map,Shebeiyunxing3 shebeiyunxing3){
		shebeiyunxing3=shebeiyunxing3Service.getById(id);
		map.put("shebeiyunxing3", shebeiyunxing3);
		return "shebeiyunxing3_detail";
	}
//	前台详细
	@RequestMapping("sbyx3Detail.do")
	public String sbyx3Detail(int id,ModelMap map,Shebeiyunxing3 shebeiyunxing3){
		shebeiyunxing3=shebeiyunxing3Service.getById(id);
		map.put("shebeiyunxing3", shebeiyunxing3);
		return "shebeiyunxing3detail";
	}
//	
	@RequestMapping("updateShebeiyunxing3.do")
	public String updateShebeiyunxing3(int id,ModelMap map,Shebeiyunxing3 shebeiyunxing3,HttpServletRequest request,HttpSession session){
		shebeiyunxing3Service.update(shebeiyunxing3);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shebeiyunxingList.do";
	}

//	分页查询
	@RequestMapping("shebeiyunxing3List.do")
	public String shebeiyunxing3List(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing3 shebeiyunxing3, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing3Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing3> list=shebeiyunxing3Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing3_list";
	}
	
	@RequestMapping("shebeiyunxing3_yanben1.do")
	public String shebeiyunxing3_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing3 shebeiyunxing3, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing3Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing3> list=shebeiyunxing3Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing3_yanben1";
	}
	@RequestMapping("shebeiyunxing3_yanben2.do")
	public String shebeiyunxing3_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing3 shebeiyunxing3, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing3Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing3> list=shebeiyunxing3Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing2_yanben2";
	}
	@RequestMapping("shebeiyunxing3_yanben3.do")
	public String shebeiyunxing3_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing3 shebeiyunxing3, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing3Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing3> list=shebeiyunxing3Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing3_yanben3";
	}
	@RequestMapping("shebeiyunxing3_yanben4.do")
	public String shebeiyunxing3_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing3 shebeiyunxing3, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing3Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing3> list=shebeiyunxing3Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing3_yanben4";
	}
	@RequestMapping("shebeiyunxing3_yanben5.do")
	public String shebeiyunxing3_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing3 shebeiyunxing3, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing3Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing3> list=shebeiyunxing3Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing3_yanben5";
	}
	
	
	
	@RequestMapping("sbyx3List.do")
	public String sbyx3List(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing3 shebeiyunxing3, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing3Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing3> list=shebeiyunxing3Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing3list";
	}
	@RequestMapping("sbyx3Listtp.do")
	public String sbyx3Listtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiyunxing3 shebeiyunxing3, String bianhao, String shebeimingcheng, String rizhi, String canshu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(rizhi==null||rizhi.equals("")){pmap.put("rizhi", null);}else{pmap.put("rizhi", rizhi);}		if(canshu==null||canshu.equals("")){pmap.put("canshu", null);}else{pmap.put("canshu", canshu);}		
		int total=shebeiyunxing3Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiyunxing3> list=shebeiyunxing3Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiyunxing3listtp";
	}
	
	@RequestMapping("deleteShebeiyunxing3.do")
	public String deleteShebeiyunxing3(int id,HttpServletRequest request){
		shebeiyunxing3Service.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shebeiyunxingList.do";
	}
	
	
}
