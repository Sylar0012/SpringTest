package site.metacoding.test.web.dto.request.team;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamUpdateDto {
	private Integer id;
	private Integer stadiumId;
	private String name;
}
