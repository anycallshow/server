package edu.kh.community.member.model.dao;

import static edu.kh.community.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.community.member.model.vo.Member;

public class MemberDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;

	// 기본 생성자
	public MemberDAO() {
		try {
			prop = new Properties();
			String filePath = MemberDAO.class.getResource("/edu/kh/community/sql/member-sql.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 로그인 DAO
	 * 
	 * @param conn
	 * @param mem
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Connection conn, Member mem) throws Exception {
		Member loginMember = null; // 결과 저장용 변수

		try {
			// SQL 얻어오기
			String sql = prop.getProperty("login");

			// PreparedStatement 생성 및 SQL 적재
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberPw());

			// SQL 수행
			rs = pstmt.executeQuery();

			if (rs.next()) {
				loginMember = new Member();

				loginMember.setMemberNo(rs.getInt("MEMBER_NO"));
				loginMember.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				loginMember.setMemberNickname(rs.getString("MEMBER_NICK"));
				loginMember.setMemberTel(rs.getString("MEMBER_TEL"));
				loginMember.setMemberAddress(rs.getString("MEMBER_ADDR"));
				loginMember.setProfileImage(rs.getString("PROFILE_IMG"));
				loginMember.setEnrollDate(rs.getString("ENROLL_DT"));

			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return loginMember; // null 또는 Member 객체 주소

	}

	/** 회원가입 DAO
	 * @param conn
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member mem) throws Exception{
		int result = 0;

		try {
			String sql = prop.getProperty("signUp");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,mem.getMemberEmail());
			pstmt.setString(2,mem.getMemberPw());
			pstmt.setString(3,mem.getMemberNickname());
			pstmt.setString(4,mem.getMemberTel());
			pstmt.setString(5,mem.getMemberAddress());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;
	}


	/** 마이페이지(내정보 수정) DAO
	 * @param conn
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int myPage(Connection conn, Member mem) throws Exception {
		int result = 0;

		try {
			String sql = prop.getProperty("myPage");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,mem.getMemberNickname());
			pstmt.setString(2,mem.getMemberTel());
			pstmt.setString(3,mem.getMemberAddress());
			pstmt.setInt(4,mem.getMemberNo());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;


	}

	/** 비밀번호 변경 DAO
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int changePw(String currentPw, String newPw, int memberNo, Connection conn) throws Exception{

		int result = 0;

		try {
			String sql = prop.getProperty("changePw");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, newPw);
			pstmt.setInt(2, memberNo);
			pstmt.setString(3, currentPw);
			
			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;


	}

	/** 회원 탈퇴 DAO
	 * @param memberPw
	 * @param memberNo
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int secession(String memberPw, int memberNo, Connection conn) throws Exception{
		
		
		int result = 0;

		try {
			String sql = prop.getProperty("secession");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, memberNo);
			pstmt.setString(2, memberPw);
			
			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;
	}

	/** 이메일 중복검사 DAO
	 * @param memberEmail
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int emailDupCheck(String memberEmail, Connection conn) throws Exception{
		
		int result = 0; // 결과 저장용 변수

		try {
			
			// SQL 얻어오기
			String sql = prop.getProperty("emailDupCheck");

			// pstmt 생성
			pstmt = conn.prepareStatement(sql);

			// 위치홀더에 알맞은 값 세팅
			pstmt.setString(1, memberEmail);
			
			// SQL(SELECT) 수행 후 결과 반환 받기
			rs = pstmt.executeQuery();
			
			// rs.next()로 조회결과를 확인
			if(rs.next()) result = rs.getInt(1); // 1번 컬럼 결과를 result에 대입

		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	/** 닉네임 중복검사 DAO
	 * @param memberNickname
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDupCheck(String memberNickname, Connection conn) throws Exception{
		int result = 0; // 결과 저장용 변수

		try {
			
			String sql = prop.getProperty("nicknameDupCheck");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberNickname);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) result = rs.getInt(1); 

		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	/** 회원 정보 조회 DAO
	 * @param memberEmail
	 * @param conn
	 * @return selectMember
	 * @throws Exception
	 */
	public Member selectOne(String memberEmail, Connection conn) throws Exception{
		
		Member selectMember = null;
		
		try {
			
			String sql = prop.getProperty("selectOne");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberEmail);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				selectMember = new Member();
				
				selectMember.setMemberEmail(		rs.getString(1));
				selectMember.setMemberNickname(		rs.getString(2));
				selectMember.setMemberTel(			rs.getString(3));
				selectMember.setMemberAddress(		rs.getString(4));
				selectMember.setEnrollDate(			rs.getString(5));
				
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return selectMember;
	}

	/** 회원 목록 조회 DAO
	 * @param conn
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectAll(Connection conn) throws Exception{
		List<Member> memberList = new ArrayList<Member>();
		
		try {
			String sql = prop.getProperty("selectAll");

			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Member mem = new Member();
				
				mem.setMemberNo(rs.getInt(1));
				mem.setMemberEmail(rs.getString(2));
				mem.setMemberNickname(rs.getString(3));
				
				memberList.add(mem);
				
			}
			
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		return memberList;
	}
}
