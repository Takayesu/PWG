import java.util.Random;

public class PeaceWarGame{
	public Player player1;
	public Player player2;
	public Random rand;
	private int player1Score;
	private int player2Score;
	public int numRounds;

	public PeaceWarGame (Player player1, Player player2, int numRounds) {
		this.player1 = player1;
		this.player2 = player2;
		this.rand = new Random();
		this.player1Score = 0;
		this.player2Score = 0;
		this.numRounds = numRounds;
	}

	public void play() {
		for(int i = 1; i <= this.numRounds; i++) {
			System.out.println("Year " + i);
			System.out.println("Player 1 score: " + this.player1Score);
			System.out.println("Player 2 score: " + this.player2Score + "\n");

			Move p1Move = this.player1.takeTurn(i, this.rand);
			Move p2Move = this.player2.takeTurn(i, this.rand);
			player1.recordOpponentMove(i, p2Move);
			player2.recordOpponentMove(i, p1Move);

			System.out.println(this.player1.getName() + " chose " + Move.toString(p1Move) + ".");
			System.out.println(this.player2.getName() + " chose " + Move.toString(p1Move) + ".");

			if (p1Move.equals(p2Move)) {
				if (Move.toString(p1Move).equals("war")) {
					System.out.println("Grab yer weapons! We're all going to war!\n");
					this.player1Score += 1;
					this.player2Score += 1;
				} 
				else {
					System.out.println("Let there be peace throughout the land.\n");
					this.player1Score += 3;
					this.player2Score += 3;
				}
			}
			else {
				if (Move.toString(p1Move).equals("peace")) {
					System.out.println("Player 2 crushes Player 1!");
					this.player1Score += 0;
					this.player2Score += 5;
				}
				else {
					System.out.println("Player 1 crushes Player 2!");
					this.player1Score += 0;
					this.player1Score += 5;
				}
			}
		}
	}

	public int getPlayer1Score() {
		return this.player1Score;
	}

	public int getPlayer2Score() {
		return this.player2Score;
	}

	public static void main(String[] args) {
		int roundNum = Integer.parseInt(args[0]);
		String game = args[1];
		PeaceWarGame pwg = null;
				
		if (game.equals("computer")) {
			Player ai = new NikoDavidBot();
			Player randy = new RandomPlayer(); 
			pwg = new PeaceWarGame(ai, randy, roundNum);
			pwg.play();
		}
		else if (game.equals("player")) {
			Player ai = new NikoDavidBot();
			Player human = new HumanPlayer(); 
			pwg = new PeaceWarGame(ai, human, roundNum);
			pwg.play();
		}
		
		System.out.println("Final Scores");
		System.out.println("Player 1: " + pwg.getPlayer1Score());
		System.out.println("Player 2: " + pwg.getPlayer2Score());
	}
}
