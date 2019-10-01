package app.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import app.core.Player;
import app.core.Team;


class MatchDto {

	private final LocalDateTime date;

	private final Team team;

	private final boolean victory;
	
	private final List<Player> redTeam;
	private final List<Player> blueTeam;

	MatchDto(LocalDateTime date, Team team, boolean victory, List<Player> redTeam, List<Player> blueTeam) {

		this.date = date;
		this.team = team;
		this.victory = victory;
		this.redTeam = redTeam;
		this.blueTeam = blueTeam;
	}

	public LocalDateTime getDate() {

		return date;
	}

	public Team getTeam() {

		return team;
	}

	public boolean isVictory() {

		return victory;
	}

	public List<Player> getRedTeam() {

		return redTeam;
	}

	public List<Player> getBlueTeam() {

		return blueTeam;
	}
}
