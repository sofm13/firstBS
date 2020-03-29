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

import com.entity.Jishuxieyi;
import com.server.JishuxieyiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JishuxieyiController {
	@Resource
	private JishuxieyiServer jishuxieyiService;


   
	@RequestMapping("addJishuxieyi.do")
	public String addJishuxieyi(HttpServletRequest request,Jishuxieyi jishuxieyi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jishuxieyi.setAddtime(time.toString().substring(0, 19));
		jishuxieyiService.add(jishuxieyi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jishuxieyiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jishuxieyiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJishuxieyi.do")
	public String doUpdateJishuxieyi(int id,ModelMap map,Jishuxieyi jishuxieyi){
		jishuxieyi=jishuxieyiService.getById(id);
		map.put("jishuxieyi", jishuxieyi);
		return "jishuxieyi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("jishuxieyiDetail.do")
	public String jishuxieyiDetail(int id,ModelMap map,Jishuxieyi jishuxieyi){
		jishuxieyi=jishuxieyiService.getById(id);
		map.put("jishuxieyi", jishuxieyi);
		return "jishuxieyi_detail";
	}
//	前台详细
	@RequestMapping("jsxyDetail.do")
	public String jsxyDetail(int id,ModelMap map,Jishuxieyi jishuxieyi){
		jishuxieyi=jishuxieyiService.getById(id);
		map.put("jishuxieyi", jishuxieyi);
		return "jishuxieyidetail";
	}
//	
	@RequestMapping("updateJishuxieyi.do")
	public String updateJishuxieyi(int id,ModelMap map,Jishuxieyi jishuxieyi,HttpServletRequest request,HttpSession session){
		jishuxieyiService.update(jishuxieyi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jishuxieyiList.do";
	}

//	分页查询
	@RequestMapping("jishuxieyiList.do")
	public String jishuxieyiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jishuxieyi jishuxieyi, String xieyibianhao, String xieyimingcheng, String xieyineirong, String xieyijiafang, String xieyiyifang, String qianyueren, String qiandingriqi1,String qiandingriqi2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xieyibianhao==null||xieyibianhao.equals("")){pmap.put("xieyibianhao", null);}else{pmap.put("xieyibianhao", xieyibianhao);}		if(xieyimingcheng==null||xieyimingcheng.equals("")){pmap.put("xieyimingcheng", null);}else{pmap.put("xieyimingcheng", xieyimingcheng);}		if(xieyineirong==null||xieyineirong.equals("")){pmap.put("xieyineirong", null);}else{pmap.put("xieyineirong", xieyineirong);}		if(xieyijiafang==null||xieyijiafang.equals("")){pmap.put("xieyijiafang", null);}else{pmap.put("xieyijiafang", xieyijiafang);}		if(xieyiyifang==null||xieyiyifang.equals("")){pmap.put("xieyiyifang", null);}else{pmap.put("xieyiyifang", xieyiyifang);}		if(qianyueren==null||qianyueren.equals("")){pmap.put("qianyueren", null);}else{pmap.put("qianyueren", qianyueren);}		if(qiandingriqi1==null||qiandingriqi1.equals("")){pmap.put("qiandingriqi1", null);}else{pmap.put("qiandingriqi1", qiandingriqi1);}		if(qiandingriqi2==null||qiandingriqi2.equals("")){pmap.put("qiandingriqi2", null);}else{pmap.put("qiandingriqi2", qiandingriqi2);}		
		int total=jishuxieyiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jishuxieyi> list=jishuxieyiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jishuxieyi_list";
	}
	
	@RequestMapping("jishuxieyi_yanben1.do")
	public String jishuxieyi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jishuxieyi jishuxieyi, String xieyibianhao, String xieyimingcheng, String xieyineirong, String xieyijiafang, String xieyiyifang, String qianyueren, String qiandingriqi1,String qiandingriqi2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xieyibianhao==null||xieyibianhao.equals("")){pmap.put("xieyibianhao", null);}else{pmap.put("xieyibianhao", xieyibianhao);}		if(xieyimingcheng==null||xieyimingcheng.equals("")){pmap.put("xieyimingcheng", null);}else{pmap.put("xieyimingcheng", xieyimingcheng);}		if(xieyineirong==null||xieyineirong.equals("")){pmap.put("xieyineirong", null);}else{pmap.put("xieyineirong", xieyineirong);}		if(xieyijiafang==null||xieyijiafang.equals("")){pmap.put("xieyijiafang", null);}else{pmap.put("xieyijiafang", xieyijiafang);}		if(xieyiyifang==null||xieyiyifang.equals("")){pmap.put("xieyiyifang", null);}else{pmap.put("xieyiyifang", xieyiyifang);}		if(qianyueren==null||qianyueren.equals("")){pmap.put("qianyueren", null);}else{pmap.put("qianyueren", qianyueren);}		if(qiandingriqi1==null||qiandingriqi1.equals("")){pmap.put("qiandingriqi1", null);}else{pmap.put("qiandingriqi1", qiandingriqi1);}		if(qiandingriqi2==null||qiandingriqi2.equals("")){pmap.put("qiandingriqi2", null);}else{pmap.put("qiandingriqi2", qiandingriqi2);}		
		int total=jishuxieyiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jishuxieyi> list=jishuxieyiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jishuxieyi_yanben1";
	}
	@RequestMapping("jishuxieyi_yanben2.do")
	public String jishuxieyi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jishuxieyi jishuxieyi, String xieyibianhao, String xieyimingcheng, String xieyineirong, String xieyijiafang, String xieyiyifang, String qianyueren, String qiandingriqi1,String qiandingriqi2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xieyibianhao==null||xieyibianhao.equals("")){pmap.put("xieyibianhao", null);}else{pmap.put("xieyibianhao", xieyibianhao);}		if(xieyimingcheng==null||xieyimingcheng.equals("")){pmap.put("xieyimingcheng", null);}else{pmap.put("xieyimingcheng", xieyimingcheng);}		if(xieyineirong==null||xieyineirong.equals("")){pmap.put("xieyineirong", null);}else{pmap.put("xieyineirong", xieyineirong);}		if(xieyijiafang==null||xieyijiafang.equals("")){pmap.put("xieyijiafang", null);}else{pmap.put("xieyijiafang", xieyijiafang);}		if(xieyiyifang==null||xieyiyifang.equals("")){pmap.put("xieyiyifang", null);}else{pmap.put("xieyiyifang", xieyiyifang);}		if(qianyueren==null||qianyueren.equals("")){pmap.put("qianyueren", null);}else{pmap.put("qianyueren", qianyueren);}		if(qiandingriqi1==null||qiandingriqi1.equals("")){pmap.put("qiandingriqi1", null);}else{pmap.put("qiandingriqi1", qiandingriqi1);}		if(qiandingriqi2==null||qiandingriqi2.equals("")){pmap.put("qiandingriqi2", null);}else{pmap.put("qiandingriqi2", qiandingriqi2);}		
		int total=jishuxieyiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jishuxieyi> list=jishuxieyiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jishuxieyi_yanben2";
	}
	@RequestMapping("jishuxieyi_yanben3.do")
	public String jishuxieyi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jishuxieyi jishuxieyi, String xieyibianhao, String xieyimingcheng, String xieyineirong, String xieyijiafang, String xieyiyifang, String qianyueren, String qiandingriqi1,String qiandingriqi2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xieyibianhao==null||xieyibianhao.equals("")){pmap.put("xieyibianhao", null);}else{pmap.put("xieyibianhao", xieyibianhao);}		if(xieyimingcheng==null||xieyimingcheng.equals("")){pmap.put("xieyimingcheng", null);}else{pmap.put("xieyimingcheng", xieyimingcheng);}		if(xieyineirong==null||xieyineirong.equals("")){pmap.put("xieyineirong", null);}else{pmap.put("xieyineirong", xieyineirong);}		if(xieyijiafang==null||xieyijiafang.equals("")){pmap.put("xieyijiafang", null);}else{pmap.put("xieyijiafang", xieyijiafang);}		if(xieyiyifang==null||xieyiyifang.equals("")){pmap.put("xieyiyifang", null);}else{pmap.put("xieyiyifang", xieyiyifang);}		if(qianyueren==null||qianyueren.equals("")){pmap.put("qianyueren", null);}else{pmap.put("qianyueren", qianyueren);}		if(qiandingriqi1==null||qiandingriqi1.equals("")){pmap.put("qiandingriqi1", null);}else{pmap.put("qiandingriqi1", qiandingriqi1);}		if(qiandingriqi2==null||qiandingriqi2.equals("")){pmap.put("qiandingriqi2", null);}else{pmap.put("qiandingriqi2", qiandingriqi2);}		
		int total=jishuxieyiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jishuxieyi> list=jishuxieyiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jishuxieyi_yanben3";
	}
	@RequestMapping("jishuxieyi_yanben4.do")
	public String jishuxieyi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jishuxieyi jishuxieyi, String xieyibianhao, String xieyimingcheng, String xieyineirong, String xieyijiafang, String xieyiyifang, String qianyueren, String qiandingriqi1,String qiandingriqi2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xieyibianhao==null||xieyibianhao.equals("")){pmap.put("xieyibianhao", null);}else{pmap.put("xieyibianhao", xieyibianhao);}		if(xieyimingcheng==null||xieyimingcheng.equals("")){pmap.put("xieyimingcheng", null);}else{pmap.put("xieyimingcheng", xieyimingcheng);}		if(xieyineirong==null||xieyineirong.equals("")){pmap.put("xieyineirong", null);}else{pmap.put("xieyineirong", xieyineirong);}		if(xieyijiafang==null||xieyijiafang.equals("")){pmap.put("xieyijiafang", null);}else{pmap.put("xieyijiafang", xieyijiafang);}		if(xieyiyifang==null||xieyiyifang.equals("")){pmap.put("xieyiyifang", null);}else{pmap.put("xieyiyifang", xieyiyifang);}		if(qianyueren==null||qianyueren.equals("")){pmap.put("qianyueren", null);}else{pmap.put("qianyueren", qianyueren);}		if(qiandingriqi1==null||qiandingriqi1.equals("")){pmap.put("qiandingriqi1", null);}else{pmap.put("qiandingriqi1", qiandingriqi1);}		if(qiandingriqi2==null||qiandingriqi2.equals("")){pmap.put("qiandingriqi2", null);}else{pmap.put("qiandingriqi2", qiandingriqi2);}		
		int total=jishuxieyiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jishuxieyi> list=jishuxieyiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jishuxieyi_yanben4";
	}
	@RequestMapping("jishuxieyi_yanben5.do")
	public String jishuxieyi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jishuxieyi jishuxieyi, String xieyibianhao, String xieyimingcheng, String xieyineirong, String xieyijiafang, String xieyiyifang, String qianyueren, String qiandingriqi1,String qiandingriqi2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xieyibianhao==null||xieyibianhao.equals("")){pmap.put("xieyibianhao", null);}else{pmap.put("xieyibianhao", xieyibianhao);}		if(xieyimingcheng==null||xieyimingcheng.equals("")){pmap.put("xieyimingcheng", null);}else{pmap.put("xieyimingcheng", xieyimingcheng);}		if(xieyineirong==null||xieyineirong.equals("")){pmap.put("xieyineirong", null);}else{pmap.put("xieyineirong", xieyineirong);}		if(xieyijiafang==null||xieyijiafang.equals("")){pmap.put("xieyijiafang", null);}else{pmap.put("xieyijiafang", xieyijiafang);}		if(xieyiyifang==null||xieyiyifang.equals("")){pmap.put("xieyiyifang", null);}else{pmap.put("xieyiyifang", xieyiyifang);}		if(qianyueren==null||qianyueren.equals("")){pmap.put("qianyueren", null);}else{pmap.put("qianyueren", qianyueren);}		if(qiandingriqi1==null||qiandingriqi1.equals("")){pmap.put("qiandingriqi1", null);}else{pmap.put("qiandingriqi1", qiandingriqi1);}		if(qiandingriqi2==null||qiandingriqi2.equals("")){pmap.put("qiandingriqi2", null);}else{pmap.put("qiandingriqi2", qiandingriqi2);}		
		int total=jishuxieyiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jishuxieyi> list=jishuxieyiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jishuxieyi_yanben5";
	}
	
	
	
	@RequestMapping("jsxyList.do")
	public String jsxyList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jishuxieyi jishuxieyi, String xieyibianhao, String xieyimingcheng, String xieyineirong, String xieyijiafang, String xieyiyifang, String qianyueren, String qiandingriqi1,String qiandingriqi2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xieyibianhao==null||xieyibianhao.equals("")){pmap.put("xieyibianhao", null);}else{pmap.put("xieyibianhao", xieyibianhao);}		if(xieyimingcheng==null||xieyimingcheng.equals("")){pmap.put("xieyimingcheng", null);}else{pmap.put("xieyimingcheng", xieyimingcheng);}		if(xieyineirong==null||xieyineirong.equals("")){pmap.put("xieyineirong", null);}else{pmap.put("xieyineirong", xieyineirong);}		if(xieyijiafang==null||xieyijiafang.equals("")){pmap.put("xieyijiafang", null);}else{pmap.put("xieyijiafang", xieyijiafang);}		if(xieyiyifang==null||xieyiyifang.equals("")){pmap.put("xieyiyifang", null);}else{pmap.put("xieyiyifang", xieyiyifang);}		if(qianyueren==null||qianyueren.equals("")){pmap.put("qianyueren", null);}else{pmap.put("qianyueren", qianyueren);}		if(qiandingriqi1==null||qiandingriqi1.equals("")){pmap.put("qiandingriqi1", null);}else{pmap.put("qiandingriqi1", qiandingriqi1);}		if(qiandingriqi2==null||qiandingriqi2.equals("")){pmap.put("qiandingriqi2", null);}else{pmap.put("qiandingriqi2", qiandingriqi2);}		
		int total=jishuxieyiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jishuxieyi> list=jishuxieyiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jishuxieyilist";
	}
	@RequestMapping("jsxyListtp.do")
	public String jsxyListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jishuxieyi jishuxieyi, String xieyibianhao, String xieyimingcheng, String xieyineirong, String xieyijiafang, String xieyiyifang, String qianyueren, String qiandingriqi1,String qiandingriqi2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xieyibianhao==null||xieyibianhao.equals("")){pmap.put("xieyibianhao", null);}else{pmap.put("xieyibianhao", xieyibianhao);}		if(xieyimingcheng==null||xieyimingcheng.equals("")){pmap.put("xieyimingcheng", null);}else{pmap.put("xieyimingcheng", xieyimingcheng);}		if(xieyineirong==null||xieyineirong.equals("")){pmap.put("xieyineirong", null);}else{pmap.put("xieyineirong", xieyineirong);}		if(xieyijiafang==null||xieyijiafang.equals("")){pmap.put("xieyijiafang", null);}else{pmap.put("xieyijiafang", xieyijiafang);}		if(xieyiyifang==null||xieyiyifang.equals("")){pmap.put("xieyiyifang", null);}else{pmap.put("xieyiyifang", xieyiyifang);}		if(qianyueren==null||qianyueren.equals("")){pmap.put("qianyueren", null);}else{pmap.put("qianyueren", qianyueren);}		if(qiandingriqi1==null||qiandingriqi1.equals("")){pmap.put("qiandingriqi1", null);}else{pmap.put("qiandingriqi1", qiandingriqi1);}		if(qiandingriqi2==null||qiandingriqi2.equals("")){pmap.put("qiandingriqi2", null);}else{pmap.put("qiandingriqi2", qiandingriqi2);}		
		int total=jishuxieyiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jishuxieyi> list=jishuxieyiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jishuxieyilisttp";
	}
	
	@RequestMapping("deleteJishuxieyi.do")
	public String deleteJishuxieyi(int id,HttpServletRequest request){
		jishuxieyiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jishuxieyiList.do";
	}
	
	
}
