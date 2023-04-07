package edu.pnu.dao.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl implements MemberInterface {
	public Connection con;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;

	public MemberDaoH2Impl() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
			System.out.println("DB 연결 성공(기본 생성자)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> getMembers() {
		Map<String,Object> map = new HashMap<>();
		List<MemberVO> list = new ArrayList<>();
		try {
			st = con.createStatement();
			
			String sqlstr = "select * from member order by id asc";
			
			rs = st.executeQuery(sqlstr);
			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getInt("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("pass"));
				m.setRegidate(rs.getDate("regidate"));
				list.add(m);
			}
			map.put("result", list);
			map.put("msg", sqlstr);
		} 
		catch (Exception e) {
			System.out.println("member 조회 에러");
			e.printStackTrace();
			map.put("result", null);
			map.put("msg", e.getMessage());
		} 
		finally {
			try {
				rs.close();
				st.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	@Override
	public Map<String, Object> getMember(Integer id) {
		Map<String, Object> map = new HashMap<>();
		try {
			String sqlstr = "select * from member where id=?";
			ps = con.prepareStatement(sqlstr);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			
			MemberVO m = new MemberVO();
			m.setId(rs.getInt("id"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setRegidate(rs.getDate("regidate"));

			map.put("result", m);
			map.put("msg", sqlstr);
		}
		catch(Exception e){
			System.out.println("member 1명 조회 에러");
			e.printStackTrace();
			map.put("result", null);
			map.put("msg", e.getMessage());
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(st != null) ps.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	@Override
	public Map<String, Object> addMember(MemberVO member) {
		Map<String, Object> map = new HashMap<>();
	
		try {
			int id = getNextId();
			String query = String.format("insert into member(id,pass,name) values(%d,'%s','%s')", id,member.getPass(),member.getName());
			st = con.createStatement();
			st.executeUpdate(query);
			
			map.put("result", getMember(id));
			map.put("msg", query);
		}
		catch(Exception e){
			System.out.println("member 추가 에러");
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
		return null;
	}

	private int getNextId() {
		try {
			st = con.createStatement();
			rs = st.executeQuery("select max(id) from member");
			rs.next();
			return rs.getInt(1) + 1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				st.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 1;
	}

	@Override
	public Map<String, Object> updateMember(MemberVO member) {
		try {
			ps = con.prepareStatement("update member set name=?, pass=? where id=?");
			ps.setString(1, member.getName());
			ps.setString(2, member.getPass());
			ps.setInt(3, member.getId());
			ps.executeUpdate();
			
			//return getMember(member.getId());
		}
		catch(Exception e){
			System.out.println("member 변경 에러");
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
		return null;
	}

	@Override
	public boolean deleteMember(Integer id) {
		try {
			ps = con.prepareStatement("delete from member where id=?");
			ps.setInt(1, id);
			if (ps.executeUpdate() == 1) {
				return true;
			}
		}
		catch(Exception e){
			System.out.println("member 삭제 에러");
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
		return false;
	}

}
