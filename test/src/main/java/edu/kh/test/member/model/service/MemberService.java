package edu.kh.test.member.model.service;

import static edu.kh.test.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.test.member.model.dao.MemberDAO;
import edu.kh.test.member.model.vo.Member;

public class MemberService {
	
	MemberDAO dao = new MemberDAO();

	public Member find(Member mem) throws Exception{
		
		Connection conn = getConnection();
		
		Member findMember = dao.find(conn,mem);
		
		close(conn);
		
		return findMember;
	}

}
