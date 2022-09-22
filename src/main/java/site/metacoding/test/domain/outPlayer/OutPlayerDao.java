package site.metacoding.test.domain.outPlayer;

import java.util.List;

public interface OutPlayerDao {
	public void insert(OutPlayer outPlayer);
	public List<OutPlayer> findAll();
	public OutPlayer findById(Integer id);
	public void update(OutPlayer outPlayer);
	public void deleteById(Integer id);
}
