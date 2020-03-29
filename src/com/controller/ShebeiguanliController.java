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

import com.entity.Shebeiguanli;
import com.server.ShebeiguanliServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShebeiguanliController {
	@Resource
	private ShebeiguanliServer shebeiguanliService;


   
	@RequestMapping("addShebeiguanli.do")
	public String addShebeiguanli(HttpServletRequest request,Shebeiguanli shebeiguanli,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shebeiguanli.setAddtime(time.toString().substring(0, 19));
		shebeiguanliService.add(shebeiguanli);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shebeiguanliList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shebeiguanliList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShebeiguanli.do")
	public String doUpdateShebeiguanli(int id,ModelMap map,Shebeiguanli shebeiguanli){
		shebeiguanli=shebeiguanliService.getById(id);
		map.put("shebeiguanli", shebeiguanli);
		return "shebeiguanli_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shebeiguanliDetail.do")
	public String shebeiguanliDetail(int id,ModelMap map,Shebeiguanli shebeiguanli){
		shebeiguanli=shebeiguanliService.getById(id);
		map.put("shebeiguanli", shebeiguanli);
		return "shebeiguanli_detail";
	}
//	前台详细
	@RequestMapping("sbglDetail.do")
	public String sbglDetail(int id,ModelMap map,Shebeiguanli shebeiguanli){
		shebeiguanli=shebeiguanliService.getById(id);
		map.put("shebeiguanli", shebeiguanli);
		return "shebeiguanlidetail";
	}
//	
	@RequestMapping("updateShebeiguanli.do")
	public String updateShebeiguanli(int id,ModelMap map,Shebeiguanli shebeiguanli,HttpServletRequest request,HttpSession session){
		shebeiguanliService.update(shebeiguanli);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shebeiguanliList.do";
	}

//	分页查询
	@RequestMapping("shebeiguanliList.do")
	public String shebeiguanliList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiguanli shebeiguanli, String bianhao, String shebeimingcheng, String kucun1,String kucun2, String shebeixiangqing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		if(shebeixiangqing==null||shebeixiangqing.equals("")){pmap.put("shebeixiangqing", null);}else{pmap.put("shebeixiangqing", shebeixiangqing);}		
		int total=shebeiguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiguanli> list=shebeiguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiguanli_list";
	}
	
	@RequestMapping("shebeiguanli_yanben1.do")
	public String shebeiguanli_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiguanli shebeiguanli, String bianhao, String shebeimingcheng, String kucun1,String kucun2, String shebeixiangqing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		if(shebeixiangqing==null||shebeixiangqing.equals("")){pmap.put("shebeixiangqing", null);}else{pmap.put("shebeixiangqing", shebeixiangqing);}		
		int total=shebeiguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiguanli> list=shebeiguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiguanli_yanben1";
	}
	@RequestMapping("shebeiguanli_yanben2.do")
	public String shebeiguanli_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiguanli shebeiguanli, String bianhao, String shebeimingcheng, String kucun1,String kucun2, String shebeixiangqing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		if(shebeixiangqing==null||shebeixiangqing.equals("")){pmap.put("shebeixiangqing", null);}else{pmap.put("shebeixiangqing", shebeixiangqing);}		
		int total=shebeiguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiguanli> list=shebeiguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiguanli_yanben2";
	}
	@RequestMapping("shebeiguanli_yanben3.do")
	public String shebeiguanli_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiguanli shebeiguanli, String bianhao, String shebeimingcheng, String kucun1,String kucun2, String shebeixiangqing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		if(shebeixiangqing==null||shebeixiangqing.equals("")){pmap.put("shebeixiangqing", null);}else{pmap.put("shebeixiangqing", shebeixiangqing);}		
		int total=shebeiguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiguanli> list=shebeiguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiguanli_yanben3";
	}
	@RequestMapping("shebeiguanli_yanben4.do")
	public String shebeiguanli_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiguanli shebeiguanli, String bianhao, String shebeimingcheng, String kucun1,String kucun2, String shebeixiangqing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		if(shebeixiangqing==null||shebeixiangqing.equals("")){pmap.put("shebeixiangqing", null);}else{pmap.put("shebeixiangqing", shebeixiangqing);}		
		int total=shebeiguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiguanli> list=shebeiguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiguanli_yanben4";
	}
	@RequestMapping("shebeiguanli_yanben5.do")
	public String shebeiguanli_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiguanli shebeiguanli, String bianhao, String shebeimingcheng, String kucun1,String kucun2, String shebeixiangqing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		if(shebeixiangqing==null||shebeixiangqing.equals("")){pmap.put("shebeixiangqing", null);}else{pmap.put("shebeixiangqing", shebeixiangqing);}		
		int total=shebeiguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiguanli> list=shebeiguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiguanli_yanben5";
	}
	
	
	
	@RequestMapping("sbglList.do")
	public String sbglList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiguanli shebeiguanli, String bianhao, String shebeimingcheng, String kucun1,String kucun2, String shebeixiangqing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		if(shebeixiangqing==null||shebeixiangqing.equals("")){pmap.put("shebeixiangqing", null);}else{pmap.put("shebeixiangqing", shebeixiangqing);}		
		int total=shebeiguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiguanli> list=shebeiguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiguanlilist";
	}
	@RequestMapping("sbglListtp.do")
	public String sbglListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeiguanli shebeiguanli, String bianhao, String shebeimingcheng, String kucun1,String kucun2, String shebeixiangqing){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		if(shebeixiangqing==null||shebeixiangqing.equals("")){pmap.put("shebeixiangqing", null);}else{pmap.put("shebeixiangqing", shebeixiangqing);}		
		int total=shebeiguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeiguanli> list=shebeiguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeiguanlilisttp";
	}
	
	@RequestMapping("deleteShebeiguanli.do")
	public String deleteShebeiguanli(int id,HttpServletRequest request){
		shebeiguanliService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shebeiguanliList.do";
	}
	
	@RequestMapping("quchongShebeiguanli.do")
	public void quchongShebeiguanli(Shebeiguanli shebeiguanli,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("bianhao", shebeiguanli.getBianhao());
		   System.out.println("bianhao==="+shebeiguanli.getBianhao());
		   System.out.println("bianhao222==="+shebeiguanliService.quchongShebeiguanli(map));
		   JSONObject obj=new JSONObject();
		   if(shebeiguanliService.quchongShebeiguanli(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "编号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
