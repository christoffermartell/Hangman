package pack;

import java.util.Scanner;

public class Hangman {

	static String star; // Olika statiska variabler som används genom hela koden
	static int guesses = 0;
	static String secretWord;
	static String Guessletter;
	static int GameStatus;
	static int GuessWord;
	static String WrongWord;

	static Scanner scanner = new Scanner(System.in); // scanner för input

	static void menuChoiceOne() { // metod till menyn för att berätta hur många chansser det är kvar.
		System.out.println("Guess:" + guesses + " of 7");
	}

	static void menuChoiceTwo() { // metod för att gissa ordet, med else if om man gissar fel
		System.out.println("you only get one guess.\n Guess the Word please");
		String input = scanner.nextLine();

		if (input == secretWord) {
			System.out.println("Congratulation! you guesses the correct word.");
			System.exit(0);

		} else if (input == WrongWord) {
			System.out.println(" Sorry you lost.");
			System.exit(0);
		}

	}

	static void menuChoiceThree() { // metod för att gissa bokstäver och sätter stjärnor så man ej ser ordet.

		Scanner scan = new Scanner(System.in);
		secretWord = HangmanPrivate.getWord();
		star = new String(new char[secretWord.length()]).replace("\0", "*");

		while (guesses < 7 && star.contains("*")) { // while loop så man kan gissa bokstäver flera gånger..
			System.out.println(" Guess a letter please.");
			System.out.println(star);
			String guess = scan.next();
			hang(guess);

		}
		scan.close();

	}

	public static void main(String[] args) { // menyn med switch cases.
		Scanner scan = new Scanner(System.in);

		int choice;

		do {

			System.out.println("menu");
			System.out.println("1. GameStatus");
			System.out.println("2. Guessword");
			System.out.println("3. Guess letter");
			System.out.println(" Enter Choice 1-3 : ");

			choice = scan.nextInt();

			switch (choice) {
			case 1:
				menuChoiceOne();
				break;
			case 2:
				menuChoiceTwo();
				break;

			case 3:
				menuChoiceThree();
				break;
			}
		} while (!(guesses < 7));

	}

	public static void hang(String guess) { // metod som gör att bokstaven visas om man gissar rätt
		String newStar = "";
		for (int i = 0; i < secretWord.length(); i++) { // och skickar vidare om mskriver fel så att metoden med bilden
														// visas.
			if (secretWord.charAt(i) == guess.charAt(0)) {
				newStar += guess.charAt(0);

			} else if (star.charAt(i) != '*') {
				newStar += secretWord.charAt(i);

			} else {
				newStar += "*";
			}
		}

		if (star.equals(newStar)) {
			guesses++;

			hangmanImage();

		} else {
			star = newStar;

		}
		if (star.equals(secretWord)) {
			System.out.println(" Congratulations! youve guessed the right Word :" + secretWord);
		}

	}

	public static void hangmanImage() { // printline med själva "gubben"
		if (guesses == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (guesses == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (guesses == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (guesses == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (guesses == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (guesses == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (guesses == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("GAME OVER! The word was " + secretWord);
		}

	}

}
