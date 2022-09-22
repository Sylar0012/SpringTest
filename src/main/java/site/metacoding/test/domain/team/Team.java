package site.metacoding.test.domain.team;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team {
	private Integer id;
	private Integer stadiumId;
	private String name;
	private Timestamp createdAt;
}
