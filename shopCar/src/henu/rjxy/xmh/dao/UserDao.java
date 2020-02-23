package henu.rjxy.xmh.dao;

import henu.rjxy.xmh.bean.User;

public interface UserDao {
	//1����¼
	User login(String username, String password);
	//2�����һ���û���Ϣ
	boolean insertUser(User newUser);
	//3�������û���Ϣ
	void updateUser(User user);
	//4���޸�һ����Ϣ������
	void updatePassword(String username, String newPassword);
	//5������username��ȡ�˻���Ϣ
	User selectUserByUsername(String username);
}
