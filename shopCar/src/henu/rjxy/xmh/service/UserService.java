package henu.rjxy.xmh.service;

import henu.rjxy.xmh.bean.User;

public interface UserService {
	//��¼����
	User Login(String username,String password);
	//�޸��˻���Ϣ
	boolean alterUser(User user);
	//ע��һ���˻�
	boolean createUser(User newUser);
	//�޸��˻�����
	boolean alterPassword(String username,String oldPassword,String newPassword);
}
