package app.interfaces;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Match;
import app.domain.MatchRepository;


@RestController
@RequestMapping("/match")
public class SaveMatchController {

	@Autowired
	private MatchRepository matchRepository;

	@PostMapping
	private ResponseEntity saveMatch(@RequestBody MatchForm form){

		Match match = new Match();

		match.setBlueTeam(form.getBlueTeam());
		match.setRedTeam(form.getRedTeam());
		match.setWinner(form.getWinner());
		match.setDate(LocalDateTime.now());

		matchRepository.save(match);

		return ResponseEntity.ok().build();
	}
}
