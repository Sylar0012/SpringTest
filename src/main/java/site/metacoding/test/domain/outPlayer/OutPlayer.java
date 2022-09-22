package site.metacoding.test.domain.outPlayer;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter	
public class OutPlayer {
	private Integer id;
	private Integer teamId;
	private String reason;
	private Timestamp createdAt;
}
