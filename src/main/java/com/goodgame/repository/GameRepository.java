package com.goodgame.repository;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.goodgame.entity.GameEntity;

public interface GameRepository extends JpaRepository<GameEntity, Long>,JpaSpecificationExecutor<GameEntity> {
	
//	@Query(nativeQuery = true,value = "SELECT * FROM game WHERE status = 1")
//	Page<GameEntity> findAllActive(Pageable pageable);
	
	GameEntity findOneByName(String name);
	
	@Query("SELECT g FROM GameEntity g JOIN g.categories c WHERE CONCAT(g.name, ' ',c.name,' ' ,g.platform.name, ' ') LIKE %?1%")
	List<GameEntity> search(String keyword);
	
	List<GameEntity> findTop12ByOrderByCreateDateDesc();
	
	@Query(nativeQuery = true, value = "SELECT count(*) FROM game WHERE status = 1")
	long countAppear();
	
	@Query(nativeQuery = true, value = "SELECT count(*) FROM game WHERE status = 0")
	long countDelete();
	
	List<GameEntity> findByNameIn(Set<String> gameId);
	
	List<GameEntity> findByIdIn(Set<Long> gameId);
}
