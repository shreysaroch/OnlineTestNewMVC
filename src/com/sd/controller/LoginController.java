package com.sd.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sd.Impl.GroupInfoDaoImpl;
import com.sd.Impl.UserDaoImpl;
import com.sd.Impl.UserTestDaoImpl;
import com.sd.pojo.GroupInfoPojo;
import com.sd.pojo.UserPojo;

@Controller
public class LoginController {
	

	@ModelAttribute("groupList")
	public ArrayList<GroupInfoPojo> getGroupList(){
		ArrayList<GroupInfoPojo> groupList = new ArrayList<GroupInfoPojo>();
		ApplicationContext factory=new ClassPathXmlApplicationContext("SpringBeanConfiguration.xml");
		GroupInfoDaoImpl groupInfo = (GroupInfoDaoImpl) factory.getBean("groupInfoDao");
		groupList=groupInfo.getGroupList();
		return groupList;
	}
	
	@RequestMapping("/login.htm")
	public ModelAndView loadLoginPage(HttpServletRequest request,HttpServletResponse response, ModelMap map) throws Exception{
		UserPojo user = new UserPojo();
		map.addAttribute("user",user);
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/check.htm", method = RequestMethod.POST)
	public ModelAndView checkExistenceOfUser(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("user") UserPojo user) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		int userId=user.getUserId();
		//BeanGenerator bGen = new BeanGenerator();
		ApplicationContext factory = new ClassPathXmlApplicationContext("SpringBeanConfiguration.xml");
		UserDaoImpl userDao = (UserDaoImpl) factory.getBean("userDao");
		System.out.println(userDao.checkExistenceofUser(userId));
		if(!userDao.checkExistenceofUser(userId)){
			System.out.println("User pojo"+user);
			if(userDao.addUser(user)){
				HttpSession session = request.getSession(true);
				session.setAttribute("user",user);	
				mv.setViewName("TakeTest");
			}
		}else{
			System.out.println("USer Exist");
			mv.setViewName("login");
			mv.addObject("message", "User already Exsist!!!");
		}
		return mv;
	}


	
}
