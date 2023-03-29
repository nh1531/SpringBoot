package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberVO;

@Repository
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
		String query = String.format("INSERT INTO member(pass,name) VALUES('%s','%s')",member.getPass(), member.getName());
		System.out.println("query" + query);
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		}
		catch (Exception e) {
			System.out.println("멤버 추가 중 예외 발생");
			e.printStackTrace();
		}
		// 현재 테이블에서 max값을 가져옴->getMember()로 select 호출
		return getMember(getMaxId());
	}

	private Integer getMaxId() {
		// 최대값을 찾아서 return
		String query = "SELECT max(id) FROM MEMBER";
		try {
			// 질의 객체 생성
			stmt = con.createStatement();
			// 질의 및 질의 결과 가져오기
			rs = stmt.executeQuery(query);
			// rs(resultset)의 다음 레코드로 이동
			rs.next();
			return rs.getInt(1);
		}
		catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return 0; // Result 반환	
	}	
	
	public MemberVO updateMembers(MemberVO member) {
		String query = "UPDATE member SET pass=?,name=? where id=?";
		System.out.println(query + "query");
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, member.getPass());
			psmt.setString(2, member.getName());
			psmt.setInt(3, member.getId());
			psmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("수정 중 예외 발생");
			e.printStackTrace();
		}
		return member;
	}
	
	public MemberVO removeMember(Integer id) {
		MemberVO memberVO = new MemberVO();
		String query = "delete from member where id=?";
		System.out.println(query + "query");
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, memberVO.getId());
			int rs = psmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("삭제 중 예외 발생");
			e.printStackTrace();
		}
		return memberVO ;
	}
	
	
	
}
