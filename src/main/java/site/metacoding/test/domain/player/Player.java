package site.metacoding.test.domain.player;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.test.web.dto.request.player.PlayerUpdateDto;

@Getter
@Setter
public class Player {
	private Integer id;
	private String name;
	private Integer teamId;
	private String position;
	private Timestamp createdAt;
	
	public void update(PlayerUpdateDto playerUPdateDto) {
		this.name = playerUPdateDto.getName();
		this.teamId = playerUPdateDto.getTeamId();
		this.position = playerUPdateDto.getPosition();
	}
}
