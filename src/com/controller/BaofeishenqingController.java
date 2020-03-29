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

import com.entity.Baofeishenqing;
import com.server.BaofeishenqingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class BaofeishenqingController {
	@Resource
	private BaofeishenqingServer baofeishenqingService;


   
	@RequestMapping("addBaofeishenqing.do")
	public String addBaofeishenqing(HttpServletRequest request,Baofeishenqing baofeishenqing,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		baofeishenqing.setAddtime(time.toString().substring(0, 19));
		baofeishenqingService.add(baofeishenqing);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "baofeishenqingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:baofeishenqingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateBaofeishenqing.do")
	public String doUpdateBaofeishenqing(int id,ModelMap map,Baofeishenqing baofeishenqing){
		baofeishenqing=baofeishenqingService.getById(id);
		map.put("baofeishenqing", baofeishenqing);
		return "baofeishenqing_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("baofeishenqingDetail.do")
	public String baofeishenqingDetail(int id,ModelMap map,Baofeishenqing baofeishenqing){
		baofeishenqing=baofeishenqingService.getById(id);
		map.put("baofeishenqing", baofeishenqing);
		return "baofeishenqing_detail";
	}
//	前台详细
	@RequestMapping("bfsqDetail.do")
	public String bfsqDetail(int id,ModelMap map,Baofeishenqing baofeishenqing){
		baofeishenqing=baofeishenqingService.getById(id);
		map.put("baofeishenqing", baofeishenqing);
		return "baofeishenqingdetail";
	}
//	
	@RequestMapping("updateBaofeishenqing.do")
	public String updateBaofeishenqing(int id,ModelMap map,Baofeishenqing baofeishenqing,HttpServletRequest request,HttpSession session){
		baofeishenqingService.update(baofeishenqing);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:baofeishenqingList.do";
	}

//	分页查询
	@RequestMapping("baofeishenqingList.do")
	public String baofeishenqingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baofeishenqing baofeishenqing, String bianhao, String shebeimingcheng, String baofeiyuanyin, String baofeishuliang1,String baofeishuliang2, String baofeiren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(baofeiyuanyin==null||baofeiyuanyin.equals("")){pmap.put("baofeiyuanyin", null);}else{pmap.put("baofeiyuanyin", baofeiyuanyin);}		if(baofeishuliang1==null||baofeishuliang1.equals("")){pmap.put("baofeishuliang1", null);}else{pmap.put("baofeishuliang1", baofeishuliang1);}		if(baofeishuliang2==null||baofeishuliang2.equals("")){pmap.put("baofeishuliang2", null);}else{pmap.put("baofeishuliang2", baofeishuliang2);}		if(baofeiren==null||baofeiren.equals("")){pmap.put("baofeiren", null);}else{pmap.put("baofeiren", baofeiren);}		
		int total=baofeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baofeishenqing> list=baofeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baofeishenqing_list";
	}
	
	@RequestMapping("baofeishenqing_yanben1.do")
	public String baofeishenqing_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baofeishenqing baofeishenqing, String bianhao, String shebeimingcheng, String baofeiyuanyin, String baofeishuliang1,String baofeishuliang2, String baofeiren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(baofeiyuanyin==null||baofeiyuanyin.equals("")){pmap.put("baofeiyuanyin", null);}else{pmap.put("baofeiyuanyin", baofeiyuanyin);}		if(baofeishuliang1==null||baofeishuliang1.equals("")){pmap.put("baofeishuliang1", null);}else{pmap.put("baofeishuliang1", baofeishuliang1);}		if(baofeishuliang2==null||baofeishuliang2.equals("")){pmap.put("baofeishuliang2", null);}else{pmap.put("baofeishuliang2", baofeishuliang2);}		if(baofeiren==null||baofeiren.equals("")){pmap.put("baofeiren", null);}else{pmap.put("baofeiren", baofeiren);}		
		int total=baofeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baofeishenqing> list=baofeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baofeishenqing_yanben1";
	}
	@RequestMapping("baofeishenqing_yanben2.do")
	public String baofeishenqing_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baofeishenqing baofeishenqing, String bianhao, String shebeimingcheng, String baofeiyuanyin, String baofeishuliang1,String baofeishuliang2, String baofeiren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(baofeiyuanyin==null||baofeiyuanyin.equals("")){pmap.put("baofeiyuanyin", null);}else{pmap.put("baofeiyuanyin", baofeiyuanyin);}		if(baofeishuliang1==null||baofeishuliang1.equals("")){pmap.put("baofeishuliang1", null);}else{pmap.put("baofeishuliang1", baofeishuliang1);}		if(baofeishuliang2==null||baofeishuliang2.equals("")){pmap.put("baofeishuliang2", null);}else{pmap.put("baofeishuliang2", baofeishuliang2);}		if(baofeiren==null||baofeiren.equals("")){pmap.put("baofeiren", null);}else{pmap.put("baofeiren", baofeiren);}		
		int total=baofeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baofeishenqing> list=baofeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baofeishenqing_yanben2";
	}
	@RequestMapping("baofeishenqing_yanben3.do")
	public String baofeishenqing_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baofeishenqing baofeishenqing, String bianhao, String shebeimingcheng, String baofeiyuanyin, String baofeishuliang1,String baofeishuliang2, String baofeiren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(baofeiyuanyin==null||baofeiyuanyin.equals("")){pmap.put("baofeiyuanyin", null);}else{pmap.put("baofeiyuanyin", baofeiyuanyin);}		if(baofeishuliang1==null||baofeishuliang1.equals("")){pmap.put("baofeishuliang1", null);}else{pmap.put("baofeishuliang1", baofeishuliang1);}		if(baofeishuliang2==null||baofeishuliang2.equals("")){pmap.put("baofeishuliang2", null);}else{pmap.put("baofeishuliang2", baofeishuliang2);}		if(baofeiren==null||baofeiren.equals("")){pmap.put("baofeiren", null);}else{pmap.put("baofeiren", baofeiren);}		
		int total=baofeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baofeishenqing> list=baofeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baofeishenqing_yanben3";
	}
	@RequestMapping("baofeishenqing_yanben4.do")
	public String baofeishenqing_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baofeishenqing baofeishenqing, String bianhao, String shebeimingcheng, String baofeiyuanyin, String baofeishuliang1,String baofeishuliang2, String baofeiren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(baofeiyuanyin==null||baofeiyuanyin.equals("")){pmap.put("baofeiyuanyin", null);}else{pmap.put("baofeiyuanyin", baofeiyuanyin);}		if(baofeishuliang1==null||baofeishuliang1.equals("")){pmap.put("baofeishuliang1", null);}else{pmap.put("baofeishuliang1", baofeishuliang1);}		if(baofeishuliang2==null||baofeishuliang2.equals("")){pmap.put("baofeishuliang2", null);}else{pmap.put("baofeishuliang2", baofeishuliang2);}		if(baofeiren==null||baofeiren.equals("")){pmap.put("baofeiren", null);}else{pmap.put("baofeiren", baofeiren);}		
		int total=baofeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baofeishenqing> list=baofeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baofeishenqing_yanben4";
	}
	@RequestMapping("baofeishenqing_yanben5.do")
	public String baofeishenqing_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baofeishenqing baofeishenqing, String bianhao, String shebeimingcheng, String baofeiyuanyin, String baofeishuliang1,String baofeishuliang2, String baofeiren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(baofeiyuanyin==null||baofeiyuanyin.equals("")){pmap.put("baofeiyuanyin", null);}else{pmap.put("baofeiyuanyin", baofeiyuanyin);}		if(baofeishuliang1==null||baofeishuliang1.equals("")){pmap.put("baofeishuliang1", null);}else{pmap.put("baofeishuliang1", baofeishuliang1);}		if(baofeishuliang2==null||baofeishuliang2.equals("")){pmap.put("baofeishuliang2", null);}else{pmap.put("baofeishuliang2", baofeishuliang2);}		if(baofeiren==null||baofeiren.equals("")){pmap.put("baofeiren", null);}else{pmap.put("baofeiren", baofeiren);}		
		int total=baofeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baofeishenqing> list=baofeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baofeishenqing_yanben5";
	}
	
	@RequestMapping("baofeishenqingList2.do")
	public String baofeishenqingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baofeishenqing baofeishenqing, String bianhao, String shebeimingcheng, String baofeiyuanyin, String baofeishuliang1,String baofeishuliang2, String baofeiren, String issh,HttpServletRequest request){
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
		
		pmap.put("baofeiren", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(baofeiyuanyin==null||baofeiyuanyin.equals("")){pmap.put("baofeiyuanyin", null);}else{pmap.put("baofeiyuanyin", baofeiyuanyin);}		if(baofeishuliang1==null||baofeishuliang1.equals("")){pmap.put("baofeishuliang1", null);}else{pmap.put("baofeishuliang1", baofeishuliang1);}		if(baofeishuliang2==null||baofeishuliang2.equals("")){pmap.put("baofeishuliang2", null);}else{pmap.put("baofeishuliang2", baofeishuliang2);}		
		
		int total=baofeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baofeishenqing> list=baofeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baofeishenqing_list2";
	}	
	
	@RequestMapping("bfsqList.do")
	public String bfsqList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baofeishenqing baofeishenqing, String bianhao, String shebeimingcheng, String baofeiyuanyin, String baofeishuliang1,String baofeishuliang2, String baofeiren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(baofeiyuanyin==null||baofeiyuanyin.equals("")){pmap.put("baofeiyuanyin", null);}else{pmap.put("baofeiyuanyin", baofeiyuanyin);}		if(baofeishuliang1==null||baofeishuliang1.equals("")){pmap.put("baofeishuliang1", null);}else{pmap.put("baofeishuliang1", baofeishuliang1);}		if(baofeishuliang2==null||baofeishuliang2.equals("")){pmap.put("baofeishuliang2", null);}else{pmap.put("baofeishuliang2", baofeishuliang2);}		if(baofeiren==null||baofeiren.equals("")){pmap.put("baofeiren", null);}else{pmap.put("baofeiren", baofeiren);}		
		int total=baofeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baofeishenqing> list=baofeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baofeishenqinglist";
	}
	@RequestMapping("bfsqListtp.do")
	public String bfsqListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baofeishenqing baofeishenqing, String bianhao, String shebeimingcheng, String baofeiyuanyin, String baofeishuliang1,String baofeishuliang2, String baofeiren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(baofeiyuanyin==null||baofeiyuanyin.equals("")){pmap.put("baofeiyuanyin", null);}else{pmap.put("baofeiyuanyin", baofeiyuanyin);}		if(baofeishuliang1==null||baofeishuliang1.equals("")){pmap.put("baofeishuliang1", null);}else{pmap.put("baofeishuliang1", baofeishuliang1);}		if(baofeishuliang2==null||baofeishuliang2.equals("")){pmap.put("baofeishuliang2", null);}else{pmap.put("baofeishuliang2", baofeishuliang2);}		if(baofeiren==null||baofeiren.equals("")){pmap.put("baofeiren", null);}else{pmap.put("baofeiren", baofeiren);}		
		int total=baofeishenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baofeishenqing> list=baofeishenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baofeishenqinglisttp";
	}
	
	@RequestMapping("deleteBaofeishenqing.do")
	public String deleteBaofeishenqing(int id,HttpServletRequest request){
		baofeishenqingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:baofeishenqingList.do";
	}
	
	
}
