package app.interfaces;

import java.util.List;

import app.core.Player;
import app.core.Team;


public class MatchForm {

	private List<Player> blueTeam;
	private List<Player> redTeam;
	
	private Team winner;

	public void setBlueTeam(List<Player> blueTeam) {

		this.blueTeam = blueTeam;
	}

	public void setRedTeam(List<Player> redTeam) {

		this.redTeam = redTeam;
	}

	public void setWinner(Team winner) {

		this.winner = winner;
	}

	List<Player> getBlueTeam() {

		return blueTeam;
	}

	public List<Player> getRedTeam() {

		return redTeam;
	}

	public Team getWinner() {

		return winner;
	}
}
