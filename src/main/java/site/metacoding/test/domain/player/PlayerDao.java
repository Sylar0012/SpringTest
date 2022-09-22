package site.metacoding.test.domain.player;

import java.util.List;

import site.metacoding.test.web.dto.request.player.PlayerListDto;
import site.metacoding.test.web.dto.request.player.PlayerSaveDto;

public interface PlayerDao {
	public void insert(PlayerSaveDto playerSaveDto);
	public List<PlayerListDto> findAll();
	public Player findById(Integer id);
	public void update(Player player);
	public void deleteById(Integer id);
}
