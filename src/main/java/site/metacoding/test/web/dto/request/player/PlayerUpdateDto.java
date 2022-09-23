package site.metacoding.test.web.dto.request.player;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerUpdateDto {
	private Integer id;
	private Integer teamId;
	private String name;
	private String position;
}
