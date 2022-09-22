package site.metacoding.test.domain.stadium;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stadium {
	private Integer id;
	private String name;
	private Timestamp createdAt;
}
