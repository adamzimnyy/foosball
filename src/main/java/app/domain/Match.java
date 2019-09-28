package app.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import app.core.Player;
import app.core.Team;


@Entity
public class Match {

	@Id @GeneratedValue 
	private Long id;
	
	@ElementCollection
	private List<Player> redTeam;

	@ElementCollection
	private List<Player> blueTeam;

	@Enumerated(EnumType.STRING)
	private Team winner;

	private LocalDateTime date;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public List<Player> getRedTeam() {

		return redTeam;
	}

	public void setRedTeam(List<Player> redTeam) {

		this.redTeam = redTeam;
	}

	public List<Player> getBlueTeam() {

		return blueTeam;
	}

	public void setBlueTeam(List<Player> blueTeam) {

		this.blueTeam = blueTeam;
	}

	public Team getWinner() {

		return winner;
	}

	public void setWinner(Team winner) {

		this.winner = winner;
	}

	public void setDate(LocalDateTime date) {

		this.date = date;
	}

	public LocalDateTime getDate() {

		return date;
	}
}
