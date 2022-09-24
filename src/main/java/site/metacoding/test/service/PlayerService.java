package site.metacoding.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.domain.player.Player;
import site.metacoding.test.domain.player.PlayerDao;
import site.metacoding.test.web.dto.request.player.PlayerSaveDto;
import site.metacoding.test.web.dto.request.player.PlayerUpdateDto;
import site.metacoding.test.web.dto.response.player.PlayerListDto;



@RequiredArgsConstructor
@Service
public class PlayerService {
	
	private final PlayerDao playerDao;
	
	public List<PlayerListDto> 선수목록보기(){
		List<PlayerListDto> playerList = playerDao.findAll();
		return playerList;
	}
	
	public void 선수추가(PlayerSaveDto playerSaveDto) {
		playerDao.insert(playerSaveDto);
	}
	
	public Player 선수한명보기(Integer id) {
		Player player = playerDao.findById(id);
		return player;
	}
	
	public void 선수수정(Integer id, PlayerUpdateDto playerUPdateDto) {
		Player playerPS = playerDao.findById(id);
		playerPS.update(playerUPdateDto);
		playerDao.update(playerPS);
	}
	
	public void 선수삭제(Integer id) {
		playerDao.deleteById(id);
	}
	
}
