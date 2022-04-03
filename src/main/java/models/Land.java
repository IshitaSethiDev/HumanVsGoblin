package models;
import java.util.Scanner;

public class Land {
	public static Position humanCurrentPosition = new Position();
	public static Position goblinCurrentPosition = new Position();
	public static Human humanObj = new Human(2, 2, 100);
	public static Goblin goblinObj = new Goblin(4, 4, 100);
	public static Integer totalRows = 10;
	public static Integer totalColumns = 10;
	public static final String COLOR_RED = "\u001B[31m";
	public static final String COLOR_BLUE = "\u001B[34m";
	public static final String NO_COLOR = "\u001B[0m";
	public static final String COLOR_GREEN = "\033[0;32m";
	public static boolean isReadyToAttack;

	public static void startGame() {
		char nextMove;
		boolean startTheGame = true;
		Scanner input = new Scanner(System.in);
		char land[][] = new char[totalRows][totalColumns];
		char human = 'H';
		String health = "0";
		//Human default position at land[2][2]
		land[humanObj.getRowPosition()][humanObj.getColumnPosition()] = human;
		//Goblin default position at land[4][4]
		land[goblinObj.getRowPosition()][goblinObj.getColumnPosition()] = 'G';

		//Set Human and goblin currentPosition in Position class
		humanCurrentPosition.setColumnPostion(2);
		humanCurrentPosition.setRowPosition(2);
		goblinCurrentPosition.setColumnPostion(4);
		goblinCurrentPosition.setRowPosition(4);
		print(land);
		printStrength(health);
		
		while (startTheGame) {
			System.out.println();
			nextMove = input.next().charAt(0);
			System.out.println("You have entered ::" + nextMove);
			int move;
			
			switch (nextMove) {
			case 'n':
			case 'N':
				if (humanObj.getRowPosition() == 1) {
					System.out.println("Enter  n/s/e/w to Change the direction");
					break;
				}
				//If Goblin is at land[1][1] then human can't move north.
				if (goblinObj.getColumnPosition() == 1 && goblinObj.getRowPosition() == 1) {
					print(land);
					printStrength(health);
				} else {
					move = humanObj.getRowPosition();
					humanObj.setRowPosition(--move);
					humanCurrentPosition.setColumnPostion(humanObj.getColumnPosition());
					humanCurrentPosition.setRowPosition(humanObj.getRowPosition());
					changePosition();
					print(land);
					printStrength(health);
				}
				break;
				
			case 'e':
			case 'E':
				//If human is at the 8th column
				if (humanObj.getColumnPosition() == totalColumns - 2) {
					System.out.println("Enter  n/s/e/w to Change the direction");
					break;
				}
				move = humanObj.getColumnPosition();
				humanObj.setColumnPosition(++move);

				humanCurrentPosition.setColumnPostion(humanObj.getColumnPosition());
				humanCurrentPosition.setRowPosition(humanObj.getRowPosition());
				changePosition();
				print(land);
				printStrength(health);
				break;
				
			case 's':
			case 'S':
				//If human is at the 8th row
				if (humanObj.getRowPosition() == totalRows - 2) {
					System.out.println("Enter  n/s/e/w to Change the direction");
					break;
				}
				move = humanObj.getRowPosition();
				humanObj.setRowPosition(++move);
				humanCurrentPosition.setColumnPostion(humanObj.getColumnPosition());
				humanCurrentPosition.setRowPosition(humanObj.getRowPosition());
				changePosition();
				print(land);
				printStrength(health);
				break;
				
			case 'w':
			case 'W':
				if (humanObj.getColumnPosition() == 1) {
					System.out.println("Enter  n/s/e/w to Change the direction");
					break;
				}
				move = humanObj.getColumnPosition();
				if (goblinObj.getColumnPosition() == 1 && goblinObj.getRowPosition() == 1 && (move - 1 == 1)
						&& humanObj.getColumnPosition() == 1) {
					print(land);
					printStrength(health);
				} else {
					humanObj.setColumnPosition(--move);
					humanCurrentPosition.setColumnPostion(humanObj.getColumnPosition());
					humanCurrentPosition.setRowPosition(humanObj.getRowPosition());
					changePosition();
					print(land);
					printStrength(health);
				}
				break;
				
			case 'a':
			case 'A':
					//When user presses 'a' combat is initiated
				goblinObj.setStrength(goblinObj.getStrength() -15);
				System.out.println("Goblin attacked you ");
				humanObj.setHealth(humanObj.getHealth() - 10);
				print(land);
				printStrength(health);
				break;
				
			default:
				System.out.println("Please enter : n/s/e/w");
				break;
			}

			if (humanObj.getHealth() <= 0) {
				startTheGame = false;
				System.out.println(COLOR_RED + "GAME OVER" + NO_COLOR);
				System.out.println(COLOR_RED + "YOU LOST" + NO_COLOR);
			}

			if (goblinObj.getStrength() <= 0) {
				startTheGame = false;
				System.out.println(COLOR_GREEN + "YOU WON THE GAME" + NO_COLOR);
			}

			//If user wishes the play the game again
			if(startTheGame == false){
				System.out.println("Do you wish to play Again?");
				Scanner keyboard = new Scanner(System.in);
				char playAgain = keyboard.next().charAt(0);

				if(playAgain == 'Y' || playAgain == 'y'){
					startTheGame = true;
				    humanObj = new Human(2, 2, 100);
				    goblinObj = new Goblin(4, 4, 100);
					System.out.println("Enter  n/s/e/w to Change the direction");
					human = 'H';
					land[humanObj.getRowPosition()][humanObj.getColumnPosition()] = human;
					land[goblinObj.getRowPosition()][goblinObj.getColumnPosition()] = 'G';
					humanCurrentPosition.setColumnPostion(2);
					humanCurrentPosition.setRowPosition(2);
					goblinCurrentPosition.setColumnPostion(4);
					goblinCurrentPosition.setRowPosition(4);
					print(land);
					printStrength(health);
				}
			}
		}
	}

