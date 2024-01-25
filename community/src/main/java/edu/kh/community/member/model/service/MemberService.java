package edu.kh.community.member.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

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

	/** 이메일 중복검사 서비스
	 * @param memberEmail
	 * @return result
	 * @throws Exception
	 */
	public int emailDupCheck(String memberEmail) throws Exception{
		
		Connection conn =getConnection(); // DBCP에서 만들어둔 커넥션 얻어오기

		int result = dao.emailDupCheck(memberEmail, conn);

		close(conn);

		return result;
		
	}

	/** 닉네임 중복검사 서비스
	 * @param memberNickname
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDupCheck(String memberNickname) throws Exception{
		
		Connection conn =getConnection(); 

		int result = dao.nicknameDupCheck(memberNickname, conn);

		close(conn);

		return result;
	}

	/** 회원 정보 조회 서비스
	 * @param memberEmail
	 * @return selectMember
	 * @throws Exception
	 */
	public Member selectOne(String memberEmail) throws Exception{
		
		Connection conn =getConnection(); 

		Member selectMember = dao.selectOne(memberEmail, conn);

		close(conn);

		return selectMember;
	}

	/** 회원 목록 조회 서비스
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectAll() throws Exception{
		Connection conn =getConnection(); 

		List<Member> memberList = dao.selectAll(conn);

		close(conn);

		return memberList;
	}

	/** 프로필 변경 service
	 * @param memberNo
	 * @param profileImage
	 * @return
	 * @throws Exception
	 */
	public int updateProfileImage(int memberNo, String profileImage) throws Exception{
		
		Connection conn =getConnection();
		
		int result = dao.updateProfileImage(conn, profileImage, memberNo);
		
		if(result > 0 ) commit(conn);
		else         	rollback(conn);

		close(conn);
		
		return result;
	}
}
