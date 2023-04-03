package edu.pnu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl implements MemberInterface {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public MemberDaoH2Impl() {
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
	public List<MemberVO> getMembers() {
		String query = "select * from member";
		System.out.println("query" + query);
		
		List<MemberVO> list = new ArrayList<>();
		try {
			// 질의 객체 생성
			stmt = con.createStatement();
			// 질의 및 질의결과 가져오기
			rs = stmt.executeQuery(query);
			
			// 질의 결과 파싱
			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getInt("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setRegidate(rs.getDate("regidate"));
				list.add(m);
			}
		}
		catch (Exception e) {
			System.out.println("members 조회 에러");
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public MemberVO getMember(Integer id) {
		try {
			psmt = con.prepareStatement("select * from member where id=?");
			psmt.setInt(1, id); // **
			rs = psmt.executeQuery();
			rs.next();
			
			MemberVO m = new MemberVO();
			m.setId(rs.getInt("id"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setRegidate(rs.getDate("regidate"));
			return m;
		}
		catch (Exception e) {
			System.out.println("member 조회 에러");
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				psmt.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private int getNextId() {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select max(id) from member");
			rs.next();
			return rs.getInt(1) + 1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 1;
	}

	@Override
	public MemberVO addMember(MemberVO member) {
		int id = getNextId();
		try {
			psmt = con.prepareStatement("insert into member (id,name,pass,regidate) values(?,?,?,?)");
			psmt.setInt(1,id);
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPass());
			psmt.setDate(4, new Date(System.currentTimeMillis()));
			psmt.executeUpdate();
			
			return getMember(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	@Override
	public MemberVO updateMember(MemberVO member) {
		try {
			psmt = con.prepareStatement("update member set name=?,pass=? where id=?");
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getPass());
			psmt.setInt(3, member.getId());
			psmt.executeUpdate();
			
			return getMember(member.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				psmt.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean deleteMember(Integer id) {
		try {
			psmt = con.prepareStatement("delete from member where id=?");
			psmt.setInt(1, id);
			if(psmt.executeUpdate() == 1) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				psmt.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	

}
