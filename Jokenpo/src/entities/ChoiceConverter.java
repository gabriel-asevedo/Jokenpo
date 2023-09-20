package entities;

public class ChoiceConverter {

	private static String playerChoice;
	private static String botChoice;

	public ChoiceConverter() {
	}

	public String getPlayerChoice() {
		return playerChoice;
	}

	public String getBotChoice() {
		return botChoice;
	}

	public static String playerConverter(Integer option) {
		if (option != null) {
			playerChoice = (option.equals(1)) ? "Rock" : (option.equals(2)) ? "Paper" : "Scissors";
		}
		return playerChoice;
	}

	public static String botConverter(Integer option) {
		if (option != null) {
			botChoice = (option.equals(1)) ? "Rock" : (option.equals(2)) ? "Paper" : "Scissors";
		}
		return botChoice;
	}

}
