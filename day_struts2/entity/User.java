/**
 *
 * Author : Qin
 * Description : 用户实体类，按照javabean规范构建
 * 		目前只使用了用户名、密码两个属性，
 * 		以后也能方便扩展。
 * */
package site.rootalone.entity;


public class User {
	private String name;
	private String password;

	public void setName(String name){
		this.name = name;	
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
}
