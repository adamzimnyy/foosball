package app.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MatchRepository extends JpaRepository<Match, Long> {

	List<Match> findTop100ByOrderByDateDesc();
}
