package site.metacoding.test.domain.team;

import java.util.List;

public interface TeamDao {
	public void insert(Team team);
	public List<Team> findAll();
	public Team findById(Integer id);
	public void update(Team team);
	public void deleteById(Integer id);
}
