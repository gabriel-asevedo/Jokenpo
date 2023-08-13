package entities;

import java.util.Random;

public class Jokenpo {

	private Integer playerNumber;
	private Integer botNumber;
	private Integer playerPoints;
	private Integer botPoints;

	private ChoiceConverter choiceConverter;

	public Jokenpo() {
		this.playerPoints = 0;
		this.botPoints = 0;
	}

	public Integer getPlayerNumber() {
		return playerNumber;
	}

	public Integer getBotNumber() {
		return botNumber;
	}

	public Integer getPlayerPoints() {
		return playerPoints;
	}

	public Integer getBotPoints() {
		return botPoints;
	}

	public ChoiceConverter getChoiceConverter() {
		return choiceConverter;
	}

	public Integer game() {
		return playerNumber.equals(botNumber) ? null : 
			(playerNumber.equals(1) && botNumber.equals(3)) || 
			(playerNumber.equals(2) && botNumber.equals(1)) || 
			(playerNumber.equals(3) && botNumber.equals(2)) ? 1 : 2;
	}

	public void playRound(Integer playerChoice) {
		this.playerNumber = playerChoice;
		this.botNumber = new Random().nextInt(3) + 1;

		Integer result = game();

		if (result != null) {
			if (result.equals(1)) {
				playerWins();
			} else {
				botWins();
			}
		}
	}

	public void playerWins() {
		playerPoints++;
	}

	public void botWins() {
		botPoints++;
	}

	public String gameResult() {
		Integer result = game();
		String winner = (result == null) ? "Tied game!" : (result.equals(1)) ? "Player Wins!" : "Bot Wins!";

		StringBuilder sb = new StringBuilder();
		sb.append("\n" + winner + "\n");
		sb.append("\nYour choice:\t" + ChoiceConverter.playerConverter(playerNumber));
		sb.append("\nBot choice:\t" + ChoiceConverter.botConverter(botNumber));

		return sb.toString();
	}

	public String score() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n//// Player Points:\t" + playerPoints + " ////");
		sb.append("\n//// Bot Points:\t" + botPoints + " ////");

		return sb.toString();
	}
}
