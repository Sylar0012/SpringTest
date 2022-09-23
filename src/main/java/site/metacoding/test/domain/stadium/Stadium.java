package site.metacoding.test.domain.stadium;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.test.web.dto.request.stadium.StadiumUpdateDto;

@Getter
@Setter
public class Stadium {
	private Integer id;
	private String name;
	private Timestamp createdAt;
	
	public void update(StadiumUpdateDto stadiumUpdateDto) {
		this.name = stadiumUpdateDto.getName();
	}
}
