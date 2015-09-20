import java.util.Random;

public class RandomPlayer implements Player {
	private String playerName;
	private Move playerMove;
	
	public String getName() {
		return this.playerName = "Random Player";
	}

	public String getDescription() {
		return "Random Player is random.";
	}

	public Move takeTurn(int num, Random rand) {
		int n = rand.nextInt(2);
		
		if (n == 1) {
			return this.playerMove = Move.WAR;
		}
		
		else {
			return this.playerMove = Move.PEACE;
		}
	}

	public void recordOpponentMove(int num, Move move) {
		return;
	}
}
