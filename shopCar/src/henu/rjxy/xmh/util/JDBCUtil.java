package henu.rjxy.xmh.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static Properties prop = new Properties();
	static{//1.��������
		InputStream in = JDBCUtil.class.getResourceAsStream("/JDBC.propreties");//��ȡ�����ļ�
		try {
			prop.load(in);//����prop������
			
			Class.forName(prop.getProperty("driverClassName"));
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","hr","123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//��ȡ����
	public static Connection getConnection() {
		Connection conn = tl.get();
		try {
			if(conn==null) {
			conn = DriverManager.getConnection(prop.getProperty("url"),
								prop.getProperty("username"),prop.getProperty("password"));
			tl.set(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//�ͷ���Դ1
	public static void close(ResultSet rs,PreparedStatement pstm, Connection conn) {
		try {
			if(rs!=null)rs.close();
			if(pstm!=null)pstm.close();
			if(conn!=null) {conn.close();tl.remove();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�ͷ���Դ2
	public static void close(PreparedStatement pstm, Connection conn) {
		try {
			if(pstm!=null)pstm.close();
			if(conn!=null) {conn.close();tl.remove();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
