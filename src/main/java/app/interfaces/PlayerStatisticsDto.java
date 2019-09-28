package app.interfaces;

import java.util.List;

import app.core.Player;


public class PlayerStatisticsDto {

	private  final Player player;


	private final MatchWinrates winrates;

	private  final List<MatchDto> matches;

	PlayerStatisticsDto(Player player, MatchWinrates winrates, List<MatchDto> matches) {

		this.player = player;
		this.winrates = winrates;
		this.matches = matches;
	}

	public Player getPlayer() {

		return player;
	}

	public List<MatchDto> getMatches() {

		return matches;
	}

	public MatchWinrates getWinrates() {

		return winrates;
	}
}
