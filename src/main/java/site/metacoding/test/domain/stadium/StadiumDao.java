package site.metacoding.test.domain.stadium;

import java.util.List;

public interface StadiumDao {
	public void insert(Stadium stardium);
	public List<Stadium> findAll();
	public Stadium findById(Integer id);
	public void update(Stadium stardium);
	public void deleteById(Integer id);
}
