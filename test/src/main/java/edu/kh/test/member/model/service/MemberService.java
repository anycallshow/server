package edu.kh.test.member.model.service;

import static edu.kh.test.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.test.member.model.dao.MemberDAO;
import edu.kh.test.member.model.vo.Member;

public class MemberService {
	
	MemberDAO dao = new MemberDAO();

	/** 아이디 찾기 서비스
	 * @param mem
	 * @return findMember
	 * @throws Exception
	 */
	public Member findId(Member mem) throws Exception{
		
		Connection conn = getConnection();
		
		Member findMember = dao.findId(conn,mem);
		
		close(conn);
		
		return findMember;
	}

}
