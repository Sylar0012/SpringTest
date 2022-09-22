package site.metacoding.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.service.PlayerService;
import site.metacoding.test.web.dto.request.player.PlayerListDto;
import site.metacoding.test.web.dto.request.player.PlayerSaveDto;
import site.metacoding.test.web.dto.request.team.TeamListDto;
import site.metacoding.test.web.dto.request.team.TeamSaveDto;
import site.metacoding.test.web.dto.response.CMRespDto;


@RequiredArgsConstructor
@Controller
public class PlayerController {
	
	private final PlayerService playerService;
	
	@GetMapping("/player/playerList")
	public String playerList(Model model) {
		List<PlayerListDto> playerList = playerService.선수목록보기();
		model.addAttribute("playerList",playerList);
		return "/player/playerList";
	}
	
	@GetMapping("/player/playerSaveForm")
	public String playerSaveForm(Model model) {
		List<PlayerListDto> playerList = playerService.선수목록보기();
		model.addAttribute("playerList",playerList);
		return "/player/playerSaveForm";
	}
	
	@PostMapping("/player/playerSave")
	public @ResponseBody CMRespDto<?> teamSave(@RequestBody PlayerSaveDto playerSaveDto){
		playerService.선수추가(playerSaveDto);
		return new CMRespDto<>(1, "팀 등록 성공", null);
	}

}
