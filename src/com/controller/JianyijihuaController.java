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

import com.entity.Jianyijihua;
import com.server.JianyijihuaServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JianyijihuaController {
	@Resource
	private JianyijihuaServer jianyijihuaService;


   
	@RequestMapping("addJianyijihua.do")
	public String addJianyijihua(HttpServletRequest request,Jianyijihua jianyijihua,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jianyijihua.setAddtime(time.toString().substring(0, 19));
		jianyijihuaService.add(jianyijihua);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jianyijihuaList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jianyijihuaList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJianyijihua.do")
	public String doUpdateJianyijihua(int id,ModelMap map,Jianyijihua jianyijihua){
		jianyijihua=jianyijihuaService.getById(id);
		map.put("jianyijihua", jianyijihua);
		return "jianyijihua_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("jianyijihuaDetail.do")
	public String jianyijihuaDetail(int id,ModelMap map,Jianyijihua jianyijihua){
		jianyijihua=jianyijihuaService.getById(id);
		map.put("jianyijihua", jianyijihua);
		return "jianyijihua_detail";
	}
//	前台详细
	@RequestMapping("jyjhDetail.do")
	public String jyjhDetail(int id,ModelMap map,Jianyijihua jianyijihua){
		jianyijihua=jianyijihuaService.getById(id);
		map.put("jianyijihua", jianyijihua);
		return "jianyijihuadetail";
	}
//	
	@RequestMapping("updateJianyijihua.do")
	public String updateJianyijihua(int id,ModelMap map,Jianyijihua jianyijihua,HttpServletRequest request,HttpSession session){
		jianyijihuaService.update(jianyijihua);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jianyijihuaList.do";
	}

//	分页查询
	@RequestMapping("jianyijihuaList.do")
	public String jianyijihuaList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianyijihua jianyijihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=jianyijihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianyijihua> list=jianyijihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianyijihua_list";
	}
	
	@RequestMapping("jianyijihua_yanben1.do")
	public String jianyijihua_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianyijihua jianyijihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=jianyijihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianyijihua> list=jianyijihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianyijihua_yanben1";
	}
	@RequestMapping("jianyijihua_yanben2.do")
	public String jianyijihua_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianyijihua jianyijihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=jianyijihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianyijihua> list=jianyijihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianyijihua_yanben2";
	}
	@RequestMapping("jianyijihua_yanben3.do")
	public String jianyijihua_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianyijihua jianyijihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=jianyijihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianyijihua> list=jianyijihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianyijihua_yanben3";
	}
	@RequestMapping("jianyijihua_yanben4.do")
	public String jianyijihua_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianyijihua jianyijihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=jianyijihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianyijihua> list=jianyijihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianyijihua_yanben4";
	}
	@RequestMapping("jianyijihua_yanben5.do")
	public String jianyijihua_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianyijihua jianyijihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=jianyijihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianyijihua> list=jianyijihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianyijihua_yanben5";
	}
	
	@RequestMapping("jianyijihuaList2.do")
	public String jianyijihuaList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianyijihua jianyijihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan,HttpServletRequest request){
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
		
		int total=jianyijihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianyijihua> list=jianyijihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianyijihua_list2";
	}	
	
	@RequestMapping("jyjhList.do")
	public String jyjhList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianyijihua jianyijihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=jianyijihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianyijihua> list=jianyijihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianyijihualist";
	}
	@RequestMapping("jyjhListtp.do")
	public String jyjhListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianyijihua jianyijihua, String jihuamingcheng, String jihuamiaoshu, String lurushijian1,String lurushijian2, String lururenyuan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jihuamingcheng==null||jihuamingcheng.equals("")){pmap.put("jihuamingcheng", null);}else{pmap.put("jihuamingcheng", jihuamingcheng);}		if(jihuamiaoshu==null||jihuamiaoshu.equals("")){pmap.put("jihuamiaoshu", null);}else{pmap.put("jihuamiaoshu", jihuamiaoshu);}		if(lurushijian1==null||lurushijian1.equals("")){pmap.put("lurushijian1", null);}else{pmap.put("lurushijian1", lurushijian1);}		if(lurushijian2==null||lurushijian2.equals("")){pmap.put("lurushijian2", null);}else{pmap.put("lurushijian2", lurushijian2);}		if(lururenyuan==null||lururenyuan.equals("")){pmap.put("lururenyuan", null);}else{pmap.put("lururenyuan", lururenyuan);}		
		int total=jianyijihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianyijihua> list=jianyijihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianyijihualisttp";
	}
	
	@RequestMapping("deleteJianyijihua.do")
	public String deleteJianyijihua(int id,HttpServletRequest request){
		jianyijihuaService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jianyijihuaList.do";
	}
	
	
}
