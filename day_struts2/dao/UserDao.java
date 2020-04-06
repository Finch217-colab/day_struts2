/*
 *
 * Author : qin
 * Description : dao层。作为service层的后勤供应。
 **/ 

package site.rootalone.dao;

import site.rootalone.entity.User;

public class UserDao {
	
	/*
	 * 验证用户是否注册过。这里没有使用数据库，只是尽可能构建一个
	 * 小的验证性质的项目而以。方便以后进行扩展。
	 *
	 * @para : u, 即将验证查询的表单提供的用户数据：用户名、密码
	 * @retrun :  如果查询成功，返回true。
	 * 	      注意 ： 查询失败还可能是数据库链接出现问题,这里
	 * 	      	      只是需求很低的验证而已,刻意回避了数据库。
	 * */
	public boolean queryUser(User u) {
		if (u.getName().equals("永强") && u.getPassword().equals("123456"))
			return true;
		else
			return false;
	}

	/*
	 * 注册时添加用户到本地服务器。同样，只是验证性质的设计。
	 * @para u : 通过注册，需要被添加的用户信息 ： 用户名、密码
	 * @return : 成功返回true，否则返回false。
	 * 	     这里，设计的是一定成功返回。没有考虑任何异常等。
	 * 	     注意： 参见 queryUser(User u)
	 * */
	public boolean addUser(User u) {
		System.out.println("添加用户成功 ： " + u.getName() + ", " + u.getPassword());
		return true;

	
	}
}
