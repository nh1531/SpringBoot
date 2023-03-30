package edu.pnu.dao.log;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class LogDaoH2Impl implements LogDao{
	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;

	public LogDaoH2Impl() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
			
			System.out.println("DB 연결 성공(기본 생성자)");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addLog(String method, String sql, boolean success) {
		try {
			ps = con.prepareStatement("insert into dblog(method,sqlstring,success) values(?,?,?)");
			ps.setString(1, "method");
			ps.setString(2, "sql");
			ps.setString(3, "success");
			
			ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println("log 추가 에러");
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				ps.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return;
	}

	@Override
	public void addLog(String method, String msg, List<MemberVO> list) {
		addLog(method, msg, list!=null?true:false);
	}
	
	
}
