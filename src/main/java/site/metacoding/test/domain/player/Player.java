package site.metacoding.test.domain.player;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
	private Integer id;
	private String name;
	private Integer teamId;
	private String position;
	private Timestamp createdAt;
}
