package edu.kh.test.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Lombok 라이브러리
// - VO(Value Object) 또는 DTO(Data Transfer Object)에
//	 작성되는 공통 코드(getter/setter/생성자)를 자동으로 추가해주는 라이브러리
// 이클립스 끄고 롬복추가 후 lib에 추가

@Getter // getter 자동 추가
@Setter // setter 자동 추가
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드 초기화하는 매개변수 생성자
@ToString // toStriong
public class Member {
	
	private int memberNo;
	private String memberId;
	private String memberEmail;
	private String memberPw;
	private String memberNickname;
	private String memberTel;
	private String memberAddress;
	private String profileImage;
	private String enrollDate;
	private String secessionFlag;
	

}