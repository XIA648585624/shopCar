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
	//登录操作
	@Override
	public User Login(String username, String password) {
		//获取连接
		Connection conn = JDBCUtil.getConnection();//获取连接
		
		try {
			//手动控制事务
			conn.setAutoCommit(false);
			User user = dao.login(username, password);//调用dao层方法
			conn.commit();
			return user;
		} catch (Exception e) {
			try {//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("登陆失败~"); 
		}finally {
			//释放资源
			JDBCUtil.close(null, conn);
		}
	}

	//修改账户信息
	@Override
	public boolean alterUser(User user) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);//手动控制事务
			if(user.getPassword()==null) {
				return false;
			}
			dao.updateUser(user);
			conn.commit();
			return true;
		} catch (Exception e) {
			try {
				conn.rollback();//事务回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("修改信息失败~");
		}finally {
			JDBCUtil.close(null, conn);//释放资源
		}
	}

	//注册一个账户
	@Override
	public boolean createUser(User newUser) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);//手动控制事务
			if(dao.selectUserByUsername(newUser.getUsername())!=null)//如果用户名已存在
				return false;
			dao.insertUser(newUser);//添加用户
			conn.commit();
			return true;
		} catch (Exception e) {
			try {
				conn.rollback();//事务回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("注册失败~");
		}finally {
			JDBCUtil.close(null, conn);//释放资源
		}
	}

	//修改账户密码
	@Override
	public boolean alterPassword(String username, String oldPassword,String newPassword) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);//手动控制事务
			//将数据封装成Person对象（日期用DateUtil中的方法处理）,
			//再调用PersonDao中的添加联系人功能方法
			if(dao.login(username, oldPassword)==null) {
				//旧密码输入错误
				return false;
			}
			dao.updatePassword(username, newPassword);
			conn.commit();
			return true;
		} catch (Exception e) {
			try {
				conn.rollback();//事务回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("修改密码失败~");
		}finally {
			JDBCUtil.close(null, conn);//释放资源
		}
	}

}
