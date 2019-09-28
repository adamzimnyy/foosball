package app.interfaces;

import java.time.LocalDateTime;

import app.core.Team;


class MatchDto {

	private final LocalDateTime date;

	private final Team team;

	private final boolean victory;

	public MatchDto(LocalDateTime date, Team team, boolean victory) {

		this.date = date;
		this.team = team;
		this.victory = victory;
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
}
