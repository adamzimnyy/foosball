package app.interfaces;

import static java.util.stream.Collectors.toList;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Match;
import app.domain.MatchRepository;


@RestController
@RequestMapping("/match")
public class MatchController {

	private final MatchFormValidator validator;
	private final MatchRepository matchRepository;
	private final MatchDtoFactory matchDtoFactory;

	@Autowired
	public MatchController(MatchFormValidator validator, MatchRepository matchRepository, MatchDtoFactory matchDtoFactory) {

		Assert.notNull(validator, "validator must not be null");
		Assert.notNull(matchRepository, "matchRepository must not be null");
		Assert.notNull(matchDtoFactory, "matchDtoFactory must not be null");

		this.validator = validator;
		this.matchRepository = matchRepository;
		this.matchDtoFactory = matchDtoFactory;
	}

	@InitBinder
	void initBinder(WebDataBinder binder) {

		binder.setValidator(validator);
	}

	@GetMapping
	private List<MatchDto> getAllMatches() {

		return matchRepository.findAll()
			.stream()
			.map(matchDtoFactory::create)
			.collect(toList());
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
