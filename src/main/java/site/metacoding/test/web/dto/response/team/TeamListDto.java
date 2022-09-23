package site.metacoding.test.web.dto.response.team;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamListDto {
	private Integer id;
	private Integer stadiumId;
	private String stadiumName;
	private String name;
	private Timestamp createdAt;
}