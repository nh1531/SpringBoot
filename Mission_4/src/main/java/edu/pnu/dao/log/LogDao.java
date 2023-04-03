package edu.pnu.dao.log;

import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public interface LogDao {

	void addLog(String method, String sql, boolean success);

	void addLog(String method, String msg, Object obj);
	
}

