/*
 *
 * Author : qin
 * Description : framework层。总控制器实现。通过一个servlet处理不同功能请求。
 *
 * Version Info ： 未使用struts2
 * */

package site.rootalone.framework;

import site.rootalone.web.LoginAction;
import site.rootalone.web.RegisterAction;

import site.rootalone.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;

import java.io.IOException;


public class ActionServlet extends HttpServlet{

	@Override 
	public void doGet(HttpServletRequest request,
			  HttpServletResponse response) throws IOException,ServletException{
	
		// 1. 获取表单提交的用户信息。 用户名、密码、以及uri
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
		// 根据action进行请求发送
		String str = "";
		if (action.contains("login")) {
			LoginAction loginAction = new LoginAction();
			str = loginAction.execute(request,response);
		}
		else {
			RegisterAction registerAction = new RegisterAction();
			str = registerAction.execute(request,response);
		}
		String page = str.substring(str.lastIndexOf("/"),str.length());
		if (str.contains("redirect")) {
			response.sendRedirect(request.getContextPath()+page);
		} 
		else {
			request.getRequestDispatcher(page).forward(request,response);		
		}
	}

	@Override
	public void doPost(HttpServletRequest request,
			  HttpServletResponse response) throws IOException,ServletException{
		doGet(request,response);
	}

}
