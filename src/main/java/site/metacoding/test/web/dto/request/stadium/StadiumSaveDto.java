package site.metacoding.test.web.dto.request.stadium;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StadiumSaveDto {
	private String name;
	private Timestamp createdAt;
}
