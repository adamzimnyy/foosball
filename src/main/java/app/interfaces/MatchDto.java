package app.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import app.core.Player;
import app.core.Team;


public class MatchDto {

	private final LocalDateTime date;
	private final List<Player> redTeam;
	private final List<Player> blueTeam;
	private final Team winner;

	MatchDto(LocalDateTime date, List<Player> redTeam, List<Player> blueTeam, Team winner) {

		this.date = date;
		this.redTeam = redTeam;
		this.blueTeam = blueTeam;
		this.winner = winner;
	}

	public LocalDateTime getDate() {

		return date;
	}

	public List<Player> getRedTeam() {

		return redTeam;
	}

	public List<Player> getBlueTeam() {

		return blueTeam;
	}

	public Team getWinner() {

		return winner;
	}
}
