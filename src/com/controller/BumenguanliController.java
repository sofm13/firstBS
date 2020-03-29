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

import com.entity.Bumenguanli;
import com.server.BumenguanliServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class BumenguanliController {
	@Resource
	private BumenguanliServer bumenguanliService;


   
	@RequestMapping("addBumenguanli.do")
	public String addBumenguanli(HttpServletRequest request,Bumenguanli bumenguanli,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		bumenguanli.setAddtime(time.toString().substring(0, 19));
		bumenguanliService.add(bumenguanli);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "bumenguanliList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:bumenguanliList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateBumenguanli.do")
	public String doUpdateBumenguanli(int id,ModelMap map,Bumenguanli bumenguanli){
		bumenguanli=bumenguanliService.getById(id);
		map.put("bumenguanli", bumenguanli);
		return "bumenguanli_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("bumenguanliDetail.do")
	public String bumenguanliDetail(int id,ModelMap map,Bumenguanli bumenguanli){
		bumenguanli=bumenguanliService.getById(id);
		map.put("bumenguanli", bumenguanli);
		return "bumenguanli_detail";
	}
//	前台详细
	@RequestMapping("bmglDetail.do")
	public String bmglDetail(int id,ModelMap map,Bumenguanli bumenguanli){
		bumenguanli=bumenguanliService.getById(id);
		map.put("bumenguanli", bumenguanli);
		return "bumenguanlidetail";
	}
//	
	@RequestMapping("updateBumenguanli.do")
	public String updateBumenguanli(int id,ModelMap map,Bumenguanli bumenguanli,HttpServletRequest request,HttpSession session){
		bumenguanliService.update(bumenguanli);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:bumenguanliList.do";
	}

//	分页查询
	@RequestMapping("bumenguanliList.do")
	public String bumenguanliList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bumenguanli bumenguanli, String bumenbianhao, String bumenmingcheng, String bumendianhua, String bumenchuanzhen, String bumenxinxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenbianhao==null||bumenbianhao.equals("")){pmap.put("bumenbianhao", null);}else{pmap.put("bumenbianhao", bumenbianhao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(bumendianhua==null||bumendianhua.equals("")){pmap.put("bumendianhua", null);}else{pmap.put("bumendianhua", bumendianhua);}		if(bumenchuanzhen==null||bumenchuanzhen.equals("")){pmap.put("bumenchuanzhen", null);}else{pmap.put("bumenchuanzhen", bumenchuanzhen);}		if(bumenxinxi==null||bumenxinxi.equals("")){pmap.put("bumenxinxi", null);}else{pmap.put("bumenxinxi", bumenxinxi);}		
		int total=bumenguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bumenguanli> list=bumenguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bumenguanli_list";
	}
	
	@RequestMapping("bumenguanli_yanben1.do")
	public String bumenguanli_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bumenguanli bumenguanli, String bumenbianhao, String bumenmingcheng, String bumendianhua, String bumenchuanzhen, String bumenxinxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenbianhao==null||bumenbianhao.equals("")){pmap.put("bumenbianhao", null);}else{pmap.put("bumenbianhao", bumenbianhao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(bumendianhua==null||bumendianhua.equals("")){pmap.put("bumendianhua", null);}else{pmap.put("bumendianhua", bumendianhua);}		if(bumenchuanzhen==null||bumenchuanzhen.equals("")){pmap.put("bumenchuanzhen", null);}else{pmap.put("bumenchuanzhen", bumenchuanzhen);}		if(bumenxinxi==null||bumenxinxi.equals("")){pmap.put("bumenxinxi", null);}else{pmap.put("bumenxinxi", bumenxinxi);}		
		int total=bumenguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bumenguanli> list=bumenguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bumenguanli_yanben1";
	}
	@RequestMapping("bumenguanli_yanben2.do")
	public String bumenguanli_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bumenguanli bumenguanli, String bumenbianhao, String bumenmingcheng, String bumendianhua, String bumenchuanzhen, String bumenxinxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenbianhao==null||bumenbianhao.equals("")){pmap.put("bumenbianhao", null);}else{pmap.put("bumenbianhao", bumenbianhao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(bumendianhua==null||bumendianhua.equals("")){pmap.put("bumendianhua", null);}else{pmap.put("bumendianhua", bumendianhua);}		if(bumenchuanzhen==null||bumenchuanzhen.equals("")){pmap.put("bumenchuanzhen", null);}else{pmap.put("bumenchuanzhen", bumenchuanzhen);}		if(bumenxinxi==null||bumenxinxi.equals("")){pmap.put("bumenxinxi", null);}else{pmap.put("bumenxinxi", bumenxinxi);}		
		int total=bumenguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bumenguanli> list=bumenguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bumenguanli_yanben2";
	}
	@RequestMapping("bumenguanli_yanben3.do")
	public String bumenguanli_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bumenguanli bumenguanli, String bumenbianhao, String bumenmingcheng, String bumendianhua, String bumenchuanzhen, String bumenxinxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenbianhao==null||bumenbianhao.equals("")){pmap.put("bumenbianhao", null);}else{pmap.put("bumenbianhao", bumenbianhao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(bumendianhua==null||bumendianhua.equals("")){pmap.put("bumendianhua", null);}else{pmap.put("bumendianhua", bumendianhua);}		if(bumenchuanzhen==null||bumenchuanzhen.equals("")){pmap.put("bumenchuanzhen", null);}else{pmap.put("bumenchuanzhen", bumenchuanzhen);}		if(bumenxinxi==null||bumenxinxi.equals("")){pmap.put("bumenxinxi", null);}else{pmap.put("bumenxinxi", bumenxinxi);}		
		int total=bumenguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bumenguanli> list=bumenguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bumenguanli_yanben3";
	}
	@RequestMapping("bumenguanli_yanben4.do")
	public String bumenguanli_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bumenguanli bumenguanli, String bumenbianhao, String bumenmingcheng, String bumendianhua, String bumenchuanzhen, String bumenxinxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenbianhao==null||bumenbianhao.equals("")){pmap.put("bumenbianhao", null);}else{pmap.put("bumenbianhao", bumenbianhao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(bumendianhua==null||bumendianhua.equals("")){pmap.put("bumendianhua", null);}else{pmap.put("bumendianhua", bumendianhua);}		if(bumenchuanzhen==null||bumenchuanzhen.equals("")){pmap.put("bumenchuanzhen", null);}else{pmap.put("bumenchuanzhen", bumenchuanzhen);}		if(bumenxinxi==null||bumenxinxi.equals("")){pmap.put("bumenxinxi", null);}else{pmap.put("bumenxinxi", bumenxinxi);}		
		int total=bumenguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bumenguanli> list=bumenguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bumenguanli_yanben4";
	}
	@RequestMapping("bumenguanli_yanben5.do")
	public String bumenguanli_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bumenguanli bumenguanli, String bumenbianhao, String bumenmingcheng, String bumendianhua, String bumenchuanzhen, String bumenxinxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenbianhao==null||bumenbianhao.equals("")){pmap.put("bumenbianhao", null);}else{pmap.put("bumenbianhao", bumenbianhao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(bumendianhua==null||bumendianhua.equals("")){pmap.put("bumendianhua", null);}else{pmap.put("bumendianhua", bumendianhua);}		if(bumenchuanzhen==null||bumenchuanzhen.equals("")){pmap.put("bumenchuanzhen", null);}else{pmap.put("bumenchuanzhen", bumenchuanzhen);}		if(bumenxinxi==null||bumenxinxi.equals("")){pmap.put("bumenxinxi", null);}else{pmap.put("bumenxinxi", bumenxinxi);}		
		int total=bumenguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bumenguanli> list=bumenguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bumenguanli_yanben5";
	}
	
	
	
	@RequestMapping("bmglList.do")
	public String bmglList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bumenguanli bumenguanli, String bumenbianhao, String bumenmingcheng, String bumendianhua, String bumenchuanzhen, String bumenxinxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenbianhao==null||bumenbianhao.equals("")){pmap.put("bumenbianhao", null);}else{pmap.put("bumenbianhao", bumenbianhao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(bumendianhua==null||bumendianhua.equals("")){pmap.put("bumendianhua", null);}else{pmap.put("bumendianhua", bumendianhua);}		if(bumenchuanzhen==null||bumenchuanzhen.equals("")){pmap.put("bumenchuanzhen", null);}else{pmap.put("bumenchuanzhen", bumenchuanzhen);}		if(bumenxinxi==null||bumenxinxi.equals("")){pmap.put("bumenxinxi", null);}else{pmap.put("bumenxinxi", bumenxinxi);}		
		int total=bumenguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bumenguanli> list=bumenguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bumenguanlilist";
	}
	@RequestMapping("bmglListtp.do")
	public String bmglListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bumenguanli bumenguanli, String bumenbianhao, String bumenmingcheng, String bumendianhua, String bumenchuanzhen, String bumenxinxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumenbianhao==null||bumenbianhao.equals("")){pmap.put("bumenbianhao", null);}else{pmap.put("bumenbianhao", bumenbianhao);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(bumendianhua==null||bumendianhua.equals("")){pmap.put("bumendianhua", null);}else{pmap.put("bumendianhua", bumendianhua);}		if(bumenchuanzhen==null||bumenchuanzhen.equals("")){pmap.put("bumenchuanzhen", null);}else{pmap.put("bumenchuanzhen", bumenchuanzhen);}		if(bumenxinxi==null||bumenxinxi.equals("")){pmap.put("bumenxinxi", null);}else{pmap.put("bumenxinxi", bumenxinxi);}		
		int total=bumenguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bumenguanli> list=bumenguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bumenguanlilisttp";
	}
	
	@RequestMapping("deleteBumenguanli.do")
	public String deleteBumenguanli(int id,HttpServletRequest request){
		bumenguanliService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:bumenguanliList.do";
	}
	
	
}
