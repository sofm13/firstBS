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

import com.entity.Chukushenqing;
import com.server.ChukushenqingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ChukushenqingController {
	@Resource
	private ChukushenqingServer chukushenqingService;


   
	@RequestMapping("addChukushenqing.do")
	public String addChukushenqing(HttpServletRequest request,Chukushenqing chukushenqing,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		chukushenqing.setAddtime(time.toString().substring(0, 19));
		chukushenqingService.add(chukushenqing);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "chukushenqingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:chukushenqingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateChukushenqing.do")
	public String doUpdateChukushenqing(int id,ModelMap map,Chukushenqing chukushenqing){
		chukushenqing=chukushenqingService.getById(id);
		map.put("chukushenqing", chukushenqing);
		return "chukushenqing_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("chukushenqingDetail.do")
	public String chukushenqingDetail(int id,ModelMap map,Chukushenqing chukushenqing){
		chukushenqing=chukushenqingService.getById(id);
		map.put("chukushenqing", chukushenqing);
		return "chukushenqing_detail";
	}
//	前台详细
	@RequestMapping("cksqDetail.do")
	public String cksqDetail(int id,ModelMap map,Chukushenqing chukushenqing){
		chukushenqing=chukushenqingService.getById(id);
		map.put("chukushenqing", chukushenqing);
		return "chukushenqingdetail";
	}
//	
	@RequestMapping("updateChukushenqing.do")
	public String updateChukushenqing(int id,ModelMap map,Chukushenqing chukushenqing,HttpServletRequest request,HttpSession session){
		chukushenqingService.update(chukushenqing);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:chukushenqingList.do";
	}

//	分页查询
	@RequestMapping("chukushenqingList.do")
	public String chukushenqingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukushenqing chukushenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		
		int total=chukushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukushenqing> list=chukushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukushenqing_list";
	}
	
	@RequestMapping("chukushenqing_yanben1.do")
	public String chukushenqing_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukushenqing chukushenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		
		int total=chukushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukushenqing> list=chukushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukushenqing_yanben1";
	}
	@RequestMapping("chukushenqing_yanben2.do")
	public String chukushenqing_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukushenqing chukushenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		
		int total=chukushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukushenqing> list=chukushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukushenqing_yanben2";
	}
	@RequestMapping("chukushenqing_yanben3.do")
	public String chukushenqing_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukushenqing chukushenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		
		int total=chukushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukushenqing> list=chukushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukushenqing_yanben3";
	}
	@RequestMapping("chukushenqing_yanben4.do")
	public String chukushenqing_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukushenqing chukushenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		
		int total=chukushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukushenqing> list=chukushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukushenqing_yanben4";
	}
	@RequestMapping("chukushenqing_yanben5.do")
	public String chukushenqing_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukushenqing chukushenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		
		int total=chukushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukushenqing> list=chukushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukushenqing_yanben5";
	}
	
	@RequestMapping("chukushenqingList2.do")
	public String chukushenqingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukushenqing chukushenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String shenqingren, String issh,HttpServletRequest request){
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
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}		
		
		int total=chukushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukushenqing> list=chukushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukushenqing_list2";
	}	
	
	@RequestMapping("cksqList.do")
	public String cksqList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukushenqing chukushenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		
		int total=chukushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukushenqing> list=chukushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukushenqinglist";
	}
	@RequestMapping("cksqListtp.do")
	public String cksqListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukushenqing chukushenqing, String bianhao, String shebeimingcheng, String shenqingshuliang1,String shenqingshuliang2, String shenqingyuanyin, String shenqingren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		if(shenqingyuanyin==null||shenqingyuanyin.equals("")){pmap.put("shenqingyuanyin", null);}else{pmap.put("shenqingyuanyin", shenqingyuanyin);}		if(shenqingren==null||shenqingren.equals("")){pmap.put("shenqingren", null);}else{pmap.put("shenqingren", shenqingren);}		
		int total=chukushenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukushenqing> list=chukushenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukushenqinglisttp";
	}
	
	@RequestMapping("deleteChukushenqing.do")
	public String deleteChukushenqing(int id,HttpServletRequest request){
		chukushenqingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:chukushenqingList.do";
	}
	
	
}
