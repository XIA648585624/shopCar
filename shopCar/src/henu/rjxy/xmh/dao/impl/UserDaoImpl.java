package henu.rjxy.xmh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import henu.rjxy.xmh.bean.User;
import henu.rjxy.xmh.dao.UserDao;
import henu.rjxy.xmh.util.JDBCUtil;

public class UserDaoImpl implements UserDao{

	//1、登录验证
	@Override
	public User login(String username,String password) {
		Connection conn = null;
		PreparedStatement pstm = null;//执行sql语句对象，带缓冲区
		ResultSet rs = null;
		try{
			conn = JDBCUtil.getConnection();
			//书写SQL语句
			String sql = "select USERNAME,PASSWORD,NAME,ZIP,ADDRESS"
					+ " from SHOP_USER where USERNAME=? and PASSWORD=?";
			//创建PreparedStatement对象，补齐站位符的值，执行sql语句
			pstm = conn.prepareStatement(sql);//创建pstm
			//将键入的数据赋值给相应站位符
			pstm.setString(1,username);
			pstm.setString(2,password);
			rs = pstm.executeQuery();
			//5.处理结果数据
			if(rs.next()) {
				return new User(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5)
						);//登陆成功
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("登录验证失败~");
		}finally {//6.关闭资源
			JDBCUtil.close(pstm, null);
		}
		
	}

	//2、向数据库插入一条账户信息
	@Override
	public boolean insertUser(User newUser) {
		Connection conn = null;
		PreparedStatement pstm = null;//执行sql语句对象，带缓冲区
		
		try{
			conn = JDBCUtil.getConnection();
			//书写SQL语句
			String sql = "insert into SHOP_USER values(?,?,?,?,?)";
			//创建PreparedStatement对象，补齐站位符的值，执行sql语句
			pstm = conn.prepareStatement(sql);//创建pstm
			//将键入的数据赋值给相应站位符
			pstm.setString(1, newUser.getUsername());
			pstm.setString(2, newUser.getPassword());
			pstm.setString(3, newUser.getName());
			pstm.setInt(4,newUser.getZip());
			pstm.setString(5,newUser.getAddress());
			int i = pstm.executeUpdate();//执行查询语句，结果集用rs接收
			//5.处理结果数据
			if(i>0) {
				//System.out.println("已成功添加"+i+"个账户");
				return true;//添加成功
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("账户信息添加失败~");
		}finally {//6.关闭资源
			JDBCUtil.close(pstm, null);
		}
		return false;
	}

	//3、修改账户信息
	@Override
	public void updateUser(User user) {
		Connection conn = null;
		PreparedStatement pstm = null;//执行sql语句对象，带缓冲区
		//ResultSet rs = null;//接收结果数据集合
		
		try{
			//获取连接
			conn = JDBCUtil.getConnection();
			//3.书写SQL语句
			String sql = "update SHOP_USER set PASSWORD=?, NAME=?,ZIP=?,ADDRESS=? where USERNAME=?";
			//4.创建PreparedStatement对象，补齐站位符的值，执行sql语句
			pstm = conn.prepareStatement(sql);//创建pstm
			//将键入的数据赋值给相应站位符
			
			pstm.setString(1, user.getPassword());
			pstm.setString(2, user.getName());
			pstm.setInt(3, user.getZip());
			pstm.setString(4, user.getAddress());
			pstm.setString(5, user.getUsername());
			int i = pstm.executeUpdate();
			//System.out.println(i);
			//5.处理结果数据
			if(i>0) {
				System.out.println("已成功修改"+i+"个账户信息");
				System.out.println("修改后的信息为："+user);
				return;//添加成功
			}else {
				System.out.println("添加失败");
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("账户信息更新失败~");
		}finally {//6.关闭资源
			JDBCUtil.close(pstm, null);
		}
	}

	//4、修改账户密码
	@Override
	public void updatePassword(String username,String newPassword) {
		Connection conn = null;
		PreparedStatement pstm = null;//执行sql语句对象，带缓冲区
		//ResultSet rs = null;//接收结果数据集合
		
		try{
			//获取连接
			conn = JDBCUtil.getConnection();
			//3.书写SQL语句
			String sql = "update SHOP_USER set PASSWORD=? where USERNAME=?";
			//4.创建PreparedStatement对象，补齐站位符的值，执行sql语句
			pstm = conn.prepareStatement(sql);//创建pstm
			//将键入的数据赋值给相应站位符
			
			pstm.setString(1, newPassword);
			pstm.setString(2, username);
			int i = pstm.executeUpdate();
			//System.out.println(i);
			//5.处理结果数据
			if(i>0) {
				System.out.println("已成功修改"+username+"的账户密码");
				System.out.println("修改后的密码为："+newPassword);
				return;//添加成功
			}else {
				System.out.println("添加失败");
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("账户信息更新失败~");
		}finally {//6.关闭资源
			JDBCUtil.close(pstm, null);
		}//finally
	}

	//5、根据username获取账户信息
	@Override
	public User selectUserByUsername(String username) {
		Connection conn = null;
		PreparedStatement pstm = null;//执行sql语句对象，带缓冲区
		ResultSet rs = null;
		try{
			conn = JDBCUtil.getConnection();
			//书写SQL语句
			String sql = "select USERNAME,PASSWORD,NAME,ZIP,ADDRESS"
					+ " from SHOP_USER where USERNAME=?";
			//创建PreparedStatement对象，补齐站位符的值，执行sql语句
			pstm = conn.prepareStatement(sql);//创建pstm
			//将键入的数据赋值给相应站位符
			pstm.setString(1,username);
			rs = pstm.executeQuery();
			//5.处理结果数据
			if(rs.next()) {
				return new User(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5)
						);//登陆成功
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("根据用户名查找用户信息失败~");
		}finally {//6.关闭资源
			JDBCUtil.close(pstm, null);
		}
		
	}
}

	
	

