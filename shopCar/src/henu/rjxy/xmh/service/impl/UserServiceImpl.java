package henu.rjxy.xmh.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import henu.rjxy.xmh.bean.User;
import henu.rjxy.xmh.dao.UserDao;
import henu.rjxy.xmh.dao.impl.UserDaoImpl;
import henu.rjxy.xmh.service.UserService;
import henu.rjxy.xmh.util.JDBCUtil;



public class UserServiceImpl implements UserService{
	private static UserDao dao = new UserDaoImpl();
	//��¼����
	@Override
	public User Login(String username, String password) {
		//��ȡ����
		Connection conn = JDBCUtil.getConnection();//��ȡ����
		
		try {
			//�ֶ���������
			conn.setAutoCommit(false);
			User user = dao.login(username, password);//����dao�㷽��
			conn.commit();
			return user;
		} catch (Exception e) {
			try {//����ع�
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("��½ʧ��~"); 
		}finally {
			//�ͷ���Դ
			JDBCUtil.close(null, conn);
		}
	}

	//�޸��˻���Ϣ
	@Override
	public boolean alterUser(User user) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);//�ֶ���������
			if(user.getPassword()==null) {
				return false;
			}
			dao.updateUser(user);
			conn.commit();
			return true;
		} catch (Exception e) {
			try {
				conn.rollback();//����ع�
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("�޸���Ϣʧ��~");
		}finally {
			JDBCUtil.close(null, conn);//�ͷ���Դ
		}
	}

	//ע��һ���˻�
	@Override
	public boolean createUser(User newUser) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);//�ֶ���������
			if(dao.selectUserByUsername(newUser.getUsername())!=null)//����û����Ѵ���
				return false;
			dao.insertUser(newUser);//����û�
			conn.commit();
			return true;
		} catch (Exception e) {
			try {
				conn.rollback();//����ع�
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("ע��ʧ��~");
		}finally {
			JDBCUtil.close(null, conn);//�ͷ���Դ
		}
	}

	//�޸��˻�����
	@Override
	public boolean alterPassword(String username, String oldPassword,String newPassword) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);//�ֶ���������
			//�����ݷ�װ��Person����������DateUtil�еķ�������,
			//�ٵ���PersonDao�е������ϵ�˹��ܷ���
			if(dao.login(username, oldPassword)==null) {
				//�������������
				return false;
			}
			dao.updatePassword(username, newPassword);
			conn.commit();
			return true;
		} catch (Exception e) {
			try {
				conn.rollback();//����ع�
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("�޸�����ʧ��~");
		}finally {
			JDBCUtil.close(null, conn);//�ͷ���Դ
		}
	}

}
