package app.interfaces;

public class MatchWinRates {

	private final int totalMatches;
	private  final int totalVictories;
	private  final float winPercent;
	private  final int redSideGames;
	private  final int redSideVictories;
	private  final int blueSideGames;
	private  final int blueSideVictories;

	MatchWinRates(int totalMatches,
		int totalVictories,
		float winPercent,
		int redSideGames,
		int redSizeVictories,
		int blueSideGames,
		int blueSideVictories) {

		this.totalMatches = totalMatches;
		this.totalVictories = totalVictories;
		this.winPercent = winPercent;
		this.redSideGames = redSideGames;
		this.redSideVictories = redSizeVictories;
		this.blueSideGames = blueSideGames;
		this.blueSideVictories = blueSideVictories;
	}

	public int getTotalMatches() {

		return totalMatches;
	}

	public int getTotalVictories() {

		return totalVictories;
	}

	public float getWinPercent() {

		return winPercent;
	}

	public int getRedSideGames() {

		return redSideGames;
	}

	public int getRedSideVictories() {

		return redSideVictories;
	}

	public int getBlueSideGames() {

		return blueSideGames;
	}

	public int getBlueSideVictories() {

		return blueSideVictories;
	}
}
