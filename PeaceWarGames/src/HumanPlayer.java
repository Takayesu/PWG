import java.util.Random;
import java.util.Scanner;

public class HumanPlayer implements Player {
	private String playerName;
	private Move playerMove;
	
	public String getName() {
		return this.playerName = "Human Player";
	}

	public String getDescription() {
		return "Human Player is based on user input.";
	}

	public Move takeTurn(int num, Random rand) {
		String s2;
		Scanner in;
		do {
			System.out.println("What is thy bidding?");
			in = new Scanner(System.in);
			String s1 = in.nextLine();
			s2 = s1.toLowerCase();
		} while(!(s2.equals("war") || s2.equals("peace")));
		
		if (s2.equals("war")) {
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