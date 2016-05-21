package home.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ��ݿ⹤����
 * @author 
 *
 */
public class DbUtil {

	/**
	 * ��ȡ��ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/home", "root", "root");
		return con;
	}
	
	/**
	 * �ر���ݿ�����
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("链接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("链接失败");
		}
	}
}
