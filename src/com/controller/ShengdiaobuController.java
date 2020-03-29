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

import com.entity.Shengdiaobu;
import com.server.ShengdiaobuServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShengdiaobuController {
	@Resource
	private ShengdiaobuServer shengdiaobuService;


   
	@RequestMapping("addShengdiaobu.do")
	public String addShengdiaobu(HttpServletRequest request,Shengdiaobu shengdiaobu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shengdiaobu.setAddtime(time.toString().substring(0, 19));
		shengdiaobuService.add(shengdiaobu);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shengdiaobuList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shengdiaobuList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShengdiaobu.do")
	public String doUpdateShengdiaobu(int id,ModelMap map,Shengdiaobu shengdiaobu){
		shengdiaobu=shengdiaobuService.getById(id);
		map.put("shengdiaobu", shengdiaobu);
		return "shengdiaobu_updt";
	}
	
	@RequestMapping("doUpdateShengdiaobu2.do")
	public String doUpdateShengdiaobu2(ModelMap map,Shengdiaobu shengdiaobu,HttpServletRequest request){
		shengdiaobu=shengdiaobuService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("shengdiaobu", shengdiaobu);
		return "shengdiaobu_updt2";
	}
	
@RequestMapping("updateShengdiaobu2.do")
	public String updateShengdiaobu2(int id,ModelMap map,Shengdiaobu shengdiaobu){
		shengdiaobuService.update(shengdiaobu);
		return "redirect:doUpdateShengdiaobu2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("shengdiaobuDetail.do")
	public String shengdiaobuDetail(int id,ModelMap map,Shengdiaobu shengdiaobu){
		shengdiaobu=shengdiaobuService.getById(id);
		map.put("shengdiaobu", shengdiaobu);
		return "shengdiaobu_detail";
	}
//	前台详细
	@RequestMapping("sdbDetail.do")
	public String sdbDetail(int id,ModelMap map,Shengdiaobu shengdiaobu){
		shengdiaobu=shengdiaobuService.getById(id);
		map.put("shengdiaobu", shengdiaobu);
		return "shengdiaobudetail";
	}
//	
	@RequestMapping("updateShengdiaobu.do")
	public String updateShengdiaobu(int id,ModelMap map,Shengdiaobu shengdiaobu,HttpServletRequest request,HttpSession session){
		shengdiaobuService.update(shengdiaobu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shengdiaobuList.do";
	}

//	分页查询
	@RequestMapping("shengdiaobuList.do")
	public String shengdiaobuList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shengdiaobu shengdiaobu, String zhanghao, String mima, String xingming, String xingbie, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=shengdiaobuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shengdiaobu> list=shengdiaobuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shengdiaobu_list";
	}
	
	@RequestMapping("shengdiaobu_yanben1.do")
	public String shengdiaobu_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shengdiaobu shengdiaobu, String zhanghao, String mima, String xingming, String xingbie, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=shengdiaobuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shengdiaobu> list=shengdiaobuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shengdiaobu_yanben1";
	}
	@RequestMapping("shengdiaobu_yanben2.do")
	public String shengdiaobu_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shengdiaobu shengdiaobu, String zhanghao, String mima, String xingming, String xingbie, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=shengdiaobuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shengdiaobu> list=shengdiaobuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shengdiaobu_yanben2";
	}
	@RequestMapping("shengdiaobu_yanben3.do")
	public String shengdiaobu_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shengdiaobu shengdiaobu, String zhanghao, String mima, String xingming, String xingbie, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=shengdiaobuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shengdiaobu> list=shengdiaobuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shengdiaobu_yanben3";
	}
	@RequestMapping("shengdiaobu_yanben4.do")
	public String shengdiaobu_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shengdiaobu shengdiaobu, String zhanghao, String mima, String xingming, String xingbie, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=shengdiaobuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shengdiaobu> list=shengdiaobuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shengdiaobu_yanben4";
	}
	@RequestMapping("shengdiaobu_yanben5.do")
	public String shengdiaobu_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shengdiaobu shengdiaobu, String zhanghao, String mima, String xingming, String xingbie, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=shengdiaobuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shengdiaobu> list=shengdiaobuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shengdiaobu_yanben5";
	}
	
	
	
	@RequestMapping("sdbList.do")
	public String sdbList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shengdiaobu shengdiaobu, String zhanghao, String mima, String xingming, String xingbie, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=shengdiaobuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shengdiaobu> list=shengdiaobuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shengdiaobulist";
	}
	@RequestMapping("sdbListtp.do")
	public String sdbListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shengdiaobu shengdiaobu, String zhanghao, String mima, String xingming, String xingbie, String bumenmingcheng, String gangwei, String lianxidianhua, String shouji, String jiatingdizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(bumenmingcheng==null||bumenmingcheng.equals("")){pmap.put("bumenmingcheng", null);}else{pmap.put("bumenmingcheng", bumenmingcheng);}		if(gangwei==null||gangwei.equals("")){pmap.put("gangwei", null);}else{pmap.put("gangwei", gangwei);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(jiatingdizhi==null||jiatingdizhi.equals("")){pmap.put("jiatingdizhi", null);}else{pmap.put("jiatingdizhi", jiatingdizhi);}		
		int total=shengdiaobuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shengdiaobu> list=shengdiaobuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shengdiaobulisttp";
	}
	
	@RequestMapping("deleteShengdiaobu.do")
	public String deleteShengdiaobu(int id,HttpServletRequest request){
		shengdiaobuService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shengdiaobuList.do";
	}
	
	@RequestMapping("quchongShengdiaobu.do")
	public void quchongShengdiaobu(Shengdiaobu shengdiaobu,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("zhanghao", shengdiaobu.getZhanghao());
		   System.out.println("zhanghao==="+shengdiaobu.getZhanghao());
		   System.out.println("zhanghao222==="+shengdiaobuService.quchongShengdiaobu(map));
		   JSONObject obj=new JSONObject();
		   if(shengdiaobuService.quchongShengdiaobu(map)!=null){
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
