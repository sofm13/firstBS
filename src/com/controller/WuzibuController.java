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

import com.entity.Wuzibu;
import com.server.WuzibuServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class WuzibuController {
	@Resource
	private WuzibuServer wuzibuService;


   
	@RequestMapping("addWuzibu.do")
	public String addWuzibu(HttpServletRequest request,Wuzibu wuzibu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		wuzibu.setAddtime(time.toString().substring(0, 19));
		wuzibuService.add(wuzibu);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "wuzibuList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:wuzibuList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateWuzibu.do")
	public String doUpdateWuzibu(int id,ModelMap map,Wuzibu wuzibu){
		wuzibu=wuzibuService.getById(id);
		map.put("wuzibu", wuzibu);
		return "wuzibu_updt";
	}
	
	@RequestMapping("doUpdateWuzibu2.do")
	public String doUpdateWuzibu2(ModelMap map,Wuzibu wuzibu,HttpServletRequest request){
		wuzibu=wuzibuService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("wuzibu", wuzibu);
		return "wuzibu_updt2";
	}
	
@RequestMapping("updateWuzibu2.do")
	public String updateWuzibu2(int id,ModelMap map,Wuzibu wuzibu){
		wuzibuService.update(wuzibu);
		return "redirect:doUpdateWuzibu2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("wuzibuDetail.do")
	public String wuzibuDetail(int id,ModelMap map,Wuzibu wuzibu){
		wuzibu=wuzibuService.getById(id);
		map.put("wuzibu", wuzibu);
		return "wuzibu_detail";
	}
//	前台详细
	@RequestMapping("wzbDetail.do")
	public String wzbDetail(int id,ModelMap map,Wuzibu wuzibu){
		wuzibu=wuzibuService.getById(id);
		map.put("wuzibu", wuzibu);
		return "wuzibudetail";
	}
//	
	@RequestMapping("updateWuzibu.do")
	public String updateWuzibu(int id,ModelMap map,Wuzibu wuzibu,HttpServletRequest request,HttpSession session){
		wuzibuService.update(wuzibu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:wuzibuList.do";
	}

//	分页查询
	@RequestMapping("wuzibuList.do")
	public String wuzibuList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuzibu wuzibu, String zhanghao, String mima, String xingming, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=wuzibuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuzibu> list=wuzibuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuzibu_list";
	}
	
	@RequestMapping("wuzibu_yanben1.do")
	public String wuzibu_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuzibu wuzibu, String zhanghao, String mima, String xingming, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=wuzibuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuzibu> list=wuzibuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuzibu_yanben1";
	}
	@RequestMapping("wuzibu_yanben2.do")
	public String wuzibu_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuzibu wuzibu, String zhanghao, String mima, String xingming, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=wuzibuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuzibu> list=wuzibuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuzibu_yanben2";
	}
	@RequestMapping("wuzibu_yanben3.do")
	public String wuzibu_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuzibu wuzibu, String zhanghao, String mima, String xingming, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=wuzibuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuzibu> list=wuzibuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuzibu_yanben3";
	}
	@RequestMapping("wuzibu_yanben4.do")
	public String wuzibu_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuzibu wuzibu, String zhanghao, String mima, String xingming, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=wuzibuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuzibu> list=wuzibuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuzibu_yanben4";
	}
	@RequestMapping("wuzibu_yanben5.do")
	public String wuzibu_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuzibu wuzibu, String zhanghao, String mima, String xingming, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=wuzibuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuzibu> list=wuzibuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuzibu_yanben5";
	}
	
	
	
	@RequestMapping("wzbList.do")
	public String wzbList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuzibu wuzibu, String zhanghao, String mima, String xingming, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=wuzibuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuzibu> list=wuzibuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuzibulist";
	}
	@RequestMapping("wzbListtp.do")
	public String wzbListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuzibu wuzibu, String zhanghao, String mima, String xingming, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=wuzibuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuzibu> list=wuzibuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuzibulisttp";
	}
	
	@RequestMapping("deleteWuzibu.do")
	public String deleteWuzibu(int id,HttpServletRequest request){
		wuzibuService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:wuzibuList.do";
	}
	
	@RequestMapping("quchongWuzibu.do")
	public void quchongWuzibu(Wuzibu wuzibu,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("zhanghao", wuzibu.getZhanghao());
		   System.out.println("zhanghao==="+wuzibu.getZhanghao());
		   System.out.println("zhanghao222==="+wuzibuService.quchongWuzibu(map));
		   JSONObject obj=new JSONObject();
		   if(wuzibuService.quchongWuzibu(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "账号可以用！");
				  
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
