package edu.kh.community.board.model.dao;

import static edu.kh.community.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.community.board.model.vo.Reply;

public class ReplyDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;

	public ReplyDAO() {

		try {
			prop = new Properties();
			String filePath = BoardDAO.class.getResource("/edu/kh/community/sql/reply-sql.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 댓글 목록 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return rList
	 * @throws Exception
	 */
	public List<Reply> selectReplyList(Connection conn, int boardNo) throws Exception{

		List<Reply> rList = new ArrayList<>();

		try {

			String sql = prop.getProperty("selectReplyList");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				Reply r = new Reply();

				r.setReplyNo( 		rs.getInt(1) );
				r.setReplyContent( 	rs.getString(2));
				r.setCreateDate( 	rs.getString(3));
				r.setBoardNo( 		rs.getInt(4));
				r.setMemberNo(		rs.getInt(5));
				r.setMemberNickname(rs.getString(6));
				r.setProfileImage(	rs.getString(7));

				rList.add(r);

			}


		} finally {
			close(rs);
			close(pstmt);
		}

		return rList;
	}

	/** 댓글 등록 DAO
	 * @param conn
	 * @param r
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Connection conn, Reply r) throws Exception{

		int result = 0;

		try {
			String sql = prop.getProperty("insertReply");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, r.getReplyContent());
			pstmt.setInt(2, r.getMemberNo());
			pstmt.setInt(3, r.getBoardNo());

			result = pstmt.executeUpdate();


		} finally {
			close(pstmt);
		}

		return result;
	}

	/** 댓글 삭제 DAO
	 * @param conn
	 * @param replyNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteReply(Connection conn, int replyNo) throws Exception{
		
		int result = 0;

		try {
			String sql = prop.getProperty("deleteReply");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, replyNo);

			result = pstmt.executeUpdate();


		} finally {
			close(pstmt);
		}
		

		return result;
	}

	/** 댓글 수정 DAO
	 * @param conn
	 * @param replyNo
	 * @param replyContent
	 * @return result
	 * @throws Exception
	 */
	public int updateReply(Connection conn, int replyNo, String replyContent) throws Exception{
		
		
		int result = 0;

		try {
			String sql = prop.getProperty("updateReply");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, replyContent);
			pstmt.setInt(2, replyNo);

			result = pstmt.executeUpdate();


		} finally {
			close(pstmt);
		}
		

		return result;
	}



}
