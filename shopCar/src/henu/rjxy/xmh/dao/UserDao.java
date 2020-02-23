package henu.rjxy.xmh.dao;

import henu.rjxy.xmh.bean.User;

public interface UserDao {
	//1、登录
	User login(String username, String password);
	//2、添加一个用户信息
	boolean insertUser(User newUser);
	//3、更新用户信息
	void updateUser(User user);
	//4、修改一个信息的密码
	void updatePassword(String username, String newPassword);
	//5、根据username获取账户信息
	User selectUserByUsername(String username);
}
