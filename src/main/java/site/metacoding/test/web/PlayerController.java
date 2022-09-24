package site.metacoding.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.domain.player.Player;
import site.metacoding.test.service.PlayerService;
import site.metacoding.test.web.dto.request.player.PlayerSaveDto;
import site.metacoding.test.web.dto.request.player.PlayerUpdateDto;
import site.metacoding.test.web.dto.request.team.TeamSaveDto;
import site.metacoding.test.web.dto.response.CMRespDto;
import site.metacoding.test.web.dto.response.player.OutPlayerListDto;
import site.metacoding.test.web.dto.response.player.PlayerListDto;
import site.metacoding.test.web.dto.response.team.TeamListDto;


@RequiredArgsConstructor
@Controller
public class PlayerController {
	
	private final PlayerService playerService;
	
	@GetMapping("/player/list")
	public String playerList(Model model) {
		List<PlayerListDto> playerList = playerService.선수목록보기();
		model.addAttribute("playerList",playerList);
		return "player/list";
	}
	
	@GetMapping("/player/saveForm")
	public String playerSaveForm(Model model) {
		List<PlayerListDto> playerList = playerService.선수목록보기();
		model.addAttribute("playerList",playerList);
		return "player/saveForm";
	}
	
	@PostMapping("/player/save")
	public @ResponseBody CMRespDto<?> playerSave(@RequestBody PlayerSaveDto playerSaveDto){
		playerService.선수추가(playerSaveDto);
		return new CMRespDto<>(1, "선수 등록 성공", null);
	}
	
	@GetMapping("/player/updateForm/{id}")
	public String playerUpdateForm(@PathVariable Integer id, Model model) {
		List<PlayerListDto> playerList = playerService.선수목록보기();
		Player player = playerService.선수한명보기(id);
		model.addAttribute("playerList",playerList);
		model.addAttribute("player",player);
		return "player/updateForm";
	}
	
	@PutMapping("/player/update/{id}")
	public @ResponseBody CMRespDto<?> playerUpdate(@PathVariable Integer id, @RequestBody PlayerUpdateDto playerUpdateDto){
		Player playerPS = playerService.선수한명보기(id);
		playerService.선수수정(id, playerUpdateDto);
		return new CMRespDto<>(1, "선수 수정 성공", null);
	}
	
	@DeleteMapping("/player/delete/{id}")
	public @ResponseBody CMRespDto<?> playerDelete(@PathVariable Integer id){
		playerService.선수삭제(id);
		return new CMRespDto<>(1, "선수 삭제 성공", null);
	}
}
