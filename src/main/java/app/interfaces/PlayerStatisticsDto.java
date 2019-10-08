package app.interfaces;

import java.util.List;

import app.core.Player;


public class PlayerStatisticsDto {

	private  final Player player;

	private final MatchWinRates winRates;

	private  final List<PlayerMatchDto> matches;

	PlayerStatisticsDto(Player player, MatchWinRates winRates, List<PlayerMatchDto> matches) {

		this.player = player;
		this.winRates = winRates;
		this.matches = matches;
	}

	public Player getPlayer() {

		return player;
	}

	public List<PlayerMatchDto> getMatches() {

		return matches;
	}

	public MatchWinRates getWinRates() {

		return winRates;
	}
}
