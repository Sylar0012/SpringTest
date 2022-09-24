package site.metacoding.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.domain.team.Team;
import site.metacoding.test.domain.team.TeamDao;
import site.metacoding.test.web.dto.request.team.TeamSaveDto;
import site.metacoding.test.web.dto.request.team.TeamUpdateDto;
import site.metacoding.test.web.dto.response.team.TeamListDto;
import site.metacoding.test.web.dto.response.team.TeamPositionDto;


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
	
	public List<TeamPositionDto> 팀별포지션목록(){
		List<TeamPositionDto> teamPositionList = teamDao.findPlayerByPosition();
		return teamPositionList;
	}
	
	public Team 한팀보기(Integer id) {
		Team team =  teamDao.findById(id);
		return team;	
	}
	
	public void 팀수정(Integer id,TeamUpdateDto teamUpdateDto) {
		Team teamPS = teamDao.findById(id);
		teamPS.update(teamUpdateDto);
		teamDao.update(teamPS);
	}
	
	public void 팀삭제(Integer id) {
		teamDao.deleteById(id);
	}
}
