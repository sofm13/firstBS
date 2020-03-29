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

import com.entity.Hetongshengcheng;
import com.server.HetongshengchengServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class HetongshengchengController {
	@Resource
	private HetongshengchengServer hetongshengchengService;


   
	@RequestMapping("addHetongshengcheng.do")
	public String addHetongshengcheng(HttpServletRequest request,Hetongshengcheng hetongshengcheng,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		hetongshengcheng.setAddtime(time.toString().substring(0, 19));
		hetongshengchengService.add(hetongshengcheng);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "hetongshengchengList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:hetongshengchengList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHetongshengcheng.do")
	public String doUpdateHetongshengcheng(int id,ModelMap map,Hetongshengcheng hetongshengcheng){
		hetongshengcheng=hetongshengchengService.getById(id);
		map.put("hetongshengcheng", hetongshengcheng);
		return "hetongshengcheng_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("hetongshengchengDetail.do")
	public String hetongshengchengDetail(int id,ModelMap map,Hetongshengcheng hetongshengcheng){
		hetongshengcheng=hetongshengchengService.getById(id);
		map.put("hetongshengcheng", hetongshengcheng);
		return "hetongshengcheng_detail";
	}
//	前台详细
	@RequestMapping("htscDetail.do")
	public String htscDetail(int id,ModelMap map,Hetongshengcheng hetongshengcheng){
		hetongshengcheng=hetongshengchengService.getById(id);
		map.put("hetongshengcheng", hetongshengcheng);
		return "hetongshengchengdetail";
	}
//	
	@RequestMapping("updateHetongshengcheng.do")
	public String updateHetongshengcheng(int id,ModelMap map,Hetongshengcheng hetongshengcheng,HttpServletRequest request,HttpSession session){
		hetongshengchengService.update(hetongshengcheng);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:hetongshengchengList.do";
	}

//	分页查询
	@RequestMapping("hetongshengchengList.do")
	public String hetongshengchengList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hetongshengcheng hetongshengcheng, String bianhao, String shebeimingcheng, String hetongbianhao, String hetongneirong, String caigougongsi, String caigouriqi1,String caigouriqi2, String caigouren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(hetongbianhao==null||hetongbianhao.equals("")){pmap.put("hetongbianhao", null);}else{pmap.put("hetongbianhao", hetongbianhao);}		if(hetongneirong==null||hetongneirong.equals("")){pmap.put("hetongneirong", null);}else{pmap.put("hetongneirong", hetongneirong);}		if(caigougongsi==null||caigougongsi.equals("")){pmap.put("caigougongsi", null);}else{pmap.put("caigougongsi", caigougongsi);}		if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}		if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}		if(caigouren==null||caigouren.equals("")){pmap.put("caigouren", null);}else{pmap.put("caigouren", caigouren);}		
		int total=hetongshengchengService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hetongshengcheng> list=hetongshengchengService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hetongshengcheng_list";
	}
	
	@RequestMapping("hetongshengcheng_yanben1.do")
	public String hetongshengcheng_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hetongshengcheng hetongshengcheng, String bianhao, String shebeimingcheng, String hetongbianhao, String hetongneirong, String caigougongsi, String caigouriqi1,String caigouriqi2, String caigouren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(hetongbianhao==null||hetongbianhao.equals("")){pmap.put("hetongbianhao", null);}else{pmap.put("hetongbianhao", hetongbianhao);}		if(hetongneirong==null||hetongneirong.equals("")){pmap.put("hetongneirong", null);}else{pmap.put("hetongneirong", hetongneirong);}		if(caigougongsi==null||caigougongsi.equals("")){pmap.put("caigougongsi", null);}else{pmap.put("caigougongsi", caigougongsi);}		if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}		if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}		if(caigouren==null||caigouren.equals("")){pmap.put("caigouren", null);}else{pmap.put("caigouren", caigouren);}		
		int total=hetongshengchengService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hetongshengcheng> list=hetongshengchengService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hetongshengcheng_yanben1";
	}
	@RequestMapping("hetongshengcheng_yanben2.do")
	public String hetongshengcheng_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hetongshengcheng hetongshengcheng, String bianhao, String shebeimingcheng, String hetongbianhao, String hetongneirong, String caigougongsi, String caigouriqi1,String caigouriqi2, String caigouren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(hetongbianhao==null||hetongbianhao.equals("")){pmap.put("hetongbianhao", null);}else{pmap.put("hetongbianhao", hetongbianhao);}		if(hetongneirong==null||hetongneirong.equals("")){pmap.put("hetongneirong", null);}else{pmap.put("hetongneirong", hetongneirong);}		if(caigougongsi==null||caigougongsi.equals("")){pmap.put("caigougongsi", null);}else{pmap.put("caigougongsi", caigougongsi);}		if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}		if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}		if(caigouren==null||caigouren.equals("")){pmap.put("caigouren", null);}else{pmap.put("caigouren", caigouren);}		
		int total=hetongshengchengService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hetongshengcheng> list=hetongshengchengService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hetongshengcheng_yanben2";
	}
	@RequestMapping("hetongshengcheng_yanben3.do")
	public String hetongshengcheng_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hetongshengcheng hetongshengcheng, String bianhao, String shebeimingcheng, String hetongbianhao, String hetongneirong, String caigougongsi, String caigouriqi1,String caigouriqi2, String caigouren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(hetongbianhao==null||hetongbianhao.equals("")){pmap.put("hetongbianhao", null);}else{pmap.put("hetongbianhao", hetongbianhao);}		if(hetongneirong==null||hetongneirong.equals("")){pmap.put("hetongneirong", null);}else{pmap.put("hetongneirong", hetongneirong);}		if(caigougongsi==null||caigougongsi.equals("")){pmap.put("caigougongsi", null);}else{pmap.put("caigougongsi", caigougongsi);}		if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}		if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}		if(caigouren==null||caigouren.equals("")){pmap.put("caigouren", null);}else{pmap.put("caigouren", caigouren);}		
		int total=hetongshengchengService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hetongshengcheng> list=hetongshengchengService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hetongshengcheng_yanben3";
	}
	@RequestMapping("hetongshengcheng_yanben4.do")
	public String hetongshengcheng_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hetongshengcheng hetongshengcheng, String bianhao, String shebeimingcheng, String hetongbianhao, String hetongneirong, String caigougongsi, String caigouriqi1,String caigouriqi2, String caigouren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(hetongbianhao==null||hetongbianhao.equals("")){pmap.put("hetongbianhao", null);}else{pmap.put("hetongbianhao", hetongbianhao);}		if(hetongneirong==null||hetongneirong.equals("")){pmap.put("hetongneirong", null);}else{pmap.put("hetongneirong", hetongneirong);}		if(caigougongsi==null||caigougongsi.equals("")){pmap.put("caigougongsi", null);}else{pmap.put("caigougongsi", caigougongsi);}		if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}		if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}		if(caigouren==null||caigouren.equals("")){pmap.put("caigouren", null);}else{pmap.put("caigouren", caigouren);}		
		int total=hetongshengchengService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hetongshengcheng> list=hetongshengchengService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hetongshengcheng_yanben4";
	}
	@RequestMapping("hetongshengcheng_yanben5.do")
	public String hetongshengcheng_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hetongshengcheng hetongshengcheng, String bianhao, String shebeimingcheng, String hetongbianhao, String hetongneirong, String caigougongsi, String caigouriqi1,String caigouriqi2, String caigouren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(hetongbianhao==null||hetongbianhao.equals("")){pmap.put("hetongbianhao", null);}else{pmap.put("hetongbianhao", hetongbianhao);}		if(hetongneirong==null||hetongneirong.equals("")){pmap.put("hetongneirong", null);}else{pmap.put("hetongneirong", hetongneirong);}		if(caigougongsi==null||caigougongsi.equals("")){pmap.put("caigougongsi", null);}else{pmap.put("caigougongsi", caigougongsi);}		if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}		if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}		if(caigouren==null||caigouren.equals("")){pmap.put("caigouren", null);}else{pmap.put("caigouren", caigouren);}		
		int total=hetongshengchengService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hetongshengcheng> list=hetongshengchengService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hetongshengcheng_yanben5";
	}
	
	
	
	@RequestMapping("htscList.do")
	public String htscList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hetongshengcheng hetongshengcheng, String bianhao, String shebeimingcheng, String hetongbianhao, String hetongneirong, String caigougongsi, String caigouriqi1,String caigouriqi2, String caigouren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(hetongbianhao==null||hetongbianhao.equals("")){pmap.put("hetongbianhao", null);}else{pmap.put("hetongbianhao", hetongbianhao);}		if(hetongneirong==null||hetongneirong.equals("")){pmap.put("hetongneirong", null);}else{pmap.put("hetongneirong", hetongneirong);}		if(caigougongsi==null||caigougongsi.equals("")){pmap.put("caigougongsi", null);}else{pmap.put("caigougongsi", caigougongsi);}		if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}		if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}		if(caigouren==null||caigouren.equals("")){pmap.put("caigouren", null);}else{pmap.put("caigouren", caigouren);}		
		int total=hetongshengchengService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hetongshengcheng> list=hetongshengchengService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hetongshengchenglist";
	}
	@RequestMapping("htscListtp.do")
	public String htscListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hetongshengcheng hetongshengcheng, String bianhao, String shebeimingcheng, String hetongbianhao, String hetongneirong, String caigougongsi, String caigouriqi1,String caigouriqi2, String caigouren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shebeimingcheng==null||shebeimingcheng.equals("")){pmap.put("shebeimingcheng", null);}else{pmap.put("shebeimingcheng", shebeimingcheng);}		if(hetongbianhao==null||hetongbianhao.equals("")){pmap.put("hetongbianhao", null);}else{pmap.put("hetongbianhao", hetongbianhao);}		if(hetongneirong==null||hetongneirong.equals("")){pmap.put("hetongneirong", null);}else{pmap.put("hetongneirong", hetongneirong);}		if(caigougongsi==null||caigougongsi.equals("")){pmap.put("caigougongsi", null);}else{pmap.put("caigougongsi", caigougongsi);}		if(caigouriqi1==null||caigouriqi1.equals("")){pmap.put("caigouriqi1", null);}else{pmap.put("caigouriqi1", caigouriqi1);}		if(caigouriqi2==null||caigouriqi2.equals("")){pmap.put("caigouriqi2", null);}else{pmap.put("caigouriqi2", caigouriqi2);}		if(caigouren==null||caigouren.equals("")){pmap.put("caigouren", null);}else{pmap.put("caigouren", caigouren);}		
		int total=hetongshengchengService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hetongshengcheng> list=hetongshengchengService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hetongshengchenglisttp";
	}
	
	@RequestMapping("deleteHetongshengcheng.do")
	public String deleteHetongshengcheng(int id,HttpServletRequest request){
		hetongshengchengService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:hetongshengchengList.do";
	}
	
	
}
