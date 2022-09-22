package site.metacoding.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.domain.team.Team;
import site.metacoding.test.domain.team.TeamDao;

import site.metacoding.test.web.dto.request.team.TeamListDto;
import site.metacoding.test.web.dto.request.team.TeamSaveDto;


@RequiredArgsConstructor
@Service
public class TeamService {
	private final TeamDao teamDao;
	
	public List<TeamListDto> 팀목록보기(){
		List<TeamListDto> teamList = teamDao.findAll();
		return teamList;
	}
	
	public void 팀추가(TeamSaveDto teamSaveDto) {
		teamDao.insert(teamSaveDto);		
	}
	
	
	
}