	/**
	 * This function prints the grid and human and goblin(H and G) based on the current positions.
	 * @param grid
	 */
	private static void print(char[][] grid) {
		for (Integer i = 0; i < grid.length; i++) {
			for (Integer x = 0; x < grid[i].length; x++) {
				if (i == 0 || x == 0 || x == totalRows - 1 || i == totalRows - 1) {
					System.out.print("# ");
				} else if (humanCurrentPosition.getColumnPostion() == x && humanCurrentPosition.getRowPosition() == i) {
					System.out.print(COLOR_BLUE + "H " + NO_COLOR);
				} else if (goblinCurrentPosition.getColumnPostion() == x
						&& goblinCurrentPosition.getRowPosition() == i) {
					System.out.print(COLOR_RED + "G " + NO_COLOR);
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * This Function changes the current positions of the human and the goblin...
	 * @return
	 */
	public static boolean changePosition() {
		int oldGoblinRow = goblinCurrentPosition.getRowPosition();
		int oldGoblinColumn = goblinCurrentPosition.getColumnPostion();

		if (humanCurrentPosition.getColumnPostion() == goblinCurrentPosition.getColumnPostion()
				&& humanCurrentPosition.getRowPosition() == goblinCurrentPosition.getRowPosition()) {
			humanObj.setHealth(humanObj.getHealth() - 10);

		} else if (humanCurrentPosition.getColumnPostion() > goblinCurrentPosition.getColumnPostion()) {
			if (humanCurrentPosition.getColumnPostion() != goblinCurrentPosition.getColumnPostion() + 1) {
				goblinCurrentPosition.setColumnPostion(goblinCurrentPosition.getColumnPostion() + 1);
			}
		} else {
			goblinCurrentPosition.setColumnPostion(goblinCurrentPosition.getColumnPostion() - 1);
		}
		if (humanCurrentPosition.getColumnPostion() == goblinCurrentPosition.getColumnPostion()
				&& humanCurrentPosition.getRowPosition() == goblinCurrentPosition.getRowPosition()) {
			humanObj.setHealth(humanObj.getHealth() - 2);

		} else if (humanCurrentPosition.getRowPosition() > goblinCurrentPosition.getRowPosition()) {
			goblinCurrentPosition.setRowPosition(goblinCurrentPosition.getRowPosition() + 1);
		} else {
			goblinCurrentPosition.setRowPosition(goblinCurrentPosition.getRowPosition() - 1);
		}

		if (goblinCurrentPosition.getColumnPostion() <= 1) {
			goblinCurrentPosition.setColumnPostion(1);
		}
		if (goblinCurrentPosition.getRowPosition() <= 1) {
			goblinCurrentPosition.setRowPosition(1);
		}

		if (goblinCurrentPosition.getRowPosition() > totalRows - 2) {
			goblinCurrentPosition.setRowPosition(totalRows - 2);
		}
		if (humanCurrentPosition.getColumnPostion() == goblinCurrentPosition.getColumnPostion()
				|| humanCurrentPosition.getRowPosition() == goblinCurrentPosition.getRowPosition()) {

			if (humanCurrentPosition.getColumnPostion() == goblinCurrentPosition.getColumnPostion()
					&& humanCurrentPosition.getRowPosition() == goblinCurrentPosition.getRowPosition()) {
				if (goblinCurrentPosition.getColumnPostion() == oldGoblinColumn
						&& goblinCurrentPosition.getRowPosition() == oldGoblinRow) {

					if (!(oldGoblinColumn - 1 <= 0)) {
						goblinCurrentPosition.setColumnPostion(oldGoblinColumn - 1);
					}
					if (!(oldGoblinRow - 1 <= 0)) {
						goblinCurrentPosition.setRowPosition(oldGoblinRow - 1);
					}
				} else {

					System.out.println("Please enter : a to attack");
					goblinCurrentPosition.setColumnPostion(oldGoblinColumn);
					goblinCurrentPosition.setRowPosition(oldGoblinRow);
				}
			}
			isReadyToAttack = true;
		} else {
			isReadyToAttack = false;
		}
		return isReadyToAttack;
	}

	/**
	 * This Function prints the Human Health and Goblin Strength
	 * @param health
	 * @return
	 */
	public static String printStrength(String health) {
		if (humanObj.getHealth() < 0) {
			humanObj.setHealth(0);
		}
		if(goblinObj.getStrength()< 0){
			goblinObj.setStrength(0);
		}
		if (humanObj.getHealth() <= 50) {
			health = COLOR_RED + humanObj.getHealth() + NO_COLOR;
		} else {
			health = COLOR_GREEN + humanObj.getHealth() + NO_COLOR;
		}

		System.out.println();
		System.out.println("The human health is   :::: " + health + "/100");
		System.out.println("The Goblin strength is:::: " + goblinObj.getStrength() + "/100");
		System.out.println();
		if (isReadyToAttack) {
			System.out.println("Please enter : a to attack or enter n/s/e/w to move");

		} else {
			System.out.println("Please enter : n/s/e/w to move");
		}
		System.out.println();
		return health;
	}
}
