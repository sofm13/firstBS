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

import com.entity.Shebeishenqing;
import com.server.ShebeishenqingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShebeishenqingController {
	@Resource
	private ShebeishenqingServer shebeishenqingService;


   
	@RequestMapping("addShebeishenqing.do")
	public String addShebeishenqing(HttpServletRequest request,Shebeishenqing shebeishenqing,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shebeishenqing.setAddtime(time.toString().substring(0, 19));
		shebeishenqingService.add(shebeishenqing);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shebeishenqingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shebeishenqingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShebeishenqing.do")
	public String doUpdateShebeishenqing(int id,ModelMap map,Shebeishenqing shebeishenqing){
		shebeishenqing=shebeishenqingService.getById(id);
		map.put("shebeishenqing", shebeishenqing);
		return "shebeishenqing_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shebeishenqingDetail.do")
	public String shebeishenqingDetail(int id,ModelMap map,Shebeishenqing shebeishenqing){
		shebeishenqing=shebeishenqingService.getById(id);
		map.put("shebeishenqing", shebeishenqing);
		return "shebeishenqing_detail";
	}
//	前台详细
	@RequestMapping("sbsqDetail.do")
	public String sbsqDetail(int id,ModelMap map,Shebeishenqing shebeishenqing){
		shebeishenqing=shebeishenqingService.getById(id);
		map.put("shebeishenqing", shebeishenqing);
		return "shebeishenqingdetail";
	}
//	
	@RequestMapping("updateShebeishenqing.do")
	public String updateShebeishenqing(int id,ModelMap map,Shebeishenqing shebeishenqing,HttpServletRequest request,HttpSession session){
		shebeishenqingService.update(shebeishenqing);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shebeishenqingList.do";
	}

//	分页查询
	@RequestMapping("shebeishenqingList.do")
	public String shebeishenqingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeishenqing shebeishenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String jujueyuanyin, String beizhu, String shenqingbumen, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}
		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}
		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}
		if(jujueyuanyin==null||jujueyuanyin.equals("")){pmap.put("jujueyuanyin", null);}else{pmap.put("jujueyuanyin", jujueyuanyin);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		if(shenqingbumen==null||shenqingbumen.equals("")){pmap.put("shenqingbumen", null);}else{pmap.put("shenqingbumen", shenqingbumen);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=shebeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeishenqing> list=shebeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeishenqing_list";
	}
	
	@RequestMapping("shebeishenqingListht.do")
	public String shebeishenqingListht(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeishenqing shebeishenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String jujueyuanyin, String beizhu, String shenqingbumen, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}
		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}
		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}
		if(jujueyuanyin==null||jujueyuanyin.equals("")){pmap.put("jujueyuanyin", null);}else{pmap.put("jujueyuanyin", jujueyuanyin);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		if(shenqingbumen==null||shenqingbumen.equals("")){pmap.put("shenqingbumen", null);}else{pmap.put("shenqingbumen", shenqingbumen);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=shebeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeishenqing> list=shebeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeishenqing_listht";
	}
	
	@RequestMapping("shebeishenqingListfp.do")
	public String shebeishenqingListfp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeishenqing shebeishenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String jujueyuanyin, String beizhu, String shenqingbumen, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}
		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}
		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}
		if(jujueyuanyin==null||jujueyuanyin.equals("")){pmap.put("jujueyuanyin", null);}else{pmap.put("jujueyuanyin", jujueyuanyin);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		if(shenqingbumen==null||shenqingbumen.equals("")){pmap.put("shenqingbumen", null);}else{pmap.put("shenqingbumen", shenqingbumen);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=shebeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeishenqing> list=shebeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeishenqing_listfp";
	}
	
	@RequestMapping("shebeishenqing_yanben1.do")
	public String shebeishenqing_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeishenqing shebeishenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String jujueyuanyin, String beizhu, String shenqingbumen, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}
		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}
		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}
		if(jujueyuanyin==null||jujueyuanyin.equals("")){pmap.put("jujueyuanyin", null);}else{pmap.put("jujueyuanyin", jujueyuanyin);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		if(shenqingbumen==null||shenqingbumen.equals("")){pmap.put("shenqingbumen", null);}else{pmap.put("shenqingbumen", shenqingbumen);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=shebeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeishenqing> list=shebeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeishenqing_yanben1";
	}
	@RequestMapping("shebeishenqing_yanben2.do")
	public String shebeishenqing_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeishenqing shebeishenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String jujueyuanyin, String beizhu, String shenqingbumen, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}
		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}
		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}
		if(jujueyuanyin==null||jujueyuanyin.equals("")){pmap.put("jujueyuanyin", null);}else{pmap.put("jujueyuanyin", jujueyuanyin);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		if(shenqingbumen==null||shenqingbumen.equals("")){pmap.put("shenqingbumen", null);}else{pmap.put("shenqingbumen", shenqingbumen);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=shebeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeishenqing> list=shebeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeishenqing_yanben2";
	}
	@RequestMapping("shebeishenqing_yanben3.do")
	public String shebeishenqing_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeishenqing shebeishenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String jujueyuanyin, String beizhu, String shenqingbumen, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}
		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}
		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}
		if(jujueyuanyin==null||jujueyuanyin.equals("")){pmap.put("jujueyuanyin", null);}else{pmap.put("jujueyuanyin", jujueyuanyin);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		if(shenqingbumen==null||shenqingbumen.equals("")){pmap.put("shenqingbumen", null);}else{pmap.put("shenqingbumen", shenqingbumen);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=shebeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeishenqing> list=shebeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeishenqing_yanben3";
	}
	@RequestMapping("shebeishenqing_yanben4.do")
	public String shebeishenqing_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeishenqing shebeishenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String jujueyuanyin, String beizhu, String shenqingbumen, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}
		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}
		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}
		if(jujueyuanyin==null||jujueyuanyin.equals("")){pmap.put("jujueyuanyin", null);}else{pmap.put("jujueyuanyin", jujueyuanyin);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		if(shenqingbumen==null||shenqingbumen.equals("")){pmap.put("shenqingbumen", null);}else{pmap.put("shenqingbumen", shenqingbumen);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=shebeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeishenqing> list=shebeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeishenqing_yanben4";
	}
	@RequestMapping("shebeishenqing_yanben5.do")
	public String shebeishenqing_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeishenqing shebeishenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String jujueyuanyin, String beizhu, String shenqingbumen, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}
		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}
		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}
		if(jujueyuanyin==null||jujueyuanyin.equals("")){pmap.put("jujueyuanyin", null);}else{pmap.put("jujueyuanyin", jujueyuanyin);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		if(shenqingbumen==null||shenqingbumen.equals("")){pmap.put("shenqingbumen", null);}else{pmap.put("shenqingbumen", shenqingbumen);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=shebeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeishenqing> list=shebeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeishenqing_yanben5";
	}
	
	@RequestMapping("shebeishenqingList2.do")
	public String shebeishenqingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeishenqing shebeishenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String jujueyuanyin, String beizhu, String shenqingbumen, String shenqingren, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("shenqingren", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}
		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}
		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}
		if(jujueyuanyin==null||jujueyuanyin.equals("")){pmap.put("jujueyuanyin", null);}else{pmap.put("jujueyuanyin", jujueyuanyin);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		if(shenqingbumen==null||shenqingbumen.equals("")){pmap.put("shenqingbumen", null);}else{pmap.put("shenqingbumen", shenqingbumen);}
		
		
		int total=shebeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeishenqing> list=shebeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeishenqing_list2";
	}
	
	
	@RequestMapping("sbsqList.do")
	public String sbsqList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeishenqing shebeishenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String jujueyuanyin, String beizhu, String shenqingbumen, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}
		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}
		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}
		if(jujueyuanyin==null||jujueyuanyin.equals("")){pmap.put("jujueyuanyin", null);}else{pmap.put("jujueyuanyin", jujueyuanyin);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		if(shenqingbumen==null||shenqingbumen.equals("")){pmap.put("shenqingbumen", null);}else{pmap.put("shenqingbumen", shenqingbumen);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=shebeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeishenqing> list=shebeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeishenqinglist";
	}
	@RequestMapping("sbsqListtp.do")
	public String sbsqListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shebeishenqing shebeishenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String jujueyuanyin, String beizhu, String shenqingbumen, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}
		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}
		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}
		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}
		if(jujueyuanyin==null||jujueyuanyin.equals("")){pmap.put("jujueyuanyin", null);}else{pmap.put("jujueyuanyin", jujueyuanyin);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		if(shenqingbumen==null||shenqingbumen.equals("")){pmap.put("shenqingbumen", null);}else{pmap.put("shenqingbumen", shenqingbumen);}
		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}
		
		int total=shebeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shebeishenqing> list=shebeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shebeishenqinglisttp";
	}
	
	@RequestMapping("deleteShebeishenqing.do")
	public String deleteShebeishenqing(int id,HttpServletRequest request){
		shebeishenqingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shebeishenqingList.do";
	}
	
	
}
