package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Jokenpo;

//The code for this project was written by 'Gabriel Asevedo de Amorim'
//You can find more information about me on my LinkedIn profile: https://www.linkedin.com/in/gabriel-as-amorim/
public class Program {

	public static void main(String[] args) {
		Jokenpo jokenpo = new Jokenpo();
		Scanner sc = new Scanner(System.in);

		try {
			String option;

			do {
				System.out.println("\t\tJ O K E N P O");
				System.out.println("Make your choice:");
				System.out.print("(1) - Rock\n(2) - Paper\n(3) - Scissors\nR:");
				int playerChoice = sc.nextInt();

				while (non_existentNumber(playerChoice)) {
					System.out.println("Invalid option!");
					System.out.print("Only the following options are allowed: (1) - Rock, (2) - Paper, (3) - Scissors");
					System.out.print("\nTry again:");
					playerChoice = sc.nextInt();
				}

				jokenpo.playRound(playerChoice);

				System.out.println(jokenpo.gameResult());
				System.out.println(jokenpo.currentScore());
				System.out.print("\n" + currentStatus(jokenpo.getPlayerPoints(), jokenpo.getBotPoints()));

				System.out.print("\nWant to play again? ( y / n ): ");
				option = sc.next();

				while (!invalidDecision(option)) {
					System.out.print("Invalid decision, choose between (\"y\" - yes) and (\"n\" - no): ");
					option = sc.next();
				}

				System.out.println("//  //\t//  //\t//  //\t//  //\t//  //\t//  //\t//  //\n");

			} while (option.equalsIgnoreCase("y"));

		} catch (InputMismatchException e) {
			System.out.println("\n\t// Some data was entered incorrectly, stay tuned and try again. //\n");
		} catch (Exception e) {
			System.out.println("\n\t// An unexpected error occurred, feel free to play again. //\n");
		} finally {
			System.out.print("\n\tFinal Score");
			System.out.println(jokenpo.finalScore());
			System.out.println(finalStatus(jokenpo.getPlayerPoints(), jokenpo.getBotPoints()));

			sc.close();
		}
	}

	public static boolean non_existentNumber(Integer number) {
		Boolean invalidNumber = (number < 1 || number > 3) ? true : false;
		return invalidNumber;
	}

	public static boolean invalidDecision(String option) {
		Boolean invalidOption = (option.equalsIgnoreCase("y") || option.equalsIgnoreCase("n")) ? true : false;
		return invalidOption;
	}

	public static String currentStatus(Integer playerPoints, Integer botPoints) {
		if (playerPoints.equals(botPoints)) {
			return "the game is tied. Who knows, your next move might tip the balance and turn the tide in your favor..";
		} else if (playerPoints > botPoints) {
			return "luck is in your favor, keep going and increase your score..";
		} else {
			return "the score is not friendly, but remember, every setback is an opportunity for a comeback. Do not give up!";
		}
	}

	public static String finalStatus(Integer playerPoints, Integer botPoints) {
		if (playerPoints.equals(botPoints)) {
			return "\nEnd of game tied! Victory may have slipped away, but next time could be your chance to shine!";
		} else if (playerPoints > botPoints) {
			return "\nCongratulations champion! Your victory is just the beginning of a legendary journey.\r\n"
					+ "We hope to see you again soon!";
		} else {
			return "\nDon't worry, everyone faces defeat from time to time. This is how we grow and become better.\r\n"
					+ "Come back whenever you want!";
		}
	}

}
