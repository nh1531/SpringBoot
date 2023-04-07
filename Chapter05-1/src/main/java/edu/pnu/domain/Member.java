package edu.pnu.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "boardList")
@Entity
public class Member {
	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	private String password;
	private String name;
	private String role;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	private List<Board1> boardList = new ArrayList<Board1>();

}
