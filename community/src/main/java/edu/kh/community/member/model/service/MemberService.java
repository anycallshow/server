package edu.kh.community.member.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.community.member.model.dao.MemberDAO;
import edu.kh.community.member.model.vo.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();

	/** 로그인 서비스
	 * @param mem
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Member mem) throws Exception{

		// Connection 얻어오기
		Connection conn = getConnection();

		// DAO 수행
		Member loginMember = dao.login(conn, mem);

		// Connection 반환
		close(conn);

		// 결과 반환
		return loginMember;
	}

	/** 회원가입 서비스
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member mem) throws Exception{

		Connection conn = getConnection();

		int result = dao.signUp(conn, mem);

		if(result > 0 ) commit(conn);
		else          	rollback(conn);

		close(conn);

		return result;
	}

	/** 마이페이지(내정보 수정) 서비스
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int myPage(Member mem) throws Exception {
		Connection conn = getConnection();

		int result = dao.myPage(conn, mem);

		if(result > 0 ) commit(conn);
		else          	rollback(conn);

		close(conn);

		return result;
	}

	/** 비밀번호 변경 서비스
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(String currentPw, String newPw, int memberNo) throws Exception{

		Connection conn =getConnection();

		int result = dao.changePw(currentPw, newPw, memberNo, conn);

		if(result > 0 ) commit(conn);
		else         	rollback(conn);

		close(conn);

		return result;
	}

	/** 회원 탈퇴 서비스
	 * @param memberPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int secession(String memberPw, int memberNo) throws Exception{

		Connection conn =getConnection();

		int result = dao.secession(memberPw, memberNo, conn);

		if(result > 0 ) commit(conn);
		else         	rollback(conn);

		close(conn);

		return result;
	}
}
