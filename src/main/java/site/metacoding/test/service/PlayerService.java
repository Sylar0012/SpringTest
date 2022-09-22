package site.metacoding.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.test.domain.player.PlayerDao;
import site.metacoding.test.web.dto.request.player.PlayerListDto;
import site.metacoding.test.web.dto.request.player.PlayerSaveDto;



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
}
