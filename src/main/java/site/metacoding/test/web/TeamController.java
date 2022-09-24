package site.metacoding.test.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.domain.team.Team;
import site.metacoding.test.service.TeamService;
import site.metacoding.test.web.dto.request.team.TeamSaveDto;
import site.metacoding.test.web.dto.request.team.TeamUpdateDto;
import site.metacoding.test.web.dto.response.CMRespDto;
import site.metacoding.test.web.dto.response.team.TeamListDto;
import site.metacoding.test.web.dto.response.team.TeamPositionDto;


@RequiredArgsConstructor
@Controller
public class TeamController {
	
	private final TeamService teamService;



	@GetMapping("/team/list")
	public String teamList(Model model) {
		List<TeamListDto> teamList = teamService.팀목록보기();
		model.addAttribute("teamList", teamList);
		return "team/list";
	}
	
	@GetMapping("/team/saveForm")
	public String teamSaveForm(Model model) {
		List<TeamListDto> teamList = teamService.팀목록보기();
		model.addAttribute("teamList", teamList);
		return"team/saveForm";
	}
	
	@PostMapping("/team/save")
	public @ResponseBody CMRespDto<?> teamSave(@RequestBody TeamSaveDto teamSaveDto){
		teamService.팀추가(teamSaveDto);
		return new CMRespDto<>(1, "팀 등록 성공", null);
	}
	
	@GetMapping("/team/positionList")
	public String teamPositionList(Model model) {
		List<TeamPositionDto> teamPositionList = teamService.팀별포지션목록();
		model.addAttribute("teamPositionList",teamPositionList);
		return "team/positionList";
	}
	
	@GetMapping("/team/updateForm/{id}")
	public String teamUpdateForm(@PathVariable Integer id, Model model) {
		List<TeamListDto> teamList = teamService.팀목록보기();
		Team team = teamService.한팀보기(id);
		model.addAttribute("teamList", teamList);
		model.addAttribute("team",team);
		return "/team/teamUpdateForm";
	}
	
	@PutMapping("/team/update/{id}")
	public @ResponseBody CMRespDto<?> teamUpdate(@PathVariable  Integer id, @RequestBody TeamUpdateDto teamUpdateDto){
		Team teamPS = teamService.한팀보기(id);
		teamService.팀수정(id, teamUpdateDto);
		return new CMRespDto<>(1, "팀 수정 성공", null);
	}
}
