package com.globalit.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

  @Id @GeneratedValue
  private Long id;

  /* 이메일로 로그인할 수 있도록 함 */
  @Column(unique = true)
  private String email;

  /* nickname 으로 로그인할 수 있도록 함 */
  @Column(unique = true)
  private String nickname;

  /* 비밀번호 */
  private String password;

  /* email 인증절차 */
  private boolean emailVerified;

  /*
   email 을 검증할 때 사용할 token 값을
   DB 에 저장해 놓고 matching 하는지 여부 판단
  */
  private String emailCheckToken;

  /* 가입된 시간(날짜) 기록용 */
  private LocalDateTime joinedAt;

  /* 해당 계정의 기본 프로필 관련 정보(간단한 자기 소개) 저장용 */
  private String bio;

  private String url;

  /* 직업 */
  private String occupation;

  /* 주거주지 */
  private String location;

  /*
    String type 은 DB 에서 기본적으로
    VARCHAR type (255) 으로 mapping 됨
    255 보다 더 큰 경우, BLOB type 으로
    mapping 되도록 해야 함
  */
  @Lob @Basic(fetch = FetchType.EAGER)
  private String profileImage;

  /* 알림 설정 관련 */
  /*
    해당 내용이 변경된 (event 가 발생된) 경우
    아래의 멤버변수들의 값을 체크함
  */
  /* study 가 생성된 것을 email 로 알림 받을지 여부 */
  private boolean studyCreateByEmail;

  /* study 가 생성된 것을 web 으로 알림 받을지 여부 */
  private boolean studyCreateByWeb;

  /*
    study 가 운영하는 모임에 가입 신청한 결과를
    email 로 받을지 여부
  */
  private boolean studyEnrollmentResultByEmail;

  /*
    study 가 운영하는 모임에 가입 신청한 결과를
    Web 으로 받을지 여부
  */
  private boolean studyEnrollmentResultByWeb;

  /*
    study 에 대해서 변경된 정보들을
    email 로 받을지 여부
  */
  private boolean studyUpdatedByEmail;

  /*
    study 에 대해서 변경된 정보들을
    Web 으로 받을지 여부
  */
  private boolean studyUpdatedByWeb;

}
