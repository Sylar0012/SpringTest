package site.metacoding.test.domain.team;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.test.web.dto.request.team.TeamUpdateDto;

@Getter
@Setter
public class Team {
	private Integer id;
	private Integer stadiumId;
	private String name;
	private Timestamp createdAt;
	
	public void update (TeamUpdateDto teamUpdateDto) {
		this.stadiumId = teamUpdateDto.getStadiumId();
		this.name = teamUpdateDto.getName();
	}
}
