package henu.rjxy.xmh.service;

import henu.rjxy.xmh.bean.User;

public interface UserService {
	//登录操作
	User Login(String username,String password);
	//修改账户信息
	boolean alterUser(User user);
	//注册一个账户
	boolean createUser(User newUser);
	//修改账户密码
	boolean alterPassword(String username,String oldPassword,String newPassword);
}
