package app.interfaces;

public class MatchWinrates {

	private final int totalMatches;
	private  final int totalVictories;
	private  final float winPercent;
	private  final int redSideGames;
	private  final int redSizeVictories;
	private  final int blueSideGames;
	private  final int blueSideVictories;

	public MatchWinrates(int totalMatches,
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
		this.redSizeVictories = redSizeVictories;
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

	public int getRedSizeVictories() {

		return redSizeVictories;
	}

	public int getBlueSideGames() {

		return blueSideGames;
	}

	public int getBlueSideVictories() {

		return blueSideVictories;
	}
}
