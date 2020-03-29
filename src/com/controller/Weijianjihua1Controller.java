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

import com.entity.Weijianjihua1;
import com.server.Weijianjihua1Server;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class Weijianjihua1Controller {
	@Resource
	private Weijianjihua1Server weijianjihua1Service;


   
	@RequestMapping("addWeijianjihua1.do")
	public String addWeijianjihua1(HttpServletRequest request,Weijianjihua1 weijianjihua1,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		weijianjihua1.setAddtime(time.toString().substring(0, 19));
		weijianjihua1Service.add(weijianjihua1);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "weijianjihuaList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:weijianjihuaList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateWeijianjihua1.do")
	public String doUpdateWeijianjihua1(int id,ModelMap map,Weijianjihua1 weijianjihua1){
		weijianjihua1=weijianjihua1Service.getById(id);
		map.put("weijianjihua", weijianjihua1);
		return "weijianjihua1_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("weijianjihua1Detail.do")
	public String weijianjihua1Detail(int id,ModelMap map,Weijianjihua1 weijianjihua1){
		weijianjihua1=weijianjihua1Service.getById(id);
		map.put("weijianjihua1", weijianjihua1);
		return "weijianjihua_detail";
	}
//	前台详细
	@RequestMapping("wjjh1Detail.do")
	public String wjjh1Detail(int id,ModelMap map,Weijianjihua1 weijianjihua1){
		weijianjihua1=weijianjihua1Service.getById(id);
		map.put("weijianjihua1", weijianjihua1);
		return "weijianjihua1detail";
	}
//	
	@RequestMapping("updateWeijianjihua1.do")
	public String updateWeijianjihua1(int id,ModelMap map,Weijianjihua1 weijianjihua1,HttpServletRequest request,HttpSession session){
		weijianjihua1Service.update(weijianjihua1);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:weijianjihuaList.do";
	}

//	分页查询
	@RequestMapping("weijianjihua1List.do")
	public String weijianjihua1List(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua1 weijianjihua1, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihua1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua1> list=weijianjihua1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua1_list";
	}
	
	@RequestMapping("weijianjihua1_yanben1.do")
	public String weijianjihua1_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua1 weijianjihua1, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihua1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua1> list=weijianjihua1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua1_yanben1";
	}
	@RequestMapping("weijianjihua1_yanben2.do")
	public String weijianjihua1_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua1 weijianjihua1, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihua1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua1> list=weijianjihua1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua1_yanben2";
	}
	@RequestMapping("weijianjihua1_yanben3.do")
	public String weijianjihua1_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua1 weijianjihua1, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihua1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua1> list=weijianjihua1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua_yanben3";
	}
	@RequestMapping("weijianjihua1_yanben4.do")
	public String weijianjihua1_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua1 weijianjihua1, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihua1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua1> list=weijianjihua1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua1_yanben4";
	}
	@RequestMapping("weijianjihua1_yanben5.do")
	public String weijianjihua1_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua1 weijianjihua1, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihua1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua1> list=weijianjihua1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua1_yanben5";
	}
	
	@RequestMapping("weijianjihua1List2.do")
	public String weijianjihua1List2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua1 weijianjihua1, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan,HttpServletRequest request){
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
		
		pmap.put("lururenyuan", (String)request.getSession().getAttribute("username"));
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		
		
		int total=weijianjihua1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua1> list=weijianjihua1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua1_list2";
	}	
	
	@RequestMapping("wjjh1List.do")
	public String wjjh1List(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua1 weijianjihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihua1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua1> list=weijianjihua1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua1list";
	}
	@RequestMapping("wjjh1Listtp.do")
	public String wjjh1Listtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua1 weijianjihua1, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihua1Service.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua1> list=weijianjihua1Service.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua1listtp";
	}
	
	@RequestMapping("deleteWeijianjihua1.do")
	public String deleteWeijianjihua1(int id,HttpServletRequest request){
		weijianjihua1Service.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:weijianjihuaList.do";
	}
	
	
}
