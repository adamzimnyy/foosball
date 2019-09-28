package app.interfaces;

import java.util.List;

import app.core.Player;


public class PlayerStatisticsDto {

	private  final Player player;

	private final MatchWinRates winRates;

	private  final List<MatchDto> matches;

	PlayerStatisticsDto(Player player, MatchWinRates winRates, List<MatchDto> matches) {

		this.player = player;
		this.winRates = winRates;
		this.matches = matches;
	}

	public Player getPlayer() {

		return player;
	}

	public List<MatchDto> getMatches() {

		return matches;
	}

	public MatchWinRates getWinRates() {

		return winRates;
	}
}
