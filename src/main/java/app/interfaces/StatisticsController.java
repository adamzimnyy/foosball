package app.interfaces;

import static app.core.Team.BLUE;
import static app.core.Team.RED;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.Player;
import app.core.Team;
import app.domain.Match;
import app.domain.MatchRepository;


@RestController
@RequestMapping("/stats")
public class StatisticsController {

	@Autowired
	private MatchRepository matchRepository;

	@GetMapping
	public List<PlayerStatisticsDto> getAllStatistics() {

		List<Match> allMatches = matchRepository.findAll();

		return Arrays.stream(Player.values())
			.map(player -> createStatistics(player, allMatches))
			.collect(Collectors.toList());
	}

	private PlayerStatisticsDto createStatistics(Player player, List<Match> allMatches) {

		List<MatchDto> matches = allMatches.stream()
			.filter(match -> wasParticipating(player, match))
			.map(match -> toMatchDto(player, match)).collect(Collectors.toList());

		MatchWinRates winRates = createWinRates(matches);

		return new PlayerStatisticsDto(player, winRates, matches);
	}

	private MatchWinRates createWinRates(List<MatchDto> matches) {

		int totalMatches = matches.size();
		int totalVictories = (int) matches.stream().filter(MatchDto::isVictory).count();
		float winPercentage = totalMatches > 0 ? totalVictories / (float) totalMatches : 0;
		int redSideGames = (int) matches.stream().filter(matchDto -> matchDto.getTeam() == RED).count();
		int redSideVictories = (int) matches.stream().filter(matchDto -> matchDto.getTeam() == RED && matchDto.isVictory()).count();
		int blueSideGames = (int) matches.stream().filter(matchDto -> matchDto.getTeam() == BLUE).count();
		int blueSideVictories = (int) matches.stream().filter(matchDto -> matchDto.getTeam() == BLUE && matchDto.isVictory()).count();

		return new MatchWinRates(
			totalMatches,
			totalVictories,
			winPercentage,
			redSideGames,
			redSideVictories,
			blueSideGames,
			blueSideVictories
		);
	}

	private boolean wasParticipating(Player player, Match match) {

		return match.getRedTeam().contains(player) || match.getBlueTeam().contains(player);
	}

	private MatchDto toMatchDto(Player player, Match match) {

		Team team = match.getBlueTeam().contains(player) ? Team.BLUE : RED;
		return new MatchDto(match.getDate(), team, match.getWinner() == team);
	}
}
