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

import com.entity.Weijianjihua;
import com.server.WeijianjihuaServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class WeijianjihuaController {
	@Resource
	private WeijianjihuaServer weijianjihuaService;


   
	@RequestMapping("addWeijianjihua.do")
	public String addWeijianjihua(HttpServletRequest request,Weijianjihua weijianjihua,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		weijianjihua.setAddtime(time.toString().substring(0, 19));
		weijianjihuaService.add(weijianjihua);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "weijianjihuaList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:weijianjihuaList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateWeijianjihua.do")
	public String doUpdateWeijianjihua(int id,ModelMap map,Weijianjihua weijianjihua){
		weijianjihua=weijianjihuaService.getById(id);
		map.put("weijianjihua", weijianjihua);
		return "weijianjihua_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("weijianjihuaDetail.do")
	public String weijianjihuaDetail(int id,ModelMap map,Weijianjihua weijianjihua){
		weijianjihua=weijianjihuaService.getById(id);
		map.put("weijianjihua", weijianjihua);
		return "weijianjihua_detail";
	}
//	前台详细
	@RequestMapping("wjjhDetail.do")
	public String wjjhDetail(int id,ModelMap map,Weijianjihua weijianjihua){
		weijianjihua=weijianjihuaService.getById(id);
		map.put("weijianjihua", weijianjihua);
		return "weijianjihuadetail";
	}
//	
	@RequestMapping("updateWeijianjihua.do")
	public String updateWeijianjihua(int id,ModelMap map,Weijianjihua weijianjihua,HttpServletRequest request,HttpSession session){
		weijianjihuaService.update(weijianjihua);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:weijianjihuaList.do";
	}

//	分页查询
	@RequestMapping("weijianjihuaList.do")
	public String weijianjihuaList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua weijianjihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua> list=weijianjihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua_list";
	}
	
	@RequestMapping("weijianjihua_yanben1.do")
	public String weijianjihua_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua weijianjihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua> list=weijianjihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua_yanben1";
	}
	@RequestMapping("weijianjihua_yanben2.do")
	public String weijianjihua_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua weijianjihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua> list=weijianjihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua_yanben2";
	}
	@RequestMapping("weijianjihua_yanben3.do")
	public String weijianjihua_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua weijianjihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua> list=weijianjihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua_yanben3";
	}
	@RequestMapping("weijianjihua_yanben4.do")
	public String weijianjihua_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua weijianjihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua> list=weijianjihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua_yanben4";
	}
	@RequestMapping("weijianjihua_yanben5.do")
	public String weijianjihua_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua weijianjihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua> list=weijianjihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua_yanben5";
	}
	
	@RequestMapping("weijianjihuaList2.do")
	public String weijianjihuaList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua weijianjihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan,HttpServletRequest request){
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
		
		int total=weijianjihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua> list=weijianjihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihua_list2";
	}	
	
	@RequestMapping("wjjhList.do")
	public String wjjhList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua weijianjihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua> list=weijianjihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihualist";
	}
	@RequestMapping("wjjhListtp.do")
	public String wjjhListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weijianjihua weijianjihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=weijianjihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weijianjihua> list=weijianjihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weijianjihualisttp";
	}
	
	@RequestMapping("deleteWeijianjihua.do")
	public String deleteWeijianjihua(int id,HttpServletRequest request){
		weijianjihuaService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:weijianjihuaList.do";
	}
	
	
}
