package edu.pnu.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Builder // 객체 생성
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id 자동증가
	private Long seq;
	private String title;
	private String content;
	private Date createDate;
	private Long cnt;

}
