package edu.kh.community.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board {
	
	private int boardNo; // 게시글 번호
	private String boardTitle; // 게시글 제목
	private String memberNickname; // 작성자
	private String createDate; // 작성일
	private int readCount; // 조회수
	private String thumbnail; // 썸네일

}
