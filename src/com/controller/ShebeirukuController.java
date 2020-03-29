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

import com.entity.Shebeiruku;
import com.server.ShebeirukuServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShebeirukuController {
	@Resource
	private ShebeirukuServer shebeirukuService;


   
	@RequestMapping("addShebeiruku.do")
	public String addShebeiruku(HttpServletRequest request,Shebeiruku shebeiruku,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shebeiruku.setAddtime(time.toString().substring(0, 19));
		shebeirukuService.add(shebeiruku);
		db dbo = new db();dbo.hsgexecute("update shebeiguanli set kucun=kucun+"+shebeiruku.getShenqingshuliang()+" where bianhao='"+shebeiruku.getBianhao()+"'");
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shebeirukuList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shebeirukuList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShebeiruku.do")
	public String doUpdateShebeiruku(int id,ModelMap map,Shebeiruku shebeiruku){
		shebeiruku=shebeirukuService.getById(id);
		map.put("shebeiruku", shebeiruku);
		return "shebeiruku_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shebeirukuDetail.do")
	public String shebeirukuDetail(int id,ModelMap map,Shebeiruku shebeiruku){
		shebeiruku=shebeirukuService.getById(id);
		map.put("shebeiruku", shebeiruku);
		return "shebeiruku_detail";
	}
//	前台详细
	@RequestMapping("sbrkDetail.do")
	public String sbrkDetail(int id,ModelMap map,Shebeiruku shebeiruku){
		shebeiruku=shebeirukuService.getById(id);
		map.put("shebeiruku", shebeiruku);
		return "shebeirukudetail";
	}
//	
	@RequestMapping("updateShebeiruku.do")
	public String updateShebeiruku(int id,ModelMap map,Shebeiruku shebeiruku,HttpServletRequest request,HttpSession session){
		shebeirukuService.update(shebeiruku);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shebeirukuList.do";
	}

//	分页查询
	@RequestMapping("shebeirukuList.do")
	public String shebeirukuList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiruku shebeiruku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeirukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiruku> list=shebeirukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiruku_list";
	}
	
	@RequestMapping("shebeiruku_yanben1.do")
	public String shebeiruku_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiruku shebeiruku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeirukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiruku> list=shebeirukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiruku_yanben1";
	}
	@RequestMapping("shebeiruku_yanben2.do")
	public String shebeiruku_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiruku shebeiruku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeirukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiruku> list=shebeirukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiruku_yanben2";
	}
	@RequestMapping("shebeiruku_yanben3.do")
	public String shebeiruku_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiruku shebeiruku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeirukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiruku> list=shebeirukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiruku_yanben3";
	}
	@RequestMapping("shebeiruku_yanben4.do")
	public String shebeiruku_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiruku shebeiruku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeirukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiruku> list=shebeirukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiruku_yanben4";
	}
	@RequestMapping("shebeiruku_yanben5.do")
	public String shebeiruku_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiruku shebeiruku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeirukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiruku> list=shebeirukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiruku_yanben5";
	}
	
	
	
	@RequestMapping("sbrkList.do")
	public String sbrkList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiruku shebeiruku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeirukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiruku> list=shebeirukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeirukulist";
	}
	@RequestMapping("sbrkListtp.do")
	public String sbrkListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiruku shebeiruku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeirukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiruku> list=shebeirukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeirukulisttp";
	}
	
	@RequestMapping("deleteShebeiruku.do")
	public String deleteShebeiruku(int id,HttpServletRequest request){
		shebeirukuService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shebeirukuList.do";
	}
	
	
}
