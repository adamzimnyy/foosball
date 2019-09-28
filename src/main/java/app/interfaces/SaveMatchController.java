package app.interfaces;

import static java.util.stream.Collectors.toList;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Match;
import app.domain.MatchRepository;


@RestController
@RequestMapping("/match")
public class SaveMatchController {
	
	private final MatchFormValidator validator;
	private final MatchRepository matchRepository;

	@Autowired
	public SaveMatchController(MatchFormValidator validator, MatchRepository matchRepository) {

		this.validator = validator;
		this.matchRepository = matchRepository;
	}

	@InitBinder
	void initBinder(WebDataBinder binder) {

		binder.setValidator(validator);
	}

	@PostMapping
	private ResponseEntity saveMatch(@Valid @RequestBody MatchForm form, BindingResult result) {

		if (result.hasErrors()) {
			return ResponseEntity.badRequest()
				.body(result.getAllErrors()
					.stream()
					.map(DefaultMessageSourceResolvable::getCode)
					.collect(toList())
				);
		}

		Match match = new Match();

		match.setBlueTeam(form.getBlueTeam());
		match.setRedTeam(form.getRedTeam());
		match.setWinner(form.getWinner());
		match.setDate(LocalDateTime.now());

		matchRepository.save(match);

		return ResponseEntity.ok().build();
	}
}
