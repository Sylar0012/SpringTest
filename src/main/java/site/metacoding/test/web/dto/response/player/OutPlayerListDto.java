package site.metacoding.test.web.dto.response.player;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutPlayerListDto {
	private Integer id;
	private Integer teamId;
	private String teamname;
	private String position;
	private String name;
	private String reason;
	private Timestamp createdAt;
}
