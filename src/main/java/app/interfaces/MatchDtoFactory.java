package app.interfaces;

import org.springframework.stereotype.Component;

import app.domain.Match;


@Component
class MatchDtoFactory {

	MatchDto create(Match match) {

		return new MatchDto(match.getDate(),match.getRedTeam(), match.getBlueTeam(), match.getWinner());
	}
}
