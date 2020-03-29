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

import com.entity.Weixiubaogao;
import com.server.WeixiubaogaoServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class WeixiubaogaoController {
	@Resource
	private WeixiubaogaoServer weixiubaogaoService;


   
	@RequestMapping("addWeixiubaogao.do")
	public String addWeixiubaogao(HttpServletRequest request,Weixiubaogao weixiubaogao,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		weixiubaogao.setAddtime(time.toString().substring(0, 19));
		weixiubaogaoService.add(weixiubaogao);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "weixiubaogaoList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:weixiubaogaoList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateWeixiubaogao.do")
	public String doUpdateWeixiubaogao(int id,ModelMap map,Weixiubaogao weixiubaogao){
		weixiubaogao=weixiubaogaoService.getById(id);
		map.put("weixiubaogao", weixiubaogao);
		return "weixiubaogao_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("weixiubaogaoDetail.do")
	public String weixiubaogaoDetail(int id,ModelMap map,Weixiubaogao weixiubaogao){
		weixiubaogao=weixiubaogaoService.getById(id);
		map.put("weixiubaogao", weixiubaogao);
		return "weixiubaogao_detail";
	}
//	前台详细
	@RequestMapping("wxbgDetail.do")
	public String wxbgDetail(int id,ModelMap map,Weixiubaogao weixiubaogao){
		weixiubaogao=weixiubaogaoService.getById(id);
		map.put("weixiubaogao", weixiubaogao);
		return "weixiubaogaodetail";
	}
//	
	@RequestMapping("updateWeixiubaogao.do")
	public String updateWeixiubaogao(int id,ModelMap map,Weixiubaogao weixiubaogao,HttpServletRequest request,HttpSession session){
		weixiubaogaoService.update(weixiubaogao);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:weixiubaogaoList.do";
	}

//	分页查询
	@RequestMapping("weixiubaogaoList.do")
	public String weixiubaogaoList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiubaogao weixiubaogao, String bianhao, String shebeimingcheng, String qingkuangjianshu, String weixiuyuanyin, String weixiujieguo, String weixiuren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}		if(weixiuyuanyin==null||weixiuyuanyin.equals("")){pmap.put("weixiuyuanyin", null);}else{pmap.put("weixiuyuanyin", weixiuyuanyin);}		if(weixiujieguo==null||weixiujieguo.equals("")){pmap.put("weixiujieguo", null);}else{pmap.put("weixiujieguo", weixiujieguo);}		if(weixiuren==null||weixiuren.equals("")){pmap.put("weixiuren", null);}else{pmap.put("weixiuren", weixiuren);}		
		int total=weixiubaogaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiubaogao> list=weixiubaogaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiubaogao_list";
	}
	
	@RequestMapping("weixiubaogao_yanben1.do")
	public String weixiubaogao_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiubaogao weixiubaogao, String bianhao, String shebeimingcheng, String qingkuangjianshu, String weixiuyuanyin, String weixiujieguo, String weixiuren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}		if(weixiuyuanyin==null||weixiuyuanyin.equals("")){pmap.put("weixiuyuanyin", null);}else{pmap.put("weixiuyuanyin", weixiuyuanyin);}		if(weixiujieguo==null||weixiujieguo.equals("")){pmap.put("weixiujieguo", null);}else{pmap.put("weixiujieguo", weixiujieguo);}		if(weixiuren==null||weixiuren.equals("")){pmap.put("weixiuren", null);}else{pmap.put("weixiuren", weixiuren);}		
		int total=weixiubaogaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiubaogao> list=weixiubaogaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiubaogao_yanben1";
	}
	@RequestMapping("weixiubaogao_yanben2.do")
	public String weixiubaogao_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiubaogao weixiubaogao, String bianhao, String shebeimingcheng, String qingkuangjianshu, String weixiuyuanyin, String weixiujieguo, String weixiuren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}		if(weixiuyuanyin==null||weixiuyuanyin.equals("")){pmap.put("weixiuyuanyin", null);}else{pmap.put("weixiuyuanyin", weixiuyuanyin);}		if(weixiujieguo==null||weixiujieguo.equals("")){pmap.put("weixiujieguo", null);}else{pmap.put("weixiujieguo", weixiujieguo);}		if(weixiuren==null||weixiuren.equals("")){pmap.put("weixiuren", null);}else{pmap.put("weixiuren", weixiuren);}		
		int total=weixiubaogaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiubaogao> list=weixiubaogaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiubaogao_yanben2";
	}
	@RequestMapping("weixiubaogao_yanben3.do")
	public String weixiubaogao_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiubaogao weixiubaogao, String bianhao, String shebeimingcheng, String qingkuangjianshu, String weixiuyuanyin, String weixiujieguo, String weixiuren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}		if(weixiuyuanyin==null||weixiuyuanyin.equals("")){pmap.put("weixiuyuanyin", null);}else{pmap.put("weixiuyuanyin", weixiuyuanyin);}		if(weixiujieguo==null||weixiujieguo.equals("")){pmap.put("weixiujieguo", null);}else{pmap.put("weixiujieguo", weixiujieguo);}		if(weixiuren==null||weixiuren.equals("")){pmap.put("weixiuren", null);}else{pmap.put("weixiuren", weixiuren);}		
		int total=weixiubaogaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiubaogao> list=weixiubaogaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiubaogao_yanben3";
	}
	@RequestMapping("weixiubaogao_yanben4.do")
	public String weixiubaogao_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiubaogao weixiubaogao, String bianhao, String shebeimingcheng, String qingkuangjianshu, String weixiuyuanyin, String weixiujieguo, String weixiuren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}		if(weixiuyuanyin==null||weixiuyuanyin.equals("")){pmap.put("weixiuyuanyin", null);}else{pmap.put("weixiuyuanyin", weixiuyuanyin);}		if(weixiujieguo==null||weixiujieguo.equals("")){pmap.put("weixiujieguo", null);}else{pmap.put("weixiujieguo", weixiujieguo);}		if(weixiuren==null||weixiuren.equals("")){pmap.put("weixiuren", null);}else{pmap.put("weixiuren", weixiuren);}		
		int total=weixiubaogaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiubaogao> list=weixiubaogaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiubaogao_yanben4";
	}
	@RequestMapping("weixiubaogao_yanben5.do")
	public String weixiubaogao_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiubaogao weixiubaogao, String bianhao, String shebeimingcheng, String qingkuangjianshu, String weixiuyuanyin, String weixiujieguo, String weixiuren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}		if(weixiuyuanyin==null||weixiuyuanyin.equals("")){pmap.put("weixiuyuanyin", null);}else{pmap.put("weixiuyuanyin", weixiuyuanyin);}		if(weixiujieguo==null||weixiujieguo.equals("")){pmap.put("weixiujieguo", null);}else{pmap.put("weixiujieguo", weixiujieguo);}		if(weixiuren==null||weixiuren.equals("")){pmap.put("weixiuren", null);}else{pmap.put("weixiuren", weixiuren);}		
		int total=weixiubaogaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiubaogao> list=weixiubaogaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiubaogao_yanben5";
	}
	
	
	
	@RequestMapping("wxbgList.do")
	public String wxbgList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiubaogao weixiubaogao, String bianhao, String shebeimingcheng, String qingkuangjianshu, String weixiuyuanyin, String weixiujieguo, String weixiuren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}		if(weixiuyuanyin==null||weixiuyuanyin.equals("")){pmap.put("weixiuyuanyin", null);}else{pmap.put("weixiuyuanyin", weixiuyuanyin);}		if(weixiujieguo==null||weixiujieguo.equals("")){pmap.put("weixiujieguo", null);}else{pmap.put("weixiujieguo", weixiujieguo);}		if(weixiuren==null||weixiuren.equals("")){pmap.put("weixiuren", null);}else{pmap.put("weixiuren", weixiuren);}		
		int total=weixiubaogaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiubaogao> list=weixiubaogaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiubaogaolist";
	}
	@RequestMapping("wxbgListtp.do")
	public String wxbgListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Weixiubaogao weixiubaogao, String bianhao, String shebeimingcheng, String qingkuangjianshu, String weixiuyuanyin, String weixiujieguo, String weixiuren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(qingkuangjianshu==null||qingkuangjianshu.equals("")){pmap.put("qingkuangjianshu", null);}else{pmap.put("qingkuangjianshu", qingkuangjianshu);}		if(weixiuyuanyin==null||weixiuyuanyin.equals("")){pmap.put("weixiuyuanyin", null);}else{pmap.put("weixiuyuanyin", weixiuyuanyin);}		if(weixiujieguo==null||weixiujieguo.equals("")){pmap.put("weixiujieguo", null);}else{pmap.put("weixiujieguo", weixiujieguo);}		if(weixiuren==null||weixiuren.equals("")){pmap.put("weixiuren", null);}else{pmap.put("weixiuren", weixiuren);}		
		int total=weixiubaogaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Weixiubaogao> list=weixiubaogaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "weixiubaogaolisttp";
	}
	
	@RequestMapping("deleteWeixiubaogao.do")
	public String deleteWeixiubaogao(int id,HttpServletRequest request){
		weixiubaogaoService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:weixiubaogaoList.do";
	}
	
	@RequestMapping("quchongWeixiubaogao.do")
	public void quchongWeixiubaogao(Weixiubaogao weixiubaogao,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("weixiuyuanyin", weixiubaogao.getWeixiuyuanyin());
		   System.out.println("weixiuyuanyin==="+weixiubaogao.getWeixiuyuanyin());
		   System.out.println("weixiuyuanyin222==="+weixiubaogaoService.quchongWeixiubaogao(map));
		   JSONObject obj=new JSONObject();
		   if(weixiubaogaoService.quchongWeixiubaogao(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "维修原因可以用！");
				  
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
