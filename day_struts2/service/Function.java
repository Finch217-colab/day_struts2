/*
 *
 * Author : qin
 * Description : service层，调用dao层。
 * 		在本例中，就是 login、register功能。
 * */

package site.rootalone.service;

import site.rootalone.dao.UserDao;
import site.rootalone.entity.User;

public class Function {
	UserDao userDao = new UserDao();
	
	public Function() {
	}

	/*
	 * 用户登录。验证过程在dao层实现。
	 * @param u : 表单提交时创建的用户对象。
	 * @return : 成功返回对象，供后续使用。
	 * 	     否则返回null。
	 * 	     注意 ： dao层没有使用数据库，也没有
	 * 	     	     检测任何异常。
	 * */
	public User login(User u) {
		if (userDao.queryUser(u)) {
			System.out.println("岁的的");
			return u;
		}
		else {

			System.out.println("岁的");
			return null;
		}
	}


	/*
	 * 用户注册。过程在dao层实现。
	 * @param u : 表单提交时创建的用户对象。
	 * @return : 成功返回对象，供后续使用。
	 * 	     否则返回null。
	 * 	     注意 ： dao层没有使用数据库，也没有
	 * 	     	     检测任何异常。
	 * */
	public User register(User u) {
		if (userDao.addUser(u))
			return u;
		else
			return null;
	}
}
