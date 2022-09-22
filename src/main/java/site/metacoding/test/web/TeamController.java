package site.metacoding.test.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.domain.stadium.Stadium;
import site.metacoding.test.service.StadiumService;
import site.metacoding.test.service.TeamService;
import site.metacoding.test.web.dto.request.team.TeamListDto;
import site.metacoding.test.web.dto.request.team.TeamSaveDto;
import site.metacoding.test.web.dto.response.CMRespDto;


@RequiredArgsConstructor
@Controller
public class TeamController {
	
	private final TeamService teamService;
	private final StadiumService stadiumService;


	@GetMapping("/team/teamList")
	public String teamList(Model model) {
		List<TeamListDto> teamList = teamService.팀목록보기();
		model.addAttribute("teamList", teamList);
		return "/team/teamList";
	}
	
	@GetMapping("/team/teamSaveForm")
	public String teamSaveForm(Model model) {
		List<TeamListDto> teamList = teamService.팀목록보기();
		model.addAttribute("teamList", teamList);
		return"/team/teamSaveForm";
	}
	
	@PostMapping("/team/teamSave")
	public @ResponseBody CMRespDto<?> teamSave(@RequestBody TeamSaveDto teamSaveDto){
		teamService.팀추가(teamSaveDto);
		return new CMRespDto<>(1, "팀 등록 성공", null);
	}
}
