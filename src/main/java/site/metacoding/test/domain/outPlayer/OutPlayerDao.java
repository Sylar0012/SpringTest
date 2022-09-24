package site.metacoding.test.domain.outPlayer;

import java.util.List;

import site.metacoding.test.web.dto.request.outPlayer.OutPlayerSaveDto;
import site.metacoding.test.web.dto.response.player.OutPlayerListDto;

public interface OutPlayerDao {
	public void insert(OutPlayerSaveDto outPlayerSaveDto);
	public List<OutPlayerListDto> findAll();
	public List<OutPlayerListDto> findAllByTeamId(Integer teamId);
	public OutPlayer findById(Integer id);
	public void update(OutPlayer outPlayer);
	public void deleteById(Integer id);
}
