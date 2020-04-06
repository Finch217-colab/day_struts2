/*
 *
 * Author : qin
 * Description : Action接口。向LoginAction、RegisterAction提供通用方法。
 *
 * Version Info : 未使用struts2。
 * */

package site.rootalone.framework;

import site.rootalone.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

public interface Action {
	/*
	 *
	 * LoginAction、RegisterAction中的逻辑。
	 * @param u
	 * @return : 页面跳转信息
	 * */
        public String execute(HttpServletRequest request, HttpServletResponse response)
		throws IOException,ServletException;
}
