import java.util.HashMap;
import java.util.Scanner;

import java.util.InputMismatchException;

public class Tic_Tac_Toe {
	private static String result;
	private static Boolean play_again = true;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InputMismatchException {
	try{
		while(play_again)
		{
			System.out.println();
			System.out.println("----------- START ------------");
		    System.out.println();
			// Initializing variables
			Tic_Tac_Toe t = new Tic_Tac_Toe();
			String response;
			int place;
			String symbol;
			int iterate = 0;
			int attempt = 1;
			String p1 = "player 1";
			String p2 = "player 2";
			HashMap<String, String> map = new HashMap<String, String>();

			// Initializing board with ' - ' mark
			String[] st = new String[9];
			for (int i = 0; i < 9; i++) {
				st[i] = "-";
			}

			System.out.println("Choose a symbol between X or O : ");
			symbol = sc.next();

			switch (symbol) {
			case "X":
				System.out.println(p1 + " choose " + symbol + " symbol");
				map.put(p1, symbol);
				map.put(p2, "O");
				break;

			case "O":
				System.out.println(p1 + " choose " + symbol + " symbol");
				map.put(p1, symbol);
				map.put(p2, "X");
				break;
			case "x":
				System.out.println(p1 + " choose " + symbol + " symbol");
				map.put(p1, symbol.toUpperCase());
				map.put(p2, "O");
				break;

			case "o":
				System.out.println(p1 + " choose " + symbol + " symbol");
				map.put(p1, symbol.toUpperCase());
				map.put(p2, "X");
				break;
			default:
				System.out.println("Enter Again!");
				break;
			}

			t.initialize(st);

			// 9 grid hence we have to iterate till 9. This are the chances we get to play 
			while (iterate < 9) {
				iterate = iterate + 1;
				++attempt;
				System.out.println("Iteration : " + iterate);
				System.out.println();

				// For player 1 playing
				if (iterate % 2 == 1) {
					System.out.println(p1 + " Play : ");
					System.out.println("Enter " + map.get(p1));
					response = map.get(p1);
					System.out.println("Enter the place of response : ");
					place = sc.nextInt();
					st = t.printgrid(st, response, place);

					result = t.check(st, attempt);
					if (result.equals("X")) {
						System.out.println("X" + " Wins!");
						break;
					} else if (result.equals("O")) {
						System.out.println("O" + " Wins!");
						break;
					}
					else if(result.equals("D"))
					{
						System.out.println("The Match is a Draw!");
					}
				}
				// For player 2 playing
				else {
					System.out.println(p2 + " Play : ");
					System.out.println("Enter " + map.get(p2));
					response = map.get(p2);
					System.out.println("Enter the place of response : ");
					place = sc.nextInt();
					st = t.printgrid(st, response, place);

					result = t.check(st, attempt);
					if (result.equals("X")) {
						System.out.println("X" + " Wins!");
						break;
					} else if (result.equals("O")) {
						System.out.println("O" + " Wins!");
						break;
					}
					else if(result.equals("D"))
					{
						System.out.println("The Match is a Draw!");
					}
				}
			}
		System.out.println("Do you wanna play again (true/false)?");
		play_again = sc.nextBoolean();
	  }  
		System.out.println("Thank You For Playing !!");
	}    
	catch(Exception e)
	{
		System.out.println("An Exception Occured "+e);
	}
	finally 
	{
		sc.close();
	}
} // main ended

	// For initializing the game
	public void initialize(String st[]) {
		System.out.println(" ------------------------- ");
		for (int i = 0; i < 9; i++) {
			System.out.print(" | " + " " + st[i] + " " + " | ");
			if ((i + 1) % 3 == 0) {
				System.out.println();
				System.out.println(" ------------------------- ");
			}
		}
		return;
	}

	// Printing the board
	public String[] printgrid(String st[], String response, int place) {
		place = place - 1;
		System.out.println(" -------------------------");
		for (int i = 0; i < 9; i++) {
			if (i == place) {
				st[place] = response;
			}
			System.out.print(" | " + " " + st[i] + " " + " | ");
			if ((i + 1) % 3 == 0) {
				System.out.println();
				System.out.println(" ------------------------- ");
			}
		}
		return st;
	}

	// Logic part to check each case
	public String check(String st[], int attempt) {
		if (st[0].concat(st[1]).concat(st[2]).equalsIgnoreCase("xxx")
				|| st[3].concat(st[4]).concat(st[5]).equalsIgnoreCase("xxx")
				|| st[6].concat(st[7]).concat(st[8]).equalsIgnoreCase("xxx")) {
			return "X";
		} else if (st[0].concat(st[1]).concat(st[2]).equalsIgnoreCase("ooo")
				|| st[3].concat(st[4]).concat(st[5]).equalsIgnoreCase("ooo")
				|| st[6].concat(st[7]).concat(st[8]).equalsIgnoreCase("ooo")) {
			return "O";
		} else if (st[0].concat(st[3]).concat(st[6]).equalsIgnoreCase("xxx")
				|| st[1].concat(st[4]).concat(st[7]).equalsIgnoreCase("xxx")
				|| st[6].concat(st[7]).concat(st[8]).equalsIgnoreCase("xxx")) {
			return "X";
		} else if (st[0].concat(st[3]).concat(st[6]).equalsIgnoreCase("ooo")
				|| st[1].concat(st[4]).concat(st[7]).equalsIgnoreCase("ooo")
				|| st[6].concat(st[7]).concat(st[8]).equalsIgnoreCase("ooo")) {
			return "O";
		} else if (st[0].concat(st[4]).concat(st[8]).equalsIgnoreCase("xxx")
				|| st[2].concat(st[4]).concat(st[6]).equalsIgnoreCase("xxx")) {
			return "X";
		} else if (st[0].concat(st[4]).concat(st[8]).equalsIgnoreCase("ooo")
				|| st[2].concat(st[4]).concat(st[6]).equalsIgnoreCase("ooo")) {
			return "O";
		} else if (attempt > 9) {
			return "D";
		}
		return "";
	}
}