package edu.kh.test.member.model.dao;

import static edu.kh.test.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.test.member.model.vo.Member;

public class MemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;
	
	public MemberDAO() {
		try {
			prop = new Properties();
			String filePath = MemberDAO.class.getResource("/edu/kh/test/sql/test-sql.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			
		}
	}

	/** 아이디 찾기 DAO
	 * @param conn
	 * @param mem
	 * @return findMember
	 * @throws Exception
	 */
	public Member findId(Connection conn, Member mem) throws Exception{
		
		Member findMember = null; // 결과 저장
		
		try {
			
			String sql = prop.getProperty("find");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberNickname());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				findMember = new Member();
				
				findMember.setMemberNo(rs.getInt("MEMBER_NO"));
				findMember.setMemberId(rs.getString("MEMBER_ID"));
				findMember.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				findMember.setMemberNickname(rs.getString("MEMBER_NICK"));
				findMember.setMemberTel(rs.getString("MEMBER_TEL"));
				findMember.setMemberAddress(rs.getString("MEMBER_ADDR"));
				findMember.setProfileImage(rs.getString("PROFILE_IMG"));
				findMember.setEnrollDate(rs.getString("ENROLL_DT"));
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return findMember;
	}

}
