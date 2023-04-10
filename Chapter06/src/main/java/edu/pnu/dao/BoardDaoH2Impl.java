package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.Board;

@Repository
public class BoardDaoH2Impl implements BoardInterface{
	
	@Autowired
	private DataSource dataSource;
	
	
	private Connection getConnection() {
		try {
			return dataSource.getConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Board> getBoards() {
		Statement st = null;
		ResultSet rs = null;
		String sqlString = "select * from board order by seq asc";
		try {
			List<Board> list = new ArrayList<>();
			//st = dataSource.getConnection().createStatement();
			//st = con.createStatement();
			st = getConnection().createStatement();
			rs = st.executeQuery(sqlString);
			while(rs.next() ) {
				Board b = new Board();
				b.setSeq(rs.getLong("seq"));
				b.setTitle(rs.getString("title"));
				b.setWriter(rs.getString("writer"));
				b.setContent(rs.getString("content"));
				b.setCreateDate(rs.getDate("createDate"));
				b.setCnt(rs.getLong("cnt"));
				
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)	rs.close();
				if (st != null)	st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Board getBoard(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

}
