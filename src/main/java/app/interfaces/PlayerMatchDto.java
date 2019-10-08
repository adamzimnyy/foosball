package app.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import app.core.Player;
import app.core.Team;


class PlayerMatchDto {

	private final MatchDto match;
	private final Team playerTeam;

	PlayerMatchDto(Team playerTeam, MatchDto match) {

		this.playerTeam = playerTeam;
		this.match = match;
	}

	public LocalDateTime getDate() {

		return match.getDate();
	}

	Team getPlayerTeam() {

		return playerTeam;
	}

	boolean isVictory() {

		return playerTeam == match.getWinner();
	}

	public List<Player> getRedTeam() {

		return match.getRedTeam();
	}

	public List<Player> getBlueTeam() {

		return match.getBlueTeam();
	}
}
