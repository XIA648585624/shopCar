package henu.rjxy.xmh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import henu.rjxy.xmh.bean.User;
import henu.rjxy.xmh.dao.UserDao;
import henu.rjxy.xmh.util.JDBCUtil;

public class UserDaoImpl implements UserDao{

	//1����¼��֤
	@Override
	public User login(String username,String password) {
		Connection conn = null;
		PreparedStatement pstm = null;//ִ��sql�����󣬴�������
		ResultSet rs = null;
		try{
			conn = JDBCUtil.getConnection();
			//��дSQL���
			String sql = "select USERNAME,PASSWORD,NAME,ZIP,ADDRESS"
					+ " from SHOP_USER where USERNAME=? and PASSWORD=?";
			//����PreparedStatement���󣬲���վλ����ֵ��ִ��sql���
			pstm = conn.prepareStatement(sql);//����pstm
			//����������ݸ�ֵ����Ӧվλ��
			pstm.setString(1,username);
			pstm.setString(2,password);
			rs = pstm.executeQuery();
			//5.����������
			if(rs.next()) {
				return new User(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5)
						);//��½�ɹ�
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��¼��֤ʧ��~");
		}finally {//6.�ر���Դ
			JDBCUtil.close(pstm, null);
		}
		
	}

	//2�������ݿ����һ���˻���Ϣ
	@Override
	public boolean insertUser(User newUser) {
		Connection conn = null;
		PreparedStatement pstm = null;//ִ��sql�����󣬴�������
		
		try{
			conn = JDBCUtil.getConnection();
			//��дSQL���
			String sql = "insert into SHOP_USER values(?,?,?,?,?)";
			//����PreparedStatement���󣬲���վλ����ֵ��ִ��sql���
			pstm = conn.prepareStatement(sql);//����pstm
			//����������ݸ�ֵ����Ӧվλ��
			pstm.setString(1, newUser.getUsername());
			pstm.setString(2, newUser.getPassword());
			pstm.setString(3, newUser.getName());
			pstm.setInt(4,newUser.getZip());
			pstm.setString(5,newUser.getAddress());
			int i = pstm.executeUpdate();//ִ�в�ѯ��䣬�������rs����
			//5.����������
			if(i>0) {
				//System.out.println("�ѳɹ����"+i+"���˻�");
				return true;//��ӳɹ�
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("�˻���Ϣ���ʧ��~");
		}finally {//6.�ر���Դ
			JDBCUtil.close(pstm, null);
		}
		return false;
	}

	//3���޸��˻���Ϣ
	@Override
	public void updateUser(User user) {
		Connection conn = null;
		PreparedStatement pstm = null;//ִ��sql�����󣬴�������
		//ResultSet rs = null;//���ս�����ݼ���
		
		try{
			//��ȡ����
			conn = JDBCUtil.getConnection();
			//3.��дSQL���
			String sql = "update SHOP_USER set PASSWORD=?, NAME=?,ZIP=?,ADDRESS=? where USERNAME=?";
			//4.����PreparedStatement���󣬲���վλ����ֵ��ִ��sql���
			pstm = conn.prepareStatement(sql);//����pstm
			//����������ݸ�ֵ����Ӧվλ��
			
			pstm.setString(1, user.getPassword());
			pstm.setString(2, user.getName());
			pstm.setInt(3, user.getZip());
			pstm.setString(4, user.getAddress());
			pstm.setString(5, user.getUsername());
			int i = pstm.executeUpdate();
			//System.out.println(i);
			//5.����������
			if(i>0) {
				System.out.println("�ѳɹ��޸�"+i+"���˻���Ϣ");
				System.out.println("�޸ĺ����ϢΪ��"+user);
				return;//��ӳɹ�
			}else {
				System.out.println("���ʧ��");
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("�˻���Ϣ����ʧ��~");
		}finally {//6.�ر���Դ
			JDBCUtil.close(pstm, null);
		}
	}

	//4���޸��˻�����
	@Override
	public void updatePassword(String username,String newPassword) {
		Connection conn = null;
		PreparedStatement pstm = null;//ִ��sql�����󣬴�������
		//ResultSet rs = null;//���ս�����ݼ���
		
		try{
			//��ȡ����
			conn = JDBCUtil.getConnection();
			//3.��дSQL���
			String sql = "update SHOP_USER set PASSWORD=? where USERNAME=?";
			//4.����PreparedStatement���󣬲���վλ����ֵ��ִ��sql���
			pstm = conn.prepareStatement(sql);//����pstm
			//����������ݸ�ֵ����Ӧվλ��
			
			pstm.setString(1, newPassword);
			pstm.setString(2, username);
			int i = pstm.executeUpdate();
			//System.out.println(i);
			//5.����������
			if(i>0) {
				System.out.println("�ѳɹ��޸�"+username+"���˻�����");
				System.out.println("�޸ĺ������Ϊ��"+newPassword);
				return;//��ӳɹ�
			}else {
				System.out.println("���ʧ��");
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("�˻���Ϣ����ʧ��~");
		}finally {//6.�ر���Դ
			JDBCUtil.close(pstm, null);
		}//finally
	}

	//5������username��ȡ�˻���Ϣ
	@Override
	public User selectUserByUsername(String username) {
		Connection conn = null;
		PreparedStatement pstm = null;//ִ��sql�����󣬴�������
		ResultSet rs = null;
		try{
			conn = JDBCUtil.getConnection();
			//��дSQL���
			String sql = "select USERNAME,PASSWORD,NAME,ZIP,ADDRESS"
					+ " from SHOP_USER where USERNAME=?";
			//����PreparedStatement���󣬲���վλ����ֵ��ִ��sql���
			pstm = conn.prepareStatement(sql);//����pstm
			//����������ݸ�ֵ����Ӧվλ��
			pstm.setString(1,username);
			rs = pstm.executeQuery();
			//5.����������
			if(rs.next()) {
				return new User(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5)
						);//��½�ɹ�
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("�����û��������û���Ϣʧ��~");
		}finally {//6.�ر���Դ
			JDBCUtil.close(pstm, null);
		}
		
	}
}

	
	

