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

import com.entity.Shebeichuku;
import com.server.ShebeichukuServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShebeichukuController {
	@Resource
	private ShebeichukuServer shebeichukuService;


   
	@RequestMapping("addShebeichuku.do")
	public String addShebeichuku(HttpServletRequest request,Shebeichuku shebeichuku,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shebeichuku.setAddtime(time.toString().substring(0, 19));
		shebeichukuService.add(shebeichuku);
		db dbo = new db();dbo.hsgexecute("update shebeiguanli set kucun=kucun-"+shebeichuku.getShenqingshuliang()+" where bianhao='"+shebeichuku.getBianhao()+"'");
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shebeichukuList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shebeichukuList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShebeichuku.do")
	public String doUpdateShebeichuku(int id,ModelMap map,Shebeichuku shebeichuku){
		shebeichuku=shebeichukuService.getById(id);
		map.put("shebeichuku", shebeichuku);
		return "shebeichuku_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shebeichukuDetail.do")
	public String shebeichukuDetail(int id,ModelMap map,Shebeichuku shebeichuku){
		shebeichuku=shebeichukuService.getById(id);
		map.put("shebeichuku", shebeichuku);
		return "shebeichuku_detail";
	}
//	前台详细
	@RequestMapping("sbckDetail.do")
	public String sbckDetail(int id,ModelMap map,Shebeichuku shebeichuku){
		shebeichuku=shebeichukuService.getById(id);
		map.put("shebeichuku", shebeichuku);
		return "shebeichukudetail";
	}
//	
	@RequestMapping("updateShebeichuku.do")
	public String updateShebeichuku(int id,ModelMap map,Shebeichuku shebeichuku,HttpServletRequest request,HttpSession session){
		shebeichukuService.update(shebeichuku);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shebeichukuList.do";
	}

//	分页查询
	@RequestMapping("shebeichukuList.do")
	public String shebeichukuList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeichuku shebeichuku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeichukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeichuku> list=shebeichukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeichuku_list";
	}
	
	@RequestMapping("shebeichuku_yanben1.do")
	public String shebeichuku_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeichuku shebeichuku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeichukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeichuku> list=shebeichukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeichuku_yanben1";
	}
	@RequestMapping("shebeichuku_yanben2.do")
	public String shebeichuku_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeichuku shebeichuku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeichukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeichuku> list=shebeichukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeichuku_yanben2";
	}
	@RequestMapping("shebeichuku_yanben3.do")
	public String shebeichuku_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeichuku shebeichuku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeichukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeichuku> list=shebeichukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeichuku_yanben3";
	}
	@RequestMapping("shebeichuku_yanben4.do")
	public String shebeichuku_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeichuku shebeichuku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeichukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeichuku> list=shebeichukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeichuku_yanben4";
	}
	@RequestMapping("shebeichuku_yanben5.do")
	public String shebeichuku_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeichuku shebeichuku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeichukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeichuku> list=shebeichukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeichuku_yanben5";
	}
	
	
	
	@RequestMapping("sbckList.do")
	public String sbckList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeichuku shebeichuku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeichukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeichuku> list=shebeichukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeichukulist";
	}
	@RequestMapping("sbckListtp.do")
	public String sbckListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeichuku shebeichuku, String bianhao, String shebeimingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		
		int total=shebeichukuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeichuku> list=shebeichukuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeichukulisttp";
	}
	
	@RequestMapping("deleteShebeichuku.do")
	public String deleteShebeichuku(int id,HttpServletRequest request){
		shebeichukuService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shebeichukuList.do";
	}
	
	
}
