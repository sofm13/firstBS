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

import com.entity.Fapiaoguanli;
import com.server.FapiaoguanliServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class FapiaoguanliController {
	@Resource
	private FapiaoguanliServer fapiaoguanliService;


   
	@RequestMapping("addFapiaoguanli.do")
	public String addFapiaoguanli(HttpServletRequest request,Fapiaoguanli fapiaoguanli,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		fapiaoguanli.setAddtime(time.toString().substring(0, 19));
		fapiaoguanliService.add(fapiaoguanli);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "fapiaoguanliList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:fapiaoguanliList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateFapiaoguanli.do")
	public String doUpdateFapiaoguanli(int id,ModelMap map,Fapiaoguanli fapiaoguanli){
		fapiaoguanli=fapiaoguanliService.getById(id);
		map.put("fapiaoguanli", fapiaoguanli);
		return "fapiaoguanli_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("fapiaoguanliDetail.do")
	public String fapiaoguanliDetail(int id,ModelMap map,Fapiaoguanli fapiaoguanli){
		fapiaoguanli=fapiaoguanliService.getById(id);
		map.put("fapiaoguanli", fapiaoguanli);
		return "fapiaoguanli_detail";
	}
//	前台详细
	@RequestMapping("fpglDetail.do")
	public String fpglDetail(int id,ModelMap map,Fapiaoguanli fapiaoguanli){
		fapiaoguanli=fapiaoguanliService.getById(id);
		map.put("fapiaoguanli", fapiaoguanli);
		return "fapiaoguanlidetail";
	}
//	
	@RequestMapping("updateFapiaoguanli.do")
	public String updateFapiaoguanli(int id,ModelMap map,Fapiaoguanli fapiaoguanli,HttpServletRequest request,HttpSession session){
		fapiaoguanliService.update(fapiaoguanli);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:fapiaoguanliList.do";
	}

//	分页查询
	@RequestMapping("fapiaoguanliList.do")
	public String fapiaoguanliList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fapiaoguanli fapiaoguanli, String bianhao, String shebeimingcheng, String fapiaobianhao, String fapiaoneirong, String fapiaojine1,String fapiaojine2, String jiluren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(fapiaobianhao==null||fapiaobianhao.equals("")){pmap.put("fapiaobianhao", null);}else{pmap.put("fapiaobianhao", fapiaobianhao);}		if(fapiaoneirong==null||fapiaoneirong.equals("")){pmap.put("fapiaoneirong", null);}else{pmap.put("fapiaoneirong", fapiaoneirong);}		if(fapiaojine1==null||fapiaojine1.equals("")){pmap.put("fapiaojine1", null);}else{pmap.put("fapiaojine1", fapiaojine1);}		if(fapiaojine2==null||fapiaojine2.equals("")){pmap.put("fapiaojine2", null);}else{pmap.put("fapiaojine2", fapiaojine2);}		if(jiluren==null||jiluren.equals("")){pmap.put("jiluren", null);}else{pmap.put("jiluren", jiluren);}		
		int total=fapiaoguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fapiaoguanli> list=fapiaoguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fapiaoguanli_list";
	}
	
	@RequestMapping("fapiaoguanli_yanben1.do")
	public String fapiaoguanli_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fapiaoguanli fapiaoguanli, String bianhao, String shebeimingcheng, String fapiaobianhao, String fapiaoneirong, String fapiaojine1,String fapiaojine2, String jiluren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(fapiaobianhao==null||fapiaobianhao.equals("")){pmap.put("fapiaobianhao", null);}else{pmap.put("fapiaobianhao", fapiaobianhao);}		if(fapiaoneirong==null||fapiaoneirong.equals("")){pmap.put("fapiaoneirong", null);}else{pmap.put("fapiaoneirong", fapiaoneirong);}		if(fapiaojine1==null||fapiaojine1.equals("")){pmap.put("fapiaojine1", null);}else{pmap.put("fapiaojine1", fapiaojine1);}		if(fapiaojine2==null||fapiaojine2.equals("")){pmap.put("fapiaojine2", null);}else{pmap.put("fapiaojine2", fapiaojine2);}		if(jiluren==null||jiluren.equals("")){pmap.put("jiluren", null);}else{pmap.put("jiluren", jiluren);}		
		int total=fapiaoguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fapiaoguanli> list=fapiaoguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fapiaoguanli_yanben1";
	}
	@RequestMapping("fapiaoguanli_yanben2.do")
	public String fapiaoguanli_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fapiaoguanli fapiaoguanli, String bianhao, String shebeimingcheng, String fapiaobianhao, String fapiaoneirong, String fapiaojine1,String fapiaojine2, String jiluren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(fapiaobianhao==null||fapiaobianhao.equals("")){pmap.put("fapiaobianhao", null);}else{pmap.put("fapiaobianhao", fapiaobianhao);}		if(fapiaoneirong==null||fapiaoneirong.equals("")){pmap.put("fapiaoneirong", null);}else{pmap.put("fapiaoneirong", fapiaoneirong);}		if(fapiaojine1==null||fapiaojine1.equals("")){pmap.put("fapiaojine1", null);}else{pmap.put("fapiaojine1", fapiaojine1);}		if(fapiaojine2==null||fapiaojine2.equals("")){pmap.put("fapiaojine2", null);}else{pmap.put("fapiaojine2", fapiaojine2);}		if(jiluren==null||jiluren.equals("")){pmap.put("jiluren", null);}else{pmap.put("jiluren", jiluren);}		
		int total=fapiaoguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fapiaoguanli> list=fapiaoguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fapiaoguanli_yanben2";
	}
	@RequestMapping("fapiaoguanli_yanben3.do")
	public String fapiaoguanli_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fapiaoguanli fapiaoguanli, String bianhao, String shebeimingcheng, String fapiaobianhao, String fapiaoneirong, String fapiaojine1,String fapiaojine2, String jiluren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(fapiaobianhao==null||fapiaobianhao.equals("")){pmap.put("fapiaobianhao", null);}else{pmap.put("fapiaobianhao", fapiaobianhao);}		if(fapiaoneirong==null||fapiaoneirong.equals("")){pmap.put("fapiaoneirong", null);}else{pmap.put("fapiaoneirong", fapiaoneirong);}		if(fapiaojine1==null||fapiaojine1.equals("")){pmap.put("fapiaojine1", null);}else{pmap.put("fapiaojine1", fapiaojine1);}		if(fapiaojine2==null||fapiaojine2.equals("")){pmap.put("fapiaojine2", null);}else{pmap.put("fapiaojine2", fapiaojine2);}		if(jiluren==null||jiluren.equals("")){pmap.put("jiluren", null);}else{pmap.put("jiluren", jiluren);}		
		int total=fapiaoguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fapiaoguanli> list=fapiaoguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fapiaoguanli_yanben3";
	}
	@RequestMapping("fapiaoguanli_yanben4.do")
	public String fapiaoguanli_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fapiaoguanli fapiaoguanli, String bianhao, String shebeimingcheng, String fapiaobianhao, String fapiaoneirong, String fapiaojine1,String fapiaojine2, String jiluren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(fapiaobianhao==null||fapiaobianhao.equals("")){pmap.put("fapiaobianhao", null);}else{pmap.put("fapiaobianhao", fapiaobianhao);}		if(fapiaoneirong==null||fapiaoneirong.equals("")){pmap.put("fapiaoneirong", null);}else{pmap.put("fapiaoneirong", fapiaoneirong);}		if(fapiaojine1==null||fapiaojine1.equals("")){pmap.put("fapiaojine1", null);}else{pmap.put("fapiaojine1", fapiaojine1);}		if(fapiaojine2==null||fapiaojine2.equals("")){pmap.put("fapiaojine2", null);}else{pmap.put("fapiaojine2", fapiaojine2);}		if(jiluren==null||jiluren.equals("")){pmap.put("jiluren", null);}else{pmap.put("jiluren", jiluren);}		
		int total=fapiaoguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fapiaoguanli> list=fapiaoguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fapiaoguanli_yanben4";
	}
	@RequestMapping("fapiaoguanli_yanben5.do")
	public String fapiaoguanli_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fapiaoguanli fapiaoguanli, String bianhao, String shebeimingcheng, String fapiaobianhao, String fapiaoneirong, String fapiaojine1,String fapiaojine2, String jiluren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(fapiaobianhao==null||fapiaobianhao.equals("")){pmap.put("fapiaobianhao", null);}else{pmap.put("fapiaobianhao", fapiaobianhao);}		if(fapiaoneirong==null||fapiaoneirong.equals("")){pmap.put("fapiaoneirong", null);}else{pmap.put("fapiaoneirong", fapiaoneirong);}		if(fapiaojine1==null||fapiaojine1.equals("")){pmap.put("fapiaojine1", null);}else{pmap.put("fapiaojine1", fapiaojine1);}		if(fapiaojine2==null||fapiaojine2.equals("")){pmap.put("fapiaojine2", null);}else{pmap.put("fapiaojine2", fapiaojine2);}		if(jiluren==null||jiluren.equals("")){pmap.put("jiluren", null);}else{pmap.put("jiluren", jiluren);}		
		int total=fapiaoguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fapiaoguanli> list=fapiaoguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fapiaoguanli_yanben5";
	}
	
	
	
	@RequestMapping("fpglList.do")
	public String fpglList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fapiaoguanli fapiaoguanli, String bianhao, String shebeimingcheng, String fapiaobianhao, String fapiaoneirong, String fapiaojine1,String fapiaojine2, String jiluren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(fapiaobianhao==null||fapiaobianhao.equals("")){pmap.put("fapiaobianhao", null);}else{pmap.put("fapiaobianhao", fapiaobianhao);}		if(fapiaoneirong==null||fapiaoneirong.equals("")){pmap.put("fapiaoneirong", null);}else{pmap.put("fapiaoneirong", fapiaoneirong);}		if(fapiaojine1==null||fapiaojine1.equals("")){pmap.put("fapiaojine1", null);}else{pmap.put("fapiaojine1", fapiaojine1);}		if(fapiaojine2==null||fapiaojine2.equals("")){pmap.put("fapiaojine2", null);}else{pmap.put("fapiaojine2", fapiaojine2);}		if(jiluren==null||jiluren.equals("")){pmap.put("jiluren", null);}else{pmap.put("jiluren", jiluren);}		
		int total=fapiaoguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fapiaoguanli> list=fapiaoguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fapiaoguanlilist";
	}
	@RequestMapping("fpglListtp.do")
	public String fpglListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fapiaoguanli fapiaoguanli, String bianhao, String shebeimingcheng, String fapiaobianhao, String fapiaoneirong, String fapiaojine1,String fapiaojine2, String jiluren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(fapiaobianhao==null||fapiaobianhao.equals("")){pmap.put("fapiaobianhao", null);}else{pmap.put("fapiaobianhao", fapiaobianhao);}		if(fapiaoneirong==null||fapiaoneirong.equals("")){pmap.put("fapiaoneirong", null);}else{pmap.put("fapiaoneirong", fapiaoneirong);}		if(fapiaojine1==null||fapiaojine1.equals("")){pmap.put("fapiaojine1", null);}else{pmap.put("fapiaojine1", fapiaojine1);}		if(fapiaojine2==null||fapiaojine2.equals("")){pmap.put("fapiaojine2", null);}else{pmap.put("fapiaojine2", fapiaojine2);}		if(jiluren==null||jiluren.equals("")){pmap.put("jiluren", null);}else{pmap.put("jiluren", jiluren);}		
		int total=fapiaoguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fapiaoguanli> list=fapiaoguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fapiaoguanlilisttp";
	}
	
	@RequestMapping("deleteFapiaoguanli.do")
	public String deleteFapiaoguanli(int id,HttpServletRequest request){
		fapiaoguanliService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:fapiaoguanliList.do";
	}
	
	
}
