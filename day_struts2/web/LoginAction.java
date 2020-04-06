/*
 *
 * Author : qin
 * Description : web层。访问service层。此为login功能的具体实现。
 * 		 service只是最简单的实现形式。拓展在这里展开。
 *
 * Version Info : 未使用struts2版本
 * */

package site.rootalone.web;

import site.rootalone.service.Function;
import site.rootalone.framework.Action;
import site.rootalone.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;


public class LoginAction implements Action {
	Function function = new Function();

	public LoginAction() {

	}


	/*
	 *
	 * login。
	 *
	 * 行至此，Model 构建完毕，已经需要考虑视图了，最后还需要一个Controller(总控制器)。
	 * 具体的 ： 
	 * 	登录成功，重定向到index.jsp。否则，转发到 error.jsp
	 *
	 * @param u
	 * @return : 返回文字串，传递给控制器统一处理。
	 * */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
                                throws IOException,ServletException
        {
		// 设置编码，防止中文乱码
		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User u = new User();
		u.setName(name);
		u.setPassword(password);

		
		if (function.login(u)!=null) {
			System.out.println("验证成功，欢迎登录......");
			return "redirect:/index.jsp";
		}
		else {
			System.out.println("验证失败......");
			return "dispatcher:/error.jsp";
		}

	}


}
