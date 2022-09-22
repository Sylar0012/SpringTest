package site.metacoding.test.web.dto.request.player;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerListDto {
	private Integer id;
	private Integer teamId;
	private String teamname;
	private String position;
	private String name;
	private Timestamp createdAt;
}
