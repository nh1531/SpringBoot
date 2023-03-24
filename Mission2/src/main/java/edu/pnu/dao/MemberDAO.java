package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDAO {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;

	// 기본 생성자
	public MemberDAO() {
		try {
			// JDBC 드라이버 로드
			Class.forName("org.h2.Driver");
			
			// DB에 연결
			String url = "jdbc:h2:tcp://localhost/~/springboot";
			String id = "sa";
			String pwd = "";
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(기본 생성자)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<MemberVO> getMembers() {

		String query = "SELECT * FROM member";
		
		System.out.println("query " + query);
		
		List<MemberVO> list = new ArrayList<>();
		
		try {
			// 질의 객체 생성
			stmt = con.createStatement();
			// 질의 및 질의 결과 가져오기
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
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return list; // 목록 반환		
	}

	public MemberVO getMember(Integer id) {
		String query = "SELECT * FROM member where id=" + id;
		
		System.out.println("query " + query);

		MemberVO m = null;
		
		try {
			// 질의 객체 생성
			stmt = con.createStatement();
			// 질의 및 질의 결과 가져오기
			rs = stmt.executeQuery(query);
			
			// 질의 결과 파싱
			rs.next();
			
			m = new MemberVO();
			m.setId(rs.getInt("id"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setRegidate(rs.getDate("regidate"));
		}
		catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return m; // Result 반환	
	}

	public MemberVO addMember(MemberVO member) {
		String query = "INSERT INTO member(id,pass,name) VALUES(?,?,?)";
		System.out.println("query" + query);
		MemberVO m = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			
			m = new MemberVO();
			m.setId(rs.getInt("id"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setRegidate(new Date());
			psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("멤버 추가 중 예외 발생");
			e.printStackTrace();
		}
		return m;
	}	
	
}
