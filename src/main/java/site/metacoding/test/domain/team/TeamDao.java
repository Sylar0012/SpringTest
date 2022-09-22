package site.metacoding.test.domain.team;

import java.util.List;

import site.metacoding.test.web.dto.request.team.TeamListDto;
import site.metacoding.test.web.dto.request.team.TeamSaveDto;

public interface TeamDao {
	public void insert(TeamSaveDto teamSaveDto);
	public List<TeamListDto> findAll();
	public Team findById(Integer id);
	public void update(Team team);
	public void deleteById(Integer id);
}
