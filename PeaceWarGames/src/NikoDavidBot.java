import java.util.Random;

public class NikoDavidBot implements Player {
	private String playerName;
	private Move playerMove;
	private Move oppMove;
	
	public String getName() {
		return this.playerName = "Niko-David Bot";
	}

	public String getDescription() {
		return "Niko-David Bot utilizes a tit-for-tat strategy.";
	}

	public Move takeTurn(int num, Random rand) {
		if (num == 1) {
			return this.playerMove = Move.PEACE;
		}
		else {
			return this.playerMove = this.oppMove;
		}
	}

	public void recordOpponentMove(int num, Move move) {
		this.oppMove = move;
	}
}
