package site.metacoding.test.web.dto.request.outPlayer;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutPlayerSaveDto {
	private Integer playerId;
	private String reason;
	private Timestamp createdAt;
}
